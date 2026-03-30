package za.ac.iie.sparkapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


            // declaring variables
            val etTime = findViewById<EditText>(R.id.etText)
            val tvMessage = findViewById<TextView>(R.id.tvMessage)
            val btnReset = findViewById<Button>(R.id.btnReset)
            val btnEnter = findViewById<Button>(R.id.btnEnter)


            // set on click listener for the enter button
            btnEnter.setOnClickListener {

                val time = etTime.text.toString()

                //check if the user input is empty
                if(etTime.text.isEmpty()){


                    etTime.error = "Oops! Invalid time of the day"
                }


                // Check the entered time and display a corresponding message

                if (time == "morning" || time == "Morning") {

                    tvMessage.text = "Send a 'Good morning' text to a family member!"

                } else if (time == "mid-morning" || time == "Mid-morning") {

                    tvMessage.text = "Reach out to a collegue with a quick 'thank you'"

                } else if (time == "afternoon" || time == "Afternoon" ) {

                    tvMessage.text = "Share a funny meme or an interesting link with a friend"

                } else if (time == "afternoon snack-time" || time == "Afternoon snack-time" ) {

                    tvMessage.text = "send a quick 'thinking of you' message"

                }else if (time == "dinner" || time == "Dinner") {

                    tvMessage.text = "Call a friend or a relative for a 5 minute catch up"

                } else if (time == "after dinner" || time == "After dinner" ) {

                    tvMessage.text = "Leave a thoughful comment on a friend's post"
                }else{

                    tvMessage.text = "Invalid input! try 'Morning, afternoon, Dinner, etc.."
                    etTime.error = "Oops! Invalid time of the day"


                }
            }

        //set on click listener for reset button
            btnReset.setOnClickListener {

                etTime.text.clear()
                tvMessage.text = null
            }
    }
}