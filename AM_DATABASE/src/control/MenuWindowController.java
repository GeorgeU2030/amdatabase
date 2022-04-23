package control;




import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.Main;
import model.Person;
import model.PersonData;


public class MenuWindowController implements Initializable{



	  private long second;
	  
	    @FXML
	    private TextField amountTF;
	    
	    @FXML
	    private ImageView imageAmerican;
	    
	    @FXML
	    private ImageView imageCreate;
	    
	    @FXML
	    private ImageView imageDelete;

	    @FXML
	    private ImageView imageRead;

	    @FXML
	    private ImageView imageUpdate;
	    
	    @FXML
	    private Label secondLabel;

	    @FXML
	    private ProgressBar pbar;
	    
	    @FXML
	    private ProgressIndicator pindicator;

	    @FXML
	    void start(ActionEvent event) throws IOException {
         Thread th = new Thread(new hilo());
         th.start();
         second=10;
         
         String amount = amountTF.getText();
         int amountPeople = Integer.parseInt(amount);
         FileReader readFile;
         readFile = new FileReader("src/data/names.csv");
			BufferedReader textFile = new BufferedReader(readFile);
	        String line;
	        String fileComplete="";
	        while((line=textFile.readLine())!=null) {
				fileComplete+=line+",";
	        }
	        ArrayList<Namesex>ns=new ArrayList<>();
	        String[] datanames = fileComplete.split(",");
	        for(int i=0;i<datanames.length;i=i+2) {
	        	Namesex names= new Namesex(datanames[i],datanames[i+1]); 
	        	ns.add(names);
	        }
	        System.out.println(ns.size());
	        if(amountPeople>6782) {
	        	amountPeople=6782;
	        }
	        int times=(amountPeople/6782)+1;
	        for(int i=0;i<times;i++) {
	        	Collections.shuffle(ns);
	        	for(int j=0;j<amountPeople;j++) {
	        		Person person=new Person(ns.get(j).name,ns.get(j).sex);
	        		PersonData.getPersonData().add(person);
	        	}
	        }
	        
	       
	    }
	    
	    @FXML
	    void createClick(ActionEvent event) {

	    }

	    @FXML
	    void deleteClick(ActionEvent event) {

	    }

	    @FXML
	    void readClick(ActionEvent event) {

	    }
	    
	    @FXML
	    void updateClick(ActionEvent event) {

	    }

	    @FXML
	    void showCountries(ActionEvent event)throws Exception {
	    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/CountryWindow.fxml"));
			 loader.setController(new CountryController());
			 Parent parent = (Parent) loader.load();
			 Stage stage = new Stage();
			 Scene scene = new Scene(parent);
			 stage.setScene(scene);
			 stage.show();
			 Stage stage2 = (Stage) imageCreate.getScene().getWindow();
			 stage2.close();
	    }
    
	  class hilo implements Runnable{

		@Override
		public void run() {
			{
			for(int i=1;i<=10;i++) {
				pbar.setProgress(i/10.0);
				pindicator.setProgress(i/10.0);
				try {
					Thread.sleep(second);
				}catch(InterruptedException ex) {
					System.out.println("error");
				}
			}
			
		}
		  
	  }
	   
}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image imcreate = new Image("icons/create.png");
		Image imread = new Image("icons/read.png");
		Image imupdate = new Image("icons/update.png");
		Image imdelete = new Image("icons/delete.png");
		Image imamerican = new Image("icons/america.png");
		imageCreate.setImage(imcreate);
		imageRead.setImage(imread);
		imageUpdate.setImage(imupdate);
		imageDelete.setImage(imdelete);
		imageAmerican.setImage(imamerican);
	}

	class Namesex{
		String name;
		String sex;
		public Namesex(String name,String sex) {
			this.name=name;
			this.sex=sex;
		}
	}
}
