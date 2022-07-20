import java.io.FileInputStream;
public class Main {

  public static String sPath = System.getenv("sPath");
  public static String sPath1 = System.getenv("sPath1");
  public static String filename = "./input.txt";
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
