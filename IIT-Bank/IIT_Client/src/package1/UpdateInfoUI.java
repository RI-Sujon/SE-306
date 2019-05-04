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


public class UpdateInfoUI extends VBox{
    Label [] label = new Label[10] ;
    TextField [] info = new TextField[10] ;
    HBox [] hbox = new HBox[10] ;
    Button []button = new Button[10] ;
    Label lbl = new Label() ;
    int flag = -1 ;
	
    public UpdateInfoUI(){
            
            button[0] = new Button("Change Name") ;
            button[1] = new Button("Change Father's Name") ;
            button[2] = new Button("Change Mother's Name") ;
            button[3] = new Button("Change Date Of Birth") ;
            button[4] = new Button("Change Result") ;
            button[5] = new Button("Go To Menu") ;
            
            for(int i=0 ; i<6 ; i++){
                button[i].setFont(Font.font("Times new Roman", FontPosture.REGULAR, 28));
                button[i].setMinSize(300,40 );
                button[i].setTextFill(Color.WHITESMOKE);
                button[i].setStyle("-fx-background-color: Gray");
            }
            
            
            label[0] = new Label() ;
            label[1] = new Label("Enter Roll Number: ") ;
            
            label[2] = new Label("Update Student Information") ;
            label[2].setMinHeight(40);
            label[2].setMinWidth(200) ;
            label[2].setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 50));
            getChildren().add(label[2]) ;
             
        
       
                hbox[0] = new HBox() ;
                info[0] = new TextField() ;
                info[0].setMinHeight(40);
                info[0].setMinWidth(300) ;
                label[1].setMinHeight(40);
                label[1].setMinWidth(200) ;
                label[1].setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 20)); 
                hbox[0].getChildren().addAll(label[1],info[0]) ;
                hbox[0].setAlignment(Pos.CENTER);
                
           
           getChildren().addAll(hbox[0]) ;
            
            setMinSize(1200, 820);

            setAlignment(Pos.CENTER);
            setSpacing(20);
            setStyle("-fx-background-color : Beige"); 

            button[6] = new Button("Submit") ;
            button[6].setFont(Font.font("Times new Roman", FontPosture.REGULAR, 28));
            button[6].setMinSize(100,50 );
            button[6].setTextFill(Color.GREENYELLOW);
            button[6].setStyle("-fx-background-color: Purple");

            hbox[1] = new HBox() ;

            hbox[1].getChildren().addAll(button[6]) ;
            hbox[1].setAlignment(Pos.CENTER);
            getChildren().addAll(hbox[1]) ;

            button[6].setOnAction(e->operation());
            
            getChildren().addAll(lbl) ;
    }
    
    public void operation() {
        String roll = info[0].getText();

        CheckPersonal personal = new CheckPersonal(); 
        if(personal.loginForUpdate(roll)){

            getChildren().remove(hbox[0]) ;
            getChildren().remove(hbox[1]) ;
            HBox hb = new HBox() ;
            HBox hb1 = new HBox() ;
            VBox vb = new VBox() ;
            VBox vb1 = new VBox() ;
            Label lb = new Label() ;
            TextField tf = new TextField() ;
            tf.setMinHeight(40);
            tf.setMinWidth(300) ;
            lb.setMinHeight(40);
            lb.setMinWidth(200) ;
            lb.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 20));

            Button btn = new Button("Submit") ;

            vb.getChildren().addAll(button[0],button[1],button[2],button[3],button[4],button[5]) ;
            vb.setSpacing(20);
            hb.getChildren().addAll(lb,tf) ;
            vb1.getChildren().addAll(hb,btn) ;
            vb1.setSpacing(50);
            vb1.setAlignment(Pos.CENTER);
            hb1.getChildren().addAll(vb,vb1) ;
            hb1.setAlignment(Pos.CENTER);
            hb1.setSpacing(30);
            getChildren().add(hb1) ;

            button[0].setOnAction(e->{
                lb.setText("Change Name:");
                setFlag(0) ;
            });

            button[1].setOnAction(e->{
                lb.setText("Change Father's Name:");
                setFlag(1) ;
            });
            button[2].setOnAction(e->{
                lb.setText("Change Mother's Name:");
                setFlag(2) ;
            });
            button[3].setOnAction(e->{
                lb.setText("Change Date Of Birth:");
                tf.setText("dd-mm-yyyy");
                setFlag(3) ;
            });
            button[4].setOnAction(e->{
                lb.setText("Change Result:");
                setFlag(4) ;
            });

            button[5].setOnAction(e->{
                Menu root1 = new Menu() ;
                Scene scene1 = new Scene(root1) ;
                MainClass.getStage().setScene(scene1);
            });

            btn.setOnAction(e->{
                String data = tf.getText() ;
                personal.updateInfo(roll, data, flag);
                tf.setText("");
                lb.setText("");
            });

        }

        else lbl.setText("Wrong Roll Number");
		
    }
    
    public void setFlag(int n){
        flag = n ;
    }
}
    