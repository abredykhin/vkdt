package io.dateteam.vkdt.net.vk;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VkProfileResponse {

    @SerializedName("response")
    public List<VkProfile> profiles;

    public VkProfile getProfile() {
        if(profiles != null && profiles.size() > 0) {
            return profiles.get(0);
        } else {
            return null;
        }
    }
}
