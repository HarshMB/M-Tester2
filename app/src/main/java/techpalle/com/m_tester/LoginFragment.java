package techpalle.com.m_tester;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    EditText et1,et2;
    Button b1;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_login, container, false);

        et1 = (EditText) v.findViewById(R.id.editText1);
        et2 = (EditText) v.findViewById(R.id.editText2);
        b1 = (Button) v.findViewById(R.id.button1);

        //((MainActivity)getActivity()).getSupportActionBar().setTitle("Palle Technologies");//to set ActionBar Title
        //((MainActivity)getActivity()).getSupportActionBar().setSubtitle("");//to set ActionBar SubTitle

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = et1.getText().toString();
                String pass = et2.getText().toString();

                if(uname.equals("") && pass.equals(""))
                {
                    Toast.makeText(getActivity(), "Enter Username and Password", Toast.LENGTH_SHORT).show();
                }
                else if(uname.equals(""))
                {
                    Toast.makeText(getActivity(), "Enter Username", Toast.LENGTH_SHORT).show();
                }
                else if(pass.equals(""))
                {
                    Toast.makeText(getActivity(), "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(uname.equals("techpalle") && pass.equals("palle"))
                    {
                        Toast.makeText(getActivity(), "Successfully Login", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(getActivity(),SecondActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        return v;

    }

}
