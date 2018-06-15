package com.ssm.service;

import com.ssm.pojo.SysUser;

public interface IUserService {
	SysUser selectByPrimaryKey(Long id);
}
