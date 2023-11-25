package teachers.util;

public enum UserType {
    STUDENT("Student"),USER("User"),PROFESSOR("Professor");

    private final String translation;

    private UserType(String translation) {
        this.translation=translation;
    }

    public String getTranslation(){
        return translation;
    }
}
