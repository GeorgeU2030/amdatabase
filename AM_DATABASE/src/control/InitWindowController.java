package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.Main;

public class InitWindowController implements Initializable{

	 @FXML
     private ImageView imageBD;
	
	 @FXML
	    void enterApp(ActionEvent event) throws Exception{
		 FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MenuWindow.fxml"));
		 loader.setController(new MenuWindowController());
		 Parent parent = (Parent) loader.load();
		 Stage stage = new Stage();
		 Scene scene = new Scene(parent);
		 stage.setScene(scene);
		 stage.show();
		 Stage stage2 = (Stage) imageBD.getScene().getWindow();
		 stage2.close();
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image bd = new Image("icons/bd.png");
		imageBD.setImage(bd);
		
	}
}

