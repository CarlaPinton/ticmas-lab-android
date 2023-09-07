package com.curso.android.app.trabajofinal.trabajofinal.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.trabajofinal.trabajofinal.Model.CompararModel

class CompararViewModel : ViewModel() {


    val compararModel : LiveData<CompararModel> get() = _compararModel
    private var _compararModel = MutableLiveData<CompararModel>()

    val palabra1 : LiveData<String> get() = _palabra1
    private var _palabra1 = MutableLiveData<String>("")

    val palabra2 : LiveData<String> get() = _palabra2
    private var _palabra2 = MutableLiveData<String>("")

    val iguales : LiveData<Boolean> get() = _iguales
    private var _iguales = MutableLiveData<Boolean>()

    fun setPalabra1(string: String){
        _palabra1.value = string
    }

    fun setPalabra2(string: String){
        _palabra2.value = string
    }

    fun compararCadenas(){
        val sonIguales = palabra1.value == palabra2.value
        val resultado =  CompararModel(_palabra1.value?: "",_palabra2.value?: "",sonIguales)
        _compararModel.value=resultado
    }
}