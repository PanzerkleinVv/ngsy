package com.gdin.dzzwsyb.ngsy.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.ngsy.web.model.Log;
import com.gdin.dzzwsyb.ngsy.web.model.Node;
import com.gdin.dzzwsyb.ngsy.web.model.ResultMessage;
import com.gdin.dzzwsyb.ngsy.web.model.Unit;
import com.gdin.dzzwsyb.ngsy.web.security.RoleSign;
import com.gdin.dzzwsyb.ngsy.web.service.DutiesUnitService;
import com.gdin.dzzwsyb.ngsy.web.service.JobUnitService;
import com.gdin.dzzwsyb.ngsy.web.service.LogService;
import com.gdin.dzzwsyb.ngsy.web.service.UnitService;

@Controller
@RequestMapping(value = "/unit")
public class UnitController {

	@Resource
	private UnitService unitService;
	@Resource
	private DutiesUnitService dutiesUnitService;
	@Resource
	private JobUnitService jobUnitService;
	@Resource
	private LogService logService;

	final static private String MODULE = "unit";

	@RequestMapping("/index")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String index() {
		return "unit";
	}

	@RequestMapping("/menu")
	@ResponseBody
	public ArrayList<Node> getMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return getTreeJson();
	}

	private ArrayList<Node> getTreeJson() {
		List<Unit> reslist = unitService.findIsUsed();// 从数据库获取所有资源
		ArrayList<Node> nodes = new ArrayList<Node>();// 把所有资源转换成树模型的节点集合，此容器用于保存所有节点
		for (Unit res : reslist) {
			Node node = new Node();
			node.setId(res.getId());
			node.setpId(res.getSuperiorId());
			node.setName(res.getName());
			node.setOpen(false);
			nodes.add(node);// 添加到节点容器
		}
		return nodes;
	}

	@RequestMapping("/newUnit")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String newUnit(@ModelAttribute("unit") Unit unit, @ModelAttribute("message") ResultMessage message,
			Model model) {
		model.addAttribute("unit", unit);
		model.addAttribute("message", message);
		return "unitInfo";
	}

	@RequestMapping("/setUnit")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String setUnit(@ModelAttribute("unit") Unit unit, Model model,
			@ModelAttribute("message") ResultMessage message) {
		final Unit unit0 = unitService.selectWithSuperiorNameById(unit.getId());
		model.addAttribute("unit", unit0);
		model.addAttribute("message", message);
		return "unitInfo";
	}

	@RequestMapping("/save")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String save(Unit unit, RedirectAttributes model, HttpSession session) {
		final ResultMessage message = new ResultMessage();
		final Long userId = (Long) session.getAttribute("userId");
		if (unit != null) {
			if (unit.getId() == null || "".equals(unit.getId())) {
				final String METHOD = "新增机构：";
				message.add();
				if (unit.getSuperiorId() == null || "".equals(unit.getSuperiorId())) {
					unit.setSuperiorId("0");
				}
				unit.setId(ApplicationUtils.newUUID());
				final int sort = unitService.getMaxSort(unit.getSuperiorId());
				unit.setSort(sort + 1);
				unit.setIsUsed(1);
				final int flag = unitService.insert(unit);
				if (flag > 0) {
					message.success();
					final Log log = new Log(userId, MODULE, unit.getId(), METHOD + unit.getName());
					logService.log(log);
				} else {
					message.failure();
					unit.setId(null);
					model.addFlashAttribute("message", message);
					model.addFlashAttribute("unit", unit);
					return "redirect:/rest/unit/newUnit";
				}
			} else {
				final String METHOD = "修改机构：";
				message.edit();
				final int flag = unitService.update(unit);
				if (flag > 0) {
					message.success();
					final Log log = new Log(userId, MODULE, unit.getId(), METHOD + unit.getName());
					logService.log(log);
				} else {
					message.failure();
				}
			}
		}
		model.addFlashAttribute("message", message);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/unit/setUnit";
	}

	@RequestMapping("/setUsed")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String setUsed(Unit unit, RedirectAttributes model, HttpSession session) {
		final ResultMessage message = new ResultMessage();
		final Long userId = (Long) session.getAttribute("userId");
		String METHOD = null;
		final Unit unit0 = unit;
		unit.setName(null);
		if (unit != null && unit.getId() != null && !"".equals(unit.getId())) {
			if (unit.getIsUsed() == 1) {
				METHOD = "启用机构：";
				message.start();
			} else {
				long count = dutiesUnitService.countUsedByUnitId(unit.getId());
				count += jobUnitService.countUsedByUnitId(unit.getId());
				message.stop();
				if (count > 0L) {
					message.failure().addMsg("该机构含有未停用的行政职务或岗位，无法停用。");
					model.addFlashAttribute("message", message);
					model.addFlashAttribute("unit", unit);
					return "redirect:/rest/unit/setUnit";
				}
				METHOD = "停用机构：";
			}
			final int flag = unitService.update(unit);
			if (flag > 0) {
				message.success();
				final Log log = new Log(userId, MODULE, unit.getId(), METHOD + unit0.getName());
				logService.log(log);
			} else {
				message.failure();
			}
		}
		model.addFlashAttribute("message", message);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/unit/setUnit";
	}

	@RequestMapping("/sortUnit")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String sortUnit(@ModelAttribute("unit") Unit unit, Model model,
			@ModelAttribute("message") ResultMessage message) {
		final List<Unit> units = unitService.getSortList(unit.getId());
		model.addAttribute("units", units);
		model.addAttribute("message", message);
		return "unitSort";
	}

	@RequestMapping("/sort")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String sort(@RequestParam(value = "ids[]") String[] ids, RedirectAttributes model, HttpSession session)
			throws Exception {
		final ResultMessage message = new ResultMessage();
		final Long userId = (Long) session.getAttribute("userId");
		final String METHOD = "机构排序：";
		final int flag = unitService.updateSort(ids);
		message.sort();
		Unit unit = new Unit();
		if (flag != 0) {
			message.success();
			final Log log = new Log(userId, MODULE, unit.getId(), METHOD + ids[0]);
			logService.log(log);
			unit.setId(ids[0]);
		} else {
			message.failure();
		}
		model.addFlashAttribute("message", message);
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/unit/sortUnit";
	}
	
	@RequestMapping("/duties")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String duties(Unit unit, RedirectAttributes model) {
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/dutiesUnit/list";
	}
	
	@RequestMapping("/job")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String job(Unit unit, RedirectAttributes model) {
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/jobUnit/list";
	}
	
	@RequestMapping("/adjustduties")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String adjustduties(Unit unit, RedirectAttributes model) {
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/adjust/adjustduties";
	}
	
	@RequestMapping("/adjustjob")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String adjustjob(Unit unit, RedirectAttributes model) {
		model.addFlashAttribute("unit", unit);
		return "redirect:/rest/adjust/list";
	}

}
