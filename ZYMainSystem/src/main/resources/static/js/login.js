layui.use(['jquery', 'layer'], function () {
    const $ = layui.jquery,
        layer = layui.layer;

    let $inputAccount = $("#input-username"),
        $inputPassword = $("#input-password"),
        $iHidePassword = $("#i-hide-password"),
        $checkboxRememberMe = $("#checkbox-remember"),
        $aRegister = $("#a-register");

    /******************** 信息空验证 ***********************/
    $("#btn-submit").click(function () {
        //自动登录
        if($checkboxRememberMe.is(":checked")){
            $checkboxRememberMe.attr("value",true)
        }else {
            $checkboxRememberMe.attr("value",false)
        }
        //输入检查
        if ($inputAccount.val() === "") {
            layer.msg('账号不能为空', {
                time: 2000
            });
        } else if ($inputPassword.val() === "") {
            layer.msg('密码不能为空', {
                time: 2000
            });
        } else {//登录请求
            $.post("/loginProcessing", {
                username: $inputAccount.val(),
                password: $inputPassword.val(),
                remember: $checkboxRememberMe.val()
            }, function (data) {
                if (data.code === 300) {
                    layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                        window.location.href = data.url;
                    });
                } else {
                    layer.msg(data.msg, {
                        time: 2000
                    });
                }
            })
        }
    })

    /******************** 隐藏与显示密码 ***********************/
    $iHidePassword.click(function () {
        let iAttrClass = $iHidePassword.attr('class');
        if (iAttrClass === 'icon-extend icon-extend-browse') {//隐藏密码
            $iHidePassword.attr('class', 'icon-extend icon-extend-eye-close');
            $inputPassword.attr('type', 'password');
        } else if (iAttrClass === 'icon-extend icon-extend-eye-close') {//显示密码
            $iHidePassword.attr('class', 'icon-extend icon-extend-browse');
            $inputPassword.attr('type', 'text');
        }
    });

    /******************** 去注册 ***********************/
    $aRegister.click(function () {//注册
        layer.open({
            title: false,
            type: 2,
            area: ['40%', '65%'],
            content: '/register'
        });
    });
});

