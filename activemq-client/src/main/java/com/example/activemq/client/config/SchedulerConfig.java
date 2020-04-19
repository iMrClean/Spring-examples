package com.example.activemq.client.config;

import com.example.activemq.client.service.ClientService;
import com.example.activemq.client.service.ClientServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Log4j2
@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static final int POOL_SIZE = 10;

    private final ClientService clientService;

    @Autowired
    public SchedulerConfig(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }


    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

        threadPoolTaskScheduler.setPoolSize(POOL_SIZE);
        threadPoolTaskScheduler.setThreadNamePrefix("my-scheduled-task-pool-");
        threadPoolTaskScheduler.initialize();

        scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
    }

    @Scheduled(cron = "${my.cron}")
    public void scheduleTaskWithCronExpression() {
        log.info("Начало scheduleTaskWithCronExpression");
        clientService.sendMessage("Hello simple active-mq sender " + dateTimeFormatter.format(LocalDateTime.now()));
        log.info("Конец scheduleTaskWithCronExpression");
    }

}
