package com.umd.ezcomm.model.dao.service.impl;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import com.umd.ezcomm.model.dao.service.storageService;

/** @author: Hongquan Yu
 *  @date: Dec 2, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public class storageServiceImpl implements storageService {

	/* (non-Javadoc)
	 * @see com.umd.ezcomm.model.dao.service.storageService#init()
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.umd.ezcomm.model.dao.service.storageService#store(org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public void store(MultipartFile file) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.umd.ezcomm.model.dao.service.storageService#loadAll()
	 */
	@Override
	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.umd.ezcomm.model.dao.service.storageService#load(java.lang.String)
	 */
	@Override
	public Path load(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.umd.ezcomm.model.dao.service.storageService#loadAsResource(java.lang.String)
	 */
	@Override
	public Resource loadAsResource(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.umd.ezcomm.model.dao.service.storageService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
