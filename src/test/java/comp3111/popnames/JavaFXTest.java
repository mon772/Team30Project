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
	public void testReporting2Empty() {	
		clickOn("#tabReport2");
//		clickOn("#t2Year1");
//		write("2000");
//		clickOn("#t2Year2");
//		write("2010");
//		clickOn("#t1Pop");
//		write("3");
//		clickOn("#t1Gender");
//		write("F");
		clickOn("#t2Summary");
		clickOn("#t2DataTable");
		clickOn("#t2BarChartCheck");
		clickOn("#t2PieChartCheck");
		
		clickOn("#t2GenerateResults");
		//sleep(1000);
		t = (TextArea)s.lookup("#textAreaConsole");
		String s1 = t.getText();
		

//		sleep(1000);
		clickOn("#tabReport2");
		
		
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
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
	
	@Test
	public void testReporting1True() {	
		clickOn("#tabReport1");
		clickOn("#T1TextFieldYear");
		write("2000");
		clickOn("#T1TextFieldtopN");
		write("5");
		clickOn("#T1_displaySummary");
		clickOn("#T1_displayDataTable");
		clickOn("#T1_displayBarChart");
		clickOn("#T1_displayPieChart");
		clickOn("#T1ButtonComputeResults");
		t = (TextArea)s.lookup("#t1textAreaSummaryMale");
		String s1 = t.getText();
		clickOn("#T1ButtonComputeResults");
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testReporting1False() {	
		clickOn("#tabReport1");
		clickOn("#T1TextFieldYear");
		write("2000");
		clickOn("#T1TextFieldtopN");
		write("5");
		clickOn("#T1ButtonComputeResults");
		//sleep(1000);
		t = (TextArea)s.lookup("#t1textAreaSummaryMale");
		String s1 = t.getText();
		clickOn("#T1ButtonComputeResults");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testReporting1Empty() {	
		clickOn("#tabReport1");
		clickOn("#T1TextFieldYear");
		write("");
		clickOn("#T1TextFieldtopN");
		write("");
		clickOn("#T1ButtonComputeResults");
		//sleep(1000);
		t = (TextArea)s.lookup("#t1textAreaSummaryMale");
		String s1 = t.getText();
		clickOn("#T1ButtonComputeResults");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testReporting3True() {	
		clickOn("#tabReport3");
		clickOn("#T3StartYearInput");
		write("2000");
		clickOn("#T3EndYearInput");
		write("2010");
		clickOn("#T3NameInput");
		write("John");
		clickOn("#T3GenderInput");
		write("M");
		clickOn("#T3SummaryCheckBox");
		clickOn("#T3DataTableCheckBox");
		clickOn("#T3BarChartCheckBox");
		clickOn("#T3LineChartCheckBox");
		clickOn("#T3GenerateResults");
		//sleep(1000);
		t = (TextArea)s.lookup("#T3TextAreaConsole");
		String s1 = t.getText();
		clickOn("#T3GenerateResults");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testReporting3TrueEmpty() {	
		clickOn("#tabReport3");
		clickOn("#T3StartYearInput");
		write("");
		clickOn("#T3EndYearInput");
		write("");
		clickOn("#T3NameInput");
		write("");
		clickOn("#T3GenderInput");
		write("");
		clickOn("#T3SummaryCheckBox");
		clickOn("#T3DataTableCheckBox");
		clickOn("#T3BarChartCheckBox");
		clickOn("#T3LineChartCheckBox");
		clickOn("#T3GenerateResults");
		//sleep(1000);
		t = (TextArea)s.lookup("#T3TextAreaConsole");
		String s1 = t.getText();
		clickOn("#T3GenerateResults");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testReporting3TrueEmptyCheckBox() {	
		clickOn("#tabReport3");
		clickOn("#T3StartYearInput");
		write("");
		clickOn("#T3EndYearInput");
		write("");
		clickOn("#T3NameInput");
		write("");
		clickOn("#T3GenderInput");
		write("");
		clickOn("#T3GenerateResults");
		//sleep(1000);
		t = (TextArea)s.lookup("#T3TextAreaConsole");
		String s1 = t.getText();
		clickOn("#T3GenerateResults");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testReporting3False() {	
		clickOn("#tabReport3");
		clickOn("#T3StartYearInput");
		write("2000");
		clickOn("#T3EndYearInput");
		write("2010");
		clickOn("#T3NameInput");
		write("John");
		clickOn("#T3GenderInput");
		write("M");
		clickOn("#T3SummaryCheckBox");
		clickOn("#T3DataTableCheckBox");
		clickOn("#T3BarChartCheckBox");
		clickOn("#T3LineChartCheckBox");
		clickOn("#T3GenerateResults");
		sleep(1000);
		t = (TextArea)s.lookup("#T3TextAreaConsole");
		String s1 = t.getText();
		clickOn("#T3GenderInput");
		write("F");
		clickOn("#T3GenerateResults");
		sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testApplication3T6X1True() {	
		clickOn("#tabApp3");
		clickOn("#T6iNameInput");
		write("John");
		clickOn("#T6iYOBInput");
		write("2001");
		clickOn("#T6iGenderInput");
		write("M");
		clickOn("#T6iPreferenceInput");
		write("Younger");
		clickOn("#T6iNameMateInput");
		write("Mary");
		clickOn("#T6iGenderMateInput");
		write("F");
		clickOn("#T6VariabilityInput");
		write("5");
		clickOn("#T6X1");
		//sleep(1000);
		t = (TextArea)s.lookup("#T6TextAreaConsole");
		String s1 = t.getText();
		clickOn("#T6X1");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testApplication3T6X1False() {	
		clickOn("#tabApp3");
		clickOn("#T6iNameInput");
		write("John");
		clickOn("#T6iYOBInput");
		write("2001");
		clickOn("#T6iGenderInput");
		write("M");
		clickOn("#T6iPreferenceInput");
		write("Younger");
		clickOn("#T6iNameMateInput");
		write("Mary");
		clickOn("#T6iGenderMateInput");
		write("F");
		clickOn("#T6VariabilityInput");
		write("5");
		clickOn("#T6X1");
		sleep(1000);
		t = (TextArea)s.lookup("#T6TextAreaConsole");
		clickOn("#T6iNameMateInput");
		write("Elizabeth");
		String s1 = "";
		s1 = t.getText();
		clickOn("#T6X1");
		sleep(1000);
		String s2 = "";
		s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testApplication3T6X2True() {	
		clickOn("#tabApp3");
		clickOn("#T6iNameInput");
		write("John");
		clickOn("#T6iYOBInput");
		write("2001");
		clickOn("#T6iGenderInput");
		write("M");
		clickOn("#T6iPreferenceInput");
		write("Younger");
		clickOn("#T6iNameMateInput");
		write("Mary");
		clickOn("#T6iGenderMateInput");
		write("F");
		clickOn("#T6VariabilityInput");
		write("5");
		clickOn("#T6X2");
		sleep(1000);
		t = (TextArea)s.lookup("#T6TextAreaConsole");
		String s1 = t.getText();
		clickOn("#T6X2");
		sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testApplication3T6X2True1() {	
		clickOn("#tabApp3");
		clickOn("#T6iNameInput");
		write("5");
		clickOn("#T6iYOBInput");
		write("a");
		clickOn("#T6iGenderInput");
		write("sdfljk");
		clickOn("#T6iPreferenceInput");
		write("young");
		clickOn("#T6iNameMateInput");
		write("5");
		clickOn("#T6iGenderMateInput");
		write("1");
		clickOn("#T6VariabilityInput");
		write("0");
		clickOn("#T6X2");
		//sleep(1000);
		t = (TextArea)s.lookup("#T6TextAreaConsole");
		String s1 = t.getText();
		clickOn("#T6X2");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	@Test
	public void testApplication3T6X2TrueEmpty() {	
		clickOn("#tabApp3");
		clickOn("#T6iNameInput");
		write("");
		clickOn("#T6iYOBInput");
		write("");
		clickOn("#T6iGenderInput");
		write("");
		clickOn("#T6iPreferenceInput");
		write("");
		clickOn("#T6iNameMateInput");
		write("");
		clickOn("#T6iGenderMateInput");
		write("");
		clickOn("#T6VariabilityInput");
		write("");
		clickOn("#T6X2");
		//sleep(1000);
		t = (TextArea)s.lookup("#T6TextAreaConsole");
		String s1 = t.getText();
		clickOn("#T6X2");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	
	
	@Test
	public void testApplication3T6X2False() {	
		clickOn("#tabApp3");
		clickOn("#T6iNameInput");
		write("John");
		clickOn("#T6iYOBInput");
		write("2001");
		clickOn("#T6iGenderInput");
		write("M");
		clickOn("#T6iPreferenceInput");
		write("Younger");
		clickOn("#T6iNameMateInput");
		write("Mary");
		clickOn("#T6iGenderMateInput");
		write("F");
		clickOn("#T6VariabilityInput");
		write("5");
		clickOn("#T6X2");
		//sleep(1000);
		t = (TextArea)s.lookup("#T6TextAreaConsole");
		clickOn("#T6iNameMateInput");
		write("Elizabeth");
		String s1 = "";
		s1 = t.getText();
		clickOn("#T6X2");
		//sleep(1000);
		String s2 = "";
		s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
}
