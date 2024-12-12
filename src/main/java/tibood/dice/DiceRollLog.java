package tibood.dice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;


@Entity
public class DiceRollLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int diceCount;

    private List<Integer> results;

    private Date timestamp;

    public interface InnerDiceRollLog extends JpaRepository<DiceRollLog, Long> {
    

    }

}
