package com.cj.tools.mybatisplus.dynamic;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcSessionFactory {

    private static JdbcSessionFactory instance = null;

    private SqlSessionFactory sqlSessionFactory;

    private DataSourceConfig dataSourceConfig;

    private JdbcSessionFactory() {
    }

    /**
     * 尝试获取实例
     * @return
     */
    public static JdbcSessionFactory tryGetInstance() {
        if (instance == null) {
            throw new RuntimeException();
        }
        return instance;
    }

    /**
     * 获取连接实例
     * @param jdbcUrl
     * @param name
     * @param password
     * @return
     */
    public static JdbcSessionFactory getInstance(String jdbcUrl, String name, String password) {
        if (instance == null) {
            instance = new JdbcSessionFactory();
            instance.createJdbcSessionFactory(jdbcUrl, "com.mysql.jdbc.Driver", name, password);
        }
        return instance;
    }

    /**
     * 测试数据库连接
     * @param jdbcUrl
     * @param name
     * @param password
     * @return
     */
    public static Boolean sqlTest(String jdbcUrl, String name, String password) {
        return sqlTest(jdbcUrl, "com.mysql.jdbc.Driver", name, password);
    }

    /**
     * 获取一个SqlSession会话
     * @return
     */
    public SqlSession getSqlSession() {
        return this.sqlSessionFactory.openSession();
    }

    public DataSourceConfig getDataSourceConfig() {
        return this.dataSourceConfig;
    }

    /**
     * 创建jdbcSession工厂
     * @param jdbcUrl
     * @param driver
     * @param name
     * @param password
     * @return
     */
    private Boolean createJdbcSessionFactory(String jdbcUrl, String driver, String name, String password) {
        if (!sqlTest(jdbcUrl, "com.mysql.jdbc.Driver", name, password)) {
            throw new RuntimeException("db connect time out");
        }
        // 保存数据库配置
        dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName(driver);
        dataSourceConfig.setUrl(jdbcUrl);
        dataSourceConfig.setUsername(name);
        dataSourceConfig.setPassword(password);

        DataSource dataSource =new PooledDataSource(driver,jdbcUrl,name,password);
        TransactionFactory transactionFactory =  new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.setDefaultStatementTimeout(8);

        // 分页
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.plugin(getPageHelper());
        configuration.addInterceptor(pageInterceptor);

        configuration.addMappers("com.cj.tools.mybatisplus.mapper");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        this.sqlSessionFactory = sqlSessionFactory;
        return true;
    }

    /**
     * 分页插件
     * @return
     */
    private PageHelper getPageHelper(){
        PageHelper pageHelper=new PageHelper();
        Properties properties=new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    /**
     * 测试数据库连接
     * @param jdbcUrl
     * @param driver
     * @param name
     * @param password
     * @return
     */
    private static Boolean sqlTest(String jdbcUrl, String driver, String name, String password) {
        DataSource dataSource =new PooledDataSource(driver,jdbcUrl,name,password);
        try {
            dataSource.setLoginTimeout(5);
            dataSource.getConnection().getClientInfo();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
