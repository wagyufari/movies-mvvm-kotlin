package com.nacoda.moviesmvvm.data.source.remote

import com.nacoda.moviesmvvm.data.model.Detail
import id.gits.jasaraharja.base.BaseApiModel
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.util.helper.Network
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 * Created by irfanirawansukirman on 04/12/17.
 */
interface MoviesService {

    /**
     * Do get movie list with this path
     */
    @GET("movie/popular")
    fun getPopular(
            @Query("api_key") api_key: String,
            @Query("language") language: String,
            @Query("page") page: String
    ): Observable<BaseApiModel<List<Movie>>>

    @GET("movie/now_playing")
    fun getNowPlaying(
            @Query("api_key") api_key: String,
            @Query("language") language: String,
            @Query("page") page: String
    ): Observable<BaseApiModel<List<Movie>>>

    @GET("movie/top_rated")
    fun getTopRated(
            @Query("api_key") api_key: String,
            @Query("language") language: String,
            @Query("page") page: String
    ): Observable<BaseApiModel<List<Movie>>>

    @GET("search/movie")
    fun getSearch(
            @Query("api_key") api_key: String,
            @Query("language") language: String,
            @Query("query") query: String
    ):Observable<BaseApiModel<List<Movie>>>

    @GET("movie/{movieId}")
    fun getDetail(
            @Path("movieId") movieId: String,
            @Query("api_key") api_key: String,
            @Query("language") language: String
    ): Observable<Detail>

    /**
     * Companion object to create the Jasa Raharja Service
     */
    companion object Factory {

        fun create(): MoviesService {

            val mLoggingInterceptor = HttpLoggingInterceptor()
            mLoggingInterceptor.level = BODY

            val mClient = OkHttpClient.Builder()
                    .addInterceptor(mLoggingInterceptor)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()

            /**
             * Un-comment when unit test
             */
//            val resource = OkHttp3IdlingResource.create("OkHttp", client)
//            IdlingRegistry.getInstance().register(resource)

            val mRetrofit = Retrofit.Builder()
                    .baseUrl(Network.API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(mClient) //Todo comment if app release
                    .build()

            return mRetrofit.create(MoviesService::class.java)
        }
    }
}