package com.fileUpload.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fileUpload.model.Image;

public interface FileUploadRepository extends JpaRepository<Image, Long>{

		Optional<Image> findByName(String imageName);

}
