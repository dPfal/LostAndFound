package services.auth;

import java.sql.Connection;
import java.sql.SQLException;

import beans.MemberBean;



public class AuthDataAccessObject extends services.DataAccessObject{

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
	
	final int PasswordCheck(Connection connect,MemberBean member) {
		int result =0;
		String query = "SELECT COUNT(*) as COUNT FROM LFDBA.MEMBERS WHERE MM_ID=? AND MM_PW=?";
		try {
			
		this.ps = connect.prepareStatement(query);
		this.ps.setNString(1, member.getMM_ID());
		this.ps.setNString(2, member.getMM_PW());
		this.rs= this.ps.executeQuery();
		
		while (this.rs.next()) {
			result= rs.getInt("COUNT");
		}
		
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return result;
	}
	final int LoginCheck(Connection connect,MemberBean member) {
		int result =0;
		String query = "SELECT COUNT(*) as COUNT FROM LFDBA.MEMBERS WHERE MM_ID=?";
		try {
			
		this.ps = connect.prepareStatement(query);
		this.ps.setNString(1, member.getMM_ID());
		this.rs= this.ps.executeQuery();
		
		while (this.rs.next()) {
			result= rs.getInt("COUNT");
		}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return result;
	}
//
//	final int insAccessLog(Connection connect , MemberBean member) {
//		
//		int result =0;
//		String dml = "INSERT INTO LFDBA.AC(AC_DATE,AC_TYPE, AC_IP ) "
//				+ "VALUES(DEFAULT, ?, ?)";
//		try {
//			this.ps=connect.prepareStatement(dml);
//			this.ps.setNString(1,member.getAccessInfo().get(0).getAccessType());
//			this.ps.setNString(2,member.getAccessInfo().get(0).getAccessIp());
//			
//			result = this.ps.executeUpdate();
//			
//		} catch (SQLException e) {e.printStackTrace();}
//		return result;
//
//	
//
//	}
	

}
