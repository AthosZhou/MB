package CZ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CLogin
 */
@WebServlet("/CLogin")
public class CLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CLogin() {
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
		String CNo=new String(request.getParameter("CNo").getBytes("ISO-8859-1"),"UTF-8");
		String CPass=new String(request.getParameter("CPass").getBytes("ISO-8859-1"),"UTF-8");
		CZService cz=new CZService();
		if(cz.CLogin(CNo, CPass))
		{
			//成功
			HttpSession session=request.getSession();
			session.setAttribute("login_C", CNo);
	    	response.sendRedirect("./CZ/CMain.jsp");
		}
		else
		{
			//失败
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('请确认用户名或密码正确且匹配');location.href='C_Login.jsp';</script>");
		}
	}

}
