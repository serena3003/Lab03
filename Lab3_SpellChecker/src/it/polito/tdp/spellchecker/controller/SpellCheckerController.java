package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.SpellCheckerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SpellCheckerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxLanguage;

    @FXML
    private TextArea txtInsert;

    @FXML
    private Button btnCheck;

    @FXML
    private TextField txtTime;

    @FXML
    private TextArea txtWrong;

    @FXML
    private TextField txtMessage;

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
    	String text = txtInsert.getText();

    }

    @FXML
    void selectLanguage(ActionEvent event) {
    	String lang = boxLanguage.getValue();
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

	public void setmodel(SpellCheckerModel model) {
		
	}
}
