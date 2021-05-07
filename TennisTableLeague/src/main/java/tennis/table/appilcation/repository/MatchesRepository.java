package tennis.table.appilcation.repository;

/**
 *  @author Praveen Kumar Singh
 * 
 *  Repository for Matches.
 */

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tennis.table.appilcation.players.Matches;

@Repository
public interface MatchesRepository extends JpaRepository<Matches, Integer>{

	@Transactional
	@Procedure(procedureName = "winner_round")
	String getMatchWinner(@Param("match_no") int match_no,@Param("team_name") String team_name);
}
