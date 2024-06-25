package com.dao;

import com.entity.GaojianleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GaojianleixingVO;
import com.entity.view.GaojianleixingView;


/**
 * 稿件类型
 * 
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface GaojianleixingDao extends BaseMapper<GaojianleixingEntity> {
	
	List<GaojianleixingVO> selectListVO(@Param("ew") Wrapper<GaojianleixingEntity> wrapper);
	
	GaojianleixingVO selectVO(@Param("ew") Wrapper<GaojianleixingEntity> wrapper);
	
	List<GaojianleixingView> selectListView(@Param("ew") Wrapper<GaojianleixingEntity> wrapper);

	List<GaojianleixingView> selectListView(Pagination page,@Param("ew") Wrapper<GaojianleixingEntity> wrapper);
	
	GaojianleixingView selectView(@Param("ew") Wrapper<GaojianleixingEntity> wrapper);
	

}
