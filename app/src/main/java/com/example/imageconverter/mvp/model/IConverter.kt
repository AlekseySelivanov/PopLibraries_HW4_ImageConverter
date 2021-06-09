package com.example.imageconverter.mvp.model

import io.reactivex.rxjava3.core.Completable

interface IConverter {
    fun convertImage(path:String): Completable
}