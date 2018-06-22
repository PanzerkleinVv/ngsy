<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	a:hover{
		font-size:18px;
	}
</style>
<div class="mainContent">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3">
					<div id="treeDemo" class="ztree"></div>
				</div>
				<div class="col-md-9">
					<nav class="navbar navbar-default" style="height:20px">
  						<div class="container-fluid">
  							<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      							<ul class="nav navbar-nav">
      								<li><a href="/rest/unit/newUnit">新增机构</a></li>
									<li><a href="/rest/unit/people">机构成员</a></li>
									<li><a href="/rest/unit/duties">职务设置</a></li>
									<li><a href="/rest/unit/job">岗位设置</a></li>
      							</ul>
      						</div>
  						 </div><!-- /.container-fluid -->
					</nav>
				</div>
			</div>
		</div>
	</div>
	
	
	

	<script type="text/javascript">
		$(function() {
			$("#index-page-title").html("机构设置");
			$("#current-page-title").html("机构设置");
		});
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
			onClick:function (e, treeId, treeNode, clickFlag) { zTree.checkNode(treeNode, !treeNode.checked, true); } 
		}
	};

	$(document).ready(function(){
		  $.ajax({
		      type: "Post",
		      url: 'rest/unit/menu',  
		      dataType: "json",
		      success: function (result) {
		    	  console.log(result);
		    	  zTree = $.fn.zTree.init($("#treeDemo"), setting, result);
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
</div>