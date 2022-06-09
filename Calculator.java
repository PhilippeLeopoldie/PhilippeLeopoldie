
/*************File1/2:Graph1.java***************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
public  class Graph1 extends JFrame{
	
	JTextField texte =new JTextField(10);
	
	
	JButton boutton1=new JButton("1");
	JButton boutton2=new JButton("2");
	JButton boutton3=new JButton("3");
	JButton boutton4=new JButton("4");
	JButton boutton5=new JButton("5");
	JButton boutton6=new JButton("6");
	JButton boutton7=new JButton("7");
	JButton boutton8=new JButton("8");
	JButton boutton9=new JButton("9");
	JButton boutton0=new JButton("0");
	JButton bouttonVirgule=new JButton(",");
	JButton bouttonPlus=new JButton("+");
	JButton bouttonMoins=new JButton("-");
	JButton bouttonDiviser=new JButton("/");
	JButton bouttonMultiplier=new JButton("*");
	JButton bouttonEgale=new JButton("=");
	JButton bouttonC=new JButton("c");
	
	public  Graph1(){
		texte.setText("0");
		this.setTitle("calculatrice");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Box b1= Box.createVerticalBox();
		b1.add(bouttonDiviser);
		b1.add(bouttonMultiplier);
		b1.add(bouttonMoins);
		b1.add(bouttonPlus);
		
		JPanel monPanel=new JPanel();
		
		
		
		
	
		
	
		Box b2= Box.createHorizontalBox();
		
		b2.add(boutton7);
		b2.add(boutton8);
		b2.add(boutton9);
		
		
		Box b3= Box.createHorizontalBox();
		b3.add(boutton4);
		b3.add(boutton5);
		b3.add(boutton6);
		
		Box b4= Box.createHorizontalBox();
		
		b4.add(boutton1);
		
		b4.add(boutton2);
		b4.add(boutton3);
		
		Box b5= Box.createHorizontalBox();
		
		
		b5.add(boutton0);
		
		b5.add(bouttonVirgule);
		b5.add(bouttonEgale);
		Box b2345= Box.createVerticalBox();
		b2345.add(b2);
		b2345.add(b3);
		b2345.add(b4);
		b2345.add(b5);
		
		
		Box b1b2345=Box.createHorizontalBox();
		b1b2345.add(b2345);
		b1b2345.add(b1);
		
		Box b6=Box.createHorizontalBox();
		
		b6.add(bouttonC);
		Box btb1b2345=Box.createVerticalBox();
		btb1b2345.add(texte);
		btb1b2345.add(b1b2345);
		
		
		Box btb1b2345b6=Box.createVerticalBox();
		
		btb1b2345b6.add(btb1b2345);
		
		btb1b2345b6.add(b6);
		monPanel.add(btb1b2345b6);
		
		 
		boutton1.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		if (texte.getText().compareTo("0")==0)
			texte.setText("");
		
			 texte.setText(texte.getText()+"1");
			String a=texte.getText();
			System.out.println(a);
			}
		}
		);
		boutton2.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		if (texte.getText().compareTo("0")==0)
			texte.setText("");
			texte.setText(texte.getText()+"2");
			String a=texte.getText();
			System.out.println(a);
			}
		}
		);
		
		boutton3.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
			if (texte.getText().compareTo("0")==0)
			texte.setText("");
			texte.setText(texte.getText()+"3");
			String a=texte.getText();
			System.out.println(a);
			}
		}
		);
		boutton4.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		
			if (texte.getText().compareTo("0")==0)
			texte.setText("");
			texte.setText(texte.getText()+"4");
			String a=texte.getText();
			System.out.println(a);
		
		
			}
		}
		);
		boutton5.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		
		
			if (texte.getText().compareTo("0")==0)
			texte.setText("");
			texte.setText(texte.getText()+"5");
			String a=texte.getText();
			System.out.println(a);
		
		
			}
		}
		);
		boutton6.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		
			if (texte.getText().compareTo("0")==0)
			texte.setText("");
			texte.setText(texte.getText()+"6");
			String a=texte.getText();
			System.out.println(a);
		
		
			}
		}
		);
		boutton8.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		
		
			 if (texte.getText().compareTo("0")==0)
			texte.setText("");
			texte.setText(texte.getText()+"8");
			String a=texte.getText();
			System.out.println(a);
		
		
			}
		}
		);
		boutton7.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		
			if (texte.getText().compareTo("0")==0)
			texte.setText("");
			texte.setText(texte.getText()+"7");
			String a=texte.getText();
			System.out.println(a);
		
		
			}
		}
		);
		boutton9.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		
		
			 if (texte.getText().compareTo("0")==0)
			texte.setText("");
			texte.setText(texte.getText()+"9");
			String a=texte.getText();
			System.out.println(a);
		
		
			}
		}
		);
		boutton0.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		
			texte.setText(texte.getText()+"0");
		
		
			}
		}
		);
		bouttonVirgule.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		
			texte.setText(texte.getText()+".");
		
		
			}
		}
		);
		
		bouttonPlus.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		
			texte.setText(texte.getText()+"+");
		
		
			}
		}
		);
		bouttonMultiplier.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		
			texte.setText(texte.getText()+"*");
		
		
			}
		}
		);
		bouttonDiviser.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		
			texte.setText(texte.getText()+"/");
		
		
			}
		}
		);
		bouttonMoins.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		
			texte.setText(texte.getText()+"-");
		
		
			}
		}
		);
		bouttonC.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		
			texte.setText("0");
		
		
			}
		}
		);
		this.getContentPane().add(monPanel);
		this.setVisible(true);
	}
	public String getTexte(){
			String a=texte.getText();
			
			return a;
		}
	public  String setTexte(String a){
			texte.setText(a);
			
			return a;
		}
	 
}
/********File2/2:Calculatrice1.java***********/
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 class Calculatrice extends Graph1{
	String expression,arg1,arg2,operateur;
	int localisation;
	double a,b;
	
	
	Calculatrice(){
		
		String plus="+";
		String moins="-";
		String multiplier="*";
		String diviser="/";
		System.out.print("Tapez votre operation a 2 nombres ex:a(+,-,* ou /)b  : ");
		
		
		bouttonEgale.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) { 
		double resultat=0.0;
			
		 expression=getTexte();
		
		localisation= expression.indexOf(plus);
		if (localisation==-1)
			localisation= expression.indexOf(moins);
		if (localisation==-1)
			localisation= expression.indexOf(multiplier);
		if (localisation==-1)
			localisation= expression.indexOf(diviser);	
		else System.out.println("echec");
		
		arg1=expression.substring(0,localisation);
		arg2=expression.substring(localisation+1,expression.length());
		operateur=expression.substring(localisation,localisation+1);
		System.out.println("argument1: "+arg1+" argument2: "+arg2+" operateur: "+operateur);
		a=Double.parseDouble(arg1);
		b=Double.parseDouble(arg2);
		if (operateur.compareTo(plus)==0)
			
		System.out.println("total= "+(resultat=a+b));
		else
			if (operateur.compareTo(moins)==0)
		System.out.println("total= "+(resultat=a-b));
			else
				if(operateur.compareTo(multiplier)==0)
		System.out.println("total= "+(resultat=a*b));
				else
					if (operateur.compareTo(diviser)==0)
		System.out.println("total= "+(resultat=a/b));
	texte.setText(""+resultat);
			}
			
			
		});
		
	}
 }
 public class Calculatrice1{
	public static void main (String [] args){
		Calculatrice cal=new Calculatrice();
		
		
	}
 }

