package learn_spring_boot.demo.service;

import learn_spring_boot.demo.entity.DataActualEntity;

import java.sql.Timestamp;
import java.util.List;

public interface DataActualService {
    List<DataActualEntity> findAll();

    DataActualEntity save(DataActualEntity dataActualEntity);

    DataActualEntity findByMetricAndTs(String metric, Timestamp time);

    List<DataActualEntity> findByMetricAndTsRange(String metric, Timestamp begin, Timestamp end);

}
