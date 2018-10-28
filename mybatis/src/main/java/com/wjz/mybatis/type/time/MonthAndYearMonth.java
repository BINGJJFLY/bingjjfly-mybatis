package com.wjz.mybatis.type.time;

import java.time.Month;
import java.time.YearMonth;

import org.junit.Assert;
import org.junit.Test;

public class MonthAndYearMonth {
	
	@Test
	public void month() {
		Assert.assertEquals(5, Month.of(5).getValue());
		Assert.assertEquals("JULY", Month.of(7).name());
	}
	
	@Test
	public void yearMonth() {
		Assert.assertEquals("2007-12", YearMonth.parse("2007-12").toString());
	}

}
