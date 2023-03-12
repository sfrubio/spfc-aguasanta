package totalacesso.pojos;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ProductGroup{
    public String name;
    public ArrayList<Iten> itens;
}