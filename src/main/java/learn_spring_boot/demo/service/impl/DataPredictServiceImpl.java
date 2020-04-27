package learn_spring_boot.demo.service.impl;

import learn_spring_boot.demo.entity.DataPredictEntity;
import learn_spring_boot.demo.repo.DataPredictRepo;
import learn_spring_boot.demo.service.DataPredictService;
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
public class DataPredictServiceImpl implements DataPredictService {

    @Autowired
    private DataPredictRepo dataPredictRepo;

    @Override
    public List<DataPredictEntity> findAll() {
        return dataPredictRepo.findAll();
    }

    @Override
    public void saveAll(List<DataPredictEntity> list) {
        dataPredictRepo.saveAll(list);
    }

    @Override
    public DataPredictEntity save(DataPredictEntity dataPredictEntity) {
        return dataPredictRepo.save(dataPredictEntity);
    }

    @Override
    public DataPredictEntity findByMetricAndTs(String metric, Timestamp time) {
        return dataPredictRepo.findByMetricAndTs(metric, time);
    }

    @Override
    public List<DataPredictEntity> findByMetricAndTsRange(String metric, Timestamp begin, Timestamp end) {
        return dataPredictRepo.findByMetricAndTsRange(metric, begin, end);
    }
}
