package GL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Next_BB
 */
@WebServlet("/Next_BB")
public class Next_BB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next_BB() {
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
		if(request.getParameter("CRK2")!=null&&request.getParameter("start_time2")!=null&&request.getParameter("end_time2")!=null)
		{
		String CRK=new String(request.getParameter("CRK2").getBytes("ISO-8859-1"),"UTF-8");
		String start_time=new String(request.getParameter("start_time2").getBytes("ISO-8859-1"),"UTF-8");
		String end_time=new String(request.getParameter("end_time2").getBytes("ISO-8859-1"),"UTF-8");
		request.setAttribute("CRK1", CRK);
		request.setAttribute("start_time1", start_time);
		request.setAttribute("end_time1", end_time);}
		int page=Integer.parseInt(request.getParameter("pageinfo"));
		request.setAttribute("pageN", page+1);
		request.getRequestDispatcher("./CZ/BB.jsp").forward(request, response);
	}

}
