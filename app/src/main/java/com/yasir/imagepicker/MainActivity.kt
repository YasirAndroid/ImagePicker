package com.yasir.imagepicker

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), ImagePickerCallback {

    private lateinit var imagePicker: ImagePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Initialize the ImagePicker
        imagePicker = ImagePicker(this, this, this)
        imagePicker.requestCameraPermission()

        // Example: Open Camera
        findViewById<TextView>(R.id.openCameraButton).setOnClickListener {
            imagePicker.openCamera()
        }

        // Example: Open Gallery
        findViewById<TextView>(R.id.openGalleryButton).setOnClickListener {
            imagePicker.requestGalleryPermission()
        }
    }

    override fun onImagePicked(uri: Uri, filePath: String?) {
        Toast.makeText(this, "Image Path: $filePath", Toast.LENGTH_LONG).show()
        Log.d("filePath", filePath.toString())

        findViewById<ImageView>(R.id.iv_load).setImageURI(filePath?.toUri())
    }

    override fun onError(errorMessage: String) {
        Toast.makeText(this, "Error: $errorMessage", Toast.LENGTH_SHORT).show()
    }
}