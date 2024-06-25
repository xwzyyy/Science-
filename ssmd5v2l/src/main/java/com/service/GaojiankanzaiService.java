package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GaojiankanzaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GaojiankanzaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GaojiankanzaiView;


/**
 * 稿件刊载
 *
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface GaojiankanzaiService extends IService<GaojiankanzaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GaojiankanzaiVO> selectListVO(Wrapper<GaojiankanzaiEntity> wrapper);
   	
   	GaojiankanzaiVO selectVO(@Param("ew") Wrapper<GaojiankanzaiEntity> wrapper);
   	
   	List<GaojiankanzaiView> selectListView(Wrapper<GaojiankanzaiEntity> wrapper);
   	
   	GaojiankanzaiView selectView(@Param("ew") Wrapper<GaojiankanzaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GaojiankanzaiEntity> wrapper);
   	

}

