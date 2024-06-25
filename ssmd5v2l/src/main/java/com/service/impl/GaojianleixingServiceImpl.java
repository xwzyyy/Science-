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


import com.dao.GaojianleixingDao;
import com.entity.GaojianleixingEntity;
import com.service.GaojianleixingService;
import com.entity.vo.GaojianleixingVO;
import com.entity.view.GaojianleixingView;

@Service("gaojianleixingService")
public class GaojianleixingServiceImpl extends ServiceImpl<GaojianleixingDao, GaojianleixingEntity> implements GaojianleixingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GaojianleixingEntity> page = this.selectPage(
                new Query<GaojianleixingEntity>(params).getPage(),
                new EntityWrapper<GaojianleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GaojianleixingEntity> wrapper) {
		  Page<GaojianleixingView> page =new Query<GaojianleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GaojianleixingVO> selectListVO(Wrapper<GaojianleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GaojianleixingVO selectVO(Wrapper<GaojianleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GaojianleixingView> selectListView(Wrapper<GaojianleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GaojianleixingView selectView(Wrapper<GaojianleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
