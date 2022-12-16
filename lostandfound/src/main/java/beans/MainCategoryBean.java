package beans;

import java.util.ArrayList;

public class MainCategoryBean {
	private String MainCategoryCode;
	private String MainCategoryName;
	private ArrayList<SubCategoryBean> subList;
	public String getMainCategoryName() {
		return MainCategoryName;
	}
	public void setMainCategoryName(String mainCategoryName) {
		MainCategoryName = mainCategoryName;
	}
	public String getMainCategoryCode() {
		return MainCategoryCode;
	}
	public void setMainCategoryCode(String mainCategoryCode) {
		MainCategoryCode = mainCategoryCode;
	}
	public ArrayList<SubCategoryBean> getSubList() {
		return subList;
	}
	public void setSubList(ArrayList<SubCategoryBean> subList) {
		this.subList = subList;
	}
}
