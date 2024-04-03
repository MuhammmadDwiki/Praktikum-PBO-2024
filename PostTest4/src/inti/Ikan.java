package inti;

public class Ikan {
    private int IdIkan;
    private int StokIkan;
    private String NamaIkan;
    double HargaIkan;

    public Ikan(int idIkan, int stokIkan, String namaIkan, double hargaIkan) {
        this.IdIkan = idIkan;
        this.NamaIkan = namaIkan;
        this.StokIkan = stokIkan; 
        this.HargaIkan = hargaIkan;
    }

    public int getIdIkan() {
        return IdIkan;
    }
    public String getNamaIkan() {
        return NamaIkan;
    }
    public int getStokIkan() {
        return StokIkan;
    }
    public double getHargaIkan() {
        return HargaIkan;
    }

    public void setIdIkan(int IdIkan) {
        this.IdIkan = IdIkan;
    }
    public void setNamaIkan(String NamaIkan) {
        this.NamaIkan = NamaIkan;
    }  
    public void setStokIkan(int StokIkan) {
        this.StokIkan = StokIkan;
    }
    public void setHargaIkan(double HargaIkan) {
        this.HargaIkan = HargaIkan;
    }

    public void display() {
        System.out.println("ID Ikan    : " + this.IdIkan);
        System.out.println("Nama Ikan  : " + this.NamaIkan);
        System.out.println("Stok Ikan  : " + this.StokIkan);
        System.out.println("Harga Ikan : " + this.HargaIkan);
    }
}