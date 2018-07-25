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
import com.gdin.dzzwsyb.ngsy.web.model.JobPerson;
import com.gdin.dzzwsyb.ngsy.web.model.JobPersonExtend;
import com.gdin.dzzwsyb.ngsy.web.model.JobPersonExtendList;
import com.gdin.dzzwsyb.ngsy.web.model.JobUnit;
import com.gdin.dzzwsyb.ngsy.web.model.Log;
import com.gdin.dzzwsyb.ngsy.web.model.Person;
import com.gdin.dzzwsyb.ngsy.web.model.ResultMessage;
import com.gdin.dzzwsyb.ngsy.web.model.Unit;
import com.gdin.dzzwsyb.ngsy.web.security.RoleSign;
import com.gdin.dzzwsyb.ngsy.web.service.DutiesPersonService;
import com.gdin.dzzwsyb.ngsy.web.service.DutiesUnitService;
import com.gdin.dzzwsyb.ngsy.web.service.JobPersonService;
import com.gdin.dzzwsyb.ngsy.web.service.JobUnitService;
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
	private JobUnitService jobUnitService;
	@Resource
	private JobPersonService jobPersonService;
	@Resource
	private UnitService unitService;
	@Resource
	private LogService logService;
	@Resource
	private PersonService personService;

	final static private String JOBMODULE = "job_person";
	final static private String DUTIESMODULE = "duties_person";

	@RequestMapping("/adjustduties")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String dutiesList(@ModelAttribute("unit") Unit unit, Model model) {
		List<DutiesPersonExtend> dutiesPersonExtends = new ArrayList<DutiesPersonExtend>();
		if (unit != null && unit.getId() != null && !"".equals(unit.getId())) {
			final List<DutiesUnit> duties = dutiesUnitService.selectList(unit.getId());
			final List<DutiesPerson> dutiesPersons = dutiesPersonService.selectPersons(duties);
			if (dutiesPersons.size() > 0 || dutiesPersons != null) {
				for (DutiesPerson dutiesPerson : dutiesPersons) {
					DutiesPersonExtend dutiesPersonExtend = new DutiesPersonExtend(dutiesPerson);
					Person person = personService.selectById(dutiesPerson.getPersonId());
					DutiesUnit dutiesUnit = dutiesUnitService.selectById(dutiesPerson.getDutiesUnitId());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String ownDateStr = sdf.format(dutiesPerson.getOwnDate());
					dutiesPersonExtend.setOwnDateStr(ownDateStr);
					if (dutiesPerson.getProbationDate() != null) {
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
	public String save(String unitId, DutiesPersonExtendList dutiesPersonExtends, RedirectAttributes model,
			HttpSession session) throws Exception {
		if (unitId != null && !"".equals(unitId)) {
			if (dutiesPersonExtends.getDutiesPersonExtends() != null
					&& dutiesPersonExtends.getDutiesPersonExtends().size() > 0) {
				final ResultMessage message = new ResultMessage();
				final Long userId = (Long) session.getAttribute("userId");
				final String METHOD = "更新内部人员职务排序：";
				message.edit();
				if (dutiesPersonService.modify(dutiesPersonExtends.getDutiesPersonExtends())) {
					message.success();
					final Log log = new Log(userId, DUTIESMODULE, unitId, METHOD);
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

	// 退休（未修改人员表中的state）
	@RequestMapping("/lostDuties")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String lostDuties(String dutiesPersonExtendId, String unitId, RedirectAttributes model, HttpSession session)
			throws Exception {
		DutiesPerson dutiesPerson = dutiesPersonService.selectById(dutiesPersonExtendId);
		Date lostDate = ApplicationUtils.getYMD();
		dutiesPerson.setLostDate(lostDate);
		int flag = dutiesPersonService.update(dutiesPerson);
		final Long userId = (Long) session.getAttribute("userId");
		final String METHOD = "人员退休：";
		if (flag < 1) {
			throw new Exception("退休更新出错");
		} else {
			final Log log = new Log(userId, DUTIESMODULE, dutiesPerson.getPersonId(), METHOD);
			logService.log(log);
		}
		final Unit unit = new Unit();
		unit.setId(unitId);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/adjust/adjustduties";
	}

	@RequestMapping("/regularDuties")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String regularDuties(String dutiesPersonExtendId, String unitId, RedirectAttributes model,
			HttpSession session) throws Exception {
		DutiesPerson dutiesPerson = dutiesPersonService.selectById(dutiesPersonExtendId);
		dutiesPerson.setIsProbation("否");
		dutiesPerson.setProbationDate(null);
		int flag = dutiesPersonService.updateByPrimaryKey(dutiesPerson);
		final Long userId = (Long) session.getAttribute("userId");
		final String METHOD = "人员转正：";
		if (flag < 1) {
			throw new Exception("转正更新出错");
		} else {
			final Log log = new Log(userId, DUTIESMODULE, dutiesPerson.getPersonId(), METHOD);
			logService.log(log);
		}
		final Unit unit = new Unit();
		unit.setId(unitId);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/adjust/adjustduties";
	}

	// 免职（未修改人员表中的state）
	@RequestMapping("/delDuties")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String delDuties(String dutiesPersonExtendId, String unitId, RedirectAttributes model, HttpSession session)
			throws Exception {
		DutiesPerson dutiesPerson = dutiesPersonService.selectById(dutiesPersonExtendId);
		Date lostDate = ApplicationUtils.getYMD();
		dutiesPerson.setLostDate(lostDate);
		final Long userId = (Long) session.getAttribute("userId");
		final String METHOD = "人员免职：";
		int flag = dutiesPersonService.update(dutiesPerson);
		if (flag < 1) {
			throw new Exception("退休更新出错");
		} else {
			final Log log = new Log(userId, DUTIESMODULE, dutiesPerson.getPersonId(), METHOD);
			logService.log(log);
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
		if (personName != null || !"".equals(personName)) {
			persons = personService.selectPersonsByName(personName);
		}
		return persons;
	}

	@RequestMapping("/addDutiesPerson")
	public String addDutiesPerson(DutiesPerson dutiesPerson, String unitId, RedirectAttributes model,
			HttpSession session) {
		dutiesPerson.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		final Long userId = (Long) session.getAttribute("userId");
		final String METHOD = "人员任职：";
		final List<DutiesUnit> duties = dutiesUnitService.selectList(unitId);
		final List<DutiesPerson> dutiesPersons = dutiesPersonService.selectPersons(duties);
		if (dutiesPersons != null && dutiesPersons.size() > 0) {
			dutiesPerson.setSort(dutiesPersons.get(dutiesPersons.size() - 1).getSort() + 1);
		} else {
			dutiesPerson.setSort(0);
		}
		int flag = dutiesPersonService.insert(dutiesPerson);
		if (flag == 1) {
			final Log log = new Log(userId, DUTIESMODULE, dutiesPerson.getPersonId(), METHOD);
			logService.log(log);
		}
		final Unit unit = new Unit();
		unit.setId(unitId);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/adjust/adjustduties";
	}

	// 退休（未修改人员表中的state）
	@RequestMapping("/lostJob")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String lostJob(String jobPersonExtendId, String unitId, RedirectAttributes model, HttpSession session)
			throws Exception {
		JobPerson jobPerson = jobPersonService.selectById(jobPersonExtendId);
		Date lostDate = ApplicationUtils.getYMD();
		final Long userId = (Long) session.getAttribute("userId");
		final String METHOD = "人员退休：";
		jobPerson.setLostDate(lostDate);
		int flag = jobPersonService.update(jobPerson);
		if (flag < 1) {
			throw new Exception("退休更新出错");
		} else {
			final Log log = new Log(userId, JOBMODULE, jobPerson.getPersonId(), METHOD);
			logService.log(log);
		}
		final Unit unit = new Unit();
		unit.setId(unitId);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/adjust/adjustJobs";
	}

	@RequestMapping("/regularJob")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String regularJob(String jobPersonExtendId, String unitId, RedirectAttributes model, HttpSession session)
			throws Exception {
		JobPerson jobPerson = jobPersonService.selectById(jobPersonExtendId);
		jobPerson.setIsProbation("否");
		jobPerson.setProbationDate(null);
		final Long userId = (Long) session.getAttribute("userId");
		final String METHOD = "人员转正：";
		int flag = jobPersonService.updateByPrimaryKey(jobPerson);
		if (flag < 1) {
			throw new Exception("转正更新出错");
		} else {
			final Log log = new Log(userId, JOBMODULE, jobPerson.getPersonId(), METHOD);
			logService.log(log);
		}
		final Unit unit = new Unit();
		unit.setId(unitId);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/adjust/adjustJobs";
	}

	// 免职（未修改人员表中的state）
	@RequestMapping("/delJob")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String delJob(String jobPersonExtendId, String unitId, RedirectAttributes model, HttpSession session)
			throws Exception {
		JobPerson jobPerson = jobPersonService.selectById(jobPersonExtendId);
		Date lostDate = ApplicationUtils.getYMD();
		jobPerson.setLostDate(lostDate);
		final Long userId = (Long) session.getAttribute("userId");
		final String METHOD = "人员退休：";
		int flag = jobPersonService.update(jobPerson);
		if (flag < 1) {
			throw new Exception("退休更新出错");
		} else {
			final Log log = new Log(userId, JOBMODULE, jobPerson.getPersonId(), METHOD);
			logService.log(log);
		}
		final Unit unit = new Unit();
		unit.setId(unitId);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/adjust/adjustJobs";
	}

	@RequestMapping("/adjustjobs")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String adjustjobs(@ModelAttribute("unit") Unit unit, Model model) {
		List<JobPersonExtend> jobPersonExtends = new ArrayList<JobPersonExtend>();
		if (unit != null && unit.getId() != null && !"".equals(unit.getId())) {
			final List<JobUnit> jobs = jobUnitService.selectList(unit.getId());
			final List<JobPerson> jobPersons = jobPersonService.selectPersons(jobs);
			if (jobPersons.size() > 0 || jobPersons != null) {
				for (JobPerson jobPerson : jobPersons) {
					JobPersonExtend jobPersonExtend = new JobPersonExtend(jobPerson);
					Person person = personService.selectById(jobPerson.getPersonId());
					JobUnit jobUnit = jobUnitService.selectById(jobPerson.getJobId());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String ownDateStr = sdf.format(jobPerson.getOwnDate());
					jobPersonExtend.setOwnDateStr(ownDateStr);
					if (jobPerson.getProbationDate() != null) {
						String probationDateStr = sdf.format(jobPerson.getProbationDate());
						jobPersonExtend.setProbationDateStr(probationDateStr);
					}
					jobPersonExtend.setPersonName(person.getName());
					jobPersonExtend.setJobName(jobUnit.getName());
					jobPersonExtends.add(jobPersonExtend);
				}
			}
			unit = unitService.selectById(unit.getId());
			model.addAttribute("unit", unit);
			model.addAttribute("jobPersonExtends", jobPersonExtends);
			model.addAttribute("jobs", jobs);
		}
		return "adjustJobs";
	}

	@RequestMapping("/jobSave")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String jobSave(String unitId, JobPersonExtendList jobPersonExtends, RedirectAttributes model,
			HttpSession session) throws Exception {
		if (unitId != null && !"".equals(unitId)) {
			if (jobPersonExtends.getJobPersonExtends() != null && jobPersonExtends.getJobPersonExtends().size() > 0) {
				final ResultMessage message = new ResultMessage();
				final Long userId = (Long) session.getAttribute("userId");
				final String METHOD = "更新内部人员岗位排序：";
				message.edit();
				if (jobPersonService.modify(jobPersonExtends.getJobPersonExtends())) {
					message.success();
					final Log log = new Log(userId, JOBMODULE, unitId, METHOD);
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
		return "redirect:/rest/adjust/adjustjobs";
	}

	@RequestMapping("/addJobPerson")
	public String addJobPerson(JobPerson jobPerson, String unitId, RedirectAttributes model, HttpSession session) {
		jobPerson.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		final List<JobUnit> jobs = jobUnitService.selectList(unitId);
		final List<JobPerson> jobPersons = jobPersonService.selectPersons(jobs);
		final Long userId = (Long) session.getAttribute("userId");
		final String METHOD = "人员转正：";
		if (jobPersons != null && jobPersons.size() > 0) {
			jobPerson.setSort(jobPersons.get(jobPersons.size() - 1).getSort() + 1);
		} else {
			jobPerson.setSort(0);
		}
		int flag = jobPersonService.insert(jobPerson);
		if (flag == 1) {
			final Log log = new Log(userId, JOBMODULE, jobPerson.getPersonId(), METHOD);
			logService.log(log);
		}
		final Unit unit = new Unit();
		unit.setId(unitId);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/adjust/adjustduties";
	}

}
