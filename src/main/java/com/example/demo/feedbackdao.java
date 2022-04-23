package com.example.demo;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//use autowire this EproductDao object to main controller
@Repository
public class feedbackdao {

	@Autowired
	JdbcTemplate template;
	
	// setter method
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Feedbackentity> getfeedback() {
		return template.query("select * from feedback", new RowMapper<Feedbackentity>() {
			public Feedbackentity mapRow(ResultSet rs, int row) throws SQLException {
				Feedbackentity e = new Feedbackentity();
				e.setID(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setFeedback(rs.getString(3));
				e.setDate(rs.getString(4));
				return e;
			}
		});
	}

	public int addfeedback(Feedbackentity product) {
		return template.update("INSERT INTO feedback (ID, name, feedback,date) VALUES(?,?,?,?)",
				new Object[] { product.getID(), product.getName(), product.getFeedback(), product.getDate() });
	}

	public Feedbackentity getByName(String name) {
		Feedbackentity entity = template.queryForObject("select * from feedback where name=?",
				BeanPropertyRowMapper.newInstance(Feedbackentity.class), name);
		return entity;
	}
}