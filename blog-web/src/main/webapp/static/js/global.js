;(function ($) {
    $.extend({
        errorMsg: function (msg) {
            $("#tips-text").text(msg);
            $("#tips").show();
        },
        errorMsgUse: function (msg) {
            $("#tips-msgText").text(msg);
            $("#msgMax").show();
        },
        maxErrorMsg: function (msg) {
            $("#maxTips-text").text(msg);
            $("#maxTips").show();
        },
        reloadMsg: function (msg) {
            $("#tipsReload-text").text(msg);
            $("#tipsReload").show();
        },
        newOption: function (text, value, selected) {
            var newOption = document.createElement("OPTION");
            newOption.text = text;
            newOption.value = value;
            if (selected) {
                newOption.selected = selected;
            }
            return newOption;
        }, select2Initialize: function () {
            $(".select2-data-search").each(function () {
                $(this).select2({
                    language: "zh-CN",
                    width: "100%",
                    selectOnBlur: true,
                    language: {
                        noResults: function (params) {
                            return "无匹配结果";
                        }
                    }
                });
            });
            $(".select2-data-all").each(function () {
                $(this).select2({
                    language: "zh-CN",
                    width: "100%",
                    selectOnBlur: true,
                    minimumResultsForSearch: -1,
                    language: {
                        noResults: function (params) {
                            return "无匹配结果";
                        }
                    }
                });
            });
        }, getContextPath: function (url) {
            return $.isEmptyObject(url) ? contextPath : (contextPath + url.trim());
        }, jointParams: function (url, obj) {
            var params = [];
            Object.keys(obj).forEach(function (key) {
                var value = obj[key];
                if (typeof value === 'undefined') {
                    value = ''
                }
                params.push([key, encodeURIComponent(value)].join('='))
            });
            var json = $.getContextPath(url) + "?" + params.join('&').trim();
            return json;
        }, errorTip: function (msg, time) {
            $("#error-tip").css("display", "inline-block");
            $("#error-tip .msg_span").text(msg);
            setTimeout("$.timeEror();", (isNullOrBlank(time) ? 2000 : time));
        }, timeEror: function () {
            $("#error-tip").css("display", "none");
        }, phoneValidation: function (str) {
            var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
            if (myreg.test(str)) {
                return false;
            } else {
                return true;
            }
        }
    });
    $.fn.extend({
        getTrimVal: function () {
            return $(this).val().trim();
        }, getTrimText: function () {
            return $(this).text().trim();
        }, getSelectedVal: function () {
            return $(this).find("option:selected").val();
        }, getSelectedText: function () {
            return $(this).find("option:selected").text();
        }, selectedValueChange: function (value) {
            $(this).val(value).trigger("change");
        }, selectedTextChange: function (value) {
            $(this).val(value).trigger("change");
        }, selectedValue: function (value) {
            $(this).val(value).select2();
        },
        serializeObject: function () {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value.trim() || '');
                } else {
                    o[this.name] = this.value.trim() || '';
                }
            });
            return o;
        }, closeModal: function () {
            $(this).css("display", "none");
        }, showModal: function () {
            $(this).css("display", "block");
        }, showBlock: function () {
            $(this).css("display", "block");
        }
    });
})(jQuery);


function check(str) {
    var temp = "";
    for (var i = 0; i < str.length; i++)
        if (str.charCodeAt(i) > 0 && str.charCodeAt(i) < 255)
            temp += str.charAt(i)
    return temp
}

/**
 * 查询条件日期初始化
 */
function initInputDate() {
    var startTime = moment().subtract(1, 'months').format("YYYY-MM-DD");//1个月前
    var endTime = (new moment()).format("YYYY-MM-DD");    // 今天时间;
    $(".default-start").val(startTime);
    $(".default-end").val(endTime);

    $('.datepicker').datetimepicker({
        format: 'yyyy-mm-dd',
        minView: "month",//设置只显示到月份
        autoclose: true,//选中关闭
        language: 'zh-CN',
        clearBtn: true,  //添加清除按钮，可选值：true/false
        todayBtn: true
    });

    //广点通微信（OMG）应收查询 日期显示到月份
    var periodNameStart = moment().subtract(1, 'months').format("YYYY-MM");//6个月前
    var periodNameEnd = (new moment()).format("YYYY-MM");    // 今天时间;
    $("#periodNameStart_txt_input").val(periodNameStart);
    $("#periodNameEnd_txt_input").val(periodNameEnd);
    $('.omgDatepicker').datetimepicker({
        format: 'yyyy-mm',
        startView: 3,  //年视图
        minView: "3", //最小视图年视图
        autoclose: true,//选中关闭
        language: 'zh-CN',
        clearBtn: true,  //添加清除按钮，可选值：true/false
    });

    //批量勾兑导入 时间显示到分钟
    var blendStart = moment().startOf('day').format("YYYY-MM-DD HH:mm:ss");//当天最早时间
    var blendEnd = moment().endOf('day').format("YYYY-MM-DD  HH:mm:ss"); // 当天最晚时间;
    $(".batch_blend-default-start").val(blendStart);
    $(".batch_blend-default-end").val(blendEnd);
    $('.batchBlendDatepicker').datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        minView: "0", //最小视图年视图
        autoclose: true,//选中关闭
        language: 'zh-CN',
        clearBtn: true,  //添加清除按钮，可选值：true/false
        todayBtn: true
    });

    //自动核销任务提交 日期显示到月份
    var periodNameStart = moment().format("YYYY-MM");//默认从2019-1开始
    var periodNameEnd = (new moment()).format("YYYY-MM");    // 今天时间;
    $("#glDateBegin_txt_input").val("");
    $("#glDateEnd_txt_input").val("");
    $('.taskDatepicker').datetimepicker({
        format: 'yyyy-mm',
        startView: 3,  //年视图
        minView: "3", //最小视图年视图
        autoclose: true,//选中关闭
        language: 'zh-CN',
        clearBtn: true,  //添加清除按钮，可选值：true/false
        //endDate:new Date()
    });


}

/* -------------------------------------------- */
/* 金额格式化方法                               */

/* -------------------------------------------- */
function formatAmount(eValue) {
    eValue = new String(eValue);
    eValue = new Number(eValue.replace(/,/g, '')).toFixed(2);
    var intPart = "";
    var decPart = "";
    if (eValue.indexOf(",") >= 0) {
        eValue = eValue.replace(/,/g, "");
    }
    if (eValue.indexOf(".") >= 0) {
        intPart = eValue.split(".")[0];
        decPart = eValue.split(".")[1];
    }
    else {
        intPart = eValue;
    }
    var num = intPart + "";
    var re = /(-?\d+)(\d{3})/
    while (re.test(num)) {
        num = num.replace(re, "$1,$2")
    }
    if (eValue.indexOf(".") >= 0) {
        eValue = num + "." + decPart;
    }
    else {
        eValue = num;
        if (eValue.length > 0 && eValue != 'NaN') eValue += ".00";
    }
    return eValue;
}


/*	MoneyInput
*	spectorye
*	2010-5-7
*	参考MonthInput
*/
MoneyInput = (function ($) {
    function MoneyInput(el) {
        this.input = $(el);
        var oThis = this;
        this.input.focus(function () {
            //oThis.input.val(oThis.stringToMoney(oThis.input.val()));
            if (oThis.input.val() == '') {
                oThis.input.val('0.00');
            }
            oThis.input.get()[0].select();
        });
        this.input.blur(function () {
            //alert(oThis.input.val());
            oThis.input.val(oThis.moneyToString(oThis.stringToMoney(oThis.input.val())));
        });
    };

    MoneyInput.prototype = {
        stringToMoney: function (string) {
            string = string.replace(/,/g, '');
            if (!isNaN(string)) {
                return string;
            }
            else {
                return 0.00;
            }
        },
        moneyToString: function (eValue) {
            try {
                //eValue = new Number(eValue).toFixed(2);
                var intPart = "";
                var decPart = "";
                if (eValue.indexOf(",") >= 0) {
                    eValue = eValue.replace(/,/g, "");
                }
                if (eValue.indexOf(".") >= 0) {
                    intPart = eValue.split(".")[0];
                    decPart = eValue.split(".")[1];
                }
                else {
                    intPart = eValue;
                }
                var num = intPart + "";
                var re = /(-?\d+)(\d{3})/
                while (re.test(num)) {
                    num = num.replace(re, "$1,$2");
                }
                if (eValue.indexOf(".") >= 0) {
                    eValue = num + "." + decPart;
                }
                else {
                    eValue = num;
                }
                return eValue;
            }
            catch (e) {
                return '';
            }
        }
    };

    $.fn.money_input = function () {
        return this.each(function () {
            new MoneyInput(this);
        });
    };
})(jQuery);

/**
 * 去掉字符串头尾空格
 * @param str 传入的字符串值
 * @author lqy
 * @since 2015-08-21
 */
function trim(str) {
    if (str == null || typeof str == "undefined") {
        return "";
    }
    return str.replace(/(^\s*)|(\s*$)/g, "");
};

/**
 * 是否为Null
 * @param object
 * @returns {Boolean}
 */
function isNull(object) {
    if (object == null || typeof object == "undefined") {
        return true;
    }
    return false;
};

/**
 * 是否为空字符串，有空格不是空字符串
 * @param str
 * @returns {Boolean}
 */
function isEmpty(str) {
    if (str == null || typeof str == "undefined" ||str == "" || str.length == 0) {
        return true;
    }
    return false;
};

/**
 * 是否为空字符串，全空格也是空字符串
 * @param str
 * @returns {Boolean}
 */
function isBlank(str) {
    if (str == null || typeof str == "undefined" ||
        str == "" || trim(str) == "") {
        return true;
    }
    return false;
};

function isNullOrBlank(mixed_var) {
    var key;
    if (mixed_var === "" || mixed_var === 0 || mixed_var === "0" || mixed_var === null || mixed_var === false || typeof mixed_var === 'undefined') {
        return true;
    }
    if (typeof mixed_var == 'object') {
        for (key in mixed_var) {
            return false;
        }
        return true;
    }
    return false;
};

/*提示框*/
function layer(styleChange, funOne, funTwo) {
    this.funOne = funOne || null;
    this.funTwo = funTwo || null;
    this.style = {
        title: '提示',
        content: '这是默认的提示',
        position: 'center',
        layerCertain: false,
    }
    if (styleChange != 'undefined') {
        this.forChangeStyle(styleChange);
    }
    this.init();
}

function request(paras) {
    var url = location.href;
    var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
    var paraObj = {}
    for (i = 0; j = paraString[i]; i++) {
        paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=") + 1, j.length);
    }
    var returnValue = paraObj[paras.toLowerCase()];
    if (typeof(returnValue) == "undefined") {
        return "";
    } else {
        return returnValue;
    }
}

layer.prototype = {
    init: function () {
        this.createDiv();
        if (this.style.layerCertain) {
            this.layerCertain();
        }
        this.closeLayer();
        this.layerConfirm(this.funOne);
        this.layerCancel(this.funTwo);
    },
    createDiv: function () {
        var iframe = document.createElement('div');
        var style = document.createElement("style");
        var classStyle = '';
        if (this.style.position == 'center') {
            classStyle = '.layerPosition{position:fixed;display:inline-block;width:80%;max-width: 600px;margin:auto';
        }
        else if (this.style.position == 'left') {
            classStyle = '.layerPosition{position:fixed;z-index:11;background:lightpink;display:inline-block;height:105px;width:200px;top:' + this.style.top + ';left:' + this.style.left + '';
        }
        iframe.className = 'layerPosition';
        style.appendChild(document.createTextNode(classStyle));
        var head = document.getElementsByTagName("head")[0];
        head.appendChild(style);
        iframe.innerHTML = '<h3>' + this.style.title + '<p style=""id="closeLayer"></p></h3><div class="bd">' + this.style.content + '</div><div class="fd"><button class="cancel">取消</button><button class="confirm">确定</button>';
        document.body.appendChild(iframe);
    },
    layerCertain: function () {
        var oCertain = document.createElement('div');
        var style = document.createElement("style");
        var classStyle = '';
        classStyle = '.layerCertain{position:fixed;z-index:2;top:0;left:0;bottom:0;right:0;background:rgba(0,0,0,0.4)}';
        style.appendChild(document.createTextNode(classStyle));
        var head = document.getElementsByTagName("head")[0];
        head.appendChild(style);
        oCertain.className = 'layerCertain';
        document.body.appendChild(oCertain);
    },
    closeLayer: function () {
        this.addHandler(document.getElementById('closeLayer'), 'click', function () {
            var certain = document.getElementsByClassName('layerCertain')[0] || null,
                layerPanel = document.getElementsByClassName('layerPosition')[0];
            if (certain) {
                certain.parentElement.removeChild(certain);
            }
            layerPanel.parentElement.removeChild(layerPanel);
        });
    },
    //这个是回调的重点
    layerConfirm: function (funOne) {
        var _this = this;
        this.addHandler(document.getElementsByClassName('confirm')[0], 'click', function () {
            if (funOne && typeof funOne == 'function') {
                funOne();
            }
            var certain = document.getElementsByClassName('layerCertain')[0] || null,
                layerPanel = document.getElementsByClassName('layerPosition')[0];
            if (certain) {
                certain.parentElement.removeChild(certain);
            }
            layerPanel.parentElement.removeChild(layerPanel);
        })
    },
    //这个是回调的重点
    layerCancel: function (funTwo) {
        var _this = this;
        this.addHandler(document.getElementsByClassName('cancel')[0], 'click', function () {
            if (funTwo && typeof funTwo == 'function') {
                funTwo();
            }
            var certain = document.getElementsByClassName('layerCertain')[0] || null,
                layerPanel = document.getElementsByClassName('layerPosition')[0];
            if (certain) {
                certain.parentElement.removeChild(certain);
            }
            layerPanel.parentElement.removeChild(layerPanel);
        })
    },
    addHandler: function (obj, type, fun) {
        obj.addEventListener ? obj.addEventListener(type, fun) : obj['on' + type] = fun;
    },
    forChangeStyle: function (styleChange) {
        for (var key in styleChange) {
            this.style[key] = styleChange[key];
        }
    }
}

String.prototype.format = function () {
    if (arguments.length == 0) return this;
    var param = arguments[0];
    var s = this;
    if (typeof(param) == 'object') {
        for (var key in param)
            s = s.replace(new RegExp("\\{" + key + "\\}", "g"), param[key]);
        return s;
    } else {
        for (var i = 0; i < arguments.length; i++)
            s = s.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i]);
        return s;
    }
}

/*将日期里的/ 替换成-*/
function replaceDateStr(str,keyWord) {
    var aa = "/";
    var val = str .replace(new RegExp(aa,'g'),keyWord)
    return val;
}

/*时间转时间戳*/
function dateToStamp(date) {
    date = date.replace(/-/g,'/');
    var timestamp = new Date(date).getTime();
    return timestamp;
}

//金额格式化
function toDecimal(x) {
    var f = parseFloat(x);
    if (isNaN(f)) {
        return 0.00;
    }
    f = Math.round(x*100)/100;
    return f;
}

//验证日期是否是yyyy-MM-dd格式
function dateIsYyyyDdMm(date) {
    if(isBlank(date)){
        return false;
    }
    dateFormat =/^(\d{4})-(\d{2})-(\d{2})$/;
    if(dateFormat.test(date)){
        return true;
    }else{
        return false; //false,不是yyyy-MM-dd格式
    }
}

/*校验2个金额是否是一正一负*/
function isDifferentType(a,b) {
  if(toDecimal(a) >0 && toDecimal(b) <0){
      return true;
  }
  if(toDecimal(a) <0 && toDecimal(b) >0){
      return true;
  }
  if(toDecimal(a) ==0 && toDecimal(b) != 0){
    return true;
  }
  if(toDecimal(a) !=0 && toDecimal(b) ==0){
    return true;
  }
  else {
      return false;
  }
}

/*校验输入的是否为金额，可为负数*/
function checkAmount(amount) {
    if(parseFloat(amount) == 0){
        return false;
    }
    var reg = /(^([-]?)[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^([-]?)(0){1}$)|(^([-]?)[0-9]\.[0-9]([0-9])?$)/;
    if( reg.test(amount)){
        return true;
    }
    return false;
}

/*校验输入的是否为金额，不可为负数*/
function checkAmountNot(amount) {
    if(parseFloat(amount) == 0){
        return false;
    }
    var reg = /(^([+]?)[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^([-]?)(0){1}$)|(^([-]?)[0-9]\.[0-9]([0-9])?$)/;
    if( reg.test(amount)){
        return true;
    }
    return false;
}

//格式化金额，加千分号和保留2位小数
function formatPointAmount(amount) {
    return toDecimal(amount).toFixed(2).split('').reverse().join('').replace(/(\d{3})(?=\d)/g, '$1,').split('').reverse().join('');
}

/* -------------------------------------------- */
/* 2010-08-30									*/
/* 换算金额为目标汇率的金额                     */
/* -------------------------------------------- */
function exchangeAmountForRate(pSrcAmount, pSrcRate, pDestRate) {
    var _srcAmount = new Number(new String(pSrcAmount).replace(/,/g, '').trim()); //源金额
    _srcAmount = (isNaN(_srcAmount) ? 0 : _srcAmount);
    var _srcRate = new Number(new String(pSrcRate).replace(/,/g, '').trim()); //源汇率
    _srcRate = (isNaN(_srcRate) ? 1 : _srcRate);
    var _destRate = new Number(new String(pDestRate).replace(/,/g, '').trim()); //目标汇率
    _destRate = (isNaN(_destRate) ? 1 : _destRate);

    var _destAmount = new Number(_srcAmount * _srcRate / _destRate).toFixed(2);

    return new Number(_destAmount);
}

//两个日期的差值(d1 - d2).
function dateDiff(d1, d2) {
    var day = 24 * 60 * 60 * 1000;
    try {
        var dateArr = d1.split("-");
        var checkDate = new Date();
        checkDate.setFullYear(dateArr[0], dateArr[1] - 1, dateArr[2]);
        var checkTime = checkDate.getTime();

        var dateArr2 = d2.split("-");
        var checkDate2 = new Date();
        checkDate2.setFullYear(dateArr2[0], dateArr2[1] - 1, dateArr2[2]);
        var checkTime2 = checkDate2.getTime();

        var cha = (checkTime - checkTime2) / day;
        return cha;
    } catch (e) {
        return false;
    }
}

//拆分数组，拼接成str,str
function splitArray(array) {
    if(isEmpty(array)){
        return "";
    }
    var tempVal = "";
    for (var i = 0; i < array.length; i++) {
        array[i] += ",";
        tempVal += array[i];
    }
    array = tempVal.substring(0, tempVal.length - 1);
    return array;
}

//只能为数字，正整数
function checkIsNumber(number){
    var reg = /(^([+]?)[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^([-]?)(0){1}$)|(^([-]?)[0-9]\.[0-9]([0-9])?$)/;
    if(!reg.test(number)){
        return false;
    }
    return true;
}

//只能为数字，可为负
function checkIsNumberNot(number){
    var reg = /(^([-]?)[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^([-]?)(0){1}$)|(^([-]?)[0-9]\.[0-9]([0-9])?$)/;
    if(!reg.test(number)){
        return false;
    }
    return true;
}
