/**
 * Building on the sample skeleton for 'ui.fxml' COntroller Class generated by SceneBuilder 
 */
package comp3111.popnames;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.Scene;


public class Controller {

    @FXML
    private Tab tabTaskZero;

    @FXML
    private TextField textfieldNameF;

    @FXML
    private TextField textfieldYear;

    @FXML
    private Button buttonRankM;

    @FXML
    private TextField textfieldNameM;

    @FXML
    private Button buttonRankF;

    @FXML
    private Button buttonTopM;

    @FXML
    private Button buttonTopF;

    @FXML
    private Button buttonSummary;

    @FXML
    private Tab tabReport1;

    @FXML
    private TextField T1TextFieldYear;

    @FXML
    private TextField T1TextFieldtopN;

    @FXML
    private CheckBox T1_displaySummary;

    @FXML
    private CheckBox T1_displayDataTable;

    @FXML
    private CheckBox T1_displayBarChart;

    @FXML
    private CheckBox T1_displayPieChart;

    @FXML
    private Button T1ButtonComputeResults;

    @FXML
    private Tab t1ConsoleTab;

    @FXML
    private TextArea textAreaConsole1;

    @FXML
    private Tab t1SummaryTab;

    @FXML
    private TextArea t1textAreaSummaryMale;

    @FXML
    private TextArea t1textAreaSummaryFemale;

    @FXML
    private Tab t1DataTableTab;

    @FXML
    private TableView<T1Names> t1ReportTableMale;

    @FXML
    private TableColumn<T1Names, Integer> t1RankMale;

    @FXML
    private TableColumn<T1Names, String> t1NameMale;

    @FXML
    private TableColumn<T1Names, Integer> t1OccurencesMale;

    @FXML
    private TableColumn<T1Names, String> t1PercentageMale;

    @FXML
    private Label t2TotFreq1;

    @FXML
    private Label t2TotOcc1;

    @FXML
    private Label t2TotPerc1;

    @FXML
    private TableView<T1Names> t1ReportTableFemale;

    @FXML
    private TableColumn<T1Names, Integer> t1RankFemale;

    @FXML
    private TableColumn<T1Names, String> t1NameFemale;

    @FXML
    private TableColumn<T1Names, Integer> t1OccurancesFemale;

    @FXML
    private TableColumn<T1Names, String> t1PercentageFemale;

    @FXML
    private Tab t1BarChartTab;

    @FXML
    private BarChart<String, Integer> t1BarChartMale;

    @FXML
    private BarChart<String, Integer> t1BarChartFemale;

    @FXML
    private Tab t1PieChartTab;

    @FXML
    private PieChart t1PieChartMale;

    @FXML
    private PieChart t1PieChartFemale;

    @FXML
    private Tab tabReport2;

    @FXML
    private CheckBox t2Summary;

    @FXML
    private CheckBox t2DataTable;

    @FXML
    private CheckBox t2BarChartCheck;

    @FXML
    private CheckBox t2PieChartCheck;

    @FXML
    private TextField t2Year1;

    @FXML
    private TextField t2Year2;

    @FXML
    private TextField t1Pop;

    @FXML
    private TextField t1Gender;

    @FXML
    private Button t2GenerateResults;

    @FXML
    private Tab t2ConsoleTab;

    @FXML
    private TextArea textAreaConsole;

    @FXML
    private Tab t2SummaryTab;

    @FXML
    private TextArea textAreaSummary;

    @FXML
    private Tab t2DataTableTab;

    @FXML
    private TableView<T2Names> t2ReportTable;

    @FXML
    private TableColumn<T2Names, String> t2Name;

    @FXML
    private TableColumn<T2Names, Integer> t2Frequency;

    @FXML
    private TableColumn<T2Names, Integer> t2Occurances;

    @FXML
    private TableColumn<T2Names, String> t2Percentage;

    @FXML
    private Label t2TotFreq;

    @FXML
    private Label t2TotOcc;

    @FXML
    private Label t2TotPerc;

    @FXML
    private Tab t2BarChartTab;

    @FXML
    private BarChart<String, Integer> t2BarChart;

    @FXML
    private Tab t2PieChartTab;

    @FXML
    private PieChart t2PieChart;

    @FXML
    private Tab tabReport3;

    @FXML
    private Tab tabApp1;

    @FXML
    private TextField T4textFieldDadsName;

    @FXML
    private TextField T4textFieldDadsYOB;

    @FXML
    private TextField T4textFieldMomsName;

    @FXML
    private TextField T4textFieldMomsYOB;

    @FXML
    private Button t4ButtonT4X1;

    @FXML
    private Button t4ButtonT4X2;

    @FXML
    private Tab tabApp2;

    @FXML
    private TextField t5Name;

    @FXML
    private TextField t5Gender;

    @FXML
    private TextField t5YOB;

    @FXML
    private TextField t5GenderMate;

    @FXML
    private TextField t5Preference;

    @FXML
    private Button t5T5X1;

    @FXML
    private Button t5T5X2;

    @FXML
    private Tab tabApp3;
    /**
     *  Task Zero
     *  To be triggered by the "Summary" button on the Task Zero Tab 
     *  
     */
    @FXML
    void doSummary() {
    	int year = Integer.parseInt(textfieldYear.getText());
    	String oReport = AnalyzeNames.getSummary(year);
    	textAreaConsole.setText(oReport);
    }
    /**
     *  Task Zero
     *  To be triggered by the "Rank (female)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doRankF() {
    	String oReport = "";
    	String iNameF = textfieldNameF.getText();
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	int oRank = AnalyzeNames.getRank(iYear, iNameF, "F");
    	if (oRank == -1)
    		oReport = String.format("The name %s (female) has not been ranked in the year %d.\n", iNameF, iYear);
    	else
    		oReport = String.format("Rank of %s (female) in year %d is #%d.\n", iNameF, iYear, oRank);
    	textAreaConsole.setText(oReport);
    }

  
    /**
     *  Task Zero
     *  To be triggered by the "Rank (male)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doRankM() {
    	String oReport = "";
    	String iNameM = textfieldNameM.getText();
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	int oRank = AnalyzeNames.getRank(iYear, iNameM, "M");
    	if (oRank == -1)
    		oReport = String.format("The name %s (male) has not been ranked in the year %d.\n", iNameM, iYear);
    	else
    		oReport = String.format("Rank of %s (male) in year %d is #%d.\n", iNameM, iYear, oRank);
    	textAreaConsole.setText(oReport);
    }


    /**
     *  Task Zero
     *  To be triggered by the "Top 5 (female)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doTopF() {
    	String oReport = "";
    	final int topN = 5;
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	oReport = String.format("Top %d most popular names (female) in the year %d:\n", topN, iYear);
    	for (int i=1; i<=topN; i++)
    		oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "F"));
    	textAreaConsole.setText(oReport);
    }


    /**
     *  Task Zero
     *  To be triggered by the "Top 5 (male)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doTopM() {
    	String oReport = "";
    	final int topN = 5;
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	oReport = String.format("Top %d most popular names (male) in the year %d:\n", topN, iYear);
    	for (int i=1; i<=topN; i++)
    		oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "M"));
    	textAreaConsole.setText(oReport);
    }
    @FXML
    void t1ComputeResults() {
    	t1ConsoleTab.setStyle("-fx-text-base-color: black;");
    	t1SummaryTab.setDisable(true);
    	t1DataTableTab.setDisable(true);
    	t1BarChartTab.setDisable(true);
    	t1PieChartTab.setDisable(true);
    	t1ReportTableMale.getItems().clear();
    	t1ReportTableFemale.getItems().clear();
    	t1textAreaSummaryMale.setText("");
		t1textAreaSummaryFemale.setText("");
		t1BarChartMale.getData().clear();
		t1BarChartFemale.getData().clear();
		t1PieChartMale.getData().clear();
		t1PieChartFemale.getData().clear();
    	String oReport = "";
    	String year = T1TextFieldYear.getText();
    	String input_avaliable_error = "" ;
    	if(year == "") {
    		input_avaliable_error += "The year is blank! Please enter year \n";
    	}
    	String n = T1TextFieldtopN.getText();
    	if(n == "") {
    		input_avaliable_error += "The top N most popular names to reported is blank! Please enter a value \n";
    	}
    	
    	boolean summary_box = T1_displaySummary.isSelected();
    	boolean dt_box = T1_displayDataTable.isSelected();
    	boolean bar_chart_box = T1_displayBarChart.isSelected();
    	boolean pie_chart_box = T1_displayPieChart.isSelected();
    	boolean boxes_checked = true ;
    	if((summary_box == false)&&(dt_box == false)&&(bar_chart_box == false)&&(pie_chart_box == false)) {
    		input_avaliable_error += ("Please Check or Select at Least One Form of Data Representation and Try Again!");
    		boxes_checked = false ; 
    	}
    	if((year == "")||(n=="")||(boxes_checked==false)) {
    		textAreaConsole1.setText(input_avaliable_error);
    		t1ConsoleTab.setStyle("-fx-text-base-color: red;");
    		return;
    	}
    	String validation_error = "" ; 
    	boolean year_validated = false ;
    	int int_year = 0 ;
    	try {
    		int_year = Integer.parseInt(year);
    		if((int_year >=1880)&&(int_year <= 2019)) {
    			year_validated = true ; 
    		}
    		else {
    			validation_error += "Enter data value in the range for the Year. It too small or too large! \n";
    		}
    		
    	}
    	catch (Exception e) {
    		validation_error += "Enter the Correct Datatype for the Year. Enter a Number! \n";
    	}
    	boolean n_validated = false ;
    	int int_n = 0 ;
    	try {
    		int_n = Integer.parseInt(n);
    		if((int_n >=1)&&(int_n <= 10)) {
    			n_validated = true ; 
    		}
    		else {
    			validation_error += "Enter data value in the range for the N. It too small or too large! \n";
    		}
    		
    	}
    	catch (Exception e) {
    		validation_error += "Enter the Correct Datatype for the N. Enter a Number! \n";
    	}
    	if((!year_validated)||(!n_validated)) {
    		textAreaConsole1.setText(validation_error);
    		t1ConsoleTab.setStyle("-fx-text-base-color: red;");
    		return; 
    	}
    	//oReport = String.format("Year %s\n", year);
    	//oReport += String.format("N %s\n", n);
    	//oReport += String.format("Summary box %b\n", summary_box);
    	//oReport += String.format("Data table %b\n" , dt_box);
    	//oReport += String.format("Bar Chart box %b\n", bar_chart_box);
    	//oReport += String.format("Pie Chart Box %b\n" , pie_chart_box);
    	//oReport += String.format("Lets implement the charts!\n" );
    	//textAreaConsole.setText(oReport);
    	textAreaConsole1.setText("Select the repective Tabs to Check the Results");
    	AnalyzeNames analyze_obj = new AnalyzeNames(); 
    	String []  top_male_names = new String[int_n];
    	String []  top_female_names = new String[int_n];
    	int [] top_male_occurences = new int[int_n];
    	int [] top_female_occurences = new int[int_n];
    	String []  top_male_percentages = new String[int_n];
    	String [] top_female_percentages = new String[int_n];
    	int [] top_male_ranks = new int[int_n];
    	int [] top_female_ranks = new int[int_n];
    	int all_males = 0 ; 
    	int all_females = 0 ;
    	all_males = analyze_obj.getTotalMales(int_year);
    	all_females = analyze_obj.getTotalFemales(int_year);
    	String male_gender = "M";
    	String female_gender = "F";
    	String test_output = "";
    	
    	for (int i=0 ; i<int_n ; i++) {
    		top_male_ranks[i] = i+1;
    		top_female_ranks[i] = i+1 ; 
    		top_male_names[i] = analyze_obj.getName(int_year , i+1 , male_gender);
    		top_female_names[i] = analyze_obj.getName(int_year , i+1 , female_gender);
    		top_male_occurences[i] = analyze_obj.getOccurance(int_year, top_male_names[i], male_gender);
    		System.out.println(top_male_occurences[i]);
    		top_female_occurences[i] = analyze_obj.getOccurance(int_year, top_female_names[i], female_gender);
    		float mp = ((float)top_male_occurences[i]/all_males)*100;
    		float fp = ((float)top_female_occurences[i]/all_females)*100;
    		top_female_percentages[i] = String.format("%.2f%%", fp);
    		top_male_percentages[i] = String.format("%.2f%%", mp);
    	}
    	for(int i= 0 ; i<int_n ; i++) {
    		test_output+= String.format("%d %s %d %s\n",top_male_ranks[i] ,top_male_names[i], top_male_occurences[i] , top_male_percentages[i]);
    	}
    	for(int i= 0 ; i<int_n ; i++) {
    		test_output+= String.format("%d %s %d %s\n",top_female_ranks[i] ,top_female_names[i], top_female_occurences[i] , top_female_percentages[i]);
    	}
    	System.out.println(test_output);
    	t1SummaryTab.setDisable(!summary_box);
    	t1DataTableTab.setDisable(!dt_box);
    	t1BarChartTab.setDisable(!bar_chart_box);
    	t1PieChartTab.setDisable(!pie_chart_box);
    	T1Names []  male_data = new T1Names[int_n];
		T1Names [] female_data = new T1Names[int_n];
		for(int i=0 ; i <int_n ; i++) {
    		male_data[i] = new T1Names(top_male_ranks[i], top_male_names[i] , top_male_occurences[i] , top_male_percentages[i]);
    		female_data[i] = new T1Names(top_female_ranks[i], top_female_names[i] , top_female_occurences[i] , top_female_percentages[i]);
    	}
		int total_top_males = 0 ; 
    	int total_top_females = 0 ;
    	for(int i = 0 ; i<int_n ; i++) {
    		total_top_males += male_data[i].getOccurences();
    		total_top_females += female_data[i].getOccurences();
    	}
    	if(summary_box) {
			String male_result = String.format("%s is the most popular name with the number of occurrences of %d, which represents %s of total male births in %d.", top_male_names[0], top_male_occurences[0] , top_male_percentages[0], int_year);
			String female_result = String.format("%s is the most popular name with the number of occurrences of %d, which represents %s of total male births in %d.", top_female_names[0], top_female_occurences[0] , top_female_percentages[0], int_year);
			t1textAreaSummaryMale.setText(male_result);
			t1textAreaSummaryFemale.setText(female_result);
		}
    	
    	if(dt_box) {
    		
    		t1RankMale.setCellValueFactory(new PropertyValueFactory<T1Names,Integer>("rank"));
	    	t1NameMale.setCellValueFactory(new PropertyValueFactory<T1Names,String>("name"));
	    	t1OccurencesMale.setCellValueFactory(new PropertyValueFactory<T1Names,Integer>("occurences"));
	    	t1PercentageMale.setCellValueFactory(new PropertyValueFactory<T1Names,String>("percentage"));
	    	t1RankFemale.setCellValueFactory(new PropertyValueFactory<T1Names,Integer>("rank"));
	    	t1NameFemale.setCellValueFactory(new PropertyValueFactory<T1Names,String>("name"));
	    	t1OccurancesFemale.setCellValueFactory(new PropertyValueFactory<T1Names,Integer>("occurences"));
	    	t1PercentageFemale.setCellValueFactory(new PropertyValueFactory<T1Names,String>("percentage"));
	    	t1ReportTableMale.setItems(t1getNameData(male_data));
	    	t1ReportTableFemale.setItems(t1getNameData(female_data));
	    	
    	}
    	if(bar_chart_box) {
    		t1BarChartMale.setTitle(String.format("Top %d Names (male) in %d" ,  int_n , int_year));
    		XYChart.Series<String, Integer> set_male = new XYChart.Series<>();
    		set_male.setName("Male Occurences"); 
    		for (T1Names one_name : male_data) {
				if(one_name!=null) {
					set_male.getData().add(new XYChart.Data<>(one_name.getName(), one_name.getOccurences()));
				}
			}
			t1BarChartFemale.setTitle(String.format("Top %d Names (female) in %d" ,  int_n , int_year));
			XYChart.Series<String, Integer> set_female = new XYChart.Series<>();
			set_female.setName("Female Occurences");
			for (T1Names one_name : female_data) {
				if(one_name!=null) {
					set_female.getData().add(new XYChart.Data<>(one_name.getName(), one_name.getOccurences()));
				}
			}
			t1BarChartMale.getData().addAll(set_male);
			t1BarChartFemale.getData().addAll(set_female);
    	}
    	if(pie_chart_box) {
			ObservableList<PieChart.Data> pieChartDataMale= FXCollections.observableArrayList();
			for(T1Names one_name : male_data) {
				if(one_name!=null) {
					pieChartDataMale.add(new PieChart.Data(one_name.getName(), (float)(one_name.getOccurences()*100.0/total_top_males)));
				}
			}
			t1PieChartMale.setData(pieChartDataMale);
			t1PieChartMale.setStartAngle(90);
			ObservableList<PieChart.Data> pieChartDataFemale= FXCollections.observableArrayList();
			for(T1Names one_name : female_data) {
				if(one_name!=null) {
					pieChartDataFemale.add(new PieChart.Data(one_name.getName(), (float)(one_name.getOccurences()*100.0/total_top_females)));
				}
			}
			t1PieChartFemale.setData(pieChartDataFemale);
			t1PieChartFemale.setStartAngle(90);
		}
    }
    
    public ObservableList<T1Names> t1getNameData(T1Names [] names) {
		ObservableList<T1Names> Names = FXCollections.observableArrayList();
		
		for(T1Names one_name : names) {
			if(one_name!=null) {
				Names.add(one_name);
			}
		}
		return Names;
	}

    @FXML
    void t4_computeT4X1() {
    	textAreaConsole.setText("Testing T4X1");
    }

    @FXML
    void t4_computeT4X2() {
    	textAreaConsole.setText("Testing T4X2");
    }

    @FXML
    void t5_computeT5X1() {
    	textAreaConsole.setText("Testing T5X1");
    }

    @FXML
    void t5_computeT5X2() {
    	textAreaConsole.setText("Testing T5X2");
    }

    @FXML
    void t2GenerateResults() {
    	textAreaConsole.setText("Testing T2");
    }

}
