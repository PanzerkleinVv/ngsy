package com.gdin.dzzwsyb.ngsy.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdin.dzzwsyb.ngsy.web.model.DutiesPerson;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPersonExtend;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPersonList;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesUnit;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesUnitList;
import com.gdin.dzzwsyb.ngsy.web.model.Log;
import com.gdin.dzzwsyb.ngsy.web.model.Person;
import com.gdin.dzzwsyb.ngsy.web.model.ResultMessage;
import com.gdin.dzzwsyb.ngsy.web.model.Unit;
import com.gdin.dzzwsyb.ngsy.web.security.RoleSign;
import com.gdin.dzzwsyb.ngsy.web.service.DutiesPersonService;
import com.gdin.dzzwsyb.ngsy.web.service.DutiesUnitService;
import com.gdin.dzzwsyb.ngsy.web.service.LogService;
import com.gdin.dzzwsyb.ngsy.web.service.PersonService;
import com.gdin.dzzwsyb.ngsy.web.service.UnitService;

@Controller
@RequestMapping("/adjust")
public class AdjustController {
	
	@Resource
	private DutiesUnitService dutiesUnitService;
	@Resource
	private DutiesPersonService dutiesPersonService;
	@Resource
	private UnitService unitService;
	@Resource
	private LogService logService;
	@Resource
	private PersonService personService;
	
	final static private String MODULE = "adjust";
	
	@RequestMapping("/adjustduties")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String dutiesList(@ModelAttribute("unit") Unit unit, Model model) {
		List<DutiesPersonExtend> dutiesPersonExtends = new ArrayList<DutiesPersonExtend>();
		if (unit != null && unit.getId() != null && !"".equals(unit.getId())) {
			final List<DutiesUnit> duties = dutiesUnitService.selectList(unit.getId());
			final List<DutiesPerson> dutiesPersons= dutiesPersonService.selectPersons(duties);
			if(dutiesPersons.size()>0 || dutiesPersons != null) {
				for(DutiesPerson dutiesPerson : dutiesPersons) {
					DutiesPersonExtend dutiesPersonExtend = new DutiesPersonExtend(dutiesPerson);
					Person person = personService.selectById(dutiesPerson.getPersonId());
					DutiesUnit dutiesUnit = dutiesUnitService.selectById(dutiesPerson.getDutiesUnitId());
					dutiesPersonExtend.setPersonName(person.getName());
					dutiesPersonExtend.setDutiesName(dutiesUnit.getName());
					dutiesPersonExtends.add(dutiesPersonExtend);
				}
			}
			unit = unitService.selectById(unit.getId());
			model.addAttribute("unit", unit);
			model.addAttribute("dutiesPersonExtends", dutiesPersonExtends);
		}
		return "adjustDuties";
	}
	
	@RequestMapping("/save")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String save(String unitId, DutiesPersonList dutiePersons, RedirectAttributes model, HttpSession session)
			throws Exception {
		if (unitId != null && !"".equals(unitId)) {
			if (dutiePersons.getDutiesPersons() != null && dutiePersons.getDutiesPersons().size() > 0) {
				final ResultMessage message = new ResultMessage();
				final Long userId = (Long) session.getAttribute("userId");
				final String METHOD = "更新内部人员职务排序：";
				message.edit();
				if (dutiesPersonService.modify(dutiePersons.getDutiesPersons(), unitId)) {
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
		return "redirect:/rest/adjust/adjustduties";
	}
	
	
}
