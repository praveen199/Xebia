package tennis.table.appilcation.exception;

/**
 *  @author Praveen Kumar Singh
 * 
 *  Exception class for participants.
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ParticipantsListNotModifiableException extends Exception{

	private static final long serialVersionUID = 1L;

	public ParticipantsListNotModifiableException(String message){
    	super(message);
    }
}
