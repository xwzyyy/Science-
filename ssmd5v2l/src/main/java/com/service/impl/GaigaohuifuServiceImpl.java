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


import com.dao.GaigaohuifuDao;
import com.entity.GaigaohuifuEntity;
import com.service.GaigaohuifuService;
import com.entity.vo.GaigaohuifuVO;
import com.entity.view.GaigaohuifuView;

@Service("gaigaohuifuService")
public class GaigaohuifuServiceImpl extends ServiceImpl<GaigaohuifuDao, GaigaohuifuEntity> implements GaigaohuifuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GaigaohuifuEntity> page = this.selectPage(
                new Query<GaigaohuifuEntity>(params).getPage(),
                new EntityWrapper<GaigaohuifuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GaigaohuifuEntity> wrapper) {
		  Page<GaigaohuifuView> page =new Query<GaigaohuifuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GaigaohuifuVO> selectListVO(Wrapper<GaigaohuifuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GaigaohuifuVO selectVO(Wrapper<GaigaohuifuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GaigaohuifuView> selectListView(Wrapper<GaigaohuifuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GaigaohuifuView selectView(Wrapper<GaigaohuifuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
