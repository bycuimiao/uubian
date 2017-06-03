package com.uubian.api.tool;

import java.util.UUID;

public class TokenFactory {
	public static String productionToken(){
		return UUID.randomUUID().toString();
	}
}
