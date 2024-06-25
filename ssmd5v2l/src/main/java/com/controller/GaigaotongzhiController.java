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

import com.entity.ShangchuangaojianEntity;
import com.entity.ShougaoEntity;
import com.service.impl.ShangchuangaojianServiceImpl;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
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

import com.entity.GaigaotongzhiEntity;
import com.entity.view.GaigaotongzhiView;

import com.service.GaigaotongzhiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 改稿通知
 * 后端接口
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
@RestController
@RequestMapping("/gaigaotongzhi")
public class GaigaotongzhiController {
    @Autowired
    private GaigaotongzhiService gaigaotongzhiService;
    @Autowired
    private ShangchuangaojianServiceImpl shangchuangaojianService;


	/**
	 * 改稿送审接口
	 */
	@RequestMapping("/gaigaosongshen/{id}")
	@Transactional
	public R tongzhi(@PathVariable("id") Long id, HttpServletRequest request) {

		GaigaotongzhiEntity tongzhi = gaigaotongzhiService.selectById(id);
		if (tongzhi == null) {
			return R.error("稿件不存在");
		}

		ShangchuangaojianEntity shangchuangaojian = new ShangchuangaojianEntity();
		shangchuangaojian.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
		shangchuangaojian.setGaojianbianhao(tongzhi.getGaojianbianhao());
		shangchuangaojian.setGaojianbiaoti(tongzhi.getGaojianbiaoti());
		shangchuangaojian.setGaojianleixing(tongzhi.getGaojianleixing());
		shangchuangaojian.setZuozhezhanghao(tongzhi.getZuozhezhanghao());
		shangchuangaojian.setZuozhexingming(tongzhi.getZuozhexingming());
		shangchuangaojian.setGaojian(tongzhi.getHuifuzhuangtai());
		shangchuangaojian.setZuozheshouji(tongzhi.getZuozheshouji());
		shangchuangaojian.setAddtime(new Date());

		shangchuangaojianService.insert(shangchuangaojian);
		gaigaotongzhiService.deleteById(id);
		return R.ok();
	}



	/**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GaigaotongzhiEntity gaigaotongzhi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuozhe")) {
			gaigaotongzhi.setZuozhezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("bianjibu")) {
			gaigaotongzhi.setBianjizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("shengaoren")) {
			gaigaotongzhi.setShengaozhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GaigaotongzhiEntity> ew = new EntityWrapper<GaigaotongzhiEntity>();


		PageUtils page = gaigaotongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gaigaotongzhi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GaigaotongzhiEntity gaigaotongzhi, 
		HttpServletRequest request){
        EntityWrapper<GaigaotongzhiEntity> ew = new EntityWrapper<GaigaotongzhiEntity>();

		PageUtils page = gaigaotongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gaigaotongzhi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GaigaotongzhiEntity gaigaotongzhi){
       	EntityWrapper<GaigaotongzhiEntity> ew = new EntityWrapper<GaigaotongzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gaigaotongzhi, "gaigaotongzhi")); 
        return R.ok().put("data", gaigaotongzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GaigaotongzhiEntity gaigaotongzhi){
        EntityWrapper< GaigaotongzhiEntity> ew = new EntityWrapper< GaigaotongzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gaigaotongzhi, "gaigaotongzhi")); 
		GaigaotongzhiView gaigaotongzhiView =  gaigaotongzhiService.selectView(ew);
		return R.ok("查询改稿通知成功").put("data", gaigaotongzhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GaigaotongzhiEntity gaigaotongzhi = gaigaotongzhiService.selectById(id);
        return R.ok().put("data", gaigaotongzhi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GaigaotongzhiEntity gaigaotongzhi = gaigaotongzhiService.selectById(id);
        return R.ok().put("data", gaigaotongzhi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GaigaotongzhiEntity gaigaotongzhi, HttpServletRequest request){
    	gaigaotongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gaigaotongzhi);

        gaigaotongzhiService.insert(gaigaotongzhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GaigaotongzhiEntity gaigaotongzhi, HttpServletRequest request){
    	gaigaotongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gaigaotongzhi);

        gaigaotongzhiService.insert(gaigaotongzhi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GaigaotongzhiEntity gaigaotongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gaigaotongzhi);
        gaigaotongzhiService.updateById(gaigaotongzhi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gaigaotongzhiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GaigaotongzhiEntity> wrapper = new EntityWrapper<GaigaotongzhiEntity>();
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

		int count = gaigaotongzhiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
