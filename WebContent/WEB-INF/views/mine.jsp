<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainContent">
	<div class="infoMethod">
		个人信息<input name="id" id="id" type="hidden"
			value="<c:if test='${user != null}'>${user.id}</c:if>" />
	</div>
	<div style="color:${msg0};">${msg}</div>
	<div>
		<span>用户名：</span> <span><c:if test='${user != null}'>${user.username}</c:if></span>
		<input name="username" id="username" type="hidden"
			value="<c:if test='${user != null}'>${user.username}</c:if>" />
	</div>
	<div>
		<span>用户姓名：</span> <span><c:if test='${user != null}'>${user.userdesc}</c:if></span>
		<input name="userdesc" id="userdesc" type="hidden"
			value="<c:if test='${user != null}'>${user.userdesc}</c:if>" />
	</div>
	<div>
		<span>所属处室：</span> <span><c:if test='${user != null}'>${roleMap[user.roleId]}</c:if></span>
	</div>
	<div>
		<span>权限类型：</span> <span><c:if test='${user != null}'>${permissionMap[user.permissionId]}</c:if></span>
	</div>
	<div>
		<span>新密码：</span> <span><input name="password"
			id="password" type="password" value="" onblur="check0()" class="form-control placeholder-no-fix"/></span>
	</div>
	<div id='msg0' style='display: none;'></div>
	<div>
		<span>再次输入：</span> <span><input name="password0"
			id="password0" type="password" value="" onblur="check1()" class="form-control placeholder-no-fix"/></span>
	</div>
	<div id='msg1' style='display: none;'></div>
	<div class="infoButton">
		<button id="saveBut" type="button" class="btn blue">修改密码</button>
	</div>

	<script src="app/lib/security/sha256.js" type="text/javascript"></script>
	<script type="text/javascript">
		function check0() {
			var item0 = $('#msg0');
			var value0 = $('#password').val();
			if (value0 == null || value0.length == 0) {
				item0.css('display', 'block');
				item0.css('color', '#FF0000');
				item0.html('密码不能为空');
				return false;
			} else if (value0.length < 6) {
				item0.css('display', 'block');
				item0.css('color', '#FF0000');
				item0.html('密码太短（至少6位）');
				return false;
			} else if (value0.length > 15) {
				item0.css('display', 'block');
				item0.css('color', '#FF0000');
				item0.html('密码太长（至多15位）');
				return false;
			} else if (value0.search('[^\\w\\d]+') > -1) {
				item0.css('display', 'block');
				item0.css('color', '#FF0000');
				item0.html('密码只能是英文或数字');
				return false;
			} else {
				item0.css('display', 'block');
				item0.css('color', '#00FF00');
				item0.html('OK');
				return true;
			}
		}
		function check1() {
			var item0 = $('#msg1');
			var value0 = $('#password').val();
			var value1 = $('#password0').val();
			if (value0 != value1) {
				item0.css('display', 'block');
				item0.css('color', '#FF0000');
				item0.html('两次输入密码不一致');
				return false;
			} else {
				item0.css('display', 'block');
				item0.css('color', '#00FF00');
				item0.html('OK');
				return true;
			}
		}
		$('#saveBut').click(function() {
			var url = 'rest/user/psw';
			if (check0() && check1()) {
				var psw = sha256_digest($('#password').val());
				$.post(url, {
					id : $('#id').val(),
					password : psw,
					username : $('#username').val(),
					userdesc : $('#userdesc').val()
				}, function(data) {
					$('#main-content').html(data);
				});
			}
		});
		$('form').keypress(function(e) {
			var keynum;
			if (window.event) // IE
			{
				keynum = e.keyCode;
			} else if (e.which) // Netscape/Firefox/Opera
			{
				keynum = e.which;
			}
			if (keynum == 13) {
				return false;
			}
		});

		$(function() {
			$("#index-page-title").html("个人信息");
			$("#current-page-title").html("个人信息");
		});
	</script>
</div>