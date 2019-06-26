<%@ page contentType="text/html; charset=UTF-8" %>

<%
    String yourname = request.getParameter("names");
%>

    <!DOCTYPE html>
    <html>

    <head>
        <title><%= yourname %></title>
    </head>

    <body>
        <div style="text-align: center;">
            <h2>ようこそ</h2>
            <%= yourname %> さん、いらっしゃいませ！
            <br/>
        </div>
    </body>

    </html>