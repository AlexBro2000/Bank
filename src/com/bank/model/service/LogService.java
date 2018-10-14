package com.bank.model.service;

import com.bank.model.service.validator.FileService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogService {

    private static LogService logService;
    private FileService fileService = FileService.getInstance();

    private LogService() {
    }

    public static LogService getInstance(){
        if(logService == null){
            logService = new LogService();
        }
        return logService;
    }

    public void info(String message){
        log("[INFO]", message);
    }

    public void error(String message, Exception e){
        log("[ERROR]", message + "| Exception: " + e.getClass().getSimpleName());
    }

    private void log(String modePrefix, String message){
        String fullMessage = LocalDateTime.now().format(DateTimeFormatter.
                ofPattern("yyyy-MM-dd HH:mm:ss")) + " " +
                modePrefix + " " + message;
        System.out.println(fullMessage);

        try {
            fileService.write(fullMessage, "/log.txt");
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }
}
