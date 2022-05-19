package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

//reference
//https://www.youtube.com/watch?v=f7ps5B5xsFU

public class WindowController {
	
	@FXML
	private Button minBtn;
	
	@FXML
	private Button closeBtn;
	
	@FXML
	private Button zoomBtn;
	
	@FXML
	private Pane titleBar;
	
	private double xOffset;
	private double yOffset;
	
	private boolean full=false;
	
	@FXML
	private void handleCloseAction(ActionEvent event) {
		
		Stage stage = (Stage)closeBtn.getScene().getWindow();
		
		stage.close();
	}
	
	@FXML
	private void handledMinAction(ActionEvent event) {
		
		Stage stage=(Stage)minBtn.getScene().getWindow();
		
		stage.setIconified(true);
	}
	
	
	@FXML
    private void handledZoomAction(ActionEvent event) {
    	
		Stage stage=(Stage)zoomBtn.getScene().getWindow();
    	
    	if(full) {
    		stage.setFullScreen(false);
    		stage.setHeight(400);
    		stage.setWidth(600);
    		full=false;
    		stage.centerOnScreen();
    	}else {
    		stage.setFullScreenExitHint(" ");
        	stage.setFullScreen(true);
        	
        	full=true;
    	}


    }
	
	
	
	@FXML
	private void pressed(MouseEvent event) {
		
		xOffset=event.getSceneX();
		yOffset=event.getSceneY();
		
	}
	
	
	@FXML
	private void draged(MouseEvent event) {
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setX(event.getScreenX()-xOffset);
		stage.setY(event.getScreenY()-yOffset);
		
	}
	
    

}
