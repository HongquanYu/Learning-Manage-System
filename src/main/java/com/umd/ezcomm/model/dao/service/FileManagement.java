package com.umd.ezcomm.model.dao.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileManagement {

	public String storeSyllabus(MultipartFile multipartFile, String fileName) throws IOException;

	public byte[] retrieveSyllabus(String fileName);

	public boolean isSyllabusPublished(String fileName);

	public boolean publishSyllabus(String fileName);

	public boolean unPublishSyllabus(String fileName);

	public boolean doesFileExist(String fileName);
}
