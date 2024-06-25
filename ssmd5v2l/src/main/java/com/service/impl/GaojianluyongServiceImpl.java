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


import com.dao.GaojianluyongDao;
import com.entity.GaojianluyongEntity;
import com.service.GaojianluyongService;
import com.entity.vo.GaojianluyongVO;
import com.entity.view.GaojianluyongView;

@Service("gaojianluyongService")
public class GaojianluyongServiceImpl extends ServiceImpl<GaojianluyongDao, GaojianluyongEntity> implements GaojianluyongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GaojianluyongEntity> page = this.selectPage(
                new Query<GaojianluyongEntity>(params).getPage(),
                new EntityWrapper<GaojianluyongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GaojianluyongEntity> wrapper) {
		  Page<GaojianluyongView> page =new Query<GaojianluyongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GaojianluyongVO> selectListVO(Wrapper<GaojianluyongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GaojianluyongVO selectVO(Wrapper<GaojianluyongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GaojianluyongView> selectListView(Wrapper<GaojianluyongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GaojianluyongView selectView(Wrapper<GaojianluyongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
