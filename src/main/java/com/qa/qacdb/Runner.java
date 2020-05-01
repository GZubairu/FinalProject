package com.qa.qacdb;

import org.apache.log4j.Logger;

public class Runner {
	
public static final Logger LOGGER = Logger.getLogger(Runner.class);
	
	public static void main(String[] args) {
		Qacdb qacdb = new Qacdb();
		qacdb.QacdbSystem();
		
		
	}

}

