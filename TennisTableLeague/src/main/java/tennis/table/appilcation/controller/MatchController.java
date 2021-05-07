package tennis.table.appilcation.controller;

/**
 *  @author Praveen Kumar Singh
 * 
 *  This is controller class for match.
 */

import java.util.Optional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tennis.table.appilcation.exception.MatchClosedException;
import tennis.table.appilcation.exception.ResourceNotFoundException;
import tennis.table.appilcation.players.Matches;
import tennis.table.appilcation.repository.MatchesRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/match")
public class MatchController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MatchController.class);
	
	@Autowired
	private MatchesRepository matchRepository;

	@GetMapping("/list/all")
	public Iterable<Matches> getAllMatchRecord() {
		LOGGER.info("Returing list of participants in a match.");
		return matchRepository.findAll();
	}

	@PostMapping("/add/match")
	public Matches createMatch(@Valid @RequestBody Matches matches) {
		LOGGER.info("Request for adding a match.");
		return matchRepository.save(matches);
	}

	@GetMapping("/find/winner/{round_no}/{team_name}")
	public String findMathchWinnerForRound(@PathVariable(value = "round_no") int round_no,@PathVariable(value = "team_name") String team_name) {
		LOGGER.info("Request for find match winner for a round.");
		String matches = matchRepository.getMatchWinner(round_no,team_name);
		LOGGER.info("Winner for round no - " + round_no + " : who scored maximum point is " +  matches);
		return "Winner for round no - " + round_no + " : who scored maximum point is " +  matches;
	}

	@PutMapping("/update/winner/{round_no}")
	public ResponseEntity<Object> updateMatchWinner(@PathVariable(value = "round_no") int round_no,@Valid @RequestBody Matches matches) throws ResourceNotFoundException {
		LOGGER.info("Request for update match winner for a round.");
		Optional<Matches> matchOptional  = matchRepository.findById(round_no);
		
		if (!matchOptional.isPresent()) {
			LOGGER.error("The round number you are looking for is not found.");
		} else {
			matches.setMatchId(round_no);
		}
		
		matchRepository.save(matches);
		LOGGER.info("Match winner has been updated successfully.");
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/check/status/for/round/{round_no}")
	public ResponseEntity<Object> checkRoundStatus(@PathVariable(value = "round_no") int round_no) throws MatchClosedException {
		LOGGER.info("Request for checking match status for a round.");
		Optional<Matches> matchOptional = matchRepository.findById(round_no);
		
		if (matchOptional.isPresent()) {
			LOGGER.info("Match has beeen completed");
			throw new MatchClosedException("The match you are looking for has been already closed");
		} else {
			LOGGER.info("Match has beeen started,Please start the match");
		}
		
		return ResponseEntity.noContent().build();
	}
	
}
