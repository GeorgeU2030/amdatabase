package control;




import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

	    class thread implements Runnable{

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
	    //Method start for generate the database
	    @FXML
	    void start(ActionEvent event) throws IOException {
	    	//Method that begins the progressbar-class Thread
         Thread th = new Thread(new thread());
         th.start();
         //time
         second=100;
         
         String amount = amountTF.getText();
         long amountPeople = Long.parseLong(amount);
         FileReader readFile;
         //read the dataset names
         readFile = new FileReader("src/data/names.csv");
			BufferedReader textFile = new BufferedReader(readFile);
	        String line;
	        String fileComplete="";
	        while((line=textFile.readLine())!=null) {
				fileComplete+=line+",";
				
	        }
	        
	        //Arraylist for save the names and the sex
	        ArrayList<Namesex>ns=new ArrayList<>();
	        String[] datanames = fileComplete.split(",");
	        for(int i=0;i<datanames.length;i=i+2) 
	        {
	        	//We create the namesex for add the arraylist and later do shuffle
	        	Namesex names= new Namesex(datanames[i],datanames[i+1]); 
	        	ns.add(names);
	        }
	        //amountnamesMax is the maximun number of names in the dataset
	      long amountNamesmax=0;
	        if(amountPeople>6782) {
	        	//if is greater than amountPeople will be the max
	         amountNamesmax=6782;
	        }else {
	        	amountNamesmax=amountPeople;
	        }
	        //times that we will repeat the algorithm
	        long timesnames=(amountPeople/6783)+1;
	        for(int i=0;i<timesnames;i++) {
	        	//we do shuffle every time that we generate the maximum number of names
	        	if(i==timesnames-1) {
	        		amountNamesmax=amountPeople%6782;
	        	}
	        	Collections.shuffle(ns);
	        	for(int j=0;j<amountNamesmax;j++) {
	        		//we create a person with name and sex
	        		Person person=new Person(ns.get(j).name,ns.get(j).sex);
	        		PersonData.getPersonData().add(person);
	        	}
	        }
	        FileReader readFile2;
	         //read the dataset names
	         readFile2 = new FileReader("src/data/lastnames.csv");
				BufferedReader textFile2 = new BufferedReader(readFile2);
		        String line2;
		        String fileComplete2="";
		        while((line2=textFile2.readLine())!=null) {
					fileComplete2+=line2+",";
		        }
		        ArrayList<String>lastnamesArray=new ArrayList<>();
		        String[]lastnamesString=fileComplete2.split(",");
		        for(int i=0;i<lastnamesString.length;i=i+11) {
		        	lastnamesString[i]=lastnamesString[i].substring(1,lastnamesString[i].length()-1);
		        	lastnamesArray.add(lastnamesString[i]);
		        }
	
	          long timesLnames=(amountPeople/10000)+1;
	          long amountLnamesmax=0;
	          if(amountPeople>9999) {
		        	//if is greater than amountPeople will be the max
		         amountNamesmax=9999;
		        }else {
		        	amountLnamesmax=amountPeople;
		        }
	          for(int i=0;i<timesLnames;i++) {
	        	  if(i==timesLnames-1) {
	        		  amountLnamesmax=amountPeople%9999;
	        	  }
	        	  Collections.shuffle(lastnamesArray);
	        	  for(int j=0;j<amountLnamesmax;j++) {
                          PersonData.getPersonData().get(j).setLastname(lastnamesArray.get(j));                           		  
	        	  }
	          }
	         double age1 = amountPeople*0.19;
	         long age0_14=(long)age1;
	         double age2 = amountPeople*0.13;
	         long age15_24=(long)age1;
	         double age3 = amountPeople*0.39;
	         long age25_54=(long)age1;
	         double age4 = amountPeople*0.13;
	         long age55_64=(long)age1;
	         double age5 = amountPeople*0.16;
	         long age65=(long)age1;
	         int height=0;
	         ArrayList<Integer>months=new ArrayList<>();
	         months.add(1);
	         months.add(2);
	         months.add(3);
	         months.add(4);
	         months.add(5);
	         months.add(6);
	         months.add(7);
	         months.add(8);
	         months.add(9);
	         months.add(10);
	         months.add(11);
	         months.add(12);
	         int dayRandom=0;
	         int ageRandom=0;
	         int yearRandom=0;
	     
	         for(int i=0;i<age0_14;i++) {
	        	
	        	 yearRandom=(int)(Math.random()*(2022-2008)+2008);
	        	 
	        	 Collections.shuffle(months);
	        	 if(months.get(0)==1||months.get(0)==3||months.get(0)==5||months.get(0)==7||months.get(0)==8||months.get(0)==10||months.get(0)==12) {
	        		 dayRandom=(int)(Math.random()*(32-1)+1);
	        	 }
	        	 if(months.get(0)==4||months.get(0)==6||months.get(0)==9||months.get(0)==11) {
	        		 dayRandom=(int)(Math.random()*(31-1)+1);
	        	 }
	        	 if(months.get(0)==2&&yearRandom%4==0) {
	        		 dayRandom=(int)(Math.random()*(30-1)+1);
	        	 }
	        	 if(months.get(0)==2&&yearRandom%4!=0) {
	        		 dayRandom=(int)(Math.random()*(29-1)+1);
	        	 }
	        	 String dateString = dayRandom+"/"+ months.get(0)+"/"+yearRandom;
	        	 
	        	 Period age = Period.between(LocalDate.of(yearRandom, months.get(0), dayRandom), LocalDate.now());
	        	 ageRandom=age.getYears(); 
	        	 if(ageRandom==0||ageRandom==1) {
	        		  height=(int)(Math.random()*(70-50)+50);
	        	 }
	        	 if(ageRandom==2||ageRandom==3) {
	        		  height=(int)(Math.random()*(90-70)+70);
	        	 }
	        	 if(ageRandom>3&&ageRandom<7) {
	        		  height=(int)(Math.random()*(120-90)+90);
	        	 }
	        	 if(ageRandom>6&&ageRandom<9) {
	        		  height=(int)(Math.random()*(138-120)+120);
	        	 }
	        	 if(ageRandom>8&&ageRandom<13) {
	        		  height=(int)(Math.random()*(150-138)+138);
	        	 }
	        	 if(ageRandom>12&&ageRandom<15) {
	        		  height=(int)(Math.random()*(170-140)+140);
	        	 }
	        	  
	             PersonData.getPersonData().get(i).setAge(ageRandom);
	             PersonData.getPersonData().get(i).setHeight(height);
	             PersonData.getPersonData().get(i).setBirthDate(dateString);
	         }
	         long count=age0_14+age15_24;
	         for(int i=(int)age0_14;i<count;i++) {
	        	
              yearRandom=(int)(Math.random()*(2008-1998)+1998);
	        	 
	        	 Collections.shuffle(months);
	        	 if(months.get(0)==1||months.get(0)==3||months.get(0)==5||months.get(0)==7||months.get(0)==8||months.get(0)==10||months.get(0)==12) {
	        		 dayRandom=(int)(Math.random()*(32-1)+1);
	        	 }
	        	 if(months.get(0)==4||months.get(0)==6||months.get(0)==9||months.get(0)==11) {
	        		 dayRandom=(int)(Math.random()*(31-1)+1);
	        	 }
	        	 if(months.get(0)==2&&yearRandom%4==0) {
	        		 dayRandom=(int)(Math.random()*(30-1)+1);
	        	 }
	        	 if(months.get(0)==2&&yearRandom%4!=0) {
	        		 dayRandom=(int)(Math.random()*(29-1)+1);
	        	 }
	        	 String dateString = dayRandom+"/"+ months.get(0)+"/"+yearRandom;
	        	 
	        	 Period age = Period.between(LocalDate.of(yearRandom, months.get(0), dayRandom), LocalDate.now());
	        	 ageRandom=age.getYears();
	        	 if(ageRandom==14||ageRandom==15) {
	        		 height=(int)(Math.random()*(170-150)+150);
	        	 }
	        	 if(ageRandom>15&&ageRandom<18) {
	        		  height=(int)(Math.random()*(180-150)+150);
	        	 }
	        	 if(ageRandom>17&&ageRandom<25) {
	        		 height=(int)(Math.random()*(200-160)+160);
	        	 }
	             PersonData.getPersonData().get(i).setAge(ageRandom);
	             PersonData.getPersonData().get(i).setHeight(height);
	             PersonData.getPersonData().get(i).setBirthDate(dateString);
	         }
	         long counta=count;
	         count = count+age25_54;
	         for(int i=(int)counta;i<count;i++) {
             yearRandom=(int)(Math.random()*(1998-1968)+1968);
	        	 
	        	 Collections.shuffle(months);
	        	 if(months.get(0)==1||months.get(0)==3||months.get(0)==5||months.get(0)==7||months.get(0)==8||months.get(0)==10||months.get(0)==12) {
	        		 dayRandom=(int)(Math.random()*(32-1)+1);
	        	 }
	        	 if(months.get(0)==4||months.get(0)==6||months.get(0)==9||months.get(0)==11) {
	        		 dayRandom=(int)(Math.random()*(31-1)+1);
	        	 }
	        	 if(months.get(0)==2&&yearRandom%4==0) {
	        		 dayRandom=(int)(Math.random()*(30-1)+1);
	        	 }
	        	 if(months.get(0)==2&&yearRandom%4!=0) {
	        		 dayRandom=(int)(Math.random()*(29-1)+1);
	        	 }
	        	 String dateString = dayRandom+"/"+ months.get(0)+"/"+yearRandom;
	        	 
	        	 Period age = Period.between(LocalDate.of(yearRandom, months.get(0), dayRandom), LocalDate.now());
	        	 ageRandom=age.getYears();
	        	 height=(int)(Math.random()*(200-160)+160);
	        	 
	             PersonData.getPersonData().get(i).setAge(ageRandom);
	             PersonData.getPersonData().get(i).setHeight(height);
	             PersonData.getPersonData().get(i).setBirthDate(dateString);
	         }
	         counta=count;
	         count =count+age55_64;
	         for(int i=(int)counta;i<count;i++) {
              yearRandom=(int)(Math.random()*(1968-1958)+1958);
	        	 
	        	 Collections.shuffle(months);
	        	 if(months.get(0)==1||months.get(0)==3||months.get(0)==5||months.get(0)==7||months.get(0)==8||months.get(0)==10||months.get(0)==12) {
	        		 dayRandom=(int)(Math.random()*(32-1)+1);
	        	 }
	        	 if(months.get(0)==4||months.get(0)==6||months.get(0)==9||months.get(0)==11) {
	        		 dayRandom=(int)(Math.random()*(31-1)+1);
	        	 }
	        	 if(months.get(0)==2&&yearRandom%4==0) {
	        		 dayRandom=(int)(Math.random()*(30-1)+1);
	        	 }
	        	 if(months.get(0)==2&&yearRandom%4!=0) {
	        		 dayRandom=(int)(Math.random()*(29-1)+1);
	        	 }
	        	 String dateString = dayRandom+"/"+ months.get(0)+"/"+yearRandom;
	        	 
	        	 Period age = Period.between(LocalDate.of(yearRandom, months.get(0), dayRandom), LocalDate.now());
	        	 ageRandom=age.getYears(); 
	        	 height=(int)(Math.random()*(170-150)+150);
	             PersonData.getPersonData().get(i).setAge(ageRandom);
	             PersonData.getPersonData().get(i).setHeight(height);
	             PersonData.getPersonData().get(i).setBirthDate(dateString);
	         }
	         counta=count;
	         count=count+age65;
	         for(int i=(int)counta;i<count;i++) {
              yearRandom=(int)(Math.random()*(1958-1932)+1932);
	        	 
	        	 Collections.shuffle(months);
	        	 if(months.get(0)==1||months.get(0)==3||months.get(0)==5||months.get(0)==7||months.get(0)==8||months.get(0)==10||months.get(0)==12) {
	        		 dayRandom=(int)(Math.random()*(32-1)+1);
	        	 }
	        	 if(months.get(0)==4||months.get(0)==6||months.get(0)==9||months.get(0)==11) {
	        		 dayRandom=(int)(Math.random()*(31-1)+1);
	        	 }
	        	 if(months.get(0)==2&&yearRandom%4==0) {
	        		 dayRandom=(int)(Math.random()*(30-1)+1);
	        	 }
	        	 if(months.get(0)==2&&yearRandom%4!=0) {
	        		 dayRandom=(int)(Math.random()*(29-1)+1);
	        	 }
	        	 String dateString = dayRandom+"/"+ months.get(0)+"/"+yearRandom;
	        	 
	        	 Period age = Period.between(LocalDate.of(yearRandom, months.get(0), dayRandom), LocalDate.now()); 
	        	 height=(int)(Math.random()*(170-150)+150);
	        	 ageRandom=age.getYears();
	             PersonData.getPersonData().get(i).setAge(ageRandom);
	             PersonData.getPersonData().get(i).setHeight(height);
	             PersonData.getPersonData().get(i).setBirthDate(dateString);
	         }   
	         for(int i=(int)count;i<amountPeople;i++) {
             yearRandom=(int)(Math.random()*(1997-1987)+1987);
	        	 
	        	 Collections.shuffle(months);
	        	 if(months.get(0)==1||months.get(0)==3||months.get(0)==5||months.get(0)==7||months.get(0)==8||months.get(0)==10||months.get(0)==12) {
	        		 dayRandom=(int)(Math.random()*(32-1)+1);
	        	 }
	        	 if(months.get(0)==4||months.get(0)==6||months.get(0)==9||months.get(0)==11) {
	        		 dayRandom=(int)(Math.random()*(31-1)+1);
	        	 }
	        	 if(months.get(0)==2&&yearRandom%4==0) {
	        		 dayRandom=(int)(Math.random()*(30-1)+1);
	        	 }
	        	 if(months.get(0)==2&&yearRandom%4!=0) {
	        		 dayRandom=(int)(Math.random()*(29-1)+1);
	        	 }
	        	 String dateString = dayRandom+"/"+ months.get(0)+"/"+yearRandom;
	        	 
	        	 Period age = Period.between(LocalDate.of(yearRandom, months.get(0), dayRandom), LocalDate.now());
	        	 height=(int)(Math.random()*(200-160)+160);
	        	 ageRandom=age.getYears();
	             PersonData.getPersonData().get(i).setAge(ageRandom);
	             PersonData.getPersonData().get(i).setHeight(height);
	             PersonData.getPersonData().get(i).setBirthDate(dateString);
	         }
	        /* for(int i=0;i<PersonData.getPersonData().size();i++) {
	        	 System.out.println(i+1+""+PersonData.getPersonData().get(i).getName()+" "+PersonData.getPersonData().get(i).getAge()+" "+PersonData.getPersonData().get(i).getHeight()+PersonData.getPersonData().get(i).getBirthDate());
	         }*/
	         FileReader readFile3;
	         //read the dataset names
	         readFile3 = new FileReader("src/data/nations.csv");
				BufferedReader textFile3 = new BufferedReader(readFile3);
		        String line3;
		        String fileComplete3="";
		        while((line3=textFile3.readLine())!=null) {
					fileComplete3+=line3+",";
		        }
		        String[]nationsArray=fileComplete3.split(",");
		        int indexN=4;
		        int indexG=2;
		        double porcentageN=0;
		        
		        porcentageN=Double.parseDouble(nationsArray[indexN])*amountPeople;
		        int amountN=(int)porcentageN;
		        for(int i=0;i<=amountN;i++) {
		        	PersonData.getPersonData().get(i).setNationality(nationsArray[indexG]);
		        	if(i==amountPeople) {
		        		break;
		        	}
		        	if(i==amountN) {
		        		i=amountN;
		        		indexN+=5;
		        		indexG+=5;
		        		porcentageN=Double.parseDouble(nationsArray[indexN])*amountPeople;
		        		amountN=(int)porcentageN;
		        		amountN+=i;
		        	}
		        	
		        }
		        indexG=2;
		        for(int i=amountN+1;i<amountPeople;i++) {
		        	PersonData.getPersonData().get(i).setNationality(nationsArray[indexG]);
		        	indexG+=5;
		        	if(indexG>177) {
		        		indexG=2;
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
