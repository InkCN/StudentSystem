package studentsystem;

/*
 * ��¼����
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
@SuppressWarnings("serial")
public class Login extends JFrame {

	public static void main(String[] args) {
		Login denglujiemian = new Login();
		denglujiemian.setIconImage(Toolkit.getDefaultToolkit()
				.createImage("C:/Users/Administrator/workspace/StudentSystem/src/beijing.jpg"));
		denglujiemian.setTitle("��¼");
		denglujiemian.setLocation(600, 300);
		denglujiemian.setSize(500, 351);
		denglujiemian.setVisible(true);
	}

	JTextField yonghuming;
	JTextField mimakuang;
	JButton dengluanniu;
	JButton chongzhianniu;

	String imgePath = "C:/Users/Administrator/workspace/StudentSystem/src/beijing.jpg";// ����ͼƬ·��
	JPanel p5;
	Image img = Toolkit.getDefaultToolkit().createImage(imgePath);// ������ͼƬ

	Login() {
		Container rongqi = getContentPane();// ��������

		Label yonghutiao = new Label("�û���");
		Label mimatiao = new Label("���룺");

		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		p5 = new JPanel() {
			protected void paintChildren(Graphics g) {
				g.drawImage(img, 0, 0, this);
				super.paintChildren(g);
			}
		};

		yonghuming = new JTextField(15);
		mimakuang = new JPasswordField(15);

		dengluanniu = new JButton("��¼");
		chongzhianniu = new JButton("����");

		p2.add(yonghutiao);
		p2.add(yonghuming);

		p2.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));

		p3.add(mimatiao);
		p3.add(mimakuang);

		p3.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));

		p4.add(dengluanniu);
		p4.add(chongzhianniu);

		p5.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		p5.add(p2);
		p5.add(p3);
		p5.add(p4);

		rongqi.add(p5, BorderLayout.CENTER);

		dengluanniu.addActionListener(new Enter());
		chongzhianniu.addActionListener(new ReWrite());
		addWindowListener(new winClose());
	}

	class Enter implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if ((yonghuming.getText()) != null && (mimakuang.getText()) != null) {
				JOptionPane.showMessageDialog(null, "�ɹ�");

				CaoZuoJieMian frame = new CaoZuoJieMian();
				frame.setIconImage(Toolkit.getDefaultToolkit()
						.createImage("C:/Users/Administrator/workspace/StudentSystem/src/beijing.jpg"));
				// ��������Ǵ����ϵ�ʡ��ͼ

				frame.setLocation(400, 200);
				frame.setSize(500, 285);
				frame.setVisible(true);
				dispose();
			}
		}
	}

	class ReWrite implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			yonghuming.setText("");
			mimakuang.setText("");
			yonghuming.requestFocus(); // ���뼯�е�yonghuming
		}
	}

	class winClose extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			(e.getWindow()).dispose();
			System.exit(0);
		}
	}
}
