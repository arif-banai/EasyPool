package me.arifbanai.easypool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.arifbanai.easypool.enums.DataSourceType;

import java.io.File;
import java.io.IOException;

/**
 * <p>Configures {@link DataSourceManager} to use a SQLite instance.</p>
 *
 * @since 4/26/2020 2:12PM, EST
 * @see DataSourceManager
 * @see DataSourceType
 * @author Arif Banai
 */
public class SQLiteDataSourceManager extends DataSourceManager {

    /**
     * <p>Configures the {@link DataSourceManager} for use with {@link org.sqlite.JDBC}.</p>
     *    <p>Utilizes {@link DataSourceType} to get SQLite driver class paths and construct the url.</p>
     *
     * @param hostPath The path of the parent directory (parent file)
     * @param schemaFileName The name of the .db file that SQLite will use for storage
     */
    public SQLiteDataSourceManager(String hostPath, String schemaFileName) throws IOException {
        File file = new File(hostPath, schemaFileName + ".db");

        if (!(file.exists())) {
            file.createNewFile();
        }

        HikariConfig config = new HikariConfig();
        dsType = DataSourceType.SQLITE;

        config.setDriverClassName(dsType.getDriverClassName());

        String url = dsType.getUrlPrefix() + hostPath + "/" + schemaFileName + ".db";
        config.setJdbcUrl(url);

        ds = new HikariDataSource(config);
    }
}
