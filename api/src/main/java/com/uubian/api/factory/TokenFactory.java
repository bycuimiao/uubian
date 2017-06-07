package com.uubian.api.factory;

import java.util.UUID;

public class TokenFactory {
	public static String productionToken(){
		return UUID.randomUUID().toString();
	}
}
