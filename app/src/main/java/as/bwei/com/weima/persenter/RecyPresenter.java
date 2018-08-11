package as.bwei.com.weima.persenter;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import as.bwei.com.weima.bean.InfoDatas;
import as.bwei.com.weima.model.IRecyModel;
import as.bwei.com.weima.model.RecyModel;
import as.bwei.com.weima.utils.OnUiCallback;
import as.bwei.com.weima.view.IRecyView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by HP on 2018/8/11.
 */

public class RecyPresenter {
    private IRecyView view;
    private IRecyModel model;

    public RecyPresenter(IRecyView view) {
        this.view = view;
        model = new RecyModel();
    }

    public void showRecy(){
        model.recy(new OnUiCallback() {

            private InfoDatas infoDatas;

            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) throws IOException {
                Log.i("ss",result);
                Gson gson = new Gson();
                infoDatas = gson.fromJson(result, InfoDatas.class);
                view.showRecy(infoDatas);
            }
        });
    }

    //解绑
    public void onDestory(){
        view = null;
    }
}
