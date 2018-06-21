package com.gdin.dzzwsyb.ngsy.web.controller;

import java.util.ArrayList;
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
import com.gdin.dzzwsyb.ngsy.web.model.Node;
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
	public String admin(CodeType codeType, @ModelAttribute("message") ResultMessage message, Model model) {
		List<CodeType> codeTypes = null;
		if (codeType != null) {
			codeTypes = codeTypeService.selectList(codeType.getName());
		} else {
			codeTypes = codeTypeService.selectList();
		}
		model.addAttribute("codeTypes", codeTypes);
		model.addAttribute("message", message);
		model.addAttribute("name", codeType.getName());
		return "codeType";
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
				model.addFlashAttribute("codeType", codeType);
				return "redirect:/rest/code/codeList";
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
	public String codeList(@ModelAttribute("codeType") CodeType codeType, @ModelAttribute("message") ResultMessage message, Model model) {
		List<Code> codes = null;
		if (codeType != null && !"".equals(codeType.getId())) {
			codeType = codeTypeService.selectById(codeType.getId());
			codes = codeService.selectList(codeType.getId());
		} else {
			message.get().failure();
		}
		model.addAttribute("codeType", codeType);
		model.addAttribute("codes", codes);
		model.addAttribute("message", message);
		return "code";
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
			CodeType codeType = new CodeType();
			codeType.setId(code.getType());
			model.addFlashAttribute("codeType", codeType);
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
			code.setLevel("1");
			final int count = codeService.insert(code);
			if (count > 0) {
				message.success();
				final Log log = new Log(userId, MODULE, code.getType(), METHOD + code.getName());
				logService.log(log);
			} else {
				message.failure();
			}
			CodeType codeType = new CodeType();
			codeType.setId(code.getType());
			model.addFlashAttribute("codeType", codeType);
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
			CodeType codeType = new CodeType();
			codeType.setId(code.getType());
			model.addFlashAttribute("codeType", codeType);
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
	public List<Code> get(CodeType codeType) {
		if (codeType != null) {
			codeType = codeTypeService.selectList(codeType.getName()).get(0);
			return codeService.selectList(codeType.getId());
		} else {
			return null;
		}
	}
	
	/**
	 * 获取人员籍贯字典项列表json对象封装成nodes
	 * 
	 * @param code
	 *           
	 * @return ArrayList<Node> 对象
	 */
	
	@RequestMapping(value = "/getJiGuan")
	@ResponseBody
	public ArrayList<Node> getJiGuan(CodeType codeType) {
		if (codeType != null) {
			codeType = codeTypeService.selectList(codeType.getName()).get(0);
			List<Code> codes= codeService.selectList(codeType.getId());
			ArrayList<Node> nodes = new ArrayList<Node>();//把所有资源转换成树模型的节点集合，此容器用于保存所有节点
	         for(Code res : codes){
	             Node node = new Node();
	             node.setId(res.getCode());
	            /* CodeExample example = new CodeExample();
	             example.createCriteria().andCodeEqualTo(res.getCode().substring(0,4)+"00");*/
	             if(res.getLevel().equals("2")||(res.getLevel().equals("3")))
	            	 node.setpId(res.getCode().substring(0,2)+"0000");
	             else 
	            	node.setpId(res.getCode().substring(0,4)+"00");
	             node.setName(res.getName());
	             node.setOpen(false);
	             nodes.add(node);//添加到节点容器
	         }
	         return nodes;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/getJiGuanByName")
	@ResponseBody
	public List<Code> getJiGuanByName(Code code){
		if (code != null) {
			List<Code> codes = codeService.searchCodeByName(code.getName());
			return codes;
		}
		else 
			return null;
	}
}
