package beans;

import java.util.ArrayList;

public class MasterBean {
	private String MasterId;
	private String MasterPin;
	private String MasterCode;
	
	private int nprocessedFa;
	private int nprocessedLa;
	private float PerformanceFa;
	private float PerformanceLa;
	ArrayList<CenterBean> centerList = new ArrayList<CenterBean>();

	public int getNprocessedFa() {
		return nprocessedFa;
	}

	public void setNprocessedFa(int nprocessedFa) {
		this.nprocessedFa = nprocessedFa;
	}

	public int getNprocessedLa() {
		return nprocessedLa;
	}

	public void setNprocessedLa(int nprocessedLa) {
		this.nprocessedLa = nprocessedLa;
	}
	public float getPerformanceFa() {
		return PerformanceFa;
	}

	public void setPerformanceFa(float performanceFa) {
		PerformanceFa = performanceFa;
	}

	public float getPerformanceLa() {
		return PerformanceLa;
	}

	public void setPerformanceLa(float performanceLa) {
		PerformanceLa = performanceLa;
	}

	public String getMasterId() {
		return MasterId;
	}

	public void setMasterId(String masterId) {
		MasterId = masterId;
	}

	public String getMasterPin() {
		return MasterPin;
	}

	public void setMasterPin(String masterPin) {
		MasterPin = masterPin;
	}

	public String getMasterCode() {
		return MasterCode;
	}

	public void setMasterCode(String masterCode) {
		MasterCode = masterCode;
	}

	public ArrayList<CenterBean> getCenterList() {
		return centerList;
	}

	public void setCenterList(ArrayList<CenterBean> centerList) {
		this.centerList = centerList;
	}	
}
