package com.project.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Exchange_Value")

public class ExchangeValue {

	@Id @Column(name = "id")
	private Long id;
	@Column(name = "currency_from")
	private String fromCurrency;
	@Column(name = "currency_to")
	private String toCurrency;
	@Column(name = "conversion_multiple")
	private BigDecimal conversionMultiple;
	@Column(name = "port")
	private int port;
	
	public ExchangeValue() {}
	public ExchangeValue(Long id, String fromCurrency, String toCurrency, BigDecimal conversionMultiple, int port){
		super();
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionMultiple = conversionMultiple;
        this.port = port;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	}

