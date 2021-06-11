
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
	public void add20() {
		balance += 20;
	}
	public void removeTry() {
		if(tries > 0) {
			tries -= 1;
		}	
	}
	public void successfulLogin() {
		tries = 3;
	}
	public boolean withdraw(double amount) {
		if(amount > balance) {
			System.out.println("Brak wystarczaj�cej ilo�ci �rodk�w na koncie");
		} else if(amount < 50) {
			System.out.println("Minimalne mo�na wyp�aci� 50 z�");
		} else if(amount%10==0) {
			balance -= amount;
			System.out.println("Wyp�ata zako�czona sukcesem");
			return true;
		} else {
			System.out.println("Kwota wyp�aty musi by� wielokrotno�ci� banknotu 10 z�");
		}
		return false;
	}
}
