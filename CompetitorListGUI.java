import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;


public class CompetitorListGUI  implements ActionListener {
	private ParentCompetitorList competitorList;
	JFrame mainGUI;
	JFrame popUpGUI;
	ArrayList<JFrame> pops = new ArrayList<JFrame>();
	JMenuBar menuBar;
	JMenu mb, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24, m25, m26, m27, m28, m29, m30, m31, m32, m33, m34, m35, m36, m37, m38, m39, m40, m41, m42;
	JPanel sportsPanel, panelSouth, panelCentre, basketballPanel, kendoPanel, tableTennisPanel, volleyballPanel;
	JButton shortDetails, search, delete, close, help, b1, b2, b3, b4, k1, k2, k3, k4, t1, t2, t3, t4, v1, v2, v3, v4, basketball, kendoka, tabletennis, volleyball;
	JLabel membershipNumber, title, explain;
	JTextField searchField;
	// CompetitorListGUI guiArray[];
	ArrayList<CompetitorListGUI> guiList = new ArrayList<CompetitorListGUI>();
	
	private static String popUpSport = "Kendo";
	private static String popUpSortKey = "ID";
//	String[] sportsList = {"Basketball", "Kendo", "Table Tennis", "Volleyball"};
//	String[][] sortOptions = {{" ", " ", " ", " "},{"ID", "name", "age", "dan" },{" ", " ", " ", " "},{" ", " ", " ", " "}};
		
	public CompetitorListGUI(ParentCompetitorList list){
		
		competitorList=list;
		mainGUI = new JFrame("JADA Sports Management");
		mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGUI.setLocation(400,200);
		mainGUI.getContentPane().add(BorderLayout.SOUTH, buildSouth());
		mainGUI.getContentPane().add(BorderLayout.NORTH, buildMenu());
		mainGUI.getContentPane().add(BorderLayout.CENTER, buildCentre());
		mainGUI.pack();
		mainGUI.setVisible(true);	
		System.out.println("gui works");		
	}
	
	public void KillMe()
	{
		popUpGUI.setVisible(false);
	}
	
	
	private void CompetitorListGUI2(ParentCompetitorList popUpList, String sport, String sort)
	{	
	competitorList = popUpList;
	System.out.println("creating Pop Up");
	popUpGUI = new JFrame("More Details on " + sport);
	popUpGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	popUpGUI.setLocation(500,300);
	//popUpGUI.add(BorderLayout.SOUTH, bottomPanel());
	popUpGUI.getContentPane().add(BorderLayout.NORTH, northPanel());
	popUpGUI.add(BorderLayout.CENTER, reportPane(popUpList, sort));
	popUpGUI.pack();
	popUpGUI.setVisible(true);
	pops.add( popUpGUI );
	System.out.println("gui works");
	}
	
	
	public JMenuBar buildMenu()
	{
        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Edit");
        JMenu m3 = new JMenu("Report");
        JMenu m4 = new JMenu("Help");
        m4.addActionListener(this);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        
        JMenuItem m11 = new JMenuItem("Read Input File");
        m11.addActionListener(this);
        m11.setActionCommand("Read File"); 
        m1.add(m11);
        JMenuItem m12 = new JMenuItem("Write Report to File");
        m12.addActionListener(this);
        m12.setActionCommand("Report Written to File");
        m1.add(m12);
        JMenuItem m13 = new JMenuItem("Exit");
        m13.addActionListener(this);
        m13.setActionCommand("Exit");
        m1.add(m13);
        
        JMenuItem m21 = new JMenuItem("Add a Member");
        m21.addActionListener(this);
        m21.setActionCommand("Add Member");
        m2.add(m21);
        JMenuItem m22 = new JMenuItem("Delete a Member");
        m22.addActionListener(this);
        m22.setActionCommand("Delete Member");
        m2.add(m22);
        JMenuItem m23 = new JMenuItem("Extend a Member to another Sport");      
        m23.addActionListener(this);
        m23.setActionCommand("Extend member");
        m2.add(m23);

        JMenuItem m31 = new JMenuItem("Report Best Overall Competitor");
        m31.addActionListener(this);
        m31.setActionCommand("Best overall report");
        m3.add(m31);
        JMenuItem m32 = new JMenuItem("Report Basketball Statistics");
        m32.addActionListener(this);
        m32.setActionCommand("Basketball stats");
        m3.add(m32);
        JMenuItem m33 = new JMenuItem("Report Kendo Statistics");
        m33.addActionListener(this);
        m33.setActionCommand("Kendo stats");
        m3.add(m33);
        JMenuItem m34 = new JMenuItem("Report Table Tennis Statistics");
        m34.addActionListener(this);
        m34.setActionCommand("Tenis stats");
        m3.add(m34);
        JMenuItem m35 = new JMenuItem("Report Volleyball Statistics");
        m35.addActionListener(this);
        m35.setActionCommand("Volleyball stats");
        m3.add(m35);
    
        JMenuItem m41 = new JMenuItem("About JADA Sports Management Software");
        m41.addActionListener(this);
        m41.setActionCommand("About");
        m4.add(m41);
        JMenuItem m42 = new JMenuItem("Help"); 
        m42.addActionListener(this);
        m42.setActionCommand("Help");
        m4.add(m42);
        
        return mb;
	}
	
 	public JPanel buildSouth()
	{
        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JButton shortD = new JButton("All Short Details");
        JLabel label = new JLabel("Enter Membership Number");
        JTextField mn = new JTextField(3); // accepts upto 3 characters
        JButton search = new JButton("Search");
        JButton delete = new JButton("Delete");
        JButton close = new JButton("Close");
        panel.add(shortD); 
        panel.add(label); // Components Added using Flow Layout
        panel.add(mn);
        panel.add(search);
        panel.add(delete);
        panel.add(new JLabel("          "));		// spaces pad out the close button to the RHS
        panel.add(close);
        shortD.addActionListener(this);
        shortD.setActionCommand("Short details");
        shortD.setToolTipText("Click here for short details of all competitors");
        search.addActionListener(this);
        search.setActionCommand("Search");
        search.setToolTipText("Click here to search a competitor");
        delete.addActionListener(this);
        delete.setActionCommand("Delete");
        delete.setToolTipText("Click here to delete an existing competitor");
        close.addActionListener(this);
        close.setActionCommand("Close");
        close.setToolTipText("Click here to close a window and write competitor list to an output file");
        return panel;
	}
	
	public static JPanel buildSport(JPanel sportPanel, Color col, String sport, JButton b1, JButton b2, JButton b3, JButton b4, JButton b5)
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
		b5.setAlignmentX(Component.CENTER_ALIGNMENT);
		sportPanel.add(Box.createRigidArea(new Dimension(0,10)));
		sportPanel.add(title);
		sportPanel.add(Box.createRigidArea(new Dimension(0,20)));
		sportPanel.add(b1);
		sportPanel.add(Box.createRigidArea(new Dimension(0,10)));
		sportPanel.add(b2);
		sportPanel.add(Box.createRigidArea(new Dimension(0,10)));
		sportPanel.add(b4);
		sportPanel.add(Box.createRigidArea(new Dimension(0,10)));
		sportPanel.add(b3);
		sportPanel.add(Box.createRigidArea(new Dimension(0,10)));
		sportPanel.add(b5);
		sportPanel.add(Box.createRigidArea(new Dimension(0,5)));
		sportPanel.add(Box.createRigidArea(new Dimension(201,5)));
		return sportPanel;
	}    	
	
	public JPanel buildCentre()
	{
		// Builds the centre panel of 4 sports
        JPanel cPanel = new JPanel();
        cPanel.setLayout(new FlowLayout());   
		JPanel basketP = new JPanel();
		JButton b1 = new JButton("Full Statistics");
		b1.setToolTipText("Full report of baskelball players");
		b1.addActionListener(this);
		b1.setActionCommand("Full report b");
		JButton b2 = new JButton("Short Details");
		b2.setToolTipText("Short details of baskelball players");
		b2.addActionListener(this);
		b2.setActionCommand("Short details b");
		JButton b3 = new JButton("Add new competitor");
		b3.addActionListener(this);
		b3.setActionCommand("Write member b");
		b3.setToolTipText("Register new member to a basketball category");
		JButton b4 = new JButton("Highest score");
		b4.addActionListener(this);
		b4.setActionCommand("Write report b");
		b4.setToolTipText("Write a statistical report to a output file");
		JButton basketball = new JButton("More options");
		basketball.addActionListener(this);
		basketball.setActionCommand("Options b");
		basketball.setToolTipText("Click here for more options for basketball players");
		buildSport(basketP, Color.GREEN, "Basket Ball", b1, b2, b3, b4, basketball);
		
		JPanel kendoP = new JPanel();
        JButton k1 = new JButton("Full Statistics");
        k1.addActionListener(this);
        k1.setActionCommand("Full report k");
        k1.setToolTipText("Full report of kendo players");
		JButton k2 = new JButton("Short Details");
		k2.addActionListener(this);
		k2.setActionCommand("Short details k");
		k2.setToolTipText("Short details of kendo players");
		JButton k3 = new JButton("Add new competitor");
		k3.addActionListener(this);
		k3.setActionCommand("Write member k");
		k3.setToolTipText("Register new member to a kendo category");
		JButton k4 = new JButton("Highest score");
		k4.addActionListener(this);
		k4.setActionCommand("Write report k");
		k4.setToolTipText("Write a statistical report to a output file");
		JButton kendoka = new JButton("More options");
		kendoka.addActionListener(this);
		kendoka.setActionCommand("Options k");
		kendoka.setToolTipText("Click here for more options for kendoka");
		buildSport(kendoP, Color.GRAY , "Kendo", k1, k2, k3, k4, kendoka);
		
		JPanel tableP = new JPanel();
        JButton t1 = new JButton("Full Statistics");
        t1.addActionListener(this);
        t1.setActionCommand("Full report t");
        t1.setToolTipText("Full report of table tennis players");
		JButton t2 = new JButton("Short Details");
		t2.addActionListener(this);
		t2.setActionCommand("Short details t");
		t2.setToolTipText("Short details of table tennis players");
		JButton t3 = new JButton("Add new competitor");
		t3.addActionListener(this);
		t3.setActionCommand("Write member t");
		t3.setToolTipText("Register new member to a table tennis category");
		JButton t4 = new JButton("Highest score");
		t4.addActionListener(this);
		t4.setActionCommand("Write report t");
		t4.setToolTipText("Write a statistical report to a output file");
		JButton tabletennis = new JButton("More options");
		tabletennis.addActionListener(this);
		tabletennis.setActionCommand("Options t");
		tabletennis.setToolTipText("Click here for more options for table tennis competitor group");
		buildSport(tableP, Color.RED, "Table Tennis", t1, t2, t3, t4, tabletennis);
		
		JPanel volleyP = new JPanel();
        JButton v1 = new JButton("Full Statistics");
        v1.addActionListener(this);
        v1.setActionCommand("Full report v");
        v1.setToolTipText("Full report of table volleyball players");
		JButton v2 = new JButton("Short Details");
		v2.addActionListener(this);
		v2.setActionCommand("Short details v");
		v2.setToolTipText("Short details of volleyball players");
		JButton v3 = new JButton("Add new competitor");
		v3.addActionListener(this);
		v3.setActionCommand("Write member v");
		v3.setToolTipText("Register new member to a volleyball category");
		JButton v4 = new JButton("Highest score");
		v4.addActionListener(this);
		v4.setActionCommand("Write report v");
		v4.setToolTipText("Write a statistical report to a output file");
		JButton volleyball = new JButton("More options");
		volleyball.addActionListener(this);
		volleyball.setActionCommand("Options v");
		volleyball.setToolTipText("Click here for more options for volleyball players");
		buildSport(volleyP, Color.CYAN, "Volley Ball", v1, v2, v3, v4, volleyball);
		
		cPanel.add(basketP);
		cPanel.add(kendoP);
		cPanel.add(tableP);
		cPanel.add(volleyP);

		return cPanel;
	}   
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	
		String action = e.getActionCommand();
		
		if ((competitorList.getCompetitorCount() == 0) & !( (action.equals("Read File") || action.equals("Close") ) || ((action.equals("About")) || (action.equals("Help")))))	
		{ JOptionPane.showMessageDialog(mainGUI, "Load the data form the file using File->Read Input File." ); }
		else
			{	
			
			if (action.equals("About"))
				{
					JOptionPane.showMessageDialog(null, about());
					System.out.println("About");
				}
			if (action.equals("Help"))
				{
					JOptionPane.showMessageDialog(null, help());
					System.out.println("Help");
				}
		
		else if(action.equals("Read File"))
		{
			int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to read the file?", "Message", JOptionPane.YES_NO_CANCEL_OPTION );
			if(result == JOptionPane.YES_OPTION) {
				competitorList.readFile("ArkCompetitorInput.txt");
				competitorList.readFile("Input File Davids Updated.dat");
				competitorList.readFile("Volleyball_Input_data.txt");
				competitorList.readFile("AgzCompetitors.txt");
			}
			System.out.println("Reading file");
		}
		else if(action.equals("Report Written to File"))
		{
			System.out.println("Write to file");
			if(competitorList.getCompetitorCount() == 0){
				JOptionPane.showMessageDialog(mainGUI, "Load the data form the file using File->Read Input File." );
			}
			else{
			String report = competitorList.getallMembers();
			String highestScore = competitorList.getHighestScore();
			competitorList.writeToFile("Output.txt", report, highestScore);
			JOptionPane.showMessageDialog(null, "Report has been written to the file 'Output.txt'");
			System.out.println("Write to file");
			}
		}
		else if(action.equals("Delete"))
		{
			if(competitorList.getCompetitorCount() == 0){
				JOptionPane.showMessageDialog(mainGUI, "Load the data form the file using File->Read Input File." );
			}
			else{
			//		JOptionPane.showMessageDialog(null,  );
			System.out.println("Deleting");
			}
		}
		else if(action.equals("Close"))
		{
	//		JOptionPane.showMessageDialog(null,  );
			System.out.println("Closing");
			System.exit(0);
			
		}
		else if(action.equals("Short details"))
		{
				JTextArea shortDetailstext = new JTextArea(competitorList.getallMembers());
				JScrollPane shortDetails = new JScrollPane(shortDetailstext);
				shortDetailstext.setLineWrap(true);
				shortDetailstext.setWrapStyleWord(true);
				shortDetailstext.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
				shortDetails.setPreferredSize(new Dimension(371,400));
				JOptionPane.showMessageDialog(mainGUI,shortDetails, "Short details of all competitors",JOptionPane.PLAIN_MESSAGE);
				System.out.println("Short competitor details displayed");
		}
		else if(action.equals("Full report b"))
		{
				JOptionPane.showMessageDialog(null, makeReportGUI(competitorList.getBasketballFullDetails()) );
				System.out.println("Full basketball report");
		}
		else if(action.equals("Full report k"))
		{
				JOptionPane.showMessageDialog(null, makeReportGUI(competitorList.getKendoStatistics()) );
				System.out.println("Full kendo report");
		}
		else if(action.equals("Full report t"))
		{
				JOptionPane.showMessageDialog(null, makeReportGUI(competitorList.getTableTennisFullDetails("ID")) );
				System.out.println("Full tennis report");
		}
		else if(action.equals("Full report v"))
		{
				JOptionPane.showMessageDialog(null, makeReportGUI(competitorList.getVolleyballFullDetails("ID")) );
				System.out.println("Full tennis report");
		}
		else if(action.equals("Short details b"))
		{
			JOptionPane.showMessageDialog(mainGUI, competitorList.getallBasketball());
			System.out.println("Short basketball details");
		}
		else if(action.equals("Short details k"))
		{
			JOptionPane.showMessageDialog(null, makeReportGUI(competitorList.getDavidKendokaFullDetails("score")) );
			System.out.println("Full kendo report");
		}
		else if(action.equals("Short details t"))
		{
			JOptionPane.showMessageDialog(mainGUI, competitorList.getallTableTennis());
			System.out.println("Short tennis details");
		}
		else if(action.equals("Short details v"))
		{
			JOptionPane.showMessageDialog(mainGUI, competitorList.getallVolleyball());
			System.out.println("Short volleyball details");
		}
		else if(action.equals("Write member b"))
		{
		//	JOptionPane.showMessageDialog(null,  );
			System.out.println("Writing basketball member");
		}
		else if(action.equals("Write member k"))
		{
		//	JOptionPane.showMessageDialog(null,  );
			System.out.println("Writing kendo member");
		}
		else if(action.equals("Write member t"))
		{
		//	JOptionPane.showMessageDialog(null,  );
			System.out.println("Writing tennis member");
		}
		else if(action.equals("Write member v"))
		{
		//	JOptionPane.showMessageDialog(null,  );
			System.out.println("Writing volleyball member");
		}
		else if(action.equals("Write report b"))
		{
			JOptionPane.showMessageDialog(null,  competitorList.getallBasketballScoreReport());
			System.out.println("Writing basketball members to a file");
		}
		else if(action.equals("Write report k"))
		{
				JOptionPane.showMessageDialog(null,  competitorList.getallDavidKendokaScoreReport() );
				System.out.println("Writing Kendoka members to a file");
		}
		else if(action.equals("Write report t"))
		{
				JOptionPane.showMessageDialog(null,  competitorList.getallTableTennisScoreReport());
				System.out.println("Writing table tennis members to a file");
		}
		else if(action.equals("Write report v"))
		{
				JOptionPane.showMessageDialog(null,  competitorList.getallVolleyballScoreReport());
				System.out.println("Writing volleyball members to a file");
		}
		else if(action.equals("Add member"))
		{
		//	JOptionPane.showMessageDialog(null,  );
			System.out.println("Adding a member");
		}
		else if(action.equals("Delete member"))
			{
		//		JOptionPane.showMessageDialog(null,  );
				System.out.println("Deleting a member");
			}
		else if(action.equals("Extend member"))
			{
			//		JOptionPane.showMessageDialog(null,  );
				System.out.println("Extending a members categories");
						}
		else if(action.equals("Best overall report"))
		{
			JOptionPane.showMessageDialog(null, competitorList.getHighestScore());
			System.out.println("Finding a competitor with overall highest score");
				}
		else if(action.equals("Basketball stats"))
		{
			JOptionPane.showMessageDialog(null, competitorList.getBasketballStats());
			System.out.println("Printing basketball statistics");
			}
		else if(action.equals("Options b"))
		{
			JOptionPane.showMessageDialog(null, competitorList.getBasketballStats());
			System.out.println("Printing basketball statistics");
			}
		else if(action.equals("Options k"))
		{
			popUpSport = "Kendo";
			popUpSortKey = "ID";  						// default option when entering Popup
			buildOutGUIs(popUpSortKey, popUpSport);
			System.out.println("Kendo popup");
			}
		else if(action.equals("Options t"))
		{
			popUpSport = "Tabletennis";
			popUpSortKey = "ID";  						// default option when entering Popup
			buildOutGUIs(popUpSortKey, popUpSport);
			System.out.println("Tabletennis popup");
			
//			JOptionPane.showMessageDialog(null, competitorList.getBasketballStats());
			System.out.println("Printing tabletennis statistics");
			}
		else if(action.equals("Options v"))
		{
			popUpSport = "Volleyball";
			popUpSortKey = "ID";  						// default option when entering Popup
			buildOutGUIs(popUpSortKey, popUpSport);
			System.out.println("Volleyball popup");
			
			// JOptionPane.showMessageDialog(null, competitorList.getBasketballStats());
			System.out.println("Volleyball popup");
			}
		else if (action.equals("Sort by Age"))
		{
			System.out.println("Sort by Age");
			popUpSortKey = "age";
			killPopUp();
			buildOutGUIs(popUpSortKey, popUpSport);
		}
		else if (action.equals("Sort by Dan"))
		{
			System.out.println("Sort by Dan");
			popUpSortKey = "dan";
			killPopUp();
			buildOutGUIs(popUpSortKey, popUpSport);
		}
		else if (action.equals("Sort by Overall Score"))
		{
			System.out.println("Sort by Overall Score");
			popUpSortKey = "score";
			killPopUp();
			buildOutGUIs(popUpSortKey, popUpSport);
		}
		else if (action.equals("Sort by ID"))
		{
			System.out.println("Sort by ID");
			popUpSortKey = "ID";
			killPopUp();
			buildOutGUIs(popUpSortKey, popUpSport);
		}	
		else if (action.equals("Sort by Name"))
		{
			System.out.println("Sort by Name");
			popUpSortKey = "name";
			killPopUp();
			buildOutGUIs(popUpSortKey, popUpSport);
		}	
		else if	(action.equals("Sort by Position"))
		{
			System.out.println("Sort by Position");
			popUpSortKey = "position";
			killPopUp();
			buildOutGUIs(popUpSortKey, popUpSport);
		}		
		else if	(action.equals("Sort by Nationality"))
		{
			System.out.println("Sort by Nationality");
			popUpSortKey = "nationality";
			killPopUp();
			buildOutGUIs(popUpSortKey, popUpSport);
		}		
		else if (action.equals("Close Popup"))
		{
	//		this.setVisible(false);
			System.out.println("making popup not visible");
		}
		
		}
	}


	private void killPopUp() {

		for (int i=0; i<pops.size(); ++i)
		{
			pops.get(i).setVisible( false );
		}
		guiList.removeAll(guiList);
		System.out.println("guiList is empty" + guiList.isEmpty());
	}

	public String about()
	{
		System.out.println("Reached about()");
		String aboutJADA = "";
		aboutJADA += "\n";
		aboutJADA += "This excellent Sports Membership software was written by:";
		aboutJADA += "\n";
		aboutJADA += "Jessica Yip\n";
		aboutJADA += "Agne Zainyte\n";
		aboutJADA += "David Spacey\n";
		aboutJADA += "Akshay Rajieve Krishnan\n";
		aboutJADA += "\n";
		aboutJADA += "Our Software is free to use, but donations and high marks are appreciated.";
		
		return aboutJADA;
	}

	public String help()
	{
		String help = "";
		help += "\n";
		help += "Search our extensive Help database.";
		help += "\n";
				
		return help;
	}
	
	public JScrollPane makeReportGUI(String report)
	{
		JTextArea text = new JTextArea( report );
		text.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane(text);
		return scrollPane;
	}


	public JTextArea reportPane(ParentCompetitorList popUpList, String sortkey)
	{
		String report = "";
		switch (popUpSport)
		{
			case "Kendo":
				report = popUpList.getDavidKendokaFullDetails(sortkey);
				break;
			case "Basketball":
				break;
			case "Tabletennis":
				report = popUpList.getTableTennisFullDetails(sortkey);
				break;
			case "Volleyball":
				report = popUpList.getVolleyballFullDetails(sortkey);
				break;
		}
		JTextArea panel = new JTextArea( report );
		panel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		return panel;
	}
	
	public JPanel northPanel()
	{
	JPanel panelN = new JPanel();
	panelN.setLayout(new FlowLayout());
	ButtonGroup group = new ButtonGroup();
	
	JLabel explain = new JLabel("Sort By:   ");
	panelN.add(explain);
	
	JLabel label0 = new JLabel("ID");
	JRadioButton rbutton0 = new JRadioButton();
	rbutton0.addActionListener(this);
	rbutton0.setActionCommand("Sort by ID");
	panelN.add(label0);
	panelN.add(rbutton0);
	group.add(rbutton0);
	if (popUpSortKey == "ID" ) {rbutton0.setSelected(true);}	// set default
	
	JLabel label1 = new JLabel("Overall Score");
	JRadioButton rbutton1 = new JRadioButton();
	rbutton1.addActionListener(this);
	rbutton1.setActionCommand("Sort by Overall Score");
	panelN.add(label1);
	panelN.add(rbutton1);
	group.add(rbutton1);
	if (popUpSortKey == "score" ) {rbutton1.setSelected(true);} 					

	switch(popUpSport)
		{
		case "Kendo":
			JLabel klabel2 = new JLabel("Dan Grade");
			JRadioButton krbutton2 = new JRadioButton();
			krbutton2.addActionListener(this);
			krbutton2.setActionCommand("Sort by Dan");
			panelN.add(klabel2);
			panelN.add(krbutton2);
			group.add(krbutton2);
			if (popUpSortKey == "dan" ) {krbutton2.setSelected(true);}
			
			JLabel label3 = new JLabel("Age");
			JRadioButton rbutton3 = new JRadioButton();
			rbutton3.addActionListener(this);
			rbutton3.setActionCommand("Sort by Age");
			panelN.add(label3);
			panelN.add(rbutton3);
			group.add(rbutton3);
			if (popUpSortKey == "age" ) {rbutton3.setSelected(true);}
			break;
		case "Basketball":
			break;
		case "Tabletennis":
			JLabel tlabel2 = new JLabel("Nationality");
			JRadioButton trbutton2 = new JRadioButton();
			trbutton2.addActionListener(this);
			trbutton2.setActionCommand("Sort by Nationality");
			panelN.add(tlabel2);
			panelN.add(trbutton2);
			group.add(trbutton2);
			if (popUpSortKey == "nationality" ) {trbutton2.setSelected(true);}
			break;
		case "Volleyball":
			JLabel vlabel2 = new JLabel("Position");
			JRadioButton vrbutton2 = new JRadioButton();
			vrbutton2.addActionListener(this);
			vrbutton2.setActionCommand("Sort by Position");
			panelN.add(vlabel2);
			panelN.add(vrbutton2);
			group.add(vrbutton2);
			if (popUpSortKey == "position" ) {vrbutton2.setSelected(true);}
						
			JLabel vlabel3 = new JLabel("Name");
			JRadioButton vrbutton3 = new JRadioButton();
			vrbutton3.addActionListener(this);
			vrbutton3.setActionCommand("Sort by Name");
			panelN.add(vlabel3);
			panelN.add(vrbutton3);
			group.add(vrbutton3);
			if (popUpSortKey == "name" ) {vrbutton3.setSelected(true);}
			break;
		}
	return panelN;
	}

	public void buildOutGUIs(String popUpSortKey, String popUpSport)
	{
		{
			CompetitorListGUI2(competitorList, popUpSport, popUpSortKey );
		}
	}
	
}
