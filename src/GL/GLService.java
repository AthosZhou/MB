package GL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.GYS;
import Tools.DBHelp;

public class GLService {
	/*管理员在数据库中的操作*/
	public boolean GLogin(String GNo,String GPass)
	{
		boolean flag=false;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="select * from GG where GNo=? and GPass=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, GNo);
			prep.setString(2, GPass);
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
	
	public int DelCCG(String CNo) {
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="delete from CCG where CNo=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1,CNo);
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
	
	public int InsertCC(String CNo,String CName,String CPass,String CTel)
	{
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="insert into CC values(?,?,?,?)";
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
	
	
	public int InsertGC(String GCN,String GCB,String GCL)
	{
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="insert into GC values(?,?,0,?)";
			prep = conn.prepareStatement(sql);
			prep.setString(1,GCN);
			prep.setString(2,GCB);
			prep.setString(3,GCL);
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
	
	public int DelAllCCG() {
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="delete from CCG where 1=1";
			prep = conn.prepareStatement(sql);
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
	
	public int UpdateCC(String CTel,String CNo,String CName)
	{
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="Update CC set CName=?,CTel=? where CNo=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1,CName);
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
	
	public int UpdateGG(String CPass,String CNo)
	{
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="Update GG set GPass=? where GNo=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1,CPass);
			prep.setString(2,CNo);
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
	
	public int UpdateGC(String GCN,String GCB,String GCM,String GCL)
	{
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="Update GC set GCB=?,GCM=?,GCL=? where GCN=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1,GCB);
			prep.setInt(2,Integer.parseInt(GCM));
			prep.setInt(3,Integer.parseInt(GCL));
			prep.setString(4,GCN);
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
	
	public int DelGC(String GCN) {
		int flag=0;
		Connection conn=DBHelp.getCon();
		ResultSet rs=null;
		PreparedStatement prep=null;
		try
		{
			String sql="delete from GC where GCN=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1,GCN);
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
