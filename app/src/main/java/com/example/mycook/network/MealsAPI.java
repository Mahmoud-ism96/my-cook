package com.example.mycook.network;

import com.example.mycook.model.Meals;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealsAPI implements RemoteSource {

    private static String TAG = "MEALS_API";

    public static String BASE_URL = "https://themealdb.com/api/json/v1/1/";
    private static Retrofit retrofit;
    private static MealsAPI client = null;

    private MealsAPI() {
    }

    public static MealsAPI getInstance() {
        if (client == null) {
            client = new MealsAPI();
        }
        return client;
    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static void dailyInspirationEnqueue(NetworkDelegate networkDelegate) {
        ApiInterface apiService = MealsAPI.getClient().create(ApiInterface.class);
        Call<Meals> call = apiService.getDailyInspiration();
        call.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                if (response.isSuccessful()) {
                    networkDelegate.onSuccessResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());
            }
        });
    }

    public static void mealsByAreaEnqueue(NetworkDelegate networkDelegate, String area) {
        ApiInterface apiService = MealsAPI.getClient().create(ApiInterface.class);
        Call<Meals> call = apiService.getMealsByArea(area);
        call.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                if (response.isSuccessful()) {
                    networkDelegate.onSuccessResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());
            }
        });
    }

    public static void mealsByIngredientEnqueue(NetworkDelegate networkDelegate, String ingredient) {
        ApiInterface apiService = MealsAPI.getClient().create(ApiInterface.class);
        Call<Meals> call = apiService.getMealsByIngredient(ingredient);
        call.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                if (response.isSuccessful()) {
                    networkDelegate.onSuccessResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());
            }
        });
    }

    public static void mealsByCategoryEnqueue(NetworkDelegate networkDelegate, String category) {
        ApiInterface apiService = MealsAPI.getClient().create(ApiInterface.class);
        Call<Meals> call = apiService.getMealsByCategory(category);
        call.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                if (response.isSuccessful()) {
                    networkDelegate.onSuccessResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());
            }
        });
    }

    public static void getIngredientsEnqueue(NetworkDelegate networkDelegate) {
        ApiInterface apiService = MealsAPI.getClient().create(ApiInterface.class);
        Call<Meals> call = apiService.getIngredients();
        call.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                if (response.isSuccessful()) {
                    networkDelegate.onSuccessResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());
            }
        });
    }

    public static void getCategoriesEnqueue(NetworkDelegate networkDelegate) {
        ApiInterface apiService = MealsAPI.getClient().create(ApiInterface.class);
        Call<Meals> call = apiService.getCategories();
        call.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                if (response.isSuccessful()) {
                    networkDelegate.onSuccessResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());
            }
        });
    }

    public static void getAreasEnqueue(NetworkDelegate networkDelegate) {
        ApiInterface apiService = MealsAPI.getClient().create(ApiInterface.class);
        Call<Meals> call = apiService.getAreas();
        call.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                if (response.isSuccessful()) {
                    networkDelegate.onSuccessResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());
            }
        });
    }

    @Override
    public void dailyInspirationEnqueueCall(NetworkDelegate networkDelegate) {
        dailyInspirationEnqueue(networkDelegate);
    }

    @Override
    public void mealsByAreaEnqueueCall(NetworkDelegate networkDelegate, String area) {
        mealsByAreaEnqueue(networkDelegate, area);
    }

    @Override
    public void mealsByIngredientEnqueueCall(NetworkDelegate networkDelegate, String ingredient) {
        mealsByIngredientEnqueue(networkDelegate, ingredient);
    }

    @Override
    public void mealsByCategoryEnqueueCall(NetworkDelegate networkDelegate, String category) {
        mealsByCategoryEnqueue(networkDelegate, category);
    }

    @Override
    public void getIngredientsEnqueueCall(NetworkDelegate networkDelegate) {
        getIngredientsEnqueue(networkDelegate);
    }

    @Override
    public void getCategoriesEnqueueCall(NetworkDelegate networkDelegate) {
        getCategoriesEnqueue(networkDelegate);
    }

    @Override
    public void getAreasEnqueueCall(NetworkDelegate networkDelegate) {
        getAreasEnqueue(networkDelegate);
    }
}
