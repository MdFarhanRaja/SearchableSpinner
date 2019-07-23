package in.galaxyofandroid.searchablespinner;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {

    @GET("api/users")
    Call<Response> getUsers(@Query("page") int page);
}
