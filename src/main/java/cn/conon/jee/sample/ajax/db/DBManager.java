package cn.conon.jee.sample.ajax.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBManager {

	/**
	 * 工具类, 不建议对其进行初始化
	 */
	private DBManager() {
	}

	private static DataSource ds = null;

	/**
	 * 初始化数据库连接池, 且只被初始化一次
	 */
	static {
		ds = new ComboPooledDataSource("ajaxApp");
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			if (ds != null)
				return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("从数据源中获取数据库连接异常!");
		}

		return null;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param conn
	 */
	public static void releaseConnection(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("释放连接异常!");
		}
	}

}
