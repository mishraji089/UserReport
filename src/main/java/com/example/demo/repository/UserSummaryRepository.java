package com.example.demo.repository;

import com.example.demo.entity.UserSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserSummaryRepository extends JpaRepository<UserSummary, Integer> {

    @Query(value = "SELECT user_name FROM rgsa.user_summary WHERE user_type=:type ORDER BY user_name", nativeQuery = true)
    List<String> findNamesByType(@Param("type") String type);
    
    
    @Query(value = "SELECT user_name, user_login_id, assigned_states\r\n"
    		+ "FROM rgsa.user_assigned_states_summary\r\n"
    		+ "WHERE user_name = :name;", nativeQuery = true)
    
    	List<Object[]> getUserDetails(@Param("name") String name);
    	
    	@Query(value = "SELECT * \r\n"
    			+ "FROM rgsa.user_assigned_states_summary\r\n"
    			+ "ORDER BY user_name;",
    		       nativeQuery = true)
    		List<Object[]> getAllUserDetails();
}
