package me.arifbanai.easypool;

import com.mysql.cj.jdbc.Driver;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.arifbanai.easypool.enums.DataSourceType;

/**
 * <p>Configures {@link DataSourceManager} to use a MySQL instance.</p>
 *
 * @since 4/26/2020 2:12PM, EST
 * @see DataSourceManager
 * @see DataSourceType
 * @author Arif Banai
 */
public class MySQLDataSourceManager extends DataSourceManager {

    /**
     * <p>Configures the {@link DataSourceManager} for use with {@link Driver}.</p>
     *    <p>Utilizes {@link DataSourceType} to get MySQL drivers and connection credentials</p>
     *
     * @param host The IP or domain of the host server
     * @param port The port the mysql service is listening on
     * @param schema The schema to use
     * @param user Login credential
     * @param password Login credential
     */
    public MySQLDataSourceManager(String host, String port, String schema, String user, String password) {
        dsType = DataSourceType.MYSQL;

        HikariConfig config = new HikariConfig();

        config.setDriverClassName(dsType.getDriverClassName());
        config.setUsername(user);
        config.setPassword(password);

        String url = dsType.getUrlPrefix() + host + ':' + port + '/' + schema;
        config.setJdbcUrl(url);

        ds = new HikariDataSource(config);
    }
}
