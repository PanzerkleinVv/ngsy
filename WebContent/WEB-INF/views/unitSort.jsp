<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${unit == null || unit.id == null}">
		请选择机构……
	</c:when>
	<c:otherwise>
		<div class="mainContent">
			<div class="navigationBar">
				<span class="navigationItem">机构排序</span>
				<c:if test="${message != null && message.msg ne 'nullnull'}">
					<span style="color:${message.color};">${message.msg}</span>
				</c:if>
			</div>
			<div class="multipleList sortable">
				<c:forEach var="unit" items="${units}" varStatus="status">
					<div class="multipleList-row sortableLine">
						<input type="hidden" name="ids" value="${unit.id}" /> <span>${unit.name}</span>
					</div>
				</c:forEach>
			</div>
			<div class="multipleList-row-ps"><span>操作说明：拖拽排序</span></div>
			<div class="multipleList-row-but">
				<button type="button" class="btn green" onclick="save()">保存</button>
			</div>

			<script type="text/javascript">
				$(function() {
					$(".sortable").sortable({
						cursor : "move",
						items : ".sortableLine",
						opacity : 0.8,
						placeholder : "multipleList-row"
					});
				});

				function save(target) {
					var url = 'rest/unit/sort';
					var ids = $("input[name='ids']").map(function() {
						return $(this).val();
					}).get();
					$.ajax({
						'type' : 'POST',
						'url' : url,
						'data' : {
							'ids' : ids
						},
						'success' : function(data) {
							$("#unitContent").html(data);
						},
					});
				}
			</script>
		</div>
	</c:otherwise>
</c:choose>
