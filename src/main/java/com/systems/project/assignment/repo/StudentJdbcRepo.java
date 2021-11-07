package com.systems.project.assignment.repo;

import com.systems.project.assignment.Dto.StudentDto;
import com.systems.project.assignment.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class StudentJdbcRepo extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    //get all student profile
    public List<StudentDto> getAllStudents(){
        String sql = "Select * from libdb.students;";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<StudentDto> result = new ArrayList<StudentDto>();
        for(Map<String, Object> row:rows){
            StudentDto stu = new StudentDto();
            stu.setFirstName((String)row.get("first_name"));
            stu.setLastName((String)row.get("last_name"));
            stu.setStudentId((int)row.get("student_id"));
            stu.setActiveStatus((boolean) row.get("active_status"));
            stu.setRollNo((String) row.get("roll_no"));

            result.add(stu);
        }
        return result;
    }

    //get single student profile
    public StudentDto getEmployeeById(int stuId) {
        String sql = "SELECT * FROM libdb.students WHERE student_id = ?";
        return (StudentDto) getJdbcTemplate().queryForObject(sql, new Object[]{stuId}, new RowMapper<StudentDto>(){
            @Override
            public StudentDto mapRow(ResultSet rs, int rwNumber) throws SQLException {
                StudentDto stu = new StudentDto();
                stu.setStudentId(rs.getInt("student_id"));
                stu.setFirstName(rs.getString("first_name"));
                stu.setLastName(rs.getString("last_name"));
                stu.setActiveStatus(rs.getBoolean("active_status"));
                stu.setRollNo(rs.getString("roll_no"));
                return stu;
            }
        });
    }

    //Create new student
    public void insertStudent(StudentDto stu){
        String sql = "INSERT INTO libdb.students (student_id,active_status,first_name,last_name,roll_no) "+
                "VALUES(?,?,?,?,?)" ;
        getJdbcTemplate().update(sql, new Object[]{
                stu.getStudentId(), stu.isActiveStatus(),stu.getFirstName(),stu.getLastName(),stu.getRollNo()
        });
    }
}
