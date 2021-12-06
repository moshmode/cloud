import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.forum.ForumApplication;
import com.mosh.forum.entity.Question;
import com.mosh.forum.entity.query.QuestionQuery;
import com.mosh.forum.mapper.QuestionMapper;
import com.mosh.forum.service.impl.QuestionServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/16 18:04
 */
@SpringBootTest(classes = {ForumApplication.class})
public class MyTest {

    @Resource
    QuestionMapper mapper;

    @Test
    void test() {
        QuestionQuery query = new QuestionQuery();
//        query.setEnd("2021-11-15T16:00:00.000Z");
        query.setName("mo");
        ArrayList<String> strings = new ArrayList<>();

        query.setLabels(strings);

        query.setOrder(0);
        Page<Question> page = new Page<>(0, 1);
        List<Question> questions = mapper.getQuestionByQuery(page, query);

        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------");
        System.out.println(page.getTotal());
        List<Question> records = page.getRecords();
        System.out.println(records.size());

        for (Question question : questions) {
            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");
            System.out.println(question);
            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");
        }


    }

}
