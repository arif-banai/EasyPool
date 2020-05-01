package me.arifbanai.easypool.enums;

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

    private String dialectName;
    private String urlPrefix;
    private String driverClassName;

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
