package tennis.table.appilcation.repository;

/**
 *  @author Praveen Kumar Singh
 * 
 *  Repository for Participants.
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tennis.table.appilcation.players.Participants;

@Repository
public interface ParticipantsRepository extends JpaRepository<Participants, Long> {

	@Query(value="FROM Participants WHERE Team_Name = :teamName")
	List<Participants> getParticipantsNameByTeam(@Param("teamName") String Team_Name);
}
