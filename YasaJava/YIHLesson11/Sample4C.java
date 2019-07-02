import java.io.*;
import java.net.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample4C extends Application
{
   public static final String HOST = "localhost";
   public static final int PORT = 10000;

   private TextArea ta;
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      try{
         InetAddress ia = InetAddress.getLocalHost();

         //コントロールの作成
         ta = new TextArea();
         bt = new Button("接続");

         //ペインの作成
         BorderPane bp = new BorderPane();

         //ペインへの追加
         bp.setCenter(ta);
         bp.setBottom(bt);

         //イベントハンドラの登録
         bt.setOnAction(new SampleEventHandler());

         //シーンの作成
         Scene sc = new Scene(bp, 300, 200);

         //ステージへの追加
         stage.setScene(sc);

         //ステージの表示
         stage.setTitle("サンプル");
         stage.show();
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }

   //イベントハンドラクラス
   class SampleEventHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         try{
            Socket sc = new Socket(HOST, PORT);
            BufferedReader  br = new BufferedReader
                 (new InputStreamReader(sc.getInputStream()));
            String str = br.readLine();
            ta.setText(str);
            br.close();
            sc.close();
         }
         catch(Exception ex){
            ex.printStackTrace();
         }
      }
   }
}
