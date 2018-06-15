package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.SysUserMapper;
import com.ssm.pojo.SysUser;
import com.ssm.service.IUserService;

@Service
public class IUserServiceImpl implements IUserService {
	@Autowired
	private SysUserMapper mapper;

	@Override
	public SysUser selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

}
