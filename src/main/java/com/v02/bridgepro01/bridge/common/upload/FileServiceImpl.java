package com.v02.bridgepro01.bridge.common.upload;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{

    private final FileRepository fileRepository;

    @Override
    public FileDTO storeFile(MultipartFile file) throws IOException {
        FileDTO fileDTO = new FileDTO();
        fileDTO.setFileName(file.getOriginalFilename());
        fileDTO.setFileType(file.getContentType());
        fileDTO.setData(file.getBytes());

        fileRepository.insertFile(fileDTO);

        return fileDTO;
    }

    @Override
    public FileDTO getFile(Long fileId) {
        return fileRepository.getFile(fileId);
    }
}
