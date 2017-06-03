package com.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.test.pojo.Customer;

/**
 * JdbcDaoSupport , 封装了jdbcTemplate和dataSource
 * 类中无dataSource变量，但
 * 配置文件里需要配置dataSource property
 * --------spring提供
 * @author suo
 *
 */
public class JdbcCustomerDaoPlus extends JdbcDaoSupport implements CustomerDao{
	//no need to set datasource here
	@Override
	public void insert(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CUSTOMER " +
				"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
					 
			getJdbcTemplate().update(sql, 
					new Object[]{ customer.getCusId(),customer.getName(),customer.getAge()
			});
	}

	@Override
	public Customer findByCustomerId(int cusId) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
		return (Customer)getJdbcTemplate().queryForObject(sql, new Object[]{cusId},new RowMapper<Customer>(){
			@Override
			public Customer mapRow(ResultSet rs, int paramInt) throws SQLException {
				Customer customer = new Customer(rs.getInt("CUST_ID"), rs.getString("NAME"), rs.getInt("Age"));
				return customer;
			}
		});
	}

}
