package services.center;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.CenterBean;
import beans.FoundArticleBean;
import beans.LostArticleBean;
import beans.MemberBean;

public class CenterDataAccessObject extends services.DataAccessObject {

	final CenterBean lfMatching(Connection connection, CenterBean center, int pluscondition)
	{

		CenterBean centerbean=null;
		String query="SELECT LA_MCCODE AS LMAIN, LA_UCCODE AS LSUB,"
				+ "LA_CTNUMBER AS LCTNUM,LA_NAME AS LNAME,LA_PLACE AS LPLACE,"
				+ "LA_DATE AS LDATE,LA_STATUS AS LSTATUS,LA_LOCATION AS LLOCCATION,"
				+ "LA_MMID AS LID,LA_POSTDATE AS LPOSTDATE,LA_COLOR AS LCOLOR,"
				+ "FA_MCCODE AS FMAIN, FA_UCCODE AS FSUB,"
				+ "FA_CTNUMBER AS FCTNUM,FA_NAME AS FNAME,FA_PLACE AS FPLACE,"
				+ "FA_DATE AS FDATE,FA_STATUS AS FSTATUS,FA_LOCATION AS FLOCCATION,"
				+ "FA_MMID AS FID,FA_POSTDATE AS FPOSTDATE,FA_COLOR AS FCOLOR,FA_PERSON AS FPERSON,"
				+ "MM_NAME AS LMMNAME, MM_PHONE AS LMMPHONE "
				+ "FROM LFDBA.LA INNER JOIN LFDBA.FA ON LA_CTCODE=FA_CTCODE "
				+ "INNER JOIN LFDBA.MM ON LA_MMID=MM_ID "
				+ "WHERE LA_CTCODE= ? AND LA_STATUS='R' AND FA_STATUS='S' ";
				query+=(pluscondition==-1)?"AND FA_PERSON=MM_NAME":
				(pluscondition==0)?"AND ABS(LA_DATE-FA_DATE)<=2 ":
				(pluscondition==1)?"AND ABS(LA_DATE-FA_DATE)<=2 AND LA_MCCODE=FA_MCCODE AND LA_UCCODE=FA_UCCODE ":(pluscondition==2)?
			"AND ABS(LA_DATE-FA_DATE)<=2 AND LA_MCCODE=FA_MCCODE AND LA_UCCODE=FA_UCCODE AND LA_COLOR=FA_COLOR AND LA_PLACE=FA_PLACE":"";

		try {
			this.ps = connection.prepareStatement(query);
			this.ps.setNString(1, center.getCenterCode());
			this.rs = this.ps.executeQuery();
			if(this.rs.isBeforeFirst())
			{
				MemberBean member =null;
				LostArticleBean lost =null;
				FoundArticleBean found = null;
				ArrayList<MemberBean> mlist = new ArrayList<MemberBean>();
				ArrayList<LostArticleBean> llist = new ArrayList<LostArticleBean>();
				ArrayList<FoundArticleBean> flist = new ArrayList<FoundArticleBean>();

				

				while(this.rs.next())
				{
					member = new MemberBean();
					member.setMM_PHONE(this.rs.getNString("LMMPHONE"));
					member.setMM_NAME(this.rs.getNString("LMMNAME"));
					found = new FoundArticleBean();
					found.setFaPerson(this.rs.getNString("FPERSON"));
					found.setFaMainCategoryCode(this.rs.getNString("FMAIN"));
					found.setFaSubCategoryCode(this.rs.getNString("FSUB"));
					found.setFaControlNumber(this.rs.getNString("FCTNUM"));
					found.setFaName(this.rs.getNString("FNAME"));
					found.setFaPlace(this.rs.getNString("FPLACE"));
					found.setFaDate(this.rs.getNString("FDATE"));
					found.setFaStatus(this.rs.getNString("FSTATUS"));
					found.setFaLocation(this.rs.getNString("FLOCCATION"));
					found.setFaPostId(this.rs.getNString("FID"));
					found.setFaPostDate(this.rs.getNString("FPOSTDATE"));
					found.setFaColor(this.rs.getNString("FCOLOR"));
					lost = new LostArticleBean();
					lost.setLaMainCategoryCode(this.rs.getNString("LMAIN"));
					lost.setLaSubCategoryCode(this.rs.getNString("LSUB"));
					lost.setLaControlNumber(this.rs.getNString("LCTNUM"));
					lost.setLaName(this.rs.getNString("LNAME"));
					lost.setLaPlace(this.rs.getNString("LPLACE"));
					lost.setLaDate(this.rs.getNString("LDATE"));
					lost.setLaStatus(this.rs.getNString("LSTATUS"));
					lost.setLaLocation(this.rs.getNString("LLOCCATION"));
					lost.setLaPostId(this.rs.getNString("LID"));
					lost.setLaColor(this.rs.getNString("LCOLOR"));
					lost.setLaPostDate(this.rs.getNString("LPOSTDATE"));
					mlist.add(member);
					llist.add(lost);
					flist.add(found);
					member=null;
					lost=null;
					found=null;
				}
				centerbean = new CenterBean();
				centerbean.setmList(mlist);
				centerbean.setLAlist(llist);
				centerbean.setFAlist(flist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return centerbean;
	}
	final Connection openConnection() {
		return this.openConnect();
	}
	final Connection openConnection(String userName, String password ) {
		return this.openConnect();
	}
	final void closeConnection(Connection connect) {
		this.closeConnect(connect);
	}
	final void modifyTranStatus(Connection connect, boolean tran) {
		this.setTranStatus(connect, tran);
	}
	final void setTransaction(boolean tran, Connection connect) {
		this.setTransactionEnd(tran, connect);
	}
}
