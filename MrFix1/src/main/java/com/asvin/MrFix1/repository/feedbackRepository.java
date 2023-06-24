package com.asvin.MrFix1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asvin.MrFix1.Model.feedback;
@Repository
public interface feedbackRepository extends JpaRepository<feedback,Integer>{

}
