package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import model.Person;
import model.PersonData;


public class SearchController implements Initializable {

	private ObservableList<Person> datesRange= FXCollections.observableArrayList();
	@FXML
    private TableColumn<Person,String> columnData;
	
	 @FXML
	 private TableView<Person> tableData;
	 
	 @FXML
	 private MenuBar options;
	 
	 @FXML
	 private Menu menuOptions;
	 
    @FXML
    private TextField dataTF;

    @FXML
    void keyTyped(KeyEvent event) {
    	datesRange.removeAll(datesRange);
     for(int i=0;i<PersonData.getPersonData().size();i++) {
    	 if(PersonData.getPersonData().get(i).getName().contains(dataTF.getText())) {
    		 datesRange.add(PersonData.getPersonData().get(i));
    		 
    	 }
    	 
     }
     tableData.setItems(datesRange);
     
    }

    @FXML
    void nameSearch(ActionEvent event) {
    menuOptions.setText("Name");
    }

    @FXML
    void searchCode(ActionEvent event) {
    	menuOptions.setText("Code");
    }

    @FXML
    void searchCompleteName(ActionEvent event) {
    	menuOptions.setText("Complete Name");
    }

    @FXML
    void searchLastName(ActionEvent event) {
    	menuOptions.setText("Last Name");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		columnData.setCellValueFactory(new PropertyValueFactory<>("name"));
		
	}

}

