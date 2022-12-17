package beans;

import java.util.ArrayList;

public class MasterBean {
	private String MasterId;
	private String MasterPin;
	private String MasterCode;
	
	ArrayList<CenterBean> centerList = new ArrayList<CenterBean>();

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
