public class EvenementEcole {
    private String UID;
    private String dateDebut;
    private String dateFin;
    private String type;
    private String title;
    private String teacher;
    private String groupConcerned;
    private String location;

    // region Getters and setters

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getGroupConcerned() {
        return groupConcerned;
    }

    public void setGroupConcerned(String groupConcerned) {
        this.groupConcerned = groupConcerned;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    // endregion


    @Override
    public String toString() {
        return "EvenementEcole{" +
                "UID='" + UID + '\'' +
                ", dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", teacher='" + teacher + '\'' +
                ", groupConcerned='" + groupConcerned + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}