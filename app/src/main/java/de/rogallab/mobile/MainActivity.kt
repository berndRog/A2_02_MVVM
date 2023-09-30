package de.rogallab.mobile

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import de.rogallab.mobile.databinding.ActivityMainBinding

class MainActivity : BaseActivity(TAG) {

   // local variables are deleted during a state change !!!
   // (e.g. rotating the device)
   // private var _name:String = ""
   // private var _email:String = ""

   // Data Binding
   private lateinit var _binding: ActivityMainBinding
   private val _viewModel: MainViewModel by viewModels()

   // Activity is first created
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      // Data Binding
      _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
      _binding.viewModel = _viewModel
      _binding.lifecycleOwner = this

      // button event handler
      _binding.mainBtSend.setOnClickListener {
         Log.i(TAG,"main_bt_send.OnClick()")
         logDebug(TAG, logMessage())
      }
   }

   private fun logMessage(): String =
      "Name: ${_viewModel.name} Email:${_viewModel.email} Clicked:${_viewModel.getIsChecked()}"

   private fun putStateToBundle(bundle: Bundle) {
      //                key    value
      bundle.putString (NAME,  _viewModel.name)
      bundle.putString (EMAIL, _viewModel.email)
      logDebug(TAG, "putStateToBundle()\n"+logMessage())
   }

   private fun getStateFromBundle(savedInstanceState: Bundle) {
      _viewModel.name = savedInstanceState.getString(NAME) ?: ""
      _viewModel.email = savedInstanceState.getString(EMAIL) ?: ""
      logDebug(TAG, "getStateFromBundle()\n"+logMessage())
   }


   // override save/restore state methods -------------------------------------
   // Save instance state: invoked when the activity may be temporarily destroyed,
//   override fun onSaveInstanceState(savedStateBundle: Bundle) {
//      super.onSaveInstanceState(savedStateBundle)
//      getStateFromUiElements()
//      putStateToBundle(savedStateBundle)
//   }
//
//   override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//      super.onRestoreInstanceState(savedInstanceState)
//      getStateFromBundle(savedInstanceState)
//      setUiElementsFromState()
//   }

   companion object {        //12345678901234567890123
      const val isDebug = true
      const val isInfo = true
      private const val TAG = "ok>MainActivity       ."
      private const val NAME  = "MainActivityName"
      private const val EMAIL = "MainActivityEmail"
   }
}