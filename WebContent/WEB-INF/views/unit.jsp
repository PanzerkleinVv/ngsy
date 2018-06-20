<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainContent">
	<div class="unitLeft">机构树载入中……</div>
	<div class="unitRight">
		<header class="am-topbar">
			<div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
				<ul class="am-nav am-nav-pills am-topbar-nav">
					<li><a href="/rest/unit/newUnit">新增机构</a></li>
					<li><a href="/rest/unit/people">机构成员</a></li>
					<li><a href="/rest/unit/duties">职务设置</a></li>
					<li><a href="/rest/unit/job">岗位设置</a></li>
				</ul>
			</div>
		</header>
	</div>

	<script type="text/javascript">
		$(function() {
			$("#index-page-title").html("机构设置");
			$("#current-page-title").html("机构设置");
		});
	</script>
</div>