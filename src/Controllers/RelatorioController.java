/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.RelatorioDAO;
import Models.ItemPedido;
import Models.Pedido;
import Models.Relatorio;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author patrick.chagas
 */
public class RelatorioController {

//    public static ArrayList<Relatorio> consultar(String DataInicio, String DataFinal) {
//        return RelatorioDAO.getProdutos(DataInicio, DataFinal);
//    }
    
        public static ArrayList<String[]> getProduto(String DataInicio, String DataFinal) throws ParseException {
        ArrayList<Pedido> Pedidos = RelatorioDAO.getProdutos(DataInicio, DataFinal);
        ArrayList<String[]> listaProdutos = new ArrayList<>();
        
   
        for (int i = 0; i < Pedidos.size(); i++) {
            listaProdutos.add(new String[]{ String.valueOf(Pedidos.get(i).getPedidoId()),
                String.valueOf(Pedidos.get(i).getCodCli()),
                String.valueOf(Pedidos.get(i).getData()),
                String.valueOf(Pedidos.get(i).getTotal()),
            });
        }

        return listaProdutos;

    }
        
        
        public static ArrayList<String[]> getitemPedido(int idPedido) throws ParseException {
        ArrayList<ItemPedido> itemPedido = RelatorioDAO.getitemPedido(idPedido);
        ArrayList<String[]> listaProdutos = new ArrayList<>();
        
   
        for (int i = 0; i < itemPedido.size(); i++) {
            listaProdutos.add(new String[]{ String.valueOf(itemPedido.get(i).getIdPedido()),
                String.valueOf(itemPedido.get(i).getIdProduto()),
                String.valueOf(itemPedido.get(i).getNomeCli()),
                String.valueOf(itemPedido.get(i).getQtdItem()),
                String.valueOf(itemPedido.get(i).getValorItem()).replaceAll("\\.", ","),
            });
        }

        return listaProdutos;

    }

}
