package com.withsafe.global.config;

import com.withsafe.global.PointTypeHandler;
import com.withsafe.global.interceptor.MyBatisInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    @Bean
    public Interceptor myBatisInterceptor() {
        return new MyBatisInterceptor();
    }

    @Bean
    public PointTypeHandler pointTypeHandler() {
        return new PointTypeHandler();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPlugins(new Interceptor[]{myBatisInterceptor()});
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        // 타입 핸들러 설정
        sessionFactory.setTypeHandlers(new TypeHandler[]{pointTypeHandler()});

        return sessionFactory.getObject();
    }
}
