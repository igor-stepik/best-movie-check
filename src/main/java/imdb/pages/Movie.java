package imdb.pages;

public class Movie {
        String year;
        String name;
        String rating;

        public String getYear() {
            return year;
        }

        public String getName() {
            return name;

        }

        public String getRating() {
            return rating;
        }

        public Movie(String name, String rating, String year) {
            this.year = year;
            this.name = name;
            this.rating = rating;
        }
    }

