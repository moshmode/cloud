import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.edu.EduApplication;
import com.mosh.edu.entity.Course;
import com.mosh.edu.entity.query.CourseQuery;
import com.mosh.edu.mapper.CourseMapper;
import com.mosh.db.mapper.MapperUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/22 10:29
 */
@SpringBootTest(classes = EduApplication.class)
public class UtilsTest {
    @Resource
    CourseMapper mapper;

    @Test
    void test() throws IllegalAccessException {
        CourseQuery query = new CourseQuery();
        query.setTitle("8s");
        Page<Course> page = MapperUtils.getPage(mapper, query, 0, 4);
        System.out.println("-------------------------------------------");
        System.out.println("-------------------------------------------");
        System.out.println(page.getTotal());
        for (Course record : page.getRecords()) {
            System.out.println(record);
        }
    }
}
