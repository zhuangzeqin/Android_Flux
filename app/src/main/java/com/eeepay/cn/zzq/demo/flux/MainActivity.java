package com.eeepay.cn.zzq.demo.flux;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eeepay.cn.zzq.demo.flux.actions.ActionsCreator;
import com.eeepay.cn.zzq.demo.flux.actions.MessageAction;
import com.eeepay.cn.zzq.demo.flux.dispatcher.Dispatcher;
import com.eeepay.cn.zzq.demo.flux.model.Message;
import com.eeepay.cn.zzq.demo.flux.otto.MainStoreEvent;
import com.eeepay.cn.zzq.demo.flux.stores.MessageStore;
import com.squareup.otto.Subscribe;
 /**
  * 描述：Flux模式最大的特点是单向的数据流，它的UI状态更新模式继承了MVC模式的设计思想
  * 作者：zhuangzeqin
  * 时间: 2017/11/28-20:54
  * 邮箱：zzq@eeepay.cn
  */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.EditText messageeditor;
    private android.widget.Button messagebutton;
    private android.widget.Button btn_toast;
    private android.widget.TextView messageview;

    private ActionsCreator actionsCreator;//1 创建 action 对象
    private Dispatcher dispatcher;// 2 创建Dispatcher 对象

    private MessageStore store;//3  创建有关的store 对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.messageview = (TextView) findViewById(R.id.message_view);
        this.messagebutton = (Button) findViewById(R.id.message_button);
        this.btn_toast = (Button) findViewById(R.id.btn_toast);
        this.messagebutton.setOnClickListener(this);
        this.btn_toast.setOnClickListener(this);
        this.messageeditor = (EditText) findViewById(R.id.message_editor);

        initCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        store.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        store.unregister(this);
    }

    @Override
    protected void onDestroy() {
        dispatcher.unregister(store);
        super.onDestroy();
    }

    private void initCreate() {
        dispatcher = Dispatcher.getInstance();
        actionsCreator = ActionsCreator.getInstance(dispatcher);
        store = new MessageStore();
        dispatcher.register(store);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.message_button:
                String msgText = messageeditor.getText().toString().trim();
                actionsCreator.sendDispatch(new MessageAction(MessageAction.ACTION_NEW_MESSAGE, msgText));
                messageeditor.setText(null);
                break;
            case R.id.btn_toast:
                String msgText2 = messageeditor.getText().toString().trim();
                actionsCreator.sendDispatch(new MessageAction(MessageAction.ACTION_NEW_TOAST, msgText2));
                messageeditor.setText(null);
                break;
        }
    }

    private void render(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageview.setText(msg);
            }
        });

    }

    @Subscribe
    public void onStoreChange(MainStoreEvent event) {
        if (event.getOperationType().equals(MessageAction.ACTION_NEW_MESSAGE)) {
            Message data = event.getData();
            render(data.getMessage());
        } else if (event.getOperationType().equals(MessageAction.ACTION_NEW_TOAST)) {
            Message data = event.getData();
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
