<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<style type="text/css">
    div {
margin-top:10px,
}
</style>
<% 
	int resumenum=0;
%>
<input type="hidden" name="resumenum" value="<%=resumenum%>">
<div class="mainContent">	
		<div class="row" style="margin-bottom:20px">
			<form id="uploadForm" enctype="multipart/form-data" method="post">
					<table>
						<tr>
							<td>请选择文件:</td>
							<td><input style="border:1px solid black;" id="fileID" type="file" name="file" multiple /></td>
							<td><button type="button" onclick="doUpload()">上传</button></td>
						</tr>
					</table>
			</form>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-10">
						<div class="row" style="border:1px solid #ccc;border-bottom:none;">
							<div class="col-md-12">
								<div class="col-md-1" >
									<label class="control-label" for="name">姓名</label>
								</div>
								<div class="col-md-5" >
									<input class="input-clarge focused" name="name" type="text"  id="name" style="margin-top:7px;margin-bottom:7px;">
								</div>
								<div class="col-md-1" >
									<label class="control-label" for="sex">性别</label>
								</div>
								<div class="col-md-5">
									<select id="sex" name="sex" style="margin-top:7px;margin-bottom:7px;">
										<option></option>
									</select>
								</div>
							</div>
						</div>
						<div class="row" style="border:1px solid #ccc;border-bottom:none;">
							<div class="col-md-12">
								<div class="col-md-1" >
									<label class="control-label" for="birthday">出生年月</label>
								</div>
								<div class="col-md-5" >
									<input size="16" type="text" style="cursor:pointer;margin-top:7px;margin-bottom:7px;" placeholder="点击选择日期"
								id="birthday"
								class="form_date form-control placeholder-no-fix halfWidth"
								>
								</div>
								<div class="col-md-1" >
									<label class="control-label" for="nationality">民族</label>
								</div>
								<div class="col-md-5" >
									<select id="nationality" name="nationality"style="margin-top:7px;margin-bottom:7px;">
										<option></option>
									</select>
								</div>
							</div>
						</div>
					   <div class="row" style="border:1px solid #ccc;border-bottom:none;">
							<div class="col-md-12">
								<div class="col-md-1" >
									<label class="control-label" for="native_place">籍贯</label>
								</div>
								<div class="col-md-5" >
									<input class="input-clarge focused" name="native_place" type="text"  id="native_place" style="margin-top:7px;margin-bottom:7px;">
									<button type="button" class="btn btn-info" onclick="find('人员籍贯代码','0')">选择</button>
								</div>
								<div class="col-md-1" >
									<label class="control-label" for="birthplace">出生地</label>
								</div>
								<div class="col-md-5" >
									<input class="input-clarge focused" name="birthplace" type="text"  id="birthplace" style="margin-top:7px;margin-bottom:7px;">
									<button type="button" class="btn btn-info" onclick="find('人员籍贯代码','1')">选择</button>
								</div>
							</div>
						</div>
					<div class="row" style="border:1px solid #ccc;border-bottom:none;">
						<div class="col-md-12">
							<div class="col-md-1" >
								<label class="control-label" for="party">政治面貌</label>
							</div>
							<div class="col-md-5" >
								<select id="party" name="party"style="margin-top:7px;margin-bottom:7px;">
									<option></option>
								</select>
							</div>
							<div class="col-md-1" >
								<label class="control-label" for="partydate">照片</label>
							</div>
							<div class="col-md-5">
								<form id="uploadForm" enctype="multipart/form-data" method="post">
								<table>
									<tr>
										<td><input style="border:1px solid black;" id="fileID" type="file" name="file" multiple /></td>
										<td><button type="button" class="btn btn-info" onclick="">浏览</button><td>
									</tr>
								</table>
					            </form>
							</div>
						</div>
					</div>
			</div>
			<!-- 照片位置 -->
			<div class=col-md-2>
				<div class="row" style="border:1px solid #ccc;border-bottom:none;">
					<div class="col-md-12" >
						
					</div>
				</div>
		    </div>
		</div>
			
	</div>
</div>
		<div class="row">
		<div class="col-md-12">
			<div class="row" style="border:1px solid #ccc;border-bottom:none;">
					<div class="col-md-1" >
						<label class="control-label" for="partydate">入党时间</label>
					</div>
					<div class="col-md-3">
						<input size="16" type="text"  style="cursor:pointer;margin-top:7px; margin-bottom:7px;" placeholder="点击选择日期"
						id="partydate"
						class="form_date form-control placeholder-no-fix halfWidth" 
						>
					</div>
					<div class="col-md-1" >
						<label class="control-label" for="work_date">参加工作时间</label>
					</div>
					<div class="col-md-3">
						<input size="16" type="text"  style="cursor:pointer;margin-top:7px; margin-bottom:7px;" placeholder="点击选择日期"
						id="work_date"
						class="form_date form-control placeholder-no-fix halfWidth" 
						>
					</div>
			</div>
			
			<div class="row" style="border:1px solid #ccc;border-bottom:none;">
					<div class="col-md-1" >
						<label style="" class="control-label" for="salary_rank_id">考勤课酬</label>
					</div>
					<div class="col-md-3" > 	
						<input class="input-clarge focused" name="salary_rank_id" type="text"  id="salary_rank_id" style="margin-top:7px;margin-bottom:7px;">
					
					</div>
					<div class="col-md-1" >
						<label class="control-label" for="id_card">身份证号</label>
					</div>
					<div class="col-md-3">
						<input class="input-clarge focused" name="id_card" type="text" id="id_card" style="margin-top:7px;margin-bottom:7px;">
					</div>
					<div class="col-md-1" >
						<label class="control-label" for="health" >健康状况</label>
					</div>
					<div class="col-md-3">
						<select id="health" name="health" style="margin-top:7px;margin-bottom:7px;">
							<option></option>
						</select>
					</div>
			</div>
		<div class="row" style="border:1px solid #ccc;border-bottom:none;">
					<div class="col-md-2" >
						<label class="control-label" for="shuang_shi_date">双师认定时间</label>
					</div>
					<div class="col-md-4">
						<input size="10" type="text"  style="cursor:pointer;margin-top:7px; margin-bottom:7px;" placeholder="点击选择日期"
						id="shuang_shi_date"
						class="form_date form-control placeholder-no-fix halfWidth" 
						>
					</div>
					<div class="col-md-2" >
						<label class="control-label" for="enter_date">进入本单位工作时间</label>
					</div>
					<div class="col-md-4">
						<input size="16" type="text" style="cursor:pointer;margin-top:7px; margin-bottom:7px;" placeholder="点击选择日期"
						id="enter_date"
						class="form_date form-control placeholder-no-fix halfWidth" 
						>
					</div>
			</div>
			<div class="row" style="border:1px solid #ccc;border-bottom:none;">
				<div class="col-md-2" >
					<label class="control-label" for="technical_title">专业技术职称</label>
				</div>
				<div class="col-md-4">
					<input  class="input-clarge focused" name="name" type="text"  id="name" style="margin-top:7px;margin-bottom:7px;">		
				</div>
				<div class="col-md-2" >
					<label class="control-label" for="specialty">熟悉专业有何专长</label>
				</div>
				<div class="col-md-4">
					<input  class="input-clarge focused" name="specialty" type="text"  id="specialty" style="margin-top:7px;margin-bottom:7px;"> 		
				</div>	
			</div>
	<div class="row" style="border:1px solid #ccc;border-bottom:none;">
		<div class="col-md-2" >
					<label class="control-label" for="xian_ren_zhi_wu">现任职务</label>
				</div>
				<div class="col-md-10">
					<input style="width:500px;margin-top:7px;margin-bottom:7px;" class="input-clarge focused" name="xian_ren_zhi_wu" type="text"  id="xian_ren_zhi_wu">		
				</div>	
	</div>
	<div class="row" style="border:1px solid #ccc;border-bottom:none;">
		<div class="col-md-2" >
					<label class="control-label" for="ni_ren_zhi_wu">拟任职务</label>
				</div>
				<div class="col-md-10">
					<input style="width:500px;margin-top:7px;margin-bottom:7px;"  name="ni_ren_zhi_wu" type="text"  id="ni_ren_zhi_wu">		
				</div>	
	</div>
	<div class="row" style="border:1px solid #ccc;border-bottom:none;">
		<div class="col-md-2" >
					<label class="control-label" for="ni_mian_zhi_wu">拟免职务</label>
				</div>
				<div class="col-md-10">
					<input style="width:500px;margin-top:7px;margin-bottom:7px;" class="input-clarge focused" name="ni_mian_zhi_wu" type="text"  id="ni_mian_zhi_wu">		
				</div>	
	</div>
	<div class="row" style="border:1px solid #ccc;">
		<div class="col-md-2" >
					<label class="control-label" for="resume">简历</label>
				</div>
				<div class="col-md-10" >
					<input style="width:500px;margin-top:7px;margin-bottom:7px;" class="input-clarge focused" name="resume" type="text"  id="resume">
					<button type="button" class="btn btn-info" onclick="addResume()">增加</button>
					<span id="zjadd"></span>
				</div>
				
	</div>
	</div>
</div>	
		
		<!-- <div class="col-md-3" style="height: 200px;">
			<label class="control-label" for="sex">性别wwwwwww</label>
		</div> -->
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  			<div class="modal-dialog" style="width:400px;">
   				<div class="modal-content">
     				<div class="modal-header">
     					
							<button type="button" class="close" data-dismiss="modal">×</button>
							<h4 class="modal-title" id="myModalLabel">人员籍贯代码</h4>
							<input class="input-clarge focused" name="name" type="text"  id="codeName" style="margin-top:7px;margin-bottom:7px;">
						    <button type="button" class="btn btn-info" onclick="onClickfind()">查找</button>
					
					</div>
						<div class="modal-body" id="modal_body">
							<div id="treeDemo" class="ztree" style="height:300px;overflow:auto"></div>
							<div  id="color"  style="width:360px;height:300px;overflow:auto"></div>
						</div>
						<div class="modal-footer">
							<button href="#" class="btn" data-dismiss="modal">关闭</button>
							<button id="okBtn" class="btn btn-primary">确定</button>
						</div>
    				</div><!-- /.modal-content -->
  				</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<div style="display:none">
		<input id="tag1" type="text">
	</div>
	<div style="display:none">
		<input id="tag2" type="text">
	</div>
</div>


<script type="text/javascript">
var setting = {
		view: {
			dblClickExpand: false,
			selectedMulti: false
		},
		check: {
			enable: true,
			chkStyle: "radio",  //单选框
	        radioType: "all"   //对所有节点设置单选
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		edit: {
			enable: false
		},
		callback: {
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
var resumenum=<%=resumenum%>;
	$(document).ready(function() {
		$(".form_date").datepicker({
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
		getCodeSimple('中国各民族名称代码',$("#nationality"),"");
		getCodeSimple('政治面貌代码',$("#party"),"");
		getCodeSimple('健康状况代码',$("#health"),"");
	})
	function deleteitem(obj,name){
		  //if (comfirm("确实要删除该记录吗？")){
		  obj.value="0"
		  //alert(obj.value)
		  var elements=document.getElementsByName(name);//查找文档中所以id为name的元素
			//document.all.fam1.style.display="block"
			for(var i=0;i<elements.length;i++){
				//alert("ok")
				elements[i].style.display="none"		
			} 
		  //}
			return;
		}
	function addResume(){
		resumenum = resumenum+1
		document.all.resumenum.value=resumenum
		console.log(resumenum)
		var html = "<div name="+'resume1'+resumenum+">"+"<input style="+'width:500px;margin-top:10px;'+" class="+'input-clarge focused'+" name="+'resume'+resumenum+" type="+'text'+"  id="+'resume'+resumenum+">"
		+"<input type=hidden name=xlavail"+resumenum+" value=1>"
		+"<a href=\"javascript:deleteitem(document.all.xlavail"+resumenum+",'resume1"+resumenum+"')\">×</a></div>"
		document.all.zjadd.insertAdjacentHTML("beforeBegin",html)
		
	}
	//点击选择按钮的籍贯
	function find(name,tag){
		$.ajax({
		      type: "Post",
		      url: 'rest/code/getJiGuan',  
		      data: {'name' : name},
		      dataType: "json",
		      success: function (result) {
		    	  $.fn.zTree.init($("#treeDemo"), setting, result);
		    	  document.getElementById("color").style.display="none";
		    	  document.getElementById("treeDemo").style.display="";
		    	  $("#tag1").val("");
		    	  $("#tag1").val(tag);
		    	  $('#myModal').modal('show'); 
		      },
		      error: function () {
		          alert("菜单加载失败！")
		      }
		  });
		
		
	}
	//模糊查找
	function onClickfind(){
		$.ajax({
			  type:"Post",
			  url :'rest/code/getJiGuanByName',
			  data: {'name' : $("#codeName").val()},
		      dataType: "json",
		      success: function (result) {
		    	  var html = "";
		    	  if(result.length >0){
			    	  for(var i=0;i<result.length;i++){
			    		  html += '<span class="radio_box" style="margin-right:30px">'+
		                   		'<input type="radio"  name="radio"  value="' +result[i].name+'"style="cursor:pointer;">'+
		                        '<label for=""></label>'+
		                        '<em>'+result[i].name+'</em>'+'</span><br>'
			    	  }
		    	  }
		    	  else{
		    		  var html = '<label style="text-align:center;"class="control-label" for="name">'+"查询不到数据"+'</label>';
		    	  }
		    	  $("#codeName").val("");
		    	  $('#color').html(html);
		    	  document.getElementById("color").style.display="";
		    	  document.getElementById("treeDemo").style.display="none";
		    	  $("#tag2").val("");
		    	  $("#tag2").val("0");
		    	  $('#myModal').modal('show'); 
		      },
		      error: function () {
		          alert("菜单加载失败！")
		      }
		  });
	}
	$("#okBtn").click(function(){
		var tag1 = $("#tag1").val();
		var tag2 = $("#tag2").val();
		//籍贯
		if(tag2=="0"){
			var selectedName=$('input[name="radio"]:checked').val();
			if(tag1=="0"){
				$("#native_place").val(selectedName);
			}
			else{
				$("#birthplace").val(selectedName);
			}
		}
		else{
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			checkCount = zTree.getCheckedNodes(true);
			var classpurview = checkCount[0].name;
			if(tag1=="0"){
				$("#native_place").val(classpurview);
			}
			else{
				$("#birthplace").val(classpurview);
			}
		}
		$("#tag1").val("")
		$("#tag2").val("")
		$('#myModal').modal('hide'); 
		
	})
</script>