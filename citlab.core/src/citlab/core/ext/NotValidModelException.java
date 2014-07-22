package citlab.core.ext;

/** when a model is read from a file but its contains severe errors (it is not valid
 */
public class NotValidModelException extends CitLabException{

	public NotValidModelException(String string) {
		super(string);
	}

}
