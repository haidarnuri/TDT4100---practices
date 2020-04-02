//Del 4 - mobil-appen
//Gjorde denne delvis
public class BikeRentalController{
	
	@FXML Textfield fromInput;
	@FXML Textfield toInput;
	
	
	private int hours = 0;
	
	
	
	@FXML
	public void plus1HourAction(ActionEvent event){
			
	}

	@FXML
	public void minus1HourAction(ActionEvent event){
		setFromTime()
	} 

	@FXML
	public void rentAction(ActionEvent event){
		
	} 	
	private LocalDateTime getFromTime() {
		LocaleDate
    }
	/**
	* Updates the from input field value according to the LocalDateTime argument
	* @param time
	*/
	private void setFromTime(final LocalDateTime time) {
		fromInput.setText(time.toString())
    }
 
/**
 * @return a LocalDataTime object corresponding to the from input field value
 */
	private LocalDateTime getToTime() {
		
	}
/**
 * Updates the from input field value according to the LocalDateTime argument
 * @param time
 */
	private void setToTime(final LocalDateTime time) {
		toInput.setText(time.toString());
    }
	
	
}

	