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


import com.dao.GaojiankanzaiDao;
import com.entity.GaojiankanzaiEntity;
import com.service.GaojiankanzaiService;
import com.entity.vo.GaojiankanzaiVO;
import com.entity.view.GaojiankanzaiView;

@Service("gaojiankanzaiService")
public class GaojiankanzaiServiceImpl extends ServiceImpl<GaojiankanzaiDao, GaojiankanzaiEntity> implements GaojiankanzaiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GaojiankanzaiEntity> page = this.selectPage(
                new Query<GaojiankanzaiEntity>(params).getPage(),
                new EntityWrapper<GaojiankanzaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GaojiankanzaiEntity> wrapper) {
		  Page<GaojiankanzaiView> page =new Query<GaojiankanzaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GaojiankanzaiVO> selectListVO(Wrapper<GaojiankanzaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GaojiankanzaiVO selectVO(Wrapper<GaojiankanzaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GaojiankanzaiView> selectListView(Wrapper<GaojiankanzaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GaojiankanzaiView selectView(Wrapper<GaojiankanzaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
