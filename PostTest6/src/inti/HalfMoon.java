package inti;

public class HalfMoon extends Ikan {
    private String BentukEkor;

    public HalfMoon(int idIkan, int stokIkan, String namaIkan, String BentukEkor, double hargaIkan) {
    super(idIkan, stokIkan, namaIkan, hargaIkan);
    this.BentukEkor = BentukEkor; 
    }

    public String getBentukEkor() {
        return BentukEkor;
    }

    public void setBentukEkor(String BentukEkor) {
        this.BentukEkor = BentukEkor;
    }

    @Override
    public void display() {
        System.out.println("ID Ikan     : " + this.getIdIkan());
        System.out.println("Nama Ikan   : " + this.getNamaIkan());
        System.out.println("Bentuk Ekor : " + this.BentukEkor);
        System.out.println("Stok Ikan   : " + this.getStokIkan());
        System.out.println("Harga Ikan  : " + this.HargaIkan);
    }

    public void display(int num) {
        System.out.println("Ikan ke     : " + num);
        System.out.println("ID Ikan     : " + this.getIdIkan());
        System.out.println("Nama Ikan   : " + this.getNamaIkan());
        System.out.println("Bentuk Ekor : " + this.BentukEkor);
        System.out.println("Stok Ikan   : " + this.getStokIkan());
        System.out.println("Harga Ikan  : " + this.HargaIkan);
    }
}
