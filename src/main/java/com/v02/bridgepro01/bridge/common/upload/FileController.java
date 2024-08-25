package com.v02.bridgepro01.bridge.common.upload;


import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/files")
    public ResponseEntity<FileDTO> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            FileDTO fileDTO = fileService.storeFile(file);
            return ResponseEntity.ok(fileDTO);
        } catch (IOException e) {
            // IOException 발생 시 에러 응답을 반환할 수 있습니다.
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        FileDTO fileDTO = fileService.getFile(id);

        System.out.println(fileDTO.getFileName());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileDTO.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDTO.getFileName() + "\"")
                .body(fileDTO.getData());
    }



    }
