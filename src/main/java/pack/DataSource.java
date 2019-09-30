package pack;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSource extends DriverManagerDataSource {
	public DataSource() {
		this.setDriverClassName("org.mariadb.jdbc.Driver");
		this.setUrl("jdbc:mysql://localhost:3306/test");
		this.setUsername("root");
		this.setPassword("kic1234");
	}
}