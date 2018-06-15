<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainContent">
	<div class="">
		<form action="" method="post">
			<input name="name" id="name" size="25" value="${name}"
				class="input-sm form-inline" type="text" autocomplete="off"
				placeholder="查找字典项类别名称" />
			<button id="searchBut" type="button" class="btn blue form-inline">查询</button>
		</form>
	</div>
	<div class="navigationBar">
		<span style="cursor: pointer;" id="getAll" class="navigationItem">所有</span>
		<c:if test="${name != null && '' ne name}">
			<span>>></span>
			<span class="navigationItem">${name} 查询结果</span>
		</c:if>
		<c:if test="${message != null && message.msg ne 'nullnull'}">
			<span style="color:${message.color};">${message.msg}</span>
		</c:if>
	</div>
	<div class="userTable">
		<div class="userRow userHeader">
			<span class="userItem">序号</span> <span class="userItem">字典项类别名称</span>
			<span class="userItem">&ensp;</span> <span class="userItem">操作</span><span
				class="userItem">&ensp;</span>
		</div>
		<c:forEach var="codeType" items="${codeTypes}" varStatus="status">
			<div class="userRow">
				<span class="userItem">${status.count}<input name="id"
					type="hidden" value="${codeType.id}" /></span> <span
					class="userItem codeForm codeName">${codeType.name}</span> <span
					class="userItem codeForm codeHide"><input name="name"
					size="50" class="input-sm form-inline" value="${codeType.name}"/>
				</span> <span class="userItem codeForm">
					<button type="button" class="btn blue codeForm"
						onclick="doOpen(this)">管理字典项</button>
				</span> <span class="userItem resultMsg codeForm codeHide"></span> <span
					class="userItem">
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
				name="name" size="50" class="input-sm form-inline" /> </span> <span
				class="userItem"><span class="resultMsg"></span> </span> <span
				class="userItem">
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
		$('button').click(function() {
			var butId = $(this).attr('id');
			if (butId == 'searchBut') {
				var url = 'rest/code/admin';
				$.post(url, {
					name : $('#name').val()
				}, function(data) {
					showData("#main-content", data);
				});
			}
		});
		$('form').keypress(function(e) {
			var keynum;
			if (window.event) // IE
			{
				keynum = e.keyCode;
			} else if (e.which) // Netscape/Firefox/Opera
			{
				keynum = e.which;
			}
			if (keynum == 13) {
				return false;
			}
		});

		function doOpen(target) {
			var id = $(target).parent().parent().find("input[name='id']").val();
			var url = "rest/code/codeList";
			$.get(url, {
				'id' : id
			}, function(data) {
				showData("#main-content", data);
			});
		}

		function edit(target) {
			var rowDiv = $(target).parent().parent();
			rowDiv.find("input[name='name']").val(
					rowDiv.find(".codeName").html());
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
			var msg = rowDiv.find(".resultMsg");
			if (name == null || name.length < 1) {
				msg.html("不能为空！");
				msg.css('color', '#FF0000');
				return false;
			} else {
				msg.html("OK");
				msg.css('color', '#00FF00');
				var url = "rest/code/editCodeType";
				$.post(url, {
					'id' : id,
					'name' : name
				}, function(data) {
					showData("#main-content", data);
				});
				return true;
			}
		}

		function add(target) {
			var rowDiv = $(target).parent().parent();
			var name = rowDiv.find("input[name='name']").val();
			var msg = rowDiv.find(".resultMsg");
			if (name == null || name.length < 1) {
				msg.html("不能为空！");
				msg.css('color', '#FF0000');
				return false;
			} else {
				msg.html("OK");
				msg.css('color', '#00FF00');
				var url = "rest/code/addCodeType";
				$.post(url, {
					'name' : name
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
			var url = "rest/code/deleteCodeType";
			$.post(url, {
				'id' : id,
				'name' : name
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