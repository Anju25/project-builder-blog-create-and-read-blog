package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface 
{

	public int signUp(User user) throws ClassNotFoundException 
	{
		String INSERT_USERS_SQL = "INSERT INTO USERS(email, password)VALUES(?,?)";

		int result = 0;
		try
		{
			Connection connection = ConnectionManager.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1,user.getEmail());
			preparedStatement.setString(2,user.getPassword());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	
	public boolean loginUser(User user) throws ClassNotFoundException 
	
		{
			boolean status = false;
			try
			{
				Connection con = ConnectionManager.getConnection();
				String sql="select * from users";
			    Statement st=con.createStatement();
			    ResultSet rs=st.executeQuery(sql);
			    while(rs.next())
			    {
                   if(user.getEmail().equals(rs.getString("email")) && user.getPassword().equals(rs.getString("password")));
			    	status=true;
			    }

			} catch (SQLException e) 
			{
				// process sql exception
				System.out.println(e);
			}
			return status;
		}
	
}

