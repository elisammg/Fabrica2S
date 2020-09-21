package com.proyecto.fabrica.controller;



import com.proyecto.fabrica.consumeAPI.NetCliente;
import com.proyecto.fabrica.interfaceService.IClienteService;
import com.proyecto.fabrica.interfaceService.IPedidosService;
import com.proyecto.fabrica.interfaceService.IProductosService;
import com.proyecto.fabrica.modelo.Clientes;
import com.proyecto.fabrica.modelo.Pedidos;
import com.proyecto.fabrica.modelo.Productos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Controller
@RequestMapping
public class ControllerPedidos {

    @Autowired
    private IPedidosService service;
    @Autowired
    private IProductosService serviceRepuestos;
    @Autowired
    private IClienteService serviceClientes;

    @GetMapping("/pedidos")
    public String listar(Model model)
    {
        List<Pedidos> pedidos=service.listar();
        model.addAttribute("pedidos", pedidos);
        return "pedidos";
    }

    //Url para consultar los pedidos de los clientes (listado de clientes)
    @GetMapping("/pedidos/cliente/{id}")
    public String listarporcliente(@PathVariable String id,Model model)
    {
        List<Pedidos> pedidos=service.listar();
        for (int i = pedidos.size()-1; i >= 0; i--) {
            Pedidos pedido = pedidos.get(i);
            if (!id.equals(pedido.getClientes())) {
                pedidos.remove(pedido);
            } else {
                if (pedido.getVisto()==0) {
                    pedido.setVisto(1);
                    service.save(pedido);
                } else {
                    pedidos.remove(pedido);
                }
            }
        }
        //template pedidosporcliente
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("idcliente", id);
        return "pedidosporcliente";
    }

    @GetMapping("/pedidodetalle/{id}")
    public String listardetalle(@PathVariable String id, Model modelo)
    {
        Optional<Pedidos> pedidos=service.listarId(id);
        modelo.addAttribute("pedidos", pedidos);
        return "pedidodetalle";
    }

    @GetMapping("/pedidonuevo")
    public String agregar(Model modelo){
        modelo.addAttribute("pedidos", new Pedidos());
        //productos disponibles
        List<Productos> productos=serviceRepuestos.listar();
        modelo.addAttribute("lrepuestos", productos);
        //clientes
        List<Clientes>clientes=serviceClientes.listar();
        modelo.addAttribute("lclientes", clientes);
        return "pedidonuevo";
    }

    @PostMapping("/savepedido")
    public String save(@Valid Pedidos pe, Model model){
        service.save(pe);
        return "redirect:/pedidos";

    }

    //Consumir API para guardar pedidos
    @GetMapping("/solicitudes/{id}")
    public String solicitudes(Model modelo, @PathVariable String id) throws JSONException, ParseException
    {
        NetCliente nc = new NetCliente();
        String url = "http://192.168.1.24:";
        String puerto = "8000";
        String urlCliente = url+puerto+ "/restpedidos/";
        String valores = nc.MetodoGet(urlCliente);

        JSONArray json = new JSONArray(valores);


        for (int i = 0; i < json.length(); i++) {
            JSONObject jsonob = json.getJSONObject(i);

            // Url detalle
            String urlOb = url + puerto+"/restdetalle/";

            int codigoPedido = jsonob.getInt("Codigo_Pedido");

            // Recuperando fecha de pedido y calculando fecha de entrega
            String fecha = jsonob.getString("Fecha_Pedido");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaPedido = formatter.parse(fecha);
            Date fechaEntrega = new Date();
            Optional<Clientes> cliente = serviceClientes.listarId(id);
            if (!cliente.isEmpty()) {
                //calculando fecha de entrega
                fechaEntrega.setDate(fechaPedido.getDate()+ cliente.get().getEntrega());
            }
            // *****

            String valoresdetalle = nc.MetodoGet(urlOb);
            JSONArray jsonDetalle = new JSONArray(valoresdetalle);
            // Url detalle
            for (int j = 0; j < jsonDetalle.length(); j++) {
                JSONObject jsonObDetalle = jsonDetalle.getJSONObject(j);
                //Recuperacion de clave foranea de pedido para recuperar los detalles
                String Pedidofk = jsonObDetalle.getString("Pedidofk");
                Pedidofk = Pedidofk.substring(37,Pedidofk.length()-1);
                int pedidofk = Integer.parseInt(Pedidofk);
                if (pedidofk == codigoPedido) {
                    String codigoRepuesto = jsonObDetalle.getString("Productos");
                    // Calculando sub total
                    int cantidadRepuesto = jsonObDetalle.getInt("Cantidad");
                    Optional<Productos> repuesto = serviceRepuestos.listarId(codigoRepuesto);
                    int subTotal = 0;
                    if (!repuesto.isEmpty()) {
                        subTotal = cantidadRepuesto * repuesto.get().getPrecio();
                    }
                    //Nuevo pedido para guardar en la bd
                    Pedidos pedido2 = new Pedidos();
                    //Creando llave única
                    pedido2.setId("1"+codigoPedido+i+j+id);
                    pedido2.setFecha_recibido(fechaPedido);
                    pedido2.setFecha_entrega(fechaEntrega);
                    pedido2.setClientes(id);
                    ArrayList<String> repuestos = new ArrayList<>();
                    repuestos.add(codigoRepuesto);
                    pedido2.setEstado("Pendiente");
                    pedido2.setRepuestos(repuestos);
                    pedido2.setCantidad(cantidadRepuesto);
                    pedido2.setPrecio_final(subTotal);
                    pedido2.setIdventas(codigoPedido + "");
                    pedido2.setVisto(0);
                    service.save(pedido2);
                }
            }
        }
        return "redirect:/pedidos";
    }

    @GetMapping("/editarpedido/{id}")
    public String editar(@PathVariable String id, Model modelo)
    {
        Optional<Pedidos> pedidos=service.listarId(id);
        modelo.addAttribute("pedidos", pedidos);
        
        List<Productos> productos=serviceRepuestos.listar();
        modelo.addAttribute("lrepuestos", productos);
        List<Clientes>clientes=serviceClientes.listar();
        modelo.addAttribute("lclientes", clientes);
        return "pedidonuevo";
    }

    @GetMapping("/eliminarpedido/{id}")
    public String delete(Model modelo, @PathVariable String id)
    {
        service.delete(id);
        return "redirect:/pedidos";
    }

}
