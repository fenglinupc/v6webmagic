package us.codecraft.webmagic.downloader.log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class SaveLogMysql {

	public static void saveLogs(String taskId, String url, String status, String time) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		Connection conn = DBUtils.getConnection();
		String sql = "INSERT INTO CRW_TASK_LOG VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uuid);
			pstmt.setString(2, taskId);
			pstmt.setString(3, url);
			pstmt.setString(4, "");
			pstmt.setString(5, status);
			pstmt.setString(6, time);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtils.closeConnection(conn);
		}

	}

	
}
