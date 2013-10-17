import java.util.ArrayList;


/**
 * Node class for Graph
 * @author kristebo
 *
 */
public class Task {
	public ArrayList<Task> outEdge;
	private int id , time;
	private String name ;
	private int earliestStart , latestStart ;

	private int manpower;
	private ArrayList<Integer> preds;

	/** 
	 * Constructor limited workforce, manpower does not limit 
	 */
	public Task(int id, String name,int time, int staff, ArrayList<Integer> preds){
		this.id=id;
		this.time=time;
		this.name=name;
		this.manpower=staff;
		this.preds=preds;
		outEdge=new ArrayList<>();
	}
	/**
	 * A simple tostring method.
	 */
	public String toString(){

		String ret1=String.format("ID: %s\nName: %s\nStaff: %s \nPredecessors:", id, name, manpower);
		String p="";
		if (preds!=null){
			for (Integer s: preds)	p=p+" "+ s;
			return ret1.concat(p);
		}
		return ret1.concat("\nNo predecessors");


	}
	/**
	 * Gets the predecessors defined in this task.
	 * 
	 * @return ArrayList of integers this tasks predecessors as a ArrayList of integers.
	 */
	public ArrayList<Integer> getPredecessors(){
		return preds;
	}

	/**********************************************
	 * PUBLIC METHODS
	 *	GETTERS
	 *
	 *
	 **********************************************/
	public int getId() {
		return id;
	}
	public int getTime() {
		return time;
	}
	public String getName() {
		return name;
	}
	public int getEarliestStart() {
		return earliestStart;
	}
	public int getLatestStart() {
		return latestStart;
	}
	/**
	 * Sets the latest start this task will start at.
	 * @param latestStart
	 */
	public void setLatestStart(int latestStart){
		this.latestStart=latestStart;
	}
	/**
	 * Sets the earliest start this task can begin at.
	 * @param earliestStart
	 */
	public void setEarliestStart(int earliestStart){
		this.earliestStart=earliestStart;
	}
	public int getManpower() {
		return manpower;
	}
	

}

