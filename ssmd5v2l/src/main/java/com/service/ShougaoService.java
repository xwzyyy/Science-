package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShougaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShougaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShougaoView;


/**
 * 收稿
 *
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface ShougaoService extends IService<ShougaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShougaoVO> selectListVO(Wrapper<ShougaoEntity> wrapper);
   	
   	ShougaoVO selectVO(@Param("ew") Wrapper<ShougaoEntity> wrapper);
   	
   	List<ShougaoView> selectListView(Wrapper<ShougaoEntity> wrapper);
   	
   	ShougaoView selectView(@Param("ew") Wrapper<ShougaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShougaoEntity> wrapper);
   	

}

