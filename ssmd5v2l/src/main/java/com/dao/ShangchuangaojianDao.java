package com.dao;

import com.entity.ShangchuangaojianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangchuangaojianVO;
import com.entity.view.ShangchuangaojianView;


/**
 * 上传稿件
 * 
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface ShangchuangaojianDao extends BaseMapper<ShangchuangaojianEntity> {
	
	List<ShangchuangaojianVO> selectListVO(@Param("ew") Wrapper<ShangchuangaojianEntity> wrapper);
	
	ShangchuangaojianVO selectVO(@Param("ew") Wrapper<ShangchuangaojianEntity> wrapper);
	
	List<ShangchuangaojianView> selectListView(@Param("ew") Wrapper<ShangchuangaojianEntity> wrapper);

	List<ShangchuangaojianView> selectListView(Pagination page,@Param("ew") Wrapper<ShangchuangaojianEntity> wrapper);
	
	ShangchuangaojianView selectView(@Param("ew") Wrapper<ShangchuangaojianEntity> wrapper);
	

}
