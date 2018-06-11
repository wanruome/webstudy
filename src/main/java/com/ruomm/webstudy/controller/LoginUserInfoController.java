/**
 *	@copyright wanruome-2018
 * 	@author wanruome
 * 	@create 2018年6月10日 下午3:09:24
 */
package com.ruomm.webstudy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruomm.webstudy.dal.request.LoginUserReqDto;
import com.ruomm.webstudy.services.LoginService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/login")

public class LoginUserInfoController {
	@Autowired
	LoginService loginService;
	Validated Validated;

	@ApiOperation("用户登录")
	@PostMapping("/doLogin")
	public String doLogin(@Valid @RequestParam LoginUserReqDto loginUserReqDto, BindingResult bindingResult) {
		System.out.println(loginUserReqDto.toString());
		return loginService.doLogin();
	}
}
