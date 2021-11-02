
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.mosh.edu.service.CourseService;
import com.mosh.edu.service.impl.CourseServiceImpl;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/8 13:47
 */
public class Code {

    @Test
    public void test2() {
//        // 1、创建代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 2、全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir("D:/WorkSpace/IdeaProjects/cloud/cloud-service/cloud-service-edu/src/main/java/");
//
//        gc.setAuthor("mosh");
//        gc.setOpen(false); //生成后是否打开资源管理器
//        gc.setFileOverride(false); //重新生成时文件是否覆盖
//
//        //UserServie
//        gc.setServiceName("%sService");    //去掉Service接口的首字母I
//
//        gc.setIdType(IdType.ID_WORKER_STR); //主键策略
//        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
////        gc.setSwagger2(true);//开启Swagger2模式
//
//        mpg.setGlobalConfig(gc);
//
//        // 3、数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://localhost:3306/cloud?serverTimezone=GMT%2B8");
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername("mosh");
//        dsc.setPassword("mode0520");
//        dsc.setDbType(DbType.MYSQL);
//        mpg.setDataSource(dsc);
//
//        // 4、包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("edu"); //模块名
//        //包  com.atguigu.eduservice
//        pc.setParent("com.mosh");
//        //包  com.atguigu.eduservice.controller
//        pc.setController("controller");
//        pc.setEntity("entity");
//        pc.setService("service");
//        pc.setMapper("mapper");
//        mpg.setPackageInfo(pc);
//
//        // 5、策略配置
//        StrategyConfig strategy = new StrategyConfig();
//
//        strategy.setInclude("edu_video", "edu_chapter", "edu_course", "edu_course_description");
//
//        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
//        strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀
//
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
//        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作
//
//        strategy.setRestControllerStyle(true); //restful api风格控制器
//        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符
//
//        mpg.setStrategy(strategy);
//
//
//        // 6、执行
//        mpg.execute();

    }

    public void write() {
        ArrayList<Data> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new Data(i, "luck" + i));
        }
        EasyExcel.write(new File("D:/MyDownload/01.xls"), Data.class).sheet("hello").doWrite(data);
    }

    public void read() {
        EasyExcel.read(new File("D:/MyDownload/01.xls"), Data.class, new ExcelListener()).sheet("hello").doRead();
    }

}
