$(function ($){
   $("#writeBlog").click(function (){
       location.href = "http://localhost:8080/myblog/html/write.html"
   });


   $.getJSON("http://localhost:8080/myblog/blogServlet","action=allBlog",function (data){
       for (var i = 0;i<data.blogCount;i++){
           var id = data.articles[i].id;
           var tr = $("<tr>  <td><a target='_blank' href=''> </a></td>  </tr>");
           $("#form").append(tr);
           $("a:last").text(data.articles[i].title);
           $("a:last").attr('href','http://localhost:8080/myblog/html/article.html?id='+id);
       }

   });
});