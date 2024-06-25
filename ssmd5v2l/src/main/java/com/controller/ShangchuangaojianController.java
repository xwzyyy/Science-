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

import com.entity.ShougaoEntity;
import com.entity.view.ShougaoView;
import com.service.ShougaoService;
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

import com.entity.ShangchuangaojianEntity;
import com.entity.view.ShangchuangaojianView;

import com.service.ShangchuangaojianService;

import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 上传稿件
 * 后端接口
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
@RestController
@RequestMapping("/shangchuangaojian")
public class ShangchuangaojianController {
    @Autowired
    private ShangchuangaojianService shangchuangaojianService;
    @Autowired
    private ShougaoService shougaoService;
    /**
     * 收稿接口
     */
    @RequestMapping("/shougao/{id}")
    @Transactional
    public R shougao(@PathVariable("id") Long id, HttpServletRequest request) {
        // 获取上传稿件信息
        ShangchuangaojianEntity gaojian = shangchuangaojianService.selectById(id);
        if (gaojian == null) {
            return R.error("稿件不存在");
        }

        // 创建新的收稿记录
        ShougaoEntity shougao = new ShougaoEntity();
        System.out.println();
        shougao.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        shougao.setGaojianbianhao(gaojian.getGaojianbianhao());
        shougao.setGaojianbiaoti(gaojian.getGaojianbiaoti());
        shougao.setGaojianleixing(gaojian.getGaojianleixing());
        shougao.setShengaozhanghao("");
        shougao.setShengaoxingming("");
        shougao.setZuozhezhanghao(gaojian.getZuozhezhanghao());
        shougao.setZuozhexingming(gaojian.getZuozhexingming());
        shougao.setZuozheshouji(gaojian.getZuozheshouji());
        shougao.setGaojian(gaojian.getGaojian());
        try {
            shougao.setShangchuanshijian(gaojian.getShangchuanshijian().toString());
        }catch (Exception e){
            shougao.setShangchuanshijian("");
        }
        shougao.setAddtime(new Date());
        if (gaojian.getSfsh().isEmpty()){
            shougao.setSfsh("");
            shougao.setShhf("");
        }else {
            shougao.setSfsh(gaojian.getSfsh());
            shougao.setShhf(gaojian.getShhf());
        }

        String tableName = request.getSession().getAttribute("tableName").toString();
        shougao.setBianjizhanghao((String)request.getSession().getAttribute("username"));
        // 插入收稿记录
        shougaoService.insert(shougao);
        shangchuangaojianService.deleteById(id);
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
        ShangchuangaojianEntity gaojian = shangchuangaojianService.selectById(id);
        if (gaojian == null) {
            return R.error("收稿不存在");
        }

        // 更新审核状态和审核回复
        gaojian.setSfsh("已审核");
        gaojian.setShhf(shhf);
        shangchuangaojianService.updateById(gaojian);
        return R.ok();
    }

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangchuangaojianEntity shangchuangaojian, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuozhe")) {
			shangchuangaojian.setZuozhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShangchuangaojianEntity> ew = new EntityWrapper<ShangchuangaojianEntity>();


		PageUtils page = shangchuangaojianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangchuangaojian), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangchuangaojianEntity shangchuangaojian, 
		HttpServletRequest request){
        EntityWrapper<ShangchuangaojianEntity> ew = new EntityWrapper<ShangchuangaojianEntity>();

		PageUtils page = shangchuangaojianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangchuangaojian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangchuangaojianEntity shangchuangaojian){
       	EntityWrapper<ShangchuangaojianEntity> ew = new EntityWrapper<ShangchuangaojianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangchuangaojian, "shangchuangaojian")); 
        return R.ok().put("data", shangchuangaojianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangchuangaojianEntity shangchuangaojian){
        EntityWrapper< ShangchuangaojianEntity> ew = new EntityWrapper< ShangchuangaojianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangchuangaojian, "shangchuangaojian")); 
		ShangchuangaojianView shangchuangaojianView =  shangchuangaojianService.selectView(ew);
		return R.ok("查询上传稿件成功").put("data", shangchuangaojianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangchuangaojianEntity shangchuangaojian = shangchuangaojianService.selectById(id);
        return R.ok().put("data", shangchuangaojian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangchuangaojianEntity shangchuangaojian = shangchuangaojianService.selectById(id);
        return R.ok().put("data", shangchuangaojian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangchuangaojianEntity shangchuangaojian, HttpServletRequest request){
    	shangchuangaojian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangchuangaojian);

        shangchuangaojianService.insert(shangchuangaojian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangchuangaojianEntity shangchuangaojian, HttpServletRequest request){
    	shangchuangaojian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangchuangaojian);

        shangchuangaojianService.insert(shangchuangaojian);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShangchuangaojianEntity shangchuangaojian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangchuangaojian);
        shangchuangaojianService.updateById(shangchuangaojian);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shangchuangaojianService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ShangchuangaojianEntity> wrapper = new EntityWrapper<ShangchuangaojianEntity>();
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

		int count = shangchuangaojianService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
