package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraint;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class viewController implements Initializable{
	@FXML
	private TextField txtNumber1;
	@FXML
	private TextField txtNumber2;
	
	@FXML
	private Button btnTeste;
	
	@FXML
	private Label labelResult;
	
	@FXML
	public void btnTestAction (){
		try {
			double number1 =  Double.parseDouble(txtNumber1.getText());
			double number2 =  Double.parseDouble(txtNumber2.getText());
			double sum = number1 + number2;
			labelResult.setText(String.format("%.2f", sum));
			
		} catch (NumberFormatException e) {
			Alerts.showAlert("Digito inválido", "Parse error",  e.getMessage(), AlertType.ERROR);
		}
	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 Constraint.setTextFieldDouble(txtNumber1);
		 Constraint.setTextFieldDouble(txtNumber2);
	}
}
