package com.zsl.homestay.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsl.homestay.configuration.MyException;
import com.zsl.homestay.mapper.UserMapper;
import com.zsl.homestay.model.User;
import com.zsl.homestay.model.UserDTO;
import com.zsl.homestay.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Value("${file.patch}")
	private String filePatch;

	@Override
	public PageInfo<User> queryAllUser(User user) {
		if (user != null && user.getPageSize() != 0) {
			Page<User> page = PageHelper.startPage(user.getPageNum(), user.getPageSize());
		}
		PageInfo<User> pageInfo = new PageInfo<>(userMapper.queryAll(user));
		return pageInfo;
	}

	@Override
	public boolean login(String userName, String password) {
		User user = userMapper.selectUserName(userName);
		if (user == null) {
			throw new MyException(Response.SC_INTERNAL_SERVER_ERROR, "用户名或密码错误");
		}
		// Base64 解密
		byte[] decoded = Base64.getDecoder().decode(password);

		String decodeStr = new String(decoded);
		String md5Str = DigestUtils.md5DigestAsHex(decodeStr.getBytes());
		if (!md5Str.equals(user.getPassword())) {
			throw new MyException(Response.SC_INTERNAL_SERVER_ERROR, "用户名或密码错误");
		}
		return true;
	}

	@Override
	public Integer updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public User selectById(String id) {
		return userMapper.selectById(id);
	}

	@Override
	public Integer create(UserDTO user) {
		User us = new User();
		User u = userMapper.selectUserName(user.getUserName());
		if (u != null) {
			throw new MyException(Response.SC_INTERNAL_SERVER_ERROR, "用户已存在");
		}
		if (!StringUtils.isEmpty(user.getPassword())) {
			// Base64 解密
			byte[] decoded = Base64.getDecoder().decode(user.getPassword());

			String decodeStr = new String(decoded);
			String md5Str = DigestUtils.md5DigestAsHex(decodeStr.getBytes());
			user.setPassword(md5Str);
		}
		BeanUtils.copyProperties(user, us);
		us.setId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
		if (user.getPassportPhoto() != null) {
			MultipartFile file = user.getPassportPhoto();

			// 获取文件名
			String fileName = file.getOriginalFilename();
			// 获取文件后缀名
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			// 重新生成文件名
			String newFileName = UUID.randomUUID().toString().replace("-", "") + suffixName;
			File targetFile = new File(filePatch + File.separator + newFileName);

			try (FileOutputStream fileOutputStream = new FileOutputStream(targetFile)) {
				IOUtils.copy(file.getInputStream(), fileOutputStream);
				log.info("------>>>>>>uploaded a file successfully!<<<<<<------");
			} catch (IOException e) {
				log.info("------>>>>>>uploaded a file failed!<<<<<<------", e);
			}
			us.setPassportPhoto(filePatch + newFileName);
		}
		if (user.getSign() != null) {
			MultipartFile file = user.getSign();
			// 获取文件名
			String fileName = file.getOriginalFilename();
			// 获取文件后缀名
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			// 重新生成文件名
			String newFileName = UUID.randomUUID().toString().replace("-", "") + suffixName;
			File targetFile = new File(filePatch + File.separator + newFileName);

			try (FileOutputStream fileOutputStream = new FileOutputStream(targetFile)) {
				IOUtils.copy(file.getInputStream(), fileOutputStream);
				log.info("------>>>>>>uploaded a file successfully!<<<<<<------");
			} catch (IOException e) {
				log.info("------>>>>>>uploaded a file failed!<<<<<<------", e);
			}
			us.setSign(newFileName);
		}
		return userMapper.create(us);
	}

	@Override
	public Integer deleteById(String id) {
		return userMapper.deleteById(id);
	}
}
