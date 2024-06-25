package com.dao;

import com.entity.ShengaorenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShengaorenVO;
import com.entity.view.ShengaorenView;


/**
 * 审稿人
 * 
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface ShengaorenDao extends BaseMapper<ShengaorenEntity> {
	
	List<ShengaorenVO> selectListVO(@Param("ew") Wrapper<ShengaorenEntity> wrapper);
	
	ShengaorenVO selectVO(@Param("ew") Wrapper<ShengaorenEntity> wrapper);
	
	List<ShengaorenView> selectListView(@Param("ew") Wrapper<ShengaorenEntity> wrapper);

	List<ShengaorenView> selectListView(Pagination page,@Param("ew") Wrapper<ShengaorenEntity> wrapper);
	
	ShengaorenView selectView(@Param("ew") Wrapper<ShengaorenEntity> wrapper);
	

}
