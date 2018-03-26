package com.burnaev.repositories;


import com.burnaev.models.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilesInfoRepository extends JpaRepository<FileInfo, Long>{
    FileInfo findOneByStorageName(String fileName);
    List<FileInfo> findAllByAuthorIdOrderByOriginalNameAsc(Long authorId);
    List<FileInfo> findAllByAuthorIdOrderByOriginalNameDesc(Long authorId);
    List<FileInfo> findAllByAuthorIdOrderByUploadTimeAsc(Long authorId);
    List<FileInfo> findAllByAuthorIdOrderByUploadTimeDesc(Long authorId);

    List<FileInfo> findAllByOriginalNameIgnoreCase(String name);
}
