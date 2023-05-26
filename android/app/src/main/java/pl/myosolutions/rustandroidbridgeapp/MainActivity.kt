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