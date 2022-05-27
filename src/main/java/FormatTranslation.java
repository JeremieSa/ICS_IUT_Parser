public abstract class FormatTranslation {

    private FormatTranslation(){}

    public static String getUID(String uidLine) {
        // UID:CELCAT - 2022 (967636-40)
        return uidLine.substring(
                uidLine.indexOf(':') + 1
        );
    }

    public static String getDate(String dateLine) {
        // Format : DD/MM/YYYY - HH:MM
        String dateNotFormatted =
                dateLine.substring(
                    dateLine.indexOf(':') + 1,
                    dateLine.length()-1 // Exclude Z char at the end
                );

        return dateNotFormatted.substring(4, 6) + "/"
                + dateNotFormatted.substring(6, 8) + "/"
                + dateNotFormatted.substring(0, 4) + " - "
                + dateNotFormatted.substring(9, 11) + ":"
                + dateNotFormatted.substring(11, 13);
    }

    public static String getType(String summaryLine) {
        // Specific case
        if(summaryLine.contains("XXX"))
            return "XXX";

        return summaryLine.substring(
                summaryLine.indexOf(':') + 1,
                summaryLine.indexOf('-') - 1
        );
    }

    public static String getTitle(String summaryLine) {
        // Specific case
        if(summaryLine.contains("XXX"))
            return "Other";

        return summaryLine.substring(
                summaryLine.indexOf('-') + 2,
                summaryLine.indexOf('\\')
        );
    }

    public static String getTeacher(String summaryLine) {
        // Specific case
        if(summaryLine.contains("XXX"))
            return null;

        return summaryLine.substring(
                summaryLine.lastIndexOf(',') + 2
        );
    }

    public static String getGroupConcerned(String summaryLine) {
        // Specific case
        if(summaryLine.contains("XXX"))
            return null;

        if(summaryLine.indexOf(',') == -1) return null;
        String group =
                summaryLine.substring(
                        summaryLine.indexOf(',') + 2
                );

        if(group.indexOf('\\') == -1) return null;
        group =
                group.substring(
                        0,
                        group.indexOf('\\')
                );

        return group;
    }

    public static String getLocation(String locationLine) {
        return locationLine.substring(
                locationLine.indexOf(':') + 1
        );
    }
}
