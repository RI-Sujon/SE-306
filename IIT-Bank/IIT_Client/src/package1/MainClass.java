package Package1;

import javafx.application.Application;
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
       
        ClientLogin root = new ClientLogin() ;
        
        Scene scene = new Scene(root) ; 
        
        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.show();   
    }
    
    public static void main(String[] args) {
    	
    	 launch(args);
    }
}