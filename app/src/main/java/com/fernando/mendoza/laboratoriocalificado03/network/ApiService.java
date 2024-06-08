package com.fernando.mendoza.laboratoriocalificado03.network;

import com.fernando.mendoza.laboratoriocalificado03.model.Teacher;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/list/teacher-b")
    Call<List<Teacher>> getTeachers();
}
