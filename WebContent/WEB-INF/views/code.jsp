<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainContent">
	<div class="navigationBar">
		<span style="cursor: pointer;" id="getAll" class="navigationItem">所有</span>
		<c:if test="${codeType != null && '' ne codeType.id}">
			<span>>></span>
			<span class="navigationItem">${codeType.name} 的字典项</span>
			<input type="hidden" id="type" value="${codeType.id}">
		</c:if>
		<c:if test="${message != null && message.msg ne 'nullnull'}">
			<span style="color:${message.color};">${message.msg}</span>
		</c:if>
	</div>
	<div class="userTable">
		<div class="userRow userHeader">
			<span class="userItem">序号</span> <span class="userItem">字典项名称</span>
			<span class="userItem">字典项代码</span> <span class="userItem">&emsp;</span>
			<span class="userItem">操作</span><span class="userItem">&ensp;</span>
		</div>
		<c:forEach var="code" items="${codes}" varStatus="status">
			<div class="userRow">
				<span class="userItem">${status.count}<input name="id"
					type="hidden" value="${code.id}" /></span> <span
					class="userItem codeForm codeName"> ${code.name} </span> <span
					class="userItem codeForm codeHide"><input name="name"
					size="50" class="input-sm form-inline" value="${codeType.name}" />
				</span><span class="userItem codeForm codeCode"> ${code.code} </span> <span
					class="userItem codeForm codeHide"><input name="code"
					size="50" class="input-sm form-inline" value="${code.code}" /> </span><span
					class="userItem resultMsg"></span> <span class="userItem">
					<button type="button" class="btn green codeForm"
						onclick="edit(this)">修改</button>
					<button type="button" class="btn green codeForm codeHide"
						onclick="save(this)">保存</button>
				</span> <span class="userItem">
					<button type="button" class="btn red codeForm" onclick="del(this)">删除</button>
					<button type="button" class="btn red codeForm codeHide"
						onclick="cancel(this)">取消</button>
				</span>
			</div>
		</c:forEach>
		<div class="userRow">
			<span class="userItem">新增</span> <span class="userItem"><input
				name="name" size="50" class="input-sm form-inline" /> </span><span
				class="userItem"><input name="code" size="50"
				class="input-sm form-inline" /> </span> <span class="userItem"><span
				class="resultMsg"></span> </span> <span class="userItem">
				<button type="button" class="btn green" onclick="add(this)">新增</button>
			</span> <span class="userItem"> &ensp; </span>
		</div>
	</div>

	<script type="text/javascript">
		$("#getAll").click(function() {
			var url = 'rest/code/admin';
			$.get(url, function(data) {
				showData("#main-content", data);
			});
		});

		function edit(target) {
			var rowDiv = $(target).parent().parent();
			rowDiv.find("input[name='name']").val(
					rowDiv.find(".codeName").html());
			rowDiv.find("input[name='code']").val(
					rowDiv.find(".codeCode").html());
			rowDiv.find(".codeForm").toggleClass('codeHide');
		}

		function cancel(target) {
			var rowDiv = $(target).parent().parent();
			rowDiv.find(".codeForm").toggleClass('codeHide');
		}

		function save(target) {
			var rowDiv = $(target).parent().parent();
			var id = rowDiv.find("input[name='id']").val();
			var name = rowDiv.find("input[name='name']").val();
			var code = rowDiv.find("input[name='code']").val();
			var msg = rowDiv.find(".resultMsg");
			var type = $("#type").val();
			if (name == null || name.length < 1) {
				msg.html("名称不能为空！");
				msg.css('color', '#FF0000');
				return false;
			} else if (code == null || code.length < 1) {
				msg.html("代码不能为空！");
				msg.css('color', '#FF0000');
				return false;
			} else {
				msg.html("OK");
				msg.css('color', '#00FF00');
				var url = "rest/code/editCode";
				$.post(url, {
					'id' : id,
					'name' : name,
					'code' : code,
					'type' : type
				}, function(data) {
					showData("#main-content", data);
				});
				return true;
			}
		}

		function add(target) {
			var rowDiv = $(target).parent().parent();
			var name = rowDiv.find("input[name='name']").val();
			var code = rowDiv.find("input[name='code']").val();
			var type = $("#type").val();
			var msg = rowDiv.find(".resultMsg");
			if (name == null || name.length < 1) {
				msg.html("名称不能为空！");
				msg.css('color', '#FF0000');
				return false;
			} else if (code == null || code.length < 1) {
				msg.html("代码不能为空！");
				msg.css('color', '#FF0000');
				return false;
			} else {
				msg.html("OK");
				msg.css('color', '#00FF00');
				var url = "rest/code/addCode";
				$.post(url, {
					'name' : name,
					'code' : code,
					'type' : type
				}, function(data) {
					showData("#main-content", data);
				});
				return true;
			}
		}

		function del(target) {
			var rowDiv = $(target).parent().parent();
			var id = rowDiv.find("input[name='id']").val();
			var name = rowDiv.find("input[name='name']").val();
			var url = "rest/code/deleteCode";
			var type = $("#type").val();
			$.get(url, {
				'id' : id,
				'name' : name,
				'type' : type
			}, function(data) {
				showData("#main-content", data);
			});
			return true;
		}

		$(function() {
			$("#index-page-title").html("字典管理");
			$("#current-page-title").html("字典管理");
		});
	</script>
</div>