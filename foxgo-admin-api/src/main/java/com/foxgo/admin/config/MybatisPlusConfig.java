package com.foxgo.admin.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@MapperScan(basePackages = {"com.foxgo.admin.mapper*"})
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }


    /**
     * 相当于顶部的：
     * {@code @MapperScan("com.foxgo.admin.*.mapper*")}
     * 这里可以扩展，比如使用配置文件来配置扫描Mapper的路径
     */
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
//        scannerConfigurer.setBasePackage("com.foxgo.admin.mapper*");
//        return scannerConfigurer;
//    }

    /**
     * 性能分析拦截器，不建议生产使用
     */
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }

    /**
     * sql注入器  逻辑删除插件
     * @return
     */
//    @Bean
//    public ISqlInjector iSqlInjector(){
//        return new LogicSqlInjector();
//    }

    /**
     * 乐观锁插件
     * @return
     */
//    @Bean
//    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
//        return new OptimisticLockerInterceptor();
//    }




}
