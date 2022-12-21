package services.generalfunction;

import java.sql.Connection;
import java.sql.SQLException;

import beans.FoundArticleBean;
import beans.LostArticleBean;
import beans.MemberBean;
import services.DataAccessObject;

public class GeneralDataAccessObject extends DataAccessObject {

	final int insRegLost(Connection connection, LostArticleBean la) {
		System.out.println("insRegLost");
		int result = 0;
		String dml = "INSERT INTO "
				+ "LFDBA.LA(LA_MCCODE,LA_UCCODE,LA_CTNUMBER,LA_NAME,LA_PLACE,LA_DATE,"
				+ "LA_CTCODE,LA_STATUS,LA_LOCATION, LA_DETAIL, LA_COLOR, LA_POSTDATE, LA_MMID,LA_TITLE,LA_PLACEDETAIL) "
				+ "VALUES "
				+ "(?,?,('L'||(SELECT LPAD(NVL(SUBSTR(MAX(LA_CTNUMBER),2),'0000000')+1,7,0) FROM LFDBA.LA)),?,?,TO_DATE(?,'YYYYDD'),?,DEFAULT,?,?,?,DEFAULT,?,?,?)";
				//(LA_MCCODE,LA_UCCODE,LA_CTNUMBER,LA_NAME,LA_PLACE,LA_DATE,LA_CTCODE,LA_STATUS,LA_LOCATION,LA_DETAIL,LA_COLOR,LA_POSTDATE,LA_MMID,LA_TITLE,LA_PLACEDETAIL)
		try {
			this.ps = connection.prepareStatement(dml);
			this.ps.setNString(1, la.getLaMainCategoryCode());
			this.ps.setNString(2, la.getLaSubCategoryCode());
			// CTNUMBER
			this.ps.setNString(3, la.getLaName());
			this.ps.setNString(4, la.getLaPlace());
			this.ps.setNString(5, la.getLaDate());
			this.ps.setNString(6, la.getLaCenterCode());
			// STATUS
			this.ps.setNString(7, la.getLaLocation());
			this.ps.setNString(8, la.getLaDetail());
			this.ps.setNString(9, la.getLaColor());
			// POSTDATE
			this.ps.setNString(10, la.getLaPostId());
			this.ps.setNString(11,la.getLaTitle());
			this.ps.setNString(12, la.getLaPlaceDetail());

			result = this.ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(result == 1 ? "ins성공" : "ins실패");
		return result;
	}
//	final String getUcCode(Connection connection, LostArticleBean la) {
//		System.out.println("getUcCode");
//		String UcCode = new String();
//		
//		String query = "SELECT UC_CODE AS UCCODE FROM LFDBA.SUBCATEGORIES WHERE UC_NAME=?";
//		
//		try {
//			this.ps = connection.prepareStatement(query);
//			this.rs=this.ps.executeQuery();
//			UcCode=rs.getNString("UCCODE");
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//		return UcCode;
//	}
	final int insRegFound(Connection connection, FoundArticleBean fa) {
		System.out.println("insRegFound");
		int result = 0;
		String dml = "INSERT INTO "
				+ "LFDBA.FA(FA_MCCODE,FA_UCCODE,FA_CTNUMBER,FA_NAME,FA_PLACE,FA_DATE,"
				+ "FA_CTCODE,FA_STATUS,FA_LOCATION, FA_DETAIL, FA_COLOR, FA_POSTDATE, FA_MMID,FA_TITLE,FA_PLACEDETAIL,FA_PERSON) "
				+ "VALUES "
				+ "(?,?,('F'||(SELECT LPAD(NVL(SUBSTR(MAX(FA_CTNUMBER),2),'0000000')+1,7,0) FROM LFDBA.FA)),?,?,TO_DATE(?,'YYYYDD'),?,DEFAULT,?,?,?,DEFAULT,?,?,?,?)";
				//(LA_MCCODE,LA_UCCODE,LA_CTNUMBER,LA_NAME,LA_PLACE,LA_DATE,LA_CTCODE,LA_STATUS,LA_LOCATION,LA_DETAIL,LA_COLOR,LA_POSTDATE,LA_MMID,LA_TITLE,LA_PLACEDETAIL)
		try {
			this.ps = connection.prepareStatement(dml);
			this.ps.setNString(1, fa.getFaMainCategoryCode());
			this.ps.setNString(2, fa.getFaSubCategoryCode());
			// CTNUMBER
			this.ps.setNString(3, fa.getFaName());
			this.ps.setNString(4, fa.getFaPlace());
			this.ps.setNString(5, fa.getFaDate());
			this.ps.setNString(6, fa.getFaCenterCode());
			// STATUS
			this.ps.setNString(7, fa.getFaLocation());
			this.ps.setNString(8, fa.getFaDetail());
			this.ps.setNString(9, fa.getFaColor());
			// POSTDATE
			this.ps.setNString(10, fa.getFaPostId());
			this.ps.setNString(11,fa.getFaTitle());
			this.ps.setNString(12, fa.getFaPlaceDetail());
			this.ps.setNString(13, fa.getFaPerson());
			result = this.ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(result == 1 ? "ins성공" : "ins실패");
		return result;
	}
	
	final Connection openConnection() {
		return this.openConnect();
	}

	final Connection openConnection(String userName, String password) {
		System.out.println("enter openConnection");
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
