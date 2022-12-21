package services.masterfunction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.CenterBean;
import beans.FoundArticleBean;
import beans.LostArticleBean;
import beans.MasterBean;
import beans.MemberBean;


public class MfDataAccessObject extends services.DataAccessObject {
	final MasterBean calculateCenterByPerformance(Connection connection, MasterBean master)
	{
		String query="SELECT (SELECT COUNT(LA_CTNUMBER) FROM LFDBA.LA WHERE "
				+ "LA_STATUS=C GROUP BY LA_CTCODE) AS CLNUM,"
				+ "(SELECT COUNT(LA_CTNUMBER) AS A CT_NAME AS B FROM LFDBA.LA "
				+ "INNER JOIN CT ON LA_CTCODE=CT_CODE GROUP BY LA_CTCODE,CT_NAME) AS ALNUM,"
				+ "(SELECT COUNT(FA_CTNUMBER) FROM LFDBA.FA WHERE "
				+ "FA_STATUS=C GROUP BY FA_CTCODE) AS CFNUM,"
				+ "(SELECT COUNT(FA_CTNUMBER) FROM LFDBA.FA GROUP BY FA_CTCODE) AS AFNUM "
				+ "FROM DUAL";
		try {
			this.ps = connection.prepareStatement(query);
			
			this.rs = this.ps.executeQuery();
			if(this.rs.isBeforeFirst())
			{
				ArrayList<CenterBean> list = new ArrayList<CenterBean>();
				CenterBean center =null;
				while(this.rs.next())
				{
					center = new CenterBean();
					center.setCenterName(this.rs.getNString("AFNUM.B"));
					center.setNprocessedFa(this.rs.getInt("CFNUM"));
					center.setNprocessedLa(this.rs.getInt("CLNUM"));
					center.setPerformanceFa(
							(center.getNprocessedFa()/this.rs.getInt("AFNUM.A"))*100
							);
					center.setPerformanceLa(
							(center.getNprocessedLa()/this.rs.getInt("ALNUM"))*100
							);
					list.add(center);
				}
				master.setCenterList(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return master;
	}
	final MasterBean calculateAllPerformance(Connection connection, MasterBean master)
	{
		String query="SELECT (SELECT COUNT(LA_CTNUMBER) AS CLNUM FROM LFDBA.LA WHERE LA_STATUS=C),"
				+ "(SELECT COUNT(FA_CTNUMBER) AS CFNUM FROM LFDBA.FA WHERE FA_STATUS=C),"
				+ "(SELECT COUNT(LA_CTNUMBER) AS ALNUM FROM LFDBA.LA),"
				+ "(SELECT COUNT(FA_CTNUMBER) AS AFNUM FROM LFDBA.LA) FROM DUAL";
		
		try {
			this.ps = connection.prepareStatement(query);
			
			this.rs = this.ps.executeQuery();
			if(this.rs.isBeforeFirst())
			{
				while(this.rs.next())
				{
					master.setNprocessedLa(this.rs.getInt("CLNUM"));
					master.setNprocessedFa(this.rs.getInt("CFNUM"));
					master.setPerformanceLa(
							(master.getNprocessedLa()/this.rs.getInt("ALNUM"))*100
							);
					master.setPerformanceFa(
							(master.getNprocessedFa()/this.rs.getInt("AFNUM"))*100
							);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return master;
	}
	final int completeProcessing(Connection connection, CenterBean center)
	{
		int result=0;
		String dml=null;
		String ctnum=null;
		if(center.getFAlist() !=null)
		{
			dml="UPDATE LFDBA.FA SET FA_STATUS='C' WHERE FA_CTNUMBER=?";
			ctnum=center.getFAlist().get(0).getFaControlNumber();
		}
		else if(center.getLAlist() != null) {
			dml="UPDATE LFDBA.LA SET LA_STATUS='C' WHERE LA_CTNUMBER=?";
			ctnum=center.getLAlist().get(0).getLaControlNumber();
		}
		
		try {
			this.ps = connection.prepareStatement(dml);
			this.ps.setNString(1, ctnum);
			result=this.ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	final ArrayList<FoundArticleBean> getCenterFoundList(Connection connection, CenterBean center)
	{
		ArrayList<FoundArticleBean> list = null;
		String query="SELECT FA_MCCODE AS MAINCATEGORY,FA_SCCODE AS SUBCATEGORY,FA_CTNUMBER CONTROLLNUM,"
				+ "FA_NAME AS FOUNDNAME,FA_PLACE FOUNDPLACE,FA_DATE FOUNDDATE,FA_STATUS FOUNDSTATUS,"
				+ "FA_LOCATION AS FOUNDLOCATION,FA_MMID AS FOUNDID,FA_POSTDATE AS FOUNDPOSTDATE,"
				+ "FA_COLOR AS FOUNDCOLOR,FA_CTCODE AS FOUNDCENTERCODE,FA_PERSON AS LOSTPERSON FROM LFDBA.FA "
				+ "WHERE FA_CTCODE=? AND FA_STATUS='P'";
		try {
			this.ps = connection.prepareStatement(query);
			this.ps.setNString(1, center.getCenterCode());
			
			this.rs =this.ps.executeQuery();
			if(this.rs.isBeforeFirst())
			{
				list = new ArrayList<FoundArticleBean>();
				FoundArticleBean fa=null;
				while(this.rs.next())
				{
					fa= new FoundArticleBean();
					fa.setFaMainCategoryCode(this.rs.getNString("MAINCATEGORY"));
					fa.setFaSubCategoryCode(this.rs.getNString("SUBCATEGORY"));
					fa.setFaControlNumber(this.rs.getNString("CONTROLLNUM"));
					fa.setFaName(this.rs.getNString("FOUNDNAME"));
					fa.setFaPlace(this.rs.getNString("FOUNDPLACE"));
					fa.setFaDate(this.rs.getNString("FOUNDDATE"));
					fa.setFaStatus(this.rs.getNString("FOUNDSTATUS"));
					fa.setFaLocation(this.rs.getNString("FOUNDLOCATION"));
					fa.setFaPostId(this.rs.getNString("FOUNDID"));
					fa.setFaPostDate(this.rs.getNString("FOUNDPOSTDATE"));
					fa.setFaColor(this.rs.getNString("FOUNDCOLOR"));
					fa.setFaCenterCode(this.rs.getNString("FOUNDCENTERCODE"));
					fa.setFaPerson(this.rs.getNString("LOSTPERSON"));
					list.add(fa);
					fa=null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	final ArrayList<LostArticleBean> getCenterLostList(Connection connection, CenterBean center)
	{
		ArrayList<LostArticleBean> list = null;
		String query="SELECT LA_MCCODE AS MAINCATEGORY,LA_SCCODE AS SUBCATEGORY,LA_CTNUMBER CONTROLLNUM,"
				+ "LA_NAME AS LOSTNAME,LA_PLACE LOSTPLACE,LA_DATE LOSTDATE,LA_STATUS LOSTSTATUS,"
				+ "LA_LOCATION AS LOSTLOCATION,LA_DETAIL AS LOSTCONTENT,LA_MMID AS LOSTID,LA_POSTDATE AS LOSTPOSTDATE,"
				+ "LA_COLOR AS LOSTCOLOR,LA_CTCODE AS LOSTCENTERCODE FROM LFDBA.LA WHERE "
				+ "LA_CTCODE=? AND LA_STATUS='P'";
		try {
			this.ps = connection.prepareStatement(query);
			this.ps.setNString(1, center.getCenterCode());
			
			this.rs =this.ps.executeQuery();
			if(this.rs.isBeforeFirst())
			{
				list = new ArrayList<LostArticleBean>();
				LostArticleBean la=null;
				while(this.rs.next())
				{
					la= new LostArticleBean();
					la.setLaCenterCode(this.rs.getNString("LOSTCENTERCODE"));
					la.setLaColor(this.rs.getNString("LOSTCOLOR"));
					la.setLaControlNumber(this.rs.getNString("CONTROLLNUM"));
					la.setLaDate(this.rs.getNString("LOSTDATE"));
					la.setLaLocation(this.rs.getNString("LOSTLOCATION"));
					la.setLaName(this.rs.getNString("LOSTNAME"));
					la.setLaPlace(this.rs.getNString("LOSTPLACE"));
					la.setLaPostDate(this.rs.getNString("LOSTPOSTDATE"));
					la.setLaPostId(this.rs.getNString("LOSTID"));
					la.setLaStatus(this.rs.getNString("LOSTSTATUS"));
					la.setLaSubCategoryCode(this.rs.getNString("SUBCATEGORY"));
					la.setLaMainCategoryCode(this.rs.getNString("MAINCATEGORY"));
					la.setLaDetail(this.rs.getNString("LOSTCONTENT"));
					list.add(la);
					la=null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	final CenterBean getCenterInfo(Connection connection, CenterBean center)
	{
		String query="SELECT CT_CODE AS CTCODE, CT_NAME AS CTNAME, CT_PIN AS CTPIN"
				+ "CT_PHONE AS CTPHONE, CT_ADDRESS AS CTADDR, CT_LOCODE AS CTLOCODE "
				+"FROM LFDBA.CT WHERE CT_CODE=? AND CT_NAME=?";
		try {
			this.ps = connection.prepareStatement(query);
			this.ps.setNString(1, center.getCenterCode());
			this.ps.setNString(2, center.getCenterName());
			
			this.rs =this.ps.executeQuery();
			if(this.rs.isBeforeFirst())
			{
				while(this.rs.next())
				{
					center.setCenterPhone(this.rs.getNString("CTPHONE"));
					center.setCenterMasterPw(this.rs.getNString("CTPIN"));
					center.setCenterLocationcode(this.rs.getNString("CTLOCODE"));
					center.setCenterAddress(this.rs.getNString("CTADDR"));
					center.setCenterCode(this.rs.getNString("CTCODE"));
					center.setCenterName(this.rs.getNString("CTNAME"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return center;
	}
	
	final MasterBean getCenterList(Connection connection, MasterBean master)
	{
		String query="SELECT CT_CODE AS CTCODE, CT_NAME AS CTNAME "
				+ "FROM LFDBA.SL ";
		try {
			this.ps = connection.prepareStatement(query);
			
			this.rs =this.ps.executeQuery();
			if(this.rs.isBeforeFirst())
			{
				master = new MasterBean();
				ArrayList<CenterBean> list = new ArrayList<CenterBean>();
				CenterBean center= new CenterBean();
				while(this.rs.next())
				{
					center.setCenterCode(this.rs.getNString("CTCODE"));
					center.setCenterName(this.rs.getNString("CTNAME"));
					list.add(center);
				}
				master.setCenterList(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return master;	
	}
	final int insCenter(Connection connection, CenterBean center)
	{
		int result=0;
		String dml = "INSERT INTO LFDBA.CT(CT_PIN,CT_CODE,CT_NAME"
				+",CT_PHONE,CT_ADDRESS,CT_LOCODE";
		
		try {
			this.ps = connection.prepareStatement(dml);
			this.ps.setNString(1, center.getCenterMasterPw());
			this.ps.setNString(2, center.getCenterCode());
			this.ps.setNString(3, center.getCenterName());
			this.ps.setNString(4, center.getCenterPhone());
			this.ps.setNString(5, center.getCenterAddress());
			this.ps.setNString(6, center.getCenterLocationcode());
			
			result =this.ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
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
