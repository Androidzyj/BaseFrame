package com.example.baseframe.presenter.commonUtils;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.widget.EditText;

/**
 * Created by Administrator on 2019/9/12 0012
 * 通用工具类
 */
public class CommonUtils {
    public Context mContext;

    public CommonUtils(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 设置Editext输入字体的大小
     * @param editText
     * @param hintSize 提示信息大小
     * @param contentSize 输入内容字体大小
     */
    public void setEditTextSize(final EditText editText, final int hintSize, final int contentSize) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, hintSize);
                } else {
                    editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, contentSize);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
