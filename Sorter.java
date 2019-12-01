import java.util.ArrayList;
import java.util.Collections;

public class Sorter
{
		ArrayList<ParentCompetitor> competitor = new ArrayList<>();
	
	
		public Sorter(ArrayList<ParentCompetitor> competitor)
		{	this.competitor = competitor;	}
		
		public ArrayList<ParentCompetitor> sortByName()
		{	
			Collections.sort(competitor, ParentCompetitor.compareName);
			return competitor;
		}
		
		public ArrayList<ParentCompetitor> sortByDan()
		{
			Collections.sort(competitor, ParentCompetitor.compareDan);
			return competitor;
		}

		public ArrayList<ParentCompetitor> sortByAge()
		{
			Collections.sort(competitor, ParentCompetitor.compareAge);
			return competitor;
		}
		
		public ArrayList<ParentCompetitor> sortByScore()
		{
			Collections.sort(competitor, ParentCompetitor.compareScore);
			return competitor;
		}
		
		public ArrayList<ParentCompetitor> sortByID()
		{
			Collections.sort(competitor, ParentCompetitor.compareID);
			return competitor;
		}
		
}