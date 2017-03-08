package tj.com.scrollview_and_listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView mLView;
    private ScrollView mSview;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLView=(ListView)findViewById(R.id.mListView);
        mSview=(ScrollView)findViewById(R.id.mScrollView);
        adapter=new ArrayAdapter<String>(this,R.layout.listview_item_layout,R.id.itemtext,getData());
        mLView.setAdapter(adapter);
    }
    public List<String> getData(){
        List<String> list=new ArrayList<String>();
        for (int i = 0; i <20; i++) {
            list.add("jack"+i);
        }
        return list;
    }

    //拦截事件，进行分发，分发到指定对象中
    @Override
    public boolean dispatchTouchEvent(MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_MOVE){
            //将事件分发到listview中
            mLView.dispatchTouchEvent(event);
        }
        return super.dispatchTouchEvent(event);
    }
}


