package com.entity.view;

import com.entity.GaojiankanzaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 稿件刊载
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
@TableName("gaojiankanzai")
public class GaojiankanzaiView  extends GaojiankanzaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GaojiankanzaiView(){
	}
 
 	public GaojiankanzaiView(GaojiankanzaiEntity gaojiankanzaiEntity){
 	try {
			BeanUtils.copyProperties(this, gaojiankanzaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
