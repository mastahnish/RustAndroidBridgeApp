package pl.myosolutions.rustandroidbridgeapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

open class MainActivity : AppCompatActivity() {
    private external fun addTwoInts(a: Int, b: Int): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {

            val a = findViewById<EditText>(R.id.number_a).text.toString()
            val b = findViewById<EditText>(R.id.number_b).text.toString()

            val result = addTwoInts(
                Integer.parseInt(if (a.isNullOrEmpty()) "0" else a),
                Integer.parseInt(if (b.isNullOrEmpty()) "0" else b)
            )
            Log.d("RustAndroidBridgeApp1234", "Result: $result")

            findViewById<TextView>(R.id.result).text = result.toString()
        }
    }

    companion object {
        init {
            System.loadLibrary("simple_library")
        }
    }
}


/*class MainActivity : AppCompatActivity() {
    private val REQUEST_IMAGE_CAPTURE = 1
    private val REQUEST_IMAGE_PICK = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ImageProcessingApp()
                }
            }
        }
    }

    @Composable
    fun ImageProcessingApp() {
        val imageBitmap = remember { mutableStateOf<ImageBitmap?>(null) }
        val context = LocalContext.current

        Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                    bitmap = imageBitmap.value ?: painterResource(R.drawable.placeholder),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(300.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { dispatchTakePictureIntent() }) {
                Text("Take Photo")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { dispatchPickImageIntent() }) {
                Text("Select Photo")
            }
        }

        LaunchedEffect(true) {
            // Initialize Rust library
            System.loadLibrary("simple_library")
        }

        fun processImage(bitmap: Bitmap) {
            imageBitmap.value = bitmap.asImageBitmap()
            // Call Rust function for image processing
            processImage(bitmap)
        }

        external fun add_two_ints

        fun checkCameraPermission(): Boolean {
            val permission = Manifest.permission.CAMERA
            return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
        }

        fun requestCameraPermission() {
            val permission = Manifest.permission.CAMERA
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), REQUEST_IMAGE_CAPTURE)
        }

        fun checkReadStoragePermission(): Boolean {
            val permission = Manifest.permission.READ_EXTERNAL_STORAGE
            return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
        }

        fun requestReadStoragePermission() {
            val permission = Manifest.permission.READ_EXTERNAL_STORAGE
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), REQUEST_IMAGE_PICK)
        }

        fun dispatchTakePictureIntent() {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }

        fun dispatchPickImageIntent() {
            val pickImageIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(pickImageIntent, REQUEST_IMAGE_PICK)
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (resultCode == RESULT_OK) {
                when (requestCode) {
                    REQUEST_IMAGE_CAPTURE -> {
                        val imageBitmap = data?.extras?.get("data") as Bitmap
                        processImage(imageBitmap)
                    }
                    REQUEST_IMAGE_PICK -> {
                        val imageUri: Uri? = data?.data
                        try {
                            val imageBitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
                            processImage(imageBitmap)
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                ImageProcessingApp()
            }
        }
    }
}*/
