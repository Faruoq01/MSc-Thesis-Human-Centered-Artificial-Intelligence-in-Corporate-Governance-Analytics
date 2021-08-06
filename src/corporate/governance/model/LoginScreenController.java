/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corporate.governance.model;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Faruoq
 */
public class LoginScreenController implements Initializable {

    @FXML
    private FontAwesomeIconView image;
    @FXML
    private StackPane stackpane;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     @FXML
    void getStarted(ActionEvent event) {
        
        Stage loginScreen = new Stage();
                Parent root = null;
                
                try{
                    root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
                    
                } catch (Exception e){
                    e.printStackTrace();
                }
            
                Stage current = (Stage)image.getScene().getWindow();
                Scene scene = new Scene(root);
                
                loginScreen.setScene(scene);
                loginScreen.initStyle(StageStyle.TRANSPARENT);
                current.hide();
                loginScreen.show();

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
