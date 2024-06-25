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

import com.entity.GaigaohuifuEntity;
import com.entity.view.GaigaohuifuView;

import com.service.GaigaohuifuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 改稿回复
 * 后端接口
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
@RestController
@RequestMapping("/gaigaohuifu")
public class GaigaohuifuController {
    @Autowired
    private GaigaohuifuService gaigaohuifuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GaigaohuifuEntity gaigaohuifu, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuozhe")) {
			gaigaohuifu.setZuozhezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("bianjibu")) {
			gaigaohuifu.setBianjizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("shengaoren")) {
			gaigaohuifu.setShengaozhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GaigaohuifuEntity> ew = new EntityWrapper<GaigaohuifuEntity>();


		PageUtils page = gaigaohuifuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gaigaohuifu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GaigaohuifuEntity gaigaohuifu, 
		HttpServletRequest request){
        EntityWrapper<GaigaohuifuEntity> ew = new EntityWrapper<GaigaohuifuEntity>();

		PageUtils page = gaigaohuifuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gaigaohuifu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GaigaohuifuEntity gaigaohuifu){
       	EntityWrapper<GaigaohuifuEntity> ew = new EntityWrapper<GaigaohuifuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gaigaohuifu, "gaigaohuifu")); 
        return R.ok().put("data", gaigaohuifuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GaigaohuifuEntity gaigaohuifu){
        EntityWrapper< GaigaohuifuEntity> ew = new EntityWrapper< GaigaohuifuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gaigaohuifu, "gaigaohuifu")); 
		GaigaohuifuView gaigaohuifuView =  gaigaohuifuService.selectView(ew);
		return R.ok("查询改稿回复成功").put("data", gaigaohuifuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GaigaohuifuEntity gaigaohuifu = gaigaohuifuService.selectById(id);
        return R.ok().put("data", gaigaohuifu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GaigaohuifuEntity gaigaohuifu = gaigaohuifuService.selectById(id);
        return R.ok().put("data", gaigaohuifu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GaigaohuifuEntity gaigaohuifu, HttpServletRequest request){
    	gaigaohuifu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gaigaohuifu);

        gaigaohuifuService.insert(gaigaohuifu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GaigaohuifuEntity gaigaohuifu, HttpServletRequest request){
    	gaigaohuifu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gaigaohuifu);

        gaigaohuifuService.insert(gaigaohuifu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GaigaohuifuEntity gaigaohuifu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gaigaohuifu);
        gaigaohuifuService.updateById(gaigaohuifu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gaigaohuifuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GaigaohuifuEntity> wrapper = new EntityWrapper<GaigaohuifuEntity>();
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

		int count = gaigaohuifuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
