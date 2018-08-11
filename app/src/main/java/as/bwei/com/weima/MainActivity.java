package as.bwei.com.weima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import as.bwei.com.weima.adapter.MyRecyAdapter;
import as.bwei.com.weima.bean.InfoDatas;
import as.bwei.com.weima.persenter.RecyPresenter;
import as.bwei.com.weima.view.IRecyView;

public class MainActivity extends AppCompatActivity implements IRecyView{

    private RecyPresenter presenter;
    private XRecyclerView xrv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        presenter = new RecyPresenter(this);
        presenter.showRecy();
    }

    private void initview() {
        xrv = (XRecyclerView) findViewById(R.id.xrv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv.setLayoutManager(manager);
    }

    @Override
    public void showRecy(InfoDatas infoDatas) {
        MyRecyAdapter myRecyAdapter = new MyRecyAdapter(this, infoDatas);
        xrv.setAdapter(myRecyAdapter);
    }
}
