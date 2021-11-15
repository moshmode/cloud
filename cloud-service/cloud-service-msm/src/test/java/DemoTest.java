import com.alibaba.cloudapi.sdk.constant.SdkConstant;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import com.mosh.msm.client.MsmApiClient;
import com.mosh.msm.context.MsmConfigurationContext;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/6 9:57
 */
public class DemoTest {


    @Resource
    MsmConfigurationContext context;


    @Test
    void test1() {
        context.setClient(new MsmApiClient());
        ApiResponse response = context.getClient().sendSyncMode("13021885052", "M72CB42894", "220577");
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String getResultString(ApiResponse response) throws IOException {
        StringBuilder result = new StringBuilder();
        result.append("Response from backend server").append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        result.append("ResultCode:").append(SdkConstant.CLOUDAPI_LF).append(response.getCode()).append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        if (response.getCode() != 200) {
            result.append("Error description:").append(response.getHeaders().get("X-Ca-Error-Message")).append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        }

        result.append("ResultBody:").append(SdkConstant.CLOUDAPI_LF).append(new String(response.getBody(), SdkConstant.CLOUDAPI_ENCODING));

        return result.toString();
    }
}
