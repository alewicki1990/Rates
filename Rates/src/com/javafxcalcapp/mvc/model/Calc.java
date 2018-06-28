package com.javafxcalcapp.mvc.model;

public class Calc {
	private double creditValue;
	private double interestRate;
	private int creditPeriod;
	private double result;

	public double getCreditValue() {
		return creditValue;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public double getCreditPeriod() {
		return creditPeriod;
	}

	public double getResult() {
		return result;
	}

	public void setCreditValue(double creditValue) {
		this.creditValue = creditValue;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void setCreditPeriod(int creditPeriod) {
		this.creditPeriod = creditPeriod;
	}

	/*
	 * // A– wysokość kredytu b– oprocentowanie w skali roku (stopy procentowe
	 * plus marża banku) n– ilość rat do spłaty (okres kredytowania l (jak
	 * lata) pomnożony przez m, czyli 12, bo tyle jest miesięcy w roku) R– to
	 * będzie wysokość naszej raty C– całkowita kwota do spłaty
	 * 
	 * q=1+(b/m) double q=1+(interestRate/creditPeriod);
	 * 
	 * R=A*(q^n)*(q-1)/[(q^n)-1]
	 * 
	 * result=creditValue*(Math.pow(q, n)*(q-1)/(((Math.pow(q, n))-1)
	 */

	public void calc(double creditValue, double interestRate, int creditPeriod) {

		double q = 1 + (interestRate / creditPeriod);
		result = creditValue * Math.pow(q, creditPeriod) * (q - 1) / ((Math.pow(q, creditPeriod)) - 1);
	}

	public double calc() {
		double q = 1 + (interestRate / creditPeriod);
		result = creditValue * Math.pow(q, creditPeriod) * (q - 1) / ((Math.pow(q, creditPeriod)) - 1);
		return result;
	}

}
