package com.bydmr.navigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_photos.*

class PhotosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonHome.setOnClickListener {
            val nextAction = PhotosFragmentDirections.nextAction()

            Navigation.findNavController(it).navigate(nextAction)
        }

        arguments?.let {
            val safeArgs = PhotosFragmentArgs.fromBundle(it)
            tvNum.text = "Number of Photos ${safeArgs.numOfPhotos}"
        }
    }


}
