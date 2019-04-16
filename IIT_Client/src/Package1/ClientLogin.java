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

public class ClientLogin extends VBox {
	    public ClientLogin(){
	            
    		Button btn = new Button("Go to Bank") ; 
    		Button btn1 = new Button("Back") ; 
        
               btn.setMinHeight(50);
               btn.setMinWidth(200) ;
               btn.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 20)); 
  
   
           setMinSize(1200, 820);
            
           setAlignment(Pos.CENTER);
           setSpacing(30);
           
           HBox hBox = new HBox() ;
           
           btn1.setTranslateX(100);
           hBox.getChildren().addAll(btn,btn1) ;
           hBox.setAlignment(Pos.CENTER);
           getChildren().addAll(hBox) ;
           
           btn.setOnAction(e->operationAsClient());
	    }
	    
	    public void operationAsClient() {
			
			
	    }
}	
