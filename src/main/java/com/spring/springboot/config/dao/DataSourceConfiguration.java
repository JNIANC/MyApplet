package com.spring.springboot.config.dao;

import java.beans.PropertyVetoException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.spring.springboot.config.dao")
public class DataSourceConfiguration {
	
	@Value("${jdbc.driver}")
	private String driverClass;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.username}")
	private String jdbcUser;
	@Value("${jdbc.password}")
	private String jdbcPassword;

	@Bean(name="dataSource")
	public ComboPooledDataSource createDateSource() throws PropertyVetoException {
		
		ComboPooledDataSource dataSource= new ComboPooledDataSource();
	
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUser(jdbcUser);
		dataSource.setPassword(jdbcPassword);
		//关闭连接后不自动Commit
		dataSource.setAutoCommitOnClose(false);
		return dataSource;
	}
}
