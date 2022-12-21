package beans;

import java.util.ArrayList;

public class MemberBean {

	private String MM_ID;
	private String MM_PW;
	private String MM_NAME;
	private String MM_EMAIL;
	private String MM_PHONE;
	private String MM_ADDRESS;
	private String MM_ADDRDETAIL;
	private boolean MM_GENDER;
	
	private ArrayList<LostArticleBean> LAlist;
	private ArrayList<FoundArticleBean> FAlist;
	private ArrayList<ReviewBean> Reviewlist;
	private ArrayList<CommentBean> CommentList;
	
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
	public ArrayList<ReviewBean> getReviewlist() {
		return Reviewlist;
	}
	public void setReviewlist(ArrayList<ReviewBean> reviewlist) {
		Reviewlist = reviewlist;
	}
	public String getMM_ID() {
		return MM_ID;
	}
	public void setMM_ID(String mM_ID) {
		MM_ID = mM_ID;
	}
	public String getMM_PW() {
		return MM_PW;
	}
	public void setMM_PW(String mM_PW) {
		MM_PW = mM_PW;
	}
	public String getMM_NAME() {
		return MM_NAME;
	}
	public void setMM_NAME(String mM_NAME) {
		MM_NAME = mM_NAME;
	}
	public String getMM_EMAIL() {
		return MM_EMAIL;
	}
	public void setMM_EMAIL(String mM_EMAIL) {
		MM_EMAIL = mM_EMAIL;
	}
	public String getMM_PHONE() {
		return MM_PHONE;
	}
	public void setMM_PHONE(String mM_PHONE) {
		MM_PHONE = mM_PHONE;
	}
	public String getMM_ADDRESS() {
		return MM_ADDRESS;
	}
	public void setMM_ADDRESS(String mM_ADDRESS) {
		MM_ADDRESS = mM_ADDRESS;
	}
	public String getMM_ADDRDETAIL() {
		return MM_ADDRDETAIL;
	}
	public void setMM_ADDRDETAIL(String mM_ADDRDETAIL) {
		MM_ADDRDETAIL = mM_ADDRDETAIL;
	}
	public boolean isMM_GENDER() {
		return MM_GENDER;
	}
	public void setMM_GENDER(boolean mM_GENDER) {
		MM_GENDER = mM_GENDER;
	}
	public ArrayList<CommentBean> getCommentList() {
		return CommentList;
	}
	public void setCommentList(ArrayList<CommentBean> commentList) {
		CommentList = commentList;
	}
	
	
	
}
