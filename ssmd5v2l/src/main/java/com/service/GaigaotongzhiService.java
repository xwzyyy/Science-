package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GaigaotongzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GaigaotongzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GaigaotongzhiView;


/**
 * 改稿通知
 *
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface GaigaotongzhiService extends IService<GaigaotongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GaigaotongzhiVO> selectListVO(Wrapper<GaigaotongzhiEntity> wrapper);
   	
   	GaigaotongzhiVO selectVO(@Param("ew") Wrapper<GaigaotongzhiEntity> wrapper);
   	
   	List<GaigaotongzhiView> selectListView(Wrapper<GaigaotongzhiEntity> wrapper);
   	
   	GaigaotongzhiView selectView(@Param("ew") Wrapper<GaigaotongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GaigaotongzhiEntity> wrapper);
   	

}

