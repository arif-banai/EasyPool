# EasyPool
This library makes it easy to use [HikariCP](https://github.com/brettwooldridge/HikariCP) with different data sources (SQLite, MySQL, postgreSQL, etc.)

All the drivers necessary for HikariCP to establish connections to a given data source are included as dependencies. 

The supported data sources are enumerated in [DataSourceType](../src/me/arifbanai/easypool/enums/DataSourceType.java), 
which stores implementation specific data required for using a specific DataSource.

## Quick Start

A hikari.properties file can be passed to the HikariDataSource created by setting the Java System Property "hikari.configurationFile" to the path of the properties file. This must be done _**before**_ initializing a [DataSourceManager](../src/me/arifbanai/easypool/DataSourceManager.java)

```java
/*
 Set location of hikari properties file to System property
 When HikariConfig default constructor is called, the properties file is loaded
 see https://github.com/brettwooldridge/HikariCP (ctrl+F system property)
*/
String path = "path/to/resource";
System.setProperty("hikaricp.configurationFile", path + "/hikari.properties");
```

Simply instantiate a DataSourceManager with some implementing class
```java
DataSourceManager dsm = new MySQLDataSourceManager(host, port, schema, user, password);
// or
DataSourceManager dsm = new SQLiteDataSourceManager(path, this.getName());
```

## Maven
Build and install to your local repo, then add the dependency
```xml
<dependency>
    <groupId>me.arifbanai</groupId>
    <artifactId>easypool</artifactId>
    <version>1.2</version>
</dependency>
```

**Changelog**
- **2/9/2021**
  - Updated dependencies and plugins to the latest versions
  
- **2/11/2021**
  - Updated .gitignore and removed ignored files
  - Removed duplicate .idea/.gitignore file
  - Updated readme entry about using "hikari.configurationFile" system property
  - Added dialect-based retrieval method for DataSourceType enum

- **2/13/2021**
  - Updated README.md