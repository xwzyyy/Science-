package com.dao;

import com.entity.BianjibuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BianjibuVO;
import com.entity.view.BianjibuView;


/**
 * 编辑部
 * 
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface BianjibuDao extends BaseMapper<BianjibuEntity> {
	
	List<BianjibuVO> selectListVO(@Param("ew") Wrapper<BianjibuEntity> wrapper);
	
	BianjibuVO selectVO(@Param("ew") Wrapper<BianjibuEntity> wrapper);
	
	List<BianjibuView> selectListView(@Param("ew") Wrapper<BianjibuEntity> wrapper);

	List<BianjibuView> selectListView(Pagination page,@Param("ew") Wrapper<BianjibuEntity> wrapper);
	
	BianjibuView selectView(@Param("ew") Wrapper<BianjibuEntity> wrapper);
	

}
