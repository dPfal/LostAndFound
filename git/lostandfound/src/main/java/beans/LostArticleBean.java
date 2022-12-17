package beans;

import java.util.ArrayList;

public class LostArticleBean {
	private String LaSubCategoryCode;
	private String LaControlNumber;
	private String LaName;
	private String LaPlace;
	private String LaDate;
	private String LaCenterCode;
	private String LaStatus;
	private String LaLocation;
	private String LaPostDate;
	private String LaPostId;
	private String LaColor;
	private String LaMainCategoryCode;
	private String LaDetail;

	private ArrayList<ImgBean> ImgList;
	private ArrayList<CommentBean> Commentlist;
	private ReviewBean reviewBean;

	public String getLaSubCategoryCode() {
		return LaSubCategoryCode;
	}

	public void setLaSubCategoryCode(String laSubCategoryCode) {
		LaSubCategoryCode = laSubCategoryCode;
	}

	public String getLaControlNumber() {
		return LaControlNumber;
	}

	public void setLaControlNumber(String laControlNumber) {
		LaControlNumber = laControlNumber;
	}

	public String getLaName() {
		return LaName;
	}

	public void setLaName(String laName) {
		LaName = laName;
	}

	public String getLaPlace() {
		return LaPlace;
	}

	public void setLaPlace(String laPlace) {
		LaPlace = laPlace;
	}

	public String getLaDate() {
		return LaDate;
	}

	public void setLaDate(String laDate) {
		LaDate = laDate;
	}

	public String getLaCenterCode() {
		return LaCenterCode;
	}

	public void setLaCenterCode(String laCenterCode) {
		LaCenterCode = laCenterCode;
	}

	public String getLaStatus() {
		return LaStatus;
	}

	public void setLaStatus(String laStatus) {
		LaStatus = laStatus;
	}

	public String getLaLocation() {
		return LaLocation;
	}

	public void setLaLocation(String laLocation) {
		LaLocation = laLocation;
	}
	public String getLaPostDate() {
		return LaPostDate;
	}

	public void setLaPostDate(String laPostDate) {
		LaPostDate = laPostDate;
	}

	public ArrayList<ImgBean> getImgList() {
		return ImgList;
	}

	public void setImgList(ArrayList<ImgBean> imgList) {
		ImgList = imgList;
	}

	

	public ReviewBean getReviewBean() {
		return reviewBean;
	}

	public void setReviewBean(ReviewBean reviewBean) {
		this.reviewBean = reviewBean;
	}

	public String getLaPostId() {
		return LaPostId;
	}

	public void setLaPostId(String laPostId) {
		LaPostId = laPostId;
	}
	public String getLaColor() {
		return LaColor;
	}

	public void setLaColor(String laColor) {
		LaColor = laColor;
	}

	public ArrayList<CommentBean> getCommentlist() {
		return Commentlist;
	}

	public void setCommentlist(ArrayList<CommentBean> commentlist) {
		this.Commentlist = commentlist;
	}

	public String getLaMainCategoryCode() {
		return LaMainCategoryCode;
	}

	public void setLaMainCategoryCode(String laMainCategoryCode) {
		LaMainCategoryCode = laMainCategoryCode;
	}

	public String getLaDetail() {
		return LaDetail;
	}

	public void setLaDetail(String laDetail) {
		LaDetail = laDetail;
	}



}
