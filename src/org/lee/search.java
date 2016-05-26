package org.lee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Order_search
 */
@WebServlet("/search.do")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String builder = request.getParameter("builder");
		
		try {
			// 连接SQLite的JDBC
			String sql="jdbc:sqlite://d:/Sqlite/test.db";
			Class.forName("org.sqlite.JDBC");
			// 建立一个数据库名test.db的连接，如果不存在就在当前目录下创建之
			Connection conn = DriverManager.getConnection(sql);
			PreparedStatement stmt = conn.prepareStatement("select * from guitar where builder=? ");
			stmt.setString(1,builder) ;	
			ResultSet rs = stmt.executeQuery();// 查询数据

			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01" +
                    	" Transitional//EN'>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title></title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>查询结果如下：</h1><br/>");
			out.println("<table border='1' cellspacing='0'><tr><td>serialNumber"+"</td>");
			out.println("<td>price"+"</td>");
			out.println("<td>builder"+"</td>");
			out.println("<td>type"+"</td>");
			out.println("<td>backWood"+"</td>");
			out.println("<td>topWood"+"</td></tr>");
			
			while(rs.next()){
				String serialNumber=rs.getString("serialNumber");
				double price=rs.getDouble("price");
				String type=rs.getString("type");
				String backWood=rs.getString("backWood");
				String topWood=rs.getString("topWood");
			
				out.println("<tr><td>"+ serialNumber+"</td>");
				out.println("<td>"+ price+"</td>");
				out.println("<td>"+builder+"</td>");
				out.println("<td>"+type+"</td>");
				out.println("<td>"+backWood+"</td>");
				out.println("<td>"+topWood+"</td></tr>");
				
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		
			rs.close();
		    stmt.close();
		    conn.close();
		}
		catch(SQLException e){
			System.out.print("SQLException" + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
