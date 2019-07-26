package jspservlet.vo;



//封装产品的信息：包括 ：ID 产品名称 价格 产品介绍  库存  
public class Product {
	  private int id;
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
	public String getPictures(){
		return pictures;
	}
	public void setPictures(String pictures) {
		this.pictures = pictures;
		
	}


}
