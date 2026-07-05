package builders;

import com.github.javafaker.Faker;
import managers.AuthManager;
import pojo.product.ProductRequest;
import utilities.RandomDataUtil;
public final class ProductRequestBuilder {

    private static final Faker faker = new Faker();

    private ProductRequestBuilder() {
    }

    public static ProductRequest build() {

        String productName = faker.commerce().productName();

        if (productName.length() > 20) {
            productName = productName.substring(0, 20);
        }

        return ProductRequest.builder()
                .productName(RandomDataUtil.productName(18))
                .productAddedBy(AuthManager.getUserId())
                .productCategory("Electronics")
                .productSubCategory("Automation")
                .productPrice(String.valueOf(faker.number().numberBetween(10000, 100000)))
                .productDescription(faker.lorem().sentence())
                .productFor("Testing")
                .build();
    }
}