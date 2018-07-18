<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainContent">
	<form role="form" action="rest/person/find" method="post">
		<div class="searchBar">
			<input type="hidden" name="pageNo" id="pageNo" value="1" /> 
			<div class="row">
						<div class="col-md-2">
							<label class="control-label" for="name">姓名:</label>
							<input type="text" id="name" name="name" class="input-clarge focused" style="width: 100px; " value="${query != null ? query.name : ''}"/>
							<p class="help-block"></p>
						</div>
						<div class="col-md-4">
							<label class="control-label" for="age">年龄:</label>
							    <select id="ageSelect" name="ageSelect"  >
									<option <c:if test="${query.ageSelect == '等于'}">selected="selected"</c:if>>等于</option>
									<option <c:if test="${query.ageSelect == '大于'}">selected="selected"</c:if>>大于</option>
									<option <c:if test="${query.ageSelect == '小于'}">selected="selected"</c:if>>小于</option>
								</select>
							<input type="text" id="ageInt" name="ageInt"  class="input-clarge focused" style="width: 100px;" value="${query != null ? query.ageInt : ''}"/>	
						</div>
						<div class="col-md-2">
							<label class="control-label" for="technical_title">职务:</label>
							<input type="text" id="technical_title" name="technical_title" class="input-clarge focused" style="width: 100px;" value="${query != null ? query.technical_title : ''}"/>
							<p class="help-block"></p>
						</div>
						<div class="col-md-4">
							<label class="control-label" for="enterDate">来校时间:</label>
							    <select id="enterDateSelect" name="enterDateSelect" >
									<option <c:if test="${query.enterDateSelect == '等于'}">selected="selected"</c:if>>等于</option>
									<option <c:if test="${query.enterDateSelect == '大于'}">selected="selected"</c:if>>大于</option>
									<option  <c:if test="${query.enterDateSelect == '小于'}">selected="selected"</c:if>>小于</option>
								</select>
							<input type="text" id="enterDateInt" name="enterDateInt"  class="input-clarge focused" style="width: 100px;" value="${query != null ? query.enterDateInt : ''}"/>	
						</div>
			</div>
			<button type="button" class="btn green" onclick="query('1')">查询</button>
		
		</div>
		<c:if test="${people != null}"></c:if>
		<div class="resultBar">
			<div class="row">
			<c:forEach items="${people}" var="person" varStatus="status">
				<div class="col-md-3" onclick="getPerson('${person.id}')" style="margin-top:10px;">
					<span>
						<img src="rest/person/photo?id=${person.id}" width="80px" height="100px" />
					</span>
					<span>${person.name}</span>
					<span>${person.xianRenZhiWu}</span>
				</div>
			</c:forEach>
			</div>
			<div class="row">
				<div class="pageBox">
					<c:if test="${page.pageNo eq 1}">
						<span class="page firstP">首页</span>
						<span class="page beforeP">上一页</span>
					</c:if>
					<c:if test="${page.pageNo > 1}">
						<span class="page firstP clickable" onclick="query(1)">首页</span>
						<span class="page beforeP clickable" onclick="query(${page.pageNo-1})">上一页</span>
					</c:if>
					<c:if test="${page.totalPages<5}">
						<c:forEach begin="1" end="${page.totalPages}" varStatus="index">
							<span class="page numP clickable" id="${index.index}" onclick="query(${index.index})">${index.index}</span>
						</c:forEach>
					</c:if>
					<c:if test="${page.totalPages>5}">
						<c:if test="${page.pageNo<=3}">
							<c:forEach begin="1" end="5" varStatus="index">
								<span class="page numP clickable" id="${index.index}" onclick="query(${index.index})">${index.index}</span>
							</c:forEach>
						</c:if>
					</c:if>
					<span class="page countP">第${page.pageNo}/${page.totalPages}页（共${page.totalCount}条结果）</span>
					<c:if test="${page.totalPages>5}">
						<c:if test="${page.pageNo>=4&&page.pageNo<=page.totalPages-2}">
							<c:forEach begin="${page.pageNo-2}" end="${page.pageNo+2}" varStatus="index">
								<span class="page numP clickable" id="${index.index}" onclick="query(${index.index})">${index.index}</span>
							</c:forEach>
						</c:if>
					</c:if>
					<c:if test="${page.totalPages>5}">
						<c:if test="${page.pageNo>(page.totalPages-2)}">
							<c:forEach begin="${page.totalPages-4}" end="${page.totalPages}" varStatus="index">
								<span class="page numP clickable" id="${index.index}" onclick="query(${index.index})">${index.index}</span>
							</c:forEach>
						</c:if>
					</c:if>
					<c:if test="${page.pageNo eq page.totalPages}">
						<span class="page afterP">下一页</span>
						<span class="page lastP">尾页</span>
					</c:if>
					<c:if test="${page.pageNo < page.totalPages}">
						<span class="page afterP clickable" onclick="query(${page.pageNo+1})">下一页</span>
						<span class="page lastP clickable" onclick="query(${page.totalPages})">尾页</span>
					</c:if>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$(function() {
			$("#index-page-title").html("人员查找");
			$("#current-page-title").html("人员查找");
		});
		
		function query(num) {
			$("#pageNo").val(num);
			$("form").ajaxSubmit({
				success : function(result) { //表单提交后更新页面显示的数据
					$('#main-content').html(result);
				}
			});
		}
		
		function getPerson(id) {
			var url = 'rest/person/get';
			$.post(url, {
				'id' : id
			}, function(data) {
				$("#main-content").html(data);
			});
		}
	</script>
</div>
			