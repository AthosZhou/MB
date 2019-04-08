package Bean;

public class CC {
	
	public CC(String CNo,String CName,String CPass,String CTel)
	{
		this.CName=CName;
		this.CNo=CNo;
		this.CPass=CPass;
		this.CTel=CTel;
	}
	
	String CNo;
	public String getCNo() {
		return CNo;
	}
	public void setCNo(String cNo) {
		CNo = cNo;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public String getCPass() {
		return CPass;
	}
	public void setCPass(String cPass) {
		CPass = cPass;
	}
	public String getCTel() {
		return CTel;
	}
	public void setCTel(String cTel) {
		CTel = cTel;
	}

	String CName;
	String CPass;
	String CTel;
	
}
