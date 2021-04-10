/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary alienDictionary= new AlienDictionary();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtArea"
    private TextArea txtArea; // Value injected by FXMLLoader

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML
    void doClear(ActionEvent event) {

    	txtParola.clear();
    	txtArea.clear();
    	alienDictionary.resetDictionary();
    	
    	
    }

    @FXML
    void doTranslate(ActionEvent event) {
 
    	txtArea.clear();
    	
    	String riga= txtParola.getText().toLowerCase();
    	
    	//Controllo input
    	if (riga==null|| riga.length()==0) {
    		txtArea.setText("Inserire una o due parole.");
    		return;
    	}
    	
    	StringTokenizer st= new StringTokenizer(riga," ");
    	
    	//Controllo su st
    	if (st.hasMoreElements()) {
    		txtArea.setText("Inserire una o due parole");
    	}
    	
    	//estraggo la prima parola
    	String alienWord=st.nextToken();
    	if (st.hasMoreElements()) {
    		String translation= st.nextToken();
    		
    		if (!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
    			txtArea.setText("Inserire solo caratteri alfabetici");
    		    return;
    		}
    		alienDictionary.addWord(alienWord, translation);
    		txtArea.setText("La parola: \"" + alienWord+ "\",con traduzione:\""+translation+"\", è stata inserita nel dizionario");
    	}else {
    		if (!alienWord.matches("[a-zA-Z]*")){
    			txtArea.setText("inserire solo caratteri alfabetici");
    			return;
    		}
    		
    		String translation= alienDictionary.translateWord(alienWord);
    		if (translation!=null) {
    			txtArea.setText(translation);
    		}else {
    			txtArea.setText("La parola cercata non esiste nel dizionario");
    		}
    	}
    	
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
