package com.javafxcalcapp.mvc.view;

import com.javafxcalcapp.mvc.model.Calc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CalcController {

	Calc calculator;

	@FXML
	Label creditValueLabel;

	@FXML
	Label interestRateLabel;

	@FXML
	Label creditPeriodLabel;

	@FXML
	Label resultLabel;

	@FXML
	Label resultPriceLabel;

	@FXML
	TextField creditValueTextField;

	@FXML
	TextField interestRateTextField;

	@FXML
	TextField creditPeriodTextField;

	@FXML
	Button calculateButton;

	@FXML
	private void calcButtonPressed() {
		calculator = new Calc();
		try {
			checkIfStringHasOnlyDigits(creditValueTextField.getText());
			checkIfStringHasOnlyDigits(interestRateTextField.getText());
			checkIfStringHasOnlyDigits(creditPeriodTextField.getText());
			
			calculator.setCreditValue(Double.parseDouble(creditValueTextField.getText()));
			calculator.setInterestRate(Double.parseDouble(interestRateTextField.getText()));
			calculator.setCreditPeriod(Integer.parseInt(creditPeriodTextField.getText()));
			calculator.calc();
			resultPriceLabel.setText(String.valueOf(calculator.getResult()));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Niepoprawne dane.");
			alert.setContentText(e.getMessage());

			alert.showAndWait();
		}
	}

	private void checkIfStringHasOnlyDigits(String string) throws IllegalArgumentException {
		if (string.matches("^[0-9]*$") == false)
			throw new IllegalArgumentException("Pola tekstowe mog¹ zawieraæ tylko liczby dodatnie!");
	}
}
