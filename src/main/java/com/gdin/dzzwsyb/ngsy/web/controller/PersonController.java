package com.gdin.dzzwsyb.ngsy.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.ngsy.web.model.Log;
import com.gdin.dzzwsyb.ngsy.web.model.Person;
import com.gdin.dzzwsyb.ngsy.web.model.ResultMessage;
import com.gdin.dzzwsyb.ngsy.web.security.RoleSign;
import com.gdin.dzzwsyb.ngsy.web.service.EducationService;
import com.gdin.dzzwsyb.ngsy.web.service.LogService;
import com.gdin.dzzwsyb.ngsy.web.service.PersonService;
import com.gdin.dzzwsyb.ngsy.web.service.RankService;
import com.gdin.dzzwsyb.ngsy.web.service.ResumeService;
import com.gdin.dzzwsyb.ngsy.web.service.TechnicalTitleService;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

	@Resource
	private PersonService personService;
	@Resource
	private TechnicalTitleService technicalTitleService;
	@Resource
	private EducationService educationService;
	@Resource
	private RankService rankService;
	@Resource
	private ResumeService resumeService;
	@Resource
	private LogService logService;

	final static private String MODULE = "person";

	@RequestMapping(value = "/checkIdCard")
	@RequiresRoles(value = RoleSign.ADMIN)
	@ResponseBody
	public Boolean admin(Person person) {
		return personService.checkIdCard(person) == 0;
	}

	@RequestMapping(value = "/save")
	@RequiresRoles(value = RoleSign.ADMIN)
	@Transactional(rollbackFor = { Exception.class })
	public String save(Person person, RedirectAttributes model, HttpSession session) throws Exception {
		if (person != null) {
			ResultMessage message = new ResultMessage();
			final Long userId = (Long) session.getAttribute("userId");
			if (person.getId() != null && !"".equals(person.getId())) {
				final String METHOD = "修改人员：";
				message.edit();
				int flag = personService.update(person);
				if (flag > 0) {
					if (person.getTechnicalTitles() != null && person.getTechnicalTitles().size() > 0) {
						flag += technicalTitleService.modify(person.getTechnicalTitles(), person.getId());
					}
					if (person.getEducations() != null && person.getEducations().size() > 0) {
						flag += educationService.modify(person.getEducations(), person.getId());
					}
					if (person.getRanks() != null && person.getRanks().size() > 0) {
						flag += rankService.modify(person.getRanks(), person.getId());
					}
					if (person.getResumes() != null && person.getResumes().size() > 0) {
						flag += resumeService.modify(person.getResumes(), person.getId());
					}
					message.success();
					final Log log = new Log(userId, MODULE, person.getId(), METHOD + person.getName());
					logService.log(log);
				} else {
					message.failure();
					model.addFlashAttribute("person", person);
					model.addFlashAttribute("message", message);
					return "redirect:/rest/person/back";
				}
			} else {
				person.setId(ApplicationUtils.newUUID());
				final String METHOD = "新增人员：";
				message.add();
				int flag = personService.insert(person);
				if (flag > 0) {
					if (person.getTechnicalTitles() != null && person.getTechnicalTitles().size() > 0) {
						flag += technicalTitleService.modify(person.getTechnicalTitles(), person.getId());
					}
					if (person.getEducations() != null && person.getEducations().size() > 0) {
						flag += educationService.modify(person.getEducations(), person.getId());
					}
					if (person.getRanks() != null && person.getRanks().size() > 0) {
						flag += rankService.modify(person.getRanks(), person.getId());
					}
					if (person.getResumes() != null && person.getResumes().size() > 0) {
						flag += resumeService.modify(person.getResumes(), person.getId());
					}
					message.success();
					final Log log = new Log(userId, MODULE, person.getId(), METHOD + person.getName());
					logService.log(log);
				} else {
					message.failure();
					model.addFlashAttribute("person", person);
					model.addFlashAttribute("message", message);
					return "redirect:/rest/person/back";
				}
			}
			model.addFlashAttribute("person", person);
			model.addFlashAttribute("message", message);
			return "redirect:/rest/person/get";
		} else {
			return "redirect:/rest/page/addPerson";
		}
	}

	@RequestMapping(value = "/back")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String back(@ModelAttribute("person") Person person, @ModelAttribute("message") ResultMessage message,
			Model model) {
		model.addAttribute("person", person);
		model.addAttribute("message", message);
		return "addPerson";
	}

	@RequestMapping(value = "/get")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String get(@ModelAttribute("person") Person person, @ModelAttribute("message") ResultMessage message,
			Model model) {
		person = personService.selectById(person.getId());
		if (person != null) {
			model.addAttribute("person", person);
			model.addAttribute("message", message);
			return "person";
		} else {
			return "addPerson";
		}

	}

	@RequestMapping(value = "/edit")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String edit(Person person, Model model) {
		person = personService.selectById(person.getId());
		if (person != null) {
			if (person.getId() != null && !"".equals(person.getId())) {
				person = personService.selectById(person.getId());
				person.setTechnicalTitles(technicalTitleService.selectByPersonId(person.getId()));
				person.setEducations(educationService.selectByPersonId(person.getId()));
				person.setRanks(rankService.selectByPersonId(person.getId()));
				person.setResumes(resumeService.selectByPersonId(person.getId()));
			}
			model.addAttribute("person", person);
		}
		return "addPerson";
	}

}
