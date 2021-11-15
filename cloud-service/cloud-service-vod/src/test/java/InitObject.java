import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;


/**
 * Description
 *
 * @author mosh
 * @date 2021/11/3 19:12
 */
public class InitObject {

    public static DefaultAcsClient getClient() {
        String ak = "LTAI5tDoiUV5w9kMMqovxXUh", sk = "KNryDnaTbyrPq8ljeXSsc3v93UwZec", endPoint = "cn-shenzhen";

        DefaultProfile profile = DefaultProfile.getProfile(endPoint, ak, sk);
        return new DefaultAcsClient(profile);
    }
}
