import mybeans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sample4 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException{
        try{
            //サーブレットコンテキストの取得
            ServletContext sc = getServletContext();

            //Beanの作成
            CarDBBean cb = new CarDBBean();

            //リクエストに設定
            request.setAttribute("cb", cb);

            //リクエストに転送
            sc.getRequestDispatcher("/Sample4.jsp").forward(request, response);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}