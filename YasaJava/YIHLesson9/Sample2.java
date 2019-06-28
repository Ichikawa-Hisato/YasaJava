import java.io.*;

public class Sample2{
    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("パラメータ数が違います。");
            System.exit(1);
        }

        try{
            File file1 = new File(args[0]);
            File file2 = new File(args[1]);

            System.out.println("変更前のファイル名は" + file1.getName());

            boolean res = file1.renameTo(file2);

            if(res == true){
                System.out.println("ファイル名を変更しました。");
                System.out.println("変更後のファイル名は" + file2.getName());
            }else{
                System.out.println("ファイル名を変更できませんでした。");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}