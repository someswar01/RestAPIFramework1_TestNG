package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.DeleteProductService;
import services.GetOrderService;
import services.OrderService;
import services.ProductService;

public class ProductSteps {

    private final ProductService productService;
    private final OrderService orderService;
    private final GetOrderService getOrderService;
    private final DeleteProductService deleteProductService;

    public ProductSteps(ProductService productService,
                        OrderService orderService,
                        GetOrderService getOrderService,
                        DeleteProductService deleteProductService) {

        this.productService = productService;
        this.orderService = orderService;
        this.getOrderService = getOrderService;
        this.deleteProductService = deleteProductService;
    }

    @When("User adds a product")
    public void userAddsProduct() {

        productService.addProduct();
    }

    @Then("Product should be created successfully")
    public void productShouldBeCreatedSuccessfully() {

        System.out.println("Product Created Successfully");

    }

    @When("User creates an order")
    public void userCreatesAnOrder() {

        orderService.createOrder();

    }

    @Then("Order should be created successfully")
    public void orderShouldBeCreatedSuccessfully() {

        System.out.println("Order Created Successfully");

    }

    @When("User gets order details")
    public void userGetsOrderDetails() {

        getOrderService.getOrderDetails();

    }

    @Then("Order details should be returned")
    public void orderDetailsShouldBeReturned() {

        System.out.println("Order Details Retrieved");

    }

    @When("User deletes the product")
    public void userDeletesTheProduct() {

        deleteProductService.deleteProduct();

    }

    @Then("Product should be deleted successfully")
    public void productShouldBeDeletedSuccessfully() {

        System.out.println("Product Deleted Successfully");

    }
}