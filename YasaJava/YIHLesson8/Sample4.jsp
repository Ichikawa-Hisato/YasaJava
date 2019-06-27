<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="cb" class="mybeans.CarDBBean" scope="request"/>

<%!
    ArrayList colname;
    ArrayList data;
%>
<%
    colname = cb.getColname();
    data = cb.getData();
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
            <hr/>
            お選びください。<br/>
            <br/>
            <table border="1" style="margin-left: auto; margin-right:auto;">
                <tr bgcolor="#E0C76F">
                    <%
                        for(int column=0; column<colname.size(); column++){
                    %>
                    <th>
                        <%= (String) colname.get(column) %>
                    </th>
                    <%
                        }
                    %>
                </tr>
                <%
                    for(int row=0; row<data.size(); row++){
                %>
                <tr>
                    <%
                        ArrayList rowdata = (ArrayList) (data.get(row));
                        for(int column=0; column<rowdata.size(); column++){
                    %>
                    <td>
                        <%= rowdata.get(column) %>
                    </td>
                    <%
                        }
                    %>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>