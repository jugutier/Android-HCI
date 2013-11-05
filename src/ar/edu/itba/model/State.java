package ar.edu.itba.model;

public class State {
	private String stateId;
	private String name;
	public String getStateId() {
		return stateId;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return stateId+name;
	}
}
/*
{
"stateId": "C",
"name": "Ciudad Autonoma de Buenos Aires"
}
*/