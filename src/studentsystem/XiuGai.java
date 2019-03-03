package studentsystem;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class XiuGai extends JFrame{
	public static final int Width=320;
	public static final int Heigth=320;

	Button btn,btn2;
	JTextField jt,jt2,jt3;
	
	public XiuGai(){
		setSize(Width, Heigth);
		setLocation(820,200);
		setTitle(new String("修改："));
		setLayout(new FlowLayout());
		Container con=getContentPane();
		
		jt=new JTextField(20);
		Label lb=new Label("学号：");
		btn=new Button("确定");
		btn.addActionListener(new Enter());
		btn2=new Button("取消");
		
		add(lb);
		add(jt);
		
		add(btn);
		add(btn2);
	}
	class Enter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Container con=getContentPane();
			if(e.getActionCommand().equals("确定")){
				con.setBackground(Color.red);
				
				Connection sin=ShujuC.getconnection();
				String sno=jt.getText();
				
				
				try {
					PreparedStatement stmt;
					stmt=sin.prepareStatement("delete from student where sno=?");
					stmt.setObject(1, sno);
					stmt.execute();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				Tianjia tg=new Tianjia();
				tg.setVisible(true);
			}
		}
		
	}
}
