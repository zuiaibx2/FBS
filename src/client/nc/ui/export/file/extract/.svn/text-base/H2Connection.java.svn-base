package nc.ui.export.file.extract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nc.pub.Constants;

/**
 * @ClassName: H2Connection <b> h2数据库的连接与关闭 </b>
 *             <p>
 *             在此处添加此类的描述信息
 *             </p>
 *             创建日期: 2016年10月15日 上午10:28:52
 * @Author 王凯强
 * @Version
 */
public class H2Connection {
	private static String dbname = "sdatas";
	private static String username = "avic";
	private static String password = "1";
	private static boolean autocommit = false;

	public static Connection getConnection(String h2dbHostFolderPath)
			throws Exception, ClassNotFoundException {
		Class.forName("org.h2.Driver");

		Connection connection = DriverManager.getConnection("jdbc:h2:file:"
				+ h2dbHostFolderPath + Constants.SEP + dbname, username,
				password);
		connection.setAutoCommit(autocommit);
		return connection;
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeResutSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
