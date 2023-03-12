package totalacesso.pojos;

import lombok.Data;

import java.util.Date;

@Data
public class Iten{
    public String category;
    public int productId;
    public int productStatusId;
    public int sessionId;
    public int sectorId;
    public int discountId;
    public String discountName;
    public String discountCategory;
    public String productName;
    public String productDescription;
    public Date sessionStartDate;
    public double convenienceFee;
    public double price;
    public int limitSales;
    public Object priceDescription;
    public boolean isPackage;
    public boolean isPromotional;
    public Object couponCode;
    public Object packageComposition;
}