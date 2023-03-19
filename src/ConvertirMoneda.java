import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ConvertirMoneda {
    public static ArrayList<Moneda> monedas;
    public static String operador = "";
    static Object opcion;


    public static void main(String[] args) {
        
        monedas = new ArrayList<>();
        monedas.add(new Moneda("DOLAR", 18.98));
        monedas.add(new Moneda("EURO", 20.34));
        monedas.add(new Moneda("YEN", 0.14));
        monedas.add(new Moneda("LIBRA", 23.02));

        primeraSeleccion();

        
   
    }

    public static void primeraSeleccion(){
        String [] conversor = {"Converso de Moneda", "Conversor de Temperatura"};
        
        muestraDialogo("Selecciona una opcion de conversion","Elegir",conversor);
        
        
        if (opcion.toString().equalsIgnoreCase("Converso de Moneda")){
            seleccionConvercionMoneda();
        }else{
            seleccionConvercionTemperatura();
        }
    }

    private static void seleccionConvercionTemperatura() {
        String[] convercionesTemperaturas={"De Celsius A Fahrenheit","De Celsius a Kelvin", "De Fahrenheit a Celsius", "De Fahrenheit a Kelvin", "De Kelvin a Celsius", "De Kelvin a Fahrenheit"};
        muestraDialogo("Selecciona una opcion de conversion","Elegir",convercionesTemperaturas);
        try{
            double valorTemp = Double.parseDouble(JOptionPane.showInputDialog("Introduce la Temperatura a convertir:"));
            double valorconv=0;
            Temperatura temperatura = new Temperatura(valorTemp);
           
            switch (opcion.toString()){
                case "De Celsius A Fahrenheit":
                    valorconv = temperatura.celciusAfahrenheit();
                    break;

                case "De Celsius a Kelvin":    
                    valorconv = temperatura.celciusAkelvin();
                    break;

                case "De Fahrenheit a Celsius":    
                    valorconv = temperatura.fahrenheitAcelcius();
                    break;
                
                case "De Fahrenheit a Kelvin":
                    valorconv = temperatura.fahrenheitAkelvin();
                    break;

                case "De Kelvin a Celsius":
                    valorconv = temperatura.KelvinAcelcius();
                    break;

                case "De Kelvin a Fahrenheit":
                    valorconv = temperatura.Kelvinfahrenheit();
                    break;
            }
            JOptionPane.showMessageDialog(null,  "el valor convertido es: "+ valorconv);
            reiniciarFinalizar();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se indico un valor numerico valido vuelva a intentarlo");
            seleccionConvercionTemperatura();
        }

    }

    private static void seleccionConvercionMoneda() {

        String[] opciones = {"De pesos a Moneda Extranjera", "De Moneda Extrajera a pesos"};
        
        muestraDialogo("Elige el tipo de convercion","Moneda",opciones);
        
        if(opcion.toString() == "De pesos a Moneda Extranjera" ){
            operador="/";
        }else{
            operador="*";
        }   

        mostrarlistamoneda();
    }

    public static void mostrarlistamoneda(){
        List<String> listMoneda = new ArrayList<>();
        for(int i=0; i<monedas.size(); i++){
            listMoneda.add(monedas.get(i).getmoneda().toString()); 
        }

        String[] arryMoneda = new String[listMoneda.size()];
        arryMoneda = listMoneda.toArray(arryMoneda);

        muestraDialogo("Elige la moneda a la cual convertir tu Dinero","Moneda",arryMoneda);
        convertir();
        
    }

    public static void convertir(){
        for (Moneda valor : monedas) {
            if(valor.getmoneda()==opcion.toString())
            {
                try{
                    double importe = Double.parseDouble(JOptionPane.showInputDialog("Introduce el Valor a convertir:"));
                    if (operador=="/"){
                        JOptionPane.showMessageDialog(null,  "el valor es: "+ String.format("%.2f",  (importe/valor.getValorMoneda())));
                    }else{
                        JOptionPane.showMessageDialog(null,  "el valor es: "+ String.format("%.2f", (importe*valor.getValorMoneda())));
                        
                    }
                    reiniciarFinalizar();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"No se indico un valor numerico valido vuelva a intentarlo");
                    convertir();
                }
                

                
                 
            }
        }
    }

    public static void muestraDialogo(String mensaje, String titulo, String[] arreglo){
        opcion = JOptionPane.showInputDialog(null,
        mensaje, titulo,
        JOptionPane.QUESTION_MESSAGE,null,arreglo, arreglo[0]);
    }

    public static void reiniciarFinalizar()
    {
        int msn = JOptionPane.showConfirmDialog(null, "Desea Continuar en el programa");
        if (msn==JOptionPane.YES_OPTION){
            primeraSeleccion();
        }
        else{
            JOptionPane.showMessageDialog(null,  "Programa Finalizado");
        }
    }
       
}
