package com.example.demo.repository;

import com.example.demo.entity.UserSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserSummaryRepository extends JpaRepository<UserSummary, Integer> {

    @Query(value = "SELECT user_name FROM rgsa.user_summary WHERE user_type=:type ORDER BY user_name", nativeQuery = true)
    List<String> findNamesByType(@Param("type") String type);
    
    
    @Query(value = "SELECT user_name, user_login_id, user_type, assigned_states " +
            "FROM rgsa.user_master_summary " +
            "WHERE user_name = :name AND user_type = :type",
            nativeQuery = true)
    List<Object[]> getUserDetails(@Param("name") String name,
                                 @Param("type") String type);
    	
    @Query(value = "SELECT user_name, user_login_id, user_type, assigned_states " +
            "FROM rgsa.user_master_summary " +   // ✅ space added
            "ORDER BY user_name",
            nativeQuery = true)
    List<Object[]> getAllUserDetails();
}
