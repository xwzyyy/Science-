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


import com.dao.GaigaotongzhiDao;
import com.entity.GaigaotongzhiEntity;
import com.service.GaigaotongzhiService;
import com.entity.vo.GaigaotongzhiVO;
import com.entity.view.GaigaotongzhiView;

@Service("gaigaotongzhiService")
public class GaigaotongzhiServiceImpl extends ServiceImpl<GaigaotongzhiDao, GaigaotongzhiEntity> implements GaigaotongzhiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GaigaotongzhiEntity> page = this.selectPage(
                new Query<GaigaotongzhiEntity>(params).getPage(),
                new EntityWrapper<GaigaotongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GaigaotongzhiEntity> wrapper) {
		  Page<GaigaotongzhiView> page =new Query<GaigaotongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GaigaotongzhiVO> selectListVO(Wrapper<GaigaotongzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GaigaotongzhiVO selectVO(Wrapper<GaigaotongzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GaigaotongzhiView> selectListView(Wrapper<GaigaotongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GaigaotongzhiView selectView(Wrapper<GaigaotongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
