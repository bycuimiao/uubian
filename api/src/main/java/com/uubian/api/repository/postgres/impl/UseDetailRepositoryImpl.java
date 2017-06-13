package com.uubian.api.repository.postgres.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.uubian.api.domain.postgres.UserDetail;
import com.uubian.api.repository.postgres.UseDetailRepository;
@Repository
public class UseDetailRepositoryImpl implements UseDetailRepository{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	
	
	public int save(UserDetail userDetail){
		String sql = "INSERT INTO user_detail (user_id, realname, domicile_country, domicile_province,domicile_city, domicile_county, headurl, sex, occupation, industry,summary_base, summary_detail) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			return jdbcTemplate.update(sql, userDetail.getUser_id(),userDetail.getRealname(),userDetail.getDomicile_country(),
					userDetail.getDomicile_province(),userDetail.getDomicile_city(),userDetail.getDomicile_county(),userDetail.getHeadurl(),userDetail.getSex(),
					userDetail.getOccupation(),userDetail.getIndustry(),userDetail.getSummary_base(),userDetail.getSummary_detail()
					);
		} catch (Exception e) {
			return 0;
		}
		
	}

	public int update(UserDetail userDetail) {
		String sql = "UPDATE user_detail SET realname=?, domicile_country=?,domicile_province=?,domicile_city=?,domicile_county=?,headurl=?,sex=?,occupation=?,industry=?,summary_base=?,summary_detail=? WHERE user_id=?";
		try {
			return jdbcTemplate.update(sql,userDetail.getRealname(),userDetail.getDomicile_country(),
					userDetail.getDomicile_province(),userDetail.getDomicile_city(),userDetail.getDomicile_county(),userDetail.getHeadurl(),userDetail.getSex(),
					userDetail.getOccupation(),userDetail.getIndustry(),userDetail.getSummary_base(),userDetail.getSummary_detail(),userDetail.getUser_id());
		} catch (Exception e) {
			return 0;
		}
	}
	
	
	public UserDetail getUserDetailById(long id){
		String sql = "SELECT * FROM user_detail WHERE user_id=?";
		RowMapper<UserDetail> rowMapper=new BeanPropertyRowMapper<UserDetail>(UserDetail.class);
		try {
			return jdbcTemplate.queryForObject(sql, rowMapper,id);
		} catch (Exception e) {
			return null;
		}
	}
}
