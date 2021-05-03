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
    /*
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
  public void testT5X1True() {	
		clickOn("#tabApp2");
		clickOn("#t5Name");
		write("Dave");
		clickOn("#t5Gender");
		write("M");
		clickOn("#t5YOB");
		write("2000");
		clickOn("#t5GenderMate");
		write("F");
		clickOn("#t5Preference");
		write("Younger");
		clickOn("#t5T5X1");
		sleep(12000);
		clickOn("#a2ViewResults");
		clickOn("#a2ResultsNext");
		
		t = (TextArea)s.lookup("#textAreaSummary2");
		String s1 = t.getText();
		clickOn("#t5T5X1");
		sleep(12000);
		clickOn("#a2ViewResults");
		clickOn("#a2ResultsNext");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testT5X2True() {	
		clickOn("#tabApp2");
		clickOn("#t5Name");
		write("Dave");
		clickOn("#t5Gender");
		write("M");
		clickOn("#t5YOB");
		write("2000");
		clickOn("#t5GenderMate");
		write("F");
		clickOn("#t5Preference");
		write("Younger");
		clickOn("#t5T5X2");
		clickOn("#a2EnterAdditionalData");
		clickOn("#t5RandInt1");
		write("4");
		clickOn("#t5RandInt2");
		write("14");
		clickOn("#a2ComputeResultsTX2");
		clickOn("#a2ResultsNextX2");
		
		
		t = (TextArea)s.lookup("#a2TextAreaConsoleX2");
		String s1 = t.getText();
		clickOn("#t5T5X2");
		clickOn("#a2EnterAdditionalData");
//		clickOn("#t5RandInt1");
//		write("4");
//		clickOn("#t5RandInt2");
//		write("14");
		clickOn("#a2ComputeResultsTX2");
		clickOn("#a2ResultsNextX2");
		
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	
	@Test
	public void t4X2GenerateNamesTrue() {
		clickOn("#tabApp1");
		clickOn("#T4textFieldDadsName");
		write("Andrew");
		clickOn("#T4textFieldMomsName");
		write("Sarah");
		clickOn("#T4textFieldDadsYOB");
		write("2000");
		clickOn("#T4textFieldMomsYOB");
		write("2000");
		clickOn("#t4ButtonT4X2");
		clickOn("#t4X2MaleButton");
		clickOn("#t4X2ExtraYearsAnswer");
		write("10");
		t = (TextArea)s.lookup("#textAreaConsole1");
		//clickOn("t4X2UniquenessScaleAnswer");
		String s1 = t.getText();
		clickOn("#t4X2GetNamePrediction");
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
		
	}
	@Test
	public void t4X2GenerateNamesFalse() {
		clickOn("#tabApp1");
		clickOn("#T4textFieldDadsName");
		write("Andrew");
		clickOn("#T4textFieldMomsName");
		write("Sarah");
		clickOn("#T4textFieldDadsYOB");
		write("2000");
		clickOn("#T4textFieldMomsYOB");
		write("2000");
		clickOn("#t4ButtonT4X2");
		clickOn("#t4X2FemleButton");
		clickOn("#t4X2ExtraYearsAnswer");
		t = (TextArea)s.lookup("#textAreaConsole1");
		String s1 = t.getText();
		write("10");
		//clickOn("t4X2UniquenessScaleAnswer");
		clickOn("#t4X2GetNamePrediction");
		String s2 = "  ";
		assertFalse(s1.equals(s2));
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
	*/
	
	
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
	public void t4X2GenerateNamesTrue() {
		clickOn("#tabApp1");
		clickOn("#T4textFieldDadsName");
		write("Andrew");
		clickOn("#T4textFieldMomsName");
		write("Sarah");
		clickOn("#T4textFieldDadsYOB");
		write("2000");
		clickOn("#T4textFieldMomsYOB");
		write("2000");
		clickOn("#t4ButtonT4X2");
		clickOn("#t4X2MaleButton");
		clickOn("#t4X2ExtraYearsAnswer");
		write("10");
		t = (TextArea)s.lookup("#textAreaConsole1");
		//clickOn("t4X2UniquenessScaleAnswer");
		String s1 = t.getText();
		clickOn("#t4X2GetNamePrediction");
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
	  public void testT5X1True() {	
			clickOn("#tabApp2");
			clickOn("#t5Name");
			write("Dave");
			clickOn("#t5Gender");
			write("M");
			clickOn("#t5YOB");
			write("2000");
			clickOn("#t5GenderMate");
			write("F");
			clickOn("#t5Preference");
			write("Younger");
			clickOn("#t5T5X1");
			sleep(12000);
			clickOn("#a2ViewResults");
			clickOn("#a2ResultsNext");
			
			t = (TextArea)s.lookup("#textAreaSummary2");
			String s1 = t.getText();
			clickOn("#t5T5X1");
			sleep(12000);
			clickOn("#a2ViewResults");
			clickOn("#a2ResultsNext");
			//sleep(1000);
			String s2 = t.getText();
			assertTrue(s1.equals(s2));
		}
	
	@Test
	public void testT5X2True() {	
		clickOn("#tabApp2");
		clickOn("#t5Name");
		write("Dave");
		clickOn("#t5Gender");
		write("M");
		clickOn("#t5YOB");
		write("2000");
		clickOn("#t5GenderMate");
		write("F");
		clickOn("#t5Preference");
		write("Younger");
		clickOn("#t5T5X2");
		clickOn("#a2EnterAdditionalData");
		clickOn("#t5RandInt1");
		write("4");
		clickOn("#t5RandInt2");
		write("14");
		clickOn("#a2ComputeResultsTX2");
		clickOn("#a2ResultsNextX2");
		
		
		t = (TextArea)s.lookup("#a2TextAreaConsoleX2");
		String s1 = t.getText();
		clickOn("#t5T5X2");
		clickOn("#a2EnterAdditionalData");
//		clickOn("#t5RandInt1");
//		write("4");
//		clickOn("#t5RandInt2");
//		write("14");
		clickOn("#a2ComputeResultsTX2");
		clickOn("#a2ResultsNextX2");
		
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void testT5X2True2() {	
		clickOn("#tabApp2");
		clickOn("#t5Name");
		write("Sarah");
		clickOn("#t5Gender");
		write("F");
		clickOn("#t5YOB");
		write("2017");
		clickOn("#t5GenderMate");
		write("M");
		clickOn("#t5Preference");
		write("Older");
		clickOn("#t5T5X2");
		clickOn("#a2EnterAdditionalData");
		clickOn("#t5RandInt1");
		write("8");
		clickOn("#t5RandInt2");
		write("12");
		clickOn("#a2ComputeResultsTX2");
		clickOn("#a2ResultsNextX2");
		
		
		t = (TextArea)s.lookup("#a2TextAreaConsoleX2");
		String s1 = t.getText();
		clickOn("#t5T5X2");
		clickOn("#a2EnterAdditionalData");
//		clickOn("#t5RandInt1");
//		write("4");
//		clickOn("#t5RandInt2");
//		write("14");
		clickOn("#a2ComputeResultsTX2");
		clickOn("#a2ResultsNextX2");
		
		String s2 = t.getText();
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
	public void t4X1GenerateNamesTrue() {
		clickOn("#tabApp1");
		clickOn("#T4textFieldDadsName");
		write("Andrew");
		clickOn("#T4textFieldMomsName");
		write("Sarah");
		clickOn("#T4textFieldDadsYOB");
		write("2000");
		clickOn("#T4textFieldMomsYOB");
		write("2000");
		clickOn("#t4ButtonT4X1");
		clickOn("#t4X1MaleButton");
		sleep(2000);
		t = (TextArea)s.lookup("#textAreaConsole1");
		String s1 = t.getText();
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
		
	}
	@Test
	public void t4X1GenerateNamesFalse() {
		clickOn("#tabApp1");
		clickOn("#T4textFieldDadsName");
		write("Andrew");
		clickOn("#T4textFieldMomsName");
		write("Sarah");
		clickOn("#T4textFieldDadsYOB");
		write("2000");
		clickOn("#T4textFieldMomsYOB");
		write("2000");
		clickOn("#t4ButtonT4X1");
		clickOn("#t4X1FemleButton");
		sleep(2000);
		t = (TextArea)s.lookup("#textAreaConsole1");
		String s1 = t.getText();
		String s2 = "  ";
		assertFalse(s1.equals(s2));
		
	}
	
	@Test
	public void t4X2GenerateNamesTrue2() {
		clickOn("#tabApp1");
		clickOn("#T4textFieldDadsName");
		write("2000");
		clickOn("#T4textFieldMomsName");
		write("2000");
		clickOn("#T4textFieldDadsYOB");
		write("Andrew");
		clickOn("#T4textFieldMomsYOB");
		write("Sarah");
		clickOn("#t4ButtonT4X2");
		String s1 = t.getText();
		clickOn("#t4X2GetNamePrediction");
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
		
	}
/*
	@Test
	public void testSummaryTrue() {	
		//clickOn("#tabTaskZero");
		clickOn("#buttonSummary");
		//sleep(1000);
		String s1 = t.getText();
		clickOn("#buttonSummary");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	*/
	@Test
	public void testTopButtonFalse() {	
		clickOn("#tabTaskZero");
		clickOn("#buttonSummary");
		clickOn("#buttonTopM");
		clickOn("#buttonRankM");
		//sleep(1000);
		String s1 = t.getText();
		clickOn("#buttonTopF");
		clickOn("#buttonRankF");
		//sleep(1000);
		String s2 = t.getText();
		assertFalse(s1.equals(s2));
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
}
