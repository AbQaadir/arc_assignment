package com.arc.imageprocessingms.image;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileData, Long> {

    Optional<FileData> findById(long fileId);
}
