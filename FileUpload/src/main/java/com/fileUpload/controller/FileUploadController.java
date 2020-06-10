package com.fileUpload.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileUpload.model.Image;
import com.fileUpload.repository.FileUploadRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FileUploadController {

	@Autowired
	private FileUploadRepository fileUploadRepository;


	@PostMapping("/image")
	public ResponseEntity<?> uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		
		Image image = new Image(file.getOriginalFilename(),file.getContentType(),compressBytes(file.getBytes()));
		System.out.println(image.getImageByte());
		fileUploadRepository.save(image);
		return ResponseEntity.ok("file uploaded");
	}
	
	@GetMapping(path = { "/image/{imageName}" })
	public Image getImage(@PathVariable("imageName") String imageName) throws IOException {
		
		final Optional<Image> retrievedImage = fileUploadRepository.findByName(imageName);
		Image image = new Image(retrievedImage.get().getName(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getImageByte()));
		image.setId(retrievedImage.get().getId());
		return image;
	}
	
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		}
		catch (IOException e) {
			
		}
			
		return outputStream.toByteArray();
	}
	
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
}
