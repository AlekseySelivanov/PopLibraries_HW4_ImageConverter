package com.example.imageconverter.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import com.example.imageconverter.R
import com.example.imageconverter.mvp.model.IConverter
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.File
import java.io.FileOutputStream

class Converter(val context: Context) : IConverter {
    override fun convertImage(path: String): Completable = Completable.fromAction {

        val image = context.contentResolver?.openInputStream(Uri.parse(path))?.buffered()
            ?.use { it.readBytes() }
            image?.let {
            val bitmap = BitmapFactory.decodeByteArray(it, 0, it.size)
            val file =
                File(context.getExternalFilesDir(null), context.getString(R.string.converted_name))
            FileOutputStream(file).use {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
            }
        }
    }
        .subscribeOn(Schedulers.io())
}