package com.gdin.dzzwsyb.ngsy.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdin.dzzwsyb.ngsy.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.ngsy.web.model.LogQuery;
import com.gdin.dzzwsyb.ngsy.web.model.VLog;
import com.gdin.dzzwsyb.ngsy.web.security.RoleSign;
import com.gdin.dzzwsyb.ngsy.web.service.LogService;

@Controller
@RequestMapping(value = "/log")
public class LogController {
	
	@Resource
	private LogService logService;
	
	/**
	 * 日志管理查询页面
	 * 
	 * @param logQuery
	 *            封装查询日志的条件
	 * @param model
	 *            返回视图模型
	 * @return log.jsp
	 */
	@RequestMapping(value = "/admin")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String admin(LogQuery logQuery, Model model) {
		Page<VLog> page = logService.selectPage(logQuery);
		List<VLog> logs = page.getResult();
		model.addAttribute("page", page);
		model.addAttribute("logs", logs);
		model.addAttribute("logQuery", logQuery);
		return "log";
	}
}
