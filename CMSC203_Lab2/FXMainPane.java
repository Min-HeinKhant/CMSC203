


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	
	private Button btnHello, btnHowdy, btnChinese, btnClear, btnExit;
    private Label lblFeedback;
    private TextField text;
    private HBox hboxButtons, hboxFeedback; 
	//  declare two HBoxes
	
	//student Task #4:
	//  declare an instance of DataManager
    private DataManager dataManager;

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		btnHello = new Button("Hello");
        btnHowdy = new Button("Howdy");
        btnChinese = new Button("Chinese");
        btnClear = new Button("Clear");
        btnExit = new Button("Exit");

        lblFeedback = new Label("Feedback:");
        text = new TextField(); 
        
        hboxButtons = new HBox(); 
        hboxFeedback = new HBox();
        
 
		
		
		//student Task #4:
		//  instantiate the DataManager instance
        dataManager = new DataManager();
		//  set margins and set alignment of the components
        
        hboxFeedback.setSpacing(10); 
        hboxButtons.setSpacing(10); 
        
        hboxFeedback.setAlignment(Pos.CENTER);
        hboxButtons.setAlignment(Pos.CENTER);


		//student Task #3:
		//  add the label and textfield to one of the HBoxes
        
        hboxFeedback.getChildren().addAll(lblFeedback, text);
        hboxButtons.getChildren().addAll(btnHello, btnHowdy, btnChinese, btnClear, btnExit);

		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
        this.getChildren().addAll(hboxFeedback, hboxButtons);

        ButtonHandler buttonHandler = new ButtonHandler();
        btnHello.setOnAction(buttonHandler);
        btnHowdy.setOnAction(buttonHandler);
        btnChinese.setOnAction(buttonHandler);
        btnClear.setOnAction(buttonHandler);
        btnExit.setOnAction(buttonHandler);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            if (event.getSource() == btnHello) {
                text.setText(dataManager.getHello());
            } else if (event.getSource() == btnHowdy) {
                text.setText(dataManager.getHowdy());
            } else if (event.getSource() == btnChinese) {
                text.setText(dataManager.getChinese());
            } else if (event.getSource() == btnClear) {
                text.clear();
            } else if (event.getSource() == btnExit) {
                Platform.exit();
            }

	
}
	}
	
}
	
