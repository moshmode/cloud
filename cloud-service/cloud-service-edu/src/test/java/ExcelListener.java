import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/15 15:36
 */
public class ExcelListener extends AnalysisEventListener<Data> {

    //创建list集合封装最终的数据
    List<Data> list = new ArrayList<>();

    @Override
    public void invoke(Data data, AnalysisContext analysisContext) {
        System.out.println("***"+data);
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
