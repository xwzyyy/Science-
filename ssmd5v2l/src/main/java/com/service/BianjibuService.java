package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BianjibuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BianjibuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BianjibuView;


/**
 * 编辑部
 *
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface BianjibuService extends IService<BianjibuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BianjibuVO> selectListVO(Wrapper<BianjibuEntity> wrapper);
   	
   	BianjibuVO selectVO(@Param("ew") Wrapper<BianjibuEntity> wrapper);
   	
   	List<BianjibuView> selectListView(Wrapper<BianjibuEntity> wrapper);
   	
   	BianjibuView selectView(@Param("ew") Wrapper<BianjibuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BianjibuEntity> wrapper);
   	

}

