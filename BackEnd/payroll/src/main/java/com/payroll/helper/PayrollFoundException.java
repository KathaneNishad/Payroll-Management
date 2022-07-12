package com.payroll.helper;

public class PayrollFoundException extends Exception{
	public PayrollFoundException() {
		super("Payroll already Exists");
	}
	public PayrollFoundException(String msg) {
		super(msg);
	}
}
