import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Bankomat implements ActionListener {
	private static List<Konto> konta;
	private static File plik;
	JFrame f;
	JTextField t;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bok,blogout,blogin,binfo,bbalance,bwithdraw;
	public Bankomat() {
		f = new JFrame("Bankomat");
		t = new JTextField();
		binfo = new JButton("Info");
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setSize(400, 600);
		t.setBounds(30, 40, 280, 30);
		f.add(t);
		binfo.setBounds(110, 170, 60, 30);
		f.add(binfo);
		binfo.addActionListener(this);
	}
	public static void main(String[] args) {
		plik = new File();
		konta = plik.ReadFile();
		for(Konto account: konta) {
			System.out.println(account);
		}
		new Bankomat();
		Scanner scanner = new Scanner(System.in);
		boolean userLogin = false;
		while(userLogin != true) {
			System.out.println("Proszê podaæ numer karty");
			String userCardNumber  = scanner.nextLine();
			System.out.println("Proszê podaæ numer pin");
			String userpin  = scanner.nextLine();
			userLogin = login(userCardNumber,userpin);
		}
	}
	public static boolean login(String cardNumber, String pin) {
		for(Konto account: konta) {
			if(account.getCardNumber().equals(cardNumber)) {
				if (account.getTries() <= 0) {
					System.out.println("Konto zablokowane. Proszê siê skontaktowaæ z administratorem");
				}
				else if(account.getPin() == pin) {
					System.out.println("Zalogowano pomyœlnie");
					System.out.println("Witaj " + account.getName());
					account.successfullLogin();
					plik.SaveFile(konta);
					userMenu(account);
					return true;
				} else {
					account.removeTry();
					System.out.println("Niepoprawny pin. Pozosta³o: " + account.getTries());
					if (account.getTries() == 0) {
						System.out.println("Konto zosta³o zablokowane. Proszê siê skontaktowaæ z administratorem");
					}
					plik.SaveFile(konta);
				}
			}
		}
		return false;
	}
	public static void userMenu(Konto konto) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == binfo) {
			JFrame f1 = new JFrame("Info");
			JLabel label = new JLabel("test");
			f1.setLayout(null);
			f1.setVisible(true);
			f1.setResizable(false);
			f1.setSize(400, 600);
			label.setBounds(30, 40, 280, 30);
			f1.add(label);
		}
		
	}
}
