import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class AccountPortal extends JFrame implements ActionListener{
	           
             
              private AccountLogin sl;
			   MenuBar mb;
			   Menu FileMenu,EditMenu,SearchMenu,ViewMenu;
	           MenuItem save,saveas,print,open,exit;
			    MenuItem aboutme;
				private AboutAccount as;
			   
			   
	          public AccountPortal(AccountLogin al){
		   super("Account PORTAL");
		
		          sl=al;
				  as=new AboutAccount(this);
		 
		 
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
		 
		 
		 FileMenu.add(save);FileMenu.add(saveas);FileMenu.add(print);FileMenu.add(exit);
		
		ViewMenu.add(aboutme);
		 
		 mb.add(FileMenu); mb.add(EditMenu ); mb.add(SearchMenu); mb.add( ViewMenu);
		 
		
		
		JButton b4=new JButton("Back");
		add(b4);
		b4.addActionListener(this);
		exit.addActionListener(this);
		aboutme.addActionListener(this);
		
		setSize(500,600);
		setLayout(new FlowLayout());
		setMenuBar(mb);
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		
		 if(s.equals("Back"))
		{
			sl.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Exit"))
		{
			System.exit(0);
			
		}
		else if(s.equals("About me ?"))
		{
	
		    this.setVisible(false);
			as.setVisible(true);
		}
		
	}
	
}