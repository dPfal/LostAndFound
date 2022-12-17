package beans;

import java.util.ArrayList;

public class CenterBean {
	private String centerMasterPw;
	private String centerCode;
	private String centerName;
	private String centerPhone;
	private String centerAddress;
	private String centerLocationcode;

	private ArrayList<LostArticleBean> LAlist;
	private ArrayList<FoundArticleBean> FAlist;
	

	public ArrayList<LostArticleBean> getLAlist() {
		return LAlist;
	}

	public void setLAlist(ArrayList<LostArticleBean> lAlist) {
		LAlist = lAlist;
	}

	public ArrayList<FoundArticleBean> getFAlist() {
		return FAlist;
	}

	public void setFAlist(ArrayList<FoundArticleBean> fAlist) {
		FAlist = fAlist;
	}
	public String getCenterMasterPw() {
		return centerMasterPw;
	}

	public void setCenterMasterPw(String centerMasterPw) {
		this.centerMasterPw = centerMasterPw;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterPhone() {
		return centerPhone;
	}

	public void setCenterPhone(String centerPhone) {
		this.centerPhone = centerPhone;
	}

	public String getCenterAddress() {
		return centerAddress;
	}

	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}

	public String getCenterLocationcode() {
		return centerLocationcode;
	}

	public void setCenterLocationcode(String centerLocationcode) {
		this.centerLocationcode = centerLocationcode;
	}

}
