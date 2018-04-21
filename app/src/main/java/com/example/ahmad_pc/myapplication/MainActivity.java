package com.example.ahmad_pc.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button mSend;
    RecyclerView mList;
    EditText mInput;
    private MsgAdapter mAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new MsgAdapter(new ArrayList<Msg>());
        setContentView(R.layout.activity_main);
        mList = findViewById(R.id.RVMsg);
        mList.setAdapter(mAdapter);
        mList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mInput = findViewById(R.id.editText);

        mSend = findViewById(R.id.sendButton);
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Msg msg = new Msg("Your Name", mInput.getText().toString(), System.currentTimeMillis());
                mAdapter.addMessage(msg);
                mInput.setText("");
            }
        });


    }


}
