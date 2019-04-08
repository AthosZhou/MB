package CZ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CCCH
 */
@WebServlet("/CCCH")
public class CCCH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CCCH() {
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
		String CTel=new String(request.getParameter("CTel").getBytes("ISO-8859-1"),"UTF-8");
		CZService cz=new CZService();
		if(cz.UpdateCC(CPass, CTel, CNo)>0)
		{
			//cg
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('修改成功！');location.href='./CZ/XX.jsp';</script>");
		}
		else
		{
			//s
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('修改失败！服务器异常');location.href='./CZ/XX.jsp';</script>");
		}
	}

}
