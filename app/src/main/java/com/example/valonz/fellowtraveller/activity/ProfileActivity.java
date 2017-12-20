package com.example.valonz.fellowtraveller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

import com.example.valonz.fellowtraveller.R;
import com.example.valonz.fellowtraveller.modules.SQLiteHandler;
import com.example.valonz.fellowtraveller.modules.SessionManager;

public class ProfileActivity extends Activity {

	private TextView txtName;
	private TextView txtEmail;
	private TextView txtPhone;
	private Button btnLogout;

	private SQLiteHandler db;
	private SessionManager session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);

		txtName = (TextView) findViewById(R.id.name);
		txtEmail = (TextView) findViewById(R.id.email);
		txtPhone = (TextView) findViewById(R.id.phone);
		btnLogout = (Button) findViewById(R.id.btnLogout);

		final Button btnGoogleMap = (Button) findViewById(R.id.btnGoogleMap);

		btnGoogleMap.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(ProfileActivity.this, MapsActivity.class);
				ProfileActivity.this.startActivity(i);
			}
		});

		// SqLite database handler
		db = new SQLiteHandler(getApplicationContext());

		// session manager
		session = new SessionManager(getApplicationContext());

		if (!session.isLoggedIn()) {
			logoutUser();
		}

		// Fetching user details from SQLite
		HashMap<String, String> user = db.getUserDetails();

		String name = user.get("name");
		String email = user.get("email");
		String phone = user.get("phone");

		// Displaying the user details on the screen
		txtName.setText(name);
		txtEmail.setText(email);
		txtPhone.setText(phone);

		// Logout button click event
		btnLogout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				logoutUser();
			}
		});
	}

	/**
	 * Logging out the user. Will set isLoggedIn flag to false in shared
	 * preferences Clears the user data from sqlite users table
	 * */
	private void logoutUser() {
		session.setLogin(false);

		db.deleteUsers();

		// Launching the login activity
		Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
		startActivity(intent);
		finish();
	}
}
