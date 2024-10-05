package Model;

public class Supplier {

    private String Company, Supplier_Name, Title, Address, Email, Website, Bank, Branch, Holder;
    private int Mobile, Landline, Fax, Acc;
    private Double Opening_Amount, Limit_Amount;

    public Supplier() {
    }

    public Supplier(String Company, String Supplier_Name, String Title, String Address, int Mobile, int Landline, int Fax, String Email, String Website, String Bank, String Branch, int Acc, String Holder, Double Opening_Amount, Double Limit_Amount) {
        this.Company = Company;
        this.Supplier_Name = Supplier_Name;
        this.Title = Title;
        this.Address = Address;
        this.Mobile = Mobile;
        this.Landline = Landline;
        this.Fax = Fax;
        this.Email = Email;
        this.Website = Website;
        this.Bank = Bank;
        this.Branch = Branch;
        this.Acc = Acc;
        this.Holder = Holder;
        this.Opening_Amount = Opening_Amount;
        this.Limit_Amount = Limit_Amount;    
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getSupplier_Name() {
        return Supplier_Name;
    }

    public void setSupplier_Name(String Supplier_Name) {
        this.Supplier_Name = Supplier_Name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String Website) {
        this.Website = Website;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String Bank) {
        this.Bank = Bank;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String Branch) {
        this.Branch = Branch;
    }

    public String getHolder() {
        return Holder;
    }

    public void setHolder(String Holder) {
        this.Holder = Holder;
    }

    public int getMobile() {
        return Mobile;
    }

    public void setMobile(int Mobile) {
        this.Mobile = Mobile;
    }

    public int getLandline() {
        return Landline;
    }

    public void setLandline(int Landline) {
        this.Landline = Landline;
    }

    public int getFax() {
        return Fax;
    }

    public void setFax(int Fax) {
        this.Fax = Fax;
    }

    public int getAcc() {
        return Acc;
    }

    public void setAcc(int Acc) {
        this.Acc = Acc;
    }

    public Double getOpening_Amount() {
        return Opening_Amount;
    }

    public void setOpening_Amount(Double Opening_Amount) {
        this.Opening_Amount = Opening_Amount;
    }

    public Double getLimit_Amount() {
        return Limit_Amount;
    }

    public void setLimit_Amount(Double Limit_Amount) {
        this.Limit_Amount = Limit_Amount;
    }

}
