package com.wjz.mybatis.logging;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.spi.LocationAwareLogger;

public class Slf4jLogTest {
	
	private final Marker MARKER = MarkerFactory.getMarker("BINGJJFLY");

	@Test
	public void api() {
		Logger log = LoggerFactory.getLogger(Slf4jLogTest.class);
		Assert.assertEquals(true, log instanceof LocationAwareLogger);
		LocationAwareLogger logger = (LocationAwareLogger) log;
		logger.log(MARKER, Slf4jLogTest.class.getName(), LocationAwareLogger.INFO_INT, "hello WORLD.", null, null);
		log.info("hello slf4j.");
	}
	
	@Test
	public void log() {
		Log log = LogFactory.getLog(Slf4jLogTest.class);
		System.out.println(log.getClass());
	}
}
