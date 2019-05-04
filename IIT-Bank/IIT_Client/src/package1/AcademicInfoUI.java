package package1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class AcademicInfoUI extends VBox{
    Label [] label = new Label[10] ;
    TextField [] info = new TextField[10] ;
    HBox [] hbox = new HBox[10] ;
    Button []button = new Button[2] ;
    Label lbl = new Label() ;
	
    public AcademicInfoUI(){
            
            label[0] = new Label("Student Name:") ;
            label[1] = new Label("Roll:") ;
            label[2] = new Label("Registration No:") ;
            label[3] = new Label("Father's Name:") ;
            label[4] = new Label("Mother's Name:") ;
            label[5] = new Label("Date Of Birth:") ;
            label[6] = new Label("Result:") ;
            label[7] = new Label("Student Information") ;
            label[7].setMinHeight(40);
            label[7].setMinWidth(200) ;
            label[7].setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 50));
            getChildren().add(label[7]) ;
             
        
           for(int i=0 ; i<7 ; i++)
           {
                hbox[i] = new HBox() ;
                info[i] = new TextField() ;
                info[i].setMinHeight(40);
                info[i].setMinWidth(300) ;
                label[i].setMinHeight(40);
                label[i].setMinWidth(200) ;
                label[i].setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 20)); 
                hbox[i].getChildren().addAll(label[i],info[i]) ;
                hbox[i].setAlignment(Pos.CENTER);
                getChildren().addAll(hbox[i]) ;
           }
           
           info[5].setText("dd-mm-yyyy");
            
            setMinSize(1200, 820);

            setAlignment(Pos.CENTER);
            setSpacing(20);
            setStyle("-fx-background-color : Beige"); 


            button[1] = new Button("Submit") ;
            button[1].setFont(Font.font("Times new Roman", FontPosture.REGULAR, 28));
            button[1].setMinSize(100,50 );
            button[1].setTextFill(Color.GREENYELLOW);
            button[1].setStyle("-fx-background-color: Purple");

            HBox hBox = new HBox() ;

            hBox.getChildren().addAll(button[1]) ;
            hBox.setAlignment(Pos.CENTER);
            getChildren().addAll(hBox) ;

            System.out.println("matha");
            info[0].setOnAction(e->info[0].setText(info[0].getText()));

            button[1].setOnAction(e->operation());
            
            getChildren().addAll(lbl) ;
    }
    
    public void operation() {
		String sName = info[0].getText();
                String roll = info[1].getText();
		String reg = info[2].getText();
		String fName = info[3].getText();
		String mName = info[4].getText();
		String dOb = info[5].getText();
                String result = info[6].getText();
		
		CheckPersonal acc = new CheckPersonal() ; 
		int value = acc.checking(sName, reg, fName, mName, dOb) ;
                
                
		
                if(sName.equals("") ||roll.equals("") ||reg.equals("") ||fName.equals("") ||mName.equals("") ||dOb.equals("") ||result.equals("")){
                    lbl.setText("Please Write All Information");
                }
			
                else{
                    
                    if(acc.loginForUpdate(roll)){
                        lbl.setText("Already Has an Account");
                    }
                    
                    else {
                        ClientLogin root = new ClientLogin(sName,roll, reg, fName, mName, dOb, reg) ;
                        Scene scene = new Scene(root) ;

                        MainClass.getStage().setScene(scene);
                    }
                }
    }
}
    