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

public class AccountUIMenu extends VBox {
    Label [] label = new Label[8] ;
    TextField accNumberBox1 = new TextField() ;
    PasswordField passwordBox1 = new PasswordField() ;
    
    TextField nameBox = new TextField() ;
    TextField accNumberBox2 = new TextField() ;
    PasswordField passwordBox2 = new PasswordField() ;
    HBox [] hbox = new HBox[8] ;
    Button []button = new Button[5] ;
    Label serverReplayLabel = new Label() ;
    
    Account account = new Account() ;
    String accountNumber ;

    public AccountUIMenu(String accountNumber ){
        this.accountNumber = accountNumber ;
        
        button[0] = new Button("Deposit") ;
        button[1] = new Button("Withdraw") ;
        button[2] = new Button("Transefer Balance") ;
        button[3] = new Button("Sign out") ;
        
        label[0] = new Label("Name:") ;
        label[1] = new Label("Account No: ") ;
        label[2] = new Label("Balance: ") ;
        label[3] = new Label() ;
        label[4] = new Label() ;
        label[5] = new Label() ;
        
        setInfo();

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
        
        for(int i=0 ; i<3 ; i++)
        {
            hbox[i] = new HBox() ;
            label[i].setMinHeight(40);
            label[i].setMinWidth(150) ;
            label[i].setFont(Font.font("Times new Roman",FontWeight.BOLD, FontPosture.ITALIC, 20));
            label[i+3].setMinHeight(40);
            label[i+3].setMinWidth(150) ;
            label[i+3].setFont(Font.font("Kristen ITC",FontWeight.BOLD, FontPosture.ITALIC, 20));
            hbox[i].setAlignment(Pos.CENTER);
            hbox[i].getChildren().addAll(label[i],label[i+3]) ;
            button[i].setFont(Font.font("Times new Roman", FontPosture.REGULAR, 28));
            button[i].setMinSize(100,50 );
            button[i].setTextFill(Color.GREEN);
            button[i].setStyle("-fx-background-color: SILVER ;");
        }

        setMinSize(1200, 700);

        //setStyle("-fx-background-color : Beige"); 

        VBox vbox1 = new VBox() ;
        VBox vbox2 = new VBox() ;
        
        vbox1.getChildren().addAll(hbox[0],hbox[1],hbox[2]);
        vbox2.getChildren().addAll(button[0],button[1],button[2],button[3]);
        
        vbox1.setSpacing(10);
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

        button[0].setOnAction(e->{depositMoney();});
        button[1].setOnAction(e->{withdraw();});
        button[3].setOnAction(e->{goToMenu();});

    }
    
    public void goToMenu(){
        BankUIMenu root1 = new BankUIMenu();
        Scene scene1 = new Scene(root1) ;
        MainClass.getStage().setScene(scene1);
    }
	    
    public void depositMoney() {
        Label l = new Label("Deposit Ammount") ;
        TextField t = new TextField() ;
        Button b = new Button("Ok") ;
        HBox hbox1 = new HBox() ;
        hbox1.getChildren().addAll(l,t,b) ;
        getChildren().add(hbox1) ;
        hbox1.setSpacing(10);
        
        hbox1.setTranslateX(700);
        
        b.setOnAction(e->{
            account.deposit( t.getText(), accountNumber) ;
            getChildren().remove(hbox1) ;
            setInfo() ;
        });
        
    }
    
    public void withdraw() {
        Label l = new Label("Withdraw Ammount") ;
        TextField t = new TextField() ;
        Button b = new Button("Ok") ;
        HBox hbox1 = new HBox() ;
        hbox1.getChildren().addAll(l,t,b) ;
        getChildren().add(hbox1) ;
        hbox1.setSpacing(10);
        hbox1.setTranslateX(700);
        
        b.setOnAction(e->{
            account.withdraw(t.getText(), accountNumber) ;
            getChildren().remove(hbox1) ;
            setInfo() ;
        });
        
        setInfo() ;
        
    }
    
    public void setInfo(){
        String str = account.allInfo(accountNumber) ;
        String[] strr = str.split("&") ;
        label[3].setText(strr[0]);
        label[4].setText(strr[1]);
        label[5].setText(strr[2]);
    }
}	