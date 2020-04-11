$(function () {

});
function submitBlog() {
    var userName = $("#username").val();
    var password = $("#password").val();
    $.ajax({
        url:"/login/ajaxLoginIndex?userName="+userName+"&password="+password,
        contentType:"application/x-www-form-urlencoded;charset=UTF-8",
        success:function (data) {
            if (data.code == "200") {
                $.reloadMsg("登录成功！点击跳转至首页")
            }else {
                $.errorMsg("账号或者密码错误，请重新输入！")
                return;
            }
        }
    })
}

//登录成功后跳转至首页
function loginIndexHtml() {
    window.location.href = "/index"
}


