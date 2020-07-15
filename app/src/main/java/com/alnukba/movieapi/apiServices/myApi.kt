package com.alnukba.movieapi.apiServices


import com.alnukba.movieapi.models.categoryModel.categoryModel
import com.alnukba.movieapi.models.detailsModel.movieDetails
import com.alnukba.movieapi.models.movieModel.poupolarMovie
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mustafayusef.holidaymaster.networks.networkIntercepter
import okhttp3.CipherSuite
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import java.util.*
import java.util.concurrent.TimeUnit


interface myApi {


    @GET("movie/popular?api_key=ee59fe79dd07494a5804e1206a396a15&language=en-US&page=1")
    suspend fun getPopolarMovie():Response<poupolarMovie>

    @GET("movie/upcoming?api_key=ee59fe79dd07494a5804e1206a396a15&language=en-US&page=1")
    suspend fun getupcoming():Response<poupolarMovie>

    @GET("movie/now_playing?api_key=ee59fe79dd07494a5804e1206a396a15&language=en-US&page=1")
    suspend fun getNowPlaying():Response<poupolarMovie>

    @GET("movie/top_rated?api_key=ee59fe79dd07494a5804e1206a396a15&language=en-US&page=1")
    suspend fun getTopRated():Response<poupolarMovie>

    @GET("movie/{id}/similar/?api_key=ee59fe79dd07494a5804e1206a396a15&language=en-US")
    suspend fun getSimilarMovie(
        @Path("id") id:Int):Response<poupolarMovie>

    @GET("movie/{id}?api_key=ee59fe79dd07494a5804e1206a396a15&language=en-US")
    suspend fun getMovieDetails(
        @Path("id") id:Int):Response<movieDetails>

    @GET("genre/movie/list?api_key=ee59fe79dd07494a5804e1206a396a15&language=en-US")
    suspend fun getCategory(
        ):Response<categoryModel>


    @GET("discover/movie?api_key=ee59fe79dd07494a5804e1206a396a15&")
    suspend fun getMoviesByGenre(@Query("with_genres") id:Int
    ):Response<poupolarMovie>
    companion object{

        operator fun invoke(
            networkIntercepter: networkIntercepter
        ):myApi{
            val spec = ConnectionSpec.Builder ( ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_2)
                .cipherSuites(
                    CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                    CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                    CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256
                )
                .build()
            val spec1 = ConnectionSpec.Builder ( ConnectionSpec.CLEARTEXT)
                .build()

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .connectTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .addInterceptor(networkIntercepter).addInterceptor(loggingInterceptor)
                .connectionSpecs(Collections.singletonList(spec))
//                .connectionSpecs(Collections.singletonList(spec1))
                .build()
            return Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.themoviedb.org/3/")
              //  .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(myApi::class.java)
        }
    }
}
