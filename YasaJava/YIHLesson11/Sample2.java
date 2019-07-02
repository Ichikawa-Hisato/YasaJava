import java.net.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample2 extends Application
{
   private Label lb1, lb2;
   private TextField tf1, tf2;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      try{
         InetAddress ia = InetAddress.getLocalHost();

         //コントロールの作成
         lb1 = new Label("ホスト名");
         lb2 = new Label("IPアドレス");
         tf1 = new TextField(ia.getHostName());    
         tf2 = new TextField(ia.getHostAddress()); 

         //ペインの作成
         BorderPane bp = new BorderPane();
         VBox vb = new VBox();

         //ペインへの追加
         vb.getChildren().add(lb1);
         vb.getChildren().add(tf1);
         vb.getChildren().add(lb2);
         vb.getChildren().add(tf2);

         bp.setCenter(vb);

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
}
