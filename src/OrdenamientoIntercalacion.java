import java.io.*;

public class OrdenamientoIntercalacion{

	/*public static int[] array(int[] numeros, int[] numeros2) {
		
		int arrayOrdenado[] = new int[numeros.length+numeros2.length];
		
		int i,k,j;

		for(i=j=k=0; i<numeros.length && j<numeros2.length; k++){

			if(numeros[i]<numeros2[j]) {
				arrayOrdenado[k] = numeros[i];
				i++;
			}else {
				arrayOrdenado[k] = numeros2[j];
				j++;
			}

		}

		for(;i<numeros.length; i++,k++) {
			arrayOrdenado[k] = numeros[i];
		}

		for(;j<numeros2.length; j++,k++) {
			arrayOrdenado[k] = numeros2[j];
		}

		return arrayOrdenado;
	}*/


    public static int[] array(int[] numeros, int[] numeros2) {
		
    	int arrayOrdenado[] = new int[numeros.length+numeros2.length];
		
    	int i=0, j=0, k=0;
    	
    	while(i<numeros.length && j<numeros2.length) {
    		if(numeros[i]<numeros2[j]) {
    			arrayOrdenado[k] = numeros[i];
    			i++;
    		}else {
    			arrayOrdenado[k] = numeros2[j];
    			j++;
    		}
    		k++;
    	}
    	
    	while(i<numeros.length) {
    		arrayOrdenado[k] = numeros[i];
			i++;
			k++;
    	}
    	
        while(j<numeros2.length) {
        	arrayOrdenado[k] = numeros2[j];
			j++;
			k++;
    	}
    	
    	return arrayOrdenado;
    	
	}

    
    public static String archivoIterativo(String autos1, String autos2, String db) {
		
    	File a1 = new File(autos1);
		File a2 = new File(autos2);
		
		if(a1.length()+a2.length()==0) {
			return "Ambos archivos deben de tener elementos";
		}else if(a1.length()==0 || a2.length()==0) {
			return "Ambos archivos deben de tener elementos";
		}else {
    	
    	    ObjectInputStream ois = null;
    	    ObjectInputStream ois2 = null;
    	    ObjectOutputStream oos = null;
    	
		    try {
			
			    ois = new ObjectInputStream(new FileInputStream(autos1));
			    ois2 = new ObjectInputStream(new FileInputStream(autos2));
			    oos = new ObjectOutputStream(new FileOutputStream(db));

			    int errorArchivo = 0;
			    Auto obj = (Auto)ois.readObject();
			    Auto obj2 = (Auto)ois2.readObject();
			    int año = obj.getAño();
			    int año2 = obj2.getAño();

			    while(errorArchivo==0) {

				    if(año<=año2) {
					
					    try {
						
					    	oos.writeObject(obj);
					        obj = ((Auto)ois.readObject());
					        año = obj.getAño();
					    
				        }catch (EOFException | ClassNotFoundException e) {
				    	    errorArchivo = 1;
					    }
					
				    }else {
					
					    try {

					    	oos.writeObject(obj2);
						    obj2 = ((Auto)ois2.readObject());
					        año2 = obj2.getAño();
					    
				        }catch (EOFException | ClassNotFoundException e) {
					        errorArchivo = 2;
				        }
					
				    }
			    }


			    while(true) {
				
				    try {
					
					    if(errorArchivo==2) {
					    	oos.writeObject(obj);
						    obj = ((Auto)ois.readObject());
					    }else{
					    	oos.writeObject(obj2);
						    obj2 = ((Auto)ois2.readObject());
					    }
					
			        }catch (EOFException | ClassNotFoundException e) {
				        break;
			        }
			    }


		    } catch (FileNotFoundException e) {
			    e.printStackTrace();
		    } catch (IOException e) {
			    e.printStackTrace();
		    } catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} finally {
			    try {
				    ois.close();
				    ois2.close();
			    } catch (IOException e) {
				    e.printStackTrace();
			    }
		    }

		}
    	
	    return "La base de datos se ha cargadado    :)";
	}
	

    public static void imprimir(String ruta) {
    	
    	File a = new File(ruta);
    	
    	if(a.length()!=0) {
    		ObjectInputStream ois = null;
    		
    	    try {
    		
    		    ois = new ObjectInputStream(new FileInputStream(ruta));


    		    while(true) {
    			
    			    try {
    				
    				    System.out.println(ois.readObject());
    				
    		        }catch (EOFException | ClassNotFoundException e) {
    			        break;
    		        }
    			
    		    }


    	    } catch (FileNotFoundException e) {
    		    e.printStackTrace();
    	    } catch (IOException e) {
    		    e.printStackTrace();
    	    } finally {
    		    try {
    			    ois.close();
    		    } catch (IOException e) {
    			    e.printStackTrace();
    		    }
    	    }
    	}	
    }
    
    
    public static String archivoRecursivo(String autos1, String autos2, String db) {
		
    	File a1 = new File(autos1);
		File a2 = new File(autos2);
		
		if(a1.length()+a2.length()==0) {
			return "Ambos archivos deben de tener elementos";
		}else if(a1.length()==0 || a2.length()==0) {
			return "Ambos archivos deben de tener elementos";
		}else {
    	
    	    ObjectInputStream ois = null;
    	    ObjectInputStream ois2 = null;
    	    ObjectOutputStream oos = null;
    	
		    try {
			
			    ois = new ObjectInputStream(new FileInputStream(autos1));
			    ois2 = new ObjectInputStream(new FileInputStream(autos2));
			    oos = new ObjectOutputStream(new FileOutputStream(db));

			    int errorArchivo = 0;
			    Auto obj = (Auto)ois.readObject();
			    Auto obj2 = (Auto)ois2.readObject();
			    int año = obj.getAño();
			    int año2 = obj2.getAño();
			    
			    agregar(obj, obj2, año, año2, errorArchivo, oos, ois2, ois);


		    } catch (FileNotFoundException e) {
			    e.printStackTrace();
		    } catch (IOException e) {
			    e.printStackTrace();
		    } catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} finally {
			    try {
				    ois.close();
				    ois2.close();
				    oos.close();
			    } catch (IOException e) {
				    e.printStackTrace();
			    }
		    }

		}
    	
	    return "La base de datos se ha cargadado    :)";
	}
    
    
    public static void agregar(Auto obj, Auto obj2, int año, int año2, int errorArchivo,
        	ObjectOutputStream oos, ObjectInputStream ois2, ObjectInputStream ois) throws IOException {
        	
        	if(errorArchivo==0) {

    		    if(año<=año2) {
    			
    			    try {
    				
    			    	oos.writeObject(obj);
    			        obj = ((Auto)ois.readObject());
    			        agregar(obj, obj2, obj.getAño(), año2, errorArchivo, oos, ois2, ois);
    			    
    		        }catch (EOFException | ClassNotFoundException e) {
    		        	// errorArchivo es 1
    		        	agregar(obj, obj2, obj.getAño(), año2, 1, oos, ois2, ois);
    			    }
    			
    		    }else {
    			
    			    try {

    			    	oos.writeObject(obj2);
    				    obj2 = ((Auto)ois2.readObject());
    			        agregar(obj, obj2, año, obj.getAño(), errorArchivo, oos, ois2, ois);
    			    
    		        }catch (EOFException | ClassNotFoundException e) {
    		        	// errorArchivo es 2
    		        	agregar(obj, obj2, obj.getAño(), año2, 2, oos, ois2, ois);
    		        }
    			
    		    }
    	    }else{
    			
    		    try {
    			
    			    if(errorArchivo==2) {
    			    	oos.writeObject(obj);
    				    obj = ((Auto)ois.readObject());
    				    agregar(obj, obj2, año, año2, errorArchivo, oos, ois2, ois);
    			    }else{
    			    	oos.writeObject(obj2);
    				    obj2 = ((Auto)ois2.readObject());
    				    agregar(obj, obj2, año, año2, errorArchivo, oos, ois2, ois);
    			    }
    			
    	        }catch (EOFException | ClassNotFoundException e) {
    		        
    	        }
    	    }
        }
}
