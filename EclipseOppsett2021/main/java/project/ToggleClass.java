package project;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class ToggleClass {

	private ToggleGroup group = new ToggleGroup();
	private boolean isToogleSelected = false;
	private String toogleSelected = "";
	private RadioButton smallBoard,mediumBoard,largeBoard;
	
	public ToggleClass(RadioButton smallBoard, RadioButton mediumBoard,RadioButton largeBoard) {
		this.smallBoard=smallBoard;
		this.mediumBoard=mediumBoard;
		this.largeBoard=largeBoard;
		handleToogle();
	}
	
	
	public boolean toggleIsSelected() {
		return isToogleSelected;
	}
	
	public Integer boardSizeSelected() {
		Integer size = null;
		if(toggleIsSelected()) {
			switch(toogleSelected) {
				case "small":
					size = 3;
					break;
				case "medium":
					size = 6;
					break;
				case "large":
					size = 9;
					break;
			}
		}
		return size;
	}
	
	/*
	 * Dette er logikken bak de ulike radioknappene på intromenyen. 
	 */
	private void handleToogle() {
		smallBoard.setToggleGroup(group);
		mediumBoard.setToggleGroup(group);
		largeBoard.setToggleGroup(group);
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()  
        { 
             public void changed(ObservableValue<? extends Toggle> ob,  Toggle o, Toggle n) 
            { 
                RadioButton tempRadioButton = (RadioButton)group.getSelectedToggle(); 
                if (tempRadioButton != null) { 
                	isToogleSelected=true;
                   if(tempRadioButton.getId().equals("smallBoard")) {
                	   toogleSelected = "small";
                   }
                   if(tempRadioButton.getId().equals("mediumBoard")) {
                	   toogleSelected = "medium";
                   }
                   if(tempRadioButton.getId().equals("largeBoard")) {
                	   toogleSelected = "large";
                   }
                } 
            } 
        }); 
	}
	
	private void checkValidToogle(RadioButton smallBoard,RadioButton mediumBoard,RadioButton largeBoard) {
		if(smallBoard == null || mediumBoard == null || largeBoard == null) {
			throw new IllegalArgumentException("Toogle is not found");
		}
	}

}
