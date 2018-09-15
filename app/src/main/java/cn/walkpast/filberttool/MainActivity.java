package cn.walkpast.filberttool;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.walkpast.filbert.RecursInputMethod;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mRootLayout;
    private TextView mHelloWorld;
    private EditText mEditText;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootLayout = findViewById(R.id.root_layout);
        new RecursInputMethod(this).setRootView(mRootLayout);
        mHelloWorld = findViewById(R.id.hello_world);
        mEditText = findViewById(R.id.edit_text);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MyAdapter(this));

//        mHelloWorld.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                InputMethodUtils.getInstance(MainActivity.this).showSoftInput(mEditText);
//            }
//        });
    }


    class MyAdapter extends RecyclerView.Adapter {

        private Context mContext;

        public MyAdapter(Context context) {
            mContext = context;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = View.inflate(mContext, R.layout.item_for_recycler_view, null);

            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }


        class MyHolder extends RecyclerView.ViewHolder {

            public MyHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
