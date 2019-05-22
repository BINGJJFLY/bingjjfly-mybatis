package com.wjz.mybatis.builder;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

public class FinancingTest {
	
	@Test
	public void financing() {
		Financing financing = new Financing("YFK001")
				.customerId("20190101")
				.customerName("bingjjfly")
				.financingAmount(new BigDecimal("1087.78"))
				.financingTime(new Date());
		System.out.println(financing);
	}

}
