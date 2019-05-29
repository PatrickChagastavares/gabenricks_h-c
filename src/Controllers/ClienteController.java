/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ClienteDAO;
import Models.Cliente;
import java.util.ArrayList;

/**
 *
 * @author HOLANDAS
 */
public class ClienteController {

    //Salva com todas as informações preenchidas
    public static boolean salvar(int clienteId, String nome, int cpf,
            int telefone, int codFidelidade, String email,
            String endereco, String infoComplementar) {
        
        Cliente c = new Cliente(clienteId, nome, cpf, telefone, codFidelidade, email, endereco, infoComplementar);
        return ClienteDAO.salvar(c);
        
    }
//    // A partir deste a complexidade para salvar um cliente diminui
//    public static boolean salvar(String nome, int cpf, int telefone, int codFidelidade, String email, String endereco){
//        Cliente c = new Cliente(nome, cpf, telefone, codFidelidade, email, endereco);
//        return ClienteDAO.salvar(c);
//    }
//    public static boolean salvar(String nome, int cpf, int telefone, int codFidelidade, String email){
//        Cliente c = new Cliente(nome, cpf, telefone, codFidelidade, email);
//        return ClienteDAO.salvar(c);
//    }
//    public static boolean salvar(String nome, int cpf, int telefone, int codFidelidade){
//        Cliente c = new Cliente(nome, cpf, telefone, codFidelidade);
//        return ClienteDAO.salvar(c);
//    }
//    // Esta é a regra minima para cadastrar um cliente
//    public static boolean salvar(String nome, int cpf, int telefone){
//        Cliente c = new Cliente(nome, cpf, telefone);
//        return ClienteDAO.salvar(c);
//    }

    public static boolean excluir(int clienteId) {
        return ClienteDAO.excluir(clienteId);
    }

    public static ArrayList<Cliente> consultar(int cpf) {
        return ClienteDAO.consultar(cpf);
    }

    public static ArrayList<Cliente> consultar(String nome) {
        return ClienteDAO.consultar(nome);
    }

    public static ArrayList<String[]> getClientes() {
        ArrayList<Cliente> clientes = ClienteDAO.getClientes();
        ArrayList<String[]> listaClientes = new ArrayList<>();

        for (int i = 0; i < clientes.size(); i++) {
            listaClientes.add(new String[]{String.valueOf(clientes.get(i).getClienteId()),
                clientes.get(i).getNome(),
                String.valueOf(clientes.get(i).getCpf()),
                String.valueOf(clientes.get(i).getTelefone()),
                String.valueOf(clientes.get(i).getCodFidelidade()),
                clientes.get(i).getEmail(),
                clientes.get(i).getEndereco(),
                clientes.get(i).getInfoComplementar()});

        }

        return listaClientes;

    }

}
