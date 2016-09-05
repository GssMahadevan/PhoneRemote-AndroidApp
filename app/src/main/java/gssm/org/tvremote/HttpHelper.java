package gssm.org.tvremote;

import android.content.Context;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by gssm on 21/8/16.
 */

public class HttpHelper {
    private static final String TAG="HttpHelper";
    public static final  String URL="http://your_python_phone_remote_server_:port/";
    private final Context ctx;
    private Retrofit retrofit;
    ApiInterface apiService ;


    public HttpHelper(Context ctx) {
        this.ctx = ctx;
        init();
    }
    private void init(){
        if(retrofit != null) return;
        retrofit=ApiClient.getClient(ctx);
        apiService =retrofit.create(ApiInterface.class);
    }
    public  void callChip(int position, long id, String mode) {
        init();
        String cmd = ImageAdapter.getCodeByString(position);
        if (cmd == null) {
            Log.e(TAG,"No command at location:"+position);
            return;
        }
        callRetrofitAsync(apiService,cmd,mode);
    }
    public void callRetrofitAsync( final String cmd,String mode) {
        callRetrofitAsync(apiService,cmd,mode);
    }
    public void callRetrofitAsync(ApiInterface apiService, final String cmd,final String mode) {

        Call<CmdResponse> call = apiService.sendCode(cmd,mode);
        final String w1 = call.request().url().toString();//  toString();

        Log.i(TAG, "callRetrofitAsync "+w1);
        call.enqueue(new Callback<CmdResponse>() {
            @Override
            public void onResponse(Call<CmdResponse>call, Response<CmdResponse> response) {
                if(response == null) {
                    Log.d(TAG, "onResponse: null response");
                    return;
                }
                CmdResponse body = response.body();
                if(body == null){
                    Log.d(TAG, "onResponse: null body response");
                    return;
                }
                String code = body.getCode();
                Log.d(TAG, "onResponse: " + w1+ " -->"+ code);
            }

            @Override
            public void onFailure(Call<CmdResponse>call, Throwable t) {
                Log.e(TAG, "onFailure "+w1+" ,ex:"+t.toString());
            }
        });
    }
}
