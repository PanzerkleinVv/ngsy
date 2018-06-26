<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${unit == null || unit.id == null}">
		请选择机构……
	</c:when>
	<c:otherwise>
		<c:set var="i" value="0" />
		<div class="mainContent">
			<form id="dutiesForm">
				<div class="navigationBar">
					<span class="navigationItem">${unit.simpleName} 行政职务设置</span>
					<c:if test="${message != null && message.msg ne 'nullnull'}">
						<span style="color:${message.color};">${message.msg}</span>
					</c:if>
					<input type="hidden" name="unitId" value="${unit.id}" />
				</div>
				<div class="multipleFormTable sortable">
					<div class="multipleFormHeader col-md-12">
						<span class="col-md-4">行政职务名称</span> <span class="col-md-4">院内行政职级</span>
						<span class="col-md-2">应有职数</span> <span class="col-md-2">状态</span>
					</div>
					<c:forEach var="duty" items="${duties}" varStatus="status">
						<c:set var="i" value="${status.index}" />
						<div class="multipleFormRow col-md-12">
							<input type="hidden" name="dutieUnits[${status.index}].id"
								class="dutyId" value="${duty.id}" /> <span class="col-md-4"><input
								type="text" name="dutieUnits[${status.index}].name"
								value="${duty.name}" class="form-control" onblur="check(this)" /></span><input
								type="hidden" name="rankValue" value="${duty.rank}"
								disabled="disabled" /> <span class="col-md-4"><select
								name="dutieUnits[${status.index}].rank"
								class="form-control rankSelect" onblur="check(this)"><option></option></select></span><span
								class="col-md-2"><input type="text"
								name="dutieUnits[${status.index}].count" value="${duty.count}"
								class="form-control" onblur="check(this)" /></span><input
								type="hidden" name="isUsedValue" value="${duty.isUsed}"
								disabled="disabled" /> <span class="col-md-2"><select
								name="dutieUnits[${status.index}].isUsed"
								class="form-control isUsedSelect" onblur="check(this)"><option
										value="1">启用</option>
									<option value="0">停用</option></select></span><input type="hidden"
								name="dutieUnits[${status.index}].sort" class="dutySort"
								value="${duty.sort}" />
						</div>
					</c:forEach>
					<div class="multipleFormAdd">
						<a onclick="add()" style="cursor: pointer;"><i
							class="fa fa-plus"></i>新增一行</a>
					</div>
					<div class="multipleFormMsg col-md-12">
						<span class="col-md-6">操作说明：拖拽排序</span><span class="col-md-6"></span>
					</div>
					<div class="multipleFormFooter">
						<button type="button" class="btn green" onclick="save()">保存</button>
					</div>

				</div>
			</form>
			<input type="hidden" id="flag" value="${i == null ? 0 : i}" />
			<script type="text/javascript">
				$(function() {
					$(".rankSelect")
							.each(
									function(i, n) {
										getCodeSimple(
												'院内行政职级',
												$(n),
												$(n)
														.parent()
														.prev(
																"input[name='rankValue']")
														.val());
									});
					var options = {
						target : "#unitContent",
						url : "rest/dutiesUnit/save",
						type : 'POST'
					};
					$('#dutiesForm').ajaxForm(options);
					$(".isUsedSelect").each(
							function(i, n) {
								$(n).val(
										$(n).parent().prev(
												"input[name='isUsedValue']")
												.val());
							});
					$(".sortable").sortable({
						cursor : "move",
						items : ".multipleFormRow",
						opacity : 0.8,
						placeholder : "multipleFormRow"
					});
					$(".sortable").bind('sortupdate', function(event, ui) {
						$(".dutySort").each(function(i, n) {
							$(n).val(i);
						});
					});
				});

				function check(target) {
					var type = $(target).attr("name");
					var value = $(target).val();
					var msg = $(".multipleFormMsg>span:last");
					if (type.search("name") > -1) {
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
					} else if (type.search("count") > -1) {
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
					} else if (type.search("rank") > -1) {
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
					} else if (type.search("isUsed") > -1) {
						if (value == null || value.length < 1) {
							msg.html("状态 不能为空！");
							msg.css('color', '#FF0000');
							$(target).addClass("alertBorder");
							return false;
						} else if (value == 0
								&& checkUsed($(target).parents(
										".multipleFormRow").find(".dutyId")
										.val())) {
							msg.html("该职务有在任人员，无法停用！");
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

				function checkUsed(value) {
					var flag;
					$.ajax({
						type : "Post",
						data : {
							id : value
						},
						url : 'rest/dutiesUnit/checkUsed',
						dataType : "json",
						async : false,
						success : function(result) {
							flag = result;
						}
					});
					return flag;
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
						$('#dutiesForm').submit();
					} else {
						return false;
					}
				}

				function add() {
					var flag = parseInt($("#flag").val()) + 1;
					var innerHtml = '<div class="multipleFormRow col-md-12"><input type="hidden" name="dutieUnits[' + flag + '].id" /> <span class="col-md-4"><input type="text" name="dutieUnits['
							+ flag
							+ '].name" class="form-control" onblur="check(this)" /></span> <span class="col-md-4"><select name="dutieUnits['
							+ flag
							+ '].rank" class="form-control rankSelect" onblur="check(this)"><option></option></select></span><span class="col-md-2"><input type="text" name="dutieUnits['
							+ flag
							+ '].count" class="form-control" onblur="check(this)" /></span><input type="hidden" name="dutieUnits[' + flag + '].isUsed" value="1" /> <span class="col-md-2"><a onclick="del(this)" style="cursor: pointer;"><i class="fa fa-trash-o"></i></a></span></div><input type="hidden" name="dutieUnits[' + flag + '].sort" class="dutySort" value="' + flag + '" />';
					$(".multipleFormAdd").before(innerHtml);
					getCodeSimple('院内行政职级', $(".rankSelect:last"), "");
					$("#flag").val(flag);
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