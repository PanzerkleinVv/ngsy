package com.gdin.dzzwsyb.ngsy.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdin.dzzwsyb.ngsy.web.dao.UnitMapper;
import com.gdin.dzzwsyb.ngsy.web.model.Node;
import com.gdin.dzzwsyb.ngsy.web.model.Unit;
import com.gdin.dzzwsyb.ngsy.web.service.UnitService;

@Controller
@RequestMapping("/unit")
public class UnitController {
	@Resource
	private UnitService unitService;
	
	@RequestMapping("/menu")
    public void getMenu(HttpServletRequest request,HttpServletResponse response) throws Exception{
        Node tree = getTreeJson();//获得一棵树模型的数据
        //json.setData(tree);
        
        
    }
    

     public Node getTreeJson() {
         List<Unit> reslist = unitService.findIsUsed();//从数据库获取所有资源
         ArrayList<Node> nodes = new ArrayList<Node>();//把所有资源转换成树模型的节点集合，此容器用于保存所有节点
         for(Unit res : reslist){
             Node node = new Node();
             node.setNodeId(res.getId());
             node.setPid(res.getSuperiorId());
             node.setText(res.getName());
             nodes.add(node);//添加到节点容器
         }
         Node tree = new Node();//重要插件，创建一个树模型
         Node mt = tree.createTree(nodes);//Node类里面包含了一个创建树的方法。这个方法就是通过节点的信息（nodes）来构建一颗多叉树manytree->mt。
         //System.out.println(tree.iteratorTree(mt));
         return mt;
     }
    
}
