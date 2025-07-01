package Windows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class RegistrationDataCheck {
	
//	public Boolean checkFirstName(String first_name, String column, String table, String row, String value, PreparedStatement preparedStatement) throws SQLException {
//		preparedStatement.setString(1, column);preparedStatement.setString(2, table);preparedStatement.setString(3, row);preparedStatement.setString(4, value);
//		ResultSet rSet = preparedStatement.executeQuery();
//		if(rSet.next()==true) {
//			//lblPNED.setText("Already exists");
//			return true;
//		}
//		return false;
//	};
//	
//	public Boolean checkLastName(String last_name, String column, String table, String row, String value, PreparedStatement preparedStatement) throws SQLException{
//		preparedStatement.setString(1, column);preparedStatement.setString(2, table);preparedStatement.setString(3, row);preparedStatement.setString(4, value);
//		return false;
//	};
//	
//	public Boolean checkFathersName(String fathers_name, String column, String table, String row, String value, PreparedStatement preparedStatement) throws SQLException{
//		preparedStatement.setString(1, column);preparedStatement.setString(2, table);preparedStatement.setString(3, row);preparedStatement.setString(4, value);
//		return false;
//	};
	
	public abstract boolean isUnique();
	
//	public Boolean checkEmailForUnique(Connection connection, String Email) throws SQLException{
//		connection.prepareStatement("SELECT email from patient WHERE = ?");
//		preparedStatement.setString(1, column);preparedStatement.setString(2, table);
//		preparedStatement.setString(3, row);preparedStatement.setString(4, Email);
//		ResultSet rSet = preparedStatement.executeQuery();
//		if(rSet.next()==true) {
//			return true;
//		}
//		return false;
//	};
	
}
