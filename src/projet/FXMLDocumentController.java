/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projet;

import java.io.IOException;
import java.sql.*;


import java.net.URL;


import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author DALI
 */
public class FXMLDocumentController implements Initializable {
     @FXML
    private Button inscrire;
    @FXML
   private Button btnok;
    @FXML
    private Label label;

    @FXML
    private Label password;

    @FXML
    private TextField txtpass;

    @FXML
    private TextField txtuer;

    @FXML
    private Label username;
 
    private Connection connect;
    private PreparedStatement statement;
    private ResultSet result;
    
    
    
    public Connection connectDb(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        connect= DriverManager.getConnection("jdbc:mysql://localhost/hellodb","root","")   ;
          
        return connect;
  
}
    
    catch (Exception e){e.printStackTrace();}
    return null;
    }
    @FXML
     public void login(ActionEvent event){
        
        String name=txtuer.getText();
        String pass=txtpass.getText();
        
        
       if (name.equals("") && pass.equals(("")) ){
       JOptionPane.showMessageDialog(null,"champs vide");}
       else{
         
        
         try{ 
             connect=connectDb(); 
             
             String sql="select * from login where username=? and pass=?";
              statement= connect.prepareStatement(sql);
              statement.setString(1,name);
              statement.setString(2 ,pass);
              result=statement.executeQuery();
                 if(result.next()){
                     JOptionPane.showMessageDialog(null,"login success");
                     btnok.getScene().getWindow().hide();
                      
                  Parent  root = FXMLLoader.load(getClass().getResource("dahsbord.fxml"));
                  Scene scene=new Scene(root);
                  Stage stage=new Stage();
                  stage.setScene(scene);
                  stage.setTitle("dashbord");
                  stage.show();
                 }
                 else{JOptionPane.showMessageDialog(null,"login failed");
                 txtuer.setText("");
                 txtpass.setText("");
                 txtuer.requestFocus();
                 }
         }
         catch (Exception e){e.printStackTrace();}   
    } }
    
     
      @FXML
    void inscrire(ActionEvent event) throws IOException {
                 inscrire.getScene().getWindow().hide();
                      
                  Parent  root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
                  Scene scene=new Scene(root);
                  Stage stage=new Stage();
                  stage.setScene(scene);
                  stage.setTitle("inscription");
                  stage.show();

    }
     
     
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
