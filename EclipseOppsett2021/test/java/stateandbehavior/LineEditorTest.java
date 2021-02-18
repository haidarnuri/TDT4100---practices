package stateandbehavior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LineEditorTest {
	private LineEditor lineEditor;
	
	private void checkEditorContent(String s) {
		Assertions.assertEquals(s, lineEditor.toString());
		int pos = s.indexOf('|');
		Assertions.assertEquals(s.substring(0, pos) + s.substring(pos + 1), lineEditor.getText());
		Assertions.assertEquals(pos, lineEditor.getInsertionIndex());
	}
	
	@BeforeEach
	public void setup() {
		lineEditor = new LineEditor();
	}
	
	@Test
	public void testContstructor() {
		checkEditorContent("|");
	}
	
	@Test
	public void testSetters() {
		lineEditor.setText("Hello World!");
		checkEditorContent("|Hello World!");
		lineEditor.setInsertionIndex(5);
		checkEditorContent("Hello| World!");
	}
	
	@Test
	public void testInsertStringAtEnd() {
		lineEditor.insertString("");
		checkEditorContent("|");
		lineEditor.insertString("Java");
		checkEditorContent("Java|");
		lineEditor.insertString(" er gøy!");
		checkEditorContent("Java er gøy!|");
	}
	
	@Test
	public void testInsertStringMiddle() {
		lineEditor.setText("Javagøy!");
		lineEditor.setInsertionIndex(4);
		lineEditor.insertString(" er ");
		checkEditorContent("Java er |gøy!");
	}
	
	@Test
	public void testInsertStringAtBeginning() {
		lineEditor.setText("er gøy!");
		lineEditor.setInsertionIndex(0);
		lineEditor.insertString("Java ");
		checkEditorContent("Java |er gøy!");
	}
	
	@Test
	public void testLeft() {
		lineEditor.left();
		checkEditorContent("|");
		lineEditor.setText("J");
		lineEditor.setInsertionIndex(1);
		checkEditorContent("J|");
		lineEditor.left();
		checkEditorContent("|J");
	}
	
	@Test
	public void testRight() {
		lineEditor.right();
		checkEditorContent("|");
		lineEditor.setText("J");
		lineEditor.setInsertionIndex(0);
		checkEditorContent("|J");
		lineEditor.right();
		checkEditorContent("J|");
	}
	
	@Test
	public void testDeleteLeft() {
		lineEditor.deleteLeft();
		checkEditorContent("|");
		lineEditor.insertString("J");
		lineEditor.deleteLeft();
		checkEditorContent("|");
		lineEditor.insertString("Java");
		lineEditor.setInsertionIndex(2);
		checkEditorContent("Ja|va");
		lineEditor.deleteLeft();
		checkEditorContent("J|va");
	}
	
	@Test
	public void testDeleteRight() {
		lineEditor.deleteRight();
		checkEditorContent("|");
		lineEditor.insertString("J");
		lineEditor.setInsertionIndex(0);
		lineEditor.deleteRight();
		checkEditorContent("|");
		lineEditor.insertString("Java");
		lineEditor.setInsertionIndex(2);
		checkEditorContent("Ja|va");
		lineEditor.deleteRight();
		checkEditorContent("Ja|a");
	}
}