$(function ($){
   function getUrlParam(name) {
      var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
      var r = window.location.search.substr(1).match(reg);  //匹配目标参数
      if (r != null) return unescape(r[2]); return null; //返回参数值
   }

   var id = getUrlParam("id");

   $.getJSON("http://localhost:8080/myblog/blogServlet","action=oneBlog&id="+id,function (data){
      $("#title").text(data.article.title);
      $("#text").text(data.article.main);
   });

});