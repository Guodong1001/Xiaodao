package com.bwie.xiaodao.view.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.xiaodao.R;

/**
 * 类描述：
 * 创建人：xiaoqian
 * 创建时间：2017/8/10 17:09
 */


public class ContentFragment extends Fragment {
      private static final String KEY = "arg";

          private View view;

          @Nullable
          public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
              view = inflater.inflate(R.layout.fragment_content, container, false);
              TextView txt = (TextView) view.findViewById(R.id.txt_content);
              return view;
          }


          /**
           * Fragment静态传值
           * @param str
           * @return
           */
          public static ContentFragment newInstance(String str) {
              ContentFragment fragment = new ContentFragment();
              Bundle bundle = new Bundle();
              bundle.putString(KEY, str);
              return fragment;
          }

}
