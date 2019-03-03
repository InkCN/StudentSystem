package studentsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class CaoZuoJieMian extends JFrame implements ActionListener{

	JPanel contentPane;
	BorderLayout borderLayout1 =new BorderLayout(5,10);
	Label prompt;
	JTextField stm;
	Button run;
	public static final TextArea result =new TextArea();
	
	public CaoZuoJieMian(){
		contentPane=(JPanel) this.getContentPane();
		contentPane.setLayout(borderLayout1);
		this.setTitle("ѧ����Ϣ����ϵͳ");
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			System.exit(0);
			}
		});
		
		prompt=new Label("ִ�����");
		run=new Button("��ʼִ��");
		result.setEditable(false);
		
		stm=new JTextField(100);
		
		JPanel option=new JPanel();
		Button zenjia=new Button("���ӣ�add��");
		option.add(zenjia,BorderLayout.NORTH);
		zenjia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==zenjia){
					Zenjia add1=new Zenjia();
					add1.setVisible(true);
				}
			}
		});
		zenjia.addActionListener(this);
		
		Button shanchu=new Button("ɾ����delet��");
		option.add(shanchu,BorderLayout.NORTH);
		shanchu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==shanchu){
					Shanchu dt1=new Shanchu();
					dt1.setVisible(true);
				}
			}
		});
		shanchu.addActionListener(this);
		
		Button xiugai=new Button("�޸ģ�alter��");
		option.add(xiugai,BorderLayout.NORTH);
		xiugai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==xiugai){
					XiuGai af=new XiuGai();
					af.setVisible(true);
				}
			}
		});
		xiugai.addActionListener(this);
		
		Button cx=new Button("��ѯ��query��");
		option.add(cx,BorderLayout.NORTH);
		cx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==cx){
					ChaXun cj=new ChaXun();
					cj.setVisible(true);
				}
			}
		});
		cx.addActionListener(this);
		
		Button chaxun=new Button("ˢ�£�refresh��");
		option.add(chaxun,BorderLayout.NORTH);
		chaxun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==chaxun){
					Connection sin=ShujuC.getconnection();
					ResultSet rs=ShujuC.query(sin);
					try {
						result.setText("ˢ�³ɹ�\n\n\n");
						while(rs.next()){
							String msg=rs.getString("sno")+"\t"+rs.getString("sname")+"\t"
									+rs.getString("ssex")+"\t"+rs.getString("sage")+"\t"+rs.getString("sclass")
									+"\t"+rs.getString("smajor")+"\n";
							result.append(msg);
						}
						sin.close();
						rs.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		chaxun.addActionListener(this);	
		
		Button tuichu=new Button("�˳���quit��");
		option.add(tuichu,BorderLayout.NORTH);
		tuichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==tuichu){
					System.exit(0);
				}
			}
		});
		tuichu.addActionListener(this);
		
		//���沼��
		contentPane.add(prompt,borderLayout1.WEST);
		contentPane.add(stm,borderLayout1.CENTER);
		contentPane.add(run,borderLayout1.EAST);
		contentPane.add(result,borderLayout1.SOUTH);
		contentPane.add(option,borderLayout1.NORTH);
		
		run.addActionListener(this);		
	}
	
	public void actionPerformed(ActionEvent e) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		if(e.getSource()==run){
		
				try {
					con = ShujuC.getconnection();
					String msg1 = "���ӳɹ�";
					result.setText("���ӳɹ�\n\n\n");
					String yuju = stm.getText();
					st = con.createStatement();
					rs = st.executeQuery(yuju);
					while (rs.next()) {
						String msg = rs.getString("sno") + "\t" + rs.getString("sname") + "\t" + rs.getString("ssex")
								+ "\t" + rs.getString("sage") + "\t" + rs.getString("sclass") + "\t"
								+ rs.getString("smajor") + "\n";
						result.append(msg);
					} 
				} catch (SQLException sqle) {
					result.setText(sqle+"lianjiecuowu");
				}catch (Exception h) {
					h.printStackTrace();
				}finally{
					try{
						rs.close();
						st.close();
						con.close();
					}catch(SQLException e1){
						e1.printStackTrace();
					}
				}			
		}
	}

}
