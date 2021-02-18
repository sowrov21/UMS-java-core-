import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;



class ViewFaculty extends JFrame implements ActionListener{
	
	     private JTable table;
		 private JLabel l;
		 private DefaultTableModel model;
		 private AdminPortal h;
		 private UpdateFaculty uf;
	
	public ViewFaculty(AdminPortal t){
		super(" All Facultay Informatin");
		h=t;
		l= new JLabel("Want to Update ?");
		Button b=new Button("Back");
		Button b2=new Button("Go to Update");
		
		uf=new UpdateFaculty(this);
		
		add(l);add(b2);add(b);
		setSize(600,400);
		setLayout(new FlowLayout());
		b.addActionListener(this);
		b2.addActionListener(this);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		model= new DefaultTableModel(0,2);
		table= new JTable(model);
		String header[]={"F_ID" , "F_Name","Gender","Skill","J_Date","DOB","Address","Password",};
		model.setColumnIdentifiers(header);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery("select * from faculty;");
			
			while(rs.next()){
				String s1 =rs.getString(1);
				String s2 =rs.getString(2);
				String s3 =rs.getString(3);
				String s4 =rs.getString(4);
				String s5 =rs.getString(5);
				String s6 =rs.getString(6);
				String s7 =rs.getString(7);
				String s8 =rs.getString(8);
				model.addRow(new Object[] {s1,s2,s3,s4,s5,s6,s7,s8});
				
				
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
		  else if(s.equals("Go to Update")){
			this.setVisible(false);
			uf.setVisible(true);
		}
	}
	
}