package gssm.org.tvremote;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {
    private static final String TAG="ImageAdapter";
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return BUTTONS.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        Log.d(TAG,"getView pos:"+position+", name:"+BUTTONS[position]);
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(72, 72));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(8, 8, 8, 8);

        } else {
            imageView = (ImageView) convertView;
        }
        if(position < mThumbIds.length) {
            imageView.setImageResource(mThumbIds[position]);
        }else{
            imageView.setImageResource(R.drawable.black_empty);
        }
        return imageView;

    }



    // references to our images
    public static  String[] BUTTONS = {
            "" ,"", "",
            "power" ,"",  "mute",
            "1" ,"2" , "3",
            "4" ,"5" , "6",
            "7" ,"8" , "9",
            "text" ,"0" , "sub",
            "menu" ,"up" , "guide",
            "left" ,"ok" , "right",
            "enter","down","i",
            "ch-up" ,"reverse" , "vol_up",
            "ch_down" ,"pause" , "vol_down",
            "" ,"forward" , "",
            "red" ,"green" , "yellow","blue",
            "stb"
    };

    public static  String[] STR_CODES = {
            "" ,"", "",
            "power" ,"",  "mute",
            "b1" ,"b2" , "b3",
            "b4" ,"b5" , "b6",
            "b7" ,"b8" , "b9",
            "text" ,"b0" , "sub",
            "menu" ,"up" , "guide",
            "left" ,"ok" , "right",
            "enter","down","i",
            "ch_up" ,"reverse" , "vol_up",
            "ch_down" ,"pause" , "vol_down",
            "" ,"forward" , "",
            "red" ,"green" , "yellow","blue",
            "stb"
    };

    // references to our images
    private static final Integer[] mThumbIds = {

            R.drawable.black_empty, R.drawable.black_empty,R.drawable.black_empty,
            R.drawable.j_power, R.drawable.black_empty,R.drawable.j_mute,
            R.drawable.j_b1, R.drawable.j_b2,R.drawable.j_b3,
            R.drawable.j_b4,  R.drawable.j_b5,R.drawable.j_b6,
            R.drawable.j_b7,R.drawable.j_b8,R.drawable.j_b9,
            R.drawable.j_text,R.drawable.j_b0,R.drawable.j_sub,
            R.drawable.j_menu,R.drawable.j_up,R.drawable.j_guide,
            R.drawable.j_left,R.drawable.j_ok,R.drawable.j_right,
            R.drawable.j_enter,R.drawable.j_down,R.drawable.j_i,
            R.drawable.j_ch_up,R.drawable.j_reverse,R.drawable.j_vol_up,
            R.drawable.j_ch_down,R.drawable.j_pause,R.drawable.j_vol_down,
            R.drawable.black_empty,R.drawable.j_forward,R.drawable.black_empty,
            R.drawable.j_red,R.drawable.j_green,R.drawable.j_yellow,
            R.drawable.j_blue,R.drawable.j_stb,
    };

    public static String getCodeByString(int location){
        if(location > STR_CODES.length || location < 0 ){
            return null;
        }
        String ret = STR_CODES[location];
        if("tv".equals(ret) || "stb".equals(ret)) return null;
        return  ret;
    }
}