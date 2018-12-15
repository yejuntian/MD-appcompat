package appcompat.com.md_appcompat.snackbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import appcompat.com.md_appcompat.R;

public class SnackBarActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mCustomToast;
    private Button mSnackBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_snackbar_layout);
        mCustomToast = findViewById(R.id.btn_toast);
        mSnackBar = findViewById(R.id.btn_snackBar);
        mCustomToast.setOnClickListener(this);
        mSnackBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_toast:
                Toast result = new Toast(this);
                LayoutInflater inflate = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = inflate.inflate(R.layout.custom_toast_layout, null);
                result.setView(customView);
                result.setDuration(Toast.LENGTH_LONG);
                result.show();
                break;
            case R.id.btn_snackBar:
                Snackbar snackbar = Snackbar.make(v, "是否打开GPS", Snackbar.LENGTH_LONG);
                snackbar.setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "使用SnackBar", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.setActionTextColor(Color.RED);
                snackbar.show();
                break;
        }
    }
}
