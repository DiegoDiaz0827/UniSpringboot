package com.campus.uni.repository;

import com.campus.uni.Entities.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentdetailRepository extends JpaRepository<StudentDetail,Long> {

}
