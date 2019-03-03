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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class ChaXun extends JFrame{
	public static final int Width=320;
	public static final int Heigth=320;
	
	Button btn,btn2;
	JTextField jt,jt2,jt3;
	
	public ChaXun(){
		setSize(Width,Heigth);
		setLocation(820,200);
		setTitle(new String("��ѯ��"));
		setLayout(new FlowLayout());
		
		Container con=getContentPane();
		
		jt=new JTextField(20);
		Label lb=new Label("ѧ�ţ�");
		
		btn=new Button("ȷ��");
		btn.addActionListener(new Enter());
		
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
				
				Connection sin=ShujuC.getconnection();
				String sno=jt.getText();
				ResultSet rs=null;
				PreparedStatement stmt=null;
				
				String sql="select * from student where sno=?";
				try {
					stmt=sin.prepareStatement(sql);
					stmt.setObject(1, sno);
					rs=stmt.executeQuery();
					
					while(rs.next()){
						String msg=rs.getString("sno")+"\t"+rs.getString("sname")+"\t"+rs.getString("ssex")+"\t"+rs.getString("sage")+"\t"+rs.getString("sclass")+"\t"+rs.getString("smajor")+"\n";						
						JOptionPane.showMessageDialog(null, msg,"��ѯ���",JOptionPane.NO_OPTION);						
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			dispose();
		}
		
	}
}
