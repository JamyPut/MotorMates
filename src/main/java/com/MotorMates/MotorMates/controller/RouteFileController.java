package com.MotorMates.MotorMates.controller;

import com.MotorMates.MotorMates.entity.RouteFile;
import com.MotorMates.MotorMates.message.ResponseRouteFile;
import com.MotorMates.MotorMates.message.ResponseRouteMessage;
import com.MotorMates.MotorMates.service.RouteFileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController("/forum")
@CrossOrigin("http://localhost:8080")
public class RouteFileController {

    @Autowired
    private RouteFileStorageService storageService;

    @PostMapping("/routes/upload")
    public ResponseEntity<ResponseRouteMessage> uploadFile(@RequestParam("file")MultipartFile file) {
        String message = "";
        try {
            storageService.storeRouteFile(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseRouteMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseRouteMessage(message));
        }
    }

    @GetMapping("/routes")
    public ResponseEntity<List<ResponseRouteFile>> getListFiles(){
        List<ResponseRouteFile> files = storageService.getAllRouteFiles().map(routeFile -> {
            String routeFileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/routes")
                    .path(String.valueOf(routeFile.getId()))
                    .toUriString();

            return new ResponseRouteFile(
                    routeFile.getRouteFileName(),
                    routeFileDownloadUri,
                    routeFile.getType(),
                    routeFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/routes/{id}")
    public ResponseEntity<byte[]> getRouteFile(@PathVariable String id) {
        RouteFile routeFile = storageService.getRouteFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + routeFile.getRouteFileName() + "\"")
                .body(routeFile.getData());
    }

}
