package ir.dunijet.mashin_hesab_xiaumi021

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.Toast
import ir.dunijet.mashin_hesab_xiaumi021.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onNumberClicked()
        onOperatorClicked()

    }

    private fun onNumberClicked() {

        binding.btnnoghte.setOnClickListener {



            if (binding.txtvoroodi.text.isEmpty() || binding.txtjavab.text.isNotEmpty()) {

                appendText("0.")

            } else if (!binding.txtvoroodi.text.contains(".")) {

                appendText(".")

            }

        }

        binding.btn0.setOnClickListener {
            if (binding.txtvoroodi.text.isNotEmpty()) {
                appendText("0")
            }


        }

        binding.btnshomare1.setOnClickListener {
            appendText("1")
        }

        binding.btnshomare2.setOnClickListener {
            appendText("2")
        }

        binding.btnshomare3.setOnClickListener {
            appendText("3")
        }

        binding.btnshomare4.setOnClickListener {
            appendText("4")
        }

        binding.btnshomare5.setOnClickListener {
            appendText("5")
        }

        binding.btnshomare6.setOnClickListener {
            appendText("6")
        }

        binding.btnshomare7.setOnClickListener {
            appendText("7")
        }

        binding.btnshomare8.setOnClickListener {
            appendText("8")
        }

        binding.btnshomare9.setOnClickListener {
            appendText("9")
        }

    }


    private fun onOperatorClicked() {

        binding.btnmosavi.setOnClickListener {

            try {

                val ttt = ExpressionBuilder(binding.txtvoroodi.text.toString()).build()
                val result = ttt.evaluate()
                val longresuil = result.toLong()

                if (result == longresuil.toDouble()) {

                    binding.txtjavab.text = longresuil.toString()

                } else {
                    binding.txtjavab.text = result.toString()
                }


            } catch (w: Exception) {

                binding.txtvoroodi.text = ""
                binding.txtjavab.text = ""
                Toast.makeText(this, "ERROR...", Toast.LENGTH_LONG).show()

            }


        }

        binding.btnbeezafe.setOnClickListener {


            if (binding.txtvoroodi.text.isNotEmpty()) {
                val mychar = binding.txtvoroodi.text.last()
                if (mychar != '+'
                    && mychar != '-'
                    && mychar != '*'
                    && mychar != '/'){
                    appendText("+")
                }

            }

        }

        binding.btnmenha.setOnClickListener {

            if (binding.txtvoroodi.text.isNotEmpty()) {
                val mychar = binding.txtvoroodi.text.last()
                if (mychar != '+'
                    && mychar != '-'
                    && mychar != '*'
                    && mychar != '/'){
                    appendText("-")
                }

            }
        }

        binding.btnzarbdar.setOnClickListener {


            if (binding.txtvoroodi.text.isNotEmpty()) {
                val mychar = binding.txtvoroodi.text.last()
                if (mychar != '+'
                    && mychar != '-'
                    && mychar != '*'
                    && mychar != '/'){
                    appendText("*")
                }

            }


        }

        binding.btntaghsim.setOnClickListener {


            if (binding.txtvoroodi.text.isNotEmpty()) {
                val mychar = binding.txtvoroodi.text.last()
                if (mychar != '+'
                    && mychar != '-'
                    && mychar != '*'
                    && mychar != '/'){
                    appendText("/")
                }

            }


        }

        binding.btnparantezbaz.setOnClickListener {
            appendText("(")
        }

        binding.btnparantezbaste.setOnClickListener {
            appendText(")")
        }

        binding.btnAc.setOnClickListener {
            binding.txtjavab.text = ""
            binding.txtvoroodi.text = ""
        }

        binding.btndahan.setOnClickListener {

            val amir = binding.txtvoroodi.text.toString()

            if (amir.isNotEmpty()) {

                binding.txtvoroodi.text = amir.substring(0, amir.length - 1)

            }

        }

    }

    private fun appendText(newtext: String) {



        if (binding.txtjavab.text.isNotEmpty()) {
            binding.txtjavab.text = ""
            binding.txtvoroodi.text = ""

        }

        binding.txtvoroodi.append(newtext)


//        این قسمت پایین رو نمیخواد یاد بگیری
        val vto: ViewTreeObserver = binding.horizontalllll.viewTreeObserver
        vto.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.horizontalllll.viewTreeObserver.removeOnGlobalLayoutListener(this)
                binding.horizontalllll.scrollTo(binding.txtvoroodi.width, 0)
            }
        })


    }

}