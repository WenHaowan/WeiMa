package as.bwei.com.weima.model;

import as.bwei.com.weima.utils.OkHttpUtils;
import okhttp3.Callback;

/**
 * Created by HP on 2018/8/11.
 */

public class RecyModel implements IRecyModel{
    @Override
    public void recy(Callback callback) {
        OkHttpUtils.getInstance().doGet("https://www.zhaoapi.cn/product/searchProducts?keywords=笔记本&page=1", callback);
    }
}
