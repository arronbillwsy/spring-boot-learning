package learn_spring_boot.demo.repo;

import learn_spring_boot.demo.entity.DataPredictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface DataPredictRepo extends JpaRepository<DataPredictEntity, Long> {
    @Query(value = "select * from atpdb.data_predict where metric=?1 and ts=?2 order by ts", nativeQuery = true)
    DataPredictEntity findByMetricAndTs(String metric, Timestamp time);

    @Query(value = "select * from atpdb.data_predict where metric=?1 and ts>=?2 and ts<?3 order by ts", nativeQuery = true)
    List<DataPredictEntity> findByMetricAndTsRange(String metric, Timestamp begin, Timestamp end);
}
