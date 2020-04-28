package learn_spring_boot.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/4/22 14:14
 **/

@Component
public class Scheduler {

    private Logger logger = Logger.getLogger(Scheduler.class.getName());


    @Scheduled(cron = "0 0 5 * * ?")
    public void trainToday() {
        logger.info("Training Today Task");
    }

    @Scheduled(cron = "0 0 17 * * ?")
    public void trainTomorrow() {
        logger.info("Training Tomorrow Task");
    }
}
