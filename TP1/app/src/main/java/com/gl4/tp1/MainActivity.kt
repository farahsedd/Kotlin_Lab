package com.gl4.tp1

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.gl4.tp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var txtEmail : EditText
    lateinit var txtPwd : EditText
    lateinit var btnLogin : Button



    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


        txtEmail = findViewById(R.id.editTextEmail)
        var email = txtEmail.text.toString()

        txtPwd = findViewById(R.id.editTextPwd)
        var pwd = txtPwd.text.toString()

        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener { view ->
            var email = txtEmail.text.toString()
            var pwd = txtPwd.text.toString()
            if (email == "Gl4@insat.tn" && pwd == "2022") {
                Toast.makeText(this, "Connexion avec succès", Toast.LENGTH_SHORT).show()
                val intent = Intent(view.context,WelcomeActivity::class.java)
                intent.putExtra("email",email)
                startActivity(intent)

            } else {
                // Invalid login, show an error message
                Toast.makeText(this, "Email:$email ou mot de passe: $pwd sont incorrectes", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}