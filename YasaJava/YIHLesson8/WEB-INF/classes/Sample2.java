import java.sql.*;


public class Sample2{
    public static void main(String[] args){
        try{
            //接続の準備
            String url = "jdbc:derby:cardb;create=true";
            String usr = "";
            String pw = "";

            //データベース接続
            Connection cn = DriverManager.getConnection(url, usr, pw);

            //問い合わせの準備
            Statement st = cn.createStatement();
            String qry = "SELECT * FROM 車表 WHERE 番号>=3";

            //問い合わせ
            ResultSet rs = st.executeQuery(qry);

            //データの取得
            ResultSetMetaData rm = rs.getMetaData();
            int cnum = rm.getColumnCount();
            while(rs.next()){
                for(int i=1; i<=cnum; i++){
                    System.out.print(rm.getColumnName(i) + ":" + rs.getObject(i) + " ");
                }
                System.out.println("");
            }
            //接続のクローズ
            rs.close();
            st.close();
            cn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}