package vttp2022.assessment.csf.orderbackend.models;

public class PizzaOrderRequest {
    
    // userName: this.fb.control<string>('', [ Validators.required ]),
    // userEmail: this.fb.control<string>('', [ Validators.required, Validators.email ]),
    // userPizzaSize: this.fb.control<number>(0, [ Validators.required ]),
    // userPizzaBase: this.fb.control<string>("thin", [ Validators.required ]),
    // userPizzaSauce: this.fb.control<string>("classic", [ Validators.required ]),
    // userPizzaToppings: this.fb.array([this.pizzaToppings], [Validators.minLength(1)]),
    // userComments: this.fb.control<string>('')

    private Integer orderId;
	private String userName;
    private String userEmail;
	private Integer userPizzaSize;
	private String userPizzaBase;
	private String userPizzaSauce;
	private PizzaToppings userPizzaToppings;
	private String userComments;
    
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public Integer getUserPizzaSize() {
        return userPizzaSize;
    }
    public void setUserPizzaSize(Integer userPizzaSize) {
        this.userPizzaSize = userPizzaSize;
    }
    public String getUserPizzaBase() {
        return userPizzaBase;
    }
    public void setUserPizzaBase(String userPizzaBase) {
        this.userPizzaBase = userPizzaBase;
    }
    public String getUserPizzaSauce() {
        return userPizzaSauce;
    }
    public void setUserPizzaSauce(String userPizzaSauce) {
        this.userPizzaSauce = userPizzaSauce;
    }
    public PizzaToppings getUserPizzaToppings() {
        return userPizzaToppings;
    }
    public void setUserPizzaToppings(PizzaToppings userPizzaToppings) {
        this.userPizzaToppings = userPizzaToppings;
    }
    public String getUserComments() {
        return userComments;
    }
    public void setUserComments(String userComments) {
        this.userComments = userComments;
    }



    
}
