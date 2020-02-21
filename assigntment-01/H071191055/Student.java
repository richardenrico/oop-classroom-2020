import java.util.Map;
import java.util.Random;

class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private int registerYear;
    private String faculty;
    private String department;
    private String major;

    public String getId() {
        return id;
    }
    public void setId(Map <String, String> facultyMap, Map <String, String> majorMap) {
        Random r = new Random();
        int randomNumber = r.nextInt(061);
        String newId = facultyMap.get(getFaculty()) + majorMap.get(getMajor()) + 1 + String.valueOf(registerYear).substring(2, 4) + 1 + String.format("%03d", randomNumber);
        this.id = newId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(Map <String,String> facultyMap) {
        String[] name = getfullName().split(" ");
        String name_2 = "";
        for (int i = 0 ; i < name.length-1 ; i++) {
            int j = 0;
            name_2 = name_2 + name[i].charAt(j);
        }
        String fixEmail = name[name.length-1].toLowerCase() + name_2.toLowerCase() + String.valueOf(registerYear).substring(2, 4) + facultyMap.get(getFaculty()).toLowerCase() + "@student.unhas.ac.id";
        this.email = fixEmail;
    }

    public void setRegisterYear(int registerYear) {
        this.registerYear = registerYear;
    }

    public String getFaculty() {
        return faculty;
    }
    public String getDepartment() {
        return department;
    }
    public String getMajor() {
        return major;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    public String getfullName() {
        String fullName = firstName.toLowerCase() + " " + lastName.toLowerCase();
        String fixName = "";
        for (int i = 0 ; i < fullName.length() ; i++) {
            if (i == 0 || fullName.codePointBefore(i) == 32) {
                fixName = fixName + ((char)(fullName.codePointAt(i) -32));
            }else {
                fixName += fullName.charAt(i);
            }
        }
        return fixName.toString();
    }
    public void description() {
        System.out.printf("Nama \t\t: %s\n", getfullName());
        System.out.printf("NIM \t\t: %s\n", getId());
        System.out.printf("Email Mahasiswa : %s\n", getEmail());
        System.out.printf("Fakultas \t: %s\n", getFaculty());
        System.out.printf("Departemen \t: %s\n", getDepartment());
        System.out.printf("Program Studi \t: %s\n", getMajor());
        System.out.println();
    }
}