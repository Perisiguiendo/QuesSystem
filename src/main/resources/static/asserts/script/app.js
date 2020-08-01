$(document).ready(function (e) {

    var cums = [[${cums}]];
    var cums_type = [[${cums_type}]];
    var cums_len = cums.length;
    var poj_names = [];
    var poj_num = [];
    var poj_id = [];
    m=0;
    console.log(cums);
    console.log(cums_type);
    //数组去重,恢复项目
    for(let i=0; i < cums_len; i++) {
        if (poj_names.indexOf(cums[i].proj_name) === -1) {
            poj_names.push(cums[i].proj_name);
            poj_id
        }
        for (let n = 0; n < poj_names.length; n++) {
            poj_num[n] = 0;
            for (let i = 0; i < cums_len; i++) {
                if (poj_names[n] === cums[i].proj_name) {
                    poj_num[n]++;
                }
            }
        }
    }
    console.log(poj_names);
    console.log(poj_num);
    for (let i = 0; i < poj_names.length; i++) {
        $('.content-box').append('<div class="row test-project-box">' +
            '<div class="row test-top">' +
            '<div class="col-xs-12 col-sm-4 col-md-3">' + poj_names[i] + '</div>' +
            '<div class="col-xs-12 col-sm-8 col-md-9 ">' +
            '<div>' +
            '<a href="javascript:void(0)" class="createQu">创建问卷</a>' +
            // '<a href="#" class="check-pro">查看</a>' +
            // '<a href="javascript:void(0)" class="edit-pro">编辑</a>' +
            '<a href="javascript:void(0)" class="del-pro" id="">删除</a>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>'
        );
    }
    //恢复问卷
    var k=0;
    for (let f = 0; f < poj_num.length; f++) {
        for (let j = 0; j < poj_num[f]; j++) {
            $($('.test-project-box')[f]).append('<div class="row test-content">' +
                '<div class="row test-info">' +
                '<div class="col-xs-12 col-sm-4 col-md-3 ">' + cums[k].questionnaire_name + '</div>' +
                '<div class="col-xs-12 col-sm-8 col-md-9 ">' +
                '<div>' +
                '<span class="iconfont">&#xe63f;未开始</span>' +
                '<span>答卷'+ cums[k].id +'</span>' +
                '<span>' + cums[k].creation_date.substring(0,10) + " " + cums[k].creation_date.substring(11,19) + '</span>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '<div class="row test-op">' +
                '<div class="col-xs-12 col-sm-6 col-md-8">' +
                '<a href="#" class="iconfont">&#xe6f5; 设计问卷</a>' +
                '<a href="#" class="iconfont">&#xe734; 发送问卷</a>' +
                '<a href="#" class="iconfont">&#xe638; 分析&下载' +
                '<span class="triangle-op"></span>' +
                '</a>' +
                '</div>' +
                '<div class="col-xs-12 col-sm-6 col-md-4 ">' +
                '<div>' +
                // '<a href="#" class="iconfont">&#xe69c; 开启</a>' +
                '<a href="#" class="iconfont">&#xe600; 预览</a>' +
                // '<a href="javascript:void(0)" class="iconfont">&#xe63e; 查看</a>' +
                '<a href="#" class="iconfont">&#xe61c; 编辑</a>' +
                // '<a href="javascript:void(0)" class="iconfont">&#xe609; 复制</a>' +
                '<a href="javascript:void(0)" class="iconfont del-que">&#xe614; 删除</a>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>'
            );
            k++;
        }
    }

    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "H+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }

    // var que_num = cums_len;
    var proj = '<div class="project-name">'+
                    '<input class="project-name-id" type="text" placeholder="请输入项目名称">' +
                    '<input type="button" class="make-sure" value="确认">'+
                '</div>';

    //输入项目框
    $('.create-pro').click(function () {

        $('.history-pro').after(proj);
    });

    var queName;
    //创建项目
    $('.make-sure').live('click', function () {
        queName = $('.project-name-id').val();
        if ($('.project-name-id').val()) {
            var time1 = new Date().Format("yyyy-MM-dd HH:mm:ss");
            var xmlhttp;
            if (window.XMLHttpRequest)
            {
                //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                xmlhttp=new XMLHttpRequest();
            }
            else
            {
                // IE6, IE5 浏览器执行代码
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.open("POST","http://localhost:8080/project/os?projectname="+$('.project-name-id').val()+"&creation_date="+time1,true);
            xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            xmlhttp.send();
            $('.content-box').append('<div class="row test-project-box" id="pj"'+  +'>' +
                '<div class="row test-top">' +
                '<div class="col-xs-12 col-sm-4 col-md-3">' + $('.project-name-id').val() + '</div>' +
                '<div class="col-xs-12 col-sm-8 col-md-9 ">' +
                '<div>' +
                '<a href="javascript:void(0)" class="createQu">创建问卷</a>' +
                // '<a href="#" class="check-pro">查看</a>' +
                // '<a href="javascript:void(0)" class="edit-pro">编辑</a>' +
                '<a href="javascript:void(0)" class="del-pro">删除项目</a>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>');
        } else {
            alert('请输入项目名称！');
        }
        $('.project-name').remove();
    });

    //创建问卷
    $('.createQu').live('click', function () {
        $('.pop-up-window-box').show();
        var question_type = $(this).parent().parent().parent().children('div').first().html();
        console.log(question_type);
        var time2 = new Date().Format("yyyy-MM-dd HH:mm:ss");
        console.log("http://localhost:8080/questionnaire/os?questionnaire_type"+"proj_name="+ question_type +"&questionnaire_name=默认标题&questionnaire_content=默认描述"+"&creation_date="+time2);

        var xmlhttp;
        if (window.XMLHttpRequest)
        {
            //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xmlhttp=new XMLHttpRequest();
        }
        else
        {
            // IE6, IE5 浏览器执行代码
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.open("POST","http://localhost:8080/questionnaire/os?questionnaire_type="+ question_type +"&questionnaire_name=默认标题&questionnaire_content=默认描述"+"&creation_date="+time2,true);
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send();

        $(this).parent().parent().parent().parent().append('<div class="row test-content">' +
            '<div class="row test-info">' +
            '<div class="col-xs-12 col-sm-4 col-md-3 ">'+ queName + '问卷' + que_num +'</div>' +
            '<div class="col-xs-12 col-sm-8 col-md-9 ">' +
            '<div>' +
            '<span class="iconfont">&#xe63f;未开始</span>' +
            '<span>答卷' +'</span>' +
            '<span>' + time2 + '</span>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '<div class="row test-op">' +
            '<div class="col-xs-12 col-sm-6 col-md-8">' +
            '<a href="#" class="iconfont">&#xe6f5; 设计问卷</a>' +
            '<a href="#" class="iconfont">&#xe734; 发送问卷</a>' +
            '<a href="#" class="iconfont">&#xe638; 分析&下载' +
            '<span class="triangle-op"></span>' +
            '</a>' +
            '</div>' +
            '<div class="col-xs-12 col-sm-6 col-md-4 ">' +
            '<div>' +
            // '<a href="#" class="iconfont">&#xe69c; 开启</a>' +
            '<a href="#" class="iconfont">&#xe600; 预览</a>' +
            // '<a href="javascript:void(0)" class="iconfont">&#xe63e; 查看</a>' +
            // '<a href="#" class="iconfont">&#xe61c; 编辑</a>' +
            // '<a href="javascript:void(0)" class="iconfont">&#xe609; 复制</a>' +
            '<a href="javascript:void(0)" class="iconfont del-que">&#xe614; 删除</a>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>');
    });

    //删除项目
    $('.del-pro').live('click', function () {
        $(this).parent().parent().parent().parent().remove();
    });

    //删除问卷
    $('.del-que').live('click', function () {
        $(this).parent().parent().parent().parent().remove();
    });
    

});