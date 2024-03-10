package inti;

public class Ikan {
    int IdIkan, StokIkan;
    String NamaIkan, JenisIkan;
    double HargaIkan;

    public Ikan(int idIkan, int stokIkan, String namaIkan, String jenisIkan, double hargaIkan) {
        this.IdIkan = idIkan;
        this.NamaIkan = namaIkan;
        this.JenisIkan = jenisIkan;
        this.StokIkan = stokIkan; 
        this.HargaIkan = hargaIkan;
    }

    public int getIdIkan() {
        return IdIkan;
    }
    public String getNamaIkan() {
        return NamaIkan;
    }
    public String getJenisIkan() {
        return JenisIkan;
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
    public void setJenisIkan(String JenisIkan) {
        this.JenisIkan = JenisIkan;
    }
    public void setStokIkan(int StokIkan) {
        this.StokIkan = StokIkan;
    }
    public void setHargaIkan(double HargaIkan) {
        this.HargaIkan = HargaIkan;
    }
    


    public void tampil() {
        System.out.println("ID Ikan : " + this.IdIkan);
        System.out.println("Nama Ikan : " + this.NamaIkan);
        System.out.println("Jenis Ikan : " + this.JenisIkan); 
        System.out.println("Stok Ikan : " + this.StokIkan);
        System.out.println("Harga Ikan : " + this.HargaIkan);
    }
}
