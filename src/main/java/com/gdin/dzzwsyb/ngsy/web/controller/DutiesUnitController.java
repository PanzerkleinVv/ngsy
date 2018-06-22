package com.gdin.dzzwsyb.ngsy.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdin.dzzwsyb.ngsy.web.model.DutiesUnit;
import com.gdin.dzzwsyb.ngsy.web.model.ResultMessage;
import com.gdin.dzzwsyb.ngsy.web.model.Unit;
import com.gdin.dzzwsyb.ngsy.web.security.RoleSign;
import com.gdin.dzzwsyb.ngsy.web.service.DutiesUnitService;
import com.gdin.dzzwsyb.ngsy.web.service.LogService;

@Controller
@RequestMapping(value = "/dutiesUnit")
public class DutiesUnitController {
	
	@Resource
	private DutiesUnitService dutiesUnitService;
	@Resource
	private LogService logService;
	
	@RequestMapping("/list")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String list(@ModelAttribute("unit") Unit unit, Model model,
			@ModelAttribute("message") ResultMessage message) {
		if (unit != null && unit.getId() != null && !"".equals(unit.getId())) {
			final List<DutiesUnit> duties = dutiesUnitService.selectList(unit.getId());
			model.addAttribute("duties", duties);
		}
		model.addAttribute("message", message);
		return "unitSort";
	}
	
	
}
