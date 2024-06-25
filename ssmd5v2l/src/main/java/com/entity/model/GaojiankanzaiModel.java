package com.entity.model;

import com.entity.GaojiankanzaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 稿件刊载
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public class GaojiankanzaiModel  implements Serializable {
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
	 * 录用时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date luyongshijian;
		
	/**
	 * 酬金
	 */
	
	private Float choujin;
		
	/**
	 * 刊载时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date kanzaishijian;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
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
	 * 设置：录用时间
	 */
	 
	public void setLuyongshijian(Date luyongshijian) {
		this.luyongshijian = luyongshijian;
	}
	
	/**
	 * 获取：录用时间
	 */
	public Date getLuyongshijian() {
		return luyongshijian;
	}
				
	
	/**
	 * 设置：酬金
	 */
	 
	public void setChoujin(Float choujin) {
		this.choujin = choujin;
	}
	
	/**
	 * 获取：酬金
	 */
	public Float getChoujin() {
		return choujin;
	}
				
	
	/**
	 * 设置：刊载时间
	 */
	 
	public void setKanzaishijian(Date kanzaishijian) {
		this.kanzaishijian = kanzaishijian;
	}
	
	/**
	 * 获取：刊载时间
	 */
	public Date getKanzaishijian() {
		return kanzaishijian;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
