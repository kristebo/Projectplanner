
import java.io.File;
import java.util.ArrayList;





public class Oblig2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f=new File(args[0]);
		ArrayList<Task> taskList =FileReader.readFileAndCreateTasks(f);
		new TaskGraph(taskList);
		
	}
}

