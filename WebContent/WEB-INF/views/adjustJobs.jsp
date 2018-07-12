<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<c:set var="i" value="0" />
	<div class="col-md-2-3">
		<div class="mainContent">
		<form id="dutiesPersonForm">
			<div class="multipleList sortable">
			<input type="hidden" name="unitId" id="unitId" value="${unit.id}" />
				<c:forEach items="${dutiesPersonExtends}" var="dutiesPersonExtend" varStatus="status" >
					<c:set var="i" value="${status.index}" />
					<div class="multipleList-row sortableLine">
						<input type="hidden" name="dutiesPersonExtends[${status.index}].id"
								class="dutyPersonId" value="${dutiesPersonExtend.id}" />
						<span>${dutiesPersonExtend.personName}</span>
						<input type="hidden"
								name="dutiesPersonExtends[${status.index}].sort" class="dutyPersonSort"
								value="${dutiesPersonExtend.sort}" />
						
					</div>
				</c:forEach>
			</div>
			<div class="multipleList-row-ps"><span>操作说明：拖拽排序</span></div>
			<div class="multipleList-row-but">
				<button type="button" class="btn green" onclick="save()">保存</button>
				<a class="btn btn-primary" id="addInformation">任命</a>
			</div>
		</form>
		</div>
	</div>
<div class="col-md-9-10">
	<div class="userTable">
		<div class="userRow userHeader">
			<span class="userItem">姓名</span> <span class="userItem">职务</span>
			<span class="userItem">入职时间</span> <span class="userItem" style="min-width:20px">是否试用</span>
			<span class="userItem">试用期至</span><span class="userItem" style="min-width:150px">操作</span>
		</div>
		<c:forEach items="${dutiesPersonExtends}" var="dutiesPersonExtend" varStatus="status" > 
					 <div class="userRow">
	    					<span class="userItem"><input name="id" id="dutiesPersonExtendId" 
					type="hidden" value="${dutiesPersonExtend.id}" />${dutiesPersonExtend.personName}</span>
	    					<span class="userItem">${dutiesPersonExtend.dutiesName} </span>
	    					<span class="userItem">${dutiesPersonExtend.ownDateStr} </span>
	    					<span class="userItem">${dutiesPersonExtend.isProbation} </span>
	    					<span class="userItem">${dutiesPersonExtend.probationDateStr} </span>
	    					<span class="userItem">
	    					<a class="btn btn-success" onclick="Regular(this)" <c:if test="${dutiesPersonExtend.probationDate == null || dutiesPersonExtend.probationDate eq 'nullnull'}"> disabled="disabled"</c:if>
	    					><i class="halflings-icon white zoom-in"></i>转正</a>
	    					<a class="btn btn-info" onclick="Lost(this)"><i class="halflings-icon white edit"></i>退休</a>
	    					<a class="btn btn-danger" onclick="Del(this)"><i class="halflings-icon white trash"></i>免职</a>
	    					</span>
	    			</div>
        </c:forEach>  
		</div>
	</div>
	<!--任命-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	<div class="modal-dialog" style="width: 380px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>任命编辑</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="AddUserForm">
					<fieldset>		
						<div class="control-group">
							<label class="control-label" for="id">姓名</label>
							<div class="controls">
								<input class="input-clarge focused" name="person_name" type="text" style="width:216px" id="person_name">
								<div id="blurMsg">
								
								</div>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="name" >职务</label >
							<div class="controls">
								<select id="duties_name"  name="duties_name" style="width:216px">
									<option></option>
									<c:forEach items="${duties}" var="dutie" varStatus="status" > 
										<option value="${dutie.id}"> ${dutie.name} </option>
									</c:forEach>
								</select>
							</div>											
						</div>
						<div class="control-group">
							<label class="control-label" for="own_date" >任职时间</label >
							<div class="controls">
								<input class="input-clarge focused" name="own_date" type="date"  style="width: 216px;" id="own_date">
							</div>											
						</div>
						<div class="control-group">
							<label class="control-label" for="is_probation" >是否试用</label >
							<div class="controls">
								<select id="is_probation"  name="is_probation" style="width:216px" onchange="isProbationChange()">
									<option></option>
									<option>是</option>
									<option>否</option>
								</select>
							</div>											
						</div>
						<div class="control-group" id="probationDiv" style="display:none;">
							<label class="control-label" for="probation_date" >试用期至</label >
							<div class="controls">
								<input class="input-clarge focused" name="probation_date" type="date"  style="width: 216px;" id="probation_date">
							</div>											
						</div>				
					</fieldset>
				</form>

			</div>
			<div class="modal-footer">
				<a href="#" class="btn btn-success" data-dismiss="modal">关闭</a>
				<a id="AddDutiesPeople" onclick="AddDutiesPeople()" class="btn btn-primary">增加信息</a>
			</div>
		</div>
	</div>
</div>
		</div>
<script type="text/javascript">
   
	$("#addInformation").click(function(){
		document.getElementById("AddUserForm").reset(); 
		$("#blurMsg").css("display","none");
		$('#myModal').modal('show');
	})
	$(function() {
		var options = {
			target : "#unitContent",
			url : "rest/adjust/save",
			type : 'POST'
		};
		$('#dutiesPersonForm').ajaxForm(options);
		$(".sortable").sortable({
			cursor : "move",
			items : ".sortableLine",
			opacity : 0.8,
			placeholder : "multipleFormRow"
		});
		$(".sortable").bind('sortupdate', function(event, ui) {
			$(".dutyPersonSort").each(function(i, n) {
				$(n).val(i);
			});
		});
	});
	function save(target) {
		$('#dutiesPersonForm').submit();
	}
	function Lost(target) {
		var url = "rest/adjust/lostDuties";
		var rowDiv = $(target).parent().parent();
		var dutiesPersonExtendId = rowDiv.find("input[name='id']").val();
		layer.confirm('您是否要调整该人员为退休？', {
				  btn: ['确定','取消'] //按钮
				}, function(){
					$.post(url, {
						dutiesPersonExtendId : dutiesPersonExtendId,
						unitId : $("#unitId").val()
					}, function(data) {
						layer.msg('退休操作完成', {icon: 1});
						$("#unitContent").html(data);
					});
				});
	}
	function Regular(target){
		var url = "rest/adjust/regularDuties";
		var rowDiv = $(target).parent().parent();
		var dutiesPersonExtendId = rowDiv.find("input[name='id']").val();
		$.post(url,{
			dutiesPersonExtendId : dutiesPersonExtendId,
			unitId : $("#unitId").val()
		},function(data){
			layer.msg('转正操作完成', {icon: 1});
			$("#unitContent").html(data);
		});
	}
	function Del(target){
		var url = "rest/adjust/delDuties";
		var rowDiv = $(target).parent().parent();
		var dutiesPersonExtendId = rowDiv.find("input[name='id']").val();
		layer.confirm('您是否要调整该人员为免职？', {
			  btn: ['确定','取消'] //按钮
			}, function(){
			$.post(url,{
				dutiesPersonExtendId : dutiesPersonExtendId,
				unitId : $("#unitId").val()
			},function(data){
				layer.msg('免职操作完成', {icon: 1});
				$("#unitContent").html(data);
			});
		});
	}
	$("#person_name").blur(function(){
		var url = 'rest/adjust/personBlur';
		$.post(url,{
			personName:$("#person_name").val()
		},function(data){
			console.log(data);
			$("#blurMsg").removeAttr("style");
			if(data == false){
				var html = '<font style="color:red;">'+"人员库暂无此人信息"+'</font>';
				$("#blurMsg").html(html);
			}
			else{
				var html = '<font style="color:green;">'+"人员库有此人信息"+'</font>';
				$("#blurMsg").html(html);
			}
			
		})
	})
	
	function isProbationChange(){
		var options = $("#is_probation option:selected");
		if(options.text() == "是"){
			$("#probationDiv").removeAttr("style");
		}
		else{
			$("#probationDiv").css("display","none");
		}
	}
	
	function AddDutiesPeople(){
		$("#AddDutiesPeople").attr("disabled", true);
		var options=$("#duties_name option:selected");
		var url = 'rest/adjust/addDutiesPerson';
		$.post(url,{
			unitId : $("#unitId").val(),
			dutiesUnitId : options.val(),
			personName : $("#person_name").val(),
			isProbation : $("#is_probation").val(),
			ownDate : $("#own_date").val(),
			probationDate : $("#probation_date").val()
			
		},function(data){
			$(".modal-backdrop").remove();
			$("#unitContent").html(data);
		})
	}
	
</script>