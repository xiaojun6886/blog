$(function () {
    $("#full-name").on("blur",function () {
        var fullName = $(this).val();
        $.ajax({
            url:"/login/ajaxGetFullName?fullName="+fullName,
            contentType:"application/x-www-form-urlencoded;charset=UTF-8",
            success:function (data) {
                if (data.code == "200") {
                    $(".tip9").show();
                } else {
                    $(".tip9").hide();
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
    if (isEmpty(fullName)) {
        $(".tip4").show();
        return;
    } else {
        $(".tip4").hide();
    }
    if (isEmpty(email)) {
        $(".tip6").show();
        return;
    } else {
        $(".tip6").hide();
    }
    if (isEmpty(phoneNum)) {
        $(".tip7").show();
        return;
    } else {
        $(".tip7").hide();
    }
    if (isEmpty(password)) {
        $(".tip5").show();
        return;
    } else {
        $(".tip5").hide();
    }
    if (isEmpty(rePassword)) {
        $(".tip8").show();
        return;
    } else {
        $(".tip8").hide();
    }
    if (!flag) {
        $(".tip14").show();
        return;
    } else {
        $(".tip14").hide();
    }
    //校验邮箱
    var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    if(!reg.test(email)){
        $(".tip10").show();
        return;
    } else {
        $(".tip10").hide();
    }
    //校验手机号
    var pho = /^0?1[3|4|5|6|7|8][0-9]\d{8}$/;
    if(!pho.test(phoneNum)){
       $(".tip11").show();
        return;
    }else {
        $(".tip11").hide();
    }
    //校验密码复杂度
    var pwdRegex = new RegExp('(?=.*[0-9])(?=.*[a-zA-Z]).{8,16}');
    if (!pwdRegex.test(password)) {
        $(".tip12").show();
        return;
    } else {
        $(".tip12").hide();
    }
    //校验两次输入密码是否一致
    if (password != rePassword){
        $(".tip13").show();
        return;
    } else {
        $(".tip13").hide();
    }

    var paramBean = {"fullName":fullName,"email":email,"phoneNum":phoneNum,"password":password};

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
}

//注册成功后跳转至登录页面
function reloadLoginHtml() {
    window.location.href = "/login"
}
//返回登录页面
function backLogin() {
    window.location.href = "/login"
}
