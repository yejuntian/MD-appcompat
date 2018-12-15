package appcompat.com.md_appcompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    private ListPopupWindow listPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonPanel);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPanel:
                showListPopWindow();
                break;
        }
    }

    private void showListPopWindow() {
        String lists[] = new String[]{"第一个条目", "第二个条目", "第三个条目"};
        MyAdapter adapter = new MyAdapter(this,lists);

        listPopupWindow = new ListPopupWindow(this);
        listPopupWindow.setAdapter(adapter);

        listPopupWindow.setWidth(400);
        listPopupWindow.setHeight(400);
        listPopupWindow.setModal(true);//设置为true响应物理键
        listPopupWindow.setAnchorView(button);
        listPopupWindow.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.colorAccent)));//设置背景色;
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "点击第 " + position + " 个条目", Toast.LENGTH_LONG).show();
                listPopupWindow.dismiss();
            }
        });
        listPopupWindow.show();
    }

}
