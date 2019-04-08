package Bean;

import java.sql.Timestamp;

public class GCT {
	
	public GCT(int OPN,String OPR,String OPC,String OGCN,float OGCP,String OGCG,int OGCM,Timestamp OPT)
	{
		this.OGCM=OGCM;
		this.OGCN=OGCN;
		this.OGCP=OGCP;
		this.OGCG=OGCG;
		this.OPC=OPC;
		this.OPN=OPN;
		this.OPR=OPR;
		this.OPT=OPT;
	}
	
	private String OGCG;
	public String getOGCG() {
		return OGCG;
	}
	public void setOGCG(String oGCG) {
		OGCG = oGCG;
	}

	private int OPN;
	public int getOPN() {
		return OPN;
	}
	public void setOPN(int oPN) {
		OPN = oPN;
	}
	public String getOPR() {
		return OPR;
	}
	public void setOPR(String oPR) {
		OPR = oPR;
	}
	public String getOPC() {
		return OPC;
	}
	public void setOPC(String oPC) {
		OPC = oPC;
	}
	public String getOGCN() {
		return OGCN;
	}
	public void setOGCN(String oGCN) {
		OGCN = oGCN;
	}
	public float getOGCP() {
		return OGCP;
	}
	public void setOGCP(float oGCP) {
		OGCP = oGCP;
	}
	public int getOGCM() {
		return OGCM;
	}
	public void setOGCM(int oGCM) {
		OGCM = oGCM;
	}
	public Timestamp getOPT() {
		return OPT;
	}
	public void setOPT(Timestamp oPT) {
		OPT = oPT;
	}

	private String OPR;
	private String OPC;
	private String OGCN;
	private float OGCP;
	private int OGCM;
	private Timestamp OPT;
}
