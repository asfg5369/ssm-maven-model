package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.TblUser;
import com.ssm.service.IPojoUserService;

@Controller
public class AdminController extends DispatcherServlet {

	@Autowired
	private IPojoUserService iPojoUserService;

	public static final String SUCCESS = "success";

	// @ModelAttribute
	// public void getUser(@RequestParam(value = "id", required = false) Long
	// id, Map<String, Object> map) {
	// if (id != null) {
	// TblUser user = iPojoUserService.selectByPrimaryKey(id);
	// map.put("tblUser", user);
	// }
	// }
	// no found
	@RequestMapping("/*")
	public String notFound() {
		return "404";
	}

	@RequestMapping("/success")
	public ModelAndView getUserName(@Validated TblUser user, BindingResult br, ModelAndView mv) {
		System.out.println("user:" + JSON.toJSONString(user));
		mv = new ModelAndView();
		if (br.hasErrors()) {
			System.out.println("错误数量:" + br.getErrorCount());
			Long id = user.getId();
			int res = Integer.parseInt(String.valueOf(id)) / 0;
			System.out.println(res);
			mv.setViewName("index");
			return mv;
		}
		int res = iPojoUserService.updateByPrimaryKeySelective(user);
		mv.setViewName(SUCCESS);
		mv.addObject("res", res);
		return mv;
	}

	@RequestMapping("/index{index}")
	public String index(@PathVariable String index, TblUser tblUser) {
		return "index" + index;
	}

	@RequestMapping("/layer{index}")
	public String layer(@PathVariable String index) {
		return "layer" + index;
	}

}
