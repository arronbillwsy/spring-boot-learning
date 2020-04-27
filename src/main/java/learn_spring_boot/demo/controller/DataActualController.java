package learn_spring_boot.demo.controller;

import learn_spring_boot.demo.entity.DataActualEntity;
import learn_spring_boot.demo.response.ResponseEntity;
import learn_spring_boot.demo.service.DataActualService;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
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
@RequestMapping("/api/actual")
public class DataActualController {

    private final Logger logger = LoggerFactory.getLogger(DataActualController.class);

    @Autowired
    private DataActualService dataActualService;

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAll(){
        List<DataActualEntity> dataActualEntities = dataActualService.findAll();
        return new ResponseEntity(dataActualEntities);
    }

    @RequestMapping(value = "/get/range", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getByMetricAndTs(@RequestParam String metric, String begin, String end){
        Timestamp beginDate = Timestamp.valueOf(begin);
        Timestamp endDate = Timestamp.valueOf(end);
        List<DataActualEntity> dataActualEntities = dataActualService.findByMetricAndTsRange(metric, beginDate, endDate);
        return new ResponseEntity(dataActualEntities);
    }

}
