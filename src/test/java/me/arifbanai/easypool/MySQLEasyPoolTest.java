package me.arifbanai.easypool;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MySQLEasyPoolTest extends EasyPool {

    /**
     * Pay attention not to leave credentials in here or in config.yml when committing
     * <br>
     * Could potentially make use of {@link System#getProperty(String)}
     */
    @Test
    @EnabledIf("configEnabled")
    @DisplayName("Successfully connect to a MySQL DB defined in config.yml")
    public void testCreateMySQLDataSource() {
        Yaml yaml = new Yaml(new Constructor(Config.class));

        InputStream is = this.getClass().getClassLoader()
                        .getResourceAsStream("config.yml");


        Config config = yaml.load(is);

        MySQL mysql = new MySQL(config.getHost(),
                config.getPort(), config.getSchema(),
                config.getUsername(), config.getPassword());

        assertTrue(mysql.ds.isRunning());
        mysql.close();
    }

    /**
     * @return if the config is prepped for testing a MySQL connection
     */
    boolean configEnabled() {
        Yaml yaml = new Yaml(new Constructor(Config.class));

        InputStream is = this.getClass().getClassLoader()
                .getResourceAsStream("config.yml");

        Config config = yaml.load(is);
        return config.getDialect().equals("mysql");
    }

}