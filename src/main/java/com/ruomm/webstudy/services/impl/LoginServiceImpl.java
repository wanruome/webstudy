/**
 *	@copyright wanruome-2018
 * 	@author wanruome
 * 	@create 2018年6月10日 下午3:11:31
 */
package com.ruomm.webstudy.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruomm.base.datasource.DataSource;
import com.ruomm.webstudy.services.DbSeqService;
import com.ruomm.webstudy.services.LoginService;

@Component
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	DbSeqService dbSeqService;

	@DataSource("mysql")
	@Transactional(rollbackFor = Exception.class)

	@Override
	public String doLogin() {
		return dbSeqService.getSeqByName("tbl_login_user_key2") + "";
	}

}
