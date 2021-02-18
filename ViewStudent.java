import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;



class ViewStudent extends JFrame implements ActionListener{
	
	     private JTable table;
		 private DefaultTableModel model;
		 private AdminPortal h;
		 private JLabel l;
		 private UpdateStudent us;
	
	public ViewStudent (AdminPortal t){
		super(" All Students Informatin");
		h=t;
		us=new UpdateStudent(this);
		l= new JLabel("Want to Update ?");
		Button b=new Button("Back");
		Button b2=new Button("Go to Update");
		
		add(l);add(b2);add(b);
		setSize(600,400);
		setLayout(new FlowLayout());
		b.addActionListener(this);
		b2.addActionListener(this);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		model= new DefaultTableModel(0,7);
		table= new JTable(model);
		String header[]={"S_ID" , "S_Name", "Department", "Gender", "Date Of Birth", "Address"};
		model.setColumnIdentifiers(header);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery("select id,s_name,dept,gender,dob,address from student ;");
			
			while(rs.next()){
				String s1 =rs.getString(1);
				String s2 =rs.getString(2);
				String s3 =rs.getString(3);
				String s4 =rs.getString(4);
				String s5 =rs.getString(5);
				String s6 =rs.getString(6);
				//String s7 =rs.getString(7);
				model.addRow(new Object[] {s1,s2,s3,s4,s5,s6});
				
				
			}
		}
		catch(Exception ex){
			
			System.out.println(ex);
		}
		
		
		JScrollPane pane= new JScrollPane(table);
         add(pane);
		
		
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		
		     if(s.equals("Back")){
			this.setVisible(false);
			h.setVisible(true);
		}
		 if(s.equals("Go to Update")){
			this.setVisible(false);
			us.setVisible(true);
		}
	}
	
}