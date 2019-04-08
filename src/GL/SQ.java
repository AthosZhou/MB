package GL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SQ
 */
@WebServlet("/SQ")
public class SQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SQ() {
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
		String CName=new String(request.getParameter("CName").getBytes("ISO-8859-1"),"UTF-8");
		String CPass=new String(request.getParameter("CPass").getBytes("ISO-8859-1"),"UTF-8");
		String CTel=new String(request.getParameter("CTel").getBytes("ISO-8859-1"),"UTF-8");
		GLService gl=new GLService();
		if(gl.InsertCC(CNo, CName, CPass, CTel)>0)
		{
			gl.DelCCG(CNo);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('通过成功！');location.href='./GL/ZC.jsp';</script>");
		}
		else
		{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('数据库异常！');location.href='./GL/ZC.jsp';</script>");
		}
	}

}
