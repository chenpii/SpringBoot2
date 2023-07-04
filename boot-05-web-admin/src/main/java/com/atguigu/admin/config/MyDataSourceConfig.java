package com.atguigu.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Configuration
public class MyDataSourceConfig {

    // 默认的自动配置是Hikari，判断容器中没有DataSource才会配  @ConditionalOnMissingBean(DataSource.class)

    /**
     * 注入druid数据源
     *
     * @return
     * @throws SQLException
     */
    @Bean
    @ConfigurationProperties("spring.datasource") //跟配置文件绑定
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setFilters("wall,stat");//开启防火墙、监控功能
        return druidDataSource;
    }

    /**
     * 配置druid的监控页
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        return statViewServletServletRegistrationBean;
    }


    /**
     * WebStatFilter用于采集web-jdbc关联监控的数据
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
