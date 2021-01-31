package seapps.abstraction.core.config;

import org.apache.ibatis.session.SqlSessionFactory;

public interface SessionFactoryBuilder {
    SqlSessionFactory getSqlSessionFactory();
}