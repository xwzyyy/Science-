package com.dao;

import com.entity.GaigaohuifuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GaigaohuifuVO;
import com.entity.view.GaigaohuifuView;


/**
 * 改稿回复
 * 
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface GaigaohuifuDao extends BaseMapper<GaigaohuifuEntity> {
	
	List<GaigaohuifuVO> selectListVO(@Param("ew") Wrapper<GaigaohuifuEntity> wrapper);
	
	GaigaohuifuVO selectVO(@Param("ew") Wrapper<GaigaohuifuEntity> wrapper);
	
	List<GaigaohuifuView> selectListView(@Param("ew") Wrapper<GaigaohuifuEntity> wrapper);

	List<GaigaohuifuView> selectListView(Pagination page,@Param("ew") Wrapper<GaigaohuifuEntity> wrapper);
	
	GaigaohuifuView selectView(@Param("ew") Wrapper<GaigaohuifuEntity> wrapper);
	

}
