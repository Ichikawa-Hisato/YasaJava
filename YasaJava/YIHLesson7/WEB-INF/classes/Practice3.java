import mybeans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Practice3 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            // フォームデータの取得
            String carname = request.getParameter("cars");

            // Beanの作成
            CarBean cb = new CarBean();
            cb.setCarname(carname);
            cb.makeCardata();

            // リクエストに設定
            request.setAttribute("cb", cb);

            // サーブレットコンテキストの取得
            ServletContext sc = getServletContext();

            // リクエストの転送
            if (carname.length() == 0) {
                sc.getRequestDispatcher("/error.html").forward(request, response);
            }else if(carname.equals("タクシー")){
                sc.getRequestDispatcher("/Practice3Taxi.html").forward(request, response);
            } else {
                sc.getRequestDispatcher("/Practice3.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}