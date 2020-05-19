package learn_spring_boot.demo.datasource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;

import java.time.LocalDateTime;

public class DatasourceManager {
    // default release time
    private static final Long DEFAULT_RELEASE = 10L;

    @Getter
    private HikariDataSource dataSource;

    private LocalDateTime lastUseTime;

    public DatasourceManager(HikariDataSource dataSource) {
        this.dataSource = dataSource;
        this.lastUseTime = LocalDateTime.now();
    }

    public boolean isExpired() {
        if (LocalDateTime.now().isBefore(this.lastUseTime.plusMinutes(DEFAULT_RELEASE))) {
            return false;
        }
        this.dataSource.close();
        return true;
    }

    public void refreshTime() {
        this.lastUseTime = LocalDateTime.now();
    }
}
