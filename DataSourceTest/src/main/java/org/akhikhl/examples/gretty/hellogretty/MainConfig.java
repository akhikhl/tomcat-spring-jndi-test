/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.akhikhl.examples.gretty.hellogretty;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

/**
 *
 * @author ahi
 */
@Configuration
public class MainConfig {

  private static final Logger logger = LoggerFactory.getLogger(MainConfig.class);

  @Bean
  public DataSource dataSource() {
    /* final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
    dsLookup.setResourceRef(true);
    return dsLookup.getDataSource("jdbc/devcore"); */

    DataSource dataSource = null;
    try {
      InitialContext init = new InitialContext();
	    Context env = (Context) init.lookup("java:comp/env");
      dataSource = (DataSource) env.lookup("jdbc/devcore");
      Connection con = dataSource.getConnection();
    } catch (Exception e) {
      logger.error("Exception in dataSource", e);
      throw new RuntimeException(e);
    }
    return dataSource;
  }
}
