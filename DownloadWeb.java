/**
 * DownloadWeb
 */
import java.io.*;
import java.util.*;
import java.net.Socket;
import java.net.UnknownHostException;
public class DownloadWeb {
    static String host;
    static int port=443;
    
    static String path = "/";
    public static void main(String[] args) {
        sethost();
        try {
            Socket soc=new Socket(host,port);
            OutputStream opstr = soc.getOutputStream();
            PrintWriter pw=new PrintWriter(opstr,true);
            pw.println("GET "+path+" HTTP/1.1");
            pw.println("Host: "+host);
            pw.println();
            InputStream ipstr=soc.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(ipstr));
            show(br);
            soc.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
    }
    private static void show(BufferedReader br) {
        String line;
        try {
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private static void sethost() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the host :");
        host=sc.nextLine();
    }
    
    
}
