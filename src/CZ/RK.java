package CZ;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RK
 */
@WebServlet("/RK")
public class RK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RK() {
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
		String OGCN=new String(request.getParameter("OGCN").getBytes("ISO-8859-1"),"UTF-8");
		String OGCM1=new String(request.getParameter("OGCM").getBytes("ISO-8859-1"),"UTF-8");
		int OGCM=Integer.parseInt(OGCM1);
		String OGCP1=new String(request.getParameter("OGCP").getBytes("ISO-8859-1"),"UTF-8");
		float OGCP=Float.parseFloat(OGCP1);
		String OGCG=new String(request.getParameter("OGCG").getBytes("ISO-8859-1"),"UTF-8");
//		String CZY=(String)request.getSession().getAttribute("login_CZY");
		
		String OPR="入库操作";
		String OPC=request.getSession().getAttribute("login_C").toString();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String OPT=df.format(new Date()).toString();
		System.out.println(OGCN+OGCG);
		CZService cz=new CZService();
		if(cz.RK(OPR, OPC, OGCN, OGCP, OGCG, OGCM, OPT)>0)
		{
			//成功
			int Mount=cz.getMount(OGCN)+OGCM;
			if(cz.UpdateMount(Mount, OGCN)>0)
			{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script>alert('入库成功！');location.href='./CZ/RK.jsp';</script>");
			}
			else
			{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script>alert('入库失败！请确认数据库运行正常');location.href='./CZ/RK.jsp';</script>");
			}
		}
		else
		{
			//失败
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('入库失败！请确认数据库运行正常');location.href='./CZ/RK.jsp';</script>");
		}
	}

}
