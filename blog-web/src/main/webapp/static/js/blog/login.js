$(function () {
    document.onkeydown = function(e){
        var ev = document.all ? window.event : e;
        if(ev.keyCode==13) {// 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发
            submitBlog();
        }
    }
});
function submitBlog() {
    var userName = $("#username").val();
    if (isEmpty(userName)) {
        $(".tip1").show();
        return;
    } else {
        $(".tip1").hide();
    }
    var password = $("#password").val();
    if (isEmpty(password)) {
        $(".tip2").show();
        return;
    } else {
        $(".tip2").hide();
    }
    $.ajax({
        url:"/login/ajaxLoginIndex?userName="+userName+"&password="+password,
        contentType:"application/x-www-form-urlencoded;charset=UTF-8",
        success:function (data) {
            if (data.code == "200") {
                loginIndexHtml();
            }else {
                $("#loginError").html(data.model.model.msg);
                $(".tip3").show();
                return;
            }
        }
    })
}


//登录成功后跳转至首页
function loginIndexHtml() {
    window.location.href = "/index"
}


