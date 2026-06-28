package validators;

import org.testng.Assert;

public final class ResponseValidator {

    private ResponseValidator() {
    }

    public static void validateEquals(String actual,
                                      String expected,
                                      String fieldName) {

        Assert.assertEquals(actual, expected,
                fieldName + " validation failed");
    }

    public static void validateNotNull(Object object,
                                       String fieldName) {

        Assert.assertNotNull(object,
                fieldName + " should not be null");
    }

    public static void validateTrue(boolean condition,
                                    String message) {

        Assert.assertTrue(condition, message);
    }

    public static void validateFalse(boolean condition,
                                     String message) {

        Assert.assertFalse(condition, message);
    }
}
