package com.qa.qacdb.persistence.domain;

import org.apache.log4j.Logger;

import com.qa.qacdb.utils.Utils;

public enum Domain {

	CUSTOMER("Information about customers"), PRODUCT("Individual Products"), ORDER("Orders made by customers"), ORDERLINE("Total amount of orders made by customers"),
	STOP("To close the application");

	public static final Logger LOGGER = Logger.getLogger(Domain.class);

	private String description;

	private Domain(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.name() + ": " + this.description;
	}

	public static void printDomains() {
		for (Domain domain : Domain.values()) {
			LOGGER.info(domain.getDescription());
		}
	}

	public static Domain getDomain() {
		Domain domain;
		while (true) {
			try {
				domain = Domain.valueOf(Utils.getInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return domain;
	}

}
