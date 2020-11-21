import java.util.Arrays;
import java.io.Serializable;

class Auto implements Serializable{
	
	private String nombreAuto;
	private String marca;
	private int año;

	public Auto(String nombreAuto, String marca, int año) {
		super();
		this.nombreAuto = nombreAuto;
		this.marca = marca;
		this.año = año;
	}

	public int getAño() {
		return año;
	}

	@Override
	public String toString() {
		return "Auto [nombreAuto=" + nombreAuto + ", marca=" + marca + ", año=" + año + "]";
	}
}


public class Prueba {
	
	/*public static void llenar1(String ruta1) {
        ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(ruta1));
			
			oos.writeObject(new Auto("Supra", "Toyota", 1998));
			oos.writeObject(new Auto("Rx7", "Mazda", 2002));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

    public static void llenar2(String ruta2) {
        ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(ruta2));
			
			oos.writeObject(new Auto("Dodge", "Charger", 1997));
			oos.writeObject(new Auto("Eclipse", "Mitsubishi", 1999));
			oos.writeObject(new Auto("Dodge", "challenger", 2006));
			oos.writeObject(new Auto("Lancer evo", "Mitsubishi", 2007));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}*/
	
	
	public static void main(String[] args) {

		// Deben estar previamente ordenados
		int numeros[] = {1, 3, 5, 7, 9};
		int numeros2[] = {2, 4, 6, 8, 10};
		
		System.out.println(Arrays.toString(OrdenamientoIntercalacion.array(numeros, numeros2)));
		
		//-----------------------------------------------
		
		// Rutas
		String ruta1 = "./archivos/autos1.bin";
		String ruta2 = "./archivos/autos2.bin";
		String ruta3 = "./archivos/db.bin";
		
		// llenar1(ruta1);
		// llenar2(ruta2);

		System.out.println(OrdenamientoIntercalacion.archivoIterativo(ruta1, ruta2, ruta3)+"\n");
		
		System.out.println("--------------Autos archivo 1----------------");
		OrdenamientoIntercalacion.imprimir(ruta1);
		System.out.println();
		System.out.println("--------------Autos archivo 2----------------");
	    OrdenamientoIntercalacion.imprimir(ruta2);
	    System.out.println();
	    System.out.println("--------------Autos ordenados por año----------------");
		OrdenamientoIntercalacion.imprimir(ruta3);
		
		System.out.println();
		
		System.out.println(OrdenamientoIntercalacion.archivoRecursivo(ruta1, ruta2, ruta3)+"\n");
		OrdenamientoIntercalacion.imprimir(ruta3);
	}

}
