package com.MotorMates.MotorMates.service;

import com.MotorMates.MotorMates.entity.RouteFile;
import com.MotorMates.MotorMates.repository.RouteFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class RouteFileStorageService {

    @Autowired
    private RouteFileRepository routeFileRepository;

    public void storeRouteFile(MultipartFile file) throws IOException{
        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        RouteFile routeFile = new RouteFile(filename, file.getContentType(), file.getBytes());
        routeFileRepository.save(routeFile);
    }

    public RouteFile getRouteFile(String id) {
        return routeFileRepository.findById(id).get();
    }

    public Stream<RouteFile> getAllRouteFiles(){
        Spliterator<RouteFile> spliterator = routeFileRepository.findAll().spliterator();
        return StreamSupport.stream(spliterator, false);
    }
}
