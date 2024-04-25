import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner teclado1=new Scanner(System.in);
        Scanner teclado2=new Scanner(System.in);

        APIConvertidor c=new APIConvertidor();

        int opcion=0;
        double monto=0;
        String base="";
        String fin="";

        System.out.println("=========================================\n");
        System.out.println("Bienvenidos al conversor de divisas alura!!");
        System.out.println("=========================================\n");

        String menu= """
                Seleccione el tipo de conversion que desea realizar!!
                1.-Convertir de USD (dolares) => a MXN (peso Mexicanos).
                2.-Convertir de ARS (peso Argentino) => a USD (dolares).
                3.-Convertir de USD (dolares) => a BOB (peso Boliviano).
                4.-Convertir de BOB (peso Boliviano) => a USD (dolares).
                5.-Convertir de USD (dolares) => a COP (peso Colombiano).
                6.-Convertir de COP (peso colombiano) => a USD (dolares).
                7.-Convertir a otro tipo de denominación.
                8.- Historial de conversion.
                9.- Salir.
                """;
        String menu2= """
                Divisas disponibles para convertir. Recuerde solo ingresas las 3 Letras mayusculas
                
                AFN - Afganistán.              BOB - Bolivia.                   COP - Colombia.
                ALL - Albania.                 BRL - Brasil.                    MXN - Pesos Méxicanos.
                DZD - Argelia.                 CAD - Canadá.
                USD - Dolar Americano.         KYD - Islas Caimán.
                EUR - Andorra.                 CLP - Chile (Peso chileno).
                AUD - Australia.               CNY - China.
                """;
        try{
            do {
                System.out.println(menu);
                opcion=teclado1.nextInt();

                switch (opcion){
                    case 1:
                        System.out.println("Ingrese el monto de USD a convertir");
                        monto = teclado2.nextDouble();
                        base = "USD";
                        fin = "MXN";
                        var res=c.cambiarMoneda(base,fin,monto);
                        System.out.println("ingreso :"+monto+" USD equivalen a: "+res+" MXN");
                        break;
                    case 2:
                        System.out.println("Ingrese el monto ARS a convertir");
                        monto = teclado2.nextDouble();
                        base = "ARS";
                        fin = "USD";
                        System.out.println("ingreso :"+monto+" ARS equivalen a: "+c.cambiarMoneda(base,fin,monto)+" USD");
                        break;
                    case 3:
                        System.out.println("Ingrese el monto a convertir");
                        monto = teclado2.nextDouble();
                        base = "USD";
                        fin = "BOB";
                        System.out.println("ingreso :"+monto+" USD equivalen a: "+c.cambiarMoneda(base,fin,monto)+" BOB");
                        break;
                    case 4:
                        System.out.println("Ingrese el monto a convertir");
                        monto = teclado2.nextDouble();
                        base = "BOB";
                        fin = "USD";
                        System.out.println("ingreso :"+monto+" BOB equivalen a: "+c.cambiarMoneda(base,fin,monto)+" USD");
                        break;
                    case 5:
                        System.out.println("Ingrese el monto a convertir");
                        monto = teclado2.nextDouble();
                        base = "USD";
                        fin = "COP";
                        System.out.println("ingreso :"+monto+" USD equivalen a: "+c.cambiarMoneda(base,fin,monto)+" COP");
                        break;
                    case 6:
                        System.out.println("Ingrese el monto a convertir");
                        monto = teclado2.nextDouble();
                        base = "COP";
                        fin = "USD";
                        System.out.println("ingreso :"+monto+" COP equivalen a: "+c.cambiarMoneda(base,fin,monto)+" USD");
                        break;
                    case 7:
                        Scanner ing=new Scanner(System.in);
                        System.out.println(menu2);
                        System.out.println("Ingrese las tres letras de su moneda principal (Ej. USD)\n");
                        String monBase= ing.nextLine();
                        System.out.println("Ingrese las tres letras de su moneda a convertir (Ej. MXN)\n");
                        String mondestino= teclado2.nextLine();
                        System.out.println("Monto a convertir\n");
                        double cantidad=teclado1.nextDouble();
                        var dinero=c.cambiarMoneda(monBase,mondestino,cantidad);
                        System.out.println("Usted Ingreso "+cantidad+" "+monBase+" y equivale a "+dinero+" "+mondestino);
                        break;
                    case 8:
                        System.out.println("Historial de conversion....");
                        break;
                }

            }while(opcion!=9);
            System.out.println("Gracias por usar el convertidor de Divisas, hasta pronto..");
        } catch (NumberFormatException e) {
            System.out.println("Ingrese solo numeros del 1 al 9 a la hora de seleccionar el menu");
        }
    }
}
