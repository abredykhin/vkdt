package io.dateteam.vkdt.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.dateteam.vkdt.R;
import io.dateteam.vkdt.net.vk.RxVkApi;
import io.dateteam.vkdt.net.vk.VkFriendsResponse;
import io.dateteam.vkdt.net.vk.VkProfile;
import io.dateteam.vkdt.net.vk.VkProfileResponse;
import io.dateteam.vkdt.util.RxFirebase;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static io.dateteam.vkdt.net.vk.RxVkApi.userProfile;

public class LoginActivity extends AppCompatActivity {
    private static final String LOG_TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.login_button).setOnClickListener(v -> VKSdk.login(LoginActivity.this, "friends", "photos"));
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                checkUserExists();
            }

            @Override
            public void onError(VKError error) {
                Log.e(LOG_TAG, error.errorMessage);
            }
        });
    }

    private void checkUserExists() {
        String userId = VKAccessToken.currentToken().userId;
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users/vk");
        RxFirebase.with(reference).onSingleValueEvent(userId)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(dataSnapshot -> {
                    if (dataSnapshot.exists()) {
                        return Observable.just(dataSnapshot.getValue(VkProfile.class));
                    } else {
                        Map<String, Boolean> friendsMap = new HashMap<>();


                        RxVkApi.userProfile().flatMap(profile -> {
                            RxFirebase.with(reference.child(profile.getId())).setValue(profile);
                            return RxVkApi.friends(profile.getId());
                        }).subscribe(friendProfile -> {
                                    friendsMap.put(friendProfile.getId(), true);
                                    reference.child(friendProfile.getId()).setValue(friendProfile);
                                },
                                err -> Log.e(LOG_TAG, err.getMessage()),
                                Observable.just(profile).
                    });

                });
    }

    )
//                        MainActivity.start(LoginActivity.this);
//                        finish();
//                    } else {
//                        grabUserInfo();
//                    }
//                })
//                .subscribe(dataSnapshot -> {
//                }, error -> {
//                    Log.e(LOG_TAG, error.getMessage());
//                })
}

    private void grabUserInfo() {

//        req.executeWithListener(new VKRequest.VKRequestListener() {
//            @Override
//            public void onComplete(VKResponse response) {
//                try {
//                    final VkProfile profile = new Gson().fromJson(response.responseString, VkProfileResponse.class).getProfile();
//                    FirebaseDatabase.getInstance().getReference("users/vk/" + profile.getId()).setValue(profile, (databaseError, databaseReference) -> {
//                        if (databaseError != null) {
//                            Log.e(LOG_TAG, databaseError.getMessage());
//                        } else {
//                            Log.i(LOG_TAG, "User added to database!");
//                            grabFriends(profile.getId());
//                        }
//                    });
//                } catch (Throwable t) {
//                    Log.e(LOG_TAG, t.getMessage());
//                }
//            }
//
//            @Override
//            public void onError(VKError error) {
//                Log.e(LOG_TAG, error.errorMessage);
//            }
//        });
    }
    public static void start(Context c) {
        Intent intent = new Intent(c, LoginActivity.class);
        c.startActivity(intent);
    }
}
