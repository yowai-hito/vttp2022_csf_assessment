package vttp2022.assessment.csf.orderbackend.configs;

public class BackendConstants {

    public static final String SUCCESS_STATUS = "success";
    public static final String FAIL_STATUS = "failed";
    public static final String APPLICATION_JSON = "application/json";

    public static final String SQL_INSERT_PIZZA_ORDER = "INSERT INTO pizzafactory.orders " +
    "(name, email, pizza_size, thick_crust, sauce, toppings, comments) " +
    "VALUES (?,?,?,?,?,?,?)";

    public static final String SQL_GET_ORDERS_BY_EMAIL = "SELECT * FROM pizzafactory.orders WHERE email = ?";
}
