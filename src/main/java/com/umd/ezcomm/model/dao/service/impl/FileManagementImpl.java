package com.umd.ezcomm.model.dao.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.umd.ezcomm.model.dao.service.FileManagement;

public class FileManagementImpl implements FileManagement {

	@Override
	public String storeFile(MultipartFile multipartFile, String fileName) throws IOException {

		String lReturnString = "";

		if (multipartFile.getBytes() != null) {
			File f = new File(fileName);
			if (f.exists() && !f.isDirectory()) {
				lReturnString = "Replaced Previous Syllabus with new file";
			} else {
				lReturnString = "Successfully Uploaded Syllabus";
			}
			writeFile(fileName, multipartFile);
		}

		return lReturnString;
	}

	@Override
	public boolean retrieveFile(String somethign) {
		// TODO Auto-generated method stub
		return false;
	}

	public void writeFile(String filename, MultipartFile file) throws IOException {
		File fileToBeWritten = new File(filename);
		fileToBeWritten.createNewFile();
		FileOutputStream fos = new FileOutputStream(fileToBeWritten, false);
		fos.write(file.getBytes());
		fos.close();
	}

}
