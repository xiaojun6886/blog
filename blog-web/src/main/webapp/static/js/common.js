var $backToTopEle=$('<a href="javascript:void(0)" class="Hui-iconfont toTop" title="返回顶部" alt="返回顶部" style="display:none">^^</a>').appendTo($("body")).click(function(){
	$("html, body").animate({ scrollTop: 0 }, 120);
});
var backToTopFun = function() {
	var st = $(document).scrollTop(), winh = $(window).height();
	(st > 0)? $backToTopEle.show(): $backToTopEle.hide();
	/*IE6下的定位*/
	if(!window.XMLHttpRequest){
		$backToTopEle.css("top", st + winh - 166);
	}
};
	$(function(){
		$(window).on("scroll",backToTopFun);
		backToTopFun();
	});

//时间戳转时间格式
function getTsFormatDate(timeStamp) {
    var date = new Date(timeStamp);
    //console.log(date); 结果为：Tue Apr 02 2019 07:49:23 GMT+0800 (中国标准时间)
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

//异步加载最新发布数据
$(function () {
    $.ajax({
        url:"/ajaxGetIndexDetail",
        contentType:"application/json",
        success:function (datas) {
            if (datas != null && datas.length>0) {
                var dataList = datas.slice(0,10);
                for (var i=0; i<dataList.length;i++) {
                    var title = dataList[i].title;
                    var blogDetailId = dataList[i].blogDetailId;
                    var hrefId =  "/article/detail/"+ blogDetailId;
                    var titleContent =
                        '<li><a href='+hrefId+' target="_blank">'+title+'</a></li>';
                    $("#titleCon").append(titleContent);
                }
            }
        }
    })
});

function logoMenu() {
    window.location.href = "/login"
}
function registerMenu() {
    window.location.href = "/login/register"
}