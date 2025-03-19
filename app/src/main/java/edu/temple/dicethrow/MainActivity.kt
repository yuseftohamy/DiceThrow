package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
  private lateinit var dieFragment: DieFragment

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    dieFragment = DieFragment.newInstance(6)

    supportFragmentManager.beginTransaction()
      .replace(R.id.fragmentContainerView, dieFragment)
      .commit()

    findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
      dieFragment.throwDie()
    }
  }
}
