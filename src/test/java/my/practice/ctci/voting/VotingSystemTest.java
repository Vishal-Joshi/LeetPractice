package my.practice.ctci.voting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vishal Joshi
 */
class VotingSystemTest {

    private final VotingSystem system = new VotingSystem();

    @Test
    void shouldBeAbleToCastVoteMultipleTimesToSamePerson(){
        //given
        String candidate = "vishal";

        //when
        system.castVote(candidate);
        system.castVote(candidate);

        //then
        assertEquals(2, system.getVotesFor(candidate));
    }

    @Test
    void shouldGetCandidateWithMaxVotesAsWinner(){
        //given
        String candidate = "vishal";
        String candidate2 = "billa";

        //when
        system.castVote(candidate);
        system.castVote(candidate);
        system.castVote(candidate2);

        //then
        assertEquals(new Candidate(candidate, 2), system.winner());
    }


}