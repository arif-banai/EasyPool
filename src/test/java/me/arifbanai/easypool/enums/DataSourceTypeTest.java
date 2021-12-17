package me.arifbanai.easypool.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataSourceTypeTest {

    @Test
    @DisplayName("DataSourceType.matchDialect(..) should work as intended (take input string, produce matching DataSourceType)")
    void matchDialectWorksAsIntended() {

        // List of all supported dialects, for now ???? 0.0
        String sqlite = "sqlite";
        String mysql = "mysql";
        String mariadb = "mariadb";

        assertEquals(DataSourceType.SQLITE, DataSourceType.matchDialect(sqlite));
        assertEquals(DataSourceType.MYSQL, DataSourceType.matchDialect(mysql));
        assertEquals(DataSourceType.MARIADB, DataSourceType.matchDialect(mariadb));
    }


}