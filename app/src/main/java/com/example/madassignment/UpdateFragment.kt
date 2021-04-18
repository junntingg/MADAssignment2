package com.example.madassignment

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.madassignment.data.User
import com.example.madassignment.data.UserViewModel
import kotlinx.android.synthetic.main.activity_register_new_staff.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {
   private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // return inflater.inflate(R.layout.fragment_update, container, false)

        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.upName.setText(args.currentUser.name)
        view.upAddress.setText(args.currentUser.address)
        view.upEmail.setText(args.currentUser.email)
        view.upPhoneNo.setText(args.currentUser.phoneNo)
        view.upIC.setText(args.currentUser.icNo)
        view.upPass.setText(args.currentUser.password)
        view.btn_Update.setOnClickListener {
            updateItem()
        }

        //Add menu
        setHasOptionsMenu(true)

        return view


    }

    private fun updateItem() {
        val name = upName.text.toString()
        val icNo = upIC.text.toString()
        val address = upEmail.text.toString()
        val email = upEmail.text.toString()
        val phoneNo = upPhoneNo.text.toString()
        val password = upPass.text.toString()

        if (inputCheck(name, icNo, address, email, phoneNo, password)) {

            val updateUser = User(args.currentUser.staffId, name, icNo, address, email, phoneNo, password)
            mUserViewModel.updateUser(updateUser)
            Toast.makeText(requireContext(), "Updated Successfully", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        } else {
            Toast.makeText(requireContext(), "Please fill up all the field", Toast.LENGTH_SHORT).show()

        }

    }

    private fun inputCheck(name: String, icNo: String, password: String, address: String, email: String, phoneNo: String): Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(icNo) && TextUtils.isEmpty(password) && TextUtils.isEmpty(address) && TextUtils.isEmpty(email) && TextUtils.isEmpty(phoneNo))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){
            deleteUser()

        }
            return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(), "Successfully removed: ${args.currentUser.name}", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
            builder.setNegativeButton("No") { _, _ -> }
            builder.setTitle("Delete ${args.currentUser.name}")
            builder.setMessage("Confirm to DELETE?  ${args.currentUser.name}")
            builder.create().show()
    }
}
