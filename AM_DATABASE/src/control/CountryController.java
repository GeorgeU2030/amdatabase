package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import main.Main;

public class CountryController {
 
	@FXML
    private MenuBar optionMenu;
	  
	@FXML
    void backMenu(ActionEvent event)throws Exception {
		 FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MenuWindow.fxml"));
		 loader.setController(new MenuWindowController());
		 Parent parent = (Parent) loader.load();
		 Stage stage = new Stage();
		 Scene scene = new Scene(parent);
		 stage.setScene(scene);
		 stage.show();
		 Stage stage2 = (Stage) optionMenu.getScene().getWindow();
		 stage2.close();
    }

    @FXML
    void exiit(ActionEvent event) {
       System.exit(0);
    } 
}
