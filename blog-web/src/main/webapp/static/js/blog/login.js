$(function () {

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
                $.reloadMsg("登录成功！点击跳转至首页")
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


