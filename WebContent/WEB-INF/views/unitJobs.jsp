<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${unit == null || unit.id == null}">
		请选择机构……
	</c:when>
	<c:otherwise>
		<c:set var="i" value="0" />
		<div class="mainContent">
			<form id="jobForm">
				<div class="navigationBar">
					<span class="navigationItem">${unit.simpleName} 行政职务设置</span>
					<c:if test="${message != null && message.msg ne 'nullnull'}">
						<span style="color:${message.color};">${message.msg}</span>
					</c:if>
					<input type="hidden" name="unitId" value="${unit.id}" />
				</div>
				<div class="multipleFormTable sortable">
					<div class="multipleFormHeader col-md-12">
						<span class="col-md-2">岗位名称</span> <span class="col-md-2">岗位级别</span>
						<span class="col-md-2">院内岗位分类</span> <span class="col-md-2">应有岗数</span>
						<span class="col-md-2">岗位工资</span> <span class="col-md-2">状态</span>
					</div>
					<c:forEach var="job" items="${jobs}" varStatus="status">
						<c:set var="i" value="${status.index}" />
						<div class="multipleFormRow col-md-12">
							<input type="hidden" name="jobUnits[${status.index}].id"
								class="jobId" value="${job.id}" /> <span class="col-md-2"><input
								type="text" name="jobUnits[${status.index}].name"
								value="${job.name}" class="form-control" onblur="check(this)" /></span><input
								type="hidden" name="rankValue" value="${job.rank}"
								disabled="disabled" /> <span class="col-md-2"><select
								name="jobUnits[${status.index}].rank"
								class="form-control rankSelect" onblur="check(this)"><option></option></select></span><input
								type="hidden" name="typeValue" value="${job.type}"
								disabled="disabled" /> <span class="col-md-2"><select
								name="jobUnits[${status.index}].type"
								class="form-control typeSelect" onblur="check(this)"><option></option></select></span><span
								class="col-md-2"><input type="text"
								name="jobUnits[${status.index}].count" value="${job.count}"
								class="form-control" onblur="check(this)" /></span><span
								class="col-md-2"><input type="text"
								name="jobUnits[${status.index}].salary" value="${job.salary}"
								class="form-control" onblur="check(this)" /></span><input
								type="hidden" name="isUsedValue" value="${job.isUsed}"
								disabled="disabled" /> <span class="col-md-2"><select
								name="jobUnits[${status.index}].isUsed"
								class="form-control isUsedSelect" onblur="check(this)"><option
										value="1">启用</option>
									<option value="0">停用</option></select></span><input type="hidden"
								name="jobUnits[${status.index}].sort" class="jobSort"
								value="${job.sort}" />
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
					$(".rankSelect").each(
							function(i, n) {
								getCodeSimple('岗位级别', $(n), $(n).parent().prev(
										"input[name='rankValue']").val());
							});
					$(".typeSelect")
							.each(
									function(i, n) {
										getCodeSimple(
												'院内岗位分类',
												$(n),
												$(n)
														.parent()
														.prev(
																"input[name='typeValue']")
														.val());
									});
					var options = {
						target : "#unitContent",
						url : "rest/jobUnit/save",
						type : 'POST'
					};
					$('#jobForm').ajaxForm(options);
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
						$(".jobSort").each(function(i, n) {
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
							msg.html("岗位名称 不能为空！");
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
							msg.html("应有岗数 不能为空！");
							msg.css('color', '#FF0000');
							$(target).addClass("alertBorder");
							return false;
						} else if (value.search(/\D/) > -1) {
							msg.html("应有岗数 只能为阿拉伯数字！");
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
							msg.html("岗位级别 不能为空！");
							msg.css('color', '#FF0000');
							$(target).addClass("alertBorder");
							return false;
						} else {
							msg.html("");
							$(target).removeClass("alertBorder");
							return true;
						}
					} else if (type.search("type") > -1) {
						if (value == null || value.length < 1) {
							msg.html("院内岗位分类 不能为空！");
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
										".multipleFormRow").find(".jobId")
										.val())) {
							msg.html("该岗位有在岗人员，无法停用！");
							msg.css('color', '#FF0000');
							$(target).addClass("alertBorder");
							return false;
						} else {
							msg.html("");
							$(target).removeClass("alertBorder");
							return true;
						}
					} else if (type.search("salary") > -1) {
						if (value != null
								&& value.length > 0
								&& !(new RegExp(
										/^0$|^[1-9]\d*$|^[1-9]\d*\.\d{1,2}$|^0\.\d{1,2}$/)
										.test(value))) {
							msg.html("岗位工资 只能为阿拉伯数字和小数点！");
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
						url : 'rest/jobUnit/checkUsed',
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
						$('#jobForm').submit();
					} else {
						return false;
					}
				}

				function add() {
					var flag = parseInt($("#flag").val()) + 1;
					var innerHtml = '<div class="multipleFormRow col-md-12"><input type="hidden" name="jobUnits[' + flag + '].id" /> <span class="col-md-2"><input type="text" name="jobUnits['
							+ flag
							+ '].name" class="form-control" onblur="check(this)" /></span> <span class="col-md-2"><select name="jobUnits['
							+ flag
							+ '].rank" class="form-control rankSelect" onblur="check(this)"><option></option></select></span><span class="col-md-2"><select name="jobUnits['
							+ flag
							+ '].type" class="form-control typeSelect" onblur="check(this)"><option></option></select></span><span class="col-md-2"><input type="text" name="jobUnits['
							+ flag
							+ '].count" class="form-control" onblur="check(this)" /></span><span class="col-md-2"><input type="text" name="jobUnits['
							+ flag
							+ '].salary" class="form-control" onblur="check(this)" /></span><input type="hidden" name="jobUnits[' + flag + '].isUsed" value="1" /> <span class="col-md-2"><a onclick="del(this)" style="cursor: pointer;"><i class="fa fa-trash-o"></i></a></span></div><input type="hidden" name="jobUnits[' + flag + '].sort" class="jobSort" value="' + flag + '" />';
					$(".multipleFormAdd").before(innerHtml);
					getCodeSimple('岗位级别', $(".rankSelect:last"), "");
					getCodeSimple('院内岗位分类', $(".typeSelect:last"), "");
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