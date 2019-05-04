package package1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
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
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class BankUIMenu extends VBox {
    Label [] label = new Label[8] ;
    TextField accNumberBox1 = new TextField() ;
    PasswordField passwordBox1 = new PasswordField() ;
    
    TextField nameBox = new TextField() ;
    TextField accNumberBox2 = new TextField() ;
    PasswordField passwordBox2 = new PasswordField() ;
    HBox [] hbox = new HBox[8] ;
    Button []button = new Button[2] ;
    Label serverReplayLabel = new Label() ;

    public BankUIMenu(){

        label[0] = new Label("Account No: ") ;
        label[1] = new Label("Password: ") ;
        label[2] = new Label("Name: ") ;
        label[3] = new Label("Account No: ") ;
        label[4] = new Label("Password: ") ;
        label[5] = new Label("If Already has an Account") ;
        label[6] = new Label("Create New Account") ;
        label[5].setFont(Font.font("Algerian",FontWeight.BOLD, 30));
        label[6].setFont(Font.font("Algerian",FontWeight.BOLD, 40));
        

        accNumberBox1.setMinHeight(30);
        accNumberBox1.setMinWidth(150) ;
        passwordBox1.setMinHeight(30);
        passwordBox1.setMinWidth(150) ;
        
        nameBox.setMinHeight(40);
        nameBox.setMinWidth(200);
        accNumberBox2.setMinHeight(40);
        accNumberBox2.setMinWidth(200) ;
        passwordBox2.setMinHeight(40);
        passwordBox2.setMinWidth(200) ;
        
        for(int i=0 ; i<5 ; i++)
        {
            hbox[i] = new HBox() ;
            label[i].setMinHeight(40);
            label[i].setMinWidth(150) ;
            label[i].setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 20)); 
            
            hbox[i].setAlignment(Pos.CENTER);
        }
       

        setMinSize(1200, 700);

        //setStyle("-fx-background-color : Beige"); 

        button[0] = new Button("Sign up") ;
        button[0].setFont(Font.font("Times new Roman", FontPosture.REGULAR, 28));
        button[0].setMinSize(100,50 );
        button[0].setTextFill(Color.BISQUE);
        button[0].setStyle("-fx-background-color: Gray");


        button[1] = new Button("Sign in") ;
        button[1].setFont(Font.font("Times new Roman", FontPosture.REGULAR, 28));
        button[1].setMinSize(100,50 );
        button[1].setTextFill(Color.NAVY);
        button[1].setStyle("-fx-background-color: GRAY");
        
        hbox[0].getChildren().addAll(label[0],accNumberBox1) ;
        hbox[1].getChildren().addAll(label[1],passwordBox1) ;
        hbox[2].getChildren().addAll(label[2],nameBox) ;
        hbox[3].getChildren().addAll(label[3],accNumberBox2) ;
        hbox[4].getChildren().addAll(label[4],passwordBox2) ;

        VBox vbox1 = new VBox() ;
        VBox vbox2 = new VBox() ;
        
        vbox1.getChildren().addAll(label[5],hbox[0],hbox[1],button[1]);
        vbox2.getChildren().addAll(label[6],hbox[2],hbox[3],hbox[4],button[0]);
        
        vbox1.setSpacing(30);
        vbox2.setSpacing(30);
        
        HBox hBox = new HBox() ;
        
        Line line  = new Line() ;
        line.setStartY(50);
        line.setEndY(300);
        line.setStroke(Color.CORAL);
        
        
        hBox.getChildren().addAll(vbox1,line ,vbox2) ;
       
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(100);
        
        
        setAlignment(Pos.CENTER);
        getChildren().addAll(hBox) ;
        getChildren().add(serverReplayLabel) ;

        button[0].setOnAction(e->{createNewAccount();});
        button[1].setOnAction(e->{loginAccount();});

    }
	    
    public void loginAccount() {
        String acc = accNumberBox1.getText();
        String password = passwordBox1.getText();
        Account account = new Account() ;
        if(account.login(acc, password)){
            AccountUIMenu root = new AccountUIMenu(acc);
            
            Scene scene = new Scene(root) ;
            MainClass.getStage().setScene(scene);
        } 

    }
    
    public void createNewAccount() {
        String name = nameBox.getText();
        String acc = accNumberBox2.getText();
        String password = passwordBox2.getText();
        Account account = new Account() ;
        account.createAccount(name, acc, password) ;
        
        AccountUIMenu root = new AccountUIMenu(acc);
            
        Scene scene = new Scene(root) ;
        MainClass.getStage().setScene(scene);
        
    }
}	

