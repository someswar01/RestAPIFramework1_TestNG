package pojo.product;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    private String productName;
    private String productAddedBy;
    private String productCategory;
    private String productSubCategory;
    private String productPrice;
    private String productDescription;
    private String productFor;

    public Map<String, String> toFormParams() {

        Map<String, String> params = new HashMap<>();

        params.put("productName", productName);
        params.put("productAddedBy", productAddedBy);
        params.put("productCategory", productCategory);
        params.put("productSubCategory", productSubCategory);
        params.put("productPrice", productPrice);
        params.put("productDescription", productDescription);
        params.put("productFor", productFor);

        return params;
    }
}