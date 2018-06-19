package com.gdin.dzzwsyb.ngsy.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdin.dzzwsyb.ngsy.core.entity.JSONResult;
import com.gdin.dzzwsyb.ngsy.web.model.Node;
import com.gdin.dzzwsyb.ngsy.web.model.Unit;
import com.gdin.dzzwsyb.ngsy.web.security.RoleSign;
import com.gdin.dzzwsyb.ngsy.web.service.UnitService;

@Controller
@RequestMapping(value = "/unit")
public class UnitController {

	@Resource
	private UnitService unitService;

	final static private String MODULE = "unit";
	
	@RequestMapping("/index")
	@RequiresRoles(value = RoleSign.ADMIN)
	public String index() {
		return "unit";
	}

	@RequestMapping("/menu")
	@ResponseBody
	public ArrayList<Node> getMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return getTreeJson();// 获得一棵树模型的数据
		// json.setData(tree);
		/*
		 * JSONResult<Node> jsonResult = new JSONResult<Node>();
		 * jsonResult.setData(tree); return jsonResult;
		 */

	}

	public ArrayList<Node> getTreeJson() {
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
	public String newUnit() {
		return null;
	}

}
