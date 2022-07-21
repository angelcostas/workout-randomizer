package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding
import kotlinx.coroutines.*
import java.lang.Exception
import java.util.*
import kotlin.math.ceil
import kotlin.math.roundToInt

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

lateinit var mtts:TextToSpeech

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    fun View.repeatOnLifeCycle(
        repeats: Int = 1,
        durationInMillis: Long,
        dispatcher: CoroutineDispatcher = Dispatchers.Main,
        block: (Int) -> Unit
    ): Job? = findViewTreeLifecycleOwner()?.let { lifecycleOwner ->
        lifecycleOwner.lifecycle.coroutineScope.launch(dispatcher) {
            if (durationInMillis == 0L)
                throw Exception("Eres tonto, no se puede 0, subnormal!")

            for (i in 1..repeats) {
                delay(durationInMillis)
                block(i)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val que = binding.textviewFirst
        val num = binding.textView

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        val locale = Locale("es", "ES")

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return

        mtts = TextToSpeech(context, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR)
                mtts.setEngineByPackageName("com.google.android.tts")
                mtts.language = locale
        })

        var desc = 15



        binding.buttonForst.setOnClickListener { view ->

            viewLifecycleOwner.lifecycleScope.launch {

                var x = 0

                que.setText("Abdominales")
                mtts.speak("abdominales", TextToSpeech.QUEUE_FLUSH, null)
                delay(2000L)
                x = (sharedPref.getInt("02", -1)..sharedPref.getInt("03", -1)).random()
                for (i in sharedPref.getInt("00", -1)..(sharedPref.getInt("01", -1)+(-1..1).random())){
                    mtts.speak("set $i", TextToSpeech.QUEUE_FLUSH, null)
                    delay(2000L)
                    for (j in 1..x){
                        num.text = "$j/$x"
                        mtts.speak("$j", TextToSpeech.QUEUE_FLUSH, null)
                        delay(sharedPref.getInt("04", -1).toLong())
                    }
                    mtts.speak("descanso", TextToSpeech.QUEUE_FLUSH, null)
                    delay(2000L)
                    for (j in 1..desc){
                        num.text = "$j/$desc"
                        mtts.speak("$j", TextToSpeech.QUEUE_FLUSH, null)
                        delay(1000L)
                    }
                }

                que.text = "Flexiones"
                mtts.speak("flexiones", TextToSpeech.QUEUE_FLUSH, null)
                delay(2000L)
                x = (sharedPref.getInt("12", -1)..sharedPref.getInt("13", -1)).random()
                for (i in sharedPref.getInt("10", -1)..(sharedPref.getInt("11", -1)+(-1..1).random())){
                    mtts.speak("set $i", TextToSpeech.QUEUE_FLUSH, null)
                    delay(2000L)
                    for (j in 1..x){
                        num.text = "$j/$x"
                        mtts.speak("$j", TextToSpeech.QUEUE_FLUSH, null)
                        delay(sharedPref.getInt("14", -1).toLong())
                    }
                    mtts.speak("descanso", TextToSpeech.QUEUE_FLUSH, null)
                    delay(2000L)
                    for (j in 1..desc){
                        num.text = "$j/$desc"
                        mtts.speak("$j", TextToSpeech.QUEUE_FLUSH, null)
                        delay(1000L)
                    }
                }

                que.text = "Sentadillas"
                mtts.speak("sentadillas", TextToSpeech.QUEUE_FLUSH, null)
                delay(2000L)
                x = (sharedPref.getInt("22", -1)..sharedPref.getInt("23", -1)).random()
                for (i in sharedPref.getInt("20", -1)..(sharedPref.getInt("21", -1)+(-1..1).random())){
                    mtts.speak("set $i", TextToSpeech.QUEUE_FLUSH, null)
                    delay(2000L)
                    for (j in 1..x){
                        num.text = "$j/$x"
                        mtts.speak("$j", TextToSpeech.QUEUE_FLUSH, null)
                        delay(sharedPref.getInt("24", -1).toLong())
                    }
                    mtts.speak("descanso", TextToSpeech.QUEUE_FLUSH, null)
                    delay(2000L)
                    for (j in 1..desc){
                        num.text = "$j/$desc"
                        mtts.speak("$j", TextToSpeech.QUEUE_FLUSH, null)
                        delay(1000L)
                    }
                }

                que.text = "Dominadas"
                mtts.speak("dominadas", TextToSpeech.QUEUE_FLUSH, null)
                delay(2000L)
                x = (sharedPref.getInt("32", -1)..sharedPref.getInt("33", -1)).random()
                for (i in sharedPref.getInt("30", -1)..(sharedPref.getInt("31", -1)+(-1..1).random())){
                    mtts.speak("set $i", TextToSpeech.QUEUE_FLUSH, null)
                    delay(2000L)
                    for (j in 1..x){
                        num.text = "$j/$x"
                        mtts.speak("$j", TextToSpeech.QUEUE_FLUSH, null)
                        delay(sharedPref.getInt("34", -1).toLong())
                    }
                    mtts.speak("descanso", TextToSpeech.QUEUE_FLUSH, null)
                    delay(2000L)
                    for (j in 1..desc){
                        num.text = "$j/$desc"
                        mtts.speak("$j", TextToSpeech.QUEUE_FLUSH, null)
                        delay(1000L)
                    }
                }

                que.text = "Abdominales"
                mtts.speak("abdominales", TextToSpeech.QUEUE_FLUSH, null)
                delay(2000L)
                x = (sharedPref.getInt("42", -1)..sharedPref.getInt("43", -1)).random()
                for (i in sharedPref.getInt("40", -1)..(sharedPref.getInt("41", -1)+(-1..1).random())){
                    mtts.speak("set $i", TextToSpeech.QUEUE_FLUSH, null)
                    delay(2000L)
                    for (j in 1..x){
                        num.text = "$j/$x"
                        mtts.speak("$j", TextToSpeech.QUEUE_FLUSH, null)
                        delay(sharedPref.getInt("44", -1).toLong())
                    }
                    mtts.speak("descanso", TextToSpeech.QUEUE_FLUSH, null)
                    delay(2000L)
                    for (j in 1..desc){
                        num.text = "$j/$desc"
                        mtts.speak("$j", TextToSpeech.QUEUE_FLUSH, null)
                        delay(1000L)
                    }
                }

                que.text = "Biceps"
                mtts.speak("biceps", TextToSpeech.QUEUE_FLUSH, null)
                delay(2000L)
                x = (sharedPref.getInt("52", -1)..sharedPref.getInt("53", -1)).random()
                for (i in sharedPref.getInt("50", -1)..(sharedPref.getInt("51", -1)+(-1..1).random())){
                    mtts.speak("set $i", TextToSpeech.QUEUE_FLUSH, null)
                    delay(2000L)
                    for (j in 1..x){
                        num.text = "$j/$x"
                        mtts.speak("$j", TextToSpeech.QUEUE_FLUSH, null)
                        delay(sharedPref.getInt("54", -1).toLong())
                    }
                    mtts.speak("cambio", TextToSpeech.QUEUE_FLUSH, null)
                    delay(5000L)
                    for (j in 1..x){
                        num.text = "$j/$x"
                        mtts.speak("$j", TextToSpeech.QUEUE_FLUSH, null)
                        delay(sharedPref.getInt("54", -1).toLong())
                    }
                    mtts.speak("Has acabado! Enhorabuena!", TextToSpeech.QUEUE_FLUSH, null)

                }

            }



        }
    }

    override fun onDestroyView() {
        if (mtts != null) {
            mtts!!.stop()
            mtts!!.shutdown()
        }
        super.onDestroyView()
        _binding = null
    }
}

