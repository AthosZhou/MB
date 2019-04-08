package Bean;

public class GC {
	
	public GC(String GCN,String GCB,int GCM,int GCL)
	{
		this.GCN=GCN;
		this.GCB=GCB;
		this.GCM=GCM;
		this.GCL=GCL;
	}
	
	private String GCN;
	public String getGCN() {
		return GCN;
	}
	public void setGCN(String gCN) {
		GCN = gCN;
	}
	public String getGCB() {
		return GCB;
	}
	public void setGCB(String gCB) {
		GCB = gCB;
	}
	public int getGCM() {
		return GCM;
	}
	public void setGCM(int gCM) {
		GCM = gCM;
	}
	public int getGCL() {
		return GCL;
	}
	public void setGCL(int gCL) {
		GCL = gCL;
	}
	private String GCB;
	private int GCM;
	private int GCL;
}
