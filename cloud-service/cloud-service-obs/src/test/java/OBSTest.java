import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/14 19:46
 */
public class OBSTest {

    @Test
    void test() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(dateFormat.format(date));

    }

    @Test
    void test1() {
        String url = "https://blog-cover.oss-cn-shenzhen.aliyuncs.com/2021/11/16/26e3f81801bb431c87b406bf8f936fa5";
        int index = url.lastIndexOf('.');
        System.out.println(url.substring(index + 5));

    }

}
