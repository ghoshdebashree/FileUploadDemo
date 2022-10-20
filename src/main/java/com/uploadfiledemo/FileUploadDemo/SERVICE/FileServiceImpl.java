package com.uploadfiledemo.FileUploadDemo.SERVICE;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService{
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        //FIND OUT FILE NAME
        String name = file.getOriginalFilename();

        //FULL PATH
        String filePath = path + File.separator+name;

        //CREATE FOLDER IF NOT CREATED
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        //FILE COPY
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return name;
    }
}
