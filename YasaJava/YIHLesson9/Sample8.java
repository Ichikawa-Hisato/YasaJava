import java.io.*;
import java.util.regex.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample8 extends Application
{
   private Label lb1, lb2, lb3;
   private TextArea ta;
   private TextField tf1, tf2;
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      lb1 = new Label("入力してください。");
      lb2 = new Label("置換前");
      lb3 = new Label("置換後");
      ta = new TextArea();

      bt = new Button("置換");
      tf1 = new TextField();
      tf2 = new TextField();

      //ペインの作成
      BorderPane bp = new BorderPane();
      HBox hb = new HBox();

      //ペインへの追加
      hb.getChildren().add(lb2);
      hb.getChildren().add(tf1);
      hb.getChildren().add(lb3);
      hb.getChildren().add(tf2);
      hb.getChildren().add(bt);

      bp.setTop(lb1);
      bp.setCenter(ta);
      bp.setBottom(hb);

      //イベントハンドラの登録
      bt.setOnAction(new SampleEventHandler());

      //シーンの作成
      Scene sc = new Scene(bp, 500, 200);

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
         Pattern pn = Pattern.compile(tf1.getText());
         Matcher mt = pn.matcher(ta.getText());
         ta.setText(mt.replaceAll(tf2.getText()));
      }
   }
}
