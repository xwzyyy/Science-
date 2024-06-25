package com.entity.vo;

import com.entity.GaigaohuifuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 改稿回复
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public class GaigaohuifuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 改稿时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date gaigaoshijian;
		
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
	 * 改稿文件
	 */
	
	private String gaigaowenjian;
		
	/**
	 * 回复内容
	 */
	
	private String huifuneirong;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
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
	 * 设置：改稿时间
	 */
	 
	public void setGaigaoshijian(Date gaigaoshijian) {
		this.gaigaoshijian = gaigaoshijian;
	}
	
	/**
	 * 获取：改稿时间
	 */
	public Date getGaigaoshijian() {
		return gaigaoshijian;
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
	 * 设置：改稿文件
	 */
	 
	public void setGaigaowenjian(String gaigaowenjian) {
		this.gaigaowenjian = gaigaowenjian;
	}
	
	/**
	 * 获取：改稿文件
	 */
	public String getGaigaowenjian() {
		return gaigaowenjian;
	}
				
	
	/**
	 * 设置：回复内容
	 */
	 
	public void setHuifuneirong(String huifuneirong) {
		this.huifuneirong = huifuneirong;
	}
	
	/**
	 * 获取：回复内容
	 */
	public String getHuifuneirong() {
		return huifuneirong;
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
