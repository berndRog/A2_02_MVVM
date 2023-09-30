package de.rogallab.mobile

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

   // MainScreen State
   private var _name: String = ""
   private var _email: String = ""
   private var _isChecked: Boolean = false

   //

   // Data Binding with properties
   // <TextView id="@+id/main_tv_caption"
   //   text='@{viewModel.caption}' <-- One-Way Binding
   var caption: String = "Model-View-ViewModel"
      private set

   // <EditText id="@+id/main_et_name"
   //   text='@={viewModel.name}' <-- Two-Way Binding
   var name: String
      get() = _name
      set(value) {
         // Avoids infinite loops.
         if (_name != value) {
            logDebug(TAG, value)
            _name = value
         }
      }

   // <EditText id="@+id/main_et_email"
   //   text='@={viewModel.email}' <-- Two-Way Binding
   var email: String
      get() = _email
      set(value) {
         if (_email != value) {
            logDebug(TAG, value)
            _email = value
         }
      }

   // Data Binding with get-/set-functions
   // <CheckBox  id="@+id/main_checkBox"
   //    checked='@={viewModel.isChecked}' <-- Two-Way Binding
   fun getIsChecked(): Boolean {      // getter isChecked
      return _isChecked
   }
   fun setIsChecked(value: Boolean) { // setter isChecked
      // Avoids infinite loops.
      if (_isChecked != value) {
         logDebug(TAG, value.toString())
         _isChecked = value
      }
   }

   companion object {        //12345678901234567890123
      private const val TAG = "ok>MainViewModel      ."
   }
}