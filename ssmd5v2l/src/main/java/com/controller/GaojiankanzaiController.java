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

import com.entity.GaojiankanzaiEntity;
import com.entity.view.GaojiankanzaiView;

import com.service.GaojiankanzaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 稿件刊载
 * 后端接口
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
@RestController
@RequestMapping("/gaojiankanzai")
public class GaojiankanzaiController {
    @Autowired
    private GaojiankanzaiService gaojiankanzaiService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GaojiankanzaiEntity gaojiankanzai, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuozhe")) {
			gaojiankanzai.setZuozhezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("bianjibu")) {
			gaojiankanzai.setBianjizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("shengaoren")) {
			gaojiankanzai.setShengaozhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GaojiankanzaiEntity> ew = new EntityWrapper<GaojiankanzaiEntity>();


		PageUtils page = gaojiankanzaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gaojiankanzai), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GaojiankanzaiEntity gaojiankanzai, 
		HttpServletRequest request){
        EntityWrapper<GaojiankanzaiEntity> ew = new EntityWrapper<GaojiankanzaiEntity>();

		PageUtils page = gaojiankanzaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gaojiankanzai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GaojiankanzaiEntity gaojiankanzai){
       	EntityWrapper<GaojiankanzaiEntity> ew = new EntityWrapper<GaojiankanzaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gaojiankanzai, "gaojiankanzai")); 
        return R.ok().put("data", gaojiankanzaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GaojiankanzaiEntity gaojiankanzai){
        EntityWrapper< GaojiankanzaiEntity> ew = new EntityWrapper< GaojiankanzaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gaojiankanzai, "gaojiankanzai")); 
		GaojiankanzaiView gaojiankanzaiView =  gaojiankanzaiService.selectView(ew);
		return R.ok("查询稿件刊载成功").put("data", gaojiankanzaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GaojiankanzaiEntity gaojiankanzai = gaojiankanzaiService.selectById(id);
        return R.ok().put("data", gaojiankanzai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GaojiankanzaiEntity gaojiankanzai = gaojiankanzaiService.selectById(id);
        return R.ok().put("data", gaojiankanzai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GaojiankanzaiEntity gaojiankanzai, HttpServletRequest request){
    	gaojiankanzai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gaojiankanzai);

        gaojiankanzaiService.insert(gaojiankanzai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GaojiankanzaiEntity gaojiankanzai, HttpServletRequest request){
    	gaojiankanzai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gaojiankanzai);

        gaojiankanzaiService.insert(gaojiankanzai);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GaojiankanzaiEntity gaojiankanzai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gaojiankanzai);
        gaojiankanzaiService.updateById(gaojiankanzai);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gaojiankanzaiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GaojiankanzaiEntity> wrapper = new EntityWrapper<GaojiankanzaiEntity>();
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

		int count = gaojiankanzaiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
