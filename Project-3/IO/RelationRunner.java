import java.io.IOException;

public class RelationRunner{
	
	public static void main(String[] args) throws IOException{
		
		String fileN = "/Users/TAMU2017/IdeaProjects/howdyReader/src/Schedule_Clean.txt";
		
		try{
			ScheduleReader howdy = new ScheduleReader(fileN);
			//howdy.get();
			//howdy.getRelNum();
			//howdy.getDB();
			//howdy.put();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}