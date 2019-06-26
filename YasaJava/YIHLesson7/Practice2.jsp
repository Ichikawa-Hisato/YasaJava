<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>

<%!
    HttpSession hs;
    Integer cn;
    Date dt;
    String str1, str2;
%>
<%
    //セッションの取得
    hs = request.getSession(true);
    cn = (Integer) hs.getAttribute("count");
    dt = (Date) hs.getAttribute("date");

    //回数設定
    if(cn == null){ 
        cn = new Integer(1);
        dt = new Date();
        str1 = "初めてのおこしですね。";
        str2 = "";
    }else{
        cn = new Integer(cn.intValue() + 1);
        str1 = cn + "回目のおこしですね。";
        str2 = "(前回：" + dt + ")";
        dt = new Date(); 
    }

    //セッションの設定
    hs.setAttribute("count", cn);
    hs.setAttribute("date", dt);
%>

<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <head>
        <title>サンプル</title>
    </head>

    <body>
        <div style="text-align: center;">
            <h2>ようこそ</h2>
                <%= str1 %>
                <br/>
                <%= str2 %>
                <br/>
                下記より、お選びください。<br/>
                <a href="car1.html">乗用車</a><br/>
                <a href="car2.html">トラック</a><br/>
                <a href="car3.html">オープンカー</a><br/>
        </div>
    </body>
</html>