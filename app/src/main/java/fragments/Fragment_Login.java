package fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineclothingstore.DashboardActivity;
import com.example.onlineclothingstore.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Login extends Fragment implements View.OnClickListener {
    private EditText etUsername, etPassword;
    private Button btnlogin;

    public Fragment_Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        btnlogin = view.findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (!validate()) {
            return;
        }
        check();

    }

    private void check() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");

        String uName = etUsername.getText().toString();
        String passW = etPassword.getText().toString();
        if (username.equals(uName) && password.equals(passW)) {
            //Toast.makeText(getActivity(), "Welcome", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity().getApplicationContext(), DashboardActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(getActivity(), "Username or Password doesn't match", Toast.LENGTH_SHORT).show();

        }
    }

    public Boolean validate() {
        boolean isValid = true;
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError(" Enter Username");
            etUsername.requestFocus();
            isValid = false;
        } else if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError("Please Enter Password");
            etPassword.requestFocus();
            isValid = false;

        }
        return isValid;
    }
}





