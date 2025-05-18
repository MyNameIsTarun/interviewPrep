package desing_pattern;

/*
 * The Strategy design pattern is a behavioral(communication, collaboration) design pattern.
 * The key idea behind the Strategy pattern is to define a family of algorithms, 
 * encapsulate each algorithm in a separate class, and make these classes interchangeable.
 * It allows the client to choose the appropriate algorithm at runtime without altering the client's code.
 */
//Step 4: Client code
public class Strategy {
	
	public static void main(String[] args) {
        ShoppingCart cart = new Strategy(). new ShoppingCart();

        // Using Credit Card payment strategy
        cart.setPaymentStrategy(new Strategy().    new    CreditCardPayment    ("1234-5678-9101-1121", "John Doe"));
        cart.checkout(100);

        // Using PayPal payment strategy
        cart.setPaymentStrategy(new Strategy(). new PayPalPayment("john.doe@example.com"));
        cart.checkout(50);
    }

	// Step 1: Strategy interface
	interface PaymentStrategy {
	    void pay(int amount);
	}

	// Step 2: ConcreteStrategy classes
	class CreditCardPayment implements PaymentStrategy {
	    private String cardNumber;
		private String name;

	    public CreditCardPayment(String cardNumber, String name) {
	        this.cardNumber = cardNumber;
	        this.name = name;
	    }

	    @Override
	    public void pay(int amount) {
	        System.out.println("Paid " + amount + " using credit card " + cardNumber);
	    }
	}

	class PayPalPayment implements PaymentStrategy {
	    private String email;

	    public PayPalPayment(String email) {
	        this.email = email;
	    }

	    @Override
	    public void pay(int amount) {
	        System.out.println("Paid " + amount + " using PayPal with email " + email);
	    }
	}

	// Step 3: Context 
	class ShoppingCart {
	    private PaymentStrategy paymentStrategy;
	    
	    public ShoppingCart() {}

	    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
	        this.paymentStrategy = paymentStrategy;
	    }

	    public void checkout(int amount) {
	        paymentStrategy.pay(amount);
	    }
	}
	
	/*
	 * Used in java?
	 * => Stream API, map(), filter(), and reduce() methods take functional interface so that we can define different strategies to be used
	 * 		 at runtime
	 * => payment functionality, allows to choose b/w diff strategies like payment via credit card, upi
	 */

}
