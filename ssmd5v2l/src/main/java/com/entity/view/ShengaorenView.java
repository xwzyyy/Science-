package com.entity.view;

import com.entity.ShengaorenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 审稿人
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
@TableName("shengaoren")
public class ShengaorenView  extends ShengaorenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShengaorenView(){
	}
 
 	public ShengaorenView(ShengaorenEntity shengaorenEntity){
 	try {
			BeanUtils.copyProperties(this, shengaorenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
