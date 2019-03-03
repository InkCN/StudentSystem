package studentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ShujuC {

	public final static Connection getconnection() {
		Connection con=null;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/wtf";
		String user="root";
		String password="123456";
		try {
			
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			con.setCatalog("wtf");
			
		} catch (ClassNotFoundException b) {
			System.out.println(b+"连接错误");
		} catch (SQLException e) {
			System.out.println(e+"第二个错误");
		}
		return con;
	}
	public final static void insert(Connection con,Object obj[]){
		PreparedStatement stmt=null;
		try {
			String sql="insert into student(sno,sname,ssex,sage,sclass,smajor) values(?,?,?,?,?,?)";
			stmt=con.prepareStatement(sql);

			stmt.setString(1, obj[0].toString());
			stmt.setString(2, obj[1].toString());
			stmt.setString(3, obj[2].toString());
			stmt.setString(4, obj[3].toString());
			stmt.setString(5, obj[4].toString());
			stmt.setString(6, obj[5].toString());
			stmt.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "失败","操作提示",JOptionPane.NO_OPTION);
		}
	}
	
	public static ResultSet query(Connection con) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		String sql="select * from student";
		try {
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return rs;
	}
	
	public final static void delete(Connection con,String s){
		PreparedStatement stmt;
		String sql="delete from student where sno=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setObject(1,s);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}
}
