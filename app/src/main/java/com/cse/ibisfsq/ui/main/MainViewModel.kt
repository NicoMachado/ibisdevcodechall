package com.cse.ibisfsq.ui.main

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cse.ibisfsq.Resource
import com.cse.ibisfsq.Status
import com.cse.ibisfsq.retrofit.RetrofitInstance
import com.cse.ibisfsq.retrofit.api.FSQPlacesResponse
import com.cse.ibisfsq.retrofit.api.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class MainViewModel : ViewModel() {

    val api = RetrofitInstance.api

    //private var responseLiveData : MutableLiveData<List<Result>?> = MutableLiveData()
    private val _responseLiveData : MutableLiveData<Resource<List<Result>>> = MutableLiveData()
    val responseLiveData : MutableLiveData<Resource<List<Result>>>
        get() = _responseLiveData

    private val fsqEventChannel = Channel<MainEvent>()
    val fsqEvent = fsqEventChannel.receiveAsFlow()

    var q:String = ""
    private var isLoading = false
    private var isError = false

    private suspend fun getPlaces(query : String) {
            Log.d(TAG, "getPlaces: query: $query")
            isError = false

            val response = try {
                isLoading = true
                _responseLiveData.postValue(Resource(Status.LOADING, null,  null))
                api.getPlaces(query)
            } catch (e: IOException){
                isLoading = false
                isError = true
                Log.e(TAG, "IOException: ${e.localizedMessage}", )
                _responseLiveData.postValue(Resource(Status.ERROR, null,  "IOException: " + e.localizedMessage))
                return
            } catch (e: HttpException) {
                isLoading = false
                isError = true
                Log.e(TAG, "HttpException: ${e.localizedMessage}", )
                _responseLiveData.postValue(Resource(Status.ERROR, null, "HttpException: "  + e.localizedMessage))
                return
            }
            if (response.isSuccessful && response.body() != null) {
                isLoading = false

                _responseLiveData.postValue(Resource(Status.SUCCESS,response.body()!!.results!!,null ))
                Log.d(TAG, "postValue ... getPlaces Success")
            } else {
                Log.d(TAG, "onResponse: $response")
            }
            Log.d(TAG, "getPlaces: post query : $query")
    }

    fun onSearchClicked(query: String) {
        q = query
        viewModelScope.launch {
            getPlaces(query)
            Log.d(TAG, "after getPlaces ? : ${isLoading}")
            if (!isLoading && !isError) {
                Log.d(TAG, "after getPlaces : SUCCESS ")
                navigateToPlacesFragment()
            }
        }
    }

    fun navigateToPlacesFragment() {
        viewModelScope.launch {
            fsqEventChannel.send(MainEvent.NavigateToPlacesFragment)
        }
    }

    sealed class MainEvent {
        //data class NavigateToPlacesFragment(val query: String) : MainEvent()
        companion object NavigateToPlacesFragment : MainEvent()
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}