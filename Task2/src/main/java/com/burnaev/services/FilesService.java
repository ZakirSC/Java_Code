package com.burnaev.services;


import com.burnaev.forms.CreateFileForm;
import com.burnaev.models.FileInfo;
import com.burnaev.models.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FilesService {
    FileInfo getFileById(Long id);

    void createFile(CreateFileForm createFileForm, Long id);

    void delete(Long fileId);

    List<FileInfo> getAllFiles();

    List<FileInfo> getSortedFiles(Long id, Sort method);

    List<FileInfo> findByName(String name);
}
