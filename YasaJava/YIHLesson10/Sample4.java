import java.sql.*;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class Sample4{
   public static void main(String[] args) throws Exception{
       try{
            //接続の準備
            String url = "jdbc:derby:cardb;create=true";
            String usr = "";
            String pw = "";

            //データベースへの接続
            Connection cn = DriverManager.getConnection(url, usr, pw);

            //問い合わせの準備
            DatabaseMetaData dm = cn.getMetaData();
            ResultSet tb = dm.getTables(null, null, "車表", null);

            Statement st = cn.createStatement();

            String qry1 = "CREATE TABLE 車表(番号 int, 名前 varchar(50))";

            String[] qry2 = {"INSERT INTO 車表 VALUES(2, '乗用車')",
                             "INSERT INTO 車表 VALUES(3, 'オープンカー')",
                             "INSERT INTO 車表 VALUES(4, 'トラック')"};

            String qry3 = "SELECT * FROM 車表";

            if(!tb.next()){
                st.executeUpdate(qry1);
                for(int i=0; i<qry2.length; i++){
                    st.executeUpdate(qry2[i]);
                }
            }

            //問い合わせ
            ResultSet rs = st.executeQuery(qry3);

            //データの取得
            ResultSetMetaData rm = rs.getMetaData();
            int cnum = rm.getColumnCount();

            // DOMの準備をする
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            //文章を新規作成する
            Document doc = db.newDocument();

            //ルート要素を追加する
            Element root = doc.createElement("cars");
            doc.appendChild(root);

            //ルート要素を作成する
            while(rs.next()){
                Element car = doc.createElement("car");
                root.appendChild(car);
                for(int i=1; i<=cnum; i++){
                    Element elm = doc.createElement(rm.getColumnName(i).toString());
                    Text txt = doc.createTextNode(rs.getObject(i).toString());
                    elm.appendChild(txt);
                    car.appendChild(elm);
                }
            }

            // 文章を書き出す
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tf.transform(new DOMSource(doc), new StreamResult("result.xml"));
            System.out.println("result.xmlに出力しました。");

       }
       catch(Exception e){
           e.printStackTrace();
       }
        
    }
}
