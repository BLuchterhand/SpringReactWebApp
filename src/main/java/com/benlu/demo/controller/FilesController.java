package com.benlu.demo.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import com.benlu.demo.repository.UserRepository;
import com.benlu.demo.tools.TsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.benlu.demo.model.FileInfo;
import com.benlu.demo.message.ResponseMessage;
import com.benlu.demo.service.FilesStorageService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/")
public class FilesController {

    @Autowired
    FilesStorageService storageService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) throws IOException, URISyntaxException {
        System.out.println("Attempting to receive file from front-end...");
        String message = "";

        try {
            storageService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();

            TsvReader tsv_reader = new TsvReader(userRepository);
            tsv_reader.initDB(System.getProperty("user.dir") + "\\uploads\\" + file.getOriginalFilename());

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        System.out.println("Files read");
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}