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
    void test(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(dateFormat.format(date));

    }

}
