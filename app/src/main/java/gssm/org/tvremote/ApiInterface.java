package gssm.org.tvremote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("/ir/change")
    Call<CmdResponse> sendCode(@Query("code") String code,@Query("model") String model);
}