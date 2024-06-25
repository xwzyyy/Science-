package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShengaorenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShengaorenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShengaorenView;


/**
 * 审稿人
 *
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface ShengaorenService extends IService<ShengaorenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShengaorenVO> selectListVO(Wrapper<ShengaorenEntity> wrapper);
   	
   	ShengaorenVO selectVO(@Param("ew") Wrapper<ShengaorenEntity> wrapper);
   	
   	List<ShengaorenView> selectListView(Wrapper<ShengaorenEntity> wrapper);
   	
   	ShengaorenView selectView(@Param("ew") Wrapper<ShengaorenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShengaorenEntity> wrapper);
   	

}

