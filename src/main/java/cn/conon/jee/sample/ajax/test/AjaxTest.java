package cn.conon.jee.sample.ajax.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;

import cn.conon.jee.sample.ajax.dao.LocationDao;
import cn.conon.jee.sample.ajax.db.ConnectionContext;
import cn.conon.jee.sample.ajax.db.DBManager;
import cn.conon.jee.sample.ajax.domain.Location;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class AjaxTest {

	@Test
	public void testBaseDaoGetForList() {
		Connection conn = DBManager.getConnection();
		ConnectionContext.bindTo(conn);
		LocationDao locationDao = new LocationDao();
		String sql = "SELECT location_id locationId, city FROM locations WHERE location_id > ?";

		List<Location> locations = locationDao.getForList(sql, 2000);
		System.out.println(locations);

		ConnectionContext.remove();
		DBManager.releaseConnection(conn);
	}

	@Test
	public void testBaseDaoGet() {
		Connection conn = DBManager.getConnection();
		ConnectionContext.bindTo(conn);
		LocationDao locationDao = new LocationDao();
		String sql = "SELECT location_id locationId, city FROM locations WHERE location_id = ?";

		Location location = locationDao.get(sql, 3000);
		System.out.println(location.getCity());

		ConnectionContext.remove();
		DBManager.releaseConnection(conn);
	}

	@Test
	public void testC3p0() throws SQLException {
		DataSource ds = new ComboPooledDataSource("ajaxApp");
		System.out.println(ds.getConnection());
	}

}
