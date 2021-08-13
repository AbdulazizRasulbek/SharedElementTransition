package uz.drop.sharedelementtransition

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.google.android.material.transition.MaterialContainerTransform
import uz.drop.sharedelementtransition.databinding.FragmentDetailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val materialContainerTransform = MaterialContainerTransform().apply {
            duration = 300L
            isDrawDebugEnabled = true
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(Color.WHITE)

        }
        val moveTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = materialContainerTransform
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentDetailBinding.bind(view)
        val imageRes = requireArguments().getInt("image")
        binding.image.setImageResource(imageRes)
    }

}