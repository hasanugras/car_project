public enum BasincDeger {
    DUSUK,
    ORTA,
    YUKSEK;


    public static BasincDeger basincaGore(int basinc) {
        if(basinc < 28) return DUSUK;
        if(basinc <= 33) return ORTA;
        return YUKSEK;
    }

    // non-static metod: enum nesnesine ait açıklama
    public String aciklama() {
        switch(this) {
            case DUSUK: return "Düşük";
            case ORTA: return "Orta";
            case YUKSEK: return "Yüksek";
        }
        return "";
    }
}
