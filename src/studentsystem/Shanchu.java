package studentsystem;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Shanchu extends JFrame{
	public static final int Width=320;
	public static final int Heigth=230;
	
	Button btn,btn2;
	JTextField jt,jt2,jt3;
	
	public Shanchu(){
		setSize(Width,Heigth);
		setLocation(820,200);
		setTitle(new String("ɾ��"));
		setLayout(new FlowLayout());
		
		Container con=getContentPane();
		jt=new JTextField(20);
		Label lb=new Label("ѧ�ţ�");
		btn=new Button("ȷ��");
		btn.addActionListener((ActionListener) new Enter());
		btn2=new Button("ȡ��");
		
		add(lb);
		add(jt);
		
		add(btn);
		add(btn2);
		
	}
	class Enter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Container con=getContentPane();
			if(e.getActionCommand().equals("ȷ��")){
				con.setBackground(Color.red);
				String sno=jt.getText();
				Connection sin=ShujuC.getconnection();
				ShujuC.delete(sin, sno);
				JOptionPane.showMessageDialog(null, "��Ϣɾ���ɹ���","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		}
		
	}
}
