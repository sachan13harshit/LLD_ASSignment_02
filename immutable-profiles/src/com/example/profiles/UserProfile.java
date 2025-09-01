package com.example.profiles;

/**
 * Mutable and confusing. Multiple constructors + setters.
 */
public class UserProfile {
    private final String id;
    private final String email;
    private final String phone;
    private final String displayName;
    private final String address;
    private final boolean marketingOptIn;
    private final String twitter;
    private final String github;

    private UserProfile(Builder helper) {
        this.id = helper.id;
        this.email = helper.email;
        this.phone = helper.phone;
        this.displayName = helper.displayName;
        this.address = helper.address;
        this.marketingOptIn = helper.marketingOptIn;
        this.twitter = helper.twitter;
        this.github = helper.github;
    }

    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDisplayName() { return displayName; }
    public String getAddress() { return address; }
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public String getTwitter() { return twitter; }
    public String getGithub() { return github; }

    static class Builder {
        private String id;
        private String email;
        private String phone;
        private String displayName;
        private String address;
        private boolean marketingOptIn;
        private String twitter;
        private String github;

        public Builder(String id , String email){
            this.id = id;
            this.email = email;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }
        public Builder setEmail(String email) { 
            this.email = email; 
            return this;
        }
        public Builder setPhone(String phone) { 
            this.phone = phone;
            return this;
        }
        public Builder setDisplayName(String displayName) { 
            this.displayName = displayName; 
            return this;
        }
        public Builder setAddress(String address) { 
            this.address = address;
            return this;
        }
        public Builder setMarketingOptIn(boolean marketingOptIn) { 
            this.marketingOptIn = marketingOptIn;
            return this;
        }
        public Builder setTwitter(String twitter) { 
            this.twitter = twitter;
            return this;
        }
        public Builder setGithub(String github) {
            this.github = github;
            return this;
        }

        public String getId() { return id; }
        public String getEmail() { return email; }
        public String getPhone() { return phone; }
        public String getDisplayName() { return displayName; }
        public String getAddress() { return address; }
        public boolean isMarketingOptIn() { return marketingOptIn; }
        public String getTwitter() { return twitter; }
        public String getGithub() { return github; }
    }
}