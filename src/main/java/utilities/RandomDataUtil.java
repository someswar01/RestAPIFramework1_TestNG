package utilities;

import com.github.javafaker.Faker;

public final class RandomDataUtil {

    private static final Faker faker = new Faker();

    private RandomDataUtil() {}

    public static String productName(int maxLength) {

        String name = faker.commerce().productName();

        return name.length() > maxLength
                ? name.substring(0, maxLength)
                : name;
    }
}
