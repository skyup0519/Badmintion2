package com.example.andy.app_test.Fragment;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.andy.app_test.R;
import com.example.andy.app_test.TestLog;
import com.example.andy.app_test.model.Main_badminton_servicer;
import com.example.andy.app_test.myapp.MyApp;

import java.util.List;


public class Fragment_viewpage4 extends Fragment {

    private  final String FRAGMENT_VIEWPAGE4 = "Fragment_viewpage4";
    private ImageView iv_page;
    private View view;

    public Fragment_viewpage4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TestLog.myLog_i(FRAGMENT_VIEWPAGE4, "onCreateView()");
        view = inflater.inflate(R.layout.viewpage_fragment4, container, false);
        init();
        return view;
    }

    private void init() {

        iv_page = (ImageView) view.findViewById(R.id.viewpage_fragment4_iv_page);

        Main_badminton_servicer myServicer = MyApp.getMain_badminton_servicer();
        List<String> list = myServicer.getViewpageUrl();
        TestLog.myLog_i(FRAGMENT_VIEWPAGE4, "list SIZE", list.size() + "");

        if(list.size() ==0){
            TestLog.myLog_i(FRAGMENT_VIEWPAGE4,"error");

            Resources res=getResources();
            Bitmap bmp= BitmapFactory.decodeResource(res, R.drawable.iv_viewpage1);
            iv_page.setImageBitmap(bmp);
            return;
        }

        if (list.size() != 0) {

            TestLog.myLog_i(FRAGMENT_VIEWPAGE4, "success");
            Glide.with(getActivity()).load(list.get(4)).into(iv_page);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        TestLog.myLog_i(FRAGMENT_VIEWPAGE4, "onStart()");

    }

    @Override
    public void onPause() {
        super.onPause();
        TestLog.myLog_i(FRAGMENT_VIEWPAGE4, "onPause()");
    }

    @Override
    public void onResume() {
        super.onResume();
        TestLog.myLog_i(FRAGMENT_VIEWPAGE4, "onResume()");
        init();
    }
}