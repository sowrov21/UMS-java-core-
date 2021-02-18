import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;



class ViewAdmin extends JFrame implements ActionListener{
	
	     private JTable table;
		 private DefaultTableModel model;
		 private AdminPortal h;
	
	public ViewAdmin (AdminPortal t){
		super(" All Admin Informatin");
		h=t;
		Button b=new Button("Back");
		add(b);
		setSize(600,400);
		setLayout(new FlowLayout());
		b.addActionListener(this);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		model= new DefaultTableModel(0,2);
		table= new JTable(model);
		String header[]={"id" , "password"};
		model.setColumnIdentifiers(header);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery("select * from admin;");
			
			while(rs.next()){
				String s1 =rs.getString(1);
				String s2 =rs.getString(2);
				System.out.println(" --------- ");
				System.out.println("  ADMIN DB ");
				System.out.println(" --------- ");
				System.out.println(s1+" "+s2);
				model.addRow(new Object[] {s1,s2});
				
				
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
	}
	
}