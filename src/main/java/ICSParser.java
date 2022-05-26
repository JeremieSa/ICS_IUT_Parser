import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ICSParser {
    private final String filePath;

    public ICSParser(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
    }

    public List<EvenementEcole> getEvenementEcole() throws IOException {
        // BufferedReader initialisation
        BufferedReader bufferedReader = initialiseBufferedReader();
        List<EvenementEcole> evenementEcoleList = new ArrayList<>();

        // Parse file using buffer
        EvenementEcole tmpEvent = new EvenementEcole();
        for(String line : bufferedReader.lines().toList()) {
            if(line.contains("DTSTART"))
                tmpEvent.setDateDebut(FormatTranslation.getDate(line));
            else if(line.contains("DTEND"))
                tmpEvent.setDateFin(FormatTranslation.getDate(line));
            else if(line.contains("UID"))
                tmpEvent.setUID(FormatTranslation.getUID(line));
            else if(line.contains("SUMMARY")) {
                tmpEvent.setType(FormatTranslation.getType(line));
                tmpEvent.setTitle(FormatTranslation.getTitle(line));
                tmpEvent.setGroupConcerned(FormatTranslation.getGroupConcerned(line));
                tmpEvent.setTeacher(FormatTranslation.getTeacher(line));
            }
            else if(line.contains("LOCATION"))
                tmpEvent.setLocation(FormatTranslation.getLocation(line));
            else if(line.contains("END:VEVENT")) {
                evenementEcoleList.add(tmpEvent);
                tmpEvent = new EvenementEcole();
            }
        }

        bufferedReader.close();
        return evenementEcoleList;
    }

    private BufferedReader initialiseBufferedReader() {
        if(fileExist()) {
            try {
                // Take car of accents with ISO 8859 1
                return new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(filePath), StandardCharsets.ISO_8859_1));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

    public boolean fileExist() {
        return new File(filePath).exists();
    }
}
