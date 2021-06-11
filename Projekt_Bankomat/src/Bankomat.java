import java.util.List;

public class Bankomat {

	public static void main(String[] args) {
		File plik = new File();
		List<Konto> konta = plik.ReadFile();
		for(Konto account: konta) {
			account.add20();
			System.out.println(account);
		}
		plik.SaveFile(konta);
	}
}
