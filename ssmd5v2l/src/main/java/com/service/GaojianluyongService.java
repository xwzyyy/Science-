package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GaojianluyongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GaojianluyongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GaojianluyongView;


/**
 * 稿件录用
 *
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface GaojianluyongService extends IService<GaojianluyongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GaojianluyongVO> selectListVO(Wrapper<GaojianluyongEntity> wrapper);
   	
   	GaojianluyongVO selectVO(@Param("ew") Wrapper<GaojianluyongEntity> wrapper);
   	
   	List<GaojianluyongView> selectListView(Wrapper<GaojianluyongEntity> wrapper);
   	
   	GaojianluyongView selectView(@Param("ew") Wrapper<GaojianluyongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GaojianluyongEntity> wrapper);
   	

}

