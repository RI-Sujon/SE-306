package package1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MainSocket {
    public static void main(String[] args) throws IOException {
         
        DataInputStream din;
        DataOutputStream dout;
        ServerSocket ss;
 
            ss = new ServerSocket(1234);
               
            while(true){
                Socket s=ss.accept();
                din =new DataInputStream(s.getInputStream());
                dout=new DataOutputStream(s.getOutputStream());
                String recieve = din.readUTF();
                System.out.println(recieve);
                String [] strr = recieve.split("&") ;
                
                Account account = new Account() ;
                if(account.login(strr[0], strr[1])){
                    if(account.withdraw("100", strr[0])){
                        dout.writeUTF("1");
                    }
                    
                    else dout.writeUTF("2");
                }
                
                else dout.writeUTF("3");
            }
    }
}
