/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi.impl;
import chatrmi.remote.InterfaceChat;
import chatrmi.remote.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author lheredia
 */
public class RemoteImpl extends UnicastRemoteObject implements InterfaceChat {
    String username;
    //List <User> listUser = new ArrayList<User>();
    List <String> listUser = new ArrayList<>();
    List <Message> listMessages = new ArrayList<>();
    public RemoteImpl() throws RemoteException{
        super();
    }
    @Override
    public String isLoginValid(String username) throws RemoteException{
        username =  username.toLowerCase();
        if(!listUser.contains(username)){
            listUser.add(username);
            this.username = username;
            return "OK";
        }
        else
            return "Usuario ya registrado";
    }

    @Override
    public String getUsername() throws Exception {
        return this.username;
    }

    public void setUsername() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void send(Message  msg) throws RemoteException {
                  
        System.out.println(msg.getUser() + ": " + msg.getMessage());
        listMessages.add(msg);
        //sendAll(message);
        //return msg;
    }

    @Override
    public String receive() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendAll(Message msg) throws RemoteException {
        
    }

    @Override
    public List<Message> getMessage() throws RemoteException {
        return listMessages;
    }

    @Override
    public void setUsername(String oldName, String newName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getStatus(String msg) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getUsers() throws RemoteException {
        return this.listUser;
    }

    @Override
    public void logOut(String username) throws Exception {
        listUser.remove(username);
    }
    
}
