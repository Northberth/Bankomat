import java.util.List;

public class Bankomat {

	public static void main(String[] args) {
		File plik = new File();
		List<Konto> konta = plik.ReadFile();
		for(Konto account: konta) {
			System.out.println(account);
		}

	}

}
