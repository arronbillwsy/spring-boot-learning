package learn_spring_boot.demo.datasource;

import com.zaxxer.hikari.HikariDataSource;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum DatasourceHolder {
    INSTANCE;

    // run when start and every 5 min, clean
    DatasourceHolder() {
        DatasourceScheduler.INSTANCE.schedule(this::clearExpiredDatasource, 5 * 60 * 1000);
    }

    // default datasource id
    public static final Long DEFAULT_ID = -1L;


    private static final Map<Long, DatasourceManager> DATASOURCE_CACHE = new ConcurrentHashMap<>();

    // add dynamic datasource
    public synchronized void addDatasource(Long id, HikariDataSource dataSource) {
        DatasourceManager datasourceManager = new DatasourceManager(dataSource);
        DATASOURCE_CACHE.put(id, datasourceManager);
    }

    // query dynamic datasource
    public synchronized HikariDataSource getDatasource(Long id) {
        if (DATASOURCE_CACHE.containsKey(id)) {
            DatasourceManager datasourceManager = DATASOURCE_CACHE.get(id);
            datasourceManager.refreshTime();
            return datasourceManager.getDataSource();
        }
        return null;
    }

    /**
     * 清除超时的数据源
     */
    public synchronized void clearExpiredDatasource() {
        DATASOURCE_CACHE.forEach((k, v) -> {
            // 排除默认数据源
            if (!DEFAULT_ID.equals(k)) {
                if (v.isExpired()) {
                    DATASOURCE_CACHE.remove(k);
                }
            }
        });
    }

    /**
     * 清除动态数据源
     * @param id 数据源id
     */
    public synchronized void removeDatasource(Long id) {
        if (DATASOURCE_CACHE.containsKey(id)) {
            // 关闭数据源
            DATASOURCE_CACHE.get(id).getDataSource().close();
            // 移除缓存
            DATASOURCE_CACHE.remove(id);
        }
    }
}
