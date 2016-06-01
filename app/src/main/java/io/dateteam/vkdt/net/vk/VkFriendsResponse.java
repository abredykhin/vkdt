package io.dateteam.vkdt.net.vk;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VkFriendsResponse {

    @SerializedName("response")
    public Response response;

    public static class Response {
        @SerializedName("items")
        public List<VkProfile> friends;
    }
}
