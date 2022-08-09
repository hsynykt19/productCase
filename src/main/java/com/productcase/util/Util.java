package com.productcase.util;

import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

@Generated
public class Util {
    private static Logger logger = LoggerFactory.getLogger(Util.class);
    private Util() {
    }

    public static String getClient(String authorization) {
        String encodedUsernamePassword = authorization.substring("Basic ".length(), authorization.length());
        String usernamePassword = new String(Base64Utils.decodeFromString(encodedUsernamePassword));
        return  usernamePassword.substring(0, usernamePassword.indexOf(':'));
    }


    public static String getUsernamePassword(String authorization) {
        String encodedUsernamePassword = authorization.substring("Basic ".length(), authorization.length());
        String usernamePassword = new String(Base64Utils.decodeFromString(encodedUsernamePassword));
        String password  = usernamePassword.substring(usernamePassword.indexOf(':'), usernamePassword.length());
        password= password.replaceAll(":", "");
        return password;
    }
    public static String getPassword(String authorization) {
        String encodedUsernamePassword = authorization.substring("Basic ".length(), authorization.length());
        String usernamePassword = new String(Base64Utils.decodeFromString(encodedUsernamePassword));
        String password  = usernamePassword.substring(0, usernamePassword.indexOf(':'));
        return password;
    }


	


	public static String getUsername(String encodedUsernamePassword) {
		String usernamePassword = new String(Base64Utils.decodeFromString(encodedUsernamePassword));
		String username  = usernamePassword.substring(0, usernamePassword.indexOf(':'));
		return username;
	}
}
