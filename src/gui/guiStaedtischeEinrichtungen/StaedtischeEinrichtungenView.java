package gui.guiStaedtischeEinrichtungen;

import business.BuergeraemterModel;
import business.Buergeramt;
import gui.guiBuergeraemter.BuergeraemterControl;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class StaedtischeEinrichtungenView {
	
	// Hier ergaenzen
    private StaedtischeEinrichtungenControl control;
    private BuergeraemterModel model;
	
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeBuergeraemter     
 		= new Label("Anzeige Bürgerämter");
    	private TextArea txtAnzeigeBuergeraemter  = new TextArea();
    	private Button btnAnzeigeBuergeraemter = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public StaedtischeEinrichtungenView(StaedtischeEinrichtungenControl control, Stage primaryStage, BuergeraemterModel model){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von städtischen "+"Einrichtungen");
    		primaryStage.show();
    		// Hier ergaenzen
    		
    		this.model = model;
    		this.control = control;
    		
			this.initKomponenten();
			this.initListener();
    	}

    	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeBuergeraemter.setLayoutX(310);
    		lblAnzeigeBuergeraemter.setLayoutY(40);
    		lblAnzeigeBuergeraemter.setFont(font);
    		lblAnzeigeBuergeraemter.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeBuergeraemter);    
        	


// Textbereich	
        	txtAnzeigeBuergeraemter.setEditable(false);
     		txtAnzeigeBuergeraemter.setLayoutX(310);
    		txtAnzeigeBuergeraemter.setLayoutY(90);
     		txtAnzeigeBuergeraemter.setPrefWidth(220);
    		txtAnzeigeBuergeraemter.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeBuergeraemter);        	
        	// Button
          	btnAnzeigeBuergeraemter.setLayoutX(310);
        	btnAnzeigeBuergeraemter.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeBuergeraemter); 
   }
   
   private void initListener() {
	    btnAnzeigeBuergeraemter.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeBuergeraemterAn();
	        	} 
   	    });
    }
   
    void zeigeBuergeraemterAn(){
    		/*if(model.getBuergeramt() != null){
    			txtAnzeigeBuergeraemter.setText(
    					model.getBuergeramt()
 				.gibBuergeramtZurueck(' '));
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Bürgeramt aufgenommen!");
    		}*/
    	if(model.getBuergeramt().size() > 0){
			StringBuffer text = new StringBuffer();
			for(Buergeramt bg : model.getBuergeramt()) {
				text.append(bg.gibBuergeramtZurueck(' ')+"\n");			
			}
			this.txtAnzeigeBuergeraemter.setText(text.toString());
		}
		else{
			zeigeInformationsfensterAn( 
				"Bisher wurde kein Baergeramt aufgenommen!");
		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}