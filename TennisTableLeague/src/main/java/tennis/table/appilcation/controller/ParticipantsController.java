package tennis.table.appilcation.controller;

/**
 *  @author Praveen Kumar Singh
 * 
 *  This is controller class for Participants.
 */

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tennis.table.appilcation.exception.ParticipantsListNotModifiableException;
import tennis.table.appilcation.exception.ResourceNotFoundException;
import tennis.table.appilcation.players.Participants;
import tennis.table.appilcation.repository.ParticipantsRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/participants")
public class ParticipantsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantsController.class);

	@Value("${total.size.participants}")
	private int checkNumberOfparticipants;
	
	@Autowired
	private ParticipantsRepository participantsRepository;

	@GetMapping("/list/all")
	public Iterable<Participants> getListOfAllParticipants() {
		LOGGER.info("Returing list of all participants.");
		return participantsRepository.findAll();
	}

	@PostMapping("/add/request")
	public ResponseEntity<Object> submitParticipantsRequest(@Valid @RequestBody Participants participants) throws ParticipantsListNotModifiableException {
		LOGGER.info("Request for adding a participants.");
		
		Iterable<Participants> totalParticipantsSize = participantsRepository.findAll();
		long lengthOfParticipants = totalParticipantsSize.spliterator().getExactSizeIfKnown();
		Participants addParticipants = null;
		
		if(lengthOfParticipants < checkNumberOfparticipants) {
			addParticipants = participantsRepository.save(participants);
		} else {
			LOGGER.error("You have allready added maximum participants,now you can't add.");
			throw new ParticipantsListNotModifiableException("Adding participants request is reached to maximum point,now you can't add more participants.");
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{participantsId}").buildAndExpand(addParticipants.getParticipantsId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/remove/{participantsId}")
	public Map<String, Boolean> removeParticipants(@PathVariable(value = "participantsId") Long participantsId) throws ResourceNotFoundException {
		LOGGER.info("Request for deleting a participants.");
		
		Participants participants = participantsRepository.findById(participantsId).orElseThrow(() -> new ResourceNotFoundException("Participants not found for this id :: " + participantsId));
		participantsRepository.delete(participants);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/search/teamname/{teamName}")
	public List<Participants> findParticipantsUsingTeamName(@PathVariable(value = "teamName") String teamName) throws ResourceNotFoundException {
		LOGGER.info("Request for search participants using teamName.");
		
		return participantsRepository.getParticipantsNameByTeam(teamName);
	}
}
