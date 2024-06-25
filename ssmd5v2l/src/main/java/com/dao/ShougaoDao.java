package com.dao;

import com.entity.ShougaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShougaoVO;
import com.entity.view.ShougaoView;


/**
 * 收稿
 * 
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface ShougaoDao extends BaseMapper<ShougaoEntity> {
	
	List<ShougaoVO> selectListVO(@Param("ew") Wrapper<ShougaoEntity> wrapper);
	
	ShougaoVO selectVO(@Param("ew") Wrapper<ShougaoEntity> wrapper);
	
	List<ShougaoView> selectListView(@Param("ew") Wrapper<ShougaoEntity> wrapper);

	List<ShougaoView> selectListView(Pagination page,@Param("ew") Wrapper<ShougaoEntity> wrapper);
	
	ShougaoView selectView(@Param("ew") Wrapper<ShougaoEntity> wrapper);
	

}
