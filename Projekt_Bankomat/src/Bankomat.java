import java.util.List;
import java.util.Scanner;

public class Bankomat {
	private static List<Konto> konta;
	private static File plik;
	public static void main(String[] args) {
		plik = new File();
		konta = plik.ReadFile();
		for(Konto account: konta) {
			System.out.println(account);
		}
		//plik.SaveFile(konta);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Prosz� poda� numer karty");
		String userCardNumber  = scanner.nextLine();
		System.out.println("Prosz� poda� numer pin");
		String userpin  = scanner.nextLine();
		login(userCardNumber,userpin);
	}
	public static boolean login(String cardNumber, String pin) {
		for(Konto account: konta) {
			System.out.println(cardNumber);
			if(account.getCardNumber().equals(cardNumber)) {
				System.out.println("Witaj " + account.getName());
				if (account.getTries() <= 0) {
					System.out.println("Konto zablokowane. Prosz� si� skontaktowa� z administratorem");
				}
				else if(account.getPin() == pin) {
					System.out.println("Zalogowano pomy�lnie");
					account.successfullLogin();
				} else {
					account.removeTry();
					System.out.println("Niepoprawny pin. Pozosta�o: " + account.getTries());
					plik.SaveFile(konta);
				}
			}
		}
		return false;
		
	}
}
