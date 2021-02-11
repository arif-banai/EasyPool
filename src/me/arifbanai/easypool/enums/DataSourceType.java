package me.arifbanai.easypool.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Enumerates all the supported data sources that can be used.
 *
 * @since 4/26/2020 4:17AM, EST
 * @author Arif Banai
 */

public enum DataSourceType {
    MYSQL("mysql", "jdbc:mysql://",
            "com.mysql.cj.jdbc.Driver"),

    SQLITE("sqlite", "jdbc:sqlite:", "org.sqlite.JDBC");

    private static final Map<String, DataSourceType> BY_DIALECT = new HashMap<>();
    private final String dialectName;
    private final String urlPrefix;
    private final String driverClassName;

    static {
        for (DataSourceType dataSourceType : values()) {
            BY_DIALECT.put(dataSourceType.dialectName, dataSourceType);
        }
    }

    /**
     * A data source that is supported by this library. Updated as new sources are supported.
     * @param dialectName String representation of this source
     * @param urlPrefix Prefix for the JDBC URL
     * @param driverClassName The class that implements {@link java.sql.Driver} for some data source
     */
    DataSourceType(String dialectName, String urlPrefix, String driverClassName) {
        this.dialectName = dialectName;
        this.urlPrefix = urlPrefix;
        this.driverClassName = driverClassName;
    }

    /**
     * The dialect string is expected to be an all lowercase version of the enum name
     * @param dialect the common 'config readable' form of the DataSourceType
     * @return the DataSourceType referenced by the dialect string
     */
    public static DataSourceType matchDialect(String dialect) {
        return BY_DIALECT.get(dialect.toUpperCase());
    }

    /**
     * @return The config-friendly String of some particular SQL-based database
     */
    public String getDialectName() {
        return dialectName;
    }

    /**
     * @return The prefix used for the JDBC URL
     * @see com.zaxxer.hikari.HikariConfig#setJdbcUrl(String)
     */
    public String getUrlPrefix() {
        return urlPrefix;
    }

    /**
     * @return The fully qualified class name of the class that implements {@link java.sql.Driver}
     */
    public String getDriverClassName() {
        return driverClassName;
    }

}
