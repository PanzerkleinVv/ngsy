<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<nav id="unitNav" class="navbar navbar-default" style="height: 20px">
	<div class="container-fluid">
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="rest/person/get">简介</a></li>
				<li><a href="rest/person/edit">修改</a></li>
				<li><a href="#">导出任免表</a></li>
			</ul>
		</div>
	</div>
</nav>
<c:choose>
	<c:when test="${person != null}">
		<div class="mainContent">
			<input id="id" type="hidden" value="${person.id}" />
			<jsp:useBean id="now" class="java.util.Date" />
			<div class="row">
				<div class="col-md-2">
					<img src="rest/person/photo?id=${person.id}" width="154px" height="180px" />
				</div>
				<div class="col-md-10">
					<div class="personBaseInfo">
						&emsp;&emsp;<b>${person.name}</b>，
						<input type="hidden" id="人的性别代码" class="needCodeName" value="${person.sex}" />
						，
						<input type="hidden" id="人员籍贯代码" class="needCodeName" value="${person.nativePlace}" />
						人， 出生地
						<input type="hidden" id="人员籍贯代码" class="needCodeName" value="${person.birthplace}" />
						，
						<input type="hidden" id="中国各民族名称代码" class="needCodeName" value="${person.nationality}" />
						，
						<fmt:formatDate value='${person.birthday}' type='DATE' pattern='yyyy年MM月dd日' />
						生（
						<c:set var="age" value="${now.time - birthday.time}" />
						<fmt:formatNumber value="${interval/1000/60/60/24/((365*4+1)/4)}" pattern="#0" />
						岁），
						<fmt:formatDate value='${person.workDate}' type='DATE' pattern='yyyy年MM月dd日' />
						参加工作，
						<c:if test="${person.partydate != null}">
							<fmt:formatDate value='${person.partydate}' type='DATE' pattern='yyyy年MM月dd日' />入党
						</c:if>
						（
						<input type="hidden" id="政治面貌代码" class="needCodeName" value="${person.nationality}" />
						）
						<c:if test="${person.educations != null && person.educations[0] != null}">，学历<input type="hidden" id="学历代码" class="needCodeName" value="${person.educations[0].education}" />（${person.educations[0].school}${person.educations[0].specialty}），<input type="hidden" id="中华人民共和国学位代码" class="needCodeName" value="${person.educations[0].degree}" />
						</c:if>
						<c:if test="${person.ranks != null && person.ranks[0] != null}">，<fmt:formatDate value='${person.ranks[0].ownDate}' type='DATE' pattern='yyyy年MM月dd日' />
							&emsp;
							<input type="hidden" id="" class="needCodeName" value="${person.ranks[0].rank}" />（<c:set var="rankAge" value="${now.time - person.ranks[0].ownDate}" />
							<fmt:formatNumber value="${interval/1000/60/60/24/((365*4+1)/4)}" pattern="#0" />）</c:if>
						。
					</div>
					<div class="personBaseInfo row">
						<c:if test="${person.families != null}">
							<c:forEach var="family" items="${person.families}">
								<span class="col-md-2">
									<input type="hidden" id="家庭关系代码" class="needCodeName" value="${family.relation}" />
								</span>
								<span class="col-md-2">${family.name}</span>
								<span class="col-md-2">${family.age}岁</span>
								<span class="col-md-6">${family.job}</span>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
			<div class="personBaseInfo row personInfo2">
				<c:if test="${person.resumes != null}">
					<c:forEach var="resume" items="${person.resumes}">
						<span class="col-md-3-16">
							<fmt:formatDate value='${resume.beginDate}' type='DATE' pattern='yyyy.MM' />
							--
							<fmt:formatDate value='${resume.endDate}' type='DATE' pattern='yyyy.MM' />
						</span>
						<span class="col-md-12-16">${resume.content}岁</span>
						<span class="col-md-1-16"></span>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		找不到该人员。
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	$("#unitNav a").click(function() {
		var url = $(this).attr("href");
		$("#unitNav li").removeClass("active");
		$(this).parent().addClass("active");
		if (url == 'rest/person/get') {
			$.post(url, {
				"id" : $("#id").val()
			}, function(data) {
				$("#main-content").html(data);
			});
		} else {
			$.post(url, {
				"id" : $("#id").val()
			}, function(data) {
				$(".mainContent").html(data);
			});
		}
		return false;
	});

	$(function() {
		$("#index-page-title").html("人员信息");
		$("#current-page-title").html("人员信息");
	});
	$(function() {
		$(".needCodeName").each(function(i, n) {
			getCodeNameAppend($(n));
		});
	});
</script>