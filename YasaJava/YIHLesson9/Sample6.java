import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample6 extends Application
{
   private Label lb1, lb2;
   private TextField tf1, tf2;
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コンポーネントの作成
      lb1 = new Label("何番目のデータを読み込みますか？(1～5)");
      lb2 = new Label("データ：");

      tf1 = new TextField("1");
      tf2 = new TextField();

      bt = new Button("読込");

      //ペインの作成
      BorderPane bp = new BorderPane();
      VBox vb = new VBox();

      //ペインの作成
      vb.getChildren().add(lb1);
      vb.getChildren().add(tf1);
      vb.getChildren().add(lb2);
      vb.getChildren().add(tf2);

      bp.setCenter(vb);
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

   //イベントハンドラクラス
   class SampleEventHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         FileChooser fc = new FileChooser();
         fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("バイナリファイル", "*.bin"));
         File fl = fc.showOpenDialog(new Stage());
         try{
            if(fl != null){
               RandomAccessFile raf =
                 new RandomAccessFile(fl, "r");
               int pos =Integer.parseInt(tf1.getText());
               raf.seek(pos-1);
               int num = raf.read();
               tf2.setText((Integer.valueOf(num)).toString());
               raf.close();
            }
         }
         catch(Exception ex){
               ex.printStackTrace();
         }
      }
   }
}
