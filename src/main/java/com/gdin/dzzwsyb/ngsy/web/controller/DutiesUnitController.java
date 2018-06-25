package com.gdin.dzzwsyb.ngsy.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdin.dzzwsyb.ngsy.web.model.DutiesUnit;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesUnitList;
import com.gdin.dzzwsyb.ngsy.web.model.Log;
import com.gdin.dzzwsyb.ngsy.web.model.ResultMessage;
import com.gdin.dzzwsyb.ngsy.web.model.Unit;
import com.gdin.dzzwsyb.ngsy.web.security.RoleSign;
import com.gdin.dzzwsyb.ngsy.web.service.DutiesUnitService;
import com.gdin.dzzwsyb.ngsy.web.service.LogService;
import com.gdin.dzzwsyb.ngsy.web.service.UnitService;

@Controller
@RequestMapping(value = "/dutiesUnit")
public class DutiesUnitController {

	@Resource
	private DutiesUnitService dutiesUnitService;
	@Resource
	private UnitService unitService;
	@Resource
	private LogService logService;

	final static private String MODULE = "duties_unit";

	@RequestMapping("/list")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String list(@ModelAttribute("unit") Unit unit, Model model,
			@ModelAttribute("message") ResultMessage message) {
		if (unit != null && unit.getId() != null && !"".equals(unit.getId())) {
			final List<DutiesUnit> duties = dutiesUnitService.selectList(unit.getId());
			unit = unitService.selectById(unit.getId());
			model.addAttribute("unit", unit);
			model.addAttribute("duties", duties);
		}
		model.addAttribute("message", message);
		return "unitDuties";
	}

	@RequestMapping("/save")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String save(String unitId, DutiesUnitList list, RedirectAttributes model, HttpSession session)
			throws Exception {
		if (unitId != null && !"".equals(unitId)) {
			if (list.getDutieUnits() != null && list.getDutieUnits().size() > 0) {
				final ResultMessage message = new ResultMessage();
				final Long userId = (Long) session.getAttribute("userId");
				final String METHOD = "更新行政职务：";
				message.edit();
				if (dutiesUnitService.modify(list.getDutieUnits(), unitId)) {
					message.success();
					final Log log = new Log(userId, MODULE, unitId, METHOD + unitId);
					logService.log(log);
				} else {
					message.failure();
				}
				model.addFlashAttribute("message", message);
			}
			final Unit unit = new Unit();
			unit.setId(unitId);
			model.addFlashAttribute("unit", unit);
		}
		return "redirect:/rest/duties_unit/unitDuties";
	}
}
