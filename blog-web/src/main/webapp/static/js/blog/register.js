$(function () {
    $("#full-name").on('blur',function () {
        var fullName = $("#full-name").val();
        $.ajax({
            url:"/login/ajaxGetFullName?fullName="+fullName,
            contentType:"application/x-www-form-urlencoded;charset=UTF-8",
            success:function (data) {

            }
        })
    });
});

function registerBlog() {
    var fullName = $("#full-name").val();
    var email = $("#email").val();
    var password = $("#password").val();
    var flag = $("#agreeRegister")[0].control.checked;
    var paramBean = {"fullName":fullName,"email":email,"password":password};
    if (flag) {
        $.ajax({
            type:"POSt",
            url:"/login/ajaxRegisterBlog",
            contentType:"application",
            data:paramBean,
            success:function (data) {
                if (data.status == "200") {
                    alert("注册成功！")
                } else {
                    alert("注册失败！")
                }
            }
        })
    } else {
        alert("请同意注册协议！")
    }
}


