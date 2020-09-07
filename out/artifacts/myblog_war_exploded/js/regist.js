$(function () {
    // $("#username").keyup(function () {
    //     var name = $("#username").val();
    //     $.getJSON("http://localhost:8080/myblog/userServlet", "action=ajaxExistsUsername&username=" + name, function (data) {
    //
    //         if (data.b) {
    //             $("#errorMsgU").text("用户名已存在");
    //         }else {
    //             $("#errorMsgU").text("");
    //         }
    //     });
    //
    //     });


    $("#username").keyup(function () {
        var name = $("#username").val();
        var usernamePatt = /^[A-Za-z0-9]{4,15}$/;
        if (!usernamePatt.test(name)) {
            $("#errorMsgU").text("用户名不合法");
        } else {
            $("#errorMsgU").text("");
        }

    });

    $("#username").blur(function () {
        var name = $("#username").val();
        $.getJSON("http://localhost:8080/myblog/userServlet", "action=ajaxExistsUsername&username=" + name, function (data) {
            if (data.b) {
                $("#errorMsgU").text("用户名已存在");
            } else {
                $("#errorMsgU").text("");
            }
        });
    });

    $("#password").keyup(function () {
        var password = $("#password").val();
        var passwordPatt = /^\w{5,12}$/;
        if (!passwordPatt.test(password)) {
            $("#errorMsgP").text("密码不合法");
        } else {
            $("#errorMsgP").text("");
        }

    });

    $("#repwd").blur(function () {
        var password = $("#password").val();
        var repwd = $("#repwd").val();
        if (repwd != password) {
            $("#errorMsgR").text("密码不一致");
        } else {
            $("#errorMsgR").text("");
        }

    });

    $("#email").keyup(function () {
        var email = $("#email").val();
        var emailPatt = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (!emailPatt.test(email)) {
            $("#errorMsgE").text("邮箱名不合法");
        } else {
            $("#errorMsgE").text("");
        }

    });

    $("#sub_btn").click(function () {

        if ($("#errorMsgU").text() == "用户名不合法" || $("#username").val() == ""){
            return false;
        }

        if ($("#errorMsgP").text() == "密码不合法" || $("#password").val() == ""){
            return false;
        }

        if ($("#errorMsgR").text() == "密码不一致" || $("#repwd").val() == ""){
            return false;
        }

        if ($("#errorMsgE").text() == "邮箱名不合法" || $("#email").val() == ""){
            return false;
        }

        
        if ($("#errorMsgU").text() == "用户名已存在" ){
            return false;
        }


    });
});