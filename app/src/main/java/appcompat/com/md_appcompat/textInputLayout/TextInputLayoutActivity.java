package appcompat.com.md_appcompat.textInputLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

import appcompat.com.md_appcompat.R;

public class TextInputLayoutActivity extends AppCompatActivity {
    private TextInputLayout textInputLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textintput_layout);

        textInputLayout = findViewById(R.id.textInputLayout);
        textInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //开始计数
        textInputLayout.setCounterEnabled(true);
        //设置最大计数
        textInputLayout.setCounterMaxLength(10);
    }
}
