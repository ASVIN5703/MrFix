package com.asvin.MrFix1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asvin.MrFix1.Model.Complaint;
import com.google.common.base.Optional;
import com.itextpdf.io.image.ImageData;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Integer> {

	//java.util.Optional<Complaint> findOne(String fileName);
	
	/* Optional<ImageData> findByName(String fileName); */
}
