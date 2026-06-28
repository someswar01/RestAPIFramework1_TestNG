package pojo.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOrderDetailsResponse {

    private OrderDetails data;

    private String message;
}
