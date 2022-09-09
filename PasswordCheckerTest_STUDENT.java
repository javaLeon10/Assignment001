package main.java.a;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() throws LengthException {
		try {
			assertTrue(PasswordCheckerUtility.isValidLength("abc12"));
		} catch (LengthException e) {
			assertTrue("Successfully threw a lengthException", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides lengthException", false);

		}
	}

	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */


	@Test
	public void testIsValidPasswordNoUpperAlpha() throws NoUpperAlphaException {
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("passwordpassword"));
		} catch (NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaException", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides NoUpperAlphaException", false);

		}
	}

	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() throws NoLowerAlphaException {
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("123456"));
		} catch (NoLowerAlphaException e) {
			assertTrue("Successfully threw a lowerAlpha Exception", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides lowerAlphaException", false);

		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() throws InvalidSequenceException {
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword("Leon@1"));
		} catch (InvalidSequenceException e) {
			assertTrue("Successfully threw a weakPasswordException", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides weakPasswordException", false);

		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() throws InvalidSequenceException {
		try {
			assertTrue(PasswordCheckerUtility.NoSameCharInSequence("P@sssword"));
		} catch (InvalidSequenceException e) {
			assertTrue("Successfully threw a InvalidSequenceException", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides NoSameCharException", false);

		}
	}

	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() throws NoDigitException {
		try {
			assertTrue(PasswordCheckerUtility.hasDigit("T@rlmnbv"));
		} catch (NoDigitException e) {
			assertTrue("Successfully threw a NoDigitException", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides NoDigitException", false);

		}
	}

	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() throws NoLowerAlphaException, NoSpecialCharacterException, NoDigitException, LengthException, NoUpperAlphaException, InvalidSequenceException {


		Boolean istr = PasswordCheckerUtility.isValidPassword("Leon@home123");
		if (istr == true) {
			System.out.println("Success");
		} else System.out.println("Not success");

	}

	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		passwords.add("123MagicPony");
		passwords.add("1234567");
		passwords.add("This is @home");
		passwords.add("Leon@home123");

		ArrayList<String> badpasswords = new ArrayList<>(10);
		badpasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
		int k = badpasswords.size();
		for (int i = 0; i < k; i++) {
			System.out.println(badpasswords.get(i));
		}

	}
}