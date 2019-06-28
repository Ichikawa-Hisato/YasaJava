import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.collections.*;

public class Sample10 extends Application
{
   private ListView<String> lv;
   private Button bt;
   private ObservableList<String> ol;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      File fl = new File(".");
      File[] fls = fl.listFiles(new SampleFileFilter());
      String[] st = new String[fls.length];
      for(int i=0; i<fls.length; i++){
        st[i] = fls[i].getName();
      }
      ol = FXCollections.observableArrayList(st);

      lv = new ListView<String>(ol);
      bt = new Button("起動");

      //ペインの作成
      BorderPane bp = new BorderPane();

      //ペインへの追加
      bp.setCenter(lv);
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
         try{
            java.awt.Desktop dp = java.awt.Desktop.getDesktop();
            dp.open(new File(lv.getSelectionModel().getSelectedItem()));
         }
         catch(IOException ex){
            System.out.println("起動できません");
         }
      }
   }

   //フィルタクラス
   class SampleFileFilter implements FileFilter
   {
      public boolean accept(File f)
      {
         if(f.isFile()){
            return true;
         }
         return false;
      }
   }
}
