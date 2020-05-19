package learn_spring_boot.demo.datasource;

public class DatasourceConfigContextHolder {
    private static final ThreadLocal<Long> DATASOURCE_HOLDER = ThreadLocal.withInitial(() -> DatasourceHolder.DEFAULT_ID);

    public static void setDefaultDatasource() {
        DATASOURCE_HOLDER.remove();
        setCurrentDatasourceConfig(DatasourceHolder.DEFAULT_ID);
    }

    /**
     * 获取当前数据源配置id
     *
     * @return 数据源配置id
     */
    public static Long getCurrentDatasourceConfig() {
        return DATASOURCE_HOLDER.get();
    }

    /**
     * 设置当前数据源配置id
     *
     * @param id 数据源配置id
     */
    public static void setCurrentDatasourceConfig(Long id) {
        DATASOURCE_HOLDER.set(id);
    }

}
