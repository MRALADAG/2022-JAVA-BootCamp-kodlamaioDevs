package kodlama.io.Devs.entities.concretes;

public class Software {

	private int id;
	private String name;

	public Software() {
	}

	public Software(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Software : { id : " + getId() + " name : " + getName() + " }";
	}

}
