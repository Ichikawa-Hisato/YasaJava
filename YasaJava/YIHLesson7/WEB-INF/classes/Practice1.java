import java.util.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

public class Practice1 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException{
        try{
            //フォームデータの取得
            String yourname = request.getParameter("names");

            //サーブレットコンテキストの取得
            ServletContext sc = getServletContext();

            //リクエストの転送
            if(yourname.length() != 0){
                sc.getRequestDispatcher("/Practice1.jsp").forward(request, response);
            }else{
                sc.getRequestDispatcher("/error.html").forward(request, response);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}