package com.bank.model.service;

import java.time.LocalDateTime;

public class LogService {
    
    private static LogService logService;

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
        System.out.println(LocalDateTime.now() + " " + modePrefix + " " + message);
    }
}
