package com.nice.team110;

public class Unqiue {
	String candidate;
	String Constituency;
	int votes;
	public Unqiue(String candidate,String Constituency,int row){
		this.candidate=candidate;
		this.Constituency=Constituency;
		this.votes=row;
	}
	public String getCandidate() {
		return candidate;
	}
	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	public String getConstituency() {
		return Constituency;
	}
	public void setConstituency(String constituency) {
		Constituency = constituency;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
}
