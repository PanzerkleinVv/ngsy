<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<div class="mainContent row0 row">
	<form role="form" class="form-horizontal">
		<div class="col-md-9 tableRow">
			<div class="form-group tableRow">
				<label class="col-md-1 control-label" for="name">姓名</label>
				<div class="col-md-3">
					<input class="form-control" name="name" type="text" id="name" placeholder="姓名" />
					<p class="help-block"></p>
				</div>
				<label class="col-md-1 control-label" for="sex">性别</label>
				<div class="col-md-3">
					<select id="sex" name="sex" class="form-control">
						<option>选择性别</option>
					</select>
					<p class="help-block"></p>
				</div>
				<label class="col-md-1 control-label" for="birthday">出生年月</label>
				<div class="col-md-3">
					<input type="text" placeholder="点击选择日期" id="birthday" name="birthday" class="form-control tableDate" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="form-group tableRow">
				<label class="col-md-1 control-label" for="nationality">民族</label>
				<div class="col-md-3">
					<select id="nationality" name="nationality" class="form-control">
						<option>选择民族</option>
					</select>
					<p class="help-block"></p>
				</div>
				<label class="col-md-1 control-label" for="nativePlace">籍贯</label>
				<div class="col-md-3">
					<input class="form-control" name="nativePlace" type="text" id="nativePlace" onclick="find('人员籍贯代码','0')" placeholder="点击选择" />
					<p class="help-block"></p>
				</div>
				<label class="col-md-1 control-label" for="birthplace">出生地</label>
				<div class="col-md-3">
					<input class="form-control" name="birthplace" type="text" id="birthplace" onclick="find('人员籍贯代码','1')" placeholder="点击选择" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="form-group tableRow">
				<label class="col-md-1 control-label" for="party">政治面貌</label>
				<div class="col-md-3">
					<select id="party" name="party" class="form-control">
						<option>政治面貌</option>
					</select>
					<p class="help-block"></p>
				</div>
				<label class="col-md-1 control-label" for="partydate">入党时间</label>
				<div class="col-md-3">
					<input type="text" placeholder="点击选择日期" id="partydate" name="partydate" class="form-control tableDate" />
					<p class="help-block"></p>
				</div>
				<label class="col-md-1 control-label" for="workDate">参加工作时间</label>
				<div class="col-md-3">
					<input type="text" placeholder="点击选择日期" id="workDate" name="workDate" class="form-control tableDate" />
					<p class="help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-3 tableRow"></div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="health">健康状况</label>
				<div class="col-md-3-16">
					<select id="health" name="health" class="form-control">
						<option>健康状况</option>
					</select>
					<p class="help-block"></p>
				</div>
				<label class="col-md-1-16 control-label" for="state">人员状态</label>
				<div class="col-md-3-16">
					<select id="state" name="state" class="form-control">
						<option>人员状态</option>
					</select>
					<p class="help-block"></p>
				</div>
				<label class="col-md-1-16 control-label" for="salaryRankId">考勤课酬</label>
				<div class="col-md-3-16">
					<input class="form-control" name="salaryRankId" type="text" id="salaryRankId" placeholder="考勤课酬" />
					<p class="help-block"></p>
				</div>
				<label class="col-md-1-16 control-label" for="shuangDhiDate">双师认定时间</label>
				<div class="col-md-3-16">
					<input type="text" placeholder="点击选择日期" id="shuangDhiDate" name="shuangDhiDate" class="form-control tableDate" />
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="idCard">身份证号</label>
				<div class="col-md-4-16">
					<input class="form-control" name="idCard" type="text" id="idCard" placeholder="身份证号" />
					<p class="help-block"></p>
				</div>
				<label class="col-md-2-16 control-label" for="specialty">熟悉专业有何专长</label>
				<textarea class="col-md-4-16 form-control" name="specialty" id="specialty" rows="3" placeholder="熟悉专业有何专长"></textarea>
				<label class="col-md-2-16 control-label" for="enterDate">进入本单位工作时间</label>
				<div class="col-md-3-16">
					<input type="text" placeholder="点击选择日期" id="enterDate" name="enterDate" class="form-control tableDate">
					<p class="help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="technicalTitle">专业技术职称</label>
				<div class="col-md-15-16">
					<div class="row">
						<span class="col-md-9-16 innerLabel">职称</span>
						<span class="col-md-3-16 innerLabel">获得日期</span>
						<span class="col-md-3-16 innerLabel">职称聘任时间</span>
						<span class="col-md-1-16 innerLabel">删除</span>
					</div>
					<div class="col-md-16-16 butRow addRow">
						<button id="0But" type="button" class="btn btn-info" onclick="add('0')">增加</button>
					</div>
					<p class="col-md-16-16 help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="education">学历学位</label>
				<div class="col-md-15-16">
					<div class="row">
						<span class="col-md-2-16 innerLabel">类型</span>
						<span class="col-md-2-16 innerLabel">学历</span>
						<span class="col-md-2-16 innerLabel">学位</span>
						<span class="col-md-3-16 innerLabel">学校</span>
						<span class="col-md-3-16 innerLabel">专业</span>
						<span class="col-md-2-16 innerLabel">毕业时间</span>
						<span class="col-md-1-16 innerLabel">最高</span>
						<span class="col-md-1-16 innerLabel">删除</span>
					</div>
					<div class="col-md-16-16 butRow addRow">
						<button id="1But" type="button" class="btn btn-info" onclick="add('1')">增加</button>
					</div>
					<p class="col-md-16-16 help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="rank">职级</label>
				<div class="col-md-15-16">
					<div class="row">
						<span class="col-md-9-16 innerLabel">职级</span>
						<span class="col-md-3-16 innerLabel">获得日期</span>
						<span class="col-md-3-16 innerLabel">职级状态</span>
						<span class="col-md-1-16 innerLabel">删除</span>
					</div>
					<div class="col-md-16-16 butRow addRow">
						<button id="2But" type="button" class="btn btn-info" onclick="add('2')">增加</button>
					</div>
					<p class="col-md-16-16 help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="xianRenZhiWu">现任职务</label>
				<div class="col-md-15-16">
					<input class="form-control" name="xianRenZhiWu" type="text" id="xianRenZhiWu" placeholder="现任职务" />
					<p class="help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="niRenZhiWu">拟任职务</label>
				<div class="col-md-15-16">
					<input class="form-control" name="niRenZhiWu" type="text" id="niRenZhiWu" placeholder="拟任职务" />
					<p class="help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="niMianZhiWu">拟免职务</label>
				<div class="col-md-15-16">
					<input class="form-control" name="niMianZhiWu" type="text" id="niMianZhiWu" placeholder="拟免职务" />
					<p class="help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="rank">简历</label>
				<div class="col-md-15-16">
					<div class="row addRow">
						<span class="col-md-3-16 innerLabel">起始时间</span>
						<span class="col-md-3-16 innerLabel">结束时间</span>
						<span class="col-md-9-16 innerLabel">简历</span>
						<span class="col-md-1-16 innerLabel">删除</span>
					</div>
					<div class="col-md-16-16 butRow addRow">
						<button id="3But" type="button" class="btn btn-info" onclick="add('3')">增加</button>
					</div>
					<p class="col-md-16-16 help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow butRow">
			<button type="button" class="col-md-16-16 addRow btn green" onclick="save()">保存</button>
		</div>
	</form>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 400px;">
		<div class="modal-content">
			<div class="modal-header">

				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4 class="modal-title" id="myModalLabel">选择代码</h4>
				<input class="input-clarge focused" name="name" type="text" id="codeName" style="margin-top: 7px; margin-bottom: 7px;">
				<button type="button" class="btn btn-info" onclick="onClickfind()">查找</button>

			</div>
			<div class="modal-body" id="modal_body">
				<div id="treeDemo" class="ztree" style="height: 300px; overflow: auto"></div>
				<div id="color" style="width: 360px; height: 300px; overflow: auto"></div>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal">关闭</button>
				<button id="okBtn" class="btn btn-primary">确定</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<div style="display: none">
	<input id="tag1" type="text">
</div>
<div style="display: none">
	<input id="tag2" type="text">
</div>
<div class="addDemo">
	<input type="hidden" id="0Next" value="0" disabled="disabled" /> <input type="hidden" id="1Next" value="0" disabled="disabled" /> <input type="hidden" id="2Next" value="0" disabled="disabled" /> <input type="hidden" id="3Next" value="0" disabled="disabled" />
	<div id="0">
		<div class="row addRow">
			<span class="col-md-9-16">
				<select id="technicalTitles_i_technicalTitle" name="technicalTitles[_i_].technicalTitle" class="form-control smForm">
					<option>职称</option>
				</select>
			</span>
			<span class="col-md-3-16">
				<input type="text" placeholder="点击选择日期" id="technicalTitles_i_ownDate" name="technicalTitles[_i_].ownDate" class="form-control tableDate" />
			</span>
			<span class="col-md-3-16">
				<input type="text" placeholder="点击选择日期" id="technicalTitles_i_jobDate" name="technicalTitles[_i_].jobDate" class="form-control tableDate" />
			</span>
			<span class="col-md-1-16 butRow">
				<a onclick="deleteRow(this)" class="delBut"><i class='fa fa-trash-o'></i></a>
			</span>
		</div>
	</div>
	<div id="1">
		<div class="row addRow">
			<span class="col-md-2-16">
				<select id="educations_i_type" name="educations[_i_].type" class="form-control smForm">
					<option>类型</option>
				</select>
			</span>
			<span class="col-md-2-16">
				<select id="educations_i_education" name="educations[_i_].education" class="form-control smForm">
					<option>学历</option>
				</select>
			</span>
			<span class="col-md-2-16">
				<select id="educations_i_degree" name="educations[_i_].degree" class="form-control smForm">
					<option>学位</option>
				</select>
			</span>
			<span class="col-md-3-16">
				<input type="text" placeholder="毕业院校" id="educations_i_school" name="educations[_i_].school" class="form-control smForm" />
			</span>
			<span class="col-md-3-16">
				<input type="text" placeholder="专业" id="educations_i_specialty" name="educations[_i_].specialty" class="form-control smForm" />
			</span>
			<span class="col-md-2-16">
				<input type="text" placeholder="点击选择日期" id="educations_i_graduationDate" name="educations[_i_].graduationDate" class="form-control tableDate smForm" />
			</span>
			<span class="col-md-1-16 butRow">
				<input type="radio" id="educations_i_isHighest" name="educations[_i_].isHighest" />
			</span>
			<span class="col-md-1-16 butRow">
				<a onclick="deleteRow(this)" class="delBut"><i class='fa fa-trash-o'></i></a>
			</span>
		</div>
	</div>
	<div id="2">
		<div class="row addRow">
			<span class="col-md-9-16">
				<select id="ranks_i_rank" name="ranks[_i_]rank" class="form-control">
					<option>职级</option>
				</select>
			</span>
			<span class="col-md-3-16">
				<input type="text" placeholder="点击选择日期" id="ranks_i_ownDate" name="ranks[_i_].ownDate" class="form-control tableDate" />
			</span>
			<span class="col-md-3-16">
				<select id="ranks_i_state" name="ranks[_i_].state" class="form-control">
					<option>职级状态</option>
				</select>
			</span>
			<span class="col-md-1-16 butRow">
				<a onclick="deleteRow(this)" class="delBut"><i class='fa fa-trash-o'></i></a>
			</span>
		</div>
	</div>
	<div id="3">
		<div class="row addRow">
			<span class="col-md-3-16">
				<input type="text" placeholder="点击选择日期" id="resumes_i_beginDate" name="resumes[_i_].beginDate" class="form-control tableDate" />
			</span>
			<span class="col-md-3-16">
				<input type="text" placeholder="点击选择日期" id="resumes_i_endDate" name="resumes[_i_].endDate" class="form-control tableDate" />
			</span>
			<span class="col-md-9-16">
				<textarea class="form-control" name="resumes[_i_].content" id="resumes_i_content" rows="3" placeholder="简历"></textarea>
			</span>
			<span class="col-md-1-16 butRow">
				<a onclick="deleteRow(this)" class="delBut"><i class='fa fa-trash-o'></i></a>
			</span>
		</div>
	</div>
</div>
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
		getCodeSimple('人的性别代码', $('#sex'), "");
		getCodeSimple('中国各民族名称代码', $("#nationality"), "");
		getCodeSimple('政治面貌代码', $("#party"), "");
		getCodeSimple('健康状况代码', $("#health"), "");
		getCodeSimple('人员状态', $('#state'), "");
		getCodeSimple('是否全日制', $("#educations_i_type"), "");
		getCodeSimple('学历代码', $("#educations_i_education"), "");
		getCodeSimple('中华人民共和国学位代码', $("#educations_i_degree"), "");
		getCodeSimple('职级状态代码', $('#ranks_i_state'), "");
		getCodeSimple('专业技术职务代码', $('#technicalTitles_i_technicalTitle'), "");
	})
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
										+ '<input type="radio"  name="radio"  value="' +result[i].name+'"style="cursor:pointer;">'
										+ '<label for=""></label>'
										+ '<em>'
										+ result[i].name
										+ '</em>'
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
	$("#okBtn").click(function() {
		var tag1 = $("#tag1").val();
		var tag2 = $("#tag2").val();
		//籍贯
		if (tag2 == "0") {
			var selectedName = $('input[name="radio"]:checked').val();
			if (tag1 == "0") {
				$("#native_place").val(selectedName);
			} else {
				$("#birthplace").val(selectedName);
			}
		} else {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			checkCount = zTree.getCheckedNodes(true);
			var classpurview = checkCount[0].name;
			if (tag1 == "0") {
				$("#native_place").val(classpurview);
			} else {
				$("#birthplace").val(classpurview);
			}
		}
		$("#tag1").val("")
		$("#tag2").val("")
		$('#myModal').modal('hide');
	});
</script>