package com.nice.team110;

public class CandidateVotes {
	String candidate;
	String constituency;
	
	public CandidateVotes(String candidate, String constituency) {
		super();
		this.candidate = candidate;
		this.constituency = constituency;
	}
	public String getCandidate() {
		return candidate;
	}
	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
}
