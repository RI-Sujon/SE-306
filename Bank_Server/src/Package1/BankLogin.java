package Package1;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class BankLogin extends VBox {
		Label [] label = new Label[8] ;
	    TextField [] info = new TextField[8] ;
	    HBox [] hbox = new HBox[8] ;
	    Button []button = new Button[2] ;
		
	    public BankLogin(){
	            
	    		label[0] = new Label("Account No: ") ;
	            label[1] = new Label("Password: ") ;
	        
	           for(int i=0 ; i<2 ; i++)
	           {
	        	   hbox[i] = new HBox() ;
	               info[i] = new TextField() ;
	               info[i].setMinHeight(50);
	               info[i].setMinWidth(300) ;
	               label[i].setMinHeight(50);
	               label[i].setMinWidth(200) ;
	               label[i].setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 20)); 
	               hbox[i].getChildren().addAll(label[i],info[i]) ;
	               hbox[i].setAlignment(Pos.CENTER);
	               getChildren().addAll(hbox[i]) ;
	           }
	            
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
	           
	           
	           info[0].setOnAction(e->info[0].setText(info[0].getText()));
	           
	           button[1].setOnAction(e->operationAsClient());
	           
	    }
	    
	    public void operationAsClient() {
			
			
	    }
}	
