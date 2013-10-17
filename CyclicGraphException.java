/**
 * @See {@link Exception} <br>
 * CyclicGraphExeption get thrown when there is a Cycle in the TaskGraph
 * @author kristebo
 *
 */
@SuppressWarnings("serial")
public class CyclicGraphException extends Exception {
	public CyclicGraphException(String message) {
		super(message);
	}
}
