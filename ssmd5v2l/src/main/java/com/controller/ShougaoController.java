package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.entity.GaigaotongzhiEntity;
import com.entity.GaojianluyongEntity;
import com.service.GaigaotongzhiService;
import com.service.GaojianluyongService;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShougaoEntity;
import com.entity.view.ShougaoView;

import com.service.ShougaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 收稿
 * 后端接口
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
@RestController
@RequestMapping("/shougao")
public class ShougaoController {
	private static final Logger log = LoggerFactory.getLogger(ShougaoController.class);
	@Autowired
    private ShougaoService shougaoService;
	@Autowired
	private GaojianluyongService gaojianluyongService;
	@Autowired
	private GaigaotongzhiService gaigaotongzhiService;
	/**
	 * 改稿通知接口
	 */
	@RequestMapping("/gaigaotongzhi/{id}")
	@Transactional
	public R tongzhi(@PathVariable("id") Long id, @RequestBody Map<String, Object> params, HttpServletRequest request) {
		String gaigaoneirong = (String) params.get("gaigaoneirong");
		// 获取收稿信息
		ShougaoEntity shougao = shougaoService.selectById(id);
		if (shougao == null) {
			return R.error("稿件不存在");
		}
		// 创建新的改稿通知记录
		GaigaotongzhiEntity gaigaotongzhi = new GaigaotongzhiEntity();
		gaigaotongzhi.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
		gaigaotongzhi.setGaojianbianhao(shougao.getGaojianbianhao());
		gaigaotongzhi.setGaojianbiaoti(shougao.getGaojianbiaoti());
		gaigaotongzhi.setGaojianleixing(shougao.getGaojianleixing());
		gaigaotongzhi.setZuozhezhanghao(shougao.getZuozhezhanghao());
		gaigaotongzhi.setZuozhexingming(shougao.getZuozhexingming());
		gaigaotongzhi.setZuozheshouji(shougao.getZuozheshouji());
		gaigaotongzhi.setGaigaoneirong(gaigaoneirong);
		gaigaotongzhi.setHuifuzhuangtai(shougao.getGaojian());
		gaigaotongzhi.setTongzhishijian(new Date());
		gaigaotongzhi.setAddtime(new Date());
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shengaoren")) {
			gaigaotongzhi.setShengaozhanghao((String)request.getSession().getAttribute("username"));
		}
		// 插入改稿通知记录
		gaigaotongzhiService.insert(gaigaotongzhi);
		shougaoService.deleteById(id);
		return R.ok();
	}


	@RequestMapping("/luyong/{id}")
	@Transactional
	public R luyong(@PathVariable("id") Long id, HttpServletRequest request) {
		// 获取收稿信息
		ShougaoEntity shougao = shougaoService.selectById(id);
		if (shougao == null) {
			return R.error("稿件不存在");
		}

		// 创建新的稿件录用记录
		GaojianluyongEntity gaojianluyong = new GaojianluyongEntity();
		gaojianluyong.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
		gaojianluyong.setGaojianbianhao(shougao.getGaojianbianhao());
		gaojianluyong.setGaojianbiaoti(shougao.getGaojianbiaoti());
		gaojianluyong.setGaojianleixing(shougao.getGaojianleixing());
		gaojianluyong.setZuozhezhanghao(shougao.getZuozhezhanghao());
		gaojianluyong.setZuozhexingming(shougao.getZuozhexingming());
		gaojianluyong.setZuozheshouji(shougao.getZuozheshouji());
		gaojianluyong.setBianjizhanghao(shougao.getBianjizhanghao());
		gaojianluyong.setShengaozhanghao(shougao.getShengaozhanghao());
		gaojianluyong.setLuyongshijian(new Date());
		gaojianluyong.setLuyonggaojian(shougao.getGaojian());
		gaojianluyong.setBanmianfei("");
		gaojianluyong.setKanzaizhuangtai("未刊载");
		gaojianluyong.setIspay("未支付");
		gaojianluyong.setAddtime(new Date());

		// 插入稿件录用记录
		gaojianluyongService.insert(gaojianluyong);
		shougaoService.deleteById(id);
		return R.ok();
	}
	/**
	 * 审核接口
	 */
	@RequestMapping("/shenhe/{id}")
	@Transactional
	public R shenhe(@PathVariable("id") Long id, @RequestBody Map<String, Object> params, HttpServletRequest request) {
		String shhf = (String) params.get("shhf");
		// 获取收稿信息
		ShougaoEntity shougao = shougaoService.selectById(id);
		if (shougao == null) {
			return R.error("收稿不存在");
		}
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shengaoren")) {
			shougao.setShengaozhanghao((String)request.getSession().getAttribute("username"));
		}
		// 更新审核状态和审核回复
		shougao.setSfsh("已审核");
		shougao.setShhf(shhf);
		shougaoService.updateById(shougao);
		return R.ok();
	}
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShougaoEntity shougao, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuozhe")) {
			shougao.setZuozhezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("bianjibu")) {
			shougao.setBianjizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("shengaoren")) {
			shougao.setShengaozhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShougaoEntity> ew = new EntityWrapper<ShougaoEntity>();


		PageUtils page = shougaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shougao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShougaoEntity shougao, 
		HttpServletRequest request){
        EntityWrapper<ShougaoEntity> ew = new EntityWrapper<ShougaoEntity>();

		PageUtils page = shougaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shougao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShougaoEntity shougao){
       	EntityWrapper<ShougaoEntity> ew = new EntityWrapper<ShougaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shougao, "shougao")); 
        return R.ok().put("data", shougaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShougaoEntity shougao){
        EntityWrapper< ShougaoEntity> ew = new EntityWrapper< ShougaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shougao, "shougao")); 
		ShougaoView shougaoView =  shougaoService.selectView(ew);
		return R.ok("查询收稿成功").put("data", shougaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShougaoEntity shougao = shougaoService.selectById(id);
        return R.ok().put("data", shougao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShougaoEntity shougao = shougaoService.selectById(id);
        return R.ok().put("data", shougao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShougaoEntity shougao, HttpServletRequest request){
    	shougao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shougao);

        shougaoService.insert(shougao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShougaoEntity shougao, HttpServletRequest request){
    	shougao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shougao);

        shougaoService.insert(shougao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShougaoEntity shougao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shougao);
        shougaoService.updateById(shougao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shougaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);

		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}

		Wrapper<ShougaoEntity> wrapper = new EntityWrapper<ShougaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuozhe")) {
			wrapper.eq("zuozhezhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("bianjibu")) {
			wrapper.eq("bianjizhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("shengaoren")) {
			wrapper.eq("shengaozhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = shougaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
}
