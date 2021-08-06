/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corporate.governance.model;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Faruoq
 */
public class HomeScreenController implements Initializable { 
    
    @FXML
    private JFXTreeTableView<GovernanceModel> treeTable2;

    @FXML
    private TreeTableColumn<GovernanceModel, String> acc;

    @FXML
    private TreeTableColumn<GovernanceModel, String> bod;

    @FXML
    private TreeTableColumn<GovernanceModel, String> sust;

    @FXML
    private TreeTableColumn<GovernanceModel, String> indp;

    @FXML
    private TreeTableColumn<GovernanceModel, String> fair;

    @FXML
    private TreeTableColumn<GovernanceModel, String> rep;

    @FXML
    private TreeTableColumn<GovernanceModel, String> ce;

    @FXML
    private TreeTableColumn<GovernanceModel, String> trans;

    @FXML
    private TreeTableColumn<GovernanceModel, String> stki;

    @FXML
    private TreeTableColumn<GovernanceModel, String> open;

    @FXML
    private TreeTableColumn<GovernanceModel, String> cgpi;

    @FXML
    private Pane LoadDataPane;
    @FXML
    private Label machineLoadDataLabel;
    @FXML
    private Label MachineChooseFileLabel;
    @FXML
    private Label machineResetLabel;
    @FXML
    private Pane learningPane;
    @FXML
    private JFXTextField LearningRate;
    @FXML
    private Label LossFunctionLabel;
    @FXML
    private JFXTextField Iteration;
    @FXML
    private AnchorPane LossAnchorPane;
    @FXML
    private Label ModelLabel;
    @FXML
    private Pane modelPane;
    @FXML
    private Pane testPane;
    @FXML
    private Label accuracyLabel;
    @FXML
    private Pane PredictionPane;
    @FXML
    private Pane CGPIPane;
    @FXML
    private Pane GovernancePane;
    @FXML
    private Pane FirstPane;
    @FXML
    private JFXButton button1;
    @FXML
    private JFXButton button2;
    @FXML
    private JFXButton button3;
    @FXML
    private JFXButton button4;
    private ScatterChart<Double, Double> scatterChart;
        
    @FXML
    private Label availableTestData;
    @FXML
    private StackPane stack;
    @FXML
    private ScatterChart<?, ?> scat;
    @FXML
    private Pane predictCGPIPane;
    @FXML
    private JFXTextField Account1;
    @FXML
    private JFXTextField Fair1;
    @FXML
    private JFXTextField Indep1;
    @FXML
    private JFXTextField Board1;
    @FXML
    private JFXTextField Sustain1;
    @FXML
    private JFXTextField Reput1;
    @FXML
    private JFXTextField Open1;
    @FXML
    private JFXTextField Stake1;
    @FXML
    private JFXTextField control1;
    @FXML
    private JFXTextField Trans1;
    @FXML
    private Label CGPILabel;
    @FXML
    private Pane CoceptsPane;
    @FXML
    private Label Account2;
    @FXML
    private Label Board2;
    @FXML
    private Label Fair2;
    @FXML
    private Label Indep2;
    @FXML
    private Label Sustain2;
    @FXML
    private Label Reput2;
    @FXML
    private Label Control2;
    @FXML
    private Label Open2;
    @FXML
    private Label Stake2;
    @FXML
    private Label Trans2;
    @FXML
    private JFXTextField enterCGPI;
    @FXML
    private StackPane stackpane;

    @FXML
    void Data(ActionEvent event) {
        
        TranslateTransition translate=new TranslateTransition(Duration.seconds(1),LoadDataPane);
            translate.setByY(200);
            translate.play();

    }

    
    

    @FXML
    private PieChart pieChart;
    @FXML
    private PieChart pieChart1;
    @FXML
    private PieChart pieChart11;
    @FXML
    private Pane DashboardPane;
    @FXML
    private JFXTreeTableView<GovernanceModel> treeTableView;

    @FXML
    private TreeTableColumn<GovernanceModel, String> ageCol;
    @FXML
    private TreeTableColumn<GovernanceModel, String> genderCol;
    @FXML
    private TreeTableColumn<GovernanceModel, String> ExpCol;
    @FXML
    private TreeTableColumn<GovernanceModel, String> AccontCol;
    @FXML
    private TreeTableColumn<GovernanceModel, String> BoardCol;
    @FXML
    private TreeTableColumn<GovernanceModel, String> sustainabilityCol;
    @FXML
    private TreeTableColumn<GovernanceModel, String> indepenCol;
    @FXML
    private TreeTableColumn<GovernanceModel, String> FairnessCol;
    @FXML
    private TreeTableColumn<GovernanceModel, String> reputationCol;
    @FXML
    private TreeTableColumn<GovernanceModel, String> controlCol;
    @FXML
    private TreeTableColumn<GovernanceModel, String> transCol;
    @FXML
    private TreeTableColumn<GovernanceModel, String> stakeCol;
    @FXML
    private TreeTableColumn<GovernanceModel, String> opennessCol;
    @FXML
    private TreeTableColumn<GovernanceModel, String> CGPICol;
    
    ObservableList<GovernanceModel> list;
    ObservableList<GovernanceModel> list2;
    
    File file;
    
    String[][] data;
            
    @FXML
    private Pane statisticalPane;
    @FXML
    private Pane staisticsPane;
    @FXML
    private Label chooseFileLabel;
    @FXML
    private Label loadDataLabel;
    @FXML
    private Label resetTableLabel;
    @FXML
    private JFXButton Dashboard;
    @FXML
    private Label AccountabilityCol;
    @FXML
    private Label BoardColn;
    @FXML
    private Label SustainabilityColn;
    @FXML
    private Label IndependenceColn;
    @FXML
    private Label FairnessColn;
    @FXML
    private Label ReputationColn;
    @FXML
    private Label ControlColn;
    @FXML
    private Label TransparencyColn;
    @FXML
    private Label StakeholderColn;
    @FXML
    private Label OpennessColn;
    @FXML
    private Label CGPIColn;
    @FXML
    private Pane statisticalPane1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        modelPane.setVisible(false);
        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(.1), modelPane);
        scaleTransition.setByY(-1);
        scaleTransition.setByX(-1);
        scaleTransition.play();
        
        testPane.setVisible(false);
        
        ScaleTransition scaleTransit = new ScaleTransition(Duration.seconds(.1), testPane);
        scaleTransit.setByY(-1);
        scaleTransit.setByX(-1);
        scaleTransit.play();
        
        predictCGPIPane.setVisible(true);
        
        ScaleTransition scaleTransit1 = new ScaleTransition(Duration.seconds(.1), predictCGPIPane);
        scaleTransit1.setByY(-1);
        scaleTransit1.setByX(-1);
        scaleTransit1.play();
        
        CoceptsPane.setVisible(false);
        
        ScaleTransition scaleTransition2 = new ScaleTransition(Duration.seconds(.1), CoceptsPane);
        scaleTransition2.setByY(-1);
        scaleTransition2.setByX(-1);
        scaleTransition2.play();
        /*Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e-> {
            
            LocalTime currentTime = LocalTime.now();
            time.setText(currentTime.getHour() +" hours" +" : "+currentTime.getMinute()+ " mins"+" : "+currentTime.getSecond() +" secs");
        }), 
                new KeyFrame(Duration.seconds(1))
        );
        
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();*/
        
        LoadDataPane.setVisible(true);
        learningPane.setVisible(true);
        
        TranslateTransition translate=new TranslateTransition(Duration.seconds(.7), LoadDataPane);
            translate.setByY(-200);
            translate.play();
            
            
        TranslateTransition learn=new TranslateTransition(Duration.seconds(.7), learningPane);
            learn.setByY(-250);
            learn.play();
        
        //Pie Chart
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Males                   ", 217),
                new PieChart.Data("Females                   ", 201),
                new PieChart.Data("Non-respondents                   ", 81));
  
        pieChart.setData(pieChartData);
        
        
        ObservableList<PieChart.Data> pieChartData1 =
                FXCollections.observableArrayList(
                new PieChart.Data("Males (25 - 35) years  ", 64),
                new PieChart.Data("Males (35 - 49) years  ", 84),
                new PieChart.Data("Males (50 - 60) years  ", 69));
        pieChart1.setData(pieChartData1);
        
        ObservableList<PieChart.Data> pieChartData11 =
                FXCollections.observableArrayList(
                new PieChart.Data("Females (25 - 35) years", 55),
                new PieChart.Data("Females (35 - 49) years", 94),
                new PieChart.Data("Females (50 - 60) years", 52));
        
        pieChart11.setData(pieChartData11);
        
        
    }    

    @FXML
    private void Dashboard(ActionEvent event) {
        statisticalPane.setVisible(false);
        statisticalPane1.setVisible(false);
        PredictionPane.setVisible(false);
        DashboardPane.setVisible(true);
    }

    @FXML
    private void Statistics(ActionEvent event) {
        Dashboard.setRipplerFill(Color.WHITE);
        DashboardPane.setVisible(false);
        statisticalPane1.setVisible(false);
        PredictionPane.setVisible(false);
        statisticalPane.setVisible(true);
    }

    @FXML
    private void LoadData(ActionEvent event) throws FileNotFoundException, IOException {
        
        if(file == null){
            
            Image image = new Image("/corporate/governance/model/image/delete.png");
                Notifications notification = Notifications.create()
                        .title("Error")
                        .text("No file is uploaded!")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
        
        }else{
            
            loadExcel();
      
            loadDataUpToTable();

            if(list != null){
                loadDataLabel.setText("Loaded Successfully!");
            }

            computeStatistic();
        
        }
    }

    private void loadDataUpToTable() {
        
        ageCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Age;           
            }
        });
        
        genderCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Gender;           
            }
        });
        
        ExpCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Experience;           
            }
        });
        
        AccontCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Accountability;           
            }
        });
        
        BoardCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().BoardCommitment;           
            }
        });
        
        sustainabilityCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Sustainability;           
            }
        });
        
        indepenCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Independence;           
            }
        });
        
        FairnessCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Fairness;           
            }
        });
        
        reputationCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Reputation;           
            }
        });
        
        controlCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().ControlEnvironment;           
            }
        });
        
        transCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Transparency;           
            }
        });
        
        stakeCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().StakeholderInterface;           
            }
        });
        
        opennessCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Openness;           
            }
        });
        
        CGPICol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().CGPI;           
            }
        });
        
        TreeItem<GovernanceModel> root = new RecursiveTreeItem<GovernanceModel>(list, RecursiveTreeObject::getChildren);
        treeTableView.setRoot(root);
        treeTableView.setShowRoot(false);
    }

    @FXML
    private void fileChooser(ActionEvent event) {
        
        chooseIt();

    }

    @FXML
    private void resetTableButton(ActionEvent event) {
        if(list == null){
            
            Image image = new Image("/corporate/governance/model/image/delete.png");
                Notifications notification = Notifications.create()
                        .title("Error")
                        .text("Data table is empty!")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_RIGHT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
        
        }else{
            list.clear();
            file = null;
            chooseFileLabel.setText("No file chosen");
            loadDataLabel.setText("");
            resetTableLabel.setText("Data cleared");
        }
    }

    private void computeStatistic() {
        
        ArrayList<Double> Accountability = new ArrayList<Double>();
        ArrayList<Double> BoardC = new ArrayList<Double>();
        ArrayList<Double> Sustainability = new ArrayList<Double>();
        ArrayList<Double> Independence = new ArrayList<Double>();
        ArrayList<Double> Fairness = new ArrayList<Double>();
        ArrayList<Double> Reputation = new ArrayList<Double>();
        ArrayList<Double> ControlEnvironment = new ArrayList<Double>();
        ArrayList<Double> Transparency = new ArrayList<Double>();
        ArrayList<Double> StakeholderInterface = new ArrayList<Double>();
        ArrayList<Double> Openness = new ArrayList<Double>();
        ArrayList<Double> CGPI = new ArrayList<Double>();
        
        
        for(int r = 1; r < data.length; r++){
            
            Accountability.add(Double.parseDouble(data[r][3]));
            BoardC.add(Double.parseDouble(data[r][4]));
            Sustainability.add(Double.parseDouble(data[r][5]));
            Independence.add(Double.parseDouble(data[r][6]));
            Fairness.add(Double.parseDouble(data[r][7]));
            Reputation.add(Double.parseDouble(data[r][8]));
            ControlEnvironment.add(Double.parseDouble(data[r][9]));
            Transparency.add(Double.parseDouble(data[r][10]));
            StakeholderInterface.add(Double.parseDouble(data[r][11]));
            Openness.add(Double.parseDouble(data[r][12]));
            CGPI.add(Double.parseDouble(data[r][13]));
            
        }
        
        
        ArrayList<ArrayList<Double>> Governance = new ArrayList<ArrayList<Double>>();
        Governance.add(Accountability);
        Governance.add(BoardC);
        Governance.add(Sustainability);
        Governance.add(Independence);
        Governance.add(Fairness);
        Governance.add(Reputation);
        Governance.add(ControlEnvironment);
        Governance.add(Transparency);
        Governance.add(StakeholderInterface);
        Governance.add(Openness);
        Governance.add(CGPI);
        
        ArrayList<Label> GovernanceView = new ArrayList<Label>();
        GovernanceView.add(AccountabilityCol);
        GovernanceView.add(BoardColn);
        GovernanceView.add(SustainabilityColn);
        GovernanceView.add(IndependenceColn);
        GovernanceView.add(FairnessColn);
        GovernanceView.add(ReputationColn);
        GovernanceView.add(ControlColn);
        GovernanceView.add(TransparencyColn);
        GovernanceView.add(StakeholderColn);
        GovernanceView.add(OpennessColn);
        GovernanceView.add(CGPIColn);
        
        
        for(int i = 0; i < Governance.size(); i++){
            
            GovernanceView.get(i).setText((Statistics.Counts(Governance.get(i))) + ""+" "
                        +(Statistics.Mean(Governance.get(i)))+ ""+" "
                        +(Statistics.std(Governance.get(i)))+""+" "
                        +(Statistics.min(Governance.get(i)))+""+"   "
                        +(Statistics.Q1(Governance.get(i)))+""+"   "
                        +(Statistics.Q2(Governance.get(i)))+""+"   "
                        +(Statistics.Q3(Governance.get(i)))+""+" "
                        +(Statistics.max(Governance.get(i)))+""+" " );
            
        }
         
    }
    
    @FXML
    void MachineLearning(ActionEvent event) {
        
        statisticalPane.setVisible(false);
        DashboardPane.setVisible(false);
        PredictionPane.setVisible(false);
        statisticalPane1.setVisible(true);
    }

    @FXML
    private void ResetMachineTable(ActionEvent event) {
        
        list2.clear();
        file = null;
        MachineChooseFileLabel.setText("No file chosen");
        machineLoadDataLabel.setText("");
        machineResetLabel.setText("Data cleared");
    }

    @FXML
    private void MachineChooseFile(ActionEvent event) {
        
        chooseIt();
        
        if(file!=null){
            MachineChooseFileLabel.setText("xlsx available!");
            machineResetLabel.setText("");
        }
    }

    @FXML
    private void MachineLoadData(ActionEvent event) throws IOException {
        
        loadExcel();
        
        acc.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Accountability;           
            }
        });
        
        bod.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().BoardCommitment;           
            }
        });
        
        sust.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Sustainability;           
            }
        });
        
        indp.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Independence;           
            }
        });
        
        fair.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Fairness;           
            }
        });
        
        rep.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Reputation;           
            }
        });
        
        ce.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().ControlEnvironment;           
            }
        });
        
        trans.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Transparency;           
            }
        });
        
        stki.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().StakeholderInterface;           
            }
        });
        
        open.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().Openness;           
            }
        });
        
        cgpi.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<GovernanceModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<GovernanceModel, String> param) {
                return param.getValue().getValue().CGPI;           
            }
        });
        
        TreeItem<GovernanceModel> root = new RecursiveTreeItem<GovernanceModel>(list2, RecursiveTreeObject::getChildren);
        treeTable2.setRoot(root);
        treeTable2.setShowRoot(false);
        
        
        if(list != null){
            machineLoadDataLabel.setText("Loaded Successfully!");
        }
    }

    @FXML
    private void HideButton(ActionEvent event) {
        
        TranslateTransition translate=new TranslateTransition(Duration.seconds(1),LoadDataPane);
        translate.setByY(-200);
        translate.play();
    }

    private void chooseIt() {
        
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("c:\\"));

        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx"));
        file = chooser.showOpenDialog(null);
        
        if(file!=null){
            chooseFileLabel.setText("xlsx available!");
            resetTableLabel.setText("");
            
            Image image = new Image("/corporate/governance/model/image/mooo.png");
                Notifications notification = Notifications.create()
                        .title("Error")
                        .text("File uploaded successfully!")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
        }
        
    }

    private void loadExcel() throws FileNotFoundException, IOException {
        
        list = FXCollections.observableArrayList();
        list2 = FXCollections.observableArrayList();;
        //System.out.println(data);
        
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file.getAbsolutePath()));
        XSSFSheet sheet = workbook.getSheetAt(0);
        int row1 = sheet.getPhysicalNumberOfRows();
        int y = 14;
        data = new String[row1][y];
        
        if(y != 14){
            
            Image image = new Image("/corporate/governance/model/image/delete.png");
                Notifications notification = Notifications.create()
                        .title("Error in Excel")
                        .text("Number of rows must be 14!")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
        
        }else{
        int i;
        
        
        for (i = 0; i <= row1-1; i++){
            XSSFRow row = sheet.getRow(i);
            
            for (int j = 0; j < 14; j++){
                
                if(row.getCell(j).getCellType() == CellType.STRING){
                    
                    data[i][j] = row.getCell(j).getStringCellValue();
                    
                }else if(row.getCell(j).getCellType() == CellType.NUMERIC){
            
                    data[i][j] = Double.toString(row.getCell(j).getNumericCellValue()); 
                    
                }else if (row.getCell(j).getCellType() == CellType.BOOLEAN){
            
                    Image image = new Image("/corporate/governance/model/image/mooo.png");
                    Notifications notification = Notifications.create()
                            .title("Error in Excel")
                            .text("Boolean data can't be processed!")
                            .hideAfter(Duration.seconds(5))
                            .position(Pos.BOTTOM_LEFT)
                            .graphic(new ImageView(image));
                    notification.darkStyle();
                    notification.show();
                }else{
                    Image image = new Image("/corporate/governance/model/image/mooo.png");
                    Notifications notification = Notifications.create()
                            .title("Error")
                            .text("Null value has been detected!")
                            .hideAfter(Duration.seconds(5))
                            .position(Pos.BOTTOM_LEFT)
                            .graphic(new ImageView(image));
                    notification.darkStyle();
                    notification.show();
                }
            }
            
        }
        
      
        for(int r = 1; r < data.length; r++){
            
            GovernanceModel newRow = new GovernanceModel();
            GovernanceModel newRow1 = new GovernanceModel();
           
            StringProperty  v1 = new SimpleStringProperty(data[r][0]);
            StringProperty  v2 = new SimpleStringProperty(data[r][1]);
            StringProperty  v3 = new SimpleStringProperty(data[r][2]);
            StringProperty  v4 = new SimpleStringProperty(data[r][3]);
            StringProperty  v5 = new SimpleStringProperty(data[r][4]);
            StringProperty  v6 = new SimpleStringProperty(data[r][5]);
            StringProperty  v7 = new SimpleStringProperty(data[r][6]);
            StringProperty  v8 = new SimpleStringProperty(data[r][7]);
            StringProperty  v9 = new SimpleStringProperty(data[r][8]);
            StringProperty  v10 = new SimpleStringProperty(data[r][9]);
            StringProperty  v11 = new SimpleStringProperty(data[r][10]);
            StringProperty  v12 = new SimpleStringProperty(data[r][11]);
            StringProperty  v13 = new SimpleStringProperty(data[r][12]);
            StringProperty  v14 = new SimpleStringProperty(data[r][13]);
                
            newRow.setAge(v1);
            newRow.setGender(v2);
            newRow.setExperience(v3);
            newRow.setAccountability(v4);
            newRow.setBoardCommitment(v5);
            newRow.setSustainability(v6);
            newRow.setIndependence(v7);
            newRow.setFairness(v8);
            newRow.setReputation(v9);
            newRow.setControlEnvironment(v10);
            newRow.setTransparency(v11);
            newRow.setStakeholderInterface(v12);
            newRow.setOpenness(v13);
            newRow.setCGPI(v14);
            
            newRow1.setAccountability(v4);
            newRow1.setBoardCommitment(v5);
            newRow1.setSustainability(v6);
            newRow1.setIndependence(v7);
            newRow1.setFairness(v8);
            newRow1.setReputation(v9);
            newRow1.setControlEnvironment(v10);
            newRow1.setTransparency(v11);
            newRow1.setStakeholderInterface(v12);
            newRow1.setOpenness(v13);
            newRow1.setCGPI(v14);
                
            list.addAll(newRow);
            list2.addAll(newRow1);
            
             
        } 
        }

    }

    @FXML
    private void objectiveFunction(ActionEvent event) {
        
        TranslateTransition learn=new TranslateTransition(Duration.seconds(.7), learningPane);
            learn.setByY(250);
            learn.play();
    }
    
    double Learn;

    @FXML
    private void LearningButton(ActionEvent event) {
        
        Learn = Double.parseDouble(LearningRate.getText());
    }
    
    double W1; double W6;
    double W2; double W7;
    double W3; double W8;
    double W4; double W9;
    double W5; double W10;
    double Bias;

    @FXML
    private void optimizationAlgorithm(ActionEvent event) {
        
        Random random = new Random();
        
        W1 = random.nextDouble();
        W2 = random.nextDouble();
        W3 = random.nextDouble();
        W4 = random.nextDouble();
        W5 = random.nextDouble();
        W6 = random.nextDouble();
        W7 = random.nextDouble();
        W8 = random.nextDouble();
        W9 = random.nextDouble();
        W10 = random.nextDouble();
        
        Bias = random.nextDouble();
        
        ArrayList<Double> Accountability = new ArrayList<Double>();
        ArrayList<Double> BoardC = new ArrayList<Double>();
        ArrayList<Double> Sustainability = new ArrayList<Double>();
        ArrayList<Double> Independence = new ArrayList<Double>();
        ArrayList<Double> Fairness = new ArrayList<Double>();
        ArrayList<Double> Reputation = new ArrayList<Double>();
        ArrayList<Double> ControlEnvironment = new ArrayList<Double>();
        ArrayList<Double> Transparency = new ArrayList<Double>();
        ArrayList<Double> StakeholderInterface = new ArrayList<Double>();
        ArrayList<Double> Openness = new ArrayList<Double>();
        ArrayList<Double> CGPI = new ArrayList<Double>();
        
        Accountability.clear();
        BoardC.clear();
        Sustainability.clear();
        Independence.clear();
        Fairness.clear();
        Reputation.clear();
        ControlEnvironment.clear();
        Transparency.clear();
        StakeholderInterface.clear();
        Openness.clear();
        CGPI.clear();
                
        
        if(data == null){
            
            Image image = new Image("/corporate/governance/model/image/delete.png");
                Notifications notification = Notifications.create()
                        .title("Error")
                        .text("No Data uploaded!")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
        
        }else{
        for(int r = 1; r < data.length; r++){
            
            Accountability.add(Double.parseDouble(data[r][3]));
            BoardC.add(Double.parseDouble(data[r][4]));
            Sustainability.add(Double.parseDouble(data[r][5]));
            Independence.add(Double.parseDouble(data[r][6]));
            Fairness.add(Double.parseDouble(data[r][7]));
            Reputation.add(Double.parseDouble(data[r][8]));
            ControlEnvironment.add(Double.parseDouble(data[r][9]));
            Transparency.add(Double.parseDouble(data[r][10]));
            StakeholderInterface.add(Double.parseDouble(data[r][11]));
            Openness.add(Double.parseDouble(data[r][12]));
            CGPI.add(Double.parseDouble(data[r][13]));
            
        }
        
        
        
        double Outputs;
        double sumOfDelta;
        double Loss;
        double delC = 0;
        
        if(LearningRate.getText().equals("")){
            
            Image image = new Image("/corporate/governance/model/image/delete.png");
                Notifications notification = Notifications.create()
                        .title("Error")
                        .text("Learning rate is not defined!")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
        
        }else if(Iteration.getText().equals("")){
            
            Image image = new Image("/corporate/governance/model/image/delete.png");
                Notifications notification = Notifications.create()
                        .title("Error")
                        .text("Number if Iteration not defined!")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
        
        }else{
        double Learning_rate = Double.parseDouble(LearningRate.getText());
       
        ArrayList<Double> delta = new ArrayList<Double>();
        ArrayList<Double> delta_scaled = new ArrayList<Double>();
        StringBuilder obf = new StringBuilder();
        int iteration = Integer.parseInt(Iteration.getText());
        LossAnchorPane.setPrefHeight(20*Double.parseDouble(Iteration.getText()));
        LossFunctionLabel.setPrefHeight(20*Double.parseDouble(Iteration.getText()));
        
        for(int i = 0; i < iteration; i++){
            
            for(int c = 0; c < Accountability.size(); c++){
                
                Outputs = W1*Accountability.get(c) + W2*BoardC.get(c) + W3*Sustainability.get(c)
                        + W4*Independence.get(c) + W5*Fairness.get(c) + W6*Reputation.get(c)
                        + W7*ControlEnvironment.get(c) + W8*Transparency.get(c) + W9*StakeholderInterface.get(c)
                        + W10*Openness.get(c) + Bias;
                
                delC = Outputs - CGPI.get(c);
                
                if(delta.size() != Accountability.size() || delta.isEmpty()){
                
                    delta.add(delC);
                    
                }else{
                    
                    delta.set(c, delC);
                    
                }
            }
            
            sumOfDelta = Statistics.sumUpSquareArray(delta);
         
            Loss = (sumOfDelta)/delta.size();
            obf.append(Loss+"\n");
            LossFunctionLabel.setText(obf.toString());
            
            for(int y = 0; y<delta.size(); y++){
       
                if(delta_scaled.size() != Accountability.size() || delta_scaled.isEmpty()){
                    delta_scaled.add(2*delta.get(y)/delta.size());
                }else{
                    delta_scaled.set(y, 2*delta.get(y)/delta.size());
                }
            
            }
            
            ArrayList<Double> w1 = new ArrayList<Double>();
            ArrayList<Double> w2 = new ArrayList<Double>();
            ArrayList<Double> w3 = new ArrayList<Double>();
            ArrayList<Double> w4 = new ArrayList<Double>();
            ArrayList<Double> w5 = new ArrayList<Double>();
            ArrayList<Double> w6 = new ArrayList<Double>();
            ArrayList<Double> w7 = new ArrayList<Double>();
            ArrayList<Double> w8 = new ArrayList<Double>();
            ArrayList<Double> w9 = new ArrayList<Double>();
            ArrayList<Double> w10 = new ArrayList<Double>();
            
            
            
            for(int z = 0; z<delta_scaled.size(); z++){
                
                if(w1.size() != Accountability.size() || w1.isEmpty()){
                
                    w1.add(Accountability.get(z)*delta_scaled.get(z));
                    w2.add(BoardC.get(z)*delta_scaled.get(z));
                    w3.add(Sustainability.get(z)*delta_scaled.get(z));
                    w4.add(Independence.get(z)*delta_scaled.get(z));
                    w5.add(Fairness.get(z)*delta_scaled.get(z));
                    w6.add(Reputation.get(z)*delta_scaled.get(z));
                    w7.add(ControlEnvironment.get(z)*delta_scaled.get(z));
                    w8.add(Transparency.get(z)*delta_scaled.get(z));
                    w9.add(StakeholderInterface.get(z)*delta_scaled.get(z));
                    w10.add(Openness.get(z)*delta_scaled.get(z));
                    
                }else{
                    
                    w1.set(z, Accountability.get(z)*delta_scaled.get(z));
                    w2.set(z, BoardC.get(z)*delta_scaled.get(z));
                    w3.set(z, Sustainability.get(z)*delta_scaled.get(z));
                    w4.set(z, Independence.get(z)*delta_scaled.get(z));
                    w5.set(z, Fairness.get(z)*delta_scaled.get(z));
                    w6.set(z, Reputation.get(z)*delta_scaled.get(z));
                    w7.set(z, ControlEnvironment.get(z)*delta_scaled.get(z));
                    w8.set(z, Transparency.get(z)*delta_scaled.get(z));
                    w9.set(z, StakeholderInterface.get(z)*delta_scaled.get(z));
                    w10.set(z, Openness.get(z)*delta_scaled.get(z));
                
                }
      
            }
            
            double var1 = Statistics.sumUpArray(w1);
            double var2 = Statistics.sumUpArray(w2);
            double var3 = Statistics.sumUpArray(w3);
            double var4 = Statistics.sumUpArray(w4);
            double var5 = Statistics.sumUpArray(w5);
            double var6 = Statistics.sumUpArray(w6);
            double var7 = Statistics.sumUpArray(w7);
            double var8 = Statistics.sumUpArray(w8);
            double var9 = Statistics.sumUpArray(w9);
            double var10 = Statistics.sumUpArray(w10);
            
       
            
            W1 = W1 - Learning_rate*var1;
            W2 = W2 - Learning_rate*var2;
            W3 = W3 - Learning_rate*var3;
            W4 = W4 - Learning_rate*var4;
            W5 = W5 - Learning_rate*var5;
            W6 = W6 - Learning_rate*var6;
            W7 = W7 - Learning_rate*var7;
            W8 = W8 - Learning_rate*var8;
            W9 = W9 - Learning_rate*var9;
            W10 = W10 - Learning_rate*var10;
            Bias = Bias - Learning_rate*Statistics.sumUpArray(delta_scaled);
          
        }
        
        ModelLabel.setText(Statistics.round(W1, 4)+" AC + "+Statistics.round(W2, 4)+" BC + "+Statistics.round(W3, 4)
                +" SC + "+Statistics.round(W4, 4)+" IP + "+Statistics.round(W5, 4)+" FN + "+Statistics.round(W6, 4)
                +" RP + "+Statistics.round(W7, 4)+" CE + "+Statistics.round(W8, 4)+" TR + "+Statistics.round(W9, 4)
                +" SI + "+Statistics.round(W10, 4)+" OP = CGPI");
        }
        
        }
    }

    @FXML
    private void LearningHide(ActionEvent event) {
        
        TranslateTransition translate=new TranslateTransition(Duration.seconds(1),learningPane);
        translate.setByY(-250);
        translate.play();
    }

    @FXML
    private void modelButton(ActionEvent event) {
        
        if(ModelLabel.equals("")){
            
            Image image = new Image("/corporate/governance/model/image/delete.png");
                Notifications notification = Notifications.create()
                        .title("Note")
                        .text("No model is found yet!")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
        
        }else{
        
            modelPane.setVisible(true);

            ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(.1), modelPane);
            scaleTransition.setByY(1);
            scaleTransition.setByX(1);
            scaleTransition.play();
        }
        
    }

    @FXML
    private void hideModel(ActionEvent event) {
        
        modelPane.setVisible(false);
        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(.1), modelPane);
        scaleTransition.setByY(-1);
        scaleTransition.setByX(-1);
        scaleTransition.play();
        
    }

    @FXML
    private void OpenTestPane(MouseEvent event) {
        
        testPane.setVisible(true);
        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(.1), testPane);
        scaleTransition.setByY(1);
        scaleTransition.setByX(1);
        scaleTransition.play();
        
    }

    @FXML
    private void hideTestPane(ActionEvent event) {
        
        testPane.setVisible(false);
        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(.1), testPane);
        scaleTransition.setByY(-1);
        scaleTransition.setByX(-1);
        scaleTransition.play();
    }
    
    File file2;
    String[][] data2;
    ArrayList<Double> CGPI;
    ArrayList<Double> predictedCGPI;
    ArrayList<Double> Error;
    

    @FXML
    private void LoadTestData(ActionEvent event) throws IOException {
        
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("c:\\"));

        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx"));
        file2 = chooser.showOpenDialog(null);
        
        if(file2!=null){
            availableTestData.setText("xlsx available!");
        }
        
        
        
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file2.getAbsolutePath()));
        XSSFSheet sheet = workbook.getSheetAt(0);
        int row1 = sheet.getPhysicalNumberOfRows();
        data2 = new String[row1][14];
        int i;
        
        
        for (i = 0; i <= row1-1; i++){
            XSSFRow row = sheet.getRow(i);
            
            for (int j = 0; j < 14; j++){
                
                
                if(row.getCell(j).getCellType() == CellType.STRING){
                    
                    data2[i][j] = row.getCell(j).getStringCellValue();
                    
                }else if(row.getCell(j).getCellType() == CellType.NUMERIC){
            
                    data2[i][j] = Double.toString(row.getCell(j).getNumericCellValue()); 
                    
                }else if (row.getCell(j).getCellType() == CellType.BOOLEAN){
            
                    System.out.println("None");
                }else{
                    System.out.println("No");
                }
            }
            
        }
        
        ArrayList<Double> Accountability = new ArrayList<Double>();
        ArrayList<Double> BoardC = new ArrayList<Double>();
        ArrayList<Double> Sustainability = new ArrayList<Double>();
        ArrayList<Double> Independence = new ArrayList<Double>();
        ArrayList<Double> Fairness = new ArrayList<Double>();
        ArrayList<Double> Reputation = new ArrayList<Double>();
        ArrayList<Double> ControlEnvironment = new ArrayList<Double>();
        ArrayList<Double> Transparency = new ArrayList<Double>();
        ArrayList<Double> StakeholderInterface = new ArrayList<Double>();
        ArrayList<Double> Openness = new ArrayList<Double>();
        CGPI = new ArrayList<Double>();
        predictedCGPI = new ArrayList<Double>();
        Error = new ArrayList<Double>();
        
        Accountability.clear();
        BoardC.clear();
        Sustainability.clear();
        Independence.clear();
        Fairness.clear();
        Reputation.clear();
        ControlEnvironment.clear();
        Transparency.clear();
        StakeholderInterface.clear();
        Openness.clear();
        CGPI.clear();
                
        
        for(int r = 1; r < data2.length; r++){
            
            Accountability.add(Double.parseDouble(data2[r][3]));
            BoardC.add(Double.parseDouble(data2[r][4]));
            Sustainability.add(Double.parseDouble(data2[r][5]));
            Independence.add(Double.parseDouble(data2[r][6]));
            Fairness.add(Double.parseDouble(data2[r][7]));
            Reputation.add(Double.parseDouble(data2[r][8]));
            ControlEnvironment.add(Double.parseDouble(data2[r][9]));
            Transparency.add(Double.parseDouble(data2[r][10]));
            StakeholderInterface.add(Double.parseDouble(data2[r][11]));
            Openness.add(Double.parseDouble(data2[r][12]));
            CGPI.add(Double.parseDouble(data2[r][13]));
            
        }
        
        double prediction;
        double error;
        
        for(int l=0; l < Accountability.size(); l++){
            
            prediction = W1*Accountability.get(l) + W2*BoardC.get(l) + W3*Sustainability.get(l)
                        + W4*Independence.get(l) + W5*Fairness.get(l) + W6*Reputation.get(l)
                        + W7*ControlEnvironment.get(l) + W8*Transparency.get(l) + W9*StakeholderInterface.get(l)
                        + W10*Openness.get(l) + Bias;
                
                error = ((prediction - CGPI.get(l))/CGPI.get(l))*100;
                double pred = prediction;
                
            if(predictedCGPI.size() != Accountability.size() || predictedCGPI.isEmpty()){
                
                Error.add(error);
                predictedCGPI.add(pred);
                    
            }else{
                    
                Error.set(l, error);
                predictedCGPI.set(l, prediction);
                    
            }
        
        }
        
        
    }

    @FXML
    private void ProcessTestData(ActionEvent event) {
        
        scat.setVisible(false);
        
        StringBuilder Acc = new StringBuilder();
        
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        
        ScatterChart scatterChart = new ScatterChart(xAxis, yAxis);
        
        ObservableList<XYChart.Series<Double, Double>> answer = FXCollections.observableArrayList();
        Series<Double, Double> series1 = new Series();
        
        for( int i = 0; i < predictedCGPI.size(); i++){
            
            double Accuracy = 100 - Math.abs(Error.get(i));
            Acc.append(Accuracy +"\n");
            
            accuracyLabel.setText(Acc.toString());
            
            series1.getData().add(new XYChart.Data(CGPI.get(i), predictedCGPI.get(i)));
        
        }
        
        answer.addAll(series1);
        
        scatterChart.setData(answer);
        
        stack.getChildren().add(scatterChart);
    }

    @FXML
    private void PredictionButton(ActionEvent event) {
        
        DashboardPane.setVisible(false);
        statisticalPane1.setVisible(false);
        statisticalPane.setVisible(false);
        PredictionPane.setVisible(true);
        
    }

    @FXML
    private void pane_1_Exit(MouseEvent event) {
        
        FirstPane.setStyle("-fx-background-color: #e2e2e2; -fx-background-radius: 20px;");
    }

    @FXML
    private void pane_1_Entered(MouseEvent event) {
        
        FirstPane.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 20px;");
        
    }

    @FXML
    private void pane_2_Exit(MouseEvent event) {
        
        CGPIPane.setStyle("-fx-background-color: #e2e2e2; -fx-background-radius: 20px;");
    }

    @FXML
    private void pane_2_Entered(MouseEvent event) {
        
        CGPIPane.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 20px;");
    }

    @FXML
    private void pane_3_Exit(MouseEvent event) {
        GovernancePane.setStyle("-fx-background-color: #e2e2e2; -fx-background-radius: 20px;");
    }

    @FXML
    private void pane_3_Entered(MouseEvent event) {
        
        GovernancePane.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 20px;");
    }

    @FXML
    private void DataStyle2(MouseEvent event) {
        button1.setStyle("-fx-border-color: white; -fx-background-color:  #001e28; -fx-background-radius: 20px;  -fx-border-radius: 20px");
        button1.setButtonType(JFXButton.ButtonType.RAISED);
    }

    @FXML
    private void DataStyle1(MouseEvent event) {
        button1.setStyle("-fx-border-color: #377ce8; -fx-background-color:  #001e28; -fx-background-radius: 20px;  -fx-border-radius: 20px");
        button1.setButtonType(JFXButton.ButtonType.RAISED);
    }

    @FXML
    private void ModelStyle2(MouseEvent event) {
        button2.setStyle("-fx-border-color: white; -fx-background-color:  #001e28; -fx-background-radius: 20px;  -fx-border-radius: 20px");
        button2.setButtonType(JFXButton.ButtonType.RAISED);
    }

    @FXML
    private void ModelStyle1(MouseEvent event) {
        button2.setStyle("-fx-border-color: #377ce8; -fx-background-color:  #001e28; -fx-background-radius: 20px;  -fx-border-radius: 20px");
        button2.setButtonType(JFXButton.ButtonType.RAISED);
    }

    @FXML
    private void ObjectiveStyle2(MouseEvent event) {
        button3.setStyle("-fx-border-color: white; -fx-background-color:  #001e28; -fx-background-radius: 20px;  -fx-border-radius: 20px");
        button3.setButtonType(JFXButton.ButtonType.RAISED);
    }

    @FXML
    private void ObjectiveStyle1(MouseEvent event) {
        button3.setStyle("-fx-border-color: #377ce8; -fx-background-color:  #001e28; -fx-background-radius: 20px;  -fx-border-radius: 20px");
        button3.setButtonType(JFXButton.ButtonType.RAISED);
    }

    @FXML
    private void optimizationStyle2(MouseEvent event) {
        button4.setStyle("-fx-border-color: white; -fx-background-color:  #001e28; -fx-background-radius: 20px;  -fx-border-radius: 20px");
        button4.setButtonType(JFXButton.ButtonType.RAISED);
    }

    @FXML
    private void optimizationStyle1(MouseEvent event) {
        button4.setStyle("-fx-border-color: #377ce8; -fx-background-color:  #001e28; -fx-background-radius: 20px; -fx-border-radius: 20px");
        button4.setButtonType(JFXButton.ButtonType.RAISED);
    }

    @FXML
    private void predictCGPI(ActionEvent event) {
        
        double prediction = W1* Double.parseDouble(Account1.getText()) + W2*Double.parseDouble(Board1.getText()) + W3*Double.parseDouble(Sustain1.getText())
                        + W4*Double.parseDouble(Indep1.getText()) + W5*Double.parseDouble(Fair1.getText()) + W6*Double.parseDouble(Reput1.getText())
                        + W7*Double.parseDouble(control1.getText()) + W8*Double.parseDouble(Trans1.getText()) + W9*Double.parseDouble(Stake1.getText())
                        + W10*Double.parseDouble(Open1.getText()) + Bias;
        
        CGPILabel.setText(Double.toString(prediction));
    }

    @FXML
    private void OpenCGPIPane(MouseEvent event) {
        
        predictCGPIPane.setVisible(true);
        
        Account1.setStyle("-fx-text-fill: white");
        Board1.setStyle("-fx-text-fill: white");
        Sustain1.setStyle("-fx-text-fill: white");
        Indep1.setStyle("-fx-text-fill: white");
        Fair1.setStyle("-fx-text-fill: white");
        Reput1.setStyle("-fx-text-fill: white");
        control1.setStyle("-fx-text-fill: white");
        Trans1.setStyle("-fx-text-fill: white");
        Stake1.setStyle("-fx-text-fill: white");
        Open1.setStyle("-fx-text-fill: white");
        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(.1), predictCGPIPane);
        scaleTransition.setByY(1);
        scaleTransition.setByX(1);
        scaleTransition.play();

    }

    @FXML
    private void HideCGPI(ActionEvent event) {
        
        predictCGPIPane.setVisible(false);
        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(.1), predictCGPIPane);
        scaleTransition.setByY(-1);
        scaleTransition.setByX(-1);
        scaleTransition.play();
    }

    @FXML
    private void GovernanceConcept(MouseEvent event) {
        
        CoceptsPane.setVisible(true);
        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(.1), CoceptsPane);
        scaleTransition.setByY(1);
        scaleTransition.setByX(1);
        scaleTransition.play();
    }

    @FXML
    private void predictConcepts(ActionEvent event) {
        
        Random random = new Random();
        
        double x1 = random.nextInt(5);
        double x2 = random.nextInt(5);
        double x3 = random.nextInt(5);
        double x4 = random.nextInt(5);
        double x5 = random.nextInt(5);
        double x6 = random.nextInt(5);
        double x7 = random.nextInt(5);
        double x8 = random.nextInt(5);
        double x9 = random.nextInt(5);
        double x10 = random.nextInt(5);
        
        
        double Outputs;
        double Loss;
        double delC = 0;
        double Learning_rate = 0.001;
       
        double delta_scaled;
        int iteration = 500;
        double CGPI = Double.parseDouble(enterCGPI.getText());
        
        
        for(int i = 0; i < iteration; i++){
            
          
                
            Outputs = W1*x1 + W2*x2 + W3*x3 + W4*x4 + W5*x5 + W6*x6 + W7*x7 + W8*x8 + W9*x9 + W10*x10 + Bias;
                
            delC = Outputs - CGPI;
                
            
            Loss = delC*delC;
            
            System.out.println(Loss);
         
            delta_scaled = 2*delC;
             
            x1 = x1 - Learning_rate*delta_scaled*x1;
            x2 = x2 - Learning_rate*delta_scaled*x2;
            x3 = x3 - Learning_rate*delta_scaled*x3;
            x4 = x4 - Learning_rate*delta_scaled*x4;
            x5 = x5 - Learning_rate*delta_scaled*x5;
            x6 = x6 - Learning_rate*delta_scaled*x6;
            x7 = x7 - Learning_rate*delta_scaled*x7;
            x8 = x8 - Learning_rate*delta_scaled*x8;
            x9 = x9 - Learning_rate*delta_scaled*x9;
            x10 = x10 - Learning_rate*delta_scaled*x10;
            
        }
        
        Account2.setText(Double.toString(x1));
        Board2.setText(Double.toString(x2));
        Sustain2.setText(Double.toString(x3));
        Indep2.setText(Double.toString(x4));
        Fair2.setText(Double.toString(x5));
        Reput2.setText(Double.toString(x6));
        Control2.setText(Double.toString(x7));
        Trans2.setText(Double.toString(x8));
        Stake2.setText(Double.toString(x9));
        Open2.setText(Double.toString(x10));
    }

    @FXML
    private void HideConcepts(ActionEvent event) {
        
        CoceptsPane.setVisible(false);
        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(.1), CoceptsPane);
        scaleTransition.setByY(-1);
        scaleTransition.setByX(-1);
        scaleTransition.play();
    }

    @FXML
    private void Logout(ActionEvent event) {
        
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Alert"));
        dialogLayout.setBody(new Text("Do you want to logout !"));
        
        JFXButton ok = new JFXButton("Ok");
        ok.setPrefHeight(30);
        ok.setPrefWidth(70);
        ok.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        ok.setButtonType(JFXButton.ButtonType.RAISED);
        
        JFXButton Cancel = new JFXButton("Cancel");
        Cancel.setPrefHeight(30);
        Cancel.setPrefWidth(70);
        Cancel.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        Cancel.setButtonType(JFXButton.ButtonType.RAISED);
        
        JFXDialog dialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.CENTER);
        
        ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent Event){
                Stage home = new Stage();
                Parent root= null;

                try {
                    root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Stage current = (Stage)FirstPane.getScene().getWindow();
                Scene scene = new Scene(root);

                home.setScene(scene);
                home.initStyle(StageStyle.TRANSPARENT);

                current.hide();
                home.show();
            }
        });
        
        Cancel.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent Event){
                dialog.close();
            }
        });
        
        dialogLayout.setActions(ok,Cancel);
        dialog.show();
    }

    @FXML
    private void Exit(ActionEvent event) {
        
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Close"));
        dialogLayout.setBody(new Text("Do you want to exit !"));
        
        JFXButton ok = new JFXButton("Ok");
        ok.setPrefHeight(30);
        ok.setPrefWidth(70);
        ok.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        ok.setButtonType(JFXButton.ButtonType.RAISED);
        
        JFXButton Cancel = new JFXButton("Cancel");
        Cancel.setPrefHeight(30);
        Cancel.setPrefWidth(70);
        Cancel.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        Cancel.setButtonType(JFXButton.ButtonType.RAISED);
        
        JFXDialog dialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.CENTER);
        
        ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent Event){
                System.exit(0);
            }
        });
        
        Cancel.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent Event){
                dialog.close();
            }
        });
        
        dialogLayout.setActions(ok,Cancel);
        dialog.show();
    }
    
    
    
}
