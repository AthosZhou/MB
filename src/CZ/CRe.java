package CZ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.CC;

/**
 * Servlet implementation class CRe
 */
@WebServlet("/CRe")
public class CRe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRe() {
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
		CZService cz=new CZService();
		if(!cz.getCCN(CNo)){
			if(cz.InsertCCG(CNo, CName, CPass, CTel)>0)
			{
				//
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script>alert('申请成功！请等候管理员通过。');location.href='C_Login.jsp';</script>");
			}
			else
			{
				//
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script>alert('申请失败！您的工号已申请过,请联系管理员确认。');location.href='C_Login.jsp';</script>");
			}
		}
		else
		{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('申请失败！您的工号已有账户,请联系管理员确认。');location.href='C_Login.jsp';</script>");
		}	
	}

}
