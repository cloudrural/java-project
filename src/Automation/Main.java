import java.io.FileInputStream;
public class Main {

  public static String sPath = "/some/dir/data";
  public static String sPath1 = "/some/dir/data/report";
  public static String filename = "./file.txt";
  public static void main(String args[]) {

     try {
        FileInputStream input = new FileInputStream(filename);
        System.out.println("Data in the file: ");
        // Reads the first byte
        int i = input.read();
       while(i != -1) {
           System.out.print((char)i);
           // Reads next byte from the file
           i = input.read();
        }
        input.close();
     }
     catch(Exception e) {
        e.getStackTrace();
     }
     System.out.println(sPath);
     System.out.println(sPath1);
  }
}
