package inti;

public class Plakat extends Ikan {
    private String WarnaIkan;

    public Plakat(int idIkan, int stokIkan, String namaIkan, String WarnaIkan, double hargaIkan) {
        super(idIkan, stokIkan, namaIkan, hargaIkan);
        this.WarnaIkan = WarnaIkan; 
    }

    public String getWarnaIkan() {
        return WarnaIkan;
    }

    public void setWarnaIkan(String WarnaIkan) {
        this.WarnaIkan = WarnaIkan;
    }

    @Override
    public void display() {
        System.out.println("ID Ikan    : " + this.getIdIkan());
        System.out.println("Nama Ikan  : " + this.getNamaIkan());
        System.out.println("Warna Ikan : " + this.WarnaIkan);
        System.out.println("Stok Ikan  : " + this.getStokIkan());
        System.out.println("Harga Ikan : " + this.HargaIkan);
    }

    public void display(int num) {
        System.out.println("Ikan ke    : " + num);
        System.out.println("ID Ikan    : " + this.getIdIkan());
        System.out.println("Nama Ikan  : " + this.getNamaIkan());
        System.out.println("Warna Ikan : " + this.WarnaIkan);
        System.out.println("Stok Ikan  : " + this.getStokIkan());
        System.out.println("Harga Ikan : " + this.HargaIkan);
    }

}

