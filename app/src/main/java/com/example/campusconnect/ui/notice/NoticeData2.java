package com.example.campusconnect.ui.notice;

public class NoticeData2 {
    public class Event {
        private String title;
        private String image;
        private String date;
        private String time;

        // Default constructor
        public Event() {
        }

        // Parameterized constructor
        public Event(String title, String image, String date, String time) {
            this.title = title;
            this.image = image;
            this.date = date;
            this.time = time;
        }

        // Getter for title
        public String getTitle() {
            return title;
        }

        // Setter for title
        public void setTitle(String title) {
            this.title = title;
        }

        // Getter for image
        public String getImage() {
            return image;
        }

        // Setter for image
        public void setImage(String image) {
            this.image = image;
        }

        // Getter for date
        public String getDate() {
            return date;
        }

        // Setter for date
        public void setDate(String date) {
            this.date = date;
        }

        // Getter for time
        public String getTime() {
            return time;
        }

        // Setter for time
        public void setTime(String time) {
            this.time = time;
        }
    }

}
