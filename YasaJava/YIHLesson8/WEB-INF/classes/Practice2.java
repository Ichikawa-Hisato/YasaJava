import java.sql.*;

public class Practice2 {
    public static void main(String args[]) {
        if (args.length != 3) {
            System.out.println("パラメータ数が違います。");
            System.exit(1);
        }
        try {
            // 接続の準備
            String url = "jdbc:derby:fooddb;create=true";
            String usr = "";
            String pw = "";

            // データベースへの接続
            Connection cn = DriverManager.getConnection(url, usr, pw);

            // 問い合わせの準備
            Statement st = cn.createStatement();
            String qry1 = "INSERT INTO 果物表 VALUES(" + args[0] + ", '" + args[1] + "', '" + args[2] + "')";
            String qry2 = "SELECT * FROM 果物表";

            // 問い合わせ
            st.executeUpdate(qry1);
            ResultSet rs = st.executeQuery(qry2);

            // データの取得
            ResultSetMetaData rm = rs.getMetaData();
            int cnum = rm.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= cnum; i++) {
                    System.out.print(rm.getColumnName(i) + ":" + rs.getObject(i) + " ");
                }
                System.out.println("");
            }
            // 接続のクローズ
            rs.close();
            st.close();
            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}