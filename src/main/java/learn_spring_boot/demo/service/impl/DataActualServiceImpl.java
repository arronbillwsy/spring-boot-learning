package learn_spring_boot.demo.service.impl;

import learn_spring_boot.demo.entity.DataActualEntity;
import learn_spring_boot.demo.repo.DataActualRepo;
import learn_spring_boot.demo.service.DataActualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/4/27 15:27
 **/
@Service
public class DataActualServiceImpl implements DataActualService {

    @Autowired
    private DataActualRepo dataActualRepo;

    @Override
    public List<DataActualEntity> findAll() {
        return dataActualRepo.findAll();
    }

    @Override
    public DataActualEntity save(DataActualEntity dataActualEntity) {
        return dataActualRepo.save(dataActualEntity);
    }

    @Override
    public DataActualEntity findByMetricAndTs(String metric, Timestamp time) {
        return dataActualRepo.findByMetricAndTs(metric, time);
    }

    @Override
    public List<DataActualEntity> findByMetricAndTsRange(String metric, Timestamp begin, Timestamp end) {
        return dataActualRepo.findByMetricAndTsRange(metric, begin, end);
    }
}
