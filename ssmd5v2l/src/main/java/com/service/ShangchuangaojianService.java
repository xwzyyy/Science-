package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangchuangaojianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangchuangaojianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangchuangaojianView;


/**
 * 上传稿件
 *
 * @author 
 * @email 
 * @date 2022-08-07 09:53:23
 */
public interface ShangchuangaojianService extends IService<ShangchuangaojianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangchuangaojianVO> selectListVO(Wrapper<ShangchuangaojianEntity> wrapper);
   	
   	ShangchuangaojianVO selectVO(@Param("ew") Wrapper<ShangchuangaojianEntity> wrapper);
   	
   	List<ShangchuangaojianView> selectListView(Wrapper<ShangchuangaojianEntity> wrapper);
   	
   	ShangchuangaojianView selectView(@Param("ew") Wrapper<ShangchuangaojianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangchuangaojianEntity> wrapper);
   	

}

