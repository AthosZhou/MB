package GL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GLogin
 */
@WebServlet("/GLogin")
public class GLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String GNo=new String(request.getParameter("GNo").getBytes("ISO-8859-1"),"UTF-8");
		String GPass=new String(request.getParameter("GPass").getBytes("ISO-8859-1"),"UTF-8");
		GLService gl=new GLService();
		if(gl.GLogin(GNo, GPass))
		{
			//
			HttpSession session=request.getSession();
			session.setAttribute("login_G", GNo);
	    	response.sendRedirect("./GL/GMain.jsp");
		}
		else
		{
			//
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('请确认用户名或密码正确且匹配');location.href='G_Login.jsp';</script>");
		}
	}

}
