package tests;

import io.restassured.response.Response;
import managers.OrderManager;
import managers.ProductManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.order.CreateOrderResponse;
import pojo.order.GetOrderDetailsResponse;
import pojo.product.AddProductResponse;
import pojo.product.DeleteProductResponse;
import services.*;
import utilities.LoggerUtil;
import validators.ResponseValidator;

public class ProductTest {

    private static final Logger logger =
            LoggerUtil.getLogger(ProductTest.class);
        private final ProductService productService = new ProductService();
        private final OrderService orderService = new OrderService();
        private final GetOrderService getOrderService = new GetOrderService();

        @Test(priority = 1)
        public void verifyAddProduct() {

            System.out.println("===== Add Product =====");
            logger.info("Add product Started");

            AddProductResponse response = productService.addProduct();
            ResponseValidator.validateNotNull(
                    response.getProductId(),
                    "Product Id");

            ResponseValidator.validateEquals(
                    response.getMessage(),
                    "Product Added Successfully",
                    "Add Product Message");

            System.out.println("Product Id : " + response.getProductId());
        }

    @Test(priority = 2)
    public void verifyCreateOrder() {

            logger.info("Create Order Started");

            CreateOrderResponse response =
                    orderService.createOrder();
        ResponseValidator.validateEquals(
                response.getMessage(),
                "Order Placed Successfully",
                "Order Message");

        ResponseValidator.validateNotNull(
                response.getOrders(),
                "Orders");
            System.out.println(
                    "Order Id : " +
                            OrderManager.getOrderId()
            );

            logger.info("Create Order Passed");
        }


    @Test(priority = 3)
    public void verifyGetOrderDetails() {

        logger.info("Get Order Details Started");

        GetOrderDetailsResponse response =
                getOrderService.getOrderDetails();

//        Assert.assertEquals(
//                response.getMessage(),
//                "Orders fetched for customer Successfully"
//        );

        ResponseValidator.validateEquals(
                response.getMessage(),
                "Orders fetched for customer Successfully",
                "Fetch Order Details message");


//        Assert.assertEquals(
//                response.getData().getCountry(),
//                "India"
//        );
        ResponseValidator.validateEquals(
                response.getData().getCountry(),
                "India",
                "Add Country Details Successfully ");

//        Assert.assertEquals(
//                response.getData().getProductOrderedId(),
//                ProductManager.getProductId()
//        );

        ResponseValidator.validateEquals(
                response.getData().getProductOrderedId(),
                ProductManager.getProductId(),
                "Validate Product Id ");

//        Assert.assertEquals(
//                response.getData().get_id(),
//                OrderManager.getOrderId()
//        );
        ResponseValidator.validateEquals(
                response.getData().get_id(),
                OrderManager.getOrderId(),
                "Validate Order Id ");


        logger.info("Get Order Details Passed");
    }

    @Test(priority = 4)
    public void verifyDeleteProduct() {

        logger.info("Delete Product Started");

        DeleteProductService service = new DeleteProductService();

        DeleteProductResponse response = service.deleteProduct();

        ResponseValidator.validateEquals(
                response.getMessage(),
                "Product Deleted Successfully",
                "Delete Product Message");

        logger.info("Delete Product Passed");
    }


}
