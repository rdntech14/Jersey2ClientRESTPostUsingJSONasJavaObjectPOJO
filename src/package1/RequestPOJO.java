package package1;

import java.util.Arrays;

public class RequestPOJO
{

	private int id;
	private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private String[] courses;
    

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }
    
    public String getFirstName ()
    {
        return firstName;
    }

    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName ()
    {
        return lastName;
    }

    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getProgramme ()
    {
        return programme;
    }

    public void setProgramme (String programme)
    {
        this.programme = programme;
    }
   

    public String[] getCourses ()
    {
        return courses;
    }

    public void setCourses (String[] courses)
    {
        this.courses = courses;
    }

	@Override
	public String toString() {
		return "MyPOJO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", programme=" + programme + ", courses=" + Arrays.toString(courses) + "]";
	}

   
}
