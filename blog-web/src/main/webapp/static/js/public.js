$(function () {

    var message = "<div class='message'>" +
        "<span class='success'></span>" +
        "<span class='fail'></span>" +
        "</div>" //提示

    //图标
    var load = "<div class='loading-box'><svg version=\"1.1\" id=\"L7\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\" viewBox=\"0 0 100 100\" enable-background=\"new 0 0 100 100\" xml:space=\"preserve\">\n" +
        " <path fill=\"#fff\" d=\"M31.6,3.5C5.9,13.6-6.6,42.7,3.5,68.4c10.1,25.7,39.2,38.3,64.9,28.1l-3.1-7.9c-21.3,8.4-45.4-2-53.8-23.3\n" +
        "  c-8.4-21.3,2-45.4,23.3-53.8L31.6,3.5z\" transform=\"rotate(279 50 50)\">\n" +
        "      <animateTransform attributeName=\"transform\" attributeType=\"XML\" type=\"rotate\" dur=\"1s\" from=\"0 50 50\" to=\"360 50 50\" repeatCount=\"indefinite\"></animateTransform>\n" +
        "  </path>\n" +
        "</svg></div>"

    /*弹窗*/
    $(".close,.none").click(function () {
        $(this).parents(".pop").css("display","none");
    })

    $("i,a,button").click(function () {
        var id = $(this).attr("name");
        $("#"+id+"").css("display","block");
    });

    /*提交*/
    $(".submi").click(function () {
        $(this).append(load).addClass("ant-btn-loading");
        $(this).parents().addClass("submi-fox");/*submi-fox系为遮罩层-提交完成后移除该CLASS  */
        setTimeout(function(){  //弹窗自动消失
            $(".submi-fox .loading-box").remove();
            $(".submi-fox").removeClass("submi-fox");
            $(".pop").css("display","none");
            $("body").append(message);
            $(".message .success").text("提交成功");
        },2000);
        setTimeout(function(){  //提示自动消失
            $(".message").remove();
        },4000);
    });

    /*勾选复选框*/
    $(document).on("click",".check-box.checker .check-list label:not('.unbind')", function () {
        $(this).toggleClass("check");

        //退款拆分按钮控制
        if ($("#refundSplitRadio").find("label").hasClass("check")){
            $(".split-table-but .add-but").css("display","block");//新增付款方按钮
            $(".receiptRefundAmount").attr('readonly',true);//勾选后禁用收款上的退款金额
        } else {
            if($("#receiptRow").find("td[name =payInfoId]").length>0){
                new layer({
                    layerCertain: true,
                    content: '取消拆分付款,将会删除所有拆分数据'
                }, function () {
                    $(".split-table-but .add-but").css("display","none");
                    $(".flagTable thead").addClass("hidden");
                    $(".flagTable tbody tr").remove();
                    $(".receiptRefundAmount").attr('readonly',false);
                    $("#refundSplitRadio").find("label").removeClass("check");
                    return;
                });
                $("#refundSplitRadio").find("label").addClass("check");
            }else {
                $(".split-table-but .add-but").css("display","none");
                $(".flagTable thead").addClass("hidden");
                $(".flagTable tbody tr").remove();
                $(".receiptRefundAmount").attr('readonly',false);
            }
        }
    });

    /*勾选单选框*/
    $(document).on("click",".check-box.radio .check-list label", function () {
        $(this).parent().parent().find("label").removeClass("check");
        $(this).addClass("check");

        //退款新增付款方，公司/个人控制
        var name = $(this).attr("name")
        if (name == "外部个人"){
            $(".taxpayerinfo").css("display","block");
        }else {
            $(".taxpayerinfo").css("display","none");
        }
    });

    //
    // /*tab*/
    // $(".modular-tab span").click(function () {
    //     var name = $(this).attr("name");
    //     $(".modular-tab span").removeClass("active");
    //     $(this).addClass("active");
    //     $(".table-conten .modular-table").addClass("hidden").removeClass("show");
    //     $(".table-conten").find("."+ name + "-table").removeClass("hidden").addClass("show");
    // })

    //输入框离焦，聚焦改变背景色
    $(document).on("focus",".input-red input", function () {
        var $parent = $(this).parents(".input-red");
        $parent.addClass("input-edit");
    })
    $(document).on("blur",".input-red input", function () {
        $(".input-red").removeClass("input-edit");
    })

    /*查询条件折叠*/
    $(".modular-head .slidetoggle").click(function () {
        $(this).toggleClass("toggle");
        $(this).parent(".modular-head").toggleClass("slide-head");
        $(this).parent(".modular-head").next().slideToggle(100);
    })

    $(".content-down").click(function () {
        $(this).find(".slidetoggle").toggleClass("toggle");
        $(this).next().slideToggle(100);
    })

})


/*刷新页面弹框*/
function reloadCommonHtml() {
    window.location.reload();
}

