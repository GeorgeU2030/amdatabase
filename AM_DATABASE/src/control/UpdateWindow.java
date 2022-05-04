package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.Main;
import model.Person;
import model.PersonData;

public class UpdateWindow implements Initializable{
    private String state="";
	private Person user=new Person("","");
	public UpdateWindow(Person person,String state) {
		this.user=person;
		this.state=state;
	}
	public UpdateWindow(String state) {
		this.state=state;
	}
	@FXML
    private MenuItem createmenu;
	 @FXML
	 private MenuItem readmenu;
    @FXML
    private TextField ageTF;

    @FXML
    private TextField birthTF;

    @FXML
    private Label codeLabel;

    @FXML
    private Button generateButton;

    @FXML
    private TextField heightTF;

    @FXML
    private ImageView imageCountry;

    @FXML
    private TextField lastnameTF;

    @FXML
    private TextField nameTF;

    @FXML
    private TextField nationalityTF;

    @FXML
    private ImageView picturePerson;

    @FXML
    private TextField sexTF;

    @FXML
    void CreateWindow(ActionEvent event) throws Exception{
     if(state.equals("UPDATE")) {
    	 FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/UpdateWindow.fxml"));
  		loader.setController(new UpdateWindow("CREATE"));
  		Parent parent = (Parent) loader.load();
  		Stage stage = new Stage();
  		Scene scene = new Scene(parent);
  		stage.setScene(scene);
  		stage.show();
  		Stage stage2 = (Stage) nameTF.getScene().getWindow();
  		stage2.close();
     }else if(state.equals("CREATE")){
    	 FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SearchWindow.fxml"));
 		loader.setController(new SearchController("UPDATE"));
 		Parent parent = (Parent) loader.load();
 		Stage stage = new Stage();
 		Scene scene = new Scene(parent);
 		stage.setScene(scene);
 		stage.show();
 		Stage stage2 = (Stage) nameTF.getScene().getWindow();
 		stage2.close();
     }
    }

    @FXML
    void backMenu(ActionEvent event) throws Exception{

    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MenuWindow.fxml"));
		 loader.setController(new MenuWindowController());
		 Parent parent = (Parent) loader.load();
		 Stage stage = new Stage();
		 Scene scene = new Scene(parent);
		 stage.setScene(scene);
		 stage.show();
		 Stage stage2 = (Stage) nameTF.getScene().getWindow();
		 stage2.close();
    }
    @FXML
    void deleteWindow(ActionEvent event) {

    }

    @FXML
    void readWindow(ActionEvent event) throws Exception{
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SearchWindow.fxml"));
		loader.setController(new SearchController("READ"));
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		Stage stage2 = (Stage) nameTF.getScene().getWindow();
		stage2.close();
    }
    @FXML
    void buttonAction(ActionEvent event) {
     if(state.equals("UPDATE")) {
    	 try {
    	 user.setAge(Integer.parseInt(ageTF.getText()));
    	 user.setHeight(Integer.parseInt(heightTF.getText()));
    	 user.setName(nameTF.getText());
    	 user.setLastname(lastnameTF.getText());
    	 user.setSex(sexTF.getText());
    	 user.setBirthDate(birthTF.getText());
    	 user.setNationality(nationalityTF.getText());
    	 }catch(Exception ex) {
    		 showAlertError();
    	 }
     }else if(state.equals("CREATE")) {
    	 try {
    	 Person person = new Person(nameTF.getText(),sexTF.getText());
    	 person.setAge(Integer.parseInt(ageTF.getText()));
    	 person.setHeight(Integer.parseInt(heightTF.getText()));
    	 person.setLastname(lastnameTF.getText());
         person.setBirthDate(birthTF.getText());
         person.setNationality(nationalityTF.getText());
         person.setCode(codeLabel.getText()); 
    	 }catch(Exception ex) {
    		 showAlertError();
    	 }
     }
    }
    private void showAlertError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("ERROR");
        alert.setContentText("All Fields are Required");
        alert.showAndWait();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
       if(state.equals("UPDATE")) {
    	   chargeImage();
         	  
     	  ageTF.setText(String.valueOf(user.getAge()));
     	  heightTF.setText(String.valueOf(user.getHeight()));
     	  nameTF.setText(user.getName());
     	  lastnameTF.setText(user.getLastname());
     	  String sex="";
     	  if(user.getSex().equals("boy")) {
     		  sex="M";
     	  }else if(user.getSex().equals("girl")) {
     		  sex="F";
     	  }
     	  
     	  sexTF.setText(sex);
     	  codeLabel.setText(user.getCode());
     	  birthTF.setText(user.getBirthDate());
     	  nationalityTF.setText(user.getNationality());
     	  generateButton.setText("UPDATE");
     	  
       }else if(state.equals("CREATE")) {
    	   chargeImage();
    	   generateButton.setText("CREATE");
    	   String code=generateCode();
    	   codeLabel.setText(code);
    	   createmenu.setText("UPDATE");
       }
	}

	public void changeFlag(String nationality) {
      		
	}
	public void chargeImage() {
		ArrayList<Integer>pictures=new ArrayList<>();
   	  for(int i=1;i<15;i++) {
   		  pictures.add(i);
   	  }
   	  Collections.shuffle(pictures);
   	  if(pictures.get(0)==1) {
   	  Image image = new Image("pictures/person1.jpg");
   	  picturePerson.setImage(image);
   	  }
   	  if(pictures.get(0)==2) {
       	  Image image = new Image("pictures/person2.jpg");
       	   picturePerson.setImage(image);
       	  }
   	  if(pictures.get(0)==3) {
       	  Image image = new Image("pictures/person3.jpg");
       	  picturePerson.setImage(image);
       	  }
   	  if(pictures.get(0)==4) {
       	  Image image = new Image("pictures/person4.jpg");
       	  picturePerson.setImage(image);
       	  }
   	  if(pictures.get(0)==5) {
       	  Image image = new Image("pictures/person5.jpg");
       	  picturePerson.setImage(image);
       	  }
   	  if(pictures.get(0)==6) {
       	  Image image = new Image("pictures/person6.jpg");
       	  picturePerson.setImage(image);
       	  }
   	  if(pictures.get(0)==7) {
       	  Image image = new Image("pictures/person7.jpg");
       	  picturePerson.setImage(image);
       	  }
   	if(pictures.get(0)==8) {
     	  Image image = new Image("pictures/person8.jpg");
     	  picturePerson.setImage(image);
     	  }
   	if(pictures.get(0)==9) {
     	  Image image = new Image("pictures/person9.jpg");
     	  picturePerson.setImage(image);
     	  }
   	if(pictures.get(0)==10) {
     	  Image image = new Image("pictures/person10.jpg");
     	  picturePerson.setImage(image);
     	  }
   	if(pictures.get(0)==11) {
     	  Image image = new Image("pictures/person11.jpg");
     	  picturePerson.setImage(image);
     	  }
   	if(pictures.get(0)==12) {
     	  Image image = new Image("pictures/person12.jpg");
     	  picturePerson.setImage(image);
     	  }
   	if(pictures.get(0)==13) {
     	  Image image = new Image("pictures/person13.jpg");
     	  picturePerson.setImage(image);
     	  }
   	if(pictures.get(0)==14) {
     	  Image image = new Image("pictures/person14.jpg");
     	  picturePerson.setImage(image);
     	  }
	}
	public String generateCode() {
		ArrayList<String>alphabet=new ArrayList<>();
	    alphabet.add("A");
	    alphabet.add("B");
	    alphabet.add("C");
	    alphabet.add("D");
	    alphabet.add("E");
	    alphabet.add("F");
	    alphabet.add("G");
	    alphabet.add("H");
	    alphabet.add("I");
	    alphabet.add("J");
	    alphabet.add("K");
	    alphabet.add("L");
	    alphabet.add("M");
	    alphabet.add("N");
	    alphabet.add("O");
	    alphabet.add("P");
	    alphabet.add("Q");
	    alphabet.add("R");
	    alphabet.add("S");
	    alphabet.add("T");
	    alphabet.add("U");
	    alphabet.add("V");
	    alphabet.add("W");
	    alphabet.add("X");
	    alphabet.add("Y");
	    alphabet.add("Z");
	    ArrayList<String>numberscode = new ArrayList<>();
	    numberscode.add("1");
	    numberscode.add("2");
	    numberscode.add("3");
	    numberscode.add("4");
	    numberscode.add("5");
	    numberscode.add("6");
	    numberscode.add("7");
	    numberscode.add("8");
	    numberscode.add("9");
	    numberscode.add("0");
	    String code="";
	    	Collections.shuffle(alphabet);
	    	Collections.shuffle(numberscode);
	    	code = alphabet.get(0)+alphabet.get(1)+alphabet.get(2)+numberscode.get(0)+numberscode.get(1)+numberscode.get(2);
	    return code;
	}
}

