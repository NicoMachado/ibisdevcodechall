package com.cse.ibisfsq

import android.util.Log
import com.cse.ibisfsq.retrofit.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Test

import org.junit.Assert.*
import java.io.IOException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val api = RetrofitInstance.api
        CoroutineScope(Dispatchers.IO).launch {
            try {
                println("antes de pi.getPlaces() ...")
                val response = api.getPlaces("Bar")
                if (response.isSuccessful && response.body() != null) {
                    println("-- > response: ${response.body()!!}")
                    //Log.d("TEST", "response: ${response.body()!!}")
                }

            } catch (e : IOException ) {
                println(" Error -- > response: ${e}")
            }

        }
        assertEquals(4, 2 + 2)
    }
}