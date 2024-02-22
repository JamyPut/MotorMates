package com.MotorMates.MotorMates.service;

import com.MotorMates.MotorMates.entity.RouteFile;
import com.MotorMates.MotorMates.repository.RouteFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class RouteFileStorageService {

    @Autowired
    private RouteFileRepository routeFileRepository;

    public RouteFile storeRouteFile(MultipartFile file) throws IOException{
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        RouteFile routeFile = new RouteFile(filename, file.getContentType(), file.getBytes());

        return routeFileRepository.save(routeFile);
    }

    public RouteFile getRouteFile(String id) {
        return routeFileRepository.findById(id).get();
    }

    public Stream<RouteFile> getAllRoutefiles(){
        return routeFileRepository.findAll().stream();
    }
}
