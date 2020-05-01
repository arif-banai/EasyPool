# EasyPool
The goal of this API is to make it easy to create a DataSource that utilizes a connection pool in order to
improve performance among DB related operations. 

I had initially used the [c3p0](https://github.com/swaldman/c3p0) as the Connection Pooling lib powering my applications, but soon
discovered [HikariCP](https://github.com/brettwooldridge/HikariCP). The choice was clear. It didn't take much to change
libraries, which is why I renamed this lib from the imaginative "c3p0-presets" to EasyPool. 

A lot of my projects often tend to interact with a data source, such as a database. I created this lib
to make it simpler to create such a datasource, as I found myself duplicate code in my projects.

The supported data sources are enumerated in [DataSourceType](../src/me/arifbanai/easypool/enums/DataSourceType.java), 
which stores implementation specific data required for using a specific DataSource.

I plan on adding support for the supported DataSources (postgres, h2, ...) and to add support for caching.
I also plan on giving this README some more love later to make this even more dead simple. 

## Quick Start
Check out [IDLogger](https://github.com/arif-banai/IDLogger) to see an example of how to use this API.
I will update this later to be more helpful.

## Maven
Add this to your maven dependencies once installed 
```xml
<dependency>
    <groupId>me.arifbanai</groupId>
    <artifactId>easypool</artifactId>
    <version>1.0</version>
</dependency>
```