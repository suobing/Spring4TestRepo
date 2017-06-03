package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.test.pojo.Customer;

public class JdbcCustomerDao implements CustomerDao{
	
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;//spring提供的jdbc模板
	
//	@Override
//	public void insert(Customer customer) {
//		String sql = "INSERT INTO CUSTOMER " +
//				"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
//		Connection conn = null;
//		try {
//			conn = dataSource.getConnection();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, customer.getCusId());
//			ps.setString(2, customer.getName());
//			ps.setInt(3, customer.getAge());
//			
//			ps.executeUpdate();
//			ps.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			if(conn!=null){
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	@Override
	public void insert(Customer customer) {
		String sql = "INSERT INTO CUSTOMER " +
				"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[]{customer.getCusId(),customer.getName(),customer.getAge()});
		
	}
	
	@Override
	public Customer findByCustomerId(int cusId) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cusId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(
					rs.getInt("CUST_ID"),
					rs.getString("NAME"), 
					rs.getInt("Age")
				);
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

//	public DataSource getDataSource() {
//		return dataSource;
//	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}	
}
