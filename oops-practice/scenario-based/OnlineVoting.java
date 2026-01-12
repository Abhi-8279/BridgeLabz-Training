import java.util.*;

// ---------------- CUSTOM EXCEPTION ----------------
class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String message) {
        super(message);
    }
}

// ---------------- OOP: VOTER ----------------
class Voter {
    private int voterId;
    private String name;
    private boolean hasVoted;

    public Voter(int voterId, String name) {
        this.voterId = voterId;
        this.name = name;
        this.hasVoted = false;
    }

    public int getVoterId() {
        return voterId;
    }

    public String getName() {
        return name;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void markVoted() {
        this.hasVoted = true;
    }
}

// ---------------- OOP: CANDIDATE ----------------
class Candidate {
    private int candidateId;
    private String name;
    private int voteCount;

    public Candidate(int candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
        this.voteCount = 0;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public String getName() {
        return name;
    }

    public void addVote() {
        voteCount++;
    }

    public int getVoteCount() {
        return voteCount;
    }
}

// ---------------- OOP: VOTE ----------------
class Vote {
    private int voterId;
    private int candidateId;

    public Vote(int voterId, int candidateId) {
        this.voterId = voterId;
        this.candidateId = candidateId;
    }
}

// ---------------- ABSTRACTION ----------------
abstract class ElectionService {
    abstract void registerVoter(Voter voter);
    abstract void addCandidate(Candidate candidate);
    abstract void castVote(int voterId, int candidateId);
    abstract void declareResults();
}

// ---------------- IMPLEMENTATION ----------------
class ElectionServiceImpl extends ElectionService {

    private Map<Integer, Voter> voters = new HashMap<>();
    private Map<Integer, Candidate> candidates = new HashMap<>();
    private List<Vote> votes = new ArrayList<>();

    public void registerVoter(Voter voter) {
        voters.put(voter.getVoterId(), voter);
        System.out.println("Voter Registered: " + voter.getName());
    }

    public void addCandidate(Candidate candidate) {
        candidates.put(candidate.getCandidateId(), candidate);
        System.out.println("Candidate Added: " + candidate.getName());
    }

    public void castVote(int voterId, int candidateId) {
        try {
            Voter voter = voters.get(voterId);
            Candidate candidate = candidates.get(candidateId);

            if (voter == null || candidate == null) {
                System.out.println("Invalid voter or candidate!");
                return;
            }

            if (voter.hasVoted()) {
                throw new DuplicateVoteException(
                        "Voter " + voter.getName() + " has already voted!"
                );
            }

            candidate.addVote();
            voter.markVoted();
            votes.add(new Vote(voterId, candidateId));

            System.out.println("Vote cast successfully by " +
                    voter.getName() + " for " + candidate.getName());

        } catch (DuplicateVoteException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void declareResults() {
        System.out.println("\n--- ELECTION RESULTS ---");
        for (Candidate c : candidates.values()) {
            System.out.println(c.getName() + " → Votes: " + c.getVoteCount());
        }
    }
}

// ---------------- MAIN CLASS ----------------
public class OnlineVoting {
    public static void main(String[] args) {

        ElectionService election = new ElectionServiceImpl();

        // Voter registration
        election.registerVoter(new Voter(1, "Abhishek"));
        election.registerVoter(new Voter(2, "Rohit"));

        // Candidate management
        election.addCandidate(new Candidate(101, "Candidate A"));
        election.addCandidate(new Candidate(102, "Candidate B"));

        // Vote casting
        election.castVote(1, 101);
        election.castVote(2, 102);

        // Duplicate vote attempt (Exception case)
        election.castVote(1, 102);

        // Declare results
        election.declareResults();
    }
}

