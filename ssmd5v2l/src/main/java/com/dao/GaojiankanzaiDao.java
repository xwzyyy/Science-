package com.dao;

import com.entity.GaojiankanzaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GaojiankanzaiVO;
import com.entity.view.GaojiankanzaiView;


/**
 * 稿件刊载
 * 
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface GaojiankanzaiDao extends BaseMapper<GaojiankanzaiEntity> {
	
	List<GaojiankanzaiVO> selectListVO(@Param("ew") Wrapper<GaojiankanzaiEntity> wrapper);
	
	GaojiankanzaiVO selectVO(@Param("ew") Wrapper<GaojiankanzaiEntity> wrapper);
	
	List<GaojiankanzaiView> selectListView(@Param("ew") Wrapper<GaojiankanzaiEntity> wrapper);

	List<GaojiankanzaiView> selectListView(Pagination page,@Param("ew") Wrapper<GaojiankanzaiEntity> wrapper);
	
	GaojiankanzaiView selectView(@Param("ew") Wrapper<GaojiankanzaiEntity> wrapper);
	

}
