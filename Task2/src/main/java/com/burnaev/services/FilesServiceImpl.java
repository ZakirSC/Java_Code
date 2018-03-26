package com.burnaev.services;

import com.burnaev.forms.CreateFileForm;
import com.burnaev.models.FileInfo;
import com.burnaev.models.Sort;
import com.burnaev.repositories.FilesInfoRepository;
import com.burnaev.repositories.UsersRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class FilesServiceImpl implements FilesService {
    @Autowired
    private FilesInfoRepository filesInfoRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Value(value = "${storage.path}")
    private String storagePath;


    @Override
    public FileInfo getFileById(Long id) {
        return filesInfoRepository.findOne(id);
    }

    @Override
    @SneakyThrows
    public void createFile(CreateFileForm createFileForm, Long id) {
        FileInfo fileInfo = FileInfo.builder()
                .originalName(createFileForm.getName())
                .description(createFileForm.getDescription())
                .author(usersRepository.findOne(id))
                .uploadTime(LocalDateTime.now())
                .build();
        String newName = UUID.randomUUID().toString().replace("-", "");
        fileInfo.setStorageName(newName + ".txt");
        fileInfo.setUrl(storagePath + "\\" + fileInfo.getStorageName());
        FileOutputStream fop = null;
        File file;

        file = new File(fileInfo.getUrl());
        fop = new FileOutputStream(file);

        if (!file.exists()) {
            file.createNewFile();
        }

        byte[] contentInBytes = createFileForm.getText().getBytes();

        fop.write(contentInBytes);
        fop.flush();
        fop.close();
        filesInfoRepository.save(fileInfo);
    }

    @Override
    public void delete(Long fileId) {
        filesInfoRepository.delete(fileId);
    }


    @Override
    public List<FileInfo> getAllFiles() {
        return filesInfoRepository.findAll();
    }

    @Override
    public List<FileInfo> getSortedFiles(Long id, Sort method) {
        switch (method) {
            case NAME_UP: return filesInfoRepository.findAllByAuthorIdOrderByOriginalNameAsc(id);
            case NAME_DOWN: return filesInfoRepository.findAllByAuthorIdOrderByOriginalNameDesc(id);
            case TIME_UP: return filesInfoRepository.findAllByAuthorIdOrderByUploadTimeAsc(id);
            case TIME_DOWN: return filesInfoRepository.findAllByAuthorIdOrderByUploadTimeDesc(id);
        }
        return null;
    }

    @Override
    public List<FileInfo> findByName(String name) {
        return filesInfoRepository.findAllByOriginalNameIgnoreCase(name);
    }
}
