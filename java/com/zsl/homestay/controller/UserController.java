package com.zsl.homestay.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageInfo;
import com.zsl.homestay.commen.Result;
import com.zsl.homestay.commen.ResultUtil;
import com.zsl.homestay.model.User;
import com.zsl.homestay.model.UserDTO;
import com.zsl.homestay.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Value("${file.patch}")
	String path;

	@GetMapping("/login")
	@ApiOperation(value = "用户登录")
	public Result<User> login(@ApiParam(name = "userName", value = "用户名") @RequestParam("userName") String userName,
			@ApiParam(name = "password", value = "密码") @RequestParam("password") String password) {
		boolean u = userService.login(userName, password);
		return ResultUtil.success(u);
	}

	@PostMapping("/api/user/list")
	@ApiOperation(value = "查询用户列表")
	public Result<PageInfo<User>> queryAllUser(@ApiParam(name = "user", value = "用户") @RequestBody User user) {
		PageInfo<User> users = userService.queryAllUser(user);
		return ResultUtil.success(users);
	}

	@PostMapping("/api/user/update")
	@ApiOperation(value = "更新用户列表")
	public Result<Integer> updateUser(@ApiParam(name = "user", value = "用户") @RequestBody User user) {
		Integer count = userService.updateUser(user);
		return ResultUtil.success(count);
	}

	@PostMapping("/api/user/create")
	@ApiOperation(value = "创建用户")
	public Result<Integer> createUser(@ApiParam(name = "user", value = "用户") UserDTO user) {
		Integer count = userService.create(user);
		return ResultUtil.success(count);
	}

	@PostMapping("/api/user/delete")
	@ApiOperation(value = "删除用户")
	public Result<Integer> deleteUser(@ApiParam(name = "id", value = "用户id") @RequestParam String id) {
		Integer count = userService.deleteById(id);
		return ResultUtil.success(count);
	}

	@PostMapping("/api/user/view")
	@ApiOperation(value = "查看用户")
	public Result<User> viewUser(@ApiParam(name = "id", value = "用户id") @RequestParam String id) {
		User user = userService.selectById(id);
		return ResultUtil.success(user);
	}

	@PostMapping("/api/user/export")
	@ApiOperation(value = "导出用户")
	public void exportUser(@ApiParam(name = "user", value = "用户") @RequestBody(required = false) User user,
			HttpServletResponse response) {
		PageInfo<User> users = userService.queryAllUser(user);
		List<User> list = users.getList();
		// 设置响应类型
		response.setContentType("application/vnd.ms-excel");
		// 设置字符编码
		response.setCharacterEncoding("utf-8");
		// 设置响应头信息
		try {
			response.setHeader("Content-disposition",
					"attachment;filename*=utf-8''" + URLEncoder.encode("用戶信息", "UTF-8") + ".xlsx");
		} catch (UnsupportedEncodingException e1) {
		}

		try {
			EasyExcel.write(response.getOutputStream(), User.class).sheet("用戶信息").doWrite(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
