package com.first.hw_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val inputText: EditText = view.findViewById(R.id.input_text)
        val submitButton: Button = view.findViewById(R.id.submit_button)

        submitButton.setOnClickListener {
            val text = inputText.text.toString()
            if (text.isEmpty()) {
                Snackbar.make(view, "Для отправки текста требуется заполнить поле", Snackbar.LENGTH_LONG).show()
            } else {
                val bundle = Bundle().apply {
                    putString("inputText", text)
                }
                findNavController().navigate(R.id.action_nav_home_to_nav_details, bundle)
            }
        }

        return view
    }
}
