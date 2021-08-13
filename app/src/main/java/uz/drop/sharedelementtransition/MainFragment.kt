package uz.drop.sharedelementtransition

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import uz.drop.sharedelementtransition.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!

    private val imageAdapter = ImageAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentMainBinding.bind(view)
        postponeEnterTransition()
        view.doOnPreDraw {
            startPostponedEnterTransition()
        }
        binding.rv.adapter = imageAdapter
        imageAdapter.submitList(list)
        imageAdapter.setOnClickListener { item, view ->
            val extras = FragmentNavigatorExtras(view to getString(R.string.image_detail))
            findNavController().navigate(R.id.detailFragment, bundleOf("image" to item.image), null, extras)
        }

    }

    private val list = listOf(
        Image(R.drawable.nature1),
        Image(R.drawable.nature2),
        Image(R.drawable.nature3),
        Image(R.drawable.nature4),
    )
}