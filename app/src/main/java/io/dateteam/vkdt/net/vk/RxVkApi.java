package io.dateteam.vkdt.net.vk;

import com.google.gson.Gson;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class RxVkApi {

    private static final String VK_PERMISSIONS = "verified, sex, bdate, city, country, " +
            "photo_max_orig, online, contacts, site, education, universities, schools, status, " +
            "last_seen, followers_count, common_count, occupation, relatives, personal, " +
            "connections, activities, interests, music, movies, tv, books, games, about, quotes, " +
            "timezone, career, military";


    public static Observable<VkProfile> userProfile() {
        return Observable.create(new Observable.OnSubscribe<VkProfile>() {
            @Override
            public void call(Subscriber<? super VkProfile> subscriber) {
                VKApi.users().get(VKParameters.from("fields", VK_PERMISSIONS)).executeSyncWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onError(VKError error) {
                        subscriber.onError(new Throwable(error.errorMessage));
                    }

                    @Override
                    public void onComplete(VKResponse response) {
                        final VkProfile profile = new Gson().fromJson(response.responseString, VkProfileResponse.class).getProfile();
                        subscriber.onNext(profile);
                        subscriber.onCompleted();
                    }
                });
            }
        });
    }

    public static Observable<VkProfile> friends(String userId) {
        return Observable.create(new Observable.OnSubscribe<VkProfile>() {
            @Override
            public void call(Subscriber<? super VkProfile subscriber) {
                VKApi.friends().get(VKParameters.from("userId", userId, "fields", VK_PERMISSIONS))
                        .executeSyncWithListener(new VKRequest.VKRequestListener() {
                            @Override
                            public void onError(VKError error) {
                                subscriber.onError(new Throwable(error.errorMessage));
                            }

                            @Override
                            public void onComplete(VKResponse response) {
                                List<VkProfile> friendList = new Gson().fromJson(response.responseString, VkFriendsResponse.class).response.friends;
                                for (VkProfile friend : friendList) {
                                    subscriber.onNext(friend);
                                }
                                subscriber.onCompleted();
                            }
                        });
            }
        })
    }

}
