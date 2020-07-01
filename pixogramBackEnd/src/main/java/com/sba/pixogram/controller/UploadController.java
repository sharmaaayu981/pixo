package com.sba.pixogram.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.sba.pixogram.entity.ImageUrl;
import com.sba.pixogram.entity.UploadPic;
import com.sba.pixogram.repository.UploadRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	UploadRepository uploadRepository;

	List<String> files = new ArrayList<String>();
	
	@PostMapping("/storeImages/{userId}")
	public UploadPic storeFile(@RequestParam("file") MultipartFile file,@PathVariable long userId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        UploadPic dbFile = new UploadPic(fileName, file.getContentType(), file.getBytes(),userId); 
        return uploadRepository.save(dbFile);
    }

	 @GetMapping("/getUserMedia/{userId}")
	 public List<ImageUrl> getUserMedia(@PathVariable long userId) throws IOException {	 
		 ArrayList<UploadPic> dbFile = new ArrayList<UploadPic>(); 
	     List<ImageUrl> img = new ArrayList<ImageUrl>();
	     dbFile=uploadRepository.findById(userId);
	     for(UploadPic uploadPic: dbFile) {
	    	 byte[] blob= uploadPic.getData();
	    	 String file_name = "C:\\Users\\Public\\EclipseImages" + userId + "_" + uploadPic.getFileName();
	    	 File file = new File(file_name);
	    	 FileOutputStream os = new FileOutputStream(file);
	    	 os.write(blob);
	    	 os.close();
	    	 ImageUrl  imgUrl = new ImageUrl();
	    	 imgUrl.setUrl(file_name);
	    	 img.add(imgUrl);
	     }
	     return img;
	 }
}
