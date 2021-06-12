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
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bok,blogout,blogin,binfo,bbalance,bwithdraw,bclear,bcancel;
	public Bankomat() {
		f = new JFrame("Bankomat");
		//t = new JTextField();
		binfo = new JButton("Info");
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bclear = new JButton("Clear");
		bok = new JButton("OK");
		bcancel = new JButton("Cancel");
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setSize(400, 600);
		//t.setBounds(30, 40, 280, 30);
		//f.add(t);
		binfo.setBounds(310, 15, 60, 30);
		b0.setBounds(155, 500, 50, 40);
		b1.setBounds(95, 350, 50, 40);
		b2.setBounds(155, 350, 50, 40);
		b3.setBounds(215, 350, 50, 40);
		b4.setBounds(95, 400, 50, 40);
		b5.setBounds(155, 400, 50, 40);
		b6.setBounds(215, 400, 50, 40);
		b7.setBounds(95, 450, 50, 40);
		b8.setBounds(155, 450, 50, 40);
		b9.setBounds(215, 450, 50, 40);
		bok.setBounds(285, 450, 80, 40);
		bclear.setBounds(285, 400, 80, 40);
		bcancel.setBounds(285, 350, 80, 40);
		f.add(binfo);
		f.add(b0);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.add(b9);
		f.add(bok);
		f.add(bclear);
		f.add(bcancel);
		binfo.addActionListener(this);
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bok.addActionListener(this);
		bclear.addActionListener(this);
		bcancel.addActionListener(this);
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
			JLabel label0 = new JLabel("Pin ma 4 liczby, a numer karty 16 liczb.");
			JLabel label1 = new JLabel("Trzy nieudane próby blokuj¹ kartê.");
			JLabel label2 = new JLabel("Mo¿na wyp³aciæ wielokrotnoœæ banknotu 10 z³,");
			JLabel label3 = new JLabel("ale nie mniej ni¿ 50 z³.");
			f1.setLayout(null);
			f1.setVisible(true);
			f1.setResizable(false);
			f1.setSize(400, 600);
			label0.setBounds(30, 40, 280, 90);
			label1.setBounds(30, 55, 280, 90);
			label2.setBounds(30, 70, 280, 90);
			label3.setBounds(30, 85, 280, 90);
			f1.add(label0);
			f1.add(label1);
			f1.add(label2);
			f1.add(label3);
		}
	}
}
