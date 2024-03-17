package com.siteinvokers.JDBC.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.siteinvokers.JDBC.model.Programmer;

@Repository
public class ProgrammerDAO {
	
	private JdbcTemplate template ;
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(Programmer programmer) {
		
		String sql 	="insert into programmer(id, name, tech) values (?,?,?)" ;
		
		
		int rows = template.update(sql, programmer.getId(), programmer.getName(), programmer.getTech() ) ;
		System.out.println("row/s affected "+ rows);
	}
	
	public List<Programmer> findAll(){
		String sql = "select * from programmer" ;
		
		RowMapper  mapper = new RowMapper() {
			public Programmer mapRow(ResultSet rs, int rowNum) throws SQLException{
				Programmer pr = new Programmer() ;
				pr.setId(rs.getInt(1)) ;
				pr.setName(rs.getString(2)) ;
				pr.setTech(rs.getString(3)) ;
				
				return pr ;
			}

			 
		} ;
		
		List<Programmer> programmers = template.query(sql, mapper );
		return programmers ;
	}
	

}
