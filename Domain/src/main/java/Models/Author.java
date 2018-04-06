package Models;

public class Author {
    private String name;
    private String lastName;
    private String birthPlace;
    private Long authorID;

    public Author() {
    }

    private Author(AuthorBuilder authorBuilder) {
        this.name = authorBuilder.name;
        this.lastName = authorBuilder.lastName;
        this.birthPlace = authorBuilder.birthPlace;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Long getAuthorID() {
        return authorID;
    }

    public static class AuthorBuilder{
        private String name;
        private String lastName;
        private String birthPlace;


        public AuthorBuilder(String name, String lastName, String birthPlace) {
            this.name = name;
            this.lastName = lastName;
            this.birthPlace = birthPlace;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setBirthPlace(String birthPlace) {
            this.birthPlace = birthPlace;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

        public String getBirthPlace() {
            return birthPlace;
        }

        public Author build(){
            return new Author(this);
        }

    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", authorID=" + authorID +
                '}';
    }
}
