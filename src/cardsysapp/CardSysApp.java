import cardsysapp.ViewLoader;
import javafx.stage.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import model.*;
import po.MyUserTable;

public class CardSysApp extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
     public void start(Stage stage) throws Exception {
        ViewLoader.showStage(new MyUserTable(), "/view/User.fxml", "", stage);
    }
}