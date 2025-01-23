package com.yasir.imagepicker

import android.net.Uri

interface ImagePickerCallback {
    fun onImagePicked(uri: Uri, filePath: String?)
    fun onError(errorMessage: String)
}
