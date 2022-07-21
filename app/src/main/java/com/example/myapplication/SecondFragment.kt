package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentSecondBinding
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        val i11 = binding.i11
        val i12 = binding.i12
        val i13 = binding.i13
        val i14 = binding.i14
        val i15 = binding.i15
        val i21 = binding.i21
        val i22 = binding.i22
        val i23 = binding.i23
        val i24 = binding.i24
        val i25 = binding.i25
        val i31 = binding.i31
        val i32 = binding.i32
        val i33 = binding.i33
        val i34 = binding.i34
        val i35 = binding.i35
        val i41 = binding.i41
        val i42 = binding.i42
        val i43 = binding.i43
        val i44 = binding.i44
        val i45 = binding.i45
        val i51 = binding.i51
        val i52 = binding.i52
        val i53 = binding.i53
        val i54 = binding.i54
        val i55 = binding.i55
        val i61 = binding.i61
        val i62 = binding.i62
        val i63 = binding.i63
        val i64 = binding.i64
        val i65 = binding.i65

        val f1 = arrayOf(i11,i12,i13,i14,i15)
        val f2 = arrayOf(i21,i22,i23,i24,i25)
        val f3 = arrayOf(i31,i32,i33,i34,i35)
        val f4 = arrayOf(i41,i42,i43,i44,i45)
        val f5 = arrayOf(i51,i52,i53,i54,i55)
        val f6 = arrayOf(i61,i62,i63,i64,i65)

        val arr = arrayOf(f1,f2,f3,f4,f5,f6)

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return

        arr.forEachIndexed{i,fila ->
            fila.forEachIndexed{j,ob ->
                ob.setHint(sharedPref.getInt("$i$j", -1).toString())
                ob.setText(sharedPref.getInt("$i$j", -1).toString())
            }
        }


        binding.buttonSave.setOnClickListener { view ->

            arr.forEachIndexed{i,fila ->
                fila.forEachIndexed{j,ob ->
                    val sav = ob.text.toString().toInt()

                    with (sharedPref.edit()) {
                        putInt("$i$j", sav)
                        apply()
                    }
                }
            }

            Toast.makeText(activity, "Guardado!", Toast.LENGTH_SHORT).show()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}