package package1;

import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class Menu extends VBox {
    
    Button [] button = new Button[5] ;

    public Menu() {
        button[0] = new Button("Create Certificate") ;
        button[0].setFont(Font.font("Times new Roman", FontPosture.REGULAR, 40));
        button[0].setMinSize(400,50 );
        button[0].setTextFill(Color.WHITE);
        button[0].setStyle("-fx-background-color: Gray");
        button[1] = new Button("Update Certificate") ;
        button[1].setFont(Font.font("Times new Roman", FontPosture.REGULAR, 40));
        button[1].setMinSize(400,50 );
        button[1].setTextFill(Color.WHITE);
        button[1].setStyle("-fx-background-color: Gray");
        button[2] = new Button("Print Information") ;
        button[2].setFont(Font.font("Times new Roman", FontPosture.REGULAR, 40));
        button[2].setMinSize(400,50 );
        button[2].setTextFill(Color.WHITE);
        button[2].setStyle("-fx-background-color: Gray");
        getChildren().addAll(button[0],button[1],button[2]) ;
        setAlignment(Pos.CENTER);
        setSpacing(50);
        setMinSize(1200, 820);
        setStyle("-fx-background-color : Beige");
        
        button[0].setOnAction(e->{createNewCertificate();});
        button[1].setOnAction(e->{updateCertificate();});
        button[2].setOnAction(e->{printAllInfo();});
    }
    
    public void createNewCertificate(){
        
        AcademicInfoUI root = new AcademicInfoUI() ;
        Scene scene = new Scene(root) ;
        MainClass.getStage().setScene(scene);
    }
    
    public void updateCertificate(){
        
        UpdateInfoUI root = new UpdateInfoUI();
        Scene scene = new Scene(root) ;
        MainClass.getStage().setScene(scene);
    }
    
    public void printAllInfo(){
        
        PrintInfoUI root = new PrintInfoUI();
        Scene scene = new Scene(root) ;
        MainClass.getStage().setScene(scene);
    }
    
}
