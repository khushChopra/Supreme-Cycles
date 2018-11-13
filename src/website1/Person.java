package website1;
import java.util.ArrayList;

public class Person{
	private String name;
	private String cname;
	private ArrayList<String> skills;

	public void setname(String kname) {
		this.name = kname;
	}
	public void setcname(String kname) {
		this.cname = kname;
	}
	public void setskills( ArrayList<String> skills) {
		this.skills = skills;
	}

	public ArrayList<String> getskills() {
		return skills;
	}
	public String getname() {
		return name;
	}
	public String getcname() {
		return cname;
	}
}