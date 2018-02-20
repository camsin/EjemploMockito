/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Usuario {
    
    private String username;
     
    private String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    /**
     * Metodo que verifica si el username y password sean correctos. (Login)
     * @param username username del usuario
     * @param password pass del usuario
     * @return true si el login es correcto, false si es incorrecto.
     */
    public static Boolean login(String username, String password){
        if(username.equals("ararat")){
            if(password.equals("1234")){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    /**
     * Metodo que nos indica si el usuario es baneado.
     * @param numIntentos el numero de intento en el que va el login.
     * @param username username del usuario.
     * @param password password del usuario.
     * @return true si esta baneado, false si no esta baneado.
     */
    public static Boolean baneado(Integer numIntentos, String username, String password){
        //Condicional llamando el metodo de login.
        if(!login(username, password)){
            System.out.println("Login incorrecto");
            //Si el numero de intento es mayor a tres el usuario es banneado.
            if(numIntentos > 3){
                System.out.println("Estas banneado");
                return true;
            }else{
                return false;
            }
        }else{
            System.out.println("Login Correcto");
        return false;
        }
        

        
    }
}
