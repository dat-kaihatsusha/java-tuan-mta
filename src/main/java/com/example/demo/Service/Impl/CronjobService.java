package com.example.demo.Service.Impl;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.UUID;
import java.util.logging.Logger;

public class CronjobService {
    Logger logger = (Logger) LoggerFactory.getLogger(CronjobService.class);

    @Scheduled(fixedDelay = 1000)
    public void demoCronjob() {
        String id = UUID.randomUUID().toString();
        System.out.println("run into cronjob");
        logger.info("nguyen tien dat" + id);
    }
}
