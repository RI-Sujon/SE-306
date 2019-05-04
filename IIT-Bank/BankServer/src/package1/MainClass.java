package package1;


import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {
    private static Stage stage ;

    public static Stage getStage() {
        return stage;
    }
    
    public void start(Stage primaryStage) throws Exception{
        
        this.stage = primaryStage ;
        
        //createNewFile() ;
       
        BankUIMenu root = new BankUIMenu();
        
        Scene scene = new Scene(root) ; 
        
        primaryStage.setTitle("Bank Server ");
        primaryStage.setScene(scene);
        primaryStage.show();   
    }
    
    public static void main(String[] args) throws IOException {
    	
    	 launch(args);
         
    }
}