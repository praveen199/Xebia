package tennis.table.appilcation.players;

/**
 *  @author Praveen Kumar Singh
 * 
 *  This is Pojo class for Participants.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="participants")
public class Participants {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Participants_Id")
	private Long participantsId;
	
	@Column(name="Participants_Name")
	private String participantsName;
	
	@Column(name="Team_Name")
	private String teamName;

	public Long getParticipantsId() {
		return participantsId;
	}

	public void setParticipantsId(Long participantsId) {
		this.participantsId = participantsId;
	}

	public String getParticipantsName() {
		return participantsName;
	}

	public void setParticipantsName(String participantsName) {
		this.participantsName = participantsName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	
	
}
