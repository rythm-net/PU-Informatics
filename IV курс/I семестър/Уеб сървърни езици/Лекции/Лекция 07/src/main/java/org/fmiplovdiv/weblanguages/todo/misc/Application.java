package org.fmiplovdiv.weblanguages.todo.misc;

public class Application {

	private String name;
	private String apiVersion;
	
	public Application(String name, String apiVersion) {
		super();
		this.name = name;
		this.apiVersion = apiVersion;
	}

	public Application() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	
	
}
