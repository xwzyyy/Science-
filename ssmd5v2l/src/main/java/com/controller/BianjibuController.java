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

import com.entity.BianjibuEntity;
import com.entity.view.BianjibuView;

import com.service.BianjibuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 编辑部
 * 后端接口
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
@RestController
@RequestMapping("/bianjibu")
public class BianjibuController {
    @Autowired
    private BianjibuService bianjibuService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		BianjibuEntity user = bianjibuService.selectOne(new EntityWrapper<BianjibuEntity>().eq("bianjizhanghao", username));
		if(user==null || !user.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(user.getId(), username,"bianjibu",  "编辑部" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody BianjibuEntity bianjibu){
    	//ValidatorUtils.validateEntity(bianjibu);
    	BianjibuEntity user = bianjibuService.selectOne(new EntityWrapper<BianjibuEntity>().eq("bianjizhanghao", bianjibu.getBianjizhanghao()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		bianjibu.setId(uId);
        bianjibuService.insert(bianjibu);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        BianjibuEntity user = bianjibuService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	BianjibuEntity user = bianjibuService.selectOne(new EntityWrapper<BianjibuEntity>().eq("bianjizhanghao", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
    	user.setMima("123456");
        bianjibuService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BianjibuEntity bianjibu, 
		HttpServletRequest request){

        EntityWrapper<BianjibuEntity> ew = new EntityWrapper<BianjibuEntity>();


		PageUtils page = bianjibuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bianjibu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BianjibuEntity bianjibu, 
		HttpServletRequest request){
        EntityWrapper<BianjibuEntity> ew = new EntityWrapper<BianjibuEntity>();

		PageUtils page = bianjibuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bianjibu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BianjibuEntity bianjibu){
       	EntityWrapper<BianjibuEntity> ew = new EntityWrapper<BianjibuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bianjibu, "bianjibu")); 
        return R.ok().put("data", bianjibuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BianjibuEntity bianjibu){
        EntityWrapper< BianjibuEntity> ew = new EntityWrapper< BianjibuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bianjibu, "bianjibu")); 
		BianjibuView bianjibuView =  bianjibuService.selectView(ew);
		return R.ok("查询编辑部成功").put("data", bianjibuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BianjibuEntity bianjibu = bianjibuService.selectById(id);
        return R.ok().put("data", bianjibu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BianjibuEntity bianjibu = bianjibuService.selectById(id);
        return R.ok().put("data", bianjibu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BianjibuEntity bianjibu, HttpServletRequest request){
    	bianjibu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bianjibu);
    	BianjibuEntity user = bianjibuService.selectOne(new EntityWrapper<BianjibuEntity>().eq("bianjizhanghao", bianjibu.getBianjizhanghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		bianjibu.setId(new Date().getTime());
        bianjibuService.insert(bianjibu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BianjibuEntity bianjibu, HttpServletRequest request){
    	bianjibu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bianjibu);
    	BianjibuEntity user = bianjibuService.selectOne(new EntityWrapper<BianjibuEntity>().eq("bianjizhanghao", bianjibu.getBianjizhanghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		bianjibu.setId(new Date().getTime());
        bianjibuService.insert(bianjibu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BianjibuEntity bianjibu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bianjibu);
        bianjibuService.updateById(bianjibu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bianjibuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<BianjibuEntity> wrapper = new EntityWrapper<BianjibuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = bianjibuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
