
public class Konto {
	private String name;
	private String pin;
	private int tries;
	private String cardNumber;
	private double balance;
	public Konto(String name, String pin, int tries, String cardNumber, double balance) {
		this.name = name;
		this.pin = pin;
		this.tries = tries;
		this.cardNumber = cardNumber;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public String getPin() {
		return pin;
	}
	public int getTries() {
		return tries;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public double getBalance() {
		return balance;
	}
	@Override
	public String toString() {
		return "Konto [name=" + name + ", pin=" + pin + ", tries=" + tries + ", cardNumber=" + cardNumber + ", balance="
				+ balance + "]";
	}
}
