/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projet;

import java.io.IOException;
import java.net.URL;
import java.sql.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author DALI
 */
public class InscriptionController implements Initializable {
 @FXML
    private AnchorPane sceneIn;
      @FXML
    private Button btnok;

    @FXML
    private TextField dateN;

    @FXML
    private TextField email;

    @FXML
    private TextField nom;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField prenom;


    @FXML
    private TextField username;
    
    @FXML
    private RadioButton radioButton1;
    
    @FXML
     private RadioButton radioButton2;


    private Connection connect;
     private PreparedStatement statement;
    private ResultSet result;
    
    public void changeScene(String fxml) throws IOException 
{
           btnok.getScene().getWindow().hide();
         Parent   root = FXMLLoader.load(getClass().getResource(fxml));
                  Scene scene=new Scene(root);
                  Stage stage=new Stage();
                  stage.setScene(scene);
                  stage.setTitle("login");
                  stage.show();

    System.out.println(fxml);
}
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
    void inscrire(ActionEvent event) throws SQLException {
         String Nom=nom.getText();
         String Prenom=prenom.getText();
         String Email=email.getText();
         String DateN=dateN.getText();
         String Username=username.getText();
         String Pass=pass.getText();
         if (Nom.equals("")||Prenom.equals("")|| Email.equals("")|| Username.equals("")||Pass.equals(""))
         {JOptionPane.showMessageDialog(null,"il y a un champ vide");
         }
         else{
              try{ 
                connect=connectDb();
                String sql="insert into login(nom,prenom,datenais,email,username,pass,sexe)values(?,?,?,?,?,?,?)";
              statement= connect.prepareStatement(sql);
              statement.setString(1,Nom);
              statement.setString(2 ,Prenom);
              statement.setString(3 ,DateN);
              statement.setString(4 ,Email);
              statement.setString(5 ,Username);
              statement.setString(6 ,Pass);
              statement.setString(7 ,"gay");
              
              statement.executeUpdate();
              JOptionPane.showMessageDialog(null,"inscription reussite");
              changeScene("FXMLDocument.fxml");
             
         }
              catch (Exception e){e.printStackTrace();}
         
         

    }}
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ToggleGroup group = new ToggleGroup();
    radioButton1.setToggleGroup(group);
    radioButton2.setToggleGroup(group);
    }    
    
}
