package com.umd.ezcomm.model.dao.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

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
	public String storeAssignment(MultipartFile multipartFile, String fileName) throws IOException {

		String lReturnString = "";

		// save to db
		if (multipartFile.getBytes() != null) {
			File f = new File(fileName);
			if (f.exists() && !f.isDirectory()) {
				lReturnString = "Replaced Previous Assignment with new file";
			} else {
				lReturnString = "Successfully Uploaded Assignment";
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

	public boolean isAssignmentPublished(String fileName) {
		// save to db
		File f = new File(fileName + "-1.pdf");
		if (f.exists() && !f.isDirectory()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isStudentAssignmentPublished(String fileName) {
		// save to db
		File f = new File(fileName + "-1.pdf");
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

	public byte[] retrieveAssignment(String fileName) {
		byte[] lFileData = null;
		try {

			System.out.println("File Name: " + fileName);
			if (isAssignmentPublished(fileName)) {
				Path lPath = Paths.get(fileName + "-1.pdf");
				lFileData = Files.readAllBytes(lPath);
			} else {
				Path lPath = Paths.get(fileName + ".pdf");
				lFileData = Files.readAllBytes(lPath);
			}
		} catch (Exception e) {
			System.out.println("Error finding file");
		}
		return lFileData;
	}

	private boolean filePrefix(File f, String pre) {

		// return pre.equals(f.getName().substring(0, pre.length()));

		for (int i = 0; i < 8; ++i)
			if (f.getName().charAt(i) != pre.charAt(i))
				return false;

		return true;
	}

	private String middleName(String name) {
		String mid = "";

		for (int i = 8; i < name.length(); ++i) {
			if (name.charAt(i) != '-') {
				mid += name.charAt(i);
			} else {
				break;
			}
		}

		return mid;
	}

	@Override
	public List<String> retrieveAssignment() {
		List<String> assignments = new LinkedList<>();

		File[] files = new File(".").listFiles();

		for (File f : files) {
			if (!f.isDirectory() && filePrefix(f, "ENPM613-")) {
				assignments.add(middleName(f.getName()));
			}
		}

		return assignments;
	}

	public byte[] retrieveAssignment(String string, String lFileName) {
		byte[] lFileData = null;
		try {

			System.out.println("Finding files starting with " + lFileName);
			File[] foundFiles = new File(".").listFiles();
			for (int i = 0; i < foundFiles.length; i++) {
				if (foundFiles[i].getName().startsWith(lFileName)) {

					System.out.println("filename in loop:" + foundFiles[i].getName());
					lFileName = foundFiles[i].getName();
					break;
				}
			}
			System.out.println("Found file in student retrieve assignment " + lFileName);
			System.out.println("Student download assignment File Name: " + lFileName);
			if (isStudentAssignmentPublished(lFileName)) {
				Path lPath = Paths.get(lFileName + "-1");
				lFileData = Files.readAllBytes(lPath);
			} else {
				Path lPath = Paths.get(lFileName + "");
				lFileData = Files.readAllBytes(lPath);
			}
		} catch (Exception e) {
			System.out.println("Error finding file");
		}
		return lFileData;
	}

}
