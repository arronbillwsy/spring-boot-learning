package learn_spring_boot.demo.controller;

import learn_spring_boot.demo.service.DataActualService;
import learn_spring_boot.demo.service.DataPredictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/4/14 10:25
 **/
public class TrainingTask implements Callable {

    private final Logger LOGGER = LoggerFactory.getLogger(TrainingTask.class);

    private DataPredictService dataPredictService;

    private DataActualService dataActualService;

    public DataPredictService getDataPredictService() {
        return dataPredictService;
    }

    public void setDataPredictService(DataPredictService dataPredictService) {
        this.dataPredictService = dataPredictService;
    }

    public DataActualService getDataActualService() {
        return dataActualService;
    }

    public void setDataActualService(DataActualService dataActualService) {
        this.dataActualService = dataActualService;
    }

    public TrainingTask(DataActualService dataActualService, DataPredictService dataPredictService) {
        this.dataActualService = dataActualService;
        this.dataPredictService = dataPredictService;
    }

    public boolean run(){
        System.out.println("1");
        return true;
    }

    @Override
    public Object call() throws Exception {
        return run();
    }
}
