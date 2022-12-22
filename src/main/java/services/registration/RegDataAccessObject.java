package services.registration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.MemberBean;


public class RegDataAccessObject extends services.DataAccessObject {
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
	
	final int selDupIdCheck(Connection connection, MemberBean member) {
		int result = 0;
		String query = "SELECT ((SELECT COUNT(MM_ID) FROM LFDBA.MM WHERE MM_ID=?) + (SELECT COUNT(CT_CODE) FROM LFDBA.CT WHERE CT_CODE =?)) AS IDCOUNT FROM DUAL";
		try {
			this.ps=connection.prepareStatement(query);
			this.ps.setNString(1, member.getMM_ID());
			this.ps.setNString(2, member.getMM_ID());
			this.rs=this.ps.executeQuery();
			if(this.rs.next()) {
				result = rs.getInt("IDCOUNT");
			}
		}
		catch(SQLException e ) {
			e.printStackTrace();
		}
		return result;
	}
	
	final int insMember(Connection connection, MemberBean member) {
		int result = 0;
		String dml = "INSERT INTO LFDBA.MM(MM_ID,MM_PW,MM_NAME,MM_EMAIL,MM_PHONE,MM_ADDRESS,MM_ADDRDETAIL) VALUES "
				+ "(?,?,?,?,?,?,?)" ;
		try {
			this.ps=connection.prepareStatement(dml);
			this.ps.setNString(1, member.getMM_ID());
			this.ps.setNString(2, member.getMM_PW());
			this.ps.setNString(3, member.getMM_NAME());
			this.ps.setNString(4, member.getMM_EMAIL());
			this.ps.setNString(5, member.getMM_PHONE());
			this.ps.setNString(6, member.getMM_ADDRESS());
			this.ps.setNString(7, member.getMM_ADDRDETAIL());
			result= this.ps.executeUpdate();
		}
		catch(SQLException e ) {
			e.printStackTrace();
		}
		return result;
	}
}
