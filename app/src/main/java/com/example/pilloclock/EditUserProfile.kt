package com.example.pilloclock

import android.app.Dialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.pilloclock.data.AppDatabase
import com.example.pilloclock.data.entity.User
import com.example.pilloclock.data.repo.UserRepository
import com.example.pilloclock.databinding.ActivityEditUserProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_edit_user_profile.*
import com.google.firebase.storage.StorageReference
import java.util.*

class EditUserProfile : AppCompatActivity() {
    private lateinit var binding: ActivityEditUserProfileBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var refUsers: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var dialog: Dialog
    private lateinit var user: User
    private lateinit var uid : String

    /*var firstName: EditText? = null
    var lastName: EditText? = null
    var maleCheckbox: CheckBox? = null
    var femaleCheckbox: CheckBox? = null
    var otherCheckbox: CheckBox? = null
    var dateOfBirth: Date? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()
        uid = mAuth.currentUser?.uid.toString()
        refUsers = FirebaseDatabase.getInstance().getReference("Users/")

        if(uid.isNotEmpty()){
            getUserData()
        }
        /*
        displayUserInfo(userRepository.getUser(email))
        val formatter: DateFormat = SimpleDateFormat("dd/MM/yyyy")
        firstName = findViewById(R.id.fname_inputField)
        lastName = findViewById(R.id.lname_inputField)
        maleCheckbox = findViewById(R.id.male_checkbox)
        femaleCheckbox = findViewById(R.id.female_checkbox)
        otherCheckbox = findViewById(R.id.other_checkbox)

       */
        val saveButton = findViewById<Button>(R.id.save_button)
        saveButton.setOnClickListener {
            //val fname: String = firstName.text.toString()
        }

        val cancelButton = findViewById<Button>(R.id.cancel_button)
        cancelButton.setOnClickListener {
            onBackPressed()
        }
    }

    private fun getUserData() {
        refUsers.child(uid).addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                user = snapshot.getValue(User::class.java)!!
                binding.fnameInputField.setText(user.firstName)
                binding.lnameInputField.setText(user.lastName)
                //binding.ageInputField.setText(user.age)
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}



