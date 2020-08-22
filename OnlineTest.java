import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; 
import java.lang.*;
import javax.swing.Timer;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Formatter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;  
import java.io.BufferedWriter;



class Register extends JFrame implements ActionListener
{
	private Container c; 
	private JLabel name; 
	private JTextField tname; 
	private JLabel mno; 
	private JTextField tmno;
	private JCheckBox term; 
	private JButton sub; 
	private JButton reset; 
	private JLabel res; 
	private Login login;
	public Register(Login login) 
	{ 
		getContentPane().setBackground(Color.GREEN);
		this.login = login;
		setLocation(250,100);
		setVisible(true);
		setSize(800,450);
		setTitle("Registration Form"); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 

		c = getContentPane(); 
		c.setLayout(null); 

		name = new JLabel("NAME"); 
		name.setFont(new Font("Arial", Font.PLAIN, 20)); 
		name.setSize(150, 20); 
		name.setLocation(50, 100); 
		c.add(name); 

		tname = new JTextField(); 
		tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tname.setSize(190, 20); 
		tname.setLocation(200, 100); 
		c.add(tname); 

		mno = new JLabel("PASSWORD"); 
		mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
		mno.setSize(150, 20); 
		mno.setLocation(50, 150); 
		c.add(mno); 

		tmno = new JPasswordField(); 
		tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tmno.setSize(190, 20); 
		tmno.setLocation(200, 150); 
		c.add(tmno); 

		

		term = new JCheckBox("Accept Terms And Conditions."); 
		term.setSize(250, 20); 
		term.setLocation(150, 200); 
		c.add(term); 

		sub = new JButton("Submit"); 
		sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sub.setSize(100, 20); 
		sub.setLocation(150, 250); 
		sub.addActionListener(this); 
		c.add(sub); 
		reset = new JButton("Reset"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 20); 
		reset.setLocation(270, 250); 
		reset.addActionListener(this); 
		c.add(reset);  

		res = new JLabel(""); 
		res.setFont(new Font("Arial", Font.PLAIN, 20)); 
		res.setSize(500, 25); 
		res.setLocation(100, 275); 
		c.add(res); 

		setVisible(true); 
	} 
	public void actionPerformed(ActionEvent e) 
	{ 
		if (e.getSource() == sub) 
		{ 
			if (term.isSelected()&&(!tmno.getText().equals("")&&!tname.getText().equals(""))) 
			{ 
				res.setText("Registration Successfully.."); 
				login.setdetail(tname.getText(),tmno.getText());
				setVisible(false);
				login.setVisible(true);

			}
			else if(tmno.getText().equals("")||tname.getText().equals("")) 
			{
				res.setText("Please fill all information");
			}
			else 
			{ 
				res.setText("Please accept the"
							+ " terms & conditions.."); 
			} 
		} 

		else if (e.getSource() == reset) 
		{ 
			String def = ""; 
			tname.setText(def); 
			tmno.setText(def); 
			res.setText(def); 
			term.setSelected(false);		
		} 
	} 
}

class Login extends JFrame implements ActionListener
{
	OnlineTest online;
	Register register;
  	JButton SUBMIT,reg,forget;
  	JLabel label1,label2;
  	final JTextField  text1,text2;
  	Map<String,String> details = new TreeMap<String,String>();
  	public void setdetail(String name,String password)
  	{
  		if(details.get(name)==null)
  		{
  			details.put(name,password);
  			try{
  			FileWriter file = new FileWriter("details.txt",true);
           	BufferedWriter buf = new BufferedWriter(file);
           	buf.write("\n");
           	buf.write(name);buf.write("\n");
           	buf.write(password);
           	buf.close();
           }
           catch(Exception ae)
           {

           }
  		}
  		else
  		{
  			JOptionPane.showMessageDialog(this,"Try some different username",
   			"Error",JOptionPane.ERROR_MESSAGE);
   			setVisible(false); 
   			register.setVisible(true); 		
   		}

  	}
   	Login()
   	{

   		try{
			File file = new File("details.txt");
			Scanner input=new Scanner(file);
			while(input.hasNext()){
				details.put(input.next(),input.next());
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
   		getContentPane().setBackground(new Color(51,204,255));
   		setLocation(250,100);
		setVisible(true);
		setSize(800,450);
   		label1 = new JLabel();
   		label1.setText("Username:");
   		text1 = new JTextField(15);
   		label2 = new JLabel();
   		label2.setText("Password:");
   		text2 = new JPasswordField(15);
   		reg=new JButton("REGISTER");
  		forget=new JButton("ADMIN\tLOGIN");
   		SUBMIT=new JButton("LOGIN");

   		add(label1);
   		add(text1);
   		add(label2);
   		add(text2);
   		add(SUBMIT);
   		add(reg);
   		add(forget);
   		setLayout(null);
		label1.setBounds(150,60,100,100);
		label2.setBounds(150,110,100,100);
		text1.setBounds(300,100,100,30);
		text2.setBounds(300,150,100,30);
		SUBMIT.setBounds(200,220,100,30);
		SUBMIT.setEnabled(false);
		reg.setBounds(120,270,100,30);
		forget.setBounds(250,270,200,30);
		forget.addActionListener(this);
		reg.addActionListener(this);
   		SUBMIT.addActionListener(this);
   		setTitle("LOGIN FORM");
   }
   public void actionPerformed(ActionEvent ae)
   {
   	if(ae.getSource()==SUBMIT)
   	{
   		String value1=text1.getText();
   		String value2=text2.getText();
   		text1.setText("");
   		text2.setText("");
   		if (details.get(value1)!=null&& value2.equals(details.get(value1))) {
   			setVisible(false);
   			online.testjava("Test of java");
   		}
   		else if(value1.equals("")||value2.equals(""))
   		{
   			JOptionPane.showMessageDialog(this,"Please fill the details",
   			"Error",JOptionPane.ERROR_MESSAGE);
   		}
   		else
   		{
   			JOptionPane.showMessageDialog(this,"Incorrect login or password\n",
   			"Error",JOptionPane.ERROR_MESSAGE);
   		}
   	}
   	if(ae.getSource()==forget)
   	{
   		String value1=text1.getText();
   		String value2=text2.getText();
   		text1.setText("");
   		text2.setText("");
   		if(value1.equals("ADMIN")&&value2.equals("IIITA"))
   		{
   			setVisible(false);
   			SUBMIT.setEnabled(true);
   			online=new OnlineTest("ADMIN","LOGIN");
   		}
   		else if(value1.equals("")||value2.equals(""))
   		{
   			JOptionPane.showMessageDialog(this,"Please fill the details",
   			"Error",JOptionPane.ERROR_MESSAGE);
   		}
   		else
   		{
   			JOptionPane.showMessageDialog(this,"Incorrect login or password\n",
   			"Error",JOptionPane.ERROR_MESSAGE);
   		}
   		
  	}
  	if(ae.getSource()==reg)
  	{
  		setVisible(false);
  		register=new Register(this);
  	}
  }
}

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JLabel l1;
	JLabel qn;
	JLabel tim,timer,timerem;
	Thread thread,thread1,thread2; 
	JRadioButton jb[]=new JRadioButton[4];
	JButton nextforstudent,bookmark,back;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];
	String arrayforquestion[]=new String[10];
    String twodimensionalarrayforoption[][]=new String[10][5];
    JButton nextbuttonforadmin,save; 
    int myqu=0;
    JTextField tname;
    static Login login;
    int maximum=-1;
    JLabel[] serialnoforoption = new JLabel[5];
    JTextField option[]=new JTextField[5];
	public void testjava(String s)
	{
		setTitle("ONLINE EXAM");
		getContentPane().setBackground(Color.PINK);		
		l=new JLabel();
		tim = new JLabel();
		timer = new JLabel();timerem= new JLabel();
		thread = new Thread(new time());
		thread1 = new Thread(new StopWatch());
		thread2 = new Thread(new Timer());
		add(timerem);
		add(timer);
		add(l);
		add(tim);
		bg=new ButtonGroup();
		for(int i=0;i<4;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		nextforstudent=new JButton("Next");
		bookmark=new JButton("Bookmark");
		nextforstudent.addActionListener(this);
		bookmark.addActionListener(this);
		add(nextforstudent);add(bookmark);
		set();
		if(maximum==current)
		{
				nextforstudent.setEnabled(false);
				bookmark.setText("Result");
			}
			thread2.start();
			thread1.start();
		thread.start();
		setLayout(null);
		timerem.setBounds(500,190,200,50);
		tim.setBounds(500,220,200,50);
		timer.setBounds(500,250,200,50);
		l.setBounds(40,40,450,20);
		l1.setBounds(5,40,30,20);
		jb[0].setBounds(50,80,200,20);
		serialnoforoption[0].setBounds(20,80,100,25);
		jb[1].setBounds(50,110,200,20);
		serialnoforoption[1].setBounds(20,110,100,25);
		jb[2].setBounds(50,140,200,20);
		serialnoforoption[2].setBounds(20,140,100,25);
		jb[3].setBounds(50,170,200,20);
		serialnoforoption[3].setBounds(20,170,100,25);
		nextforstudent.setBounds(100,240,100,30);
		bookmark.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocation(250,100);
		setVisible(true);
		setSize(800,450);
	}
	OnlineTest(String s1,String s2)
	{
		super(s1+s2);
		try{
			File file = new File("input.txt");
			Scanner input=new Scanner(file);
			for(int qnum=0;qnum<10;qnum++){
				arrayforquestion[qnum] = input.nextLine();
				for(int i=0;i<5;i++){
    				twodimensionalarrayforoption[qnum][i]= input.nextLine();
            	}
            	if(maximum<qnum)
					maximum=qnum;
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
        l=new JLabel();
        l1= new JLabel();  
        add(l);  
        getContentPane().setBackground(Color.GREEN);
        l.setText("Enter the Questions and option and right option");
        for(int i=0;i<5;i++)  
        {   serialnoforoption[i] = new JLabel();
            option[i]=new JTextField();     
            option[i].setText(twodimensionalarrayforoption[0][i]);
            add(option[i]);  
            add(serialnoforoption[i]);
        } 
        int ay=90;

        for(int i=0;i<4;i++){
        	serialnoforoption[i].setBounds(10,ay,100,25);
        	option[i].setBounds(40,ay,150,20);
        ay=ay+30;
        }  
        serialnoforoption[4].setBounds(400,120,100,25);
        option[4].setBounds(400,150,100,25);
        serialnoforoption[0].setText("(1)");
        serialnoforoption[1].setText("(2)");
        serialnoforoption[2].setText("(3)");
        serialnoforoption[3].setText("(4)");
        serialnoforoption[4].setText("CORRECT");
        back = new JButton("BACK");
        save = new JButton("SAVE");
        save.addActionListener(this);
        back.addActionListener(this);
        nextbuttonforadmin=new JButton("NEXT");
        nextbuttonforadmin.addActionListener(this);
        tname = new JTextField(); 
        tname.setText(arrayforquestion[0]);
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(700, 30); 
        tname.setLocation(40, 35);
        nextbuttonforadmin.setBounds(400,250,100,30);
        back.setBounds(100,250,100,30);
        save.setBounds(250,250,100,30);   
        add(nextbuttonforadmin);
        add(tname);
        add(l1);
        add(back);
        add(save);        
        back.setEnabled(true);
        l1.setBounds(5,35,30,20);
        l1.setText("Q1");

        l.setBounds(10,5,450,20);   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(800,450);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==save)
		{
			arrayforquestion[myqu]=tname.getText();
			for(int i=0;i<5;i++){
    			twodimensionalarrayforoption[myqu][i]=option[i].getText();
            }
            if(maximum<myqu)
				maximum=myqu;
		}
		if(e.getSource()==nextbuttonforadmin)
		{
			if(maximum>myqu)
			{
				myqu++;

				l1.setText("Q"+Integer.toString(myqu+1));
				tname.setText(arrayforquestion[myqu]);
				for(int i=0;i<5;i++){
    				option[i].setText(twodimensionalarrayforoption[myqu][i]);
            	}
			}
			else if(myqu==9)
            {
            	try{
            	FileWriter file = new FileWriter("input.txt");
           		BufferedWriter buf = new BufferedWriter(file);
           		for(int qnum =0; qnum<10;qnum++)
           		{
           			buf.write(arrayforquestion[qnum]);buf.write("\n");
           			for(int i=0;i<5;i++){
    					buf.write(twodimensionalarrayforoption[qnum][i]);buf.write("\n");
            		}
           		}
           		buf.close();
           	}
           	catch(Exception ae){}
             	JOptionPane.showMessageDialog(this,"MAXIMUM LIMIT REACHED",
   				"Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
            	String qno = Integer.toString(myqu+2);
			    l1.setText("Q"+qno);
    		    tname.setText("");
    		    for(int i=0;i<5;i++){
    				option[i].setText("");
            	}
    			myqu++;
        	}
		}
		if(e.getSource()==back)
		{
			myqu--;
			if(myqu==-1)
			{
				try{
					FileWriter file = new FileWriter("input.txt");
           			BufferedWriter buf = new BufferedWriter(file);
           			for(int qnum =0; qnum<10;qnum++)
           			{
           				buf.write(arrayforquestion[qnum]);buf.write("\n");
           				for(int i=0;i<5;i++){
    						buf.write(twodimensionalarrayforoption[qnum][i]);buf.write("\n");
            			}
           			}
           			buf.close();
           		}catch(Exception aae){ }
				remove(serialnoforoption[4]);remove(save);
				remove(back);remove(nextbuttonforadmin);remove(l);
				remove(tname);
				for(int i=0;i<5;i++)
					remove(option[i]);
				setVisible(false);
				login.setVisible(true);
			}
			else{
				l1.setText("Q"+Integer.toString(myqu+1));
				tname.setText(arrayforquestion[myqu]);
				for(int i=0;i<5;i++){ 
    			option[i].setText(twodimensionalarrayforoption[myqu][i]);
    		}
    	}
    		
		}
		if(e.getSource()==nextforstudent)
		{
			if(check())
				count=count+1;
			current++;
			if(maximum==current)
			{
				nextforstudent.setEnabled(false);
				bookmark.setText("Result");
			}
			l1.setText("Q"+Integer.toString(current+1));
			set();	
			if(current==9)
			{
				nextforstudent.setEnabled(false);
				bookmark.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk = new JButton("Bookmark"+x);
			bk.setBounds(680,20+30*x,100,30);
			
			add(bk);
			bk.setVisible(true);
			setVisible(true);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				bookmark.setText("Result");
		}
		for(int y=1;y<=x;y++)
		{
			try{
				if(e.getActionCommand().equals("Bookmark"+y))
				{
					if(check())
						count=count+1;
					now=current;
					current=m[y];
					set();
					((JButton)e.getSource()).setEnabled(false);
					current=now;
				}
				
			}
			catch(Exception aaee){ }
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			((JButton)e.getSource()).setEnabled(false);
			setVisible(false);
		}
	}
	void set()
	{
		if(current<=9)
		{
			l1.setText("Q"+Integer.toString(current+1));
        	l.setText(arrayforquestion[current]);
        	for(int k=0;k<4;k++)
        	jb[k].setText(twodimensionalarrayforoption[current][k]);
        }
		bg.clearSelection();
	}
	class time implements Runnable
	{
		public void run()
		{
			while(true)
			{
				try{Thread.sleep(1000);}
				catch(Exception e){}
				Calendar cal = Calendar.getInstance(); 
				DecimalFormat df = new DecimalFormat("00");
				String hour1 = df.format(cal.get(Calendar.HOUR));
				String min1 = df.format(cal.get(Calendar.MINUTE));
				String sec1 = df.format(cal.get(Calendar.SECOND));
				tim.setText(hour1+" : "+min1+" : "+sec1);
			}
		}
	}
	class StopWatch implements Runnable 
	{
		public void run()
		{
			int min2=0,hour2=0,sec2=0;
			while(true)
			{
				try{Thread.sleep(1000);sec2++;}
				catch(Exception e){}
				if(sec2>=60){sec2=0;min2++;}
				if(min2>=60){min2=0;hour2++;}
				DecimalFormat df = new DecimalFormat("00");
				timer.setText(df.format(hour2)+" : "+df.format(min2)+" : "+df.format(sec2));
			}
		}

	}
	class Timer implements Runnable 
	{
		public void run()
		{
			int min2=59,hour2=2,sec2=59;
			while(true)
			{
				if(sec2<0){sec2=59;min2--;}
				if(min2<0){min2=59;hour2--;}
				if(hour2<0)
				{
					int opt= JOptionPane.showConfirmDialog(null,"Time is Over Please Submit");
					if(opt==JOptionPane.YES_OPTION || opt == JOptionPane.NO_OPTION)
					actionPerformed(new ActionEvent(bookmark, ActionEvent.ACTION_FIRST, "Result"));
				}
				DecimalFormat df = new DecimalFormat("00");
				timerem.setText(df.format(hour2)+" : "+df.format(min2)+" : "+df.format(sec2));
				try{Thread.sleep(1000);sec2--;}
				catch(Exception e){}
			}
		}

	}
	boolean check(){return(jb[Integer.parseInt(twodimensionalarrayforoption[current][4])-1].isSelected());}
	public static void main(String arg[])
   	{
   		try{login = new Login();}
   		catch(Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}
   	}
} 


