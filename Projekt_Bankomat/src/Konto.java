
public class Konto {
	private String name;
	private int pin;
	private int tries;
	private int cardNumber;
	private double balance;
	public Konto(String name, int pin, int tries, int cardNumber, double balance) {
		this.name = name;
		this.pin = pin;
		this.tries = tries;
		this.cardNumber = cardNumber;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public int getPin() {
		return pin;
	}
	public int getTries() {
		return tries;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public double getBalance() {
		return balance;
	}
}
