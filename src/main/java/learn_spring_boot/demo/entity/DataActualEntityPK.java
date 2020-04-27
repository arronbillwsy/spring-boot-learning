package learn_spring_boot.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/4/27 15:23
 **/
public class DataActualEntityPK implements Serializable {
    private long id;
    private Timestamp ts;

    @Column(name = "id")
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "ts")
    @Id
    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataActualEntityPK that = (DataActualEntityPK) o;
        return id == that.id &&
                Objects.equals(ts, that.ts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ts);
    }
}
