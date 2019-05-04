package package1;

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
    
    String name;
    String roll;
    String registration;
    String nameOfFather;
    String nameOfMother;
    String dateOfBirth;
    String result;

    public ClientLogin(String sName,String roll,String reg,String fName,String mName,String dOb ,String result){
        
        name = sName ;
        this.roll = roll ;
        registration = reg ;
        nameOfFather = fName ;
        nameOfMother =mName ;
        dateOfBirth =dOb ;
        this.result =result ;
        
        
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
        setStyle("-fx-background-color : Beige"); 

        button[0] = new Button("BACK") ;
        button[0].setTranslateX(100);
        button[0].setFont(Font.font("Times new Roman", FontPosture.REGULAR, 28));
        button[0].setMinSize(100,50 );
        button[0].setTextFill(Color.WHITE);
        button[0].setStyle("-fx-background-color: Black");


        button[1] = new Button("OK") ;
        button[1].setFont(Font.font("Times new Roman", FontPosture.REGULAR, 28));
        button[1].setMinSize(100,50 );
        button[1].setTextFill(Color.WHITESMOKE);
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
                        System.out.println("Ex" + e);
                    }
                });

    }
	    
    public void operationAsClient() throws IOException {
        String acc = accNumberBox.getText();
        String password = passwordBox.getText();

        Socket s=new Socket("localhost",1234);

        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        
                
            dout.writeUTF(acc+"&"+password);
            String str = din.readUTF() ;
            
            if(str.equals("3")){
                serverReplayLabel.setText("Wrong Password. Please try again.");
            }
            
            else  {
                VBox newvbox = new VBox() ;
                Label newlabel = new Label() ;
                Button newbutton = new Button("Go to Menu") ;
                System.out.println("str: " + str);
                if(str.equals("1")){
                    CheckPersonal personal = new CheckPersonal() ;
                    personal.createCertificate(name, roll, registration, nameOfFather, nameOfMother, dateOfBirth, result) ;
                    newlabel.setText("Successfully Complete");
                }
                
                else if(str.equals("2")){
                    newlabel.setText("Sorry....Insufficient Balance");
                }
                newlabel.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 40)); 
                newvbox.setAlignment(Pos.CENTER);
                newvbox.setMinSize(1200, 820);
                newvbox.getChildren().addAll(newlabel,newbutton) ;
              
                newbutton.setFont(Font.font("Times new Roman", FontPosture.REGULAR, 30));
                newbutton.setMinSize(100,40 );
                newbutton.setTextFill(Color.WHITE);
                newbutton.setStyle("-fx-background-color: Gray");
                newvbox.setSpacing(50);
                Scene scene = new Scene(newvbox) ;
                newvbox.setStyle("-fx-background-color : Beige");
                MainClass.getStage().setScene(scene);
                newbutton.setOnAction(e->goTOMenu());
            }
            s.close() ;       
    }
    
    public void goTOMenu(){
        Menu root1 = new Menu() ;
        Scene scene1 = new Scene(root1) ;
        MainClass.getStage().setScene(scene1);
    }
}	