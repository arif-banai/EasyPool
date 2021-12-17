package me.arifbanai.easypool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.arifbanai.easypool.enums.DataSourceType;

public class MariaDB extends DataSourceManager{


    /**
     * <p>Uses {@link DataSourceType} to get MariaDB drivers and connection creds, and creates a HikariDataSource</p>
     *
     * @param host The IP or domain of the host server
     * @param port The port the mysql service is listening on
     * @param schema The schema to use
     * @param user Login credential
     * @param password Login credential
     */
    public MariaDB(String host, String port, String schema, String user, String password) {
        dsType = DataSourceType.MARIADB;

        HikariConfig config = new HikariConfig();

        config.setDriverClassName(dsType.getDriverClassName());
        config.setUsername(user);
        config.setPassword(password);

        String url = dsType.getUrlPrefix() + host + ':' + port + '/' + schema;
        config.setJdbcUrl(url);

        ds = new HikariDataSource(config);
    }
}
