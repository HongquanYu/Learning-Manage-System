package com.umd.ezcomm.model.dao.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileManagement {

	public String storeFile(MultipartFile multipartFile, String fileName) throws IOException;

	public boolean retrieveFile(String fileName);
}
