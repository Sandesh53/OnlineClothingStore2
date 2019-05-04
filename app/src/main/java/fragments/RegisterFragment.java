package fragments;


import android.content.Context;
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

import com.example.onlineclothingstore.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {
    private EditText Username, Password, ConPassword;
    private Button btnRegister;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        Username = view.findViewById(R.id.Username);
        Password = view.findViewById(R.id.Password);
        ConPassword = view.findViewById(R.id.ConPassword);
        btnRegister = view.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (!validate()) {
            return;
        }
        Registration();

    }

    private void Registration() {
        String password1 = Password.getText().toString();
        String password2 = ConPassword.getText().toString();


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (password1.equals(password2)) {
            editor.putString("username", Username.getText().toString());
            editor.putString("password", Password.getText().toString());
            editor.commit();
            Toast.makeText(getActivity(), "Sucessfully Registered", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getActivity(), "Password doesn't match", Toast.LENGTH_SHORT).show();

        }
    }

    public Boolean validate() {
        boolean isValid = true;
        if (TextUtils.isEmpty(Username.getText().toString())) {
            Username.setError("Please Enter Your Username");
            Username.requestFocus();
            isValid = false;
        } else if (TextUtils.isEmpty(Password.getText().toString())) {
            Password.setError("Please Enter Password");
            Password.requestFocus();
            isValid = false;

        } else if (TextUtils.isEmpty(ConPassword.getText().toString())) {
            ConPassword.setError(" Renter Password ");
            ConPassword.requestFocus();
            isValid = false;
        }
        return isValid;
    }
}

