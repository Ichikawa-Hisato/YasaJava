import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class Sample5{
    public static void main(String[] args)throws Exception{
        StreamSource in = new StreamSource(new File(args[0]));
        StreamSource ss = new StreamSource(new File(args[1]));
        StreamResult out = new StreamResult(new File(args[2]));

        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer(ss);
        tf.transform(in, out);
        System.out.println(args[2] + "に出力しました。");
    }
}