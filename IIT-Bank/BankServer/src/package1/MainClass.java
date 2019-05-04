package package1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {
    private static Stage stage ;

    public static Stage getStage() {
        return stage;
    }
    
    public void start(Stage primaryStage) throws Exception{
        
        this.stage = primaryStage ;
        
        //createNewFile() ;
       
        BankUIMenu root = new BankUIMenu();
        
        Scene scene = new Scene(root) ; 
        
        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.show();   
    }
    
    public static void main(String[] args) throws IOException {
    	
    	 launch(args);
         
        DataInputStream din;
        DataOutputStream dout;
        ServerSocket ss;
        
 
            ss = new ServerSocket(3319);
               
          
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
                        dout.writeUTF("Done");
                    }
                    
                    else dout.writeUTF("Insufficiant Balance");
                }
                dout.writeUTF("Wrong Password");
            }
    }
}