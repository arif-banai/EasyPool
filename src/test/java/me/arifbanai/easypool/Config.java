package me.arifbanai.easypool;

/**
 * It is very important that the fields and getters/setters are named a specific way
 *
 * <br>
 *
 * The variable names must be EXACTLY EQUAL to their YAML counterpart
 *
 * <br><br>
 *
 *
 * All the getters and setters must follow the following pattern:
 *
 * <br>
 *
 * Getters: getUsing....()
 * <br> The method name must use camelCase
 *
 * <br>
 * Setters: setUsing...()
 * <br>
 * <br>
 *
 * If these rules aren't followed precisely you will trigger {@link org.yaml.snakeyaml.error.YAMLException}
 */
public class Config {

    public boolean usingSqlite;
    public ConnectionDetails connectionDetails;

    public boolean getUsingSqlite() {
        return usingSqlite;
    }

    public void setUsingSqlite(boolean usingSqlite) {
        this.usingSqlite = usingSqlite;
    }

    public ConnectionDetails getConnectionDetails() {
        return connectionDetails;
    }

    public void setConnectionDetails(ConnectionDetails connectionDetails) {
        this.connectionDetails = connectionDetails;
    }
}
