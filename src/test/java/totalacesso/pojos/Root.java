package totalacesso.pojos;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Root{
    public Event event;
    public ArrayList<ProductGroup> productGroups;
}
