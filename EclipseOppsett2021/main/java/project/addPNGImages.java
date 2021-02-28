package project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class addPNGImages {
	 
	
	
	
	public ImageView addBombPNG(String bombPNG) {
		ImageView bombView;
		Image img = new Image(getClass().getResourceAsStream(bombPNG));
	    bombView = new ImageView(img);
	    bombView.setFitHeight(30);
	    bombView.setFitWidth(30);
	    bombView.setPreserveRatio(true);
	    return bombView;
	}
	
	public ImageView addSmileyPNG(String smileyPNG) {
		ImageView smileyView;
		Image img = new Image(getClass().getResourceAsStream(smileyPNG));
	    smileyView = new ImageView(img);
	    smileyView.setFitHeight(30);
	    smileyView.setFitWidth(30);
	    smileyView.setPreserveRatio(true);
		//smileyButton.setGraphic(smileyView);
	    return smileyView;
	}
}
