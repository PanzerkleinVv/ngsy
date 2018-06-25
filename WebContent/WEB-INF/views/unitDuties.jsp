<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${unit == null || unit.id == null}">
		请选择机构……
	</c:when>
	<c:otherwise>
		<div class="mainContent">
			<form>
				<div class="navigationBar">
					<span class="navigationItem">${unit.simpleName} 行政职务设置</span>
					<c:if test="${message != null && message.msg ne 'nullnull'}">
						<span style="color:${message.color};">${message.msg}</span>
					</c:if>
					<input type="hidden" id="unitId" value="${unit.id}" />
				</div>
				<div class="multipleFormTable">
					<div class="multipleFormHeader">
						<span>行政职务名称</span> <span>院内行政职级</span> <span>应有职数</span> <span>状态</span>
					</div>
					<c:forEach var="duty" items="${duties}" varStatus="status">
						<div class="multipleFormRow">
							<input type="hidden" name="id" value="${duty.id}" /> <span><input
								type="text" name="name" value="${duty.name}"
								class="form-control" onblur="check(this)" /></span><input
								type="hidden" name="rankValue" value="${duty.rank}"
								disabled="disabled" /> <span><select name="rank"
								class="form-control" onblur="check(this)"><option></option></select></span><span><input
								type="text" name="count" value="${duty.count}"
								class="form-control" onblur="check(this)" /></span><input
								type="hidden" name="isUsedValue" value="${duty.isUsed}"
								disabled="disabled" /> <span><select name="isUsed"
								class="form-control" onblur="check(this)"><option
										value="1">启用</option>
									<option value="0">停用</option></select></span>
						</div>
					</c:forEach>
					<div class="multipleFormAdd">
						<a onclick="add()" style="cursor: pointer;"><i
							class="fa fa-plus"></i></a>
					</div>
					<div class="multipleFormMsg">
						<span>操作说明：拖拽排序</span><span></span>
					</div>
					<div class="multipleFormFooter">
						<button type="button" class="btn green" onclick="save()">保存</button>
					</div>

				</div>
			</form>
			<script type="text/javascript">
				$(function() {
					$("select[name='rank']").each(
							function(i, n) {
								getCodeSimple('院内行政职级', $(n), $(n).prev(
										"input[name='rankValue']").val());
							});
					var options = {
						target : "#unitContent",
						url : "rest/dutiesUnit/save",
						type : 'POST'
					};
					$('.multipleFormTable form').ajaxForm(options);
				});

				function check(target) {
					var type = $(target).attr("name");
					var value = $(target).val();
					var msg = $(".multipleFormMsg>span:last");
					if (type == "name") {
						if (value == null || value.length < 1) {
							msg.html("行政职务名称 不能为空！");
							msg.css('color', '#FF0000');
							$(target).addClass("alertBorder");
							return false;
						} else {
							msg.html("");
							$(target).removeClass("alertBorder");
							return true;
						}
					} else if (type == "count") {
						if (value == null || value.length < 1) {
							msg.html("应有职数 不能为空！");
							msg.css('color', '#FF0000');
							$(target).addClass("alertBorder");
							return false;
						} else if (value.search(/\D/) != -1) {
							msg.html("应有职数 只能为阿拉伯数字！");
							msg.css('color', '#FF0000');
							$(target).addClass("alertBorder");
							return false;
						} else {
							msg.html("");
							$(target).removeClass("alertBorder");
							return true;
						}
					} else if (type == "rank") {
						if (value == null || value.length < 1) {
							msg.html("院内行政职级 不能为空！");
							msg.css('color', '#FF0000');
							$(target).addClass("alertBorder");
							return false;
						} else {
							msg.html("");
							$(target).removeClass("alertBorder");
							return true;
						}
					} else if (type == "isUsed") {
						if (value == null || value.length < 1) {
							msg.html("状态 不能为空！");
							msg.css('color', '#FF0000');
							$(target).addClass("alertBorder");
							return false;
						} else {
							msg.html("");
							$(target).removeClass("alertBorder");
							return true;
						}
					}
				}

				function checkAll() {
					var flag = true;
					$(".multipleFormTable input[type='text']").each(
							function(i, n) {
								if (!check(n)) {
									flag = false;
									return flag;
								}
							});
					if (flag) {
						$(".multipleFormTable select").each(function(i, n) {
							if (!check(n)) {
								flag = false;
								return flag;
							}
						});
					}
					return flag;
				}

				function save() {
					if (checkAll()) {
						$('.multipleFormTable form').submit();
					} else {
						return false;
					}
				}

				function add() {
					var innerHtml = '<div class="multipleFormRow"><input type="hidden" name="id" /> <span><input type="text" name="name" class="form-control" onblur="check(this)" /></span> <span><select name="rank" class="form-control" onblur="check(this)"><option></option></select></span><span><input type="text" name="count" class="form-control" onblur="check(this)" /></span><input type="hidden" name="isUsed" value="1" /> <span><a onclick="del(this)" style="cursor: pointer;"><i class="fa fa-trash-o"></i></a></span></div>';
					$(".multipleFormAdd").before(innerHtml);
					getCodeSimple('院内行政职级', $("select[name='rank']:last"), "");
					return false;
				}

				function del(target) {
					$(target).parents(".multipleFormRow").remove();
					return false;
				}
			</script>
		</div>
	</c:otherwise>
</c:choose>