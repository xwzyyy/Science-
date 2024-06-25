package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GaigaohuifuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GaigaohuifuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GaigaohuifuView;


/**
 * 改稿回复
 *
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface GaigaohuifuService extends IService<GaigaohuifuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GaigaohuifuVO> selectListVO(Wrapper<GaigaohuifuEntity> wrapper);
   	
   	GaigaohuifuVO selectVO(@Param("ew") Wrapper<GaigaohuifuEntity> wrapper);
   	
   	List<GaigaohuifuView> selectListView(Wrapper<GaigaohuifuEntity> wrapper);
   	
   	GaigaohuifuView selectView(@Param("ew") Wrapper<GaigaohuifuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GaigaohuifuEntity> wrapper);
   	

}

