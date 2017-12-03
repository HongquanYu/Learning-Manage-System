package com.umd.ezcomm.model.dao.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.umd.ezcomm.model.dao.service.FileManagement;

public class FileManagementImpl implements FileManagement {
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public String storeSyllabus(MultipartFile multipartFile, String fileName) throws IOException {

		String lReturnString = "";

		// save to db
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
	public byte[] retrieveSyllabus(String fileName) {

		byte[] lFileData = null;
		try {
			if (isSyllabusPublished(fileName)) {
				Path lPath = Paths.get("Syllabus-" + fileName + "-1.pdf");
				lFileData = Files.readAllBytes(lPath);
			} else {
				Path lPath = Paths.get("Syllabus-" + fileName + ".pdf");
				lFileData = Files.readAllBytes(lPath);
			}
		} catch (Exception e) {
			System.out.println("Error finding file");
		}
		return lFileData;
	}

	public void writeFile(String filename, MultipartFile file) throws IOException {
		File fileToBeWritten = new File(filename);
		fileToBeWritten.createNewFile();
		FileOutputStream fos = new FileOutputStream(fileToBeWritten, false);
		fos.write(file.getBytes());
		fos.close();
	}

	@Override
	public boolean isSyllabusPublished(String fileName) {
		// save to db
		File f = new File("Syllabus-" + fileName + "-1.pdf");
		if (f.exists() && !f.isDirectory()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean publishSyllabus(String fileName) {
		File f = new File("Syllabus-" + fileName + ".pdf");
		if (f.exists() && !f.isDirectory()) {
			f.renameTo(new File("Syllabus-" + fileName + "-1.pdf"));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean unPublishSyllabus(String fileName) {
		File f = new File("Syllabus-" + fileName + "-1.pdf");
		if (f.exists() && !f.isDirectory()) {
			f.renameTo(new File("Syllabus-" + fileName + ".pdf"));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean doesFileExist(String fileName) {
		File f = new File("Syllabus-" + fileName + "-1.pdf");
		if (f.exists() && !f.isDirectory()) {
			f.renameTo(new File("Syllabus-" + fileName + ".pdf"));
			return true;
		} else {
			return false;
		}
	}
}
