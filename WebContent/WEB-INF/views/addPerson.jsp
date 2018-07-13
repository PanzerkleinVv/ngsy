<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="mainContent row0 row">
	<form role="form" class="form-horizontal needs-validation" autocomplete="off" enctype="multipart/form-data">
		<input type="hidden" id="id" name="id" value="${person != null ? person.id : ''}" />
		<div class="col-md-9 tableRow">
			<div class="form-group tableRow">
				<label class="col-md-1 control-label" for="name">姓名</label>
				<div class="col-md-3">
					<input class="form-control" name="name" type="text" id="name" placeholder="姓名" required value="${person != null ? person.name : ''}" />
					<p class="help-block"></p>
				</div>
				<label class="col-md-1 control-label" for="sex">性别</label>
				<div class="col-md-3">
					<input type="hidden" id="sexValue" disabled="disabled" value="${person != null ? person.sex : ''}" /> <select id="sex" name="sex" class="form-control" required>
						<option value="">选择性别</option>
					</select>
					<p class="help-block"></p>
				</div>
				<label class="col-md-1 control-label" for="birthday">出生年月</label>
				<div class="col-md-3">
					<input type="text" placeholder="点击选择日期" id="birthday" name="birthday" class="form-control tableDate" required value="<c:if test='${person != null}'><fmt:formatDate value='${person.birthday}' type='DATE' pattern='yyyy-MM-dd' /></c:if>" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="form-group tableRow">
				<label class="col-md-1 control-label" for="nationality">民族</label>
				<div class="col-md-3">
					<input type="hidden" id="nationalityValue" disabled="disabled" value="${person != null ? person.nationality : ''}" /> <select id="nationality" name="nationality" class="form-control" required>
						<option value="">选择民族</option>
					</select>
					<p class="help-block"></p>
				</div>
				<label class="col-md-1 control-label" for="nativePlace">籍贯</label>
				<div class="col-md-3">
					<input class="form-control" type="text" id="nativePlaceView" onclick="find('人员籍贯代码','0')" placeholder="点击选择" required /> <input name="nativePlace" type="hidden" id="nativePlace" value="${person != null ? person.nativePlace : ''}" />
					<p class="help-block"></p>
				</div>
				<label class="col-md-1 control-label" for="birthplace">出生地</label>
				<div class="col-md-3">
					<input class="form-control" type="text" id="birthplaceView" onclick="find('人员籍贯代码','1')" placeholder="点击选择" required /> <input name="birthplace" type="hidden" id="birthplace" value="${person != null ? person.birthplace : ''}" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="form-group tableRow">
				<label class="col-md-1 control-label" for="party">政治面貌</label>
				<div class="col-md-3">
					<input type="hidden" id="partyValue" disabled="disabled" value="${person != null ? person.party : ''}" /> <select id="party" name="party" class="form-control" required>
						<option value="">政治面貌</option>
					</select>
					<p class="help-block"></p>
				</div>
				<label class="col-md-1 control-label" for="partydate">入党时间</label>
				<div class="col-md-3">
					<input type="text" placeholder="点击选择日期" id="partydate" name="partydate" class="form-control tableDate" value="<c:if test='${person != null}'><fmt:formatDate value='${person.partydate}' type='DATE' pattern='yyyy-MM-dd' /></c:if>" />
					<p class="help-block"></p>
				</div>
				<label class="col-md-1 control-label" for="workDate">参加工作时间</label>
				<div class="col-md-3">
					<input type="text" placeholder="点击选择日期" id="workDate" name="workDate" class="form-control tableDate" required value="<c:if test='${person != null}'><fmt:formatDate value='${person.workDate}' type='DATE' pattern='yyyy-MM-dd' /></c:if>" />
					<p class="help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-3 tableRow butRow uploadPhoto">
			<label for="photo"><img id="photoView" src="rest/person/photo?id=${person != null ? person.id : ''}" width="160px" height="200px" /></label> <input type="file" name="photo" id="photo" accept="image/*" style="display: none;" />
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="health">健康状况</label>
				<div class="col-md-3-16">
					<input type="hidden" id="healthValue" disabled="disabled" value="${person != null ? person.health : ''}" /> <select id="health" name="health" class="form-control" required>
						<option value="">健康状况</option>
					</select>
					<p class="help-block"></p>
				</div>
				<label class="col-md-1-16 control-label" for="state">人员状态</label>
				<div class="col-md-3-16">
					<input type="hidden" id="stateValue" disabled="disabled" value="${person != null ? person.state : ''}" /> <select id="state" name="state" class="form-control" required>
						<option value="">人员状态</option>
					</select>
					<p class="help-block"></p>
				</div>
				<label class="col-md-1-16 control-label" for="salaryRankId">考勤课酬</label>
				<div class="col-md-3-16">
					<input class="form-control" name="salaryRankId" type="text" id="salaryRankId" placeholder="考勤课酬" value="${person != null ? person.salaryRankId : ''}" />
					<p class="help-block"></p>
				</div>
				<label class="col-md-1-16 control-label" for="shuangDhiDate">双师认定时间</label>
				<div class="col-md-3-16">
					<input type="text" placeholder="点击选择日期" id="shuangShiDate" name="shuangShiDate" class="form-control tableDate" value="<c:if test='${person != null}'><fmt:formatDate value='${person.shuangShiDate}' type='DATE' pattern='yyyy-MM-dd' /></c:if>" />
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="idCard">身份证号</label>
				<div class="col-md-4-16">
					<input class="form-control" name="idCard" type="text" id="idCard" placeholder="身份证号" required value="${person != null ? person.idCard : ''}" />
					<p class="help-block"></p>
				</div>
				<label class="col-md-2-16 control-label" for="specialty">熟悉专业有何专长</label>
				<textarea class="col-md-4-16 form-control" name="specialty" id="specialty" rows="3" placeholder="熟悉专业有何专长">${person != null ? person.specialty : ''}</textarea>
				<label class="col-md-2-16 control-label" for="enterDate">进入本单位工作时间</label>
				<div class="col-md-3-16">
					<input type="text" placeholder="点击选择日期" id="enterDate" name="enterDate" class="form-control tableDate" required value="<c:if test='${person != null}'><fmt:formatDate value='${person.enterDate}' type='DATE' pattern='yyyy-MM-dd' /></c:if>" />
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
					<c:set var="i0" value="0" />
					<c:if test="${person != null && person.technicalTitles != null}">
						<c:forEach var="technicalTitle" items="${person.technicalTitles}" varStatus="status">
							<c:set var="i0" value="${status.index}" />
							<div class="row addRow form-group">
								<input type="hidden" id="technicalTitles${status.index}id" name="technicalTitles[${status.index}].id" value="${technicalTitle.id}" />
								<span class="col-md-9-16">
									<input type="hidden" class="hiddenValue" disabled="disabled" value="${technicalTitle.technicalTitle}" /> <select id="technicalTitles${status.index}technicalTitle" name="technicalTitles[${status.index}].technicalTitle" class="form-control smForm get_ct0" required>
										<option value="">职称</option>
									</select>
								</span>
								<span class="col-md-3-16">
									<input type="text" placeholder="点击选择日期" id="technicalTitles${status.index}ownDate" name="technicalTitles[${status.index}].ownDate" class="form-control tableDate" required value="<c:if test='${person != null}'><fmt:formatDate value='${technicalTitle.ownDate}' type='DATE' pattern='yyyy-MM-dd' /></c:if>" />
								</span>
								<span class="col-md-3-16">
									<input type="text" placeholder="点击选择日期" id="technicalTitles${status.index}jobDate" name="technicalTitles[${status.index}].jobDate" class="form-control tableDate" value="<c:if test='${person != null}'><fmt:formatDate value='${technicalTitle.jobDate}' type='DATE' pattern='yyyy-MM-dd' /></c:if>" />
								</span>
								<span class="col-md-1-16 butRow">
									<a onclick="deleteRow(this)" class="delBut"><i class='fa fa-trash-o'></i></a>
								</span>
							</div>
						</c:forEach>
					</c:if>
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
					<c:set var="i1" value="0" />
					<c:if test="${person != null && person.educations != null}">
						<c:forEach var="education" items="${person.educations}" varStatus="status">
							<c:set var="i1" value="${status.index}" />
							<div class="row addRow form-group">
								<input type="hidden" id="educations${status.index}id" name="educations[${status.index}].id" value="${education.id}" />
								<span class="col-md-2-16">
									<input type="hidden" class="hiddenValue" disabled="disabled" value="${education.type}" /> <select id="educations${status.index}type" name="educations[${status.index}].type" class="form-control smForm get_ct1" required>
										<option value="">类型</option>
									</select>
								</span>
								<span class="col-md-2-16">
									<input type="hidden" class="hiddenValue" disabled="disabled" value="${education.education}" /> <select id="educations${status.index}education" name="educations[${status.index}].education" class="form-control smForm get_ct2" required>
										<option value="">学历</option>
									</select>
								</span>
								<span class="col-md-2-16">
									<input type="hidden" class="hiddenValue" disabled="disabled" value="${education.degree}" /> <select id="educations${status.index}degree" name="educations[${status.index}].degree" class="form-control smForm get_ct3" required>
										<option value="">学位</option>
									</select>
								</span>
								<span class="col-md-3-16">
									<input type="text" placeholder="毕业院校" id="educations${status.index}school" name="educations[${status.index}].school" class="form-control smForm" required value="${education.school}" />
								</span>
								<span class="col-md-3-16">
									<input type="text" placeholder="专业" id="educations${status.index}specialty" name="educations[${status.index}].specialty" class="form-control smForm" required value="${education.specialty}" />
								</span>
								<span class="col-md-2-16">
									<input type="text" placeholder="点击选择日期" id="educations${status.index}graduationDate" name="educations[${status.index}].graduationDate" class="form-control tableDate smForm" required value="<c:if test='${person != null}'><fmt:formatDate value='${education.graduationDate}' type='DATE' pattern='yyyy-MM-dd' /></c:if>" />
								</span>
								<span class="col-md-1-16 butRow">
									<input type="checkbox" id="educations${status.index}isHighest" name="educations[${status.index}].isHighest" value="1" ${education.isHighest == '1' ? 'checked="checked"' : ''} />
								</span>
								<span class="col-md-1-16 butRow">
									<a onclick="deleteRow(this)" class="delBut"><i class='fa fa-trash-o'></i></a>
								</span>
							</div>
						</c:forEach>
					</c:if>
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
					<c:set var="i2" value="0" />
					<c:if test="${person != null && person.ranks != null}">
						<c:forEach var="rank" items="${person.ranks}" varStatus="status">
							<c:set var="i2" value="${status.index}" />
							<div class="row addRow form-group">
								<input type="hidden" id="ranks${status.index}id" name="ranks[${status.index}].id" value="${rank.id}" />
								<span class="col-md-9-16">
									<input type="hidden" class="hiddenValue" disabled="disabled" value="${rank.rank}" /> <select id="ranks${status.index}rank" name="ranks[${status.index}]rank" class="form-control" required>
										<option value="">职级</option>
									</select>
								</span>
								<span class="col-md-3-16">
									<input type="text" placeholder="点击选择日期" id="ranks${status.index}ownDate" name="ranks[${status.index}].ownDate" class="form-control tableDate" required value="<c:if test='${person != null}'><fmt:formatDate value='${rank.ownDate}' type='DATE' pattern='yyyy-MM-dd' /></c:if>" />
								</span>
								<span class="col-md-3-16">
									<input type="hidden" class="hiddenValue" disabled="disabled" value="${rank.state}" /> <select id="ranks${status.index}state" name="ranks[${status.index}].state" class="form-control get_ct4" required>
										<option value="">职级状态</option>
									</select>
								</span>
								<span class="col-md-1-16 butRow">
									<a onclick="deleteRow(this)" class="delBut"><i class='fa fa-trash-o'></i></a>
								</span>
							</div>
						</c:forEach>
					</c:if>
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
					<input class="form-control" name="xianRenZhiWu" type="text" id="xianRenZhiWu" placeholder="现任职务" value="${person != null ? person.xianRenZhiWu : ''}" />
					<p class="help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="niRenZhiWu">拟任职务</label>
				<div class="col-md-15-16">
					<input class="form-control" name="niRenZhiWu" type="text" id="niRenZhiWu" placeholder="拟任职务" value="${person != null ? person.niRenZhiWu : ''}" />
					<p class="help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="niMianZhiWu">拟免职务</label>
				<div class="col-md-15-16">
					<input class="form-control" name="niMianZhiWu" type="text" id="niMianZhiWu" placeholder="拟免职务" value="${person != null ? person.niMianZhiWu : ''}" />
					<p class="help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="rank">简历</label>
				<div class="col-md-15-16">
					<div class="row">
						<span class="col-md-3-16 innerLabel">起始时间</span>
						<span class="col-md-3-16 innerLabel">结束时间</span>
						<span class="col-md-9-16 innerLabel">简历</span>
						<span class="col-md-1-16 innerLabel">删除</span>
					</div>
					<c:set var="i3" value="0" />
					<c:if test="${person != null && person.resumes != null}">
						<c:forEach var="resume" items="${person.resumes}" varStatus="status">
							<c:set var="i3" value="${status.index}" />
							<div class="row addRow form-group">
								<input type="hidden" id="resumes${status.index}id" name="resumes[${status.index}].id" value="${resume.id}" />
								<span class="col-md-3-16">
									<input type="text" placeholder="点击选择日期" id="resumes${status.index}beginDate" name="resumes[${status.index}].beginDate" class="form-control tableDate" required value="<c:if test='${person != null}'><fmt:formatDate value='${resume.beginDate}' type='DATE' pattern='yyyy-MM-dd' /></c:if>" />
								</span>
								<span class="col-md-3-16">
									<input type="text" placeholder="点击选择日期" id="resumes${status.index}endDate" name="resumes[${status.index}].endDate" class="form-control tableDate" value="<c:if test='${person != null}'><fmt:formatDate value='${resume.endDate}' type='DATE' pattern='yyyy-MM-dd' /></c:if>" />
								</span>
								<span class="col-md-9-16">
									<textarea class="form-control" name="resumes[${status.index}].content" id="resumes${status.index}content" rows="3" placeholder="简历" required>${resume.content}</textarea>
								</span>
								<span class="col-md-1-16 butRow">
									<a onclick="deleteRow(this)" class="delBut"><i class='fa fa-trash-o'></i></a>
								</span>
							</div>
						</c:forEach>
					</c:if>
					<div class="col-md-16-16 butRow addRow">
						<button id="3But" type="button" class="btn btn-info" onclick="add('3')">增加</button>
					</div>
					<p class="col-md-16-16 help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow">
			<div class="form-group">
				<label class="col-md-1-16 control-label" for="family">主要家庭成员及重要社会关系</label>
				<div class="col-md-15-16">
					<div class="row">
						<span class="col-md-2-16 innerLabel">称谓</span>
						<span class="col-md-2-16 innerLabel">姓名</span>
						<span class="col-md-2-16 innerLabel">年龄</span>
						<span class="col-md-3-16 innerLabel">政治面貌</span>
						<span class="col-md-6-16 innerLabel">工作单位及职务</span>
						<span class="col-md-1-16 innerLabel">删除</span>
					</div>
					<c:set var="i4" value="0" />
					<c:if test="${person != null && person.resumes != null}">
						<c:forEach var="family" items="${person.families}" varStatus="status">
							<c:set var="i4" value="${status.index}" />
							<div class="row addRow form-group">
								<input type="hidden" id="families${status.index}id" name="families[${status.index}].id" value="${family.id}" />
								<span class="col-md-2-16">
									<input type="hidden" class="hiddenValue" disabled="disabled" value="${family.relation}" /> <select id="families${status.index}relation" name="families[${status.index}].relation" class="form-control get_ct5" required>
										<option value="">称谓</option>
									</select>
								</span>
								<span class="col-md-2-16">
									<input type="text" placeholder="姓名" id="families${status.index}name" name="families[${status.index}].name" class="form-control" value="${family.name}" required />
								</span>
								<span class="col-md-2-16">
									<input type="number" placeholder="年龄" id="families${status.index}age" name="families[${status.index}].age" class="form-control" min="0" max="150" step="1" value="${family.age}" />
								</span>
								<span class="col-md-3-16">
									<input type="hidden" class="hiddenValue" disabled="disabled" value="${family.party}" /> <select id="families${status.index}party" name="families[${status.index}].party" class="form-control get_ct6" required>
										<option value="">政治面貌</option>
									</select>
								</span>
								<span class="col-md-6-16">
									<textarea class="form-control" name="families[${status.index}].job" id="families${status.index}job" rows="2" placeholder="工作单位及职务" required>${family.job}</textarea>
								</span>
								<span class="col-md-1-16 butRow">
									<a onclick="deleteRow(this)" class="delBut"><i class='fa fa-trash-o'></i></a>
								</span>
							</div>
						</c:forEach>
					</c:if>
					<div class="col-md-16-16 butRow addRow">
						<button id="4But" type="button" class="btn btn-info" onclick="add('4')">增加</button>
					</div>
					<p class="col-md-16-16 help-block"></p>
				</div>
			</div>
		</div>
		<div class="col-md-16-16 tableRow butRow">
			<button type="submit" class="col-md-16-16 addRow btn green" onclick="">保存</button>
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
	<input type="hidden" id="0Next" value="${i0}" disabled="disabled" /> <input type="hidden" id="1Next" value="${i1}" disabled="disabled" /> <input type="hidden" id="2Next" value="${i2}" disabled="disabled" /> <input type="hidden" id="3Next" value="${i3}" disabled="disabled" /> <input type="hidden" id="4Next" value="${i4}" disabled="disabled" />
	<div id="0">
		<div class="row addRow form-group">
			<input type="hidden" id="technicalTitles_i_id" name="technicalTitles[_i_].id" />
			<span class="col-md-9-16">
				<select id="technicalTitles_i_technicalTitle" name="technicalTitles[_i_].technicalTitle" class="form-control smForm" required>
					<option value="">职称</option>
				</select>
			</span>
			<span class="col-md-3-16">
				<input type="text" placeholder="点击选择日期" id="technicalTitles_i_ownDate" name="technicalTitles[_i_].ownDate" class="form-control tableDate" required />
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
		<div class="row addRow form-group">
			<input type="hidden" id="educations_i_id" name="educations[_i_].id" />
			<span class="col-md-2-16">
				<select id="educations_i_type" name="educations[_i_].type" class="form-control smForm" required>
					<option value="">类型</option>
				</select>
			</span>
			<span class="col-md-2-16">
				<select id="educations_i_education" name="educations[_i_].education" class="form-control smForm" required>
					<option value="">学历</option>
				</select>
			</span>
			<span class="col-md-2-16">
				<select id="educations_i_degree" name="educations[_i_].degree" class="form-control smForm" required>
					<option value="">学位</option>
				</select>
			</span>
			<span class="col-md-3-16">
				<input type="text" placeholder="毕业院校" id="educations_i_school" name="educations[_i_].school" class="form-control smForm" required />
			</span>
			<span class="col-md-3-16">
				<input type="text" placeholder="专业" id="educations_i_specialty" name="educations[_i_].specialty" class="form-control smForm" required />
			</span>
			<span class="col-md-2-16">
				<input type="text" placeholder="点击选择日期" id="educations_i_graduationDate" name="educations[_i_].graduationDate" class="form-control tableDate smForm" required />
			</span>
			<span class="col-md-1-16 butRow">
				<input type="checkbox" id="educations_i_isHighest" name="educations[_i_].isHighest" />
			</span>
			<span class="col-md-1-16 butRow">
				<a onclick="deleteRow(this)" class="delBut"><i class='fa fa-trash-o'></i></a>
			</span>
		</div>
	</div>
	<div id="2">
		<div class="row addRow form-group">
			<input type="hidden" id="ranks_i_id" name="ranks[_i_].id" />
			<span class="col-md-9-16">
				<select id="ranks_i_rank" name="ranks[_i_]rank" class="form-control" required>
					<option value="">职级</option>
				</select>
			</span>
			<span class="col-md-3-16">
				<input type="text" placeholder="点击选择日期" id="ranks_i_ownDate" name="ranks[_i_].ownDate" class="form-control tableDate" required />
			</span>
			<span class="col-md-3-16">
				<select id="ranks_i_state" name="ranks[_i_].state" class="form-control" required>
					<option value="">职级状态</option>
				</select>
			</span>
			<span class="col-md-1-16 butRow">
				<a onclick="deleteRow(this)" class="delBut"><i class='fa fa-trash-o'></i></a>
			</span>
		</div>
	</div>
	<div id="3">
		<div class="row addRow form-group">
			<input type="hidden" id="resumes_i_id" name="resumes[_i_].id" />
			<span class="col-md-3-16">
				<input type="text" placeholder="点击选择日期" id="resumes_i_beginDate" name="resumes[_i_].beginDate" class="form-control tableDate" required />
			</span>
			<span class="col-md-3-16">
				<input type="text" placeholder="点击选择日期" id="resumes_i_endDate" name="resumes[_i_].endDate" class="form-control tableDate" />
			</span>
			<span class="col-md-9-16">
				<textarea class="form-control" name="resumes[_i_].content" id="resumes_i_content" rows="3" placeholder="简历" required></textarea>
			</span>
			<span class="col-md-1-16 butRow">
				<a onclick="deleteRow(this)" class="delBut"><i class='fa fa-trash-o'></i></a>
			</span>
		</div>
	</div>
	<div id="4">
		<div class="row addRow form-group">
			<input type="hidden" id="families_i_id" name="families[_i_].id" />
			<span class="col-md-2-16">
				<select id="families_i_relation" name="families[_i_].relation" class="form-control" required>
					<option value="">称谓</option>
				</select>
			</span>
			<span class="col-md-2-16">
				<input type="text" placeholder="姓名" id="families_i_name" name="families[_i_].name" class="form-control" required />
			</span>
			<span class="col-md-2-16">
				<input type="number" placeholder="年龄" id="families_i_age" name="families[_i_].age" class="form-control" min="0" max="150" step="1" />
			</span>
			<span class="col-md-3-16">
				<select id="families_i_party" name="families[_i_].party" class="form-control" required>
					<option value="">政治面貌</option>
				</select>
			</span>
			<span class="col-md-6-16">
				<textarea class="form-control" name="families[_i_].job" id="families_i_job" rows="2" placeholder="工作单位及职务" required></textarea>
			</span>
			<span class="col-md-1-16 butRow">
				<a onclick="deleteRow(this)" class="delBut"><i class='fa fa-trash-o'></i></a>
			</span>
		</div>
	</div>
</div>
<script type="text/javascript" src="app/js/personCard.js"></script>
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
		$("#index-page-title").html("人员新增");
		$("#current-page-title").html("人员新增");
	});
	$(function() {
		getCodeNameValue('人员籍贯代码', $("#nativePlace").val(), $("#nativePlaceView"));
		getCodeNameValue('人员籍贯代码', $("#birthplace").val(), $("#birthplaceView"));
		getCodeSimple('人的性别代码', $('#sex'), $("#sexValue").val());
		getCodeSimple('中国各民族名称代码', $("#nationality"), $("#nationalityValue").val());
		getCodeSimple('政治面貌代码', $("#party"), $("#partyValue").val());
		getCodeSimple('健康状况代码', $("#health"), $("#healthValue").val());
		getCodeSimple('人员状态', $('#state'), $("#stateValue").val());
		getCodeSimple('是否全日制', $("#educations_i_type"), "");
		getCodeSimple('学历代码', $("#educations_i_education"), "");
		getCodeSimple('中华人民共和国学位代码', $("#educations_i_degree"), "");
		getCodeSimple('职级状态代码', $('#ranks_i_state'), "");
		getCodeSimple('专业技术职务代码', $('#technicalTitles_i_technicalTitle'), "");
		getCodeSimple('家庭关系代码', $('#families_i_relation'), "");
		getCodeSimple('政治面貌代码', $('#families_i_party'), "");
		getCodeSimpleLocal('专业技术职务代码', '.get_ct0');
		getCodeSimpleLocal('是否全日制', '.get_ct1');
		getCodeSimpleLocal('学历代码', '.get_ct2');
		getCodeSimpleLocal('中华人民共和国学位代码', '.get_ct3');
		getCodeSimpleLocal('职级状态代码', '.get_ct4');
		getCodeSimpleLocal('家庭关系代码', '.get_ct5');
		getCodeSimpleLocal('政治面貌代码', '.get_ct6');
	})
	function getCodeSimpleLocal(codeType, targetClass) {
		$(targetClass).each(function(i, n) {
			getCodeSimple(codeType, $(n), $(n).prev('input.hiddenValue').val());
		});
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
				$(form).ajaxSubmit({
					type : 'post',
					url : "rest/person/save",
					success : function(result) { //表单提交后更新页面显示的数据
						$('#main-content').html(result);
					}
				});
			},
			rules : {
				"idCard" : {
					checkIdCard : true
				},
				"photo" : {
					checkPhotoSize : true
				}
			}
		});
	});

	jQuery.validator.addMethod("checkPhotoSize", function(value, element) {
		if (element.files.length == 0) {
			return true;
		}
		var fileSize = element.files[0].size;
		var maxSize = 3 * 1024 * 1024;
		if (fileSize > maxSize) {
			return false;
		} else {
			return true;
		}
	}, "请上传大小在3MB以下的图片");

	$("#photo").change(function(e) {
		var url = null;
		if (this.files.length > 0) {
			var file = e.target.files[0] || e.dataTransfer.files[0];
			if (file) {
				var reader = new FileReader();
				reader.onload = function() {
					url = this.result;
					$("#photoView").attr("src", url);
				}
				reader.readAsDataURL(file);
			}
		} else {
			url = 'rest/person/photo?id=' + $("#id").val();
			$("#photoView").attr("src", url);
		}
	});
</script>