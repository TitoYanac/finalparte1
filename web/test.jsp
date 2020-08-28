<%-- 
    Document   : test
    Created on : 28-ago-2020, 5:16:39
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1>Servlet test at " <%=request.getContextPath()%> "</h1>
        <h1>Servlet test at " <%=request.getParameter("region")%> "</h1>
        <h1>Servlet test at " <%=request.getParameter("cantidad")%> "</h1>
        
    </body>
</html>
