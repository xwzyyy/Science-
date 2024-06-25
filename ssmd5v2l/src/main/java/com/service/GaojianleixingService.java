package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GaojianleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GaojianleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GaojianleixingView;


/**
 * 稿件类型
 *
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface GaojianleixingService extends IService<GaojianleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GaojianleixingVO> selectListVO(Wrapper<GaojianleixingEntity> wrapper);
   	
   	GaojianleixingVO selectVO(@Param("ew") Wrapper<GaojianleixingEntity> wrapper);
   	
   	List<GaojianleixingView> selectListView(Wrapper<GaojianleixingEntity> wrapper);
   	
   	GaojianleixingView selectView(@Param("ew") Wrapper<GaojianleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GaojianleixingEntity> wrapper);
   	

}

