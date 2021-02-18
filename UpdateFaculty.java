import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;



class UpdateFaculty extends JFrame implements ActionListener{
	
	              private JTextField tf,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
				  private JButton b,b2;
				  
				  private ViewFaculty vf;
	
	public UpdateFaculty(ViewFaculty t){
		
		super("Update Facultay Info");
		vf=t;
		Label l=new Label("Faculty ID");
		Label l2=new Label("Faculty Name");
		Label l3=new Label("Gender");
		Label l4=new Label("Skill In");
		Label l5=new Label("Join Date");
		Label l6=new Label("Date of Birth");
		Label l7=new Label("Address");
		Label l8=new Label("Password");
		
		tf=new JTextField(15);
		tf2=new JTextField(15);
		tf3=new JTextField(15);
		tf4=new JTextField(15);
		tf5=new JTextField(15);
		tf6=new JTextField(15);
		tf7=new JTextField(15);
		tf8=new JTextField(15);
		
	    b=new JButton("Update");
	    b2=new JButton("Back");
		
		
		add(l);add(tf);
		add(l2);add(tf2);
		add(l3);add(tf3);
		add(l4);add(tf4);
		add(l5);add(tf5);
		add(l6);add(tf6);
		add(l7);add(tf7);
		add(l8);add(tf8);
		add(b);add(b2);
		
		setSize(300,530);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		b.addActionListener(this);
		b2.addActionListener(this);
		//setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		
		     if(s.equals("Back")){
			this.setVisible(false);
			vf.setVisible(true);
		}
		  else if(s.equals("Update")){
			  
			  if(tf.getText().length()!=0 && tf2.getText().length()!=0 && tf3.getText().length()!=0 && tf4.getText().length()!=0 && tf5.getText().length()!=0 && tf6.getText().length()!=0 && tf7.getText().length()!=0 && tf8.getText().length()!=0){
				  
				  
	 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			Statement st= con.createStatement();
			String str= "UPDATE faculty SET f_name='"+tf2.getText()+"',gender='"+tf3.getText()+"',skill='"+tf4.getText()+"',join_date='"+tf5.getText()+"',dob='"+tf6.getText()+"',address='"+tf7.getText()+"',password='"+tf8.getText()+"' WHERE id='"+tf.getText()+"';";
			int i=st.executeUpdate(str);
			if(i==1)
			{
				JOptionPane.showMessageDialog(null,"Successfully update !");
				
				tf.setText(null);
				tf2.setText(null);
				tf3.setText(null);
				tf4.setText(null);
				tf5.setText(null);
				tf6.setText(null);
				tf7.setText(null);
				tf8.setText(null);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Id not found !");
			}
			
			
		}
		catch(Exception ex){
			
			//JOptionPane.showMessageDialog(this,"Database Error !");
			System.out.println(ex);
		}
			  
			
			}
			else{
				JOptionPane.showMessageDialog(this,"Wrong Input ! Textfields cannot be empty");
			}
			  
			 
		}
	}
	
}