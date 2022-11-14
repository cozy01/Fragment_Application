package com.example.fragmentapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import com.example.fragmentapplication.databinding.ActivityMainBinding
import com.example.fragmentapplication.databinding.FragmentInputBinding
import com.example.fragmentapplication.databinding.FragmentResultBinding


/**
 * A simple [Fragment] subclass.
 * Use the [InputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var binding: FragmentInputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(inflater, container, false)

        fun setResult(index: Int, number: Int) {
            val result = Bundle().apply {
                putInt("Value${index}", number)
            }
            setFragmentResult("value", result)
        }

        binding.edtInput1.setOnKeyListener{view, i, keyEvent ->
            setResult(1, binding.edtInput1.text.toString().toIntOrNull() ?: 0)
            false
        }
        binding.edtInput2.setOnKeyListener{view, i, keyEvent ->
            setResult(2, binding.edtInput2.text.toString().toIntOrNull() ?: 0)
            false
        }
        binding.edtInput3.setOnKeyListener{view, i, keyEvent ->
            setResult(3, binding.edtInput3.text.toString().toIntOrNull() ?: 0)
            false
        }

        return binding.root

    }

    companion object {
        @JvmStatic
        fun newInstance(value: Int) =
            InputFragment()
    }
}