public class Main {
     public static void main(String[] args) {

        SmartLamp lampu = new SmartLamp("Philips",20);

        SmartCCTV cctv = new SmartCCTV("Xiaomi",50);

        SmartSpeaker speaker = new SmartSpeaker("Google Nest",30);



        System.out.println("=== SMART LAMP ===");
        lampu.cekFungsi();
        lampu.infoPower();
        lampu.prosesPerintah("Mati");

        System.out.println("\n=== SMART CCTV ===");
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWiFi();

        System.out.println("\n=== SMART SPEAKER ===");
        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWiFi();
        speaker.prosesPerintah("PLAY");


    }
}
