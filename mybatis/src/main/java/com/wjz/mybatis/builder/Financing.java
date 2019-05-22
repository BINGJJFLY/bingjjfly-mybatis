package com.wjz.mybatis.builder;

import java.math.BigDecimal;
import java.util.Date;

public class Financing {
	
	private String fOrderCode;
	
	private String customerId;
	
	private String customerName;
	
	private BigDecimal financingAmount;
	
	private Date financingTime;
	
	public Financing(String fOrderCode) {
		this.fOrderCode = fOrderCode;
	}
	
	public Financing(String fOrderCode, String customerId, String customerName) {
		this.fOrderCode = fOrderCode;
		this.customerId = customerId;
		this.customerName = customerName;
	}
	
	public Financing customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}
	
	public Financing customerName(String customerName) {
		this.customerName = customerName;
		return this;
	}
	
	public Financing financingAmount(BigDecimal financingAmount) {
		this.financingAmount = financingAmount;
		return this;
	}
	
	public Financing financingTime(Date financingTime) {
		this.financingTime = financingTime;
		return this;
	}

	public String getfOrderCode() {
		return fOrderCode;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public BigDecimal getFinancingAmount() {
		return financingAmount;
	}

	public Date getFinancingTime() {
		return financingTime;
	}

	@Override
	public String toString() {
		return "Financing [fOrderCode=" + fOrderCode + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", financingAmount=" + financingAmount + ", financingTime=" + financingTime + "]";
	}
	
}
