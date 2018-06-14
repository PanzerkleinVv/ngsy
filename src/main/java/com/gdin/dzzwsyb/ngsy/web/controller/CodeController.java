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

import com.gdin.dzzwsyb.ngsy.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.ngsy.web.model.Code;
import com.gdin.dzzwsyb.ngsy.web.model.CodeType;
import com.gdin.dzzwsyb.ngsy.web.model.Log;
import com.gdin.dzzwsyb.ngsy.web.model.ResultMessage;
import com.gdin.dzzwsyb.ngsy.web.security.RoleSign;
import com.gdin.dzzwsyb.ngsy.web.service.CodeService;
import com.gdin.dzzwsyb.ngsy.web.service.CodeTypeService;
import com.gdin.dzzwsyb.ngsy.web.service.LogService;

@Controller
@RequestMapping(value = "/code")
public class CodeController {

	@Resource
	private CodeTypeService codeTypeService;
	@Resource
	private CodeService codeService;
	@Resource
	private LogService logService;

	final static private String MODULE = "code_type";

	/**
	 * 字典项类别查询页面
	 * 
	 * @param codeType
	 *            封装查询的字典项类别名称
	 * @param model
	 *            返回视图模型
	 * @return code.jsp
	 */
	@RequestMapping(value = "/admin")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String admin(CodeType codeType, @ModelAttribute ResultMessage message, Model model) {
		List<CodeType> codeTypes = null;
		if (codeType != null) {
			codeTypes = codeTypeService.selectList(codeType.getName());
		} else {
			codeTypes = codeTypeService.selectList();
		}
		model.addAttribute("codeTypes", codeTypes);
		model.addAttribute("message", message);
		model.addAttribute("name", codeType.getName());
		return "code";
	}

	/**
	 * 修改字典项类别名称
	 * 
	 * @param codeType
	 *            封装修改的字典项类别名称和id
	 * @param model
	 *            返回视图模型
	 * @return 重定向到admin
	 */
	@RequestMapping(value = "/editCodeType")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String editCodeType(CodeType codeType, RedirectAttributes model, HttpSession session) {
		final String METHOD = "修改字典项类别名称：";
		final ResultMessage message = new ResultMessage();
		message.edit();
		final Long userId = (Long) session.getAttribute("userId");
		if (codeType != null) {
			final int count = codeTypeService.update(codeType);
			if (count > 0) {
				message.success();
				final Log log = new Log(userId, MODULE, codeType.getId(), METHOD + codeType.getName());
				logService.log(log);
			} else {
				message.failure();
			}
		} else {
			message.failure();
		}
		model.addFlashAttribute("message", message);
		return "redirect:/rest/code/admin";
	}

	/**
	 * 新增字典项类别
	 * 
	 * @param codeType
	 *            封装新增的字典项类别名称
	 * @param model
	 *            返回视图模型
	 * @return 成功重定向到codeList，失败重定向到admin
	 */
	@RequestMapping(value = "/addCodeType")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String addCodeType(CodeType codeType, RedirectAttributes model, HttpSession session) {
		final String METHOD = "新增字典项类别：";
		final ResultMessage message = new ResultMessage();
		message.add();
		final Long userId = (Long) session.getAttribute("userId");
		if (codeType != null) {
			codeType.setId(ApplicationUtils.newUUID());
			final int count = codeTypeService.insert(codeType);
			if (count > 0) {
				message.success();
				final Log log = new Log(userId, MODULE, codeType.getId(), METHOD + codeType.getName());
				logService.log(log);
				model.addFlashAttribute("message", message);
				model.addFlashAttribute("type", codeType.getId());
				return "redirect:/rest/code/codeList";
			} else {
				message.failure();
			}
		} else {
			message.failure();
		}
		model.addFlashAttribute("message", message);
		return "redirect:/rest/code/codeList";
	}

	/**
	 * 删除字典项类别
	 * 
	 * @param codeType
	 *            封装删除的字典项类别id
	 * @param model
	 *            返回视图模型
	 * @return 重定向到admin
	 */
	@RequestMapping(value = "/deleteCodeType")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String deleteCodeType(CodeType codeType, RedirectAttributes model, HttpSession session) {
		final String METHOD = "删除字典项类别：";
		final ResultMessage message = new ResultMessage();
		message.delete();
		final Long userId = (Long) session.getAttribute("userId");
		if (codeType != null) {
			final int count = codeTypeService.delete(codeType.getId());
			if (count > 0) {
				codeService.deleteByType(codeType.getId());
				message.success();
				final Log log = new Log(userId, MODULE, codeType.getId(), METHOD + codeType.getName());
				logService.log(log);
			} else {
				message.failure();
			}
		} else {
			message.failure();
		}
		model.addFlashAttribute("message", message);
		return "redirect:/rest/code/admin";
	}

	/**
	 * 字典项列表管理页面
	 * 
	 * @param code
	 *            封装查询的字典项类别id
	 * @param model
	 *            返回视图模型
	 * @return codeType.jsp
	 */
	@RequestMapping(value = "/codeList")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String codeList(@ModelAttribute Code code, @ModelAttribute ResultMessage message, Model model) {
		List<Code> codes = null;
		if (code != null && !"".equals(code.getType())) {
			codes = codeService.selectList(code.getType());
		} else {
			message.get().failure();
		}
		model.addAttribute("codes", codes);
		model.addAttribute("message", message);
		return "codeType";
	}

	/**
	 * 修改字典项
	 * 
	 * @param code
	 *            封装修改的字典项和id
	 * @param model
	 *            返回视图模型
	 * @return 重定向到codeList
	 */
	@RequestMapping(value = "/editCode")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String editCode(Code code, RedirectAttributes model, HttpSession session) {
		final String METHOD = "修改字典项：";
		final ResultMessage message = new ResultMessage();
		message.edit();
		final Long userId = (Long) session.getAttribute("userId");
		if (code != null) {
			final int count = codeService.update(code);
			if (count > 0) {
				message.success();
				final Log log = new Log(userId, MODULE, code.getType(), METHOD + code.getName());
				logService.log(log);
			} else {
				message.failure();
			}
			model.addFlashAttribute("type", code.getType());
		} else {
			message.failure();
		}
		model.addFlashAttribute("message", message);
		return "redirect:/rest/code/codeList";
	}

	/**
	 * 新增字典项
	 * 
	 * @param code
	 *            封装新增的字典项类别名称
	 * @param model
	 *            返回视图模型
	 * @return 成功重定向到codeList
	 */
	@RequestMapping(value = "/addCode")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String addCode(Code code, RedirectAttributes model, HttpSession session) {
		final String METHOD = "新增字典项：";
		final ResultMessage message = new ResultMessage();
		message.add();
		final Long userId = (Long) session.getAttribute("userId");
		if (code != null) {
			code.setId(ApplicationUtils.newUUID());
			final int count = codeService.insert(code);
			if (count > 0) {
				message.success();
				final Log log = new Log(userId, MODULE, code.getType(), METHOD + code.getName());
				logService.log(log);
			} else {
				message.failure();
			}
			model.addFlashAttribute("type", code.getType());
		} else {
			message.failure();
		}
		model.addFlashAttribute("message", message);
		return "redirect:/rest/code/codeList";
	}

	/**
	 * 删除字典项类别名称
	 * 
	 * @param code
	 *            封装删除的字典项类别id
	 * @param model
	 *            返回视图模型
	 * @return 重定向到codeList
	 */
	@RequestMapping(value = "/deleteCode")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String deleteCode(Code code, RedirectAttributes model, HttpSession session) {
		final String METHOD = "删除字典项：";
		final ResultMessage message = new ResultMessage();
		message.delete();
		final Long userId = (Long) session.getAttribute("userId");
		if (code != null) {
			final int count = codeService.delete(code.getId());
			if (count > 0) {
				message.success();
				final Log log = new Log(userId, MODULE, code.getType(), METHOD + code.getName());
				logService.log(log);
			} else {
				message.failure();
			}
			model.addFlashAttribute("type", code.getType());
		} else {
			message.failure();
		}
		model.addFlashAttribute("message", message);
		return "redirect:/rest/code/codeList";
	}

	/**
	 * 获取指定类别的字典项列表json对象
	 * 
	 * @param code
	 *            封装指定的字典项类别type
	 * @return json 对象
	 */
	@RequestMapping(value = "/get")
	@ResponseBody
	public List<Code> get(Code code) {
		if (code != null) {
			return codeService.selectList(code.getType());
		} else {
			return null;
		}
	}
}
