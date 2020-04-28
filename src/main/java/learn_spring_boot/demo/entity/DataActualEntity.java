package learn_spring_boot.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/4/27 15:23
 **/
@Entity
@Table(name = "data_actual", schema = "atpdb")
@IdClass(DataActualEntityPK.class)
public class DataActualEntity {
    private long id;
    private String dataSource;
    private String uid;
    private String metric;
    private String name;
    private Double value;
    private Timestamp ts;
    private Timestamp insertTime;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "data_source")
    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @Basic
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "metric")
    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "value")
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Id
    @Column(name = "ts")
    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    @Basic
    @Column(name = "insert_time")
    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    public DataActualEntity() {
    }

    public DataActualEntity(long id,
            String dataSource,
            String uid,
            String metric,
            String name,
            Double value,
            Timestamp ts,
            Timestamp insertTime) {
        this.id = id;
        this.dataSource = dataSource;
        this.uid = uid;
        this.metric = metric;
        this.name = name;
        this.value = value;
        this.ts = ts;
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "DataActualEntity{" +
                "id=" + id +
                ", dataSource='" + dataSource + '\'' +
                ", uid='" + uid + '\'' +
                ", metric='" + metric + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", ts=" + ts +
                ", insertTime=" + insertTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataActualEntity that = (DataActualEntity) o;
        return id == that.id &&
                Objects.equals(dataSource, that.dataSource) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(metric, that.metric) &&
                Objects.equals(name, that.name) &&
                Objects.equals(value, that.value) &&
                Objects.equals(ts, that.ts) &&
                Objects.equals(insertTime, that.insertTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataSource, uid, metric, name, value, ts, insertTime);
    }
}
