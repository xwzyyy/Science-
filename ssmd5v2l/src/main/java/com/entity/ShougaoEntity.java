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
 * 收稿
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
@TableName("shougao")
public class ShougaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShougaoEntity() {
		
	}
	
	public ShougaoEntity(T t) {
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
	 * 稿件编号
	 */
					
	private String gaojianbianhao;
	
	/**
	 * 稿件标题
	 */
					
	private String gaojianbiaoti;
	
	/**
	 * 稿件类型
	 */
					
	private String gaojianleixing;
	
	/**
	 * 作者账号
	 */
					
	private String zuozhezhanghao;
	
	/**
	 * 作者姓名
	 */
					
	private String zuozhexingming;
	
	/**
	 * 作者手机
	 */
					
	private String zuozheshouji;
	
	/**
	 * 上传时间
	 */
					
	private String shangchuanshijian;
	
	/**
	 * 稿件
	 */
					
	private String gaojian;
	
	/**
	 * 编辑账号
	 */
					
	private String bianjizhanghao;
	
	/**
	 * 编辑姓名
	 */
					
	private String bianjixingming;
	
	/**
	 * 审稿账号
	 */
					
	private String shengaozhanghao;
	
	/**
	 * 审稿姓名
	 */
					
	private String shengaoxingming;
	
	/**
	 * 收稿时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shougaoshijian;
	
	/**
	 * 录用状态
	 */
					
	private String luyongzhuangtai;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
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
	 * 设置：稿件编号
	 */
	public void setGaojianbianhao(String gaojianbianhao) {
		this.gaojianbianhao = gaojianbianhao;
	}
	/**
	 * 获取：稿件编号
	 */
	public String getGaojianbianhao() {
		return gaojianbianhao;
	}
	/**
	 * 设置：稿件标题
	 */
	public void setGaojianbiaoti(String gaojianbiaoti) {
		this.gaojianbiaoti = gaojianbiaoti;
	}
	/**
	 * 获取：稿件标题
	 */
	public String getGaojianbiaoti() {
		return gaojianbiaoti;
	}
	/**
	 * 设置：稿件类型
	 */
	public void setGaojianleixing(String gaojianleixing) {
		this.gaojianleixing = gaojianleixing;
	}
	/**
	 * 获取：稿件类型
	 */
	public String getGaojianleixing() {
		return gaojianleixing;
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
	/**
	 * 设置：上传时间
	 */
	public void setShangchuanshijian(String shangchuanshijian) {
		this.shangchuanshijian = shangchuanshijian;
	}
	/**
	 * 获取：上传时间
	 */
	public String getShangchuanshijian() {
		return shangchuanshijian;
	}
	/**
	 * 设置：稿件
	 */
	public void setGaojian(String gaojian) {
		this.gaojian = gaojian;
	}
	/**
	 * 获取：稿件
	 */
	public String getGaojian() {
		return gaojian;
	}
	/**
	 * 设置：编辑账号
	 */
	public void setBianjizhanghao(String bianjizhanghao) {
		this.bianjizhanghao = bianjizhanghao;
	}
	/**
	 * 获取：编辑账号
	 */
	public String getBianjizhanghao() {
		return bianjizhanghao;
	}
	/**
	 * 设置：编辑姓名
	 */
	public void setBianjixingming(String bianjixingming) {
		this.bianjixingming = bianjixingming;
	}
	/**
	 * 获取：编辑姓名
	 */
	public String getBianjixingming() {
		return bianjixingming;
	}
	/**
	 * 设置：审稿账号
	 */
	public void setShengaozhanghao(String shengaozhanghao) {
		this.shengaozhanghao = shengaozhanghao;
	}
	/**
	 * 获取：审稿账号
	 */
	public String getShengaozhanghao() {
		return shengaozhanghao;
	}
	/**
	 * 设置：审稿姓名
	 */
	public void setShengaoxingming(String shengaoxingming) {
		this.shengaoxingming = shengaoxingming;
	}
	/**
	 * 获取：审稿姓名
	 */
	public String getShengaoxingming() {
		return shengaoxingming;
	}
	/**
	 * 设置：收稿时间
	 */
	public void setShougaoshijian(Date shougaoshijian) {
		this.shougaoshijian = shougaoshijian;
	}
	/**
	 * 获取：收稿时间
	 */
	public Date getShougaoshijian() {
		return shougaoshijian;
	}
	/**
	 * 设置：录用状态
	 */
	public void setLuyongzhuangtai(String luyongzhuangtai) {
		this.luyongzhuangtai = luyongzhuangtai;
	}
	/**
	 * 获取：录用状态
	 */
	public String getLuyongzhuangtai() {
		return luyongzhuangtai;
	}
	/**
	 * 设置：跨表用户id
	 */
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
