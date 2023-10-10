package com.gaurav.leraning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.gaurav.leraning.databinding.ActivityGetApiBinding
import retrofit2.Call
import java.security.KeyStore.LoadStoreParameter

class GetApiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGetApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var result: ArrayList<Response>? = null

        val request = LeaveListRequest(1, "6Cz#W\$3g2Ej&F#5f\$eX7")

        val call = RetrofitInstance.api.getAppliedLeaveList(request)

        call.enqueue(object : retrofit2.Callback<ArrayList<Response>> {
            override fun onResponse(call: Call<ArrayList<Response>>, response: retrofit2.Response<ArrayList<Response>>) {
                if (response.isSuccessful) {
                    result = response.body()
                    // Handle the result
                    Log.d("tag912", request.SecretKey)
                    Toast.makeText(this@GetApiActivity,response.body().toString(), Toast.LENGTH_SHORT ).show()
                    binding.rvList.adapter = RvAdapter(result?: ArrayList())
                    binding.rvList.layoutManager = LinearLayoutManager(this@GetApiActivity)
                } else {
                    // Handle the error
                    Toast.makeText(this@GetApiActivity,"Else", Toast.LENGTH_SHORT ).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<Response>>, t: Throwable) {
                // Handle the failure
                Log.d("tag912","${t.message}")
                Toast.makeText(this@GetApiActivity, "failed", Toast.LENGTH_SHORT ).show()

            }
        })


    }
}