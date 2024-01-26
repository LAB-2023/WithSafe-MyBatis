package com.withsafe.global.interceptor;

import com.withsafe.global.BaseTimeDomain;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Statement;

@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class MyBatisInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object parameter = invocation.getArgs()[1];
        MappedStatement ms = (MappedStatement) invocation.getArgs()[0];

        if (parameter instanceof BaseTimeDomain) {
            BaseTimeDomain domain = (BaseTimeDomain) parameter;
            String sqlCommandType = ms.getSqlCommandType().name().toLowerCase();
            if (sqlCommandType.equals("insert")) {
                domain.preInsert();
                domain.preUpdate();
            } else if (sqlCommandType.equals("update")) {
                domain.preUpdate();
            }
        }

        return invocation.proceed();
    }
}
