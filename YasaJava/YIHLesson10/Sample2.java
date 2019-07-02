import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class Sample2{
   public static void main(String[] args) throws Exception{
        // DOMの準備をする
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        //文章を読み込む
        Document doc = db.parse(new FileInputStream("Sample.xml"));

        //文章を新規作成する
        Document doc2 = db.newDocument();

        //ルート要素を追加する
        Element root = doc2.createElement("cars");
        doc2.appendChild(root);

        //要素を取り出す
        NodeList lst = doc.getElementsByTagName("name");

        for(int i=0; i<lst.getLength(); i++){
            Node n = lst.item(i);
            for(Node ch = n.getFirstChild(); ch != null; ch = ch.getNextSibling()){
                Element elm = doc2.createElement("name");
                Text txt = doc2.createTextNode(ch.getNodeValue());
                elm.appendChild(txt);
                root.appendChild(elm);
            }
        }

        //文章を書き出す
        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.transform(new DOMSource(doc2), new StreamResult("result.xml"));
        System.out.println("result.xmlに出力しました。");
    }
}
