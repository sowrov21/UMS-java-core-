import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
public class AdminLogin extends JFrame implements ActionListener{
	private TextField tf;
	private TextField tf2;
	private Home h;
	private AdminPortal h2;
	public  AdminLogin(Home t){
		super(" Admin Login Window");
		h=t;
		h2 = new AdminPortal(this);
		Label l=new Label("User ID");
		Label l2=new Label("Password");
		tf=new TextField(28);
		tf2=new TextField(28);
		//tf2.setEchoChar('*');
		JButton b=new JButton("Login");
		JButton b2=new JButton("Back");
		add(l);add(tf);
		add(l2);add(tf2);
		add(b);add(b2);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(280,400);
		//setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		
		if(s.equals("Login")){
			int count=0;
			DataAccess da=new DataAccess();
			String typedName=tf.getText();
			String typedPass=tf2.getText();
			if(tf.getText().length()==0||tf2.getText().length()==0){
				//System.out.println("Wrong Input ! Textfields cannot be empty");
				JOptionPane.showMessageDialog(this,"Wrong Input ! Textfields cannot be empty");
			}
			else
			{String q="";
			q="select * from admin where id='"+typedName+"' and password='"+typedPass+"'";
			ResultSet rs=null;
			System.out.println("Button pressed");		
			try{
				rs=da.getData(q);
				System.out.println(q);
				while(rs.next()){
					String n = rs.getString("id");
					String p= rs.getString("password");
					if(n.equals(typedName) && p.equals(typedPass)){
						this.setVisible(false);
						h2.setVisible(true);
						count=1;
						
						tf.setText(null);
						tf2.setText(null);
						break;
					}
					
				}
				if(count==0)
			       {
					JOptionPane.showMessageDialog(this,"ID or Password Not Match");
					    tf.setText(null);
						tf2.setText(null);
				   }
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(this,"Database Error !");
				//ex.printStackTrace();
			}
		  }
		}
		
		
		else if(s.equals("Back")){
			this.setVisible(false);
			h.setVisible(true);
		}
		
	}
}