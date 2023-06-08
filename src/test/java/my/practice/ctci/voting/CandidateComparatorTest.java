package my.practice.ctci.voting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

/**
 * @author Vishal Joshi
 */
class CandidateComparatorTest {

    private final CandidateVotingComparator comparator = new CandidateVotingComparator();
    private static Candidate john;
    private static Candidate vishal;
    private static Candidate steve;

    @BeforeAll
    static void setUpEach(){
        john = new Candidate("john", 1);
        vishal = new Candidate("vishal", 1);
        steve = new Candidate("steve", 1);

        john.setVotes(0);
        steve.setVotes(3);
        vishal.setVotes(3);
    }

    @ParameterizedTest
    @MethodSource("dataProducer")
    void testComparatorForDifferentCases(Candidate candidate1, Candidate candidate2, int expectedVal){
        int compare = comparator.compare(candidate1, candidate2);
        assertEquals(expectedVal, compare);
    }

    private static Stream<Arguments> dataProducer(){
        return Stream.of(
                of(john, vishal, -1),
                of(vishal, john, 1),
                of(john, john, 0)
//                of(steve, vishal, -3),
//                of(vishal, steve, 3)
        );
    }

}