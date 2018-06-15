package cn.ssm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.SysUser;
import com.ssm.pojo.User;
import com.ssm.service.IQuartzUserService;
import com.ssm.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
// 多个配置文件
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml" })
public class TestMyBatis {
	@Autowired
	private IUserService iUserService;

	@Autowired
	private IQuartzUserService iQuartzUserService;
	@Test
	public void test1() {
		SysUser user = iUserService.selectByPrimaryKey((long) 1);
		System.out.println(JSON.toJSON(user));
	}
	@Test
	public void test2(){
		List<User> list = iQuartzUserService.queryAll();
		for (User user : list) {
			System.out.println(JSON.toJSON(user));
		}
		
	}

}
