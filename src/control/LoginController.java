package control;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import model.Function;
import model.MovieTheater;
import model.PersonalData;
public class LoginController {

	
	private static String id;
	 public static String getId() {
		return id;
	}
	public static void setId(String id) {
		LoginController.id = id;
	}
	@FXML
	    private TextField idTF;

	    @FXML
	    void enterApp(ActionEvent event) throws Exception{

	    	PersonalData.addPersonalID();
	        id=idTF.getText();
	    	if(PersonalData.searchID(id)==true) {
	    		try {
	    	showMenu(id);
	    
	    	Node source = (Node) event.getSource();     
    		Stage old = (Stage) source.getScene().getWindow();    
    		old.close(); 
	    		}catch(Exception ex) {
	    			ex.printStackTrace();
	    	} 
	    	}else {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setHeaderText(null);
	            alert.setTitle("ERROR");
	            alert.setContentText("THE USER ISN'T REGISTERED, YOU ARE A THIEF");
	            alert.showAndWait();
	    	
	    	}
}
	    public void showMenu(String id) throws Exception{
    		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MenuWindow.fxml"));		
			loader.setController(new MenuController(id));
			Parent parent = (Parent) loader.load();
			
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			
			stage.show();
    	}
}
