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
 * Servlet implementation class CK
 */
@WebServlet("/CK")
public class CK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CK() {
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
		String OPR="出库操作";
		String OPC=(String)request.getSession().getAttribute("login_C");
		float OGCP=0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String OPT=df.format(new Date()).toString();
		CZService cz=new CZService();
			int Mount=cz.getMount(OGCN)-OGCM;
			int Le=cz.getLe(OGCN);
			if(Mount<Le)
			{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script>alert('出库失败！小于最低库存');location.href='./CZ/CK.jsp';</script>");
			}
			else
			{
				if(cz.UpdateMount(Mount, OGCN)>0 && cz.CK(OPR, OPC, OGCN, OGCP, "/", OGCM, OPT)>0){
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script>alert('出库成功!');location.href='./CZ/CK.jsp';</script>");}
				else
				{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out=response.getWriter();
					out.print("<script>alert('入库失败！请确认数据库运行正常');location.href='./CZ/CK.jsp';</script>");
				}
			}
		
	}

}
