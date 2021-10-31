package com.poc2;

public class UserValidator {

	public boolean isValidUser(User user) {

		if (user.getName() == (null) || user.getDob() == (null) || user.getJoingDate() == null
				|| user.getLocation() == null)
			return false;

		return true;
	}

}
