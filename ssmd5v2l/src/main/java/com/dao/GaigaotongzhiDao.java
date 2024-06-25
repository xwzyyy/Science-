package com.dao;

import com.entity.GaigaotongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GaigaotongzhiVO;
import com.entity.view.GaigaotongzhiView;


/**
 * 改稿通知
 * 
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface GaigaotongzhiDao extends BaseMapper<GaigaotongzhiEntity> {
	
	List<GaigaotongzhiVO> selectListVO(@Param("ew") Wrapper<GaigaotongzhiEntity> wrapper);
	
	GaigaotongzhiVO selectVO(@Param("ew") Wrapper<GaigaotongzhiEntity> wrapper);
	
	List<GaigaotongzhiView> selectListView(@Param("ew") Wrapper<GaigaotongzhiEntity> wrapper);

	List<GaigaotongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<GaigaotongzhiEntity> wrapper);
	
	GaigaotongzhiView selectView(@Param("ew") Wrapper<GaigaotongzhiEntity> wrapper);
	

}
