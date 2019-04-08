package CZ;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import Bean.CC;
import Bean.GC;
import Bean.GCT;
import Bean.GYS;
import Tools.DBHelp;

public class CZService {
/*操作员在数据库中的操作*/
	/*登录查询*/
	public boolean CLogin(String CNo,String CPass)
	{
		boolean flag=false;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="select * from CC where CNo=? and CPass=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, CNo);
			prep.setString(2, CPass);
			rs=prep.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		}
		catch(Exception e)
		{e.printStackTrace();}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return flag;
	}
	
	
	
	public ArrayList<CC> getCCG()
	{
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		ArrayList<CC> gc=new ArrayList<CC>();
		try
		{
			String sql="select * from CCG";
			prep = conn.prepareStatement(sql);
			rs=prep.executeQuery();
			while(rs.next())
			{
				String CNo=rs.getString("CNo");
				String CName=rs.getString("CName");
				String CPass=rs.getString("CPass");
				String CTel=rs.getString("CTel");
				CC gc1=new CC(CNo, CName, CPass, CTel);
				gc.add(gc1);
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return gc;
	}
	
	public boolean getCCN(String Cno)
	{
		boolean flag=false;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="select * from CC where CNo=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, Cno);
			rs=prep.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return flag;
	}
	
	public void CPTSC()
	{
		boolean flag=false;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="EXEC master..xp_cmdshell 'bcp MBC.dbo.GCX out \"c:\\movie\\The.xls\" -c -S\"iZtzy9vwbq7m5oZ\" -U\"sa\" -P\"Qwer1234\"'";
			prep = conn.prepareStatement(sql);
			rs=prep.executeQuery();
			if(rs.next())
			{
				flag=true;
				
			}
		}
		catch(Exception e)
		{e.printStackTrace();}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
	}
	
	public ArrayList<CC> getCC()
	{
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		ArrayList<CC> gc=new ArrayList<CC>();
		try
		{
			String sql="select * from CC";
			prep = conn.prepareStatement(sql);
			rs=prep.executeQuery();
			while(rs.next())
			{
				String CNo=rs.getString("CNo");
				String CName=rs.getString("CName");
				String CPass=rs.getString("CPass");
				String CTel=rs.getString("CTel");
				CC gc1=new CC(CNo, CName, CPass, CTel);
				gc.add(gc1);
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return gc;
	}
	
	public ArrayList<CC> getCC(String Cno)
	{
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		ArrayList<CC> gc=new ArrayList<CC>();
		try
		{
			String sql="select * from CC where CNo=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, Cno);
			rs=prep.executeQuery();
			while(rs.next())
			{
				String CNo=rs.getString("CNo");
				String CName=rs.getString("CName");
				String CPass=rs.getString("CPass");
				String CTel=rs.getString("CTel");
				CC gc1=new CC(CNo, CName, CPass, CTel);
				gc.add(gc1);
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return gc;
	}
	
	public ArrayList<CC> getGG(String Cno)
	{
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		ArrayList<CC> gc=new ArrayList<CC>();
		try
		{
			String sql="select * from GG where GNo=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, Cno);
			rs=prep.executeQuery();
			while(rs.next())
			{
				String GNo=rs.getString("GNo");
				String GPass=rs.getString("GPass");
				CC gc1=new CC(GNo, "", GPass, "");
				gc.add(gc1);
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return gc;
	}
	
	/*对数据钢材表遍历 获取信息*/
	public ArrayList<GC> getGC()
	{
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		ArrayList<GC> gc=new ArrayList<GC>();
		try
		{
			String sql="select * from GC";
			prep = conn.prepareStatement(sql);
			rs=prep.executeQuery();
			while(rs.next())
			{
				String GCN=rs.getString("GCN");
				String GCB=rs.getString("GCB");
				int GCM=rs.getInt("GCM");
				int GCL=rs.getInt("GCL");
				GC gc1=new GC(GCN,GCB,GCM,GCL);
				gc.add(gc1);
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return gc;
	}
	/*直接获取*/
	public ArrayList<GYS> getGYS()
	{
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		ArrayList<GYS> gcs=new ArrayList<GYS>();
		try
		{
			String sql="select * from GYS";
			prep = conn.prepareStatement(sql);
			rs=prep.executeQuery();
			while(rs.next())
			{
				String GYN=rs.getString("GYN");
				String GYT=rs.getString("GYT");
				String GYA=rs.getString("GYA");
				String GYF=rs.getString("GYF");
				GYS gc1=new GYS(GYN,GYT,GYA,GYF);
				gcs.add(gc1);
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return gcs;
	}
    /*按名获取*/
	public ArrayList<GYS> getGYS(String GYS)
	{
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		ArrayList<GYS> gcs=new ArrayList<GYS>();
		try
		{
			String sql="select * from GYS where GYN=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, GYS);
			rs=prep.executeQuery();
			while(rs.next())
			{
				String GYN=rs.getString("GYN");
				String GYT=rs.getString("GYT");
				String GYA=rs.getString("GYA");
				String GYF=rs.getString("GYF");
				GYS gc1=new GYS(GYN,GYT,GYA,GYF);
				gcs.add(gc1);
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return gcs;
	}
	
	/*插入供应商*/
	public int InsertGY(String GYN,String GYT,String GYA,String GYF)
	{
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="insert into GYS values(?,?,?,?)";
			prep = conn.prepareStatement(sql);
			prep.setString(1,GYN);
			prep.setString(2,GYT);
			prep.setString(3,GYA);
			prep.setString(4,GYF);
			flag=prep.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return flag;
	}
	
	
	public int InsertCCG(String CNo,String CName,String CPass,String CTel)
	{
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="insert into CCG values(?,?,?,?)";
			prep = conn.prepareStatement(sql);
			prep.setString(1,CNo);
			prep.setString(2,CName);
			prep.setString(3,CPass);
			prep.setString(4,CTel);
			flag=prep.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return flag;
	}
	
	
	
	public int UpdateCC(String CPass,String CTel,String CNo)
	{
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="Update CC set CPass=?,CTel=? where CNo=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1,CPass);
			prep.setString(2,CTel);
			prep.setString(3,CNo);
			flag=prep.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return flag;
	}
	
	
	/*修改供应商信息*/
	public int GCH(String GYN,String GYT,String GYA,String GYF) {
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="update GYS set GYT=?,GYA=?,GYF=? where GYN=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1,GYT);
			prep.setString(2,GYA);
			prep.setString(3,GYF);
			prep.setString(4,GYN);
			flag=prep.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return flag;
	}
	
	
	public int Gde(String GYN) {
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="delete from GYS where GYN=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1,GYN);
			flag=prep.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return flag;
	}
	
	public ArrayList<GCT> getRK()
	{
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		ArrayList<GCT> gcs=new ArrayList<GCT>();
		try
		{
			String sql="select * from GCT where OPR='入库操作'";
			prep = conn.prepareStatement(sql);
			rs=prep.executeQuery();
			while(rs.next())
			{
				int OPN=rs.getInt("OPN");
				String OPR=rs.getString("OPR");
				String OPC=rs.getString("OPC");
				String OGCN=rs.getString("OGCN");
				float OGCP=rs.getFloat("OGCP");
				String OGCG=rs.getString("OGCG");
				int OGCM=rs.getInt("OGCM");
				Timestamp OPT=rs.getTimestamp("OPT");
				GCT gc1=new GCT(OPN,OPR,OPC,OGCN,OGCP,OGCG,OGCM,OPT);
				gcs.add(gc1);
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return gcs;
	}
	
	public int getGN(String CRK,String start_time,String end_time)
	{
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		int flag=0;
		try
		{
			String sql="select * from GCT where OPR=? and OPT>'"+start_time+"' and OPT<'"+end_time+"' ";
			prep = conn.prepareStatement(sql);
			prep.setString(1, CRK);
			rs=prep.executeQuery();
			while(rs.next())
			{
				flag++;
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return flag;
	}
	
	public ArrayList<GCT> getGCT(String CRK,String start_time,String end_time,int page)
	{
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		ArrayList<GCT> gcs=new ArrayList<GCT>();
		try
		{
			String sql="?";
			if(page==1)
			{
				sql="select top 5 * from GCT where OPR=? and OPT>'"+start_time+"' and OPT<'"+end_time+"' ";
				prep = conn.prepareStatement(sql);
				prep.setString(1, CRK);
			}
			else
			{
				sql="select top 5 * from GCT where OPR=? and OPT>'"+start_time+"' and OPT<'"+end_time+"' and OPN not in (select top "+(page-1)*5+" OPN from GCT where OPR=? and OPT>'"+start_time+"' and OPT<'"+end_time+"')";
				prep = conn.prepareStatement(sql);
				prep.setString(1, CRK);
				prep.setString(2, CRK);
			}		
			rs=prep.executeQuery();
			while(rs.next())
			{
				int OPN=rs.getInt("OPN");
				String OPR=rs.getString("OPR");
				String OPC=rs.getString("OPC");
				String OGCN=rs.getString("OGCN");
				float OGCP=rs.getFloat("OGCP");
				String OGCG=rs.getString("OGCG");
				int OGCM=rs.getInt("OGCM");
				Timestamp OPT=rs.getTimestamp("OPT");
				GCT gc1=new GCT(OPN,OPR,OPC,OGCN,OGCP,OGCG,OGCM,OPT);
				gcs.add(gc1);
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return gcs;
	}
	
	public int getGCTPC(int pagecount)
	{
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		int flag=0;
		String sql="select * from GCT order by OPN";
		try
		{
			prep = conn.prepareStatement(sql);
			rs=prep.executeQuery();
			while(rs.next())
			{
				flag=flag+1;
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return flag;
	}
	
	public ArrayList<GCT> getGCT(int page,int pagecount)
	{
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		ArrayList<GCT> gcs=new ArrayList<GCT>();
		String sql="select top "+pagecount+" * from GCT order by OPN";;
		try
		{
			if(page==1)
			{
				sql="select top "+pagecount+" * from GCT order by OPN";
			}
			else
			{
				sql="select top "+pagecount+" * from GCT where OPN not in(select top "+(page-1)*pagecount+" OPN from GCT order by OPN)";
			}
			prep = conn.prepareStatement(sql);
			rs=prep.executeQuery();
			while(rs.next())
			{
				int OPN=rs.getInt("OPN");
				String OPR=rs.getString("OPR");
				String OPC=rs.getString("OPC");
				String OGCN=rs.getString("OGCN");
				float OGCP=rs.getFloat("OGCP");
				String OGCG=rs.getString("OGCG");
				int OGCM=rs.getInt("OGCM");
				Timestamp OPT=rs.getTimestamp("OPT");
				GCT gc1=new GCT(OPN,OPR,OPC,OGCN,OGCP,OGCG,OGCM,OPT);
				gcs.add(gc1);
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return gcs;
	}
	
	
	public ArrayList<GCT> getCK()
	{
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		ArrayList<GCT> gcs=new ArrayList<GCT>();
		try
		{
			String sql="select * from GCT where OPR='出库操作'";
			prep = conn.prepareStatement(sql);
			rs=prep.executeQuery();
			while(rs.next())
			{
				int OPN=rs.getInt("OPN");
				String OPR=rs.getString("OPR");
				String OPC=rs.getString("OPC");
				String OGCN=rs.getString("OGCN");
				float OGCP=rs.getFloat("OGCP");
				String OGCG=rs.getString("OGCG");
				int OGCM=rs.getInt("OGCM");
				Timestamp OPT=rs.getTimestamp("OPT");
				GCT gc1=new GCT(OPN,OPR,OPC,OGCN,OGCP,OGCG,OGCM,OPT);
				gcs.add(gc1);
			}
		}
		catch(Exception e)
		{}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return gcs;
	}
	
	public int RK(String OPR,String OPC,String OGCN,float OGCP,String OGCG,int OGCM,String OPT)
	{
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="insert into GCT values(?,?,?,?,?,?,?)";
			prep = conn.prepareStatement(sql);
			prep.setString(1,OPR);
			prep.setString(2,OPC);
			prep.setString(3,OGCN);
			prep.setFloat(4,OGCP);
			prep.setString(5,OGCG);
			prep.setInt(6,OGCM);
			prep.setString(7,OPT);
			flag=prep.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return flag;
	}
	
	public int CK(String OPR,String OPC,String OGCN,float OGCP,String OGCG,int OGCM,String OPT)
	{
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="insert into GCT values(?,?,?,?,?,?,?)";
			prep = conn.prepareStatement(sql);
			prep.setString(1,OPR);
			prep.setString(2,OPC);
			prep.setString(3,OGCN);
			prep.setFloat(4,OGCP);
			prep.setString(5,OGCG);
			prep.setInt(6,OGCM);
			prep.setString(7,OPT);
			flag=prep.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return flag;
	}
	
	public int getMount(String GCN)
	{
		int Mount=-1;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="select GCM from GC where GCN=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1,GCN);
			rs=prep.executeQuery();
			while(rs.next()){
				Mount=rs.getInt("GCM");
				}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return Mount;
	}
	
	public int getLe(String GCN)
	{
		int Mount=-1;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="select GCL from GC where GCN=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1,GCN);
			rs=prep.executeQuery();
			while(rs.next()){
				Mount=rs.getInt("GCL");
				}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return Mount;
	}
	
	
	public int UpdateMount(int Mount,String GCN)
	{
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="update GC set GCM=? where GCN=?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1,Mount);
			prep.setString(2,GCN);
			flag=prep.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			DBHelp.closeDBResource(rs, prep, conn);
		}
		return flag;
	}
	
}
