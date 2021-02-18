////////////////

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;



class AboutAccount extends JFrame implements ActionListener{
	     private JTextField tf;
		 private AccountPortal sp;
	public AboutAccount(AccountPortal t){
		super(" My Info");
		sp=t;
		tf=new JTextField(30);
		JLabel l=new JLabel("Input Password");
		JButton b=new JButton("Back");
		JButton b2=new JButton("Ok");
		add(l);add(tf);
		add(b);add(b2);
		setSize(600,400);
		setLayout(new FlowLayout());
		b.addActionListener(this);
		b2.addActionListener(this);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		
		     if(s.equals("Back")){
			this.setVisible(false);
			sp.setVisible(true);
		}
		
		 else if(s.equals("Ok")){
			System.out.println("ys");
			DefaultTableModel model= new DefaultTableModel(0,7);
		JTable table= new JTable(model);
		String header[]={"S_ID" , "S_Name", "Department", "Gender", "Date Of Birth", "Address", "password"};
		model.setColumnIdentifiers(header);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery("select * from account where password='"+tf.getText()+"';");
			
			while(rs.next()){
				String s1 =rs.getString(1);
				String s2 =rs.getString(2);
				String s3 =rs.getString(3);
				String s4 =rs.getString(4);
				String s5 =rs.getString(5);
				String s6 =rs.getString(6);
				String s7 =rs.getString(7);
				model.addRow(new Object[] {s1,s2,s3,s4,s5,s6,s7});
				
				
			}
		}
		catch(Exception ex){
			
			System.out.println(ex);
		}
		
		
		JScrollPane pane= new JScrollPane(table);
         add(pane);
			
			
		}
	}
	
}