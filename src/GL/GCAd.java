package GL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GCAd
 */
@WebServlet("/GCAd")
public class GCAd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GCAd() {
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
		String GCN=new String(request.getParameter("GCN").getBytes("ISO-8859-1"),"UTF-8");
		String GCB=new String(request.getParameter("GCB").getBytes("ISO-8859-1"),"UTF-8");
		String GCL=new String(request.getParameter("GCL").getBytes("ISO-8859-1"),"UTF-8");
		GLService gl=new GLService();
		if(gl.InsertGC(GCN, GCB, GCL)>0)
		{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('���ӳɹ���');location.href='./GL/GC.jsp';</script>");
		}
		else
		{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('����ʧ�ܣ��벻Ҫ������');location.href='./GL/GC.jsp';</script>");
		}
	}

}