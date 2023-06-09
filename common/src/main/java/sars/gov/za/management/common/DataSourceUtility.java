/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.common;

import com.zaxxer.hikari.HikariDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author S2028873
 */
public class DataSourceUtility {

    public static DataSource getDatasource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(5);

        dataSource.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
        dataSource.addDataSourceProperty("url", "jdbc:sqlserver://EDZANI_LAPTOP;databaseName=schoolManagementSystemDB");
        dataSource.addDataSourceProperty("user", "root");
        dataSource.addDataSourceProperty("password", "1658");
       

        return dataSource;
    }

    public static DataSource getDatasourceLookup() {
        try {
            InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:/schoolDS");
            return dataSource;
        } catch (NamingException ex) {
            Logger.getLogger(DataSourceUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
//dataSource.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
//        dataSource.addDataSourceProperty("url", "jbdc:sqlserver://LPTAYA61:1433;databaseName=schoolSystemDB");
//        dataSource.addDataSourceProperty("user", "amogelang");
//        dataSource.addDataSourceProperty("password", "amogelang");
   