package com.example.profiles;

import java.util.Objects;

/**
 * Assembles profiles with scattered, inconsistent validation.
 */
public class ProfileService {

    public UserProfile createMinimal(String id, String email) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("bad id");
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("bad email");

        return new UserProfile.Builder(id, email).build();
    }

    public UserProfile updateDisplayName(UserProfile p, String displayName) {
        Objects.requireNonNull(p, "profile");
        if (displayName != null && displayName.length() > 100) {
            // silently trim (inconsistent policy)
            displayName = displayName.substring(0, 100);
        }
       return new UserProfile.Builder(p.getId(), p.getEmail())
                .setPhone(p.getPhone())
                .setAddress(p.getAddress())
                .setMarketingOptIn(p.isMarketingOptIn())
                .setTwitter(p.getTwitter())
                .setGithub(p.getGithub())
                .setDisplayName(displayName)
                .build();
    }
}
