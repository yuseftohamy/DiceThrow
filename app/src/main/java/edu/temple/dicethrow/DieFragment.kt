package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

  private lateinit var dieTextView: TextView
  private var dieSides: Int = 6

  companion object {
    private const val DIESIDE = "sidenumber"

    fun newInstance(sides: Int): DieFragment {
      return DieFragment().apply {
        arguments = Bundle().apply {
          putInt(DIESIDE, sides)
        }
      }
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {
      dieSides = it.getInt(DIESIDE, 6) // Default to 6 if not provided
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.fragment_die, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    dieTextView = view.findViewById(R.id.dieTextView)

    throwDie()

    view.setOnClickListener {
      throwDie()
    }
  }

  fun throwDie() {
    dieTextView.text = Random.nextInt(1, dieSides + 1).toString()
  }
}
