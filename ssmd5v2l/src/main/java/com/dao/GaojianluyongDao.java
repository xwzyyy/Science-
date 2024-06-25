package com.dao;

import com.entity.GaojianluyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GaojianluyongVO;
import com.entity.view.GaojianluyongView;


/**
 * 稿件录用
 * 
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface GaojianluyongDao extends BaseMapper<GaojianluyongEntity> {
	
	List<GaojianluyongVO> selectListVO(@Param("ew") Wrapper<GaojianluyongEntity> wrapper);
	
	GaojianluyongVO selectVO(@Param("ew") Wrapper<GaojianluyongEntity> wrapper);
	
	List<GaojianluyongView> selectListView(@Param("ew") Wrapper<GaojianluyongEntity> wrapper);

	List<GaojianluyongView> selectListView(Pagination page,@Param("ew") Wrapper<GaojianluyongEntity> wrapper);
	
	GaojianluyongView selectView(@Param("ew") Wrapper<GaojianluyongEntity> wrapper);
	

}
