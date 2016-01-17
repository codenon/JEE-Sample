package cn.conon.jee.sample.ajax.db;

import java.sql.Connection;

public class ConnectionContext {

	private static final ThreadLocal<Connection> connections = new ThreadLocal<Connection>();

	private ConnectionContext() {
	}

	/**
	 * 返回当前的 Connection 对象
	 * 
	 * @return
	 */
	public static Connection getCurrentConnection() {
		Connection conn = null;
		conn = connections.get();
		return conn;
	}

	/**
	 * 把数据库连接绑定到当前线程
	 * 
	 * @param conn
	 */
	public static void bindTo(Connection conn) {
		if (conn != null)
			connections.set(conn);
	}

	/**
	 * 解除和当前线程绑定的数据库连接
	 */
	public static void remove() {
		connections.remove();
	}
}
