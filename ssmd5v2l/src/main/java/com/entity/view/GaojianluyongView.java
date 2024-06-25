package com.entity.view;

import com.entity.GaojianluyongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 稿件录用
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
@TableName("gaojianluyong")
public class GaojianluyongView  extends GaojianluyongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GaojianluyongView(){
	}
 
 	public GaojianluyongView(GaojianluyongEntity gaojianluyongEntity){
 	try {
			BeanUtils.copyProperties(this, gaojianluyongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
