package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShangchuangaojianDao;
import com.entity.ShangchuangaojianEntity;
import com.service.ShangchuangaojianService;
import com.entity.vo.ShangchuangaojianVO;
import com.entity.view.ShangchuangaojianView;

@Service("shangchuangaojianService")
public class ShangchuangaojianServiceImpl extends ServiceImpl<ShangchuangaojianDao, ShangchuangaojianEntity> implements ShangchuangaojianService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangchuangaojianEntity> page = this.selectPage(
                new Query<ShangchuangaojianEntity>(params).getPage(),
                new EntityWrapper<ShangchuangaojianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangchuangaojianEntity> wrapper) {
		  Page<ShangchuangaojianView> page =new Query<ShangchuangaojianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShangchuangaojianVO> selectListVO(Wrapper<ShangchuangaojianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangchuangaojianVO selectVO(Wrapper<ShangchuangaojianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangchuangaojianView> selectListView(Wrapper<ShangchuangaojianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangchuangaojianView selectView(Wrapper<ShangchuangaojianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
