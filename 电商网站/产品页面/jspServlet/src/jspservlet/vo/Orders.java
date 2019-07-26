package jspservlet.vo;

public class Orders {
	private int id;
	private String username;
	private int pid;
	private String proname;
    private int price;
    private String proIntro;
    private int numbers;
    private String pictures;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProIntro() {
		return proIntro;
	}
	public void setProIntro(String proIntro) {
		this.proIntro = proIntro;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public String getPictures() {
		return pictures;
	}
	public void setPictures(String pictures) {
		this.pictures = pictures;
	}
}
