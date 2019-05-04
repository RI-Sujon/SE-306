package package1;

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


public class PrintInfoUI extends VBox{
    Label [] label = new Label[10] ;
    Label [] info = new Label[10] ;
    HBox [] hbox = new HBox[10] ;
    Button []button = new Button[10] ;
    Label lbl = new Label() ;
    TextField info0 = new TextField() ;
    int n = -1 ;
   
	
    public PrintInfoUI(){
            
            label[0] = new Label() ;
            label[1] = new Label("Enter Roll Number: ") ;
            
            label[2] = new Label("Student Information") ;
            label[2].setMinHeight(40);
            label[2].setMinWidth(200) ;
            label[2].setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 50));
            getChildren().add(label[2]) ;
            
            label[3] = new Label("Name") ;
            label[4] = new Label("Roll") ;
            label[5] = new Label("Registration") ;
            label[6] = new Label("Father's Name:") ;
            label[7] = new Label("Mother's Name:") ;
            label[8] = new Label("Date Of Birth:") ;
            label[9] = new Label("Result:") ;
        
          
            
            for(int i=3 ; i<10 ; i++)
           {
                hbox[i] = new HBox() ;
                info[i] = new Label() ;
                info[i].setMinHeight(40);
                info[i].setMinWidth(300) ;
                label[i].setMinHeight(40);
                label[i].setMinWidth(200) ;
                label[i].setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 20)); 
                hbox[i].getChildren().addAll(label[i],info[i]) ;
                hbox[i].setAlignment(Pos.CENTER);
                
           }
        
           
       
                hbox[0] = new HBox() ;
                
                info0.setMinHeight(40);
                info0.setMinWidth(300) ;
                label[1].setMinHeight(40);
                label[1].setMinWidth(200) ;
                label[1].setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 20)); 
                hbox[0].getChildren().addAll(label[1],info0) ;
                hbox[0].setAlignment(Pos.CENTER);
                
           
           getChildren().addAll(hbox[0]) ;
            
            setMinSize(1200, 820);

            setAlignment(Pos.CENTER);
            setSpacing(20);
            setStyle("-fx-background-color : Beige"); 

            button[0] = new Button("Submit") ;
            button[0].setFont(Font.font("Times new Roman", FontPosture.REGULAR, 28));
            button[0].setMinSize(100,50 );
            button[0].setTextFill(Color.GREENYELLOW);
            button[0].setStyle("-fx-background-color: Purple");

            hbox[1] = new HBox() ;

            hbox[1].getChildren().addAll(button[0]) ;
            hbox[1].setAlignment(Pos.CENTER);
            getChildren().addAll(hbox[1]) ;
            

            button[0].setOnAction(e->operation());
            
            Button newbutton = new Button("Go to Menu") ;
            
            getChildren().addAll(lbl,newbutton) ;
            newbutton.setFont(Font.font("Times new Roman", FontPosture.REGULAR, 30));
            newbutton.setMinSize(100,40 );
            newbutton.setTextFill(Color.WHITE);
            newbutton.setStyle("-fx-background-color: Gray");
            
            newbutton.setOnAction(e->goTOMenu());
    }
    
    public void goTOMenu(){
        Menu root1 = new Menu() ;
        Scene scene1 = new Scene(root1) ;
        MainClass.getStage().setScene(scene1);
    }
    
    public void operation() {   
            String roll = info0.getText();
                System.out.println("matha3:" + roll);
		CheckPersonal personal = new CheckPersonal() ;
                if(personal.loginForUpdate(roll)&&n==-1){
                    String [] str = personal.printAllInfo(roll).split("&") ;
                    for(int i=0 ; i< 7 ;i++){
                        info[i+3].setText(str[i]);
                        getChildren().addAll(hbox[i+3]) ;
                        n=1 ;
                    }
                }
                
                else if(personal.loginForUpdate(roll)&&n==1){
                    String [] str = personal.printAllInfo(roll).split("&") ;
                    for(int i=0 ; i< 7 ;i++){
                        info[i+3].setText(str[i]);
                        
                    }
                }
                
                else lbl.setText("Wrong Roll Number");
		
    }
    
    
}
    