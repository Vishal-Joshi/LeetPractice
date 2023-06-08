package my.practice.ctci.voting;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Vishal Joshi
 */
@ToString
@EqualsAndHashCode
public class Candidate {
    private final String name;
    @EqualsAndHashCode.Exclude
    private int votes;

    public Candidate(String name, int votes) {
        this.name = name;
        this.votes = votes;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getName() {
        return name;
    }
}
