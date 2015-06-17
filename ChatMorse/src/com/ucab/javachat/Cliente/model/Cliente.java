/*
 * Cliente.java
 *
 * Created on 21 de marzo de 2008, 12:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.ucab.javachat.Cliente.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

import com.google.gson.Gson;

import com.ucab.javachat.Cliente.controller.ControladorCliente;

/**
 * Modelo del cliente que utiliza el chat. Crea la comunicar mediante sockets con el sevidor.
 *
 * @authors Grupo 3 - A. Rodriguez, I. Teixeira, L. Valladares, D. Suarez
 * @version 2.0
 */
public class Cliente{
   public static String IP_SERVER;
   ControladorCliente vent;
   DataInputStream entrada = null;
   DataOutputStream salida = null;
   DataInputStream entrada2 = null;
   Socket comunication = null;//para la comunicacion
   Socket comunication2 = null;//para recivir msg
   
   /** 
    * Creates a new instance of Cliente.
    */
   public Cliente(ControladorCliente vent) throws IOException
   {      
      this.vent = vent;
   }
   
   /**
    * 
    * @param nombre
    * @param clave
    * @throws IOException
    */
   public void conexion(String nombre, String clave) throws IOException {
	   try {
		   comunication = new Socket(Cliente.IP_SERVER, 8081); //envia
		   comunication2 = new Socket(Cliente.IP_SERVER, 8082); //recibe
		   entrada = new DataInputStream(comunication.getInputStream()); // envia al cliente
		   salida = new DataOutputStream(comunication.getOutputStream()); // envia al cliente
		   entrada2 = new DataInputStream(comunication2.getInputStream());
		   vent.setLabelUser();
		   salida.writeUTF(nombre);
		   salida.writeUTF(clave);
	   } catch (IOException e) {
		   System.out.println("\tEl servidor no esta levantado");
		   System.out.println("\t=============================");
	   }
	   new threadCliente(entrada2, vent).start();
   }
   
   public String getNombre(){
      return vent.getUsuario();
   }
   
   /**
    * Este metodo al ser invocado se encarga de enviar la lista de todos los usarios conectados.
    * @return Vector con los usuarios conectados.
    */
   public Vector<String> pedirUsuarios(){
      Vector<String> users = new Vector<String>();
      try {         
         salida.writeInt(2);
         int numUsers=entrada.readInt();
         for(int i=0;i<numUsers;i++)
            users.add(entrada.readUTF());
      } catch (Exception ex) {
         ex.getMessage();
      }
      return users;
   }
   
   /**
    * Este metodo envia un mensaje a todos los usuarios que estan en una ventana grupal y privada.
    * @param amigos - Usuarios en la ventana privada.
    * @param mens - Mensaje a enviar.
    */
   public void flujo(Vector<String> amigos,String mens) { /*flujo para mensaje privado*/
	  Gson gson = new Gson();
      try {             
         System.out.println("el mensaje enviado desde el cliente es :" + mens);
         salida.writeInt(3); //opcion de mensaje a amigo
         salida.writeUTF(mens);
         String jsonamigos = gson.toJson(amigos);
         salida.writeUTF(jsonamigos);
      } catch (IOException e) {
         System.out.println("error...." + e);
      }
   }
   
   /**
    * Este metodo se encarga de enviar una instancia del objeto usuario al servidor, para esto
    * se crea un objeto json en el que se añaden los datos del usuario.
    * @param usuario - Objeto que contiene los datos de un usuario que esta en el proceso de registro.
    */
   public void flujo(Usuario usuario) { 			
		  Gson gson = new Gson();
	      try {             
	         salida.writeInt(4);
	         String jsonRegistroUsuario = gson.toJson(usuario);
	         salida.writeUTF(jsonRegistroUsuario);
	      } catch (IOException e) {
	         System.out.println("error...." + e);
	      }
	   }
   
}