package pojo.order;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    private String country;
    private String productOrderedId;
}