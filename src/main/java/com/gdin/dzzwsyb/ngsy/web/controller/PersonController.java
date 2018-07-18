package com.gdin.dzzwsyb.ngsy.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdin.dzzwsyb.ngsy.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.ngsy.core.util.HandleFile;
import com.gdin.dzzwsyb.ngsy.web.model.Log;
import com.gdin.dzzwsyb.ngsy.web.model.PeopleExtends;
import com.gdin.dzzwsyb.ngsy.web.model.Person;
import com.gdin.dzzwsyb.ngsy.web.model.ResultMessage;
import com.gdin.dzzwsyb.ngsy.web.model.TechnicalTitle;
import com.gdin.dzzwsyb.ngsy.web.properties.SourceURL;
import com.gdin.dzzwsyb.ngsy.web.security.RoleSign;
import com.gdin.dzzwsyb.ngsy.web.service.DutiesPersonService;
import com.gdin.dzzwsyb.ngsy.web.service.EducationService;
import com.gdin.dzzwsyb.ngsy.web.service.FamilyService;
import com.gdin.dzzwsyb.ngsy.web.service.JobPersonService;
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
	private FamilyService familyService;
	@Resource
	private JobPersonService jobPersonService;
	@Resource
	private DutiesPersonService dutiesPersonService;
	@Resource
	private LogService logService;

	@Autowired
	private SourceURL sourceURL;

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
	public String save(Person person, @RequestParam(value = "photo", required = false) MultipartFile file,
			RedirectAttributes model, HttpSession session) throws Exception {
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
					if (person.getFamilies() != null && person.getFamilies().size() > 0) {
						flag += familyService.modify(person.getFamilies(), person.getId());
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
					if (person.getFamilies() != null && person.getFamilies().size() > 0) {
						flag += familyService.modify(person.getFamilies(), person.getId());
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
			if (file != null && !file.isEmpty()) {
				HandleFile.savePhoto(file, person.getId(), sourceURL.PHOTO_URL);
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
			person.setEducations(educationService.getSingleMessage(person.getId()));
			person.setRanks(rankService.getSingleMessage(person.getId()));
			person.setFamilies(familyService.selectByPersonId(person.getId()));
			person.setResumes(resumeService.selectByPersonId(person.getId()));
			person.setJobs(jobPersonService.selectJobsByPersonId(person.getId(), true));
			person.setDuties(dutiesPersonService.selectDutiesByPersonId(person.getId(), true));
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
				person.setFamilies(familyService.selectByPersonId(person.getId()));
			}
			model.addAttribute("person", person);
		}
		return "addPerson";
	}

	@RequestMapping(value = "/photo")
	@RequiresRoles(value = RoleSign.ADMIN)
	public void photo(Person person, HttpServletResponse response, HttpServletRequest request) throws IOException {
		if (person != null && person.getId() != null && !"".equals(person.getId())) {
			person = personService.selectById(person.getId());
			if (person != null) {
				File photo = new File(sourceURL.PHOTO_URL + person.getId());
				if (photo.exists()) {
					BufferedImage bufferedImage = ImageIO.read(photo);
					ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
					return;
				}
			}
		}
		File photo = new File(request.getServletContext().getRealPath(sourceURL.PHOTO_URL_DEFAULT));
		BufferedImage bufferedImage = ImageIO.read(photo);
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
		return;
	}

	@RequestMapping(value = "/find")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String find(PeopleExtends peopleExtends, Integer pageNo, Model model) {
		Page<Person> page = personService.selectPage(peopleExtends, pageNo);
		List<Person> persons = page.getResult();
		if(peopleExtends.getTechnical_title() != null && !("").equals(peopleExtends.getTechnical_title())) {
			List<Person> personsList = technicalTitleService.check(persons, peopleExtends.getTechnical_title());		
			if(personsList != null || personsList.size()>0) {
				Page<TechnicalTitle> page2 = technicalTitleService.selectPage(personsList, pageNo, peopleExtends.getTechnical_title());		
				model.addAttribute("people", personsList);
				model.addAttribute("page", page2);
				model.addAttribute("query", peopleExtends);
			}
		}
		else {
			model.addAttribute("people",persons);
			model.addAttribute("page", page);
			model.addAttribute("query", peopleExtends);
		}
		
		return "findPerson";
	}

}
