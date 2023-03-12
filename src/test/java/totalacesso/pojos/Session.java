package totalacesso.pojos;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Session{
    public int configurationArenaId;
    public int sessionId;
    public int eventId;
    public Object description;
    public String customMessage;
    public boolean useDescriptionAsDisplay;
    public boolean haveArtists;
    public Date startDate;
    public Date endDate;
    public Object imageUrl;
    public int statusId;
    public int limitForSale;
    public int capacity;
    public Object artists;
    public ArrayList<Sector> sectors;
}
