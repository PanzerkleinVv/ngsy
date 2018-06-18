<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="mainContent">
	<div class="">
		<form action="" method="post">
			内容：<input name="content" id="content" size="50"
				value="${logQuery.content}" class="input-sm form-inline" type="text"
				autocomplete="off" placeholder="查找日志内容" />|&emsp;&emsp;模块：<select
				id="type" name="type" class="input-sm form-inline">
				<option></option>
			</select> <input id="typeValue" value="${logQuery.type}" /><br /> 起止时间：<input
				size="16" type="text" id="beginDate" value="<fmt:formatDate
				value='${logQuery.beginDate}' type='DATE' pattern='yyyy-MM-dd' />"
				readonly class="form_date input-sm form-inline" placeholder="起始时间" />&emsp;至&emsp;<input
				size="16" type="text" id="endDate" value="<fmt:formatDate
				value='${logQuery.endDate}' type='DATE' pattern='yyyy-MM-dd' />"
				readonly class="form_date input-sm form-inline" placeholder="终止时间" />
			<button id="searchBut" type="button" class="btn blue form-inline" onclick="query('1')">查询</button>
		</form>
	</div>
	<div class="navigationBar">
		<span style="cursor: pointer;" id="getAll" class="navigationItem">所有</span>
		<c:if test="${logQuery != null}">
			<span>>></span>
			<span class="navigationItem">查询结果</span>
		</c:if>
	</div>
	<div class="userTable">
		<div class="userRow userHeader">
			<span class="userItem">序号</span> <span class="userItem">时间</span> <span
				class="userItem">用户名</span> <span class="userItem">模块</span><span
				class="userItem">日志记录</span>
		</div>
		<c:forEach var="log" items="${logs}" varStatus="status">
			<div class="userRow">
				<span class="userItem">${log.id}</span> <span class="userItem"><fmt:setLocale value="zh_CN" />
<fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${log.time}" /></span>
				<span class="userItem">${log.userdesc}</span> <span class="userItem">${log.name}</span>
				<span class="userItem">${log.content}</span>
			</div>
		</c:forEach>
	</div>
	<div class="pageBox">
		<input type="hidden" id="pageNo" value="${page.pageNo}" /> <input
			type="hidden" id="type" value="${type}" /> <input type="hidden"
			id="status" value="${status}" />
		<c:if test="${page.pageNo eq 1}">
			<span class="page firstP">首页</span>
			<span class="page beforeP">上一页</span>
		</c:if>
		<c:if test="${page.pageNo > 1}">
			<span class="page firstP clickable" onclick="query(1)">首页</span>
			<span class="page beforeP clickable"
				onclick="query(${page.pageNo-1})">上一页</span>
		</c:if>
		<c:if test="${page.totalPages<5}">
			<c:forEach begin="1" end="${page.totalPages}" varStatus="index">
				<span class="page numP clickable" id="${index.index}"
					onclick="query(${index.index})">${index.index}</span>
			</c:forEach>
		</c:if>
		<c:if test="${page.totalPages>5}">
			<c:if test="${page.pageNo<=3}">
				<c:forEach begin="1" end="5" varStatus="index">
					<span class="page numP clickable" id="${index.index}"
						onclick="query(${index.index})">${index.index}</span>
				</c:forEach>
			</c:if>
		</c:if>
		<span class="page countP">第${page.pageNo}/${page.totalPages}页（共${page.totalCount}条结果）</span>
		<c:if test="${page.totalPages>5}">
			<c:if test="${page.pageNo>=4&&page.pageNo<=page.totalPages-2}">
				<c:forEach begin="${page.pageNo-2}" end="${page.pageNo+2}"
					varStatus="index">
					<span class="page numP clickable" id="${index.index}"
						onclick="query(${index.index})">${index.index}</span>
				</c:forEach>
			</c:if>
		</c:if>
		<c:if test="${page.totalPages>5}">
			<c:if test="${page.pageNo>(page.totalPages-2)}">
				<c:forEach begin="${page.totalPages-4}" end="${page.totalPages}"
					varStatus="index">
					<span class="page numP clickable" id="${index.index}"
						onclick="query(${index.index})">${index.index}</span>
				</c:forEach>
			</c:if>
		</c:if>
		<c:if test="${page.pageNo eq page.totalPages}">
			<span class="page afterP">下一页</span>
			<span class="page lastP">尾页</span>
		</c:if>
		<c:if test="${page.pageNo < page.totalPages}">
			<span class="page afterP clickable" onclick="query(${page.pageNo+1})">下一页</span>
			<span class="page lastP clickable"
				onclick="query(${page.totalPages})">尾页</span>
		</c:if>
	</div>

	<script type="text/javascript">
		$("#getAll").click(function() {
			var url = 'rest/log/admin';
			$.get(url, function(data) {
				showData("#main-content", data);
			});
		});
		
		$(function() {
			getCodeSimple('系统模块代码', $('#type'), $('#typeValue').val());
		});
		
		function query(pageNo) {
			var url = 'rest/log/admin';
			$.post(url, {
				'content' : $('#content').val(),
				'type' : $('#type').val(),
				'beginDate' : $('#beginDate').val(),
				'endDate' : $('#endDate').val(),
				'pageNo' : pageNo
			}, function(data) {
				showData("#main-content", data);
			});
		}

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
		
		$(".form_date").datepicker({
			format : 'yyyy-mm-dd',
			language : 'zh-CN'
		});

		$(function() {
			$("#index-page-title").html("日志管理");
			$("#current-page-title").html("日志管理");
		});
	</script>
</div>