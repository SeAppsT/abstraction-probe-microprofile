package seapps.abstraction.core.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;
import seapps.abstraction.core.config.MyBatisConfig;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@Singleton
public class DAO<T, M> {

    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    private Class<M> mapperName;
    protected List<Consumer<M>> actions = new ArrayList<>();

    public DAO(){
        sessionFactory = new MyBatisConfig().getSqlSessionFactory();
    }

    public Optional<T> execute(Function<M, T> function){
        SqlSession session = sessionFactory.openSession();
        Optional<T> result = Optional.of(function.apply(session.getMapper(mapperName)));
        session.commit();
        session.close();
        return result;
    }

    public void complete(TransactionIsolationLevel isolationLevel){
        SqlSession session = sessionFactory.openSession(isolationLevel);
        actions.forEach(action -> {
            action.accept(session.getMapper(mapperName));
        });
        session.commit();
        session.close();
        this.actions = new ArrayList<>();
    }
}