package Package1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ClientLogin extends VBox {
    Label [] label = new Label[8] ;
    TextField accNumberBox = new TextField() ;
    PasswordField passwordBox = new PasswordField() ;
    HBox [] hbox = new HBox[8] ;
    Button []button = new Button[2] ;
    Label serverReplayLabel = new Label() ;

    public ClientLogin(){

        label[0] = new Label("Account No: ") ;
        label[1] = new Label("Password: ") ;

        accNumberBox.setMinHeight(50);
        accNumberBox.setMinWidth(300) ;
        passwordBox.setMinHeight(50);
        passwordBox.setMinWidth(300) ;
        
       
        
        for(int i=0 ; i<2 ; i++)
        {
            hbox[i] = new HBox() ;
            label[i].setMinHeight(50);
            label[i].setMinWidth(200) ;
            label[i].setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 20)); 
            
            hbox[i].setAlignment(Pos.CENTER);
            getChildren().addAll(hbox[i]) ;
        }
        
        hbox[0].getChildren().addAll(label[0],accNumberBox) ;
        hbox[1].getChildren().addAll(label[1],passwordBox) ;
       

            //
        setMinSize(1200, 820);

        setAlignment(Pos.CENTER);
        setSpacing(30);
        //setStyle("-fx-background-color : Beige"); 

        button[0] = new Button("back") ;
        button[0].setTranslateX(100);


        button[1] = new Button("OK") ;
        button[1].setFont(Font.font("Times new Roman", FontPosture.REGULAR, 28));
        button[1].setMinSize(100,50 );
        button[1].setTextFill(Color.GREENYELLOW);
        button[1].setStyle("-fx-background-color: Purple");

        HBox hBox = new HBox() ;

        hBox.getChildren().addAll(button[1],button[0]) ;
        hBox.setAlignment(Pos.CENTER);
        getChildren().addAll(hBox) ;
        getChildren().add(serverReplayLabel) ;

        button[1].setOnAction(e->{
                    try {
                        operationAsClient();
                    } catch (IOException ex) {
                        Logger.getLogger(ClientLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

    }
	    
    public void operationAsClient() throws IOException {
        String acc = accNumberBox.getText();
        String password = passwordBox.getText();

        Socket s=new Socket("localhost",3319);

        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        
                
            dout.writeUTF(acc+"&"+password);
            String str = din.readUTF() ;
            
            serverReplayLabel.setText(str);
            
            s.close() ;       
        }
}	