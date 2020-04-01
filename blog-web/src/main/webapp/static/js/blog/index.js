var blogDetailId = "BLOG20200401095822";
// var queryBean = [];
// queryBean.push({
//     blogDetailId:blogDetailId
// });
var url = "/article/detail?blogDetailId="+blogDetailId;
function query() {
    $.ajax({
        url:url,
        contentType:"application/json",
        success:function (data) {
            window.location.href = '/article/detail';
        }
    })
}