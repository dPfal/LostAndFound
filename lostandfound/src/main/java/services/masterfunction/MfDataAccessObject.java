package services.masterfunction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.CenterBean;
import beans.MemberBean;


public class MfDataAccessObject extends services.DataAccessObject {
	final int insCenter(Connection connection, CenterBean center)
	{
		int result=0;
		String dml = "INSERT INTO LFDBA.SL(SL_ID,SL_PIN,SL_CODE,SL_NAME"
				+",SL_PHONE,SL_ADDRESS,SL_LOCODE";
		
		try {
			this.ps = connection.prepareStatement(dml);
			this.ps.setNString(1, center.getCenterMasterId());
			this.ps.setNString(2, center.getCenterMasterPw());
			this.ps.setNString(3, center.getCenterCode());
			this.ps.setNString(4, center.getCenterName());
			this.ps.setNString(5, center.getCenterPhone());
			this.ps.setNString(6, center.getCenterAddress());
			this.ps.setNString(7, center.getCenterLocationcode());
			
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
