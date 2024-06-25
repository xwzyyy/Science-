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

import com.entity.GaojianluyongEntity;
import com.entity.view.GaojianluyongView;

import com.service.GaojianluyongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 稿件录用
 * 后端接口
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
@RestController
@RequestMapping("/gaojianluyong")
public class GaojianluyongController {
    @Autowired
    private GaojianluyongService gaojianluyongService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GaojianluyongEntity gaojianluyong, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuozhe")) {
			gaojianluyong.setZuozhezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("bianjibu")) {
			gaojianluyong.setBianjizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("shengaoren")) {
			gaojianluyong.setShengaozhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GaojianluyongEntity> ew = new EntityWrapper<GaojianluyongEntity>();


		PageUtils page = gaojianluyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gaojianluyong), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GaojianluyongEntity gaojianluyong, 
		HttpServletRequest request){
        EntityWrapper<GaojianluyongEntity> ew = new EntityWrapper<GaojianluyongEntity>();

		PageUtils page = gaojianluyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gaojianluyong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GaojianluyongEntity gaojianluyong){
       	EntityWrapper<GaojianluyongEntity> ew = new EntityWrapper<GaojianluyongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gaojianluyong, "gaojianluyong")); 
        return R.ok().put("data", gaojianluyongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GaojianluyongEntity gaojianluyong){
        EntityWrapper< GaojianluyongEntity> ew = new EntityWrapper< GaojianluyongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gaojianluyong, "gaojianluyong")); 
		GaojianluyongView gaojianluyongView =  gaojianluyongService.selectView(ew);
		return R.ok("查询稿件录用成功").put("data", gaojianluyongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GaojianluyongEntity gaojianluyong = gaojianluyongService.selectById(id);
        return R.ok().put("data", gaojianluyong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GaojianluyongEntity gaojianluyong = gaojianluyongService.selectById(id);
        return R.ok().put("data", gaojianluyong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GaojianluyongEntity gaojianluyong, HttpServletRequest request){
    	gaojianluyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gaojianluyong);

        gaojianluyongService.insert(gaojianluyong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GaojianluyongEntity gaojianluyong, HttpServletRequest request){
    	gaojianluyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gaojianluyong);

        gaojianluyongService.insert(gaojianluyong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GaojianluyongEntity gaojianluyong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gaojianluyong);
        gaojianluyongService.updateById(gaojianluyong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gaojianluyongService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GaojianluyongEntity> wrapper = new EntityWrapper<GaojianluyongEntity>();
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

		int count = gaojianluyongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
