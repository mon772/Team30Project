package comp3111.popnames;

import static org.junit.Assert.*;
import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class JavaFXTest extends ApplicationTest {

	private Scene s;
	private TextArea t;
	
	@Override
	public void start(Stage stage) throws Exception {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));
   		VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
   		stage.setScene(scene);
   		stage.setTitle("Popular Names");
   		stage.show();
   		s = scene;
		t = (TextArea)s.lookup("#textAreaConsole");
	}
    
	@Test
	public void testButtonRankTrue() {	
		//clickOn("#tabTaskZero");
		clickOn("#buttonRankM");
		//sleep(1000);
		String s1 = t.getText();
		clickOn("#buttonRankM");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	
	@Test
	public void testButtonRankFalse() {	
		//clickOn("#tabTaskZero");
		clickOn("#buttonRankM");
		//sleep(1000);
		String s1 = t.getText();
		clickOn("#buttonRankF");
		//sleep(1000);
		String s2 = t.getText();
		assertFalse(s1.equals(s2));
	}
	
	
	@Test
	public void testTextAreaConsole() {	
		t.setText("David");
		String s = t.getText();
		assertTrue(s.equals("David"));
	}
	
	@Test
	public void testTop5True() {	
		//clickOn("#tabTaskZero");
		clickOn("#buttonTopM");
		//sleep(1000);
		String s1 = t.getText();
		clickOn("#buttonTopM");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testTop5False() {	
		//clickOn("#tabTaskZero");
		clickOn("#buttonTopM");
		//sleep(1000);
		String s1 = t.getText();
		clickOn("#buttonTopF");
		//sleep(1000);
		String s2 = t.getText();
		assertFalse(s1.equals(s2));
	}
	
	@Test
	public void testReporting2True() {	
		clickOn("#tabReport2");
		clickOn("#t2Year1");
		write("2000");
		clickOn("#t2Year2");
		write("2010");
		clickOn("#t1Pop");
		write("8");
		clickOn("#t1Gender");
		write("M");
		clickOn("#t2Summary");
		clickOn("#t2DataTable");
		clickOn("#t2BarChartCheck");
		clickOn("#t2PieChartCheck");
		clickOn("#t2GenerateResults");
		//sleep(1000);
		t = (TextArea)s.lookup("#textAreaSummary");
		String s1 = t.getText();
		clickOn("#t2GenerateResults");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testReporting2False() {	
		clickOn("#tabReport2");
		clickOn("#t2Year1");
		write("Q");
		clickOn("#t2Year2");
		write("ABC");
		clickOn("#t1Pop");
		write("Q");
		clickOn("#t1Gender");
		write("5");
		clickOn("#t2GenerateResults");
		//sleep(1000);
		t = (TextArea)s.lookup("#textAreaConsole");
		String s1 = t.getText();
		clickOn("#t2GenerateResults");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
		
}
