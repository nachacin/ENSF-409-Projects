
/**
 * A node with two references to the next-left and next-right node. Each 
 * {@code Node} object possesses a reference to an instance of {@code Data}.
 * 
 * @author ENSF 409 Teaching Team
 * @since A long time ago
 * @version 1.0
 */
class Node {
	// Instance of {@code Data}
	Data data;
	// References to next-left and next-right
	Node left, right;
	/**
	 * Creates an instance of {@code Node}.
	 * @param id student id
	 * @param faculty faculty code
	 * @param major student's major
	 * @param year student's year of study
	 */
	public Node(String id, String faculty, String major, String year) {
		// creating a data item
		data = new Data(id, faculty, major, year);
		left = null;
        right = null;
	}
	
	public String toString() {
		return data.toString();
	}
}

