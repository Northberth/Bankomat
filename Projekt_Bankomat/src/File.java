import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class File {
	public List<Konto> ReadFile() {
		try {
			FileInputStream reader = new FileInputStream("bank.txt");
			Scanner scanner = new Scanner(reader);
			List<String> daneKont = new ArrayList<>();
			while (scanner.hasNextLine()) {
				daneKont.add(scanner.nextLine());
			}
			List<Konto> konta = new ArrayList<>();
			for (int i = 0; i < daneKont.size(); i+=5 ) {
				konta.add(new Konto(daneKont.get(i),daneKont.get(i+1),Integer.parseInt(daneKont.get(i+2)),
						daneKont.get(i+3),Double.parseDouble(daneKont.get(i+4))));
			}
			return konta;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;	
	}
	public boolean SaveFile(List<Konto> konta) {
		try {
			String daneKont = "";
			for(Konto konto: konta) {
				daneKont += konto.getName() + "\n";
				daneKont += konto.getPin() + "\n";
				daneKont += konto.getTries() + "\n";
				daneKont += konto.getCardNumber() + "\n";
				daneKont += konto.getBalance() + "\n";
			}
			Path path = Path.of("bank.txt");
			BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
			writer.write(daneKont);
			writer.flush();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
