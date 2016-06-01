package io.dateteam.vkdt.net.vk;

import com.vk.sdk.api.model.VKApiUserFull;
import com.vk.sdk.api.model.VKList;

import java.util.List;

public class VkProfile {

    public String id;
    /**
     * First name of user.
     */
    public String first_name = "DELETED";

    /**
     * Last name of user.
     */
    public String last_name = "DELETED";

    /**
     * Information whether the user is online.
     */
    public int online;

    /**
     * If user utilizes a mobile application or site mobile version, it returns online_mobile as additional.
     */
    public int online_mobile;

    public String photo_max_orig = "http://vk.com/images/camera_a.gif";

    /**
     * Text of user status.
     */
    public String activity;

    /**
     * User's date of birth.  Returned as DD.MM.YYYY or DD.MM (if birth year is hidden).
     */
    public String bdate;

    /**
     * City specified on user's page in "Contacts" section.
     */
    public City city;

    /**
     * Country specified on user's page in "Contacts" section.
     */
    public Country country;

    /**
     * Last visit date(in Unix time).
     */
    public LastSeen last_seen;

    /**
     * List of user's universities
     */
    public List<University> universities;

    /**
     * List of user's schools
     */
    public List<School> schools;

    /**
     * Views on smoking.
     *
     * @see VKApiUserFull.Attitude
     */
    public int smoking;

    /**
     * Views on alcohol.
     *
     * @see VKApiUserFull.Attitude
     */
    public int alcohol;

    /**
     * Views on policy.
     *
     * @see VKApiUserFull.Political
     */
    public int political;

    /**
     * Life main stuffs.
     *
     * @see VKApiUserFull.LifeMain
     */
    public int life_main;

    /**
     * People main stuffs.
     *
     * @see VKApiUserFull.PeopleMain
     */
    public int people_main;

    /**
     * Stuffs that inspire the user.
     */
    public String inspired_by;

    /**
     * List of user's languages
     */
    public String[] langs;

    /**
     * Religion of user
     */
    public String religion;

    /**
     * Name of user's account in Facebook
     */
    public String facebook;

    /**
     * ID of user's facebook
     */
    public String facebook_name;

    /**
     * Name of user's account in LiveJournal
     */
    public String livejournal;

    /**
     * Name of user's account in Skype
     */
    public String skype;

    /**
     * URL of user's site
     */
    public String site;

    /**
     * Name of user's account in Twitter
     */
    public String twitter;

    /**
     * Name of user's account in Instagram
     */
    public String instagram;

    /**
     * User's mobile phone number
     */
    public String mobile_phone;

    /**
     * User's home phone number
     */
    public String home_phone;

    /**
     * Page screen name.
     */
    public String screen_name;

    /**
     * Nickname of user.
     */
    public String nickname;

    /**
     * User's activities
     */
    public String activities;

    /**
     * User's interests
     */
    public String interests;

    /**
     * User's favorite movies
     */
    public String movies;

    /**
     * User's favorite TV Shows
     */
    public String tv;

    /**
     * User's favorite books
     */
    public String books;

    /**
     * User's favorite games
     */
    public String games;

    /**
     * User's about information
     */
    public String about;

    /**
     * User's favorite quotes
     */
    public String quotes;

    /**
     * Information whether others can posts on user's wall.
     */
    public int can_post;

    /**
     * Information whether others' posts on user's wall can be viewed
     */
    public int can_see_all_posts;

    /**
     * Information whether private messages can be sent to this user.
     */
    public int can_write_private_message;

    /**
     * Information whether user can comment wall posts.
     */
    public int wall_comments;

    /**
     * Information whether the user is banned in VK.
     */
    public int is_banned;

    /**
     * Information whether the user is deleted in VK.
     */
    public int is_deleted;

    /**
     * Information whether the user's post of wall shows by default.
     */
    public int wall_default_owner;

    /**
     * Information whether the user has a verified page in VK
     */
    public int verified;

    /**
     * User sex.
     *
     * @see VKApiUserFull.Sex
     */
    public int sex;

    /**
     * Set of user's counters.
     */
    public VKApiUserFull.Counters counters;

    /**
     * Set of user's counters.
     */
    public VKApiUserFull.Occupation occupation;

    /**
     * Relationship status.
     *
     * @see VKApiUserFull.Relation
     */
    public int relation;

    /**
     * List of user's relatives
     */
    public VKList<VKApiUserFull.Relative> relatives;

    /**
     * Information whether the current user has add this user to the blacklist.
     */
    public int blacklisted_by_me;

    public VkProfile() {

    }

    public String getAbout() {
        return about;
    }

    public String getActivities() {
        return activities;
    }

    public String getActivity() {
        return activity;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public String getBdate() {
        return bdate;
    }

    public int isBlacklisted_by_me() {
        return blacklisted_by_me;
    }

    public String getBooks() {
        return books;
    }

    public int isCan_post() {
        return can_post;
    }

    public int isCan_see_all_posts() {
        return can_see_all_posts;
    }

    public int isCan_write_private_message() {
        return can_write_private_message;
    }

    public City getCity() {
        return city;
    }

    public VKApiUserFull.Counters getCounters() {
        return counters;
    }

    public Country getCountry() {
        return country;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getFacebook_name() {
        return facebook_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getGames() {
        return games;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public String getInspired_by() {
        return inspired_by;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getInterests() {
        return interests;
    }

    public int is_banned() {
        return is_banned;
    }

    public int is_deleted() {
        return is_deleted;
    }

    public String[] getLangs() {
        return langs;
    }

    public String getLast_name() {
        return last_name;
    }

    public LastSeen getLast_seen() {
        return last_seen;
    }

    public int getLife_main() {
        return life_main;
    }

    public String getLivejournal() {
        return livejournal;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public String getMovies() {
        return movies;
    }

    public String getNickname() {
        return nickname;
    }

    public VKApiUserFull.Occupation getOccupation() {
        return occupation;
    }

    public int isOnline() {
        return online;
    }

    public int isOnline_mobile() {
        return online_mobile;
    }

    public int getPeople_main() {
        return people_main;
    }

    public String getPhoto_max_orig() {
        return photo_max_orig;
    }

    public int getPolitical() {
        return political;
    }

    public String getQuotes() {
        return quotes;
    }

    public int getRelation() {
        return relation;
    }

    public VKList<VKApiUserFull.Relative> getRelatives() {
        return relatives;
    }

    public String getReligion() {
        return religion;
    }

    public List<School> getSchools() {
        return schools;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public int getSex() {
        return sex;
    }

    public String getSite() {
        return site;
    }

    public String getSkype() {
        return skype;
    }

    public int getSmoking() {
        return smoking;
    }

    public String getTv() {
        return tv;
    }

    public String getTwitter() {
        return twitter;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public int isVerified() {
        return verified;
    }

    public int isWall_comments() {
        return wall_comments;
    }

    public int isWall_default_owner() {
        return wall_default_owner;
    }

    public String getId() {
        return id;
    }

    public static class Counters {
        /**
         * Count was not in server response.
         */
        public final static int NO_COUNTER = -1;

        public int albums = NO_COUNTER;
        public int videos = NO_COUNTER;
        public int audios = NO_COUNTER;
        public int notes = NO_COUNTER;
        public int friends = NO_COUNTER;
        public int photos = NO_COUNTER;
        public int groups = NO_COUNTER;
        public int online_friends = NO_COUNTER;
        public int mutual_friends = NO_COUNTER;
        public int user_videos = NO_COUNTER;
        public int followers = NO_COUNTER;
        public int subscriptions = NO_COUNTER;
        public int pages = NO_COUNTER;

        public Counters() {
        }

        public int getAlbums() {
            return albums;
        }

        public int getAudios() {
            return audios;
        }

        public int getFollowers() {
            return followers;
        }

        public int getFriends() {
            return friends;
        }

        public int getGroups() {
            return groups;
        }

        public int getMutual_friends() {
            return mutual_friends;
        }

        public static int getNoCounter() {
            return NO_COUNTER;
        }

        public int getNotes() {
            return notes;
        }

        public int getOnline_friends() {
            return online_friends;
        }

        public int getPages() {
            return pages;
        }

        public int getPhotos() {
            return photos;
        }

        public int getSubscriptions() {
            return subscriptions;
        }

        public int getUser_videos() {
            return user_videos;
        }

        public int getVideos() {
            return videos;
        }
    }

    public static class City {

        /**
         * City ID.
         */
        public int id;

        /**
         * City name
         */
        public String title;

        public City() {

        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }
    }

    @SuppressWarnings("unused")
    public  static class Country {

        /**
         * Country ID.
         */
        public int id;

        /**
         * Country name
         */
        public String title;

        public Country() {
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }
    }

    public static class University {

        /**
         * University ID, positive number
         */
        public int id;

        /**
         * ID of the country the university is located in, positive number
         */
        public int country_id;

        /**
         * ID of the city the university is located in, positive number
         */
        public int city_id;

        /**
         * University name
         */
        public String name;

        /**
         * Faculty ID
         */
        public String faculty;

        /**
         * Faculty name
         */
        public String faculty_name;

        /**
         * University chair ID;
         */
        public int chair;

        /**
         * Chair name
         */
        public String chair_name;

        /**
         * Graduation year
         */
        public int graduation;

        /**
         * Form of education
         */
        public String education_form;

        /**
         * Status of education
         */
        public String education_status;

        public University() {
        }

        public int getChair() {
            return chair;
        }

        public String getChair_name() {
            return chair_name;
        }

        public int getCity_id() {
            return city_id;
        }

        public int getCountry_id() {
            return country_id;
        }

        public String getEducation_form() {
            return education_form;
        }

        public String getEducation_status() {
            return education_status;
        }

        public String getFaculty() {
            return faculty;
        }

        public String getFaculty_name() {
            return faculty_name;
        }

        public int getGraduation() {
            return graduation;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class School {
        /**
         * School ID, positive number
         */
        public int id;

        /**
         * ID of the country the school is located in, positive number
         */
        public int country_id;

        /**
         * ID of the city the school is located in, positive number
         */
        public int city_id;

        /**
         * School name
         */
        public String name;

        /**
         * Year the user started to study
         */
        public int year_from;

        /**
         * Year the user finished to study
         */
        public int year_to;

        /**
         * Graduation year
         */
        public int year_graduated;


        public String photo_big;

        /**
         * School class letter
         */
        public String clazz;

        /**
         * Speciality
         */
        public String speciality;

        public School() {
        }

        public int getCity_id() {
            return city_id;
        }

        public String getClazz() {
            return clazz;
        }

        public int getCountry_id() {
            return country_id;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSpeciality() {
            return speciality;
        }

        public int getYear_from() {
            return year_from;
        }

        public int getYear_graduated() {
            return year_graduated;
        }

        public int getYear_to() {
            return year_to;
        }
    }

    public static class LastSeen {
        public long time;

        public LastSeen() {

        }

        public long getTime() {
            return time;
        }
    }
}