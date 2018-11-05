
/**
 * 
 * @param url
 * @param target
 * TODO 点击菜单生成tab栏
 */
function load(url,target){
	//获取需要添加的菜单栏信息
	var menu = $(target);
	var id = menu.attr("id");
	var text = menu.text();
	//获取容器
	var tab = $("#tab");
	var tabMenus = tab.children();
	var flag = false;
	$.each(tabMenus, function(i, n){
		var tabId = $(n).attr("data-tab");
		if (id == tabId) {
			//去除所有现在被选中的div的active状态
			tabMenus.removeClass("active");
			$("#body").children().removeClass("active");
			//将被选择的菜单设置为被选中状态
			$(n).addClass("active");
			$("div[data-tab='"+ id +"']").addClass("active");
			$('.menu .item').tab();
			flag = true;
		}
	});
	if (flag==false) {
		//去除所有现在被选中的div的active状态
		tabMenus.removeClass("active");
		$("#body").children().removeClass("active");
		//设置菜单
		var tabMenu = $('<a class="active item atab" data-tab=""></a>');
		tabMenu.attr("data-tab",id);
		tabMenu.text(text);
		tab.append(tabMenu);
		//设置内容
		var content = $('<div class="ui bottom attached tab segment active" data-tab="" style="padding: 0px;height: 100%"></div>');
		content.attr("data-tab",id);
		var iframe=$('<iframe id="iframe_'+id+'" class="iframes" frameborder="0" src="'+ url +'" style="height: 100%;width:100%" scrolling="yes"></iframe>');
		content.append(iframe);
		$("#body").append(content);
		$('.menu .item').tab();
		tabDoubleClick();
	}
}
//双击tab关闭
function tabDoubleClick() {
	$(".atab").unbind("dblclick");
	$(".atab").bind("dblclick", function() {
		//获取双击的tab的前一个元素
		var pre = $(this).prev();
		var preId = pre.attr("data-tab");
		pre.addClass("active");
		$("div[data-tab='"+ preId +"']").addClass("active");
		//获取双击的tab标识
		var id = $(this).attr("data-tab");
		//删除菜单及内容
		$(this).remove();
		$("div[data-tab='"+ id +"']").remove();
		$('.menu .item').tab();
	});
}

/*function Resize(id, height) {
	var iframe = $("#"+id);
	var a = document.body.scrollHeight;
	var b = document.body.clientHeight;
	if (height) {
		alert(height);
		iframe.height(a+height);
	}else{
		iframe.height(a+50);
	}
}

$(window).resize(function () {
	var div = $(".active.tab");
	var iframe = div.find(".iframes");
	var id = div.attr("data-tab");
    Resize("iframe"+id);
});*/