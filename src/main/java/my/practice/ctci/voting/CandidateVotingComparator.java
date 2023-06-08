package my.practice.ctci.voting;

import java.util.Comparator;

/**
 * @author Vishal Joshi
 */
public class CandidateVotingComparator implements Comparator<Candidate> {
    @Override
    public int compare(Candidate o1, Candidate o2) {
        return Integer.compare(o1.getVotes(), o2.getVotes());
//        if (diff == 0) {
//            return o1.getName().compareTo(o2.getName());
//        }
//        return diff;
    }
}
