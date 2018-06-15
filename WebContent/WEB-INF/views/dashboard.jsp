<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<div class="mainContent">	
	<div id="tree" class="col-sm-2"></div>
	
</div>
<script>

$(function() {
	$("#index-page-title").html("提醒预览");
	$("#current-page-title").html("提醒预览");
});
<script>
<script type="text/javascript">
//选中/取消父节点时选中/取消所有子节点
function getChildNodeIdArr(node) {
  var ts = [];
  if (node.nodes) {
      for (x in node.nodes) {
          ts.push(node.nodes[x].nodeId);
          if (node.nodes[x].nodes) {
              var getNodeDieDai = getChildNodeIdArr(node.nodes[x]);
              for (j in getNodeDieDai) {
                  ts.push(getNodeDieDai[j]);
              }
          }
      }
  } else {
      ts.push(node.nodeId);
  }
  return ts;
}
//选中所有子节点时选中父节点
function setParentNodeCheck(node) {
  var parentNode = $("#tree").treeview("getNode", node.parentId);
  if (parentNode.nodes) {
      var checkedCount = 0;
      for (x in parentNode.nodes) {
          if (parentNode.nodes[x].state.checked) {
              checkedCount ++;
          } else {
              break;
          }
      }
      if (checkedCount === parentNode.nodes.length) {
          $("#tree").treeview("checkNode", parentNode.nodeId);
          setParentNodeCheck(parentNode);
      }
  }
}

$(function () {
  $.ajax({
      type: "Post",
      url: 'rest/unit/menu',  
      dataType: "json",
      success: function (result) {
          $('#tree').treeview({
              data: result.list,         // 数据源
              showCheckbox: true,   //是否显示复选框
              highlightSelected: true,    //是否高亮选中
              multiSelect: true,    //多选
              levels : 2,
              enableLinks : true,//必须在节点属性给出href属性
              color: "#010A0E",
              onNodeChecked : function (event,node) {
                  var selectNodes = getChildNodeIdArr(node); //获取所有子节点
                  if (selectNodes) { //子节点不为空，则选中所有子节点
                      $('#tree').treeview('checkNode', [selectNodes, { silent: true }]);
                  }
              },
              onNodeUnchecked : function(event, node) { //取消选中节点
                  var selectNodes = getChildNodeIdArr(node); //获取所有子节点
                  if (selectNodes) { //子节点不为空，则取消选中所有子节点
                      $('#tree').treeview('uncheckNode', [selectNodes, { silent: true }]);
                  }
              },
              
              onNodeExpanded : function(event, data) {
                      
              },
                  
              onNodeSelected: function (event, data) {
                  //alert(data.nodeId);
              }
                  
          });
      },
      error: function () {
          alert("菜单加载失败！")
      }
  });
})
</script>
