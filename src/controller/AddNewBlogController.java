package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import dao.BlogDaoImpl;
import dao.BlogDaolmpl;
import model.Blog;
//import java.sql.Date;

@WebServlet(urlPatterns = {"/new"})
public class AddNewBlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int i = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Getting into Add New Blog");
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogListView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entering do post");
		String blogTitle = request.getParameter("title");
		String blogDescription = request.getParameter("message");
		//Date now=null;
		//java.sql.Date sqlDate=new java.sql.Date(now.getTime());
		LocalDate postedOn = LocalDate.now();
		System.out.println(blogTitle);
		
		Blog blog = new Blog(++i,blogTitle,blogDescription,postedOn);
	     blog.setBlogId(++i);
		blog.setBlogTitle(blogTitle);
		blog.setBlogDescription(blogDescription);
		blog.setPostedon(postedOn);
		
		BlogDaolmpl blogDao = new BlogDaolmpl();
		try {
			blogDao.insertBlog(blog);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("allblogs");
		/*
		 * RequestDispatcher rd=this.getServletContext().getRequestDispatcher(
		 * "/WEB-INF/views/blogView.jsp"); rd.forward(request, response);
		 */
		
	}
}