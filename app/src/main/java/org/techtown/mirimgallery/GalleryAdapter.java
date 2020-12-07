package org.techtown.mirimgallery;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GalleryAdapter extends BaseAdapter {
    Context context;
    TextView textToast;
    View toastView;

    int[] imgRes = {R.drawable.post1,R.drawable.post2,R.drawable.post3,R.drawable.post4,R.drawable.post5,R.drawable.post6,R.drawable.post7,R.drawable.post8,
            R.drawable.post9,R.drawable.post10,R.drawable.post11,R.drawable.post12,R.drawable.post13,R.drawable.post14,R.drawable.post15,R.drawable.post16
    };
    String[] titleRes={"기생충","설국열차","택시운전사","군함도","반도","레미제라블","라라랜드","메이즈러너","부산행","살아있다","비긴어게인","어바웃타임","마션","어벤저스","어벤저스","셜록홈즈"};
    ImageView imgvMain;

    public GalleryAdapter(Context context,ImageView imgvMain){
        this.context=context;
        this.imgvMain=imgvMain;
    }

    @Override
    public int getCount() {
        return imgRes.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final ImageView imgv=new ImageView(context);
        imgv.setLayoutParams(new Gallery.LayoutParams(200,300));
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imgv.setPadding(5,5,5,5);
        imgv.setImageResource(imgRes[position]);

        final int pos=position;
        imgv.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast toast=new Toast(context);
                toastView=View.inflate(context,R.layout.toast,null);
                imgvMain.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imgvMain.setImageResource(imgRes[pos]);
                textToast=toastView.findViewById(R.id.text_toast);
                textToast.setText(titleRes[pos]);
                toast.setView(toastView);
                toast.show();
                return false;
            }
        });
        return imgv;
    }
}
