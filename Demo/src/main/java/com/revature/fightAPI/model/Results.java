package com.revature.fightAPI.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {
	
	@JsonProperty("next")
	public String next;
	@JsonProperty("results")
	public List<StarWars> results;
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public List<StarWars> getResults() {
		return results;
	}
	public void setResults(List<StarWars> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "Results [next=" + next + ", results=" + results + "]";
	}
	
}
