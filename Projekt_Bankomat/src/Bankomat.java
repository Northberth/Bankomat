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
	static boolean isLogged;
	private static Konto loggedUser;
	JLabel linfo, lamount;
	String amount;
	public Bankomat() {
		isLogged = false;
		loggedUser = null;
		amount = "";
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
		blogout = new JButton("Logout");
		blogin = new JButton("Login");
		bbalance = new JButton("Balance");
		bwithdraw = new JButton("Withdraw");
		linfo = new JLabel("Witaj w bankomacie");
		lamount = new JLabel("");
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setSize(400, 600);
		//t.setBounds(30, 40, 280, 30);
		//f.add(t);
		binfo.setBounds(310, 15, 60, 30);
		b0.setBounds(170, 500, 50, 40);
		b1.setBounds(110, 350, 50, 40);
		b2.setBounds(170, 350, 50, 40);
		b3.setBounds(230, 350, 50, 40);
		b4.setBounds(110, 400, 50, 40);
		b5.setBounds(170, 400, 50, 40);
		b6.setBounds(230, 400, 50, 40);
		b7.setBounds(110, 450, 50, 40);
		b8.setBounds(170, 450, 50, 40);
		b9.setBounds(230, 450, 50, 40);
		bok.setBounds(290, 450, 90, 40);
		bclear.setBounds(290, 400, 90, 40);
		bcancel.setBounds(290, 350, 90, 40);
		blogout.setBounds(5, 400, 90, 40);
		blogin.setBounds(5, 350, 90, 40);
		bbalance.setBounds(5, 450, 90, 40);
		bwithdraw.setBounds(150, 300, 90, 40);
		linfo.setBounds(5, 50, 600, 40);
		lamount.setBounds(5, 70, 600, 40);
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
		f.add(blogout);
		f.add(blogin);
		f.add(bbalance);
		f.add(bwithdraw);
		f.add(linfo);
		f.add(lamount);
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
		blogout.addActionListener(this);
		blogin.addActionListener(this);
		bbalance.addActionListener(this);
		bwithdraw.addActionListener(this);
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
				else if(account.getPin().equals(pin)) {
					System.out.println("Zalogowano pomyœlnie");
					System.out.println("Witaj " + account.getName());
					account.successfullLogin();
					plik.SaveFile(konta);
					isLogged = true;
					loggedUser = account;
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
		} else if(e.getSource() == b0) {
			amount += "0";
			lamount.setText(amount);
		} else if(e.getSource() == b1) {
			amount += "1";
			lamount.setText(amount);
		}else if(e.getSource() == b2) {
			amount += "2";
			lamount.setText(amount);
		}else if(e.getSource() == b3) {
			amount += "3";
			lamount.setText(amount);
		} else if(e.getSource() == b4) {
			amount += "4";
			lamount.setText(amount);
		}else if(e.getSource() == b5) {
			amount += "5";
			lamount.setText(amount);
		}else if(e.getSource() == b6) {
			amount += "6";
			lamount.setText(amount);
		} else if(e.getSource() == b7) {
			amount += "7";
			lamount.setText(amount);
		}else if(e.getSource() == b8) {
			amount += "8";
			lamount.setText(amount);
		}else if(e.getSource() == b9) {
			amount += "9";
			lamount.setText(amount);
		}else if(e.getSource() == bclear) {
			amount = "";
			lamount.setText(amount);
		}
	}
}
