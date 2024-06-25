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


import com.dao.BianjibuDao;
import com.entity.BianjibuEntity;
import com.service.BianjibuService;
import com.entity.vo.BianjibuVO;
import com.entity.view.BianjibuView;

@Service("bianjibuService")
public class BianjibuServiceImpl extends ServiceImpl<BianjibuDao, BianjibuEntity> implements BianjibuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BianjibuEntity> page = this.selectPage(
                new Query<BianjibuEntity>(params).getPage(),
                new EntityWrapper<BianjibuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BianjibuEntity> wrapper) {
		  Page<BianjibuView> page =new Query<BianjibuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BianjibuVO> selectListVO(Wrapper<BianjibuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BianjibuVO selectVO(Wrapper<BianjibuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BianjibuView> selectListView(Wrapper<BianjibuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BianjibuView selectView(Wrapper<BianjibuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
