import java.awt.*;
// import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Window extends JFrame // implements ActionListener
{
	public static void main(String[] args) 
	{
		
		System.out.println("started");
//		Window screenGUI = new Window();
//		screenGUI.setVisible(true);
		gui();
		System.out.println("ended ");
	}
	
	public static void gui()
	{
		JFrame frame = new JFrame("JADA Sports Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,200);
		frame.getContentPane().add(BorderLayout.SOUTH, buildSouth());
        frame.getContentPane().add(BorderLayout.NORTH, buildMenu());
        frame.getContentPane().add(BorderLayout.CENTER, buildCentre());
        frame.pack();
        frame.setVisible(true);	
//        return frame;
	}
	
	
	public static JMenuBar buildMenu()
	{
        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Edit");
        JMenu m3 = new JMenu("Report");
        JMenu m4 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        
        JMenuItem m11 = new JMenuItem("Read Input File");
        JMenuItem m12 = new JMenuItem("Save Members to File");
        JMenuItem m13 = new JMenuItem("Exit");
//        m11.addActionListener(this);
//        m12.addActionListener(this);
//        m13.addActionListener(this);
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        
        JMenuItem m21 = new JMenuItem("Add a Member");
        JMenuItem m22 = new JMenuItem("Delete a Member");
        JMenuItem m23 = new JMenuItem("Extend a Member to another Sport");
//        m21.addActionListener(this);
//        m22.addActionListener(this);
//        m23.addActionListener(this);
        m2.add(m21);
        m2.add(m22);
        m2.add(m23);
        
        JMenuItem m31 = new JMenuItem("Report Best Overall Competitor");
        JMenuItem m32 = new JMenuItem("Report Basket Ball Statistics");
        JMenuItem m33 = new JMenuItem("Report Kendo Statistics");
        JMenuItem m34 = new JMenuItem("Report Table Tennis Statistics");
        JMenuItem m35 = new JMenuItem("Report Volley Ball Statistics");
//        m31.addActionListener(this);
//        m32.addActionListener(this);
//        m33.addActionListener(this);
//        m34.addActionListener(this);
//        m35.addActionListener(this);
        m3.add(m31);
        m3.add(m32);
        m3.add(m33);
        m3.add(m34);
        m3.add(m35);
        
        JMenuItem m41 = new JMenuItem("About JADA Sports Management Software");
        JMenuItem m42 = new JMenuItem("Help");
//        m41.addActionListener(null);
//        m42.addActionListener(this);
        m4.add(m41);
        m4.add(m42);
        
        return mb;
	}
	
 	public static JPanel buildSouth()
	{
        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JButton shortD = new JButton("All Short Details");
        JLabel label = new JLabel("Enter Membership Number");
        JTextField mn = new JTextField(3); // accepts upto 3 characters
        JButton search = new JButton("Search");
        JButton delete = new JButton("Delete");
        panel.add(shortD); 
        panel.add(label); // Components Added using Flow Layout
        panel.add(mn);
        panel.add(search);
        panel.add(delete);
//        shortD.addActionListener(this);
//        search.addActionListener(this);
//        delete.addActionListener(this);
        
        return panel;
	}
	
	public static JPanel buildSport(JPanel sportPanel, Color col, String sport, JButton b1, JButton b2, JButton b3, JButton b4)
	{
		// Builds a stack of buttons plus heading
		sportPanel.setLayout(new BoxLayout(sportPanel, BoxLayout.Y_AXIS));
		sportPanel.setSize(800/3, (400 - 100));
		sportPanel.setBackground( col );
        JLabel title = new JLabel(sport);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		b1.setAlignmentX(Component.CENTER_ALIGNMENT);
		b2.setAlignmentX(Component.CENTER_ALIGNMENT);
		b3.setAlignmentX(Component.CENTER_ALIGNMENT);
		b4.setAlignmentX(Component.CENTER_ALIGNMENT);
		sportPanel.add(title);
		sportPanel.add(b1);
		sportPanel.add(b2);
		sportPanel.add(b3);
		sportPanel.add(b4);
//		b1.addActionListener(this);
//		b2.addActionListener(this);
//		b3.addActionListener(this);
//		b4.addActionListener(this);
		return sportPanel;
	}    	
	
	public static JPanel buildCentre()
	{
		// Builds the centre panel of 4 sports
        JPanel cPanel = new JPanel();
        cPanel.setLayout(new FlowLayout());;
        
		JPanel basketP = new JPanel();
		JButton b1 = new JButton("Full Statistics");
		JButton b2 = new JButton("Short Details");
		JButton b3 = new JButton("Write Members to File"); 
		JButton b4 = new JButton("Write report to File");
		buildSport(basketP, Color.GREEN, "Basket Ball", b1, b2, b3, b4);
		
		JPanel kendoP = new JPanel();
        JButton k1 = new JButton("Full Statistics");
		JButton k2 = new JButton("Short Details");
		JButton k3 = new JButton("Write members to file");
		JButton k4 = new JButton("Write report to file");
		buildSport(kendoP, Color.GRAY , "Kendo", k1, k2, k3, k4);
		
		JPanel tableP = new JPanel();
        JButton t1 = new JButton("Full Statistics");
		JButton t2 = new JButton("Short Details");
		JButton t3 = new JButton("Write members to file");
		JButton t4 = new JButton("Write report to file");
		buildSport(tableP, Color.RED, "Table Tennis", t1, t2, t3, t4);
		
		JPanel volleyP = new JPanel();
        JButton v1 = new JButton("Full Statistics");
		JButton v2 = new JButton("Short Details");
		JButton v3 = new JButton("Write members to file");
		JButton v4 = new JButton("Write report to file");
		buildSport(volleyP, Color.CYAN, "Volley Ball", v1, v2, v3, v4);
		
		cPanel.add(basketP);
		cPanel.add(kendoP);
		cPanel.add(tableP);
		cPanel.add(volleyP);

		return cPanel;
	}   
	
//	public void actionPerformed(ActionEvent e) 
//	{
//		if (m41)
//		{
//			JOptionPane.showMessageDialog(null, "You chose About!");
//			String ta = "xxx";
//		}
//		
//			if(e.getSource() == m11)
//				ta.setText("Import from File");
//			else if(e.getSource() == m12)
//				ta.setText("Save to File");
//			else if(e.getSource() == m13)
//				System.exit(0);
//			else if(e.getSource() == m21)
//				ta.setText("Add a Member");
//			else if(e.getSource() == m22)
//				ta.setText("Delete a Member");
//			else if(e.getSource() == m23)
//				ta.setText("Extend a Member");
//			else if(e.getSource() == m31)
//				ta.setText("Report Best Overall Competitor");
//			else if(e.getSource() == m32)
//				ta.setText("Report Basket Ball Statistics");
//			else if (e.getSource() == m33)
//				ta.setText("Report Kendo Statistics");
//			else if(e.getSource() == m34)
//				ta.setText("Report Table Tennis Statistics");
//			else if(e.getSource() == m35)
//				ta.setText("Report Volley Ball Statistics");
//	    	else if(e.getSource() == m41)
//	    		JOptionPane.showMessageDialog(null, help());	
//	    	else if(e.getSource() == m42)
//	    		JOptionPane.showMessageDialog(null, about());
//			
//		System.out.println(ta);
//	}

		public static String about()
		{
			System.out.println("Reached about()");
			String aboutJADA = "";
			aboutJADA += "/n";
			aboutJADA += "This excellent Sports Membership software was written by:/n";
			aboutJADA += "/n";
			aboutJADA += "Jessica Yip";
			aboutJADA += "Agne Zainyte";
			aboutJADA += "David Spacey";
			aboutJADA += "Akshay Krishnan";
			aboutJADA += "/n";
			aboutJADA += "Our Software is free to use, but donations and high marks are appreciated.";
			
			return aboutJADA;
		}

		public static String help()
		{
			String help = "";
			help += "/n";
			help += "Search our extensive Help database./n";
			help += "/n";
					
			return help;
		}	
}