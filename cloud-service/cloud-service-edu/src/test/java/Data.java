import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/15 15:07
 */

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class Data {

    @ExcelProperty(index = 0)
    int id;

    @ExcelProperty(index = 1)
    String name;
}
