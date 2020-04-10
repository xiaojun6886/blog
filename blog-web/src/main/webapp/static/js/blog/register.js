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
    $("#email").on("blur",function () {
        var email = this.value;
        var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
        if(reg.test(email)){
            alert("邮箱格式正确");
        }else{
            if (email === ""){
                $("#email").val("请输入邮箱")
            } else {
                alert("邮箱格式不正确");
            }
        }
    })

    $("#phoneNum").on("blur",function () {
        var phoneNum = this.value;
        var pho = /^1[3456789]\d{9}$/;
        if(pho.test(phoneNum)){
            alert("邮箱格式正确");
        }else{
            if (phoneNum === ""){
                $("#phoneNum").val("请输入手机号")
            } else {
                alert("号码有误！请重新输入");
            }
        }
    })
});


function registerBlog() {
    var fullName = $("#full-name").val();
    var email = $("#email").val();
    var password = $("#password").val();
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
    var paramBean = {"fullName":fullName,"email":email,"phoneNum":phoneNum,"password":password};
    if (flag) {
        $.ajax({
            type:"POSt",
            url:"/login/ajaxRegisterBlog",
            data:paramBean,
            success:function (data) {
                if (data.code == "200") {
                    $.reloadMsg("注册成功！");
                    reloadCommonHtml();
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
function reloadCommonHtml() {
    window.location.href = "/login"
}
//返回登录页面
function backLogin() {
    window.location.href = "/login"
}
