package me.arifbanai.easypool;

import com.zaxxer.hikari.HikariDataSource;
import me.arifbanai.easypool.enums.DataSourceType;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * <p>Manages access to a {@link HikariDataSource} reference.</p>
 * <p>Provides a reference to the {@link DataSourceType} of the current data source.</p>
 *
 * @since 4/26/2020 4:05AM, EST
 * @see HikariDataSource
 * @see DataSourceType
 * @author Arif Banai
 */
public abstract class DataSourceManager {

    protected HikariDataSource ds;
    protected DataSourceType dsType;


    /**
     * <p>Gets a connection from the {@link HikariDataSource}.</p>
     *
     * @return {@link Connection}
     * @throws SQLException if a database access error occurs
     * @see HikariDataSource#getConnection()
     */
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * @return The type of the DataSource that is currently configured.
     * @see DataSourceType
     */
    public DataSourceType getDataSourceType() {
        return dsType;
    }

    /**
     * <p>Closes the {@link HikariDataSource}</p>
     * @see HikariDataSource#close()
     */
    public void close() {
        ds.close();
    }
}
