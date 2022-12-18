package beans;

import java.util.ArrayList;

public class FoundArticleBean {
	private String FaSubCategoryCode;
	private String FaControlNumber;
	private String FaName;
	private String FaPlace;
	private String FaDate;
	private String FaCenterCode;
	private String FaStatus;
	private String FaLocation;
	private String FaPerson;
	private String FaPostDate;
	private String FaPostId;
	private String FaColor;
	private ArrayList<ImgBean> ImgList;
	private ArrayList<CommentBean> commentlist;
	
	public String getFaSubCategoryCode() {
		return FaSubCategoryCode;
	}
	public void setFaSubCategoryCode(String faSubCategoryCode) {
		FaSubCategoryCode = faSubCategoryCode;
	}
	public String getFaControlNumber() {
		return FaControlNumber;
	}
	public void setFaControlNumber(String faControlNumber) {
		FaControlNumber = faControlNumber;
	}
	public String getFaName() {
		return FaName;
	}
	public void setFaName(String faName) {
		FaName = faName;
	}
	public String getFaPlace() {
		return FaPlace;
	}
	public void setFaPlace(String faPlace) {
		FaPlace = faPlace;
	}
	public String getFaDate() {
		return FaDate;
	}
	public void setFaDate(String faDate) {
		FaDate = faDate;
	}
	public String getFaStatus() {
		return FaStatus;
	}
	public void setFaStatus(String faStatus) {
		FaStatus = faStatus;
	}
	public String getFaLocation() {
		return FaLocation;
	}
	public void setFaLocation(String faLocation) {
		FaLocation = faLocation;
	}
	public String getFaPerson() {
		return FaPerson;
	}
	public void setFaPerson(String faPerson) {
		FaPerson = faPerson;
	}
	public String getFaPostDate() {
		return FaPostDate;
	}
	public void setFaPostDate(String faPostDate) {
		FaPostDate = faPostDate;
	}
	public ArrayList<ImgBean> getImgList() {
		return ImgList;
	}
	public void setImgList(ArrayList<ImgBean> imgList) {
		ImgList = imgList;
	}
	public ArrayList<CommentBean> getCommentlist() {
		return commentlist;
	}
	public void setCommentlist(ArrayList<CommentBean> commentlist) {
		this.commentlist = commentlist;
	}
	public String getFaPostId() {
		return FaPostId;
	}
	public void setFaPostId(String faPostId) {
		FaPostId = faPostId;
	}
	public String getFaColor() {
		return FaColor;
	}
	public void setFaColor(String faColor) {
		FaColor = faColor;
	}
	public String getFaCenterCode() {
		return FaCenterCode;
	}
	public void setFaCenterCode(String faCenterCode) {
		FaCenterCode = faCenterCode;
	}
}
