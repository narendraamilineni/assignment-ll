package naren.jersey.pojo;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class User {

	public User(){
		
	}
	
	private String name;
	private String lname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "name: "+name+", last name:"+lname;
	}
		
}
