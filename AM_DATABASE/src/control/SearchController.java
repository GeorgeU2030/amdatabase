package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import model.AVL;
import model.Person;
import model.PersonData;



public class SearchController implements Initializable {
    
	private Person personClick=new Person("","");
	@FXML
    private Button buttonAction;
	private String state="";
	public SearchController(String state) {
		this.state=state;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static ObservableList<Person> datesRange= FXCollections.observableArrayList();
	@FXML
    private TableColumn<Person,String> columnData;
	

    @FXML
    private Label labelAge;

    @FXML
    private Label labelLast;

    @FXML
    private Label labelName;
	@FXML
    private ImageView imagePerson;
	
	 @FXML
	 private TableView<Person> tableData;
	 
	 @FXML
	 private MenuBar options;
	 
	 @FXML
	 private Menu menuOptions;
	 
    @FXML
    private TextField dataTF;

    @FXML
    private Label labelproof;
    @FXML
    void clickAction(ActionEvent event) {
      if(state.equals("READ")) {
    	  labelName.setText(personClick.getName());
    	  labelLast.setText(personClick.getLastname());
    	  labelAge.setText("AGE: "+String.valueOf(personClick.getAge()));
    	  labelName.setVisible(true);
    	  labelLast.setVisible(true);
    	  labelAge.setVisible(true);
    	  imagePerson.setVisible(true);
    	  ArrayList<Integer>pictures=new ArrayList<>();
    	  for(int i=1;i<15;i++) {
    		  pictures.add(i);
    	  }
    	  Collections.shuffle(pictures);
    	  if(pictures.get(0)==1) {
    	  Image image = new Image("pictures/person1.jpg");
    	  imagePerson.setImage(image);
    	  }
    	  if(pictures.get(0)==2) {
        	  Image image = new Image("pictures/person2.jpg");
        	  imagePerson.setImage(image);
        	  }
    	  if(pictures.get(0)==3) {
        	  Image image = new Image("pictures/person3.jpg");
        	  imagePerson.setImage(image);
        	  }
    	  if(pictures.get(0)==4) {
        	  Image image = new Image("pictures/person4.jpg");
        	  imagePerson.setImage(image);
        	  }
    	  if(pictures.get(0)==5) {
        	  Image image = new Image("pictures/person5.jpg");
        	  imagePerson.setImage(image);
        	  }
    	  if(pictures.get(0)==6) {
        	  Image image = new Image("pictures/person6.jpg");
        	  imagePerson.setImage(image);
        	  }
    	  if(pictures.get(0)==7) {
        	  Image image = new Image("pictures/person7.jpg");
        	  imagePerson.setImage(image);
        	  }
    	 // imagePerson.setImage(personClick.getImage1());
      }
    }
    @FXML
    void keyTyped(KeyEvent event) {
    	datesRange.removeAll(datesRange);
    	AVL.datas.removeAll(AVL.datas);
    	String data =dataTF.getText();
    	if(menuOptions.getText().equals("Name")) {
    	columnData.setCellValueFactory(new PropertyValueFactory<>("name"));
    	MenuWindowController.AVLnames.search(data);
    	 for(int i=0;i<PersonData.getPersonData().size();i++) {
        	 for(int j=0;j<AVL.datas.size();j++) {
        	 if(PersonData.getPersonData().get(i).getName().equals(AVL.datas.get(j))) {
        		 datesRange.add(PersonData.getPersonData().get(i));
        		 
        	 }
        	 }
        	 
         }
    	}else if(menuOptions.getText().equals("Code")) {
    	columnData.setCellValueFactory(new PropertyValueFactory<>("code"));
        MenuWindowController.AVLcode.search(data);	
        for(int i=0;i<PersonData.getPersonData().size();i++) {
       	 for(int j=0;j<AVL.datas.size();j++) {
       	 if(PersonData.getPersonData().get(i).getCode().equals(AVL.datas.get(j))) {
       		 datesRange.add(PersonData.getPersonData().get(i));
       		 
       	 }
       	 }
       	 
        }
    	}else if(menuOptions.getText().equals("Complete Name")) {
    	columnData.setCellValueFactory(new PropertyValueFactory<>("completename"));
        MenuWindowController.AVLcompletename.search(data);
        for(int i=0;i<PersonData.getPersonData().size();i++) {
       	 for(int j=0;j<AVL.datas.size();j++) {
       	 if(PersonData.getPersonData().get(i).getCompletename().equals(AVL.datas.get(j))) {
       		 datesRange.add(PersonData.getPersonData().get(i));
       		 
       	 }
       	 }
       	 
        }
        }else if(menuOptions.getText().equals("Last Name")) {
        columnData.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        MenuWindowController.AVLlastnames.search(data);	
        for(int i=0;i<PersonData.getPersonData().size();i++) {
       	 for(int j=0;j<AVL.datas.size();j++) {
       	 if(PersonData.getPersonData().get(i).getLastname().equals(AVL.datas.get(j))) {
       		 datesRange.add(PersonData.getPersonData().get(i));
       		 
       	 }
       	 }
       	 
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
		tableData.setOnMouseClicked(
				event->{
					personClick = tableData.getSelectionModel().getSelectedItem();
					//System.out.println(personClick.getName());
					
				}
				);
		labelName.setVisible(false);
		labelLast.setVisible(false);
		labelAge.setVisible(false);
	   if(state.equals("READ")) {
			buttonAction.setText("READ");
		}
	   imagePerson.setVisible(false);
	}

}

