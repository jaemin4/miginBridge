package com.v02.bridgepro01.bridge.common.upload;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    public FileDTO storeFile(MultipartFile file) throws IOException;

    public FileDTO getFile(Long fileId);




}
