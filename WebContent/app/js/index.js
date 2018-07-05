$(function() {
	App.init();

	var Index = (function() {
		var me = {};

		// 处理一级菜单点击
		me.handleMenuClick = function() {
			$('#page-sidebar-menu > li').click(function(e) {
				var menu = $('#page-sidebar-menu');
				var li = menu.find('li.active').removeClass('active');

				// 添加选中 打开的样式
				// $(this).addClass('active');
			});
		};

		// 处理子菜单点击
		me.handleSubMenuClick = function() {
			$('#page-sidebar-menu li a').click(function(e) {
				e.preventDefault();
				var url = this.href;
				if (url != null && url != 'javascript:;') {
					$.post(url, function(data) {
						showData("#main-content", data);
					});
				}
			});
		};

		me.init = function() {
			me.handleMenuClick();
			me.handleSubMenuClick();
		};

		return me;
	})();

	Index.init();

	$('#btn-dashboard').trigger("click");
});

function showData(target, data) {
	switch (target) {
	case "#main-content":
		$("#main-content").show();
		$("#main-content").html(data);
		$("#msg-content").hide();
		$("#goBack").hide();
		break;
	case "#msg-content":
		$("#msg-content").show();
		$("#msg-content").html(data);
		$("#main-content").hide();
		$("#goBack").show();
		break;
	}
}

function goBack() {
	query($("#pageNo").val());
	$("#main-content").show();
	$("#msg-content").hide();
	$("#goBack").hide();
}

/**
 * 获取数据字典下拉菜单option
 * 
 * @param name
 *            对应code_type表的name
 * @param target
 *            目标select的jQuery对象（需用$()封装后传入）
 * @param selected
 *            传入当前选定的option的value
 * @returns null，在目标select对象内append数据字典option
 */
function getCodeSimple(name, target, selected) {
	var url = 'rest/code/get';
	$.post(url, {
		'name' : name
	}, function(data) {
		if (data.length != 0) {
			$.each(data, function(i, n) {
				if (selected == n.code) {
					target.append('<option value="' + n.code
							+ '" selected="selected">' + n.name + '</option>');
				} else {
					target.append('<option value="' + n.code + '">' + n.name
							+ '</option>');
				}
			});
		}
	});
}

function getCodeName(typeName, value, target) {
	$.ajax({
		type : "Get",
		url : 'rest/code/getCodeName',
		dataType : "json",
		data : {
			'code' : value,
			'name' : name
		},
		success : function(result) {
			target.html(result.name);
		}
	});
}