package co.edureka.selenium.webdriver.basic;

public class ContactDB 
{
	private int Id;
	private String Name;
	private boolean CheckSend=false;
	private boolean gender=true;
	private int currentId;
	public int getCurrentId() {
		return currentId;
	}
	public void setCurrentId(int currentId) {
		this.currentId = currentId;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public boolean isCheckSend() {
		return CheckSend;
	}
	public void setCheckSend(boolean checkSend) {
		CheckSend = checkSend;
	}






}
