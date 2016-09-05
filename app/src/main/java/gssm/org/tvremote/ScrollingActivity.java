package gssm.org.tvremote;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;



public class ScrollingActivity extends AppCompatActivity {
    private static final String TAG="ScrollingActivity";
    private ImageAdapter imageAdapter;
    HttpHelper helper;
    private static String mode="stb";//stb -- set top box , tv - TV
    private static final int RESULT_SETTINGS = 1234;

    public static  String getMode(){
        return  mode;
    }
    private void decorateGV(GridView gv) {

        gv.setAdapter(imageAdapter);
        gv.setBackgroundColor(getResources().getColor(R.color.black));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                handleView(v,position,id);
            }
        });
    }

    private void handleView(View v,int position, long id) {
        String tvTxt = Integer.toString(position);
        if(position < ImageAdapter.BUTTONS.length) {
            Log.d(TAG,"handleView pos:"+ position);

            if("".equals(ImageAdapter.BUTTONS[position])) return;
            Log.d(TAG,"handleView pos-2:"+ position);
            String what = ImageAdapter.BUTTONS[position];
            if("stb".equals(what)){
                ImageView iv = (ImageView) v;
                if("stb".equals(mode)){
                    Log.d(TAG,"Changed mode to TV");
                    iv.setImageResource(R.drawable.j_tv);
                    mode="tv";
                }else{
                    mode="stb";
                    Log.d(TAG,"Changed mode to STB");
                    iv.setImageResource(R.drawable.j_stb);
                }
                return;
            }
            helper.callChip(position, id,mode);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        imageAdapter = new ImageAdapter(this);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        decorateGV(gridview);
        helper = new HttpHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.i(TAG,  " onOptionsItemSelected:" + item);
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, UserSettingActivity.class);
            startActivityForResult(i, RESULT_SETTINGS);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}