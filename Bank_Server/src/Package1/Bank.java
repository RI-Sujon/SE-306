package Package1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.TreeMap;

public class Bank {
    
    DataInputStream din;
    DataOutputStream dout;
    ServerSocket ss;

    public Bank()
    {
        initialize();
    }

    public void initialize()
    {
        System.out.println("welcome to server");
        ss= null;
        try {
            ss = new ServerSocket(1234);
            Socket s=ss.accept();

            din =new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream());
            
           System.out.println( din.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
            return;
    }
}
