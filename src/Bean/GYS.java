package Bean;

public class GYS {
	
	public GYS(String GYN,String GYT,String GYA,String GYF)
	{
		this.GYN=GYN;
		this.GYA=GYA;
		this.GYF=GYF;
		this.GYT=GYT;
	}
	
	private String GYN;
	public String getGYN() {
		return GYN;
	}
	public void setGYN(String gYN) {
		GYN = gYN;
	}
	public String getGYA() {
		return GYA;
	}
	public void setGYA(String gYA) {
		GYA = gYA;
	}
	public String getGYF() {
		return GYF;
	}
	public void setGYF(String gYF) {
		GYF = gYF;
	}
	public String getGYT() {
		return GYT;
	}
	public void setGYT(String gYT) {
		GYT = gYT;
	}
	private String GYA;
	private String GYF;
	private String GYT;
}
