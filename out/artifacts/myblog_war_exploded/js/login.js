$(function (){
    $("#sub_btn").keyup(function (){
        var username = $("#username").val();
        $.getJSON("http://localhost:8080/myblog/userServlet", "action=ajaxExistsUsername&username=" + username, function (data) {
            if (data.b) {
                $("#errorMsg").text("用户名已存在");
            }else {
                $("#errorMsg").text("");
            }
        });


        // if ($("#errorMsg").text() != "用户名或密码错误" && $("#state").val() == "initialize") {
        //     location.href = "http://localhost:8080/myblog/html/home.html"
        // }else {
        //     $("#errorMsg").text("用户名或密码错误");
        //     return false;
        // }
    });

});