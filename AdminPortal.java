import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class AdminPortal extends JFrame implements ActionListener{
	           
	           public FacultySignup f_sup;
	           public StudentSignup s_sup;
	           public AdminSignup ad_sup;
	           public AccountSignup acc_sup ;
	           public ViewAdmin va ;
	           public ViewStudent vs ;
	           public ViewAccount vacc ;
	           public ViewFaculty vf ;
	           public AboutAdmin aa ;
			   
			   private AdminLogin ad_L;
			   
			   MenuBar mb;
			   Menu FileMenu,EditMenu,SearchMenu,ViewMenu;
	           MenuItem save,saveas,print,open,exit;
			    MenuItem aboutme,viewadmin,viewstudent,viewaccount,viewfaculti;
			   
			   
	          public AdminPortal(AdminLogin al){
		   super("ADMIN PORTAL");
		
		          ad_L=al;
				  aa=new AboutAdmin(this);
		 
		 
		 mb= new MenuBar();
         FileMenu =	new	 Menu("File");
		 EditMenu = new	 Menu("Edit");
		 SearchMenu = new Menu("Search");
		 ViewMenu = new	 Menu("View");
		
		save= new MenuItem("Save");
		 saveas= new MenuItem("Save as");
		 print= new MenuItem("Print");
		 open= new MenuItem("Open");
		 exit= new MenuItem("Exit");
		 aboutme= new MenuItem("About me ?");		 
		 viewadmin= new MenuItem("View Admin");
		 viewstudent= new MenuItem("View Student");
		 viewaccount= new MenuItem("View Account");
		 viewfaculti= new MenuItem("View Faculty");
		 
		 FileMenu.add(save);FileMenu.add(saveas);FileMenu.add(print);FileMenu.add(exit);
		
		ViewMenu.add(aboutme);ViewMenu.add(viewadmin);ViewMenu.add(viewstudent);ViewMenu.add(viewfaculti);ViewMenu.add(viewaccount);
		 
		 mb.add(FileMenu); mb.add(EditMenu ); mb.add(SearchMenu); mb.add( ViewMenu);
		 
		      f_sup=new FacultySignup(this);
		      s_sup= new StudentSignup(this);
		      ad_sup= new AdminSignup(this);
		      acc_sup= new AccountSignup(this);
			  va=new ViewAdmin(this);
			  vs=new ViewStudent(this);
			  vf=new ViewFaculty(this);
			  vacc=new ViewAccount(this);
			  aa=new AboutAdmin(this);
		
		JButton b=new JButton("CreateStudent");
		JButton b1=new JButton("CreateFaculty");
		JButton b2=new JButton("CreateAdmin");
		JButton b3=new JButton("CreateAccountant");
		JButton b4=new JButton("Back");
		
		add(b);add(b1);add(b2);add(b3);add(b4);
		
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b.setBounds(135,50,200,40);
		b1.setBounds(135,90,200,40);
		b2.setBounds(135,140,200,40);
		b3.setBounds(135,190,200,40);
		b4.setBounds(190,240,100,40);
		exit.addActionListener(this);
		viewadmin.addActionListener(this);
		viewstudent.addActionListener(this);
		viewfaculti.addActionListener(this);
		viewaccount.addActionListener(this);
		
		setSize(500,600);
		setLayout(null);
		setMenuBar(mb);
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("CreateStudent")){
			this.setVisible(false);
			s_sup.setVisible(true);
		}
		else if(s.equals("CreateFaculty")){
			
			this.setVisible(false);
			f_sup.setVisible(true);
			
		}
		else if(s.equals("CreateAdmin")){
			this.setVisible(false);
			ad_sup.setVisible(true);
		
		}
		else if(s.equals("CreateAccountant")){
			this.setVisible(false);
			acc_sup.setVisible(true);
		}
		else if(s.equals("Back"))
		{
			ad_L.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Exit"))
		{
			System.exit(0);
			
		}
		else if(s.equals("View Admin"))
		{
			va.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("View Student"))
		{
			vs.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("View Faculty"))
		{
			vf.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("View Account"))
		{
			vacc.setVisible(true);
			this.setVisible(false);
		}
		
		else if(s.equals("About me ?"))
		{
			this.setVisible(false);
			aa.setVisible(true);
		}
		
	}
	
}