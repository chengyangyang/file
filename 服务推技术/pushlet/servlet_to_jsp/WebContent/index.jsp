<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script type="text/javascript" src="ajax-pushlet-client.js"></script>
 <script type="text/javascript"> 
        //对pushlet的初始化，触发web.xml中的servlet。
        PL._init(); 
        //这里的监听的主题，必须在sources.properties中配置的对象中声明这个主题。
        //sources.properties配置着事件源（EventSources），在服务器启动时会自动激活。
        //可以通过服务器的启动记录查看得到。可以将这个文件放到WEB-INF目录下面或者classess目录下面都可以。
        PL.joinListen('/linjiqin/hw'); 
        function onData(event) { 
            alert(event.get("hw")); 
            //离开  
            PL.leave();  
        } 
     </script>
<title>Insert title here</title>
</head>
<body>

</body>
</html>