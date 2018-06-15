package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.TblUserMapper;
import com.ssm.pojo.TblUser;
import com.ssm.service.IPojoUserService;

@Service
public class IPojoUserServiceImpl implements IPojoUserService {
	@Autowired
	private TblUserMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TblUser record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(TblUser record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public TblUser selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(TblUser record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TblUser record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

}
