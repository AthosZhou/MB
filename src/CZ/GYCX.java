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
 * Servlet implementation class GYCX
 */
@WebServlet("/GYCX")
public class GYCX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GYCX() {
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
		String GYM=new String(request.getParameter("GM").getBytes("ISO-8859-1"),"UTF-8");
		CZService cz=new CZService();
		ArrayList<GYS> gys=cz.getGYS(GYM);
		if(gys.size()!=0){
		request.setAttribute("GYS", gys);
		request.getRequestDispatcher("./CZ/GYS.jsp").forward(request, response);}
		else
		{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('查询失败！没有该供应商信息');location.href='./CZ/GYS.jsp';</script>");
		}
	}

}
