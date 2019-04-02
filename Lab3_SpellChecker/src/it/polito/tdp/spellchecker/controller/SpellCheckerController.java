package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.SpellCheckerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SpellCheckerController {
	
	private SpellCheckerModel model;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxLanguage;

    @FXML
    private TextArea txtInsert; //dove l'utente inserisce il messaggio

    @FXML
    private Button btnCheck;

    @FXML
    private TextField txtTime; //messaggio del tempo 

    @FXML
    private TextArea txtWrong; //elenco delle parole sbagliate

    @FXML
    private TextField txtMessage; //numero parole sbagliate

    @FXML
    private Button btnClear;

    @FXML
    void clearText(ActionEvent event) {
    	txtInsert.clear();
    	txtMessage.clear();
    	txtWrong.clear();
    	txtTime.clear();
    }

    @FXML
    void spellCheck(ActionEvent event) {
    		long timeStart = System.nanoTime();
    		
    		String lang = boxLanguage.getValue();
    		String text = txtInsert.getText();
    		List<String> notCorrect = model.isCorrect(text, lang);
    		
    		if(notCorrect.isEmpty()) {
    			txtWrong.appendText("Nessun errore!");
    		} else {
    			for(String t : notCorrect){
        			txtWrong.appendText(t + "\n");
        		}
    		}
    		
    		long timeEnd =  System.nanoTime();
        	long time = timeEnd-timeStart;
        	
        	txtTime.appendText("Tempo totale di esecuzione: " + time+".");
    		
    		txtMessage.appendText("Il testo contiene " + notCorrect.size() +" parole sbagliate.");
    }
    
    @FXML
    void initialize() {
        assert boxLanguage != null : "fx:id=\"boxLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtWrong != null : "fx:id=\"txtWrong\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
		boxLanguage.getItems().addAll("English", "Italiano");
    }

	public void setModel(SpellCheckerModel model) {
		// boxLanguage.getValue();
		this.model = model;
	}
}
