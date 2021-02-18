import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;



class Home extends JFrame implements ActionListener, WindowListener{
	
	           public FacultyLogin fl;
	           public StudentLogin sl;
	           public AdminLogin adl;
	           public AccountLogin accl ;
			   public TestShow TS;
			   
	
	           
	          public Home(){
		
		super("UNIVERSITY MANAGEMANT SYSTEM");
		      fl=new FacultyLogin(this);
		      sl= new StudentLogin(this);
		      adl= new AdminLogin(this);
		      accl= new AccountLogin(this);
			  TS= new TestShow(this);
		
		JButton b=new JButton("STUDENTS");
		JButton b1=new JButton("FACULTY");
		JButton b2=new JButton("ADMINISTRATOR");
		JButton b3=new JButton("ACCOUNT");
		b.setBounds(30,500,100,40);
		b1.setBounds(135,500,100,40);
		b2.setBounds(240,500,115,40);
		b3.setBounds(360,500,100,40);
		
		add(b);add(b1);add(b2);add(b3);
		
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		addWindowListener(this);
		BufferedImage img = null;
        try {
            img = ImageIO.read(new File("aiub.png"));
            } 
		catch (IOException e) {
            e.printStackTrace();
        }
        Image backImg = img.getScaledInstance(300,300, Image.SCALE_SMOOTH);
        ImageIcon backImageIcon = new ImageIcon(backImg);
        
        setLayout(new BorderLayout());
        JLabel back=new JLabel(backImageIcon);
        add(back);
        back.setLayout(new FlowLayout());
     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,700);
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("STUDENTS")){
			this.setVisible(false);
			sl.setVisible(true);
		}
		else if(s.equals("FACULTY")){
			
			this.setVisible(false);
			fl.setVisible(true);
			
		}
		else if(s.equals("ADMINISTRATOR")){
			this.setVisible(false);
			adl.setVisible(true);
		
		}
		else if(s.equals("ACCOUNT")){
			this.setVisible(false);
			accl.setVisible(true);
		}
		else if(s.equals("Testing Show")){
			this.setVisible(false);
			TS.setVisible(true);
		}
		
	}
	
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e)
	    {
	      System.exit(0);
		}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	
	/*public void paint(Graphics g){
		g.setColor(Color.CYAN);
		g.fillRect(0,0,500,600);
		
	}*/
}