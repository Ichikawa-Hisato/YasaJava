import java.io.*;

public class Sample1{
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("パラメータ数が違います。");
            System.exit(1);
        }

        try{
            File fl = new File(args[0]);
            System.out.println("ファイル名は" + fl.getName());
            System.out.println("絶対パスは" + fl.getAbsolutePath());
            System.out.println("サイズは" + fl.length() + "バイト");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}