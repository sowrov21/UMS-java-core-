import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
public class FacultySignup extends JFrame implements ActionListener{
	private TextField tf;
	private TextField tf2;
	private TextField tf3;
	private TextField tf4;
	private TextField tf5;
	private TextField tf6;
	private TextField tf7;
	private TextField tf8;
	//private Choice c;
	private Choice c2;
	private AdminPortal h;
	public FacultySignup(AdminPortal t){
		super("Faculty Signup Window");
		h=t;
		Label l=new Label("Faculty ID");
		Label l2=new Label("Faculty Name");
		Label l3=new Label("Gender");
		Label l4=new Label("Skill In");
		Label l5=new Label("Join Date");
		Label l6=new Label("Date of Birth");
		Label l7=new Label("Address");
		Label l8=new Label("Password");
	
		tf=new TextField(30);
		tf2=new TextField(30);
		tf3=new TextField(30);
		tf4=new TextField(30);
		tf5=new TextField(30);
		tf6=new TextField(30);
		tf7=new TextField(30);
		tf8=new TextField(30);
		JButton b=new JButton("Add info");
		JButton b2=new JButton("Back");
		JButton b4=new JButton("Ok Gen");
		c2=new Choice();c2.add("Male");c2.add("Female");
		add(l);add(tf);
		add(l2);add(tf2);
		add(l3);add(c2);add(b4);add(tf3);
		add(l4);add(tf4);
		add(l5);add(tf5);
		add(l6);add(tf6);
		add(l7);add(tf7);
		add(l8);add(tf8);
		add(b);add(b2);
		b.addActionListener(this);
		b2.addActionListener(this);
		b4.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(280,530);
	}
	
	public void actionPerformed(ActionEvent ae){
	
		
		String s=ae.getActionCommand();
		      	   
		if(s.equals("Ok Gen")){
				  tf3.setText(c2.getSelectedItem());
			  }
		
		else if(s.equals("Add info")){
			
			if(tf.getText().length()!=0 && tf2.getText().length()!=0 && tf3.getText().length()!=0 && tf4.getText().length()!=0 && tf5.getText().length()!=0 && tf6.getText().length()!=0 && tf7.getText().length()!=0 && tf8.getText().length()!=0){
				
			String q="insert into faculty values('"+tf.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"','"+tf7.getText()+"','"+tf8.getText()+"')";
			System.out.println(q);
			DataAccess da=new DataAccess();
			da.updateDB(q);
			JOptionPane.showMessageDialog(this,"Success ! new row(s) updated");
			    tf.setText(null);
				tf2.setText(null);
				tf3.setText(null);
				tf4.setText(null);
				tf5.setText(null);
				tf6.setText(null);
				tf7.setText(null);
				tf8.setText(null);
			}
			else{
				JOptionPane.showMessageDialog(this,"Wrong Input ! Textfields cannot be empty");
			}
			
		}
		
		else if(s.equals("Back")){
			this.setVisible(false);
			h.setVisible(true);
		}
		
	}
	
}