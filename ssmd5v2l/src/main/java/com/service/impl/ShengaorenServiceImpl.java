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


import com.dao.ShengaorenDao;
import com.entity.ShengaorenEntity;
import com.service.ShengaorenService;
import com.entity.vo.ShengaorenVO;
import com.entity.view.ShengaorenView;

@Service("shengaorenService")
public class ShengaorenServiceImpl extends ServiceImpl<ShengaorenDao, ShengaorenEntity> implements ShengaorenService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShengaorenEntity> page = this.selectPage(
                new Query<ShengaorenEntity>(params).getPage(),
                new EntityWrapper<ShengaorenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShengaorenEntity> wrapper) {
		  Page<ShengaorenView> page =new Query<ShengaorenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShengaorenVO> selectListVO(Wrapper<ShengaorenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShengaorenVO selectVO(Wrapper<ShengaorenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShengaorenView> selectListView(Wrapper<ShengaorenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShengaorenView selectView(Wrapper<ShengaorenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
