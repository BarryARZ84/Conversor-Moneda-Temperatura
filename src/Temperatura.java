public class Temperatura {
    private double temperatura;

    public Temperatura(double temperatura){
        this.temperatura=temperatura;
    }

    public double celciusAfahrenheit(){
        return (this.temperatura * 1.8) + 32;
    }

    public double celciusAkelvin(){
        return this.temperatura + 273.15;
    }

    public double fahrenheitAcelcius(){
        return (this.temperatura - 32)/1.8;
    }

    public double fahrenheitAkelvin(){
        return ((this.temperatura - 32) / 1.8) + 273.15;
    }

    public double KelvinAcelcius(){
        return this.temperatura - 273.15;
    }

    public double Kelvinfahrenheit(){
        return ((this.temperatura - 273.15) * 1.8) +32;
    }
}
