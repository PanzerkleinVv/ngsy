<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#unitNav a:hover {
	font-size: 18px;
}
</style>
<div class="mainContent">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2-3 ">
					<div id="treeDemo" class="ztree"></div>
				</div>
				<div class="col-md-9-10">
					<nav id="unitNav" class="navbar navbar-default"
						style="height: 20px">
						<div class="container-fluid">
							<div class="collapse navbar-collapse"
								id="bs-example-navbar-collapse-1">
								<ul class="nav navbar-nav">
									<li class="active"><a href="rest/unit/people">机构成员</a></li>
									<li class="dropdown">
                          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">人员调整<span class="caret"></span></a>
                         			 	<ul class="dropdown-menu">
                            				<li><a href="rest/unit/adjustduties">职务调整</a></li>
                            				<li role="separator" class="divider"></li>
                              				<li><a href="rest/unit/adjustjob">岗位调整</a></li>
                          				</ul>
                  					</li>
                  
									<li><a href="rest/unit/setUnit">机构设置</a></li>
									<li><a href="rest/unit/sortUnit">机构排序</a></li>
									<li><a href="rest/unit/newUnit">新增机构</a></li>
									<li><a href="rest/unit/duties">职务设置</a></li>
									<li><a href="rest/unit/job">岗位设置</a></li>
								</ul>
							</div>
						</div>
						<!-- /.container-fluid -->
					</nav>
					<div id="unitContent">请选择机构……</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$("#unitNav a:eq(1)").click(function() {
			$("#unitNav li").removeClass("active");
		});
		$("#unitNav a").not("#unitNav a:eq(1)").click(function() {
			var url = $(this).attr("href");
			$("#unitNav li").removeClass("active");
			$(this).parent().addClass("active");
			if (url == "rest/unit/newUnit") {
				$.post(url, function(data) {
					$("#unitContent").html(data);
				});
			}
			else {
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				checkCount = zTree.getCheckedNodes(true);
				var ids = ['1','2'];
				if (checkCount.length > 0) {
					var unitId = checkCount[0].id;
					if(url == "rest/unit/adjustduties"){
						$.post(url, {
							"id" : unitId,
							"ids": ids
						}, function(data) {
							$("#unitContent").html(data);
						});
					}
					else{
						$.post(url, {
							"id" : unitId
						}, function(data) {
							$("#unitContent").html(data);
						});
					}
					
				}
			}
			return false;
		});
		$(function() {
			$("#index-page-title").html("机构管理");
			$("#current-page-title").html("机构管理");
		});
		//选中/取消父节点时选中/取消所有子节点
		var setting = {
			view : {
				selectedMulti : false,
				addDiyDom: addDiyDom
			},
			check : {
				enable : true,
				chkStyle : "radio", //单选框
				radioType : "all" //对所有节点设置单选
			},
			data : {
				simpleData : {
					enable : true
				}
			},
			edit : {
				enable : false
			},
			callback : {
				/* beforeCheck : function(treeId, treeNode) {
				                    if (treeNode.isParent) {
				                        alert("请选择子节点！")
				                        return false;
				                    }
				                }, */
				onClick : function(e, treeId, treeNode, clickFlag) {
					zTree.checkNode(treeNode, !treeNode.checked, true);
					$("#unitNav .active>a").click();
				},
				onCheck : function(e, treeId, treeNode, clickFlag) {
					if (treeNode.checked) {
						$("#unitNav .active>a").click();
					}
				}
			}
		};
		//节点数太长省略号
		function addDiyDom(treeId, treeNode) {
            var spaceWidth = 5;
            var switchObj = $("#" + treeNode.tId + "_switch"),
            checkObj = $("#" + treeNode.tId + "_check"),
            icoObj = $("#" + treeNode.tId + "_ico");
            switchObj.remove();
            checkObj.remove();
            icoObj.parent().before(switchObj);
            icoObj.parent().before(checkObj);

            var spantxt = $("#" + treeNode.tId + "_span").html();
            if (spantxt.length > 8) {
                spantxt = spantxt.substring(0, 6) + "...";
                $("#" + treeNode.tId + "_span").html(spantxt);
            }
        
  }
		$(document).ready(function() {
			$.ajax({
				type : "Post",
				url : 'rest/unit/menu',
				dataType : "json",
				success : function(result) {
					console.log(result);
					zTree = $.fn.zTree.init($("#treeDemo"), setting, result);
				},
				error : function() {
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