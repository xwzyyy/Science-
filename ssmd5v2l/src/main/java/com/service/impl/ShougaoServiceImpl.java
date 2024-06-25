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


import com.dao.ShougaoDao;
import com.entity.ShougaoEntity;
import com.service.ShougaoService;
import com.entity.vo.ShougaoVO;
import com.entity.view.ShougaoView;

@Service("shougaoService")
public class ShougaoServiceImpl extends ServiceImpl<ShougaoDao, ShougaoEntity> implements ShougaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShougaoEntity> page = this.selectPage(
                new Query<ShougaoEntity>(params).getPage(),
                new EntityWrapper<ShougaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShougaoEntity> wrapper) {
		  Page<ShougaoView> page =new Query<ShougaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShougaoVO> selectListVO(Wrapper<ShougaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShougaoVO selectVO(Wrapper<ShougaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShougaoView> selectListView(Wrapper<ShougaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShougaoView selectView(Wrapper<ShougaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
