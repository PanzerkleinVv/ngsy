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
				<li><a href="#">机构排序</a></li>
				<li><a href="#">新增机构</a></li>
				<li><a href="#">职务设置</a></li>
				<li><a href="#">岗位设置</a></li>
			</ul>
		</div>
	</div>
</nav>
<c:choose>
	<c:when test="${person != null}">
		<div class="mainContent">
			<input id="id" type="hidden" value="${person.id}" />
			<jsp:useBean id="now" class="java.util.Date" />
			<div>
				<div class="col-md-2">
					<img src="rest/person/photo/id=${person.id}" width="160px" height="200px" s/>
				</div>
				<div class="col-md-10">
					<div>
						&emsp;&emsp;${person.name}， <input type="hidden" id="人的性别代码" class="needCodeName" value="${person.sex}" /> ， <input type="hidden" id="人员籍贯代码" class="needCodeName" value="${person.nativePlace}" /> 人， 出生地 <input type="hidden" id="人员籍贯代码" class="needCodeName" value="${person.birthplace}" /> ， <input type="hidden" id="中国各民族名称代码" class="needCodeName" value="${person.nationality}" /> ，
						<fmt:formatDate value='${person.birthday}' type='DATE' pattern='yyyy-MM-dd' />
						生（
						<c:set var="age" value="${now.time - birthday.time}" />
						<fmt:formatNumber value="${interval/1000/60/60/24/((365*4+1)/4)}" pattern="#0" />
						岁），
						<fmt:formatDate value='${person.workDate}' type='DATE' pattern='yyyy-MM-dd' />
						参加工作，
						<c:if test="${person.partydate != null}">
							<fmt:formatDate value='${person.partydate}' type='DATE' pattern='yyyy-MM-dd' />
						</c:if>
						入党，学历 <input id="getEducation" type="hidden" value="${person.id}" /> ， <input id="getRank" type="hidden" value="${person.id}" /> ， <input id="getDuties" type="hidden" value="${person.id}" /> ， <input id="getJob" type="hidden" value="${person.id}" /> 。
					</div>
					<div id="familyDiv"></div>
				</div>
			</div>
			<div>
				<div class="col-md-12" id="resumeDiv"></div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		找不到该人员。
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	var setting = {
		view : {
			dblClickExpand : false,
			selectedMulti : false
		},
		check : {
			enable : true,
			chkStyle : "radio", //单选框
			radioType : "all" //对所有节点设置单选
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		edit : {
			enable : false
		},
		callback : {
		/* beforeCheck : function(treeId, treeNode) {
		                    if (treeNode.isParent) {
		                        alert("请选择子节点！")
		                        return false;
		                    }
		                },
		onClick:function(event,treeId,treeNode){
		     if(treeNode.ahref){
		         window.open(treeNode.ahref);
		     }else{
		         alert("此节点没有链接！")
		     }
		     
		 } */
		}
	};

	$(document).ready(function() {
		$(".tableDate").datepicker({
			format : 'yyyy-mm-dd',
			language : 'zh-CN'
		});
	});
	$(function() {
		$("#index-page-title").html("干部新增");
		$("#current-page-title").html("干部新增");
	});
	$(function() {
		getCodeName($("#nativePlace").val(), $("#nativePlaceView"));
		getCodeName($("#birthplace").val(), $("#birthplaceView"));
		getCodeSimple('人的性别代码', $('#sex'), $("#sexValue").val());
		getCodeSimple('中国各民族名称代码', $("#nationality"), "");
		getCodeSimple('政治面貌代码', $("#party"), "");
		getCodeSimple('健康状况代码', $("#health"), "");
		getCodeSimple('人员状态', $('#state'), "");
		getCodeSimple('是否全日制', $("#educations_i_type"), "");
		getCodeSimple('学历代码', $("#educations_i_education"), "");
		getCodeSimple('中华人民共和国学位代码', $("#educations_i_degree"), "");
		getCodeSimple('职级状态代码', $('#ranks_i_state'), "");
		getCodeSimple('专业技术职务代码', $('#technicalTitles_i_technicalTitle'), "");
		getCodeSimpleLocal('专业技术职务代码', '.get_ct0');
		getCodeSimpleLocal('是否全日制', '.get_ct1');
		getCodeSimpleLocal('学历代码', '.get_ct2');
		getCodeSimpleLocal('中华人民共和国学位代码', '.get_ct3');
		getCodeSimpleLocal('职级状态代码', '.get_ct4');
	})
	function getCodeSimpleLocal(codeType, targetClass) {
		$(targetClass).each(function() {
			getCodeSimple(codeType, this, this.prev('input.hiddenValue'));
		});
	}
	function getCodeName(value, target) {
		if (value != null && value.length > 0) {
			$.ajax({
				type : "Get",
				url : 'rest/code/getCodeName',
				dataType : "json",
				data : {
					'code' : value
				},
				success : function(result) {
					target.html(result.name);
				}
			});
		}
	}
	function deleteRow(target) {
		$(target).parent().parent().remove();
		return false;
	}
	function add(i) {
		var next = parseInt($('#' + i + 'Next').val());
		var demo = $('#' + i).html();
		demo = demo.replace(/_i_/g, next);
		var but = $('#' + i + 'But');
		but.parent().before(demo);
		$(".tableDate").datepicker({
			format : 'yyyy-mm-dd',
			language : 'zh-CN'
		});
		$('#' + i + 'Next').val(next + 1);
	}
	//点击选择按钮的籍贯
	function find(name, tag) {
		$.ajax({
			type : "Post",
			url : 'rest/code/getJiGuan',
			data : {
				'name' : name
			},
			dataType : "json",
			success : function(result) {
				$.fn.zTree.init($("#treeDemo"), setting, result);
				document.getElementById("color").style.display = "none";
				document.getElementById("treeDemo").style.display = "";
				$("#tag1").val("");
				$("#tag1").val(tag);
				$('#myModal').modal('show');
			},
			error : function() {
				alert("菜单加载失败！")
			}
		});
	}
	//模糊查找
	function onClickfind() {
		$
				.ajax({
					type : "Post",
					url : 'rest/code/getJiGuanByName',
					data : {
						'name' : $("#codeName").val()
					},
					dataType : "json",
					success : function(result) {
						var html = "";
						if (result.length > 0) {
							for (var i = 0; i < result.length; i++) {
								html += '<span class="radio_box" style="margin-right:30px">'
										+ '<input type="radio" id="code_'+result[i].code+'"  name="radio"  value="' +result[i].code+'"style="cursor:pointer;">'
										+ '<label for="code_'+result[i].code+'">'
										+ result[i].name
										+ '</label>'
										+ '</span><br>'
							}
						} else {
							var html = '<label style="text-align:center;"class="control-label" for="name">'
									+ "查询不到数据" + '</label>';
						}
						$("#codeName").val("");
						$('#color').html(html);
						document.getElementById("color").style.display = "";
						document.getElementById("treeDemo").style.display = "none";
						$("#tag2").val("");
						$("#tag2").val("0");
						$('#myModal').modal('show');
					},
					error : function() {
						alert("菜单加载失败！")
					}
				});
	}
	$("#okBtn").click(
			function() {
				var tag1 = $("#tag1").val();
				var tag2 = $("#tag2").val();
				//籍贯
				if (tag2 == "0") {
					var selectValue = $('input[name="radio"]:checked').val();
					var selectId = $('input[name="radio"]:checked').attr('id');
					if (tag1 == "0") {
						$("#nativePlaceView").val(
								$('label[for=' + selectId + ']').html());
						$("#nativePlace").val(selectValue);
					} else {
						$("#birthplaceView").val(
								$('label[for=' + selectId + ']').html());
						$("#birthplace").val(selectValue);
					}
				} else {
					var zTree = $.fn.zTree.getZTreeObj("treeDemo");
					checkCount = zTree.getCheckedNodes(true);
					var classpurview = checkCount[0].name;
					if (tag1 == "0") {
						$("#nativePlaceView").val(classpurview);
						$("#nativePlace").val(checkCount[0].id);
					} else {
						$("#birthplaceView").val(classpurview);
						$("#birthplace").val(checkCount[0].id);
					}
				}
				$("#tag1").val("")
				$("#tag2").val("")
				$('#myModal').modal('hide');
			});

	$(function() {
		$("form.needs-validation").validate({
			submitHandler : function(form) {
				alert("submit!");
				form.submit();
			},
			rules : {
				"idCard" : {
					checkIdCard : true
				}
			}
		});
	});
</script>