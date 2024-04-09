public class BerechnungRotationsperiode{
    // ye steht für den x-Wert, der aus WinJupos für die Position des Sonnenflecks am ersten Tag ausgelesen wurde
    // ze steht für den y-Wert, der aus WinJupos für die Position des Sonnenflecks am ersten Tag ausgelesen wurde
    // bne steht für den Neigungswinkel der Sonne am ersten Tag
    // yz steht für den x-Wert, der aus WinJupos für die Position des Sonnenflecks am zweiten Tag ausgelesen wurde
    // zz steht für den y-Wert, der aus WinJupos für die Position des Sonnenflecks am zweiten Tag ausgelesen wurde
    // bnz steht für den Neigungswinkel der Sonne am zweiten Tag
    // t gibt die Dauer des Beobachtunszeitraums an
    BerechnungRotationsperiode(double ye, double ze, double yz, double zz){
        // Die Neigungswinkel der Sonne an den beiden Tagen werden in Bogenmaß umgerechnet
        
        double bne = 3.84;
        double bnz = 3.94;
        double t = 24;
        
        bne = bne/180 * Math.PI;
        bnz = bnz/180 * Math.PI;
        
        // die fehlenden x-Koordinaten werden ermittelt
        double xe = Math.sqrt(1-(ye*ye)-(ze*ze));
        double xz = Math.sqrt(1-(yz*yz)-(zz*zz));
        
        // Die x-Koordinaten werden zur Kontrolle ausgegeben
        System.out.println("x_eins: " + xe);
        System.out.println("x_zwei: " + xz); 
        
        //Die x-Koordinaten werden in neue x-Koordinaten umgewandelt unter Einbeziehung des Neigungswinkels
        double xes = xe * Math.cos(bne) - ze * Math.sin(bne);
        double xzs = xz * Math.cos(bnz) - zz * Math.sin(bnz);
        
        //Die z-Koordinaten werden in neue z-Koordinaten umgewandelt unter Einbeziehung des Neigungswinkels
        double zes = ze * Math.cos(bne) + xe * Math.sin(bne);
        double zzs = zz * Math.cos(bnz) + xz * Math.sin(bnz);
        
        // Die x- und z-Koordinaten werden zur Kontrolle ausgegeben
        System.out.println("x_strich_eins: " + xes);
        System.out.println("x_strich_zwei: " + xzs);
        System.out.println("z_strich_eins: " + zes);
        System.out.println("z_strich_zwei: " + zzs);
        
        // Die Längengrade der Sonnenflecken werden berechnet und von Bogenmaß in Grad umgerechnet
        double le = (Math.atan(ye/xes))/Math.PI * 180;
        double lz = (Math.atan(yz/xzs))/Math.PI * 180;
        
        // Die Breitengrade der Sonnenflecken werden berechnet und von Bogenmaß in Grad umgerechnet
        double be = (Math.asin(zes))/Math.PI * 180;
        double bz = (Math.asin(zzs))/Math.PI * 180;
        
        // Die Längen und Breitengrade werden zur Kontrolle ausgegeben
        System.out.println("L_eins: " + le + "°");
        System.out.println("L_zwei: " + lz + "°");
        System.out.println("B_eins: " + be + "°");
        System.out.println("B_zwei: " + bz + "°");
        
        // Die Differenz der Längengrade wird ermittelt
        double dl = le - lz;
        
        // Die Differenz der Längengrde wird zur Kontrolle ausgegeben
        System.out.println("delta_L:" + dl + "°");
        
        // Die Rotationsperiode wird in Stunden berechnet
        double th = t/dl * 360;
        
        // Die Rotationsperiode wird in Tage umgerechnet
        double td = Math.abs(th/24);
        
        // Die Rotationsperiode wird ausgegeben
        System.out.println("Rotationsperiode: " + td + " Tage");
    }
}
