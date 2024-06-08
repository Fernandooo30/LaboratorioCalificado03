import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import com.fernando.mendoza.laboratoriocalificado03.model.Teacher
import com.fernando.mendoza.laboratoriocalificado03.model.TeacherResponse
import com.fernando.mendoza.laboratoriocalificado03.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeacherViewModel : ViewModel() {

    private val _teachers = MutableLiveData<List<Teacher>>()
    val teachers: LiveData<List<Teacher>> get() = _teachers

    fun fetchTeachers() {
        RetrofitClient.apiService.getTeachers().enqueue(object : Callback<TeacherResponse> {
            override fun onResponse(call: Call<TeacherResponse>, response: Response<TeacherResponse>) {
                if (response.isSuccessful) {
                    _teachers.value = response.body()?.teachers
                } else {
                    Log.e("TeacherViewModel", "Error fetching teachers: ${response.code()} - ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TeacherResponse>, t: Throwable) {
                Log.e("TeacherViewModel", "Error fetching teachers", t)
            }
        })
    }
}
