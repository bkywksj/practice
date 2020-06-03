package com.my;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/*
 *代码生成器
 *@author Ye
 *@create 2020/5/24 19:48
 */
public class CodeGenerator {

    public static void main(String[] args) {

        String[] strings = {"comment"};//表名
        String dir = "com.my";//父目录
        addNew(dir,"null",strings);

    }

    public static void addNew(String dir, String path, String[] strings){
        //构建一个代码生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();
        //配置策略
        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //获取用户目录
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor("Ye");
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(false);
        globalConfig.setServiceName("%sService");//去service的I前缀
        globalConfig.setIdType(IdType.AUTO);
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setSwagger2(true);
        autoGenerator.setGlobalConfig(globalConfig);

        //设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mypractice?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        dataSourceConfig.setDbType(DbType.MYSQL);
        autoGenerator.setDataSource(dataSourceConfig);

        //配置包
        PackageConfig packageConfig = new PackageConfig();
        if (path != "null") {
            packageConfig.setModuleName(path);//设置模块名
        }
        packageConfig.setParent(dir);
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setController("controller");
        autoGenerator.setPackageInfo(packageConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //映射数据库表
        strategyConfig.setInclude(strings);//多个表也可以设置
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//      strategyConfig.setSuperEntityClass("你的父类实体,没有就不用设置");
//      strategyConfig.setTablePrefix("sys_");//去掉表的前缀
        strategyConfig.setEntityLombokModel(true);//自动Lombok
        strategyConfig.setRestControllerStyle(true);//驼峰命名
        strategyConfig.setLogicDeleteFieldName("deleted");//逻辑删除
        strategyConfig.setControllerMappingHyphenStyle(true);//locahost:8080/hello_id_2
        //自动填充
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);//插入时间
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);//更新时间
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategyConfig.setTableFillList(tableFills);
        //乐观锁
        strategyConfig.setVersionFieldName("version");
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();
    }
    }







