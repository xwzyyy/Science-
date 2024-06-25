package com.entity.vo;

import com.entity.GaigaotongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 改稿通知
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public class GaigaotongzhiVO  implements Serializable {
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
	 * 改稿内容
	 */
	
	private String gaigaoneirong;
		
	/**
	 * 通知时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tongzhishijian;
		
	/**
	 * 回复状态
	 */
	
	private String huifuzhuangtai;
				
	
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
	 * 设置：改稿内容
	 */
	 
	public void setGaigaoneirong(String gaigaoneirong) {
		this.gaigaoneirong = gaigaoneirong;
	}
	
	/**
	 * 获取：改稿内容
	 */
	public String getGaigaoneirong() {
		return gaigaoneirong;
	}
				
	
	/**
	 * 设置：通知时间
	 */
	 
	public void setTongzhishijian(Date tongzhishijian) {
		this.tongzhishijian = tongzhishijian;
	}
	
	/**
	 * 获取：通知时间
	 */
	public Date getTongzhishijian() {
		return tongzhishijian;
	}
				
	
	/**
	 * 设置：回复状态
	 */
	 
	public void setHuifuzhuangtai(String huifuzhuangtai) {
		this.huifuzhuangtai = huifuzhuangtai;
	}
	
	/**
	 * 获取：回复状态
	 */
	public String getHuifuzhuangtai() {
		return huifuzhuangtai;
	}
			
}
