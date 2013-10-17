import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Static class for reading files and creating tasks.
 * @author kristebo
 *
 */
public class FileReader {

	public static int numberofTasks=0;
	private static ArrayList<Integer> predecessor;
	private static ArrayList<Task> tasks;
	/**
	 * This static method reads a file and creates task objects. 
	 * @param file
	 * @return a ArraList of Tasks. and sets number of tasks as static int <tt>numberofTasks</tt>
	 */

	public static ArrayList<Task> readFileAndCreateTasks(File file){
		ArrayList<String> lines=new ArrayList<>();
		try {
			Scanner scn=new Scanner(file);
			while(scn.hasNext()){
				lines.add(scn.nextLine());
			}
			numberofTasks=Integer.parseInt(lines.get(0));
			lines.remove(0);//numberofTasks
			lines.remove(0);//lineFeed
			scn.close();
			return createTasks(lines);
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found "+ file.getName());
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * Creates Tasks from a string <tt>data</tt>
	 * @param data a String describing this Task
	 * @return
	 */
	private static ArrayList<Task> createTasks(ArrayList<String> data){
		//data for this task;
		
		int manpower, time, id;
		String name;
		tasks=new ArrayList<Task>();
		
		String delimsator = "\\s+";
		for(String s: data){
			predecessor=new ArrayList<Integer>();
			
			String[] tmp=s.split(delimsator);
			id=Integer.parseInt(tmp[0]);
			name=tmp[1];
			time=Integer.parseInt(tmp[2]);
			manpower=Integer.parseInt(tmp[3]);

			if (Integer.parseInt(tmp[4])==0){
				tasks.add(new Task(id, name, time, manpower, null)); //first task
			} else {
				predecessor.add(Integer.parseInt(tmp[4]));
				for (int i=5; i<tmp.length && Integer.parseInt(tmp[i])!=0; i++){
					predecessor.add(Integer.parseInt(tmp[i]));
					
				}
				
				tasks.add(new Task(id, name, time, manpower, predecessor));
			}
			
		}
		//System.out.println(tasks); //debug
		return tasks;
	}
	
}
