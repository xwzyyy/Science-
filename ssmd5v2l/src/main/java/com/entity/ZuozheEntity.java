package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 作者
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
@TableName("zuozhe")
public class ZuozheEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZuozheEntity() {
		
	}
	
	public ZuozheEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 作者账号
	 */
					
	private String zuozhezhanghao;
	
	/**
	 * 密码
	 */
					
	private String mima;
	
	/**
	 * 作者姓名
	 */
					
	private String zuozhexingming;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 年龄
	 */
					
	private String nianling;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 作者手机
	 */
					
	private String zuozheshouji;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：作者账号
	 */
	public void setZuozhezhanghao(String zuozhezhanghao) {
		this.zuozhezhanghao = zuozhezhanghao;
	}
	/**
	 * 获取：作者账号
	 */
	public String getZuozhezhanghao() {
		return zuozhezhanghao;
	}
	/**
	 * 设置：密码
	 */
	public void setMima(String mima) {
		this.mima = mima;
	}
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
	/**
	 * 设置：作者姓名
	 */
	public void setZuozhexingming(String zuozhexingming) {
		this.zuozhexingming = zuozhexingming;
	}
	/**
	 * 获取：作者姓名
	 */
	public String getZuozhexingming() {
		return zuozhexingming;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * 设置：作者手机
	 */
	public void setZuozheshouji(String zuozheshouji) {
		this.zuozheshouji = zuozheshouji;
	}
	/**
	 * 获取：作者手机
	 */
	public String getZuozheshouji() {
		return zuozheshouji;
	}

}
