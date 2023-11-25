package user.utils;

public enum UserType {
    STUDENT("Student"), USER("User"), PROFESSOR("Professor");

    private String translation;

    private UserType(String translation) {
        this.translation = translation;
    }

    public String getTranslation(){
        return this.translation;
    }




}
