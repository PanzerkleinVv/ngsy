<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainContent">
	<div class="navigationBar">
		<c:choose>
			<c:when test="${unit != null && unit.id != null && unit.id ne ''}">
				<span class="navigationItem">${unit.simpleName} 机构设置</span>
			</c:when>
			<c:otherwise>
				<span class="navigationItem">新增机构</span>
			</c:otherwise>
		</c:choose>
		<c:if test="${message != null && message.msg ne 'nullnull'}">
			<span style="color:${message.color};">${message.msg}</span>
		</c:if>
	</div>
	<div class="singleFormGroup">
		<input type="hidden" id="id"
			value="<c:if test='${unit != null && unit.id != null && unit.id ne ""}'>${unit.id}</c:if>" />
		<div>
			<span>机构名：</span>
		</div>
		<div>
			<input type="text" id="name" class="form-control"
				value="<c:if test='${unit != null}'>${unit.name}</c:if>"
				onblur="check(this)" /><span></span>
		</div>
		<div>
			<span>机构简称：</span>
		</div>
		<div>
			<input type="text" id="simpleName" class="form-control"
				value="<c:if test='${unit != null}'>${unit.simpleName}</c:if>"
				onblur="check(this)" /><span></span>
		</div>
		<div>
			<span>上层机构：</span>
		</div>
		<div>
			<input type="text" id="superiorName" class="form-control"
				value="<c:if test='${unit != null}'>${unit.superiorName}</c:if>"
				placeholder="点击选择" onclick="find()" /> <input type="hidden"
				id="superiorId"
				value="<c:if test='${unit != null}'>${unit.superiorId}</c:if>" />
		</div>
		<c:if test="${unit != null && unit.id != null && unit.id ne ''}">
			<div>
				<span>状态：</span>
			</div>
			<div>
				<c:choose>
					<c:when test="${unit.isUsed == 1}">
						<span>启用</span>
						<button type="button" class="btn red" onclick="used(0)">停用</button>
					</c:when>
					<c:otherwise>
						<span>停用</span>
						<button type="button" class="btn green" onclick="used(1)">启用</button>
					</c:otherwise>
				</c:choose>
			</div>
		</c:if>
		<div>
			<button type="button" class="btn green" onclick="save()">保存</button>
		</div>
	</div>
	<div class="modal fade" id="superiorModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 300px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h4 class="modal-title" id="myModalLabel">选择上层机构</h4>
				</div>
				<div class="modal-body" id="modal_body">
					<div id="superiorTree" class="ztree"
						style="height: 300px; overflow: auto"></div>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal">关闭</button>
					<button id="okBtn" class="btn btn-primary">确定</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>

	<script type="text/javascript">
		function check(target) {
			var msg = $(target).next("span");
			var value = $(target).val();
			if (value == null || value.length < 1) {
				msg.html("不能为空！");
				msg.css('color', '#FF0000');
				return false;
			} else {
				msg.html("OK");
				msg.css('color', '#00FF00');
				return true;
			}
		}

		function used(isUsed) {
			var url = "rest/unit/setUsed";
			var id = $("#id").val();
			$.post(url, {
				'id' : id,
				'name' : name,
				'isUsed' : isUsed
			}, function(data) {
				$("#unitContent").html(data);
			});
		}

		function save() {
			if (check($("#name")) && check($("#simpleName"))) {
				var url = "rest/unit/save";
				var id = $("#id").val();
				var name = $("#name").val();
				var simpleName = $("#simpleName").val();
				var superiorId = $("#superiorId").val();
				$.post(url, {
					'id' : id,
					'name' : name,
					'simpleName' : simpleName,
					'superiorId' : superiorId
				}, function(data) {
					$("#unitContent").html(data);
				});
				return true;
			} else {
				return false;
			}
		}

		var superiorSetting = {
			view : {
				dblClickExpand : false,
				selectedMulti : false
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
				onClick : function(e, treeId, treeNode, clickFlag) {
					var superiorTree = $.fn.zTree.getZTreeObj("superiorTree");
					superiorTree.checkNode(treeNode, !treeNode.checked, true);
				}
			}
		};

		function find() {
			var id = $("#superiorId").val();
			$.ajax({
				type : "Post",
				url : 'rest/unit/menu',
				dataType : "json",
				success : function(result) {
					$.fn.zTree
							.init($("#superiorTree"), superiorSetting, result);
					if (id != null && id.length > 0) {
						var superiorTree = $.fn.zTree
								.getZTreeObj("superiorTree");
						var superiorNode = superiorTree
								.getNodeByParam("id", id);
						superiorTree.checkNode(superiorNode,
								!superiorNode.checked, true);
					}
					$('#superiorModal').modal('show');
				},
				error : function() {
					alert("菜单加载失败！")
				}
			});

		}

		$("#okBtn").click(function() {
			var superiorTree = $.fn.zTree.getZTreeObj("superiorTree");
			checkCount = superiorTree.getCheckedNodes(true);
			if (checkCount.length == 0) {
				$("#superiorId").val("");
				$("#superiorName").val("");
			} else {
				var superiorNode = checkCount[0];
				$("#superiorId").val(superiorNode.id);
				$("#superiorName").val(superiorNode.name);
			}
			$('#superiorModal').modal('hide');
		});
	</script>
</div>