<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<div class="mainContent">	
	<div id="treeDemo" class="ztree"></div>
	
</div>
<script type="text/javascript">
//选中/取消父节点时选中/取消所有子节点
	var setting = {
		view: {
			dblClickExpand: false,
			selectedMulti: false
		},
		check: {
			enable: true,
			chkStyle: "radio",  //单选框
	        radioType: "all"   //对所有节点设置单选
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		edit: {
			enable: false
		},
		callback: {
		    beforeCheck : function(treeId, treeNode) {
		                        if (treeNode.isParent) {
		                            alert("请选择子节点！")
		                            return false;
		                        }
		                    },
			onClick:function(event,treeId,treeNode){
	             if(treeNode.ahref){
	                 window.open(treeNode.ahref);
	             }else{
	                 alert("此节点没有链接！")
	             }
	             
	         }
		}
	};

	$(document).ready(function(){
		  $.ajax({
		      type: "Post",
		      url: 'rest/unit/menu',  
		      dataType: "json",
		      success: function (result) {
		    	  console.log(result);
		    	  $.fn.zTree.init($("#treeDemo"), setting, result);
		      },
		      error: function () {
		          alert("菜单加载失败！")
		      }
		  });
		})
	/* var newCount = 1;
	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='add node' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_"+treeNode.tId);
		if (btn) btn.bind("click", function(){
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
			return false;
		});
	};
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	}; */
</script> 