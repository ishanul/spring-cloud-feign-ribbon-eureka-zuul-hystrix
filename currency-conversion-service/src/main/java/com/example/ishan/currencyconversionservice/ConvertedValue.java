package com.example.ishan.currencyconversionservice;

import java.math.BigDecimal;

public class ConvertedValue {

	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal rate;
	private BigDecimal conversion;

	public ConvertedValue() {
		super();
	}

	public ConvertedValue(String from, String to, BigDecimal quantity, BigDecimal rate, BigDecimal conversion) {
		super();
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.rate = rate;
		this.conversion = conversion;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getConversion() {
		return conversion;
	}

	public void setConversion(BigDecimal conversion) {
		this.conversion = conversion;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

}
