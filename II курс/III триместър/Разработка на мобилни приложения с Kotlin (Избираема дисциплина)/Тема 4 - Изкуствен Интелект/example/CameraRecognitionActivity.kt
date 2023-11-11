package com.mincho.mycars

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.mincho.mycars.databinding.ActivityCameraRecognitionBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.regex.Pattern


interface PassImage{
    fun recognizeText (image: InputImage)
}

const val ARG_REGEX = "regex_pattern"

@Suppress("DEPRECATION")
class CameraRecognitionActivity : AppCompatActivity(),PassImage{

    private var imageCapture: ImageCapture? = null

    private lateinit var binding: ActivityCameraRecognitionBinding


    private lateinit var cameraView: PreviewView

    private lateinit var cameraExecutor: ExecutorService

    private var regexPattern: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraRecognitionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        if (bundle != null) {
            regexPattern = bundle.getString(ARG_REGEX)!!
        }

        // Request camera permissions
        if (allPermissionsGranted()) {
            startCamera()
        } else {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
        }

        cameraView = binding.viewFinder

        // Set up the listener for take photo button
        binding.cameraCaptureButton.setOnClickListener { takePhoto() }


        cameraExecutor = Executors.newSingleThreadExecutor()


    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults:
        IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera()
            } else {
                Toast.makeText(this,
                    "Permissions not granted by the user.",
                    Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
//    "[A-Z][A-Z] ((\\d{4} [A-Z][A-Z])|(\\d{6}))"

    private fun takePhoto() {
        // Get a stable reference of the modifiable image capture use case
        val imageCapture = imageCapture ?: return
        
        // Set up image capture listener, which is triggered after photo has
        // been take
        imageCapture.takePicture(ContextCompat.getMainExecutor(this),object :ImageCapture.OnImageCapturedCallback(){
            @SuppressLint("UnsafeOptInUsageError")
            override fun onCaptureSuccess(image: ImageProxy) {
                super.onCaptureSuccess(image)

                Log.v(TAG, "image capture")
//                imageView.visibility = View.VISIBLE
//                imageView.setImageBitmap(imageProxyToBitmap(image))

                @SuppressLint("UnsafeExperimentalUsageError")
                val mediaImage = image.image
                if (mediaImage != null) {
                    val scanImage =
                        InputImage.fromMediaImage(mediaImage, image.imageInfo.rotationDegrees)
                    recognizeText(scanImage)

                }
            }

            override fun onError(exception: ImageCaptureException) {
                Log.e(TAG, "Photo capture failed: ${exception.message}", exception)
                super.onError(exception)
            }
        })
    }

    


    @SuppressLint("UnsafeExperimentalUsageError")
    private fun startCamera() {


        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener({
            // Used to bind the lifecycle of cameras to the lifecycle owner
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            // Preview
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.viewFinder.surfaceProvider)
                }

            imageCapture = ImageCapture.Builder()
                .build()

            // Select back camera as a default
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                // Unbind use cases before rebinding
                cameraProvider.unbindAll()
                // Bind use cases to camera
                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview, imageCapture)

            } catch(exc: Exception) {
                Log.e(TAG, "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(this))
    }
    
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            baseContext, it) == PackageManager.PERMISSION_GRANTED
    }


    override fun recognizeText (image: InputImage){
        //default detector
        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
        recognizer.process(image)
            .addOnSuccessListener { visionText ->
                processTextBlock(visionText)
            }
            .addOnFailureListener{ e ->
                Log.v(TAG,"Error while recognize ${e.message}", e)
            }
    }

    private fun processTextBlock(result: Text){
        if (result.textBlocks.size == 0){
            return
        }
        for (block in result.textBlocks){
            val blockText = block.text
            val blockCornerPoints = block.cornerPoints
            val blockFrame = block.boundingBox
            val results = Pattern.matches(regexPattern,blockText)
            val regex = regexPattern.toRegex()
            val match = regex.find(blockText)
            Log.v(TAG, "find - ${match.toString()}")
            Log.v(TAG,"blockText - $blockText, blockCornerPoints - ${blockCornerPoints?.size}, blockFrame - ${blockFrame?.left}")
            Log.v(TAG, "block text - $blockText result after regex = $results")
            if (results){
                val resultIntent = Intent()
                resultIntent.putExtra("result", blockText)
                setResult(RESULT_OK,resultIntent)
                finish()
            }
            Toast.makeText(this,"block text $blockText, result after regex = $results",Toast.LENGTH_LONG).show()
//            if (blockFrame != null) rectangles.add(blockFrame)
//            for (line in block.lines){
//                val lineText = line.text
//                val lineCornerPoints = line.cornerPoints
//                val lineFrame = line.boundingBox
//                for (element in line.elements) {
//                    val elementText = element.text
//                    val elementCornerPoints = element.cornerPoints
//                    val elementFrame = element.boundingBox
//                }
//            }
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }


    companion object {
        private const val TAG = "CameraXBasic"
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }
}