package totalacesso.pojos;

import lombok.Data;

@Data
public class Section{
    public int id;
    public int sectorId;
    public String name;
    public String numberingPattern;
    public boolean isNumberingReverse;
}