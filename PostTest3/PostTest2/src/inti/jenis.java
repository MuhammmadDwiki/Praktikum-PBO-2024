package inti;

public class jenis extends Ikan{
    private String JenisIkan;

    public jenis (int idIkan, int stokIkan, String namaIkan, String jenisIkan, double hargaIkan) {
        super(idIkan, stokIkan, namaIkan, hargaIkan);
        this.JenisIkan = jenisIkan; 
    }

    public String getJenisIkan() {
        return JenisIkan;
    }

    public void setJenisIkan(String JenisIkan) {
        this.JenisIkan = JenisIkan;
    }
}
