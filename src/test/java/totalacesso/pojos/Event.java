package totalacesso.pojos;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Event{
    public int eventId;
    public int statusId;
    public int companyId;
    public String name;
    public String subTitle;
    public String classification;
    public Date startDate;
    public Date endDate;
    public String arena;
    public String location;
    public Object headerImageUrl;
    public Object mapImageUrl;
    public Object logoEventUrl;
    public String friendlyUrl;
    public Object promoCodeLabel;
    public String period;
    public String useTerms;
    public Object packageLabel;
    public boolean showPreviousProductPriceInfo;
    public boolean hasFlowHalfPrice;
    public boolean useMarkedPlace;
    public Object tuPpSponsorText;
    public Object mktActivationSponsorText;
    public ArrayList<Session> sessions;
}
