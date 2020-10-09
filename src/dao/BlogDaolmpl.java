package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
//import java.time.LocalDate;
//import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.sql.Date;

import model.Blog;
import utility.ConnectionManager;

public  class BlogDaolmpl implements BlogDaoInterface 
{

	@Override
	public void insertBlog(Blog blog) throws ClassNotFoundException, SQLException {
		Connection con=ConnectionManager.getConnection();
		if(con!=null)
		{
			String sql="insert into blog values(?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setLong(1,blog.getBlogId());
			st.setString(2,blog.getBlogTitle());
			st.setString(3, blog.getBlogDescription());
			st.setDate(4,java.sql.Date.valueOf(blog.getPostedon()));// blog.getPostedon());
			st.executeUpdate();
			st.close();
		}
	}
	
	public static List<Blog> listblog=new ArrayList<Blog>();
@Override

	public List<Blog> selectAllBlogs() throws ClassNotFoundException, SQLException {
	//Blog blog = new Blog(0, null, null, null);
	Connection con=ConnectionManager.getConnection();
	if(con!=null)
	{
		String sql="select * from blog";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		while(rs.next())
			
		{
			int id = rs.getInt(1);
			String title = rs.getString(2);
            String description = rs.getString(3);
            LocalDate d1 = rs.getDate(4).toLocalDate();
            Blog blog=new Blog(id,title,description,d1);
			//System.out.println(d);


			/*blog.setBlogId(id);
			blog.setBlogTitle(title);
			blog.setBlogTitle(description);
		    blog.setBlogDescription(description);*/

			//LocalDate postedOn = rs.getDate("blogdate").toLocalDate();

			//blog.setPostedon(postedOn);
			listblog.add(blog);
			
		}
	}
		return listblog;
	}
	
}