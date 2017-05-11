package cn.jaybai.jaytest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button mCodeButton;
    private String TAG = "aaaaaaaaaaa";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        mCodeButton = (Button) findViewById(R.id.code_button);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Test Code Start

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@io.reactivex.annotations.NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("Hello Jaybai 1");
                e.onNext("Hello Jaybai 2");
                e.onNext("Hello Jaybai 3");
                e.onNext("Hello Jaybai 4");
//                e.onError(new Exception("oh no!"));
                Log.e(TAG, "发送在什么线程 : " + Thread.currentThread().getName());
                e.onComplete();
            }
        }).subscribeOn(Schedulers.newThread())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(new Observer<String>() {
              @Override
              public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
                  Log.e(TAG, "onSubscribe: ");
                  Log.e(TAG,"接收在什么线程 : " + Thread.currentThread().getName());
              }

              @Override
              public void onNext(@io.reactivex.annotations.NonNull String s) {
                  Log.e(TAG, "onNext : " + s);
              }

              @Override
              public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                  Log.e(TAG, "onError : ", e);
              }

              @Override
              public void onComplete() {
                  Log.e(TAG, "onComplete : ");
              }
          });

        //Test Code End


        int[] array=new int[]{2,2,1,1};
        CountStep countStep = new CountStep();
        countStep.permute(array,0);
        System.out.println("end");

    }

}
