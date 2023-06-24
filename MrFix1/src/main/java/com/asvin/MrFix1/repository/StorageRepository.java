package com.asvin.MrFix1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asvin.MrFix1.Model.ImageData;

public interface StorageRepository extends JpaRepository<ImageData,Long> {


    Optional<ImageData> findByName(String fileName);
}