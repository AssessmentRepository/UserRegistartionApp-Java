package com.userregistration.utiltestclass;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.userregistration.model.User;

public class MasterData {
	public static User getDetails() {
		User user = new User();
		user.setUserId(1);
		user.setUserFirstName("Besta");
		user.setUserLastName("Shashidhar");
		user.setUserName("B Shashidhar");
		user.setUserEmail("shashi.2346@gmail.com");
		user.setUserPassword("1234567890");
		user.setProfilePicture("www.google.com");
		user.setActive(true);
		return user;
	}
	public static Properties getProperties() throws IOException {
		FileReader reader = new FileReader("src\\main\\resources\\db.properties");
		Properties properties = new Properties();
		properties.load(reader);
		return properties;
	}
	
	public static LocalSessionFactoryBean getSession() throws IOException {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		Properties properties = getProperties();
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(properties.getProperty("database.driver"));
		dataSource.setUrl(properties.getProperty("database.url"));
		dataSource.setUsername(properties.getProperty("database.root"));
		dataSource.setPassword(properties.getProperty("database.password"));
		lsfb.setDataSource(dataSource);
		lsfb.setPackagesToScan("com.giftCard.entity");
		properties.put("hibernate.dialect", properties.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", properties.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", properties.getProperty("hibernate.show_sql"));
		lsfb.setHibernateProperties(properties);
		try {
			lsfb.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lsfb;
	}
}