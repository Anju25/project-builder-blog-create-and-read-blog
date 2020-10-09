package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.BlogDaolmpl;
import model.Blog;

// View Blog Servlet controller 
@WebServlet(urlPatterns = {"/allblogs"})
public class ViewAllBlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<Blog> listblog=new ArrayList<Blog>();
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("View All Blogs");
		System.out.println("Getting all blog post");
		BlogDaolmpl blogDAO = new BlogDaolmpl();
		
        try {
			listblog = blogDAO.selectAllBlogs();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Blog bloglist:listblog) 
		{
			System.out.println(bloglist.getBlogId());
			System.out.println(bloglist.getBlogTitle());
			System.out.println(bloglist.getBlogDescription());
			System.out.println(bloglist.getPostedon());
		}
		request.setAttribute("listBlog", listblog);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
