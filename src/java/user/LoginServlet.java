package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dto.UserDto;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		UserDto userDto = new UserDto();

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String passwordMysql = "";
		Connection con = null;
		// 加载驱动
		try {
			Class.forName(driver);
			// 获取连接
			con = DriverManager.getConnection(url, user, passwordMysql);
			// 拼接sql
			String sql = "select ut.password from user_test ut where ut.user_name=?";
			PreparedStatement s = con.prepareStatement(sql);
			s.setString(1, userName );
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				userDto.setPassword(rs.getString(1));
			}
			String message = "";
			if( userDto.getPassword()== null ){
				message = "user doesn't exist";
			}else{
				if( userDto.getPassword().equals(password)){
					request.getSession().setAttribute("userName", userName );
				}else{
					message= "password incorrect!";
				}
			}
			
			if(message.equals("")){
				request.getRequestDispatcher("common/index.jsp").forward(request,
						response);
			}else{
				request.setAttribute("message", message );
				request.getRequestDispatcher("common/login.jsp").forward(request,
						response);	
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
