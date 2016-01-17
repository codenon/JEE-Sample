package cn.conon.jee.sample.ajax.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.conon.jee.sample.ajax.db.ConnectionContext;

public class BaseDao<T> {

	private static QueryRunner queryRunner = new QueryRunner();
	private Class<T> entityClass;
	
	public BaseDao(){
		Type type = this.getClass().getGenericSuperclass();
		
		if(type instanceof ParameterizedType){
			ParameterizedType pt = (ParameterizedType) type;
			Type [] args = pt.getActualTypeArguments();
			
			if(args.length > 0){
				if(args[0] instanceof Class){
					entityClass = (Class<T>) args[0];
				}
			}
		}
		
	}
	
	/**
	 * 根据传入的 SQL 语句获取实体对象的集合
	 */
	@SuppressWarnings("unchecked")
	public List<T> getForList(String sql, Object ... args){
		List<T> list = null;
		
		Connection conn = null;
		
		try {
			conn = ConnectionContext.getCurrentConnection();
			list = (List<T>) queryRunner.query(conn, sql, new BeanListHandler(entityClass), args);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("获取实体集合对象异常");
		} 
		
		return list;
	}
	
	/**
	 * 根据传入的 SQL 语句获取一个实体对象
	 */
	public T get(String sql, Object ... args){
		T t = null;
		
		Connection conn = null;
		
		try {
			conn = ConnectionContext.getCurrentConnection();
			t = (T) queryRunner.query(conn, sql, new BeanHandler(entityClass), args);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("获取实体对象异常");
		} 
		
		return t;
	}
	
}
