import java.util.Comparator;

abstract public class ParentCompetitor {

	private String identifier;
	private int id;
	private Name name;
	private String level;
	private int [] score;
	
	public ParentCompetitor (String a, int i, Name n, String l, int [] s) 
	{
		identifier = a;
		id = i;
		name = n;
		level = l;
		score = s;		
	}
	
	public String getIdentifier() { return identifier; }
	public int getId() { return id; }
	public Name getName() {return name; }
	public String getLevel() {return level; }
	
	public int [] getScoreArray() 
	{ 
		return score ;}
	public void setScoreArray(int [] sc)
	{ score=sc;}
	public String getScoreString()
	{
		String  report = "";
		 for(int scoreIndex = 0; scoreIndex < score.length; scoreIndex++)
	 	{
			 report += score[scoreIndex] + " " ;
	 	}
	 return report;
	}
	public abstract double getOverallScore();
	public abstract String getFullDetails();
	public String getShortDetails()
	{
		String compNo = String.format("%s", id);
		 return "CN " + compNo + " (" + getName().getInitials() + ") has an overall score " + String.format("%.4s", getOverallScore());
	}

	public int getAge()
	{
		if (this instanceof DavidKendoka )
		{return ((DavidKendoka) this).getAge();}
		else
		{return 0;}
	}	

	public int getDan()
	{
		if (this instanceof DavidKendoka )
			{return ((DavidKendoka) this).getDanGrade();}
		else
			{return -1;}
	}
	
	public String getP()
	{
		if (this instanceof Volleyball )
			{
			return ((Volleyball) this).getPosition();
			}
		else
			{return null;}
	}
	
	public static Comparator<ParentCompetitor> compareName = new Comparator<ParentCompetitor>()
	{
		@Override
		public int compare(ParentCompetitor pc1, ParentCompetitor pc2)
		{
		return (int) (pc1.getName().getFullName()).compareTo(pc2.getName().getFullName());
		}
	};

	public static Comparator<ParentCompetitor> compareAge = new Comparator<ParentCompetitor>()
	{
		@Override
		public int compare(ParentCompetitor pc1, ParentCompetitor pc2)
		{
		return  ( (pc1.getAge() ) - (pc2.getAge() ) );
		}
	};

	public static Comparator<ParentCompetitor> compareScore = new Comparator<ParentCompetitor>()
	{
		@Override
		public int compare(ParentCompetitor pc1, ParentCompetitor pc2)
		{
		return 	Double.compare(pc1.getOverallScore(), pc2.getOverallScore());
		//return  (int) ((pc1.getOverallScore() ) - (pc2.getOverallScore() )) ;
		}
	};
	
	public static Comparator<ParentCompetitor> compareDan = new Comparator<ParentCompetitor>()
	{
		@Override
		public int compare(ParentCompetitor pc1, ParentCompetitor pc2)
		{
		return  (int) ( (pc1.getDan() ) - (pc2.getDan() ) );
		}
	};

	public static Comparator<ParentCompetitor> compareID = new Comparator<ParentCompetitor>()
	{
		@Override
		public int compare(ParentCompetitor pc1, ParentCompetitor pc2)
		{
		return  ( (pc1.getId() ) - (pc2.getId() ) );
		}
	};
	
	public static Comparator<ParentCompetitor> comparePosition = new Comparator<ParentCompetitor>()
	{
		@Override
		public int compare(ParentCompetitor pc1, ParentCompetitor pc2)
		{
			if ((pc1 instanceof Volleyball) & (pc2 instanceof Volleyball))
			{return (int) ( (pc1.getP()).compareTo( pc2.getP() )) ;}
			else {return 0;}
		}
	};
	
	public static Comparator<ParentCompetitor> compareNationality = new Comparator<ParentCompetitor>()
	{
		@Override
		public int compare(ParentCompetitor pc1, ParentCompetitor pc2)
		{
			if ((pc1 instanceof TableTennis) & (pc2 instanceof TableTennis))
			{return (int) ( pc1.getN().compareTo( pc2.getN() )) ;}
			else {return 0;}
		}
	};

	public static Comparator<ParentCompetitor> compareLevel = new Comparator<ParentCompetitor>()
	{
		@Override
		public int compare(ParentCompetitor pc1, ParentCompetitor pc2)
		{
			// if ((pc1 instanceof TableTennis) & (pc2 instanceof TableTennis))
			return (int) ( pc1.getLevel().compareTo( pc2.getLevel() )) ;
			// else {return 0;}
		}
	};
	
	protected String getN() 
	{
		if (this instanceof TableTennis )
		{
		return ((TableTennis) this).getCountry();
		}
	else
		{return null;}
	}

}
