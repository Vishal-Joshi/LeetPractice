package my.practice.ctci.voting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Vishal Joshi
 */
public class VotingSystem {

    private final Map<String, Candidate> candidates = new HashMap<>();
    private final CandidateVotingComparator comparator = new CandidateVotingComparator();

    public void castVote(String name) {
        if (candidates.containsKey(name)) {
            Candidate candidate = candidates.get(name);
            candidate.setVotes(candidate.getVotes() + 1);
        } else {
            candidates.put(name, new Candidate(name, 1));
        }
    }

    public int getVotesFor(String name) {
        return candidates.get(name).getVotes();
    }

    public Candidate winner() {
        List<Candidate> sortedCandidates = candidates.values().stream().sorted(new CandidateVotingComparator()).collect(Collectors.toList());
        if(sortedCandidates.get(0).getVotes() == sortedCandidates.get(1).getVotes()) {

        }
        return sortedCandidates.get(0);
    }
}
