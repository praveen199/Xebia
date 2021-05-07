package tennis.table.appilcation.players;

/**
 *  @author Praveen Kumar Singh
 * 
 *  This is Pojo class for Matches.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="matches")
public class Matches {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Round_no")
	private Integer matchId;

	@Column(name="Team_Name")
	private String teamName;

	@Column(name="First_Player")
	private String firstPlayer;

	@Column(name="First_Player_Point")
	private Integer firstPlayerPoint;

	@Column(name="Second_Player")
	private String secondPlayer;

	@Column(name="Second_Player_Point")
	private Integer secondPlayerPoint;

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(String firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public String getSecondPlayer() {
		return secondPlayer;
	}

	public void setSecondPlayer(String secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	public Integer getFirstPlayerPoint() {
		return firstPlayerPoint;
	}

	public void setFirstPlayerPoint(Integer firstPlayerPoint) {
		this.firstPlayerPoint = firstPlayerPoint;
	}

	public Integer getSecondPlayerPoint() {
		return secondPlayerPoint;
	}

	public void setSecondPlayerPoint(Integer secondPlayerPoint) {
		this.secondPlayerPoint = secondPlayerPoint;
	}

}
