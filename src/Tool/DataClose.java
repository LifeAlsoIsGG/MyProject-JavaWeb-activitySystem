package Tool;

import java.sql.*;

public class DataClose {

	// �ر����ӷ���,����Statement�Ĺر�
	public static void DataClose(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (final SQLException e) {
			e.printStackTrace();

		}

	}

	// �������أ�����PreparedStatement�Ĺر�
	public static void DataClose(ResultSet rs, PreparedStatement pstmt,
			Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (final SQLException e) {
			e.printStackTrace();

		}

	}

	// �������أ�����PreparedStatement��Statement�Ĺر�
	public static void DataClose(ResultSet rs, Statement stmt,
			PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (final SQLException e) {
			e.printStackTrace();

		}

	}
}
