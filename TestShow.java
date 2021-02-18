import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class TestShow extends Frame implements ActionListener{
	private TextArea ta;
	private Frame parent;
	private Home h;
	public TestShow(Home hm){
		super("Java Calculator");
		h=hm;
		Label l=new Label("Data From DB");
		ta=new TextArea(5,30);
		Button b=new Button("Show");
		Button b2=new Button("Exit");
		add(l);add(ta);
		add(b);add(b2);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(270,400);
		setLocation(800,200);
		//setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		System.out.println(ta.getText());
		ta.setText("");
		if(s.equals("Show")){
			try{
				DataAccess da=new DataAccess();
				ResultSet rs=null;
				rs=da.getData("select id,password from student");
				while(rs.next()){
					String str=rs.getString("id")+":"+rs.getString("password");
					ta.append(str+"\n");
				}
			}catch(Exception ex){ex.printStackTrace();}
			//ta.append("my text\n");
		}
		else if(s.equals("Exit")){
			System.exit(0);
		}
		
	}
}