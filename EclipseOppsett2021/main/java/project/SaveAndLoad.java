package project;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javafx.scene.control.Button;

public class SaveAndLoad implements ReadAndWriteFile{

	HashMap<Integer, Button> integerButtonIdMap = new HashMap<>();
	public SaveAndLoad(HashMap<Integer, Button> integerButtonIdMap) {
		this.integerButtonIdMap=integerButtonIdMap;
	}

	@Override
	public void saveFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Character> loadFile() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
