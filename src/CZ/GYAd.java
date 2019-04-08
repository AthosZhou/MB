package CZ;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.GYS;

/**
 * Servlet implementation class GYAd
 */
@WebServlet("/GYAd")
public class GYAd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GYAd() {
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
		String GYN=new String(request.getParameter("GYN").getBytes("ISO-8859-1"),"UTF-8");
		String GYT=new String(request.getParameter("GYT").getBytes("ISO-8859-1"),"UTF-8");
		String GYA=new String(request.getParameter("GYA").getBytes("ISO-8859-1"),"UTF-8");
		String GYF=new String(request.getParameter("GYF").getBytes("ISO-8859-1"),"UTF-8");
		CZService cz=new CZService();
		if(cz.InsertGY(GYN, GYT, GYA, GYF)>0)
		{
			/*成功*/
			ArrayList<GYS> gys=cz.getGYS();
			request.setAttribute("GYS", gys);
			request.getRequestDispatcher("./CZ/GYS.jsp").forward(request, response);
		}
		else
		{
			/*失败*/
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('添加失败！请确认是否重名！');location.href='./CZ/GYS.jsp';</script>");
		}
	}

}
