package com.gdin.dzzwsyb.ngsy.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPerson;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPersonExtend;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesPersonExtendList;
import com.gdin.dzzwsyb.ngsy.web.model.DutiesUnit;
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
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		            String ownDateStr = sdf.format(dutiesPerson.getOwnDate());
		            dutiesPersonExtend.setOwnDateStr(ownDateStr);
		            if(dutiesPerson.getProbationDate() != null) {
		            	String probationDateStr = sdf.format(dutiesPerson.getProbationDate());
		            	dutiesPersonExtend.setProbationDateStr(probationDateStr);
		            }
					dutiesPersonExtend.setPersonName(person.getName());
					dutiesPersonExtend.setDutiesName(dutiesUnit.getName());
					dutiesPersonExtends.add(dutiesPersonExtend);
				}
			}
			unit = unitService.selectById(unit.getId());
			model.addAttribute("unit", unit);
			model.addAttribute("dutiesPersonExtends", dutiesPersonExtends);
			model.addAttribute("duties", duties);
		}
		return "adjustDuties";
	}
	
	@RequestMapping("/save")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String save(String unitId, DutiesPersonExtendList dutiesPersonExtends, RedirectAttributes model, HttpSession session)
			throws Exception {
		if (unitId != null && !"".equals(unitId)) {
			if (dutiesPersonExtends.getDutiesPersonExtends() != null && dutiesPersonExtends.getDutiesPersonExtends().size() > 0) {
				final ResultMessage message = new ResultMessage();
				final Long userId = (Long) session.getAttribute("userId");
				final String METHOD = "更新内部人员职务排序：";
				message.edit();
				if (dutiesPersonService.modify(dutiesPersonExtends.getDutiesPersonExtends())) {
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
	
	//退休（未修改人员表中的state）
	@RequestMapping("/lostDuties")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String lostDuties(String dutiesPersonExtendId, String  unitId, RedirectAttributes model)
			throws Exception {
		DutiesPerson dutiesPerson = dutiesPersonService.selectById(dutiesPersonExtendId);
		Date lostDate = ApplicationUtils.getYMD();
		dutiesPerson.setLostDate(lostDate);
		int flag = dutiesPersonService.update(dutiesPerson);
		if (flag < 1) {
			throw new Exception("退休更新出错");
		}
		final Unit unit = new Unit();
		unit.setId(unitId);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/adjust/adjustduties";
	}
	
	@RequestMapping("/regularDuties")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String regularDuties(String dutiesPersonExtendId, String  unitId, RedirectAttributes model)
			throws Exception {
		DutiesPerson dutiesPerson = dutiesPersonService.selectById(dutiesPersonExtendId);
		dutiesPerson.setIsProbation("否");
		dutiesPerson.setProbationDate(null);
		int flag = dutiesPersonService.updateByPrimaryKey(dutiesPerson);
		if (flag < 1) {
			throw new Exception("转正更新出错");
		}
		final Unit unit = new Unit();
		unit.setId(unitId);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/adjust/adjustduties";
	}
	
	//免职（未修改人员表中的state）
	@RequestMapping("/delDuties")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String delDuties(String dutiesPersonExtendId, String  unitId, RedirectAttributes model)
			throws Exception {
		DutiesPerson dutiesPerson = dutiesPersonService.selectById(dutiesPersonExtendId);
		Date lostDate = ApplicationUtils.getYMD();
		dutiesPerson.setLostDate(lostDate);
		int flag = dutiesPersonService.update(dutiesPerson);
		if (flag < 1) {
			throw new Exception("退休更新出错");
		}
		final Unit unit = new Unit();
		unit.setId(unitId);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/adjust/adjustduties";
	}
	
	@ResponseBody
	@RequestMapping("/personBlur")
	public List<Person> personBlur(String personName) {
		List<Person> persons = new ArrayList<Person>();
		if(personName != null || !"".equals(personName)) {
			persons = personService.selectPersonsByName(personName);
		}
		return persons;
	}
	
	@RequestMapping("/addDutiesPerson")
	public String addDutiesPerson(DutiesPerson dutiesPerson, String personName, String  unitId, RedirectAttributes model) {
		dutiesPerson.setId(UUID.randomUUID().toString().replaceAll("-",""));
		final List<DutiesUnit> duties = dutiesUnitService.selectList(unitId);
		final List<DutiesPerson> dutiesPersons= dutiesPersonService.selectPersons(duties);
		int sort = dutiesPersons.get(dutiesPersons.size()-1).getSort();
		dutiesPerson.setSort(sort+1);
		//暂时没有考虑person表同名
		List<Person> persons = personService.selectPersonsByName(personName);
		dutiesPerson.setPersonId(persons.get(0).getId());
		int flag = dutiesPersonService.insert(dutiesPerson);
		final Unit unit = new Unit();
		unit.setId(unitId);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/adjust/adjustduties";
	}
	
	@RequestMapping("/adjustjobs")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String adjustjobs(@ModelAttribute("unit") Unit unit, Model model) {
		
		return "adjustJobs";
	}
	
}
