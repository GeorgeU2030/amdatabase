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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.Main;
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
    private MenuItem createmenu;
	
	 @FXML
	private MenuItem deletemenu;

	@FXML
    private MenuItem updatemenu;
	
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
    void menu1click(ActionEvent event)throws Exception {
     if(state.equals("READ")) {
    	 FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SearchWindow.fxml"));
  		loader.setController(new SearchController("UPDATE"));
  		Parent parent = (Parent) loader.load();
  		Stage stage = new Stage();
  		Scene scene = new Scene(parent);
  		stage.setScene(scene);
  		stage.show();
  		Stage stage2 = (Stage) dataTF.getScene().getWindow();
  		stage2.close();
     }else if(state.equals("UPDATE")) {
    	 FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SearchWindow.fxml"));
 		loader.setController(new SearchController("READ"));
 		Parent parent = (Parent) loader.load();
 		Stage stage = new Stage();
 		Scene scene = new Scene(parent);
 		stage.setScene(scene);
 		stage.show();
 		Stage stage2 = (Stage) dataTF.getScene().getWindow();
 		stage2.close();
     }
    }

    @FXML
    void menu2click(ActionEvent event)throws Exception {
    	if(state.equals("READ")||state.equals("UPDATE")) {
    	 FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/UpdateWindow.fxml"));
   		loader.setController(new UpdateWindow("CREATE"));
   		Parent parent = (Parent) loader.load();
   		Stage stage = new Stage();
   		Scene scene = new Scene(parent);
   		stage.setScene(scene);
   		stage.show();
   		Stage stage2 = (Stage) dataTF.getScene().getWindow();
   		stage2.close();
    	}
    }

    @FXML
    void menu3click(ActionEvent event)throws Exception {

    }
    @FXML
    void backClick(ActionEvent event) throws Exception{
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MenuWindow.fxml"));
		 loader.setController(new MenuWindowController());
		 Parent parent = (Parent) loader.load();
		 Stage stage = new Stage();
		 Scene scene = new Scene(parent);
		 stage.setScene(scene);
		 stage.show();
		 Stage stage2 = (Stage) dataTF.getScene().getWindow();
		 stage2.close();
    }
    @FXML
    void clickAction(ActionEvent event) throws Exception{
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
    		if(pictures.get(0)==8) {
    	     	  Image image = new Image("pictures/person8.jpg");
    	     	  imagePerson.setImage(image);
    	     	  }
    	   	if(pictures.get(0)==9) {
    	     	  Image image = new Image("pictures/person9.jpg");
    	     	  imagePerson.setImage(image);
    	     	  }
    	   	if(pictures.get(0)==10) {
    	     	  Image image = new Image("pictures/person10.jpg");
    	     	  imagePerson.setImage(image);
    	     	  }
    	   	if(pictures.get(0)==11) {
    	     	  Image image = new Image("pictures/person11.jpg");
    	     	  imagePerson.setImage(image);
    	     	  }
    	   	if(pictures.get(0)==12) {
    	     	  Image image = new Image("pictures/person12.jpg");
    	     	  imagePerson.setImage(image);
    	     	  }
    	   	if(pictures.get(0)==13) {
    	     	  Image image = new Image("pictures/person13.jpg");
    	     	  imagePerson.setImage(image);
    	     	  }
    	   	if(pictures.get(0)==14) {
    	     	  Image image = new Image("pictures/person14.jpg");
    	     	  imagePerson.setImage(image);
    	     	  }
    	 // imagePerson.setImage(personClick.getImage1());
      }else if(state.equals("UPDATE")) {
    	  FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/UpdateWindow.fxml"));
  		loader.setController(new UpdateWindow(personClick,"UPDATE"));
  		Parent parent = (Parent) loader.load();
  		Stage stage = new Stage();
  		Scene scene = new Scene(parent);
  		stage.setScene(scene);
  		stage.show();
  		Stage stage2 = (Stage) buttonAction.getScene().getWindow();
  		stage2.close();
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
	   if(state.equals("UPDATE")) {
		   buttonAction.setText("UPDATE");
		   buttonAction.setStyle("-fx-background-color: #00609c; ");
		   updatemenu.setText("READ");
		   
	   }
	   if(state.equals("CREATE")) {
		   buttonAction.setText("CREATE");
		   buttonAction.setStyle("-fx-background-color: #5dc1b9; ");
		   updatemenu.setText("READ");
		   createmenu.setText("UPDATE");
	   }
	   if(state.equals("DELETE")) {
		   
	   }
	   imagePerson.setVisible(false);
	}

}

