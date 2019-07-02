import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.web.*;
import javafx.event.*;

public class Sample1 extends Application
{
   private TextField tf;
   private WebView wv;
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      tf = new TextField();
      wv = new WebView();
      bt = new Button("読込");

      //ペインの作成
      BorderPane bp = new BorderPane();
      VBox vb = new VBox();
 
      //ペインへの追加
      vb.getChildren().addAll(bt, tf);

      bp.setTop(vb);
      bp.setCenter(wv);
      
      //イベントハンドラの登録
      bt.setOnAction(new SampleEventHandler());

      //シーンの作成
      Scene sc = new Scene(bp, 600, 600);
      
      //ステージへの追加
      stage.setScene(sc);

      //ステージの表示
      stage.setTitle("サンプル");
      stage.show();
   }

   //イベントハンドラクラス
   class SampleEventHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         try{
            WebEngine we = wv.getEngine();
            we.load(tf.getText());
         }
         catch(Exception ex){
            ex.printStackTrace();
         }
      }
   }
}
