package Package1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class Menu extends VBox{
	Label [] label = new Label[8] ;
    TextField [] info = new TextField[8] ;
    HBox [] hbox = new HBox[8] ;
    Button []button = new Button[2] ;
	
	
    public Menu(){
    }
    
    public Menu(int n){
            
            label[0] = new Label("Student Name:") ;
            label[1] = new Label("Registration No:") ;
            label[2] = new Label("Father's Name:") ;
            label[3] = new Label("Mother's Name:") ;
            label[4] = new Label("Date Of Birth:") ;
        
           for(int i=0 ; i<5 ; i++)
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
           
           button[1].setOnAction(e->operation());
           
    }
    
    public void operation() {
		String sName = info[0].getText();
		String reg = info[1].getText();
		String fName = info[2].getText();
		String mName = info[3].getText();
		String dOb = info[4].getText();
		
		CheckPersonal acc = new CheckPersonal() ; 
		int value = acc.checking(sName, reg, fName, mName, dOb) ;
		
		if(value == 1) {
			ClientLogin root = new ClientLogin() ;
			Scene scene = new Scene(root) ;
			
			MainClass.getStage().setScene(scene); 
			System.out.println("Ok...Everything is Alright") ;
		}
		
    }
}
    