package learn_spring_boot.demo.repo;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/4/27 15:24
 **/

import learn_spring_boot.demo.entity.DataActualEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface DataActualRepo extends JpaRepository<DataActualEntity, Long> {
    @Query(value = "select * from atpdb.data_actual where metric=?1 and ts=?2 order by ts", nativeQuery = true)
    DataActualEntity findByMetricAndTs(String metric, Timestamp time);

    @Query(value = "select * from atpdb.data_actual where metric=?1 and ts>=?2 and ts<?3 order by ts", nativeQuery = true)
    List<DataActualEntity> findByMetricAndTsRange(String metric, Timestamp begin, Timestamp end);

}
