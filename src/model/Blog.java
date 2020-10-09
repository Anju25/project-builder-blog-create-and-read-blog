package model;

//import java.sql.Date;
import java.time.LocalDate;
//import java.time.LocalDate;

public class Blog
{
	private int blogId;
	private String blogTitle;
	private String blogDescription;
	public LocalDate getPostedon() {
		return postedon;
	}
	public void setPostedon(LocalDate postedon) {
		this.postedon = postedon;
	}
	private LocalDate postedon;
	public int getBlogId() {
		return blogId;
	}
	public Blog(int blogId, String blogTitle, String blogDescription,LocalDate postedon) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogDescription = blogDescription;
		this.postedon=postedon;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}
	
	
	
	
}