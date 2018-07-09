<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<c:set var="i" value="0" />
	<div class="col-md-3">
		<div class="mainContent">
		<form id="dutiesPersonForm">
			<input type="hidden" name="unitId" value="${unit.id}" />
			<div class="multipleList sortable">
				<c:forEach items="${dutiesPersonExtends}" var="dutiesPersonExtend" varStatus="status" >
					<c:set var="i" value="${status.index}" />
					<div class="multipleList-row sortableLine">
						<input type="hidden" name="dutiesPersonExtend[${status.index}].id"
								class="dutyPersonId" value="${dutiesPersonExtend.id}" />
						<span>${dutiesPersonExtend.personName}</span>
						<input type="hidden"
								name="dutiesPersonExtend[${status.index}].sort" class="dutyPersonSort"
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
<div class="col-md-9">
	<div class="userTable">
		<div class="userRow userHeader">
			<span class="userItem">姓名</span> <span class="userItem">职务</span>
			<span class="userItem">入职时间</span> <span class="userItem">是否试用</span>
			<span class="userItem">试用期至</span><span class="userItem" style="min-width:150px">操作</span>
		</div>
		<c:forEach items="${dutiesPersonExtends}" var="dutiesPersonExtend" varStatus="status" > 
					 <div class="userRow">
	    					<span class="userItem"><input name="id" id="dutiesPersonExtendId" 
					type="hidden" value="${dutiesPersonExtend.id}" />${dutiesPersonExtend.personName}</span>
	    					<span class="userItem">${dutiesPersonExtend.dutiesName} </span>
	    					<span class="userItem">${dutiesPersonExtend.ownDate} </span>
	    					<span class="userItem">${dutiesPersonExtend.isProbation} </span>
	    					<span class="userItem">${dutiesPersonExtend.probationDate} </span>
	    					<span class="userItem">
	    					<a class="btn btn-success" id="Regular"><i class="halflings-icon white zoom-in"></i>转正</a>
	    					<a class="btn btn-info" id="Lost"><i class="halflings-icon white edit"></i>退休</a>
	    					<a class="btn btn-danger" id="Del"><i class="halflings-icon white trash"></i>免职</a>
	    					</span>
	    			</div>
        </c:forEach>  
		</div>
	</div>
	<!--任命-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 400px;">
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
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="name" >职务</label >
							<div class="controls">
								<input class="input-clarge focused" name="duties_name" type="text" style="width: 216px;" id="duties_name">
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
								<select id="is_probation" style="width: 230px;" name="is_probation">
									<option>是</option>
									<option>否</option>
								</select>
							</div>											
						</div>
						<div class="control-group">
							<label class="control-label" for="probation_date" >试用期至</label >
							<div class="controls">
								<input class="input-clarge focused" name="probation_date" type="date"  style="width: 216px;" id="probation_date">
							</div>											
						</div>				
					</fieldset>
				</form>

			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">关闭</a>
				<a id="AddDutiesPeople" class="btn btn-primary">增加信息</a>
			</div>
		</div>
	</div>
</div>
		</div>
<script type="text/javascript">
   
	$("#addInformation").click(function(){
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
			
</script>