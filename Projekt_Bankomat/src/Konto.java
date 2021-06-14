
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
	public void removeTry() {
		if(tries > 0) {
			tries -= 1;
		}	
	}
	public void successfullLogin() {
		tries = 3;
	}
	public String withdraw(double amount) {
		if(amount > balance) {
			return "Pro�ba o wyp�at� mniejszej kwoty. Aktualny stan konta to : " + getBalance() + " z�.";
		} else if(amount < 50) {
			return "Minimalne mo�na wyp�aci� 50 z�";
		} else if(amount%10==0) {
			balance -= amount;
			return "Wyp�ata zako�czona sukcesem";
		} else {
			return "Kwota wyp�aty musi by� wielokrotno�ci� banknotu 10 z�";
		}
	}
}
