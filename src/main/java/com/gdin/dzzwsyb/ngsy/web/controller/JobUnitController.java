package com.gdin.dzzwsyb.ngsy.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdin.dzzwsyb.ngsy.web.model.JobUnit;
import com.gdin.dzzwsyb.ngsy.web.model.JobUnitList;
import com.gdin.dzzwsyb.ngsy.web.model.Log;
import com.gdin.dzzwsyb.ngsy.web.model.ResultMessage;
import com.gdin.dzzwsyb.ngsy.web.model.Unit;
import com.gdin.dzzwsyb.ngsy.web.security.RoleSign;
import com.gdin.dzzwsyb.ngsy.web.service.JobPersonService;
import com.gdin.dzzwsyb.ngsy.web.service.JobUnitService;
import com.gdin.dzzwsyb.ngsy.web.service.LogService;
import com.gdin.dzzwsyb.ngsy.web.service.UnitService;

@Controller
@RequestMapping(value = "/jobUnit")
public class JobUnitController {

	@Resource
	private JobUnitService jobUnitService;
	@Resource
	private JobPersonService jobPersonService;
	@Resource
	private UnitService unitService;
	@Resource
	private LogService logService;

	final static private String MODULE = "job_unit";

	@RequestMapping("/list")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String list(@ModelAttribute("unit") Unit unit, Model model,
			@ModelAttribute("message") ResultMessage message) {
		if (unit != null && unit.getId() != null && !"".equals(unit.getId())) {
			final List<JobUnit> jobs = jobUnitService.selectList(unit.getId());
			unit = unitService.selectById(unit.getId());
			model.addAttribute("unit", unit);
			model.addAttribute("jobs", jobs);
		}
		model.addAttribute("message", message);
		return "unitJobs";
	}

	@RequestMapping("/save")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String save(String unitId, JobUnitList jobUnits, RedirectAttributes model, HttpSession session)
			throws Exception {
		if (unitId != null && !"".equals(unitId)) {
			if (jobUnits.getJobUnits() != null && jobUnits.getJobUnits().size() > 0) {
				final ResultMessage message = new ResultMessage();
				final Long userId = (Long) session.getAttribute("userId");
				final String METHOD = "更新岗位：";
				message.edit();
				if (jobUnitService.modify(jobUnits.getJobUnits(), unitId)) {
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
		return "redirect:/rest/jobUnit/list";
	}
	
	@ResponseBody
	@RequestMapping("/checkUsed")
	@RequiresRoles(value = RoleSign.ADMIN)
	public Boolean checkUsed(JobUnit jobUnit) {
		long count = jobPersonService.countXianrenByJobId(jobUnit.getId());
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}
}
