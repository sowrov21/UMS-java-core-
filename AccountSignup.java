import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
public class AccountSignup extends JFrame implements ActionListener{
	private TextField tf;
	private TextField tf2;
	private TextField tf3;
	private TextField tf4;
	private TextField tf5;
	private TextField tf6;
	private TextField tf7;
	private Choice c;
	private AdminPortal h;
	public AccountSignup(AdminPortal t){
		super("Account Signup Window");
		h=t;
		Label l=new Label("Account ID");
		Label l2=new Label("Account Name");
		Label l3=new Label("Gender");
		Label l4=new Label("Join Date");
		Label l5=new Label("Date of Birth");
		Label l6=new Label("Address");
		Label l7=new Label("password");
	
		tf=new TextField(30);
		tf2=new TextField(30);
		tf3=new TextField(30);
		tf4=new TextField(30);
		tf5=new TextField(30);
		tf6=new TextField(30);
		tf7=new TextField(30);
		JButton b=new JButton("Add info");
		JButton b2=new JButton("Back");
		JButton b3=new JButton("Ok Gen");
		c=new Choice();c.add("Male");c.add("Female");
		add(l);add(tf);
		add(l2);add(tf2);
		add(l3);add(c);add(b3);add(tf3);
		add(l4);add(tf4);
		add(l5);add(tf5);
		add(l6);add(tf6);
		add(l7);add(tf7);
		add(b);add(b2);
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(280,530);
		
	}
	
	public void actionPerformed(ActionEvent ae){
	
		
		String s=ae.getActionCommand();
		      
			   
		if(s.equals("Ok Gen")){
				  tf3.setText(c.getSelectedItem());
			  }
		
		else if(s.equals("Add info")){
			
			if(tf.getText().length()!=0 && tf2.getText().length()!=0 && tf3.getText().length()!=0 && tf4.getText().length()!=0 && tf5.getText().length()!=0 && tf6.getText().length()!=0 && tf7.getText().length()!=0){
				
			String q="insert into account values('"+tf.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"','"+tf7.getText()+"')";
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