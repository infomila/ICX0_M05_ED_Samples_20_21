
package net.iesmila.ED.UF2.capsa_blanca;


public class TheIncredibleMachine {

    private int stage = 0;

    public int crunch( int [] data ) {
        int i=0;
        int stage0count=0;
        int stage1stats[] = {0,0,0,0,0,0,0,0,0,0};
        int stage2magicnumber = 13;
        while(stage<3 && i<data.length) {
            if(data[i]>9 || data[i]<0) continue;
            switch (stage){
                case 0:
                    if(i>0 && data[i]==data[i-1]) {
                        stage0count++;
                    } else {
                        stage0count=0;
                    }
                    if(stage0count>4) {
                        stage++;
                    }
                    break;
                case 1:
                    stage1stats[data[i]]++;
                    int numGreaterThanThree = 0;
                    for(int k=0;k<stage1stats.length;k++) {
                        if(stage1stats[k]>3) numGreaterThanThree++;
                    }
                    if(numGreaterThanThree>2){
                        stage++;
                    }
                    break;
                case 2:
                    i += data[i];
                    stage2magicnumber -= data[i];
                    if(stage2magicnumber==0) {
                        stage++;
                    }
                    break;
                } // end switch
                //
                i++;
            } // end while
        if(stage==3) {
            System.out.print("Awesome dude !");
        }
        return stage;
    }
}
