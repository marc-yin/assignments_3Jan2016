package assignment.MangodbRestCRUD;

import org.springframework.data.annotation.Id;

public class Entry 
{
	@Id	private String id;
	private String name;
	private double value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}   
	
	@Override
	public String toString(){
		return "Entry{" + "id='" + id + ": name-" + name + ", value-" + value + "}";
	}
}
