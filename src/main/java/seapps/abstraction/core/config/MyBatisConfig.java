package seapps.abstraction.core.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.sql.DataSource;

public class MyBatisConfig implements SessionFactoryBuilder{

    @ConfigProperty(name = "postgres.driver")
    private String driver;

    @ConfigProperty(name = "postgres.url")
    private String url;

    @ConfigProperty(name = "postgres.username")
    private String username;

    @ConfigProperty(name = "postgres.password")
    private String password;

    private SqlSessionFactory sessionFactory = null;

    public void buildSessionFactory(){
        DataSource dataSource = new PooledDataSource(driver, url, username, password);
        Environment environment = new Environment("Develop", new JdbcTransactionFactory(), dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMappers("seapps.abstraction.core.mapper");
        sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    public SqlSessionFactory getSqlSessionFactory(){
        if (sessionFactory == null)
            buildSessionFactory();
        return sessionFactory;
    }
}