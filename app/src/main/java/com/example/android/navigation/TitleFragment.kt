package com.example.android.navigation.debug

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import com.example.android.navigation.databinding.FragmentTitleBinding
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.R

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title,container,false)

        //Can use any of the following code snippets

        /*binding.playButton.setOnClickListener { view: View->
            Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)*/

        //Kotlin extension functions used
        binding.playButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        )

        setHasOptionsMenu(true)

        return binding.root
        }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu , menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return NavigationUI.onNavDestinationSelected(item!! , view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}


