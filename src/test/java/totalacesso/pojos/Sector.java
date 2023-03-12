package totalacesso.pojos;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Sector{
    public int id;
    public int sessionId;
    public String name;
    public String description;
    public boolean isPlaceMarked;
    public int capacity;
    public int statusId;
    public ArrayList<Section> sections;
}
