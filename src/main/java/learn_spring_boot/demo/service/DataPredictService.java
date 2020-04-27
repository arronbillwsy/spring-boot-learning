package learn_spring_boot.demo.service;

import learn_spring_boot.demo.entity.DataPredictEntity;

import java.sql.Timestamp;
import java.util.List;

public interface DataPredictService {
    List<DataPredictEntity> findAll();

    void saveAll(List<DataPredictEntity> list);

    DataPredictEntity save(DataPredictEntity dataPredictEntity);

    DataPredictEntity findByMetricAndTs(String metric, Timestamp time);

    List<DataPredictEntity> findByMetricAndTsRange(String metric, Timestamp begin, Timestamp end);
}
