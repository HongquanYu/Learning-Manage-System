package com.umd.ezcomm.model.dao.service;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/** @author: Hongquan Yu
 *  @date: Dec 2, 2017
 *
 *  @From: University of Maryland, College Park
 *  @Email: hyu12346@terpmail.umd.edu
 */
public interface storageService {
    public void init();

    public void store(MultipartFile file);

    public Stream<Path> loadAll();

    public Path load(String filename);

    public Resource loadAsResource(String filename);

    public void deleteAll();
}
