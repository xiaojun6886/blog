$(function () {
    $("#full-name").on("blur",function () {
        var fullName = $(this).val();
        $.ajax({
            url:"/login/ajaxGetFullName?fullName="+fullName,
            contentType:"application/x-www-form-urlencoded;charset=UTF-8",
            success:function (data) {
                if (data.code == "200") {
                    $.errorMsg("此用户名已存在，请重新输入")
                }
            }
        })
    });
});

//注册
function registerBlog() {
    var fullName = $("#full-name").val();
    var email = $("#email").val();
    var password = $("#password").val();
    var rePassword = $("#rePassword").val();
    var phoneNum = $("#phoneNum").val();
    var flag = $("#agreeRegister")[0].control.checked;
    if (fullName === "") {
        $.errorMsg("用户名不能为空！");
        return;
    }
    if (email === "") {
        $.errorMsg("邮箱不能为空！");
        return;
    }
    if (phoneNum === "") {
        $.errorMsg("手机号不能为空！");
        return;
    }
    if (password === "") {
        $.errorMsg("密码不能为空！");
        return;
    }
    //校验邮箱
    var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    if(!reg.test(email)){
        $.errorMsg("邮箱格式不正确");
        return;
    }
    //校验手机号
    var pho = /^0?1[3|4|5|6|7|8][0-9]\d{8}$/;
    if(!pho.test(phoneNum)){
        $.errorMsg("手机号有误！请重新输入");
        return;
    }
    //校验密码复杂度
    var pwdRegex = new RegExp('(?=.*[0-9])(?=.*[a-zA-Z]).{8,16}');
    if (!pwdRegex.test(password)) {
        $.errorMsg("您的密码复杂度太低（密码中必须包含字母、数字）");
        return;
    }
    //校验两次输入密码是否一致
    if (!password === rePassword){
        $.errorMsg("两次输入密码不一致，请重新输入！");
        return;
    }

    var paramBean = {"fullName":fullName,"email":email,"phoneNum":phoneNum,"password":password};

    if (flag) {
        $.ajax({
            type:"POSt",
            url:"/login/ajaxRegisterBlog",
            data:paramBean,
            success:function (data) {
                if (data.code == "200") {
                    $.reloadMsg("注册成功！点击跳转至登录页面");
                } else {
                    $.errorMsg("注册失败！")
                }
            }
        })
    } else {
        $.errorMsg("请同意注册协议！")
    }
}

//注册成功后跳转至登录页面
function reloadLoginHtml() {
    window.location.href = "/login"
}
//返回登录页面
function backLogin() {
    window.location.href = "/login"
}
