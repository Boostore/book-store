package model;

public class User 
{
   private String fnam, lnam, eml, cont, db, pss, upass, uname, bnam, bwri;
   private int bpri;
   
    public String getFnam() {
        return fnam;
    }
    public void setFnam(String fnam) {
        this.fnam = fnam;
    }
    public String getLnam() {
        return lnam;
    }
    public void setLnam(String lnam) {
        this.lnam = lnam;
    }   
    public String getEml() {
        return eml;
    }
    public void setEml(String eml) {
        this.eml = eml;
    }
    public String getCont() {
        return cont;
    }
    public void setCont(String cont) {
        this.cont = cont;
    }
    public String getDB() {
        return db;
    }
    public void setDB(String db) {
        this.db = db;
    }
    public String getPss() {
        return pss;
    }
    public void setPss(String pss) {
        this.pss = pss;
    }
    public String getUpass() {
        return upass;
    }
    public void setUpass(String upass) {
        this.upass = upass;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getBnam() {
        return bnam;
    }
    public void setBnam(String bnam) {
        this.bnam = bnam;
    }
    public String getBwri() {
        return bwri;
    }
    public void setBwri(String bwri) {
        this.bwri = bwri;
    }
    public int getBpri() {
        return bpri;
    }
    public void setBpri(int bpri) {
        this.bpri = bpri;
    }

    @Override
    public String toString() {
        return "User{" + " fname=" + fnam + ", lname=" + lnam + ", email=" + eml + ", contact=" + cont + ", dob=" + db + ", passw" + pss + ", confpass=" + upass + ", username=" + uname + ", bname" + bnam + ", bwrit" + bwri + ", bpris" + bpri + "}";
    }
}
