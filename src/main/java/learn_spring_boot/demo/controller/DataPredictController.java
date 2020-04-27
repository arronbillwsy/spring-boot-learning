package learn_spring_boot.demo.controller;

import learn_spring_boot.demo.entity.DataPredictEntity;
import learn_spring_boot.demo.response.ResponseEntity;
import learn_spring_boot.demo.service.DataPredictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/4/27 15:32
 **/
@RestController
@RequestMapping("/api/predict")
public class DataPredictController {

    private final Logger logger = LoggerFactory.getLogger(DataPredictController.class);

    @Autowired
    private DataPredictService dataPredictService;

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAll(){
        List<DataPredictEntity> dataPredictEntities = dataPredictService.findAll();
        return new ResponseEntity(dataPredictEntities);
    }

    @RequestMapping(value = "/get/range", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getByMetricAndTs(@RequestParam String metric, String begin, String end) {
        Timestamp beginDate = Timestamp.valueOf(begin);
        Timestamp endDate = Timestamp.valueOf(end);
        List<DataPredictEntity> dataPredictEntities = dataPredictService.findByMetricAndTsRange(metric, beginDate, endDate);
        return new ResponseEntity(dataPredictEntities);
    }

    @RequestMapping(value = "saveAll", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity saveAll(List<DataPredictEntity> dataPredictEntities) {
        dataPredictService.saveAll(dataPredictEntities);
        return new ResponseEntity();
    }


}
