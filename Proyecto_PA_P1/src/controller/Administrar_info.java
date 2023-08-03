package controller;

import java.util.List;
import java.util.ArrayList;

import model.Cliente;
import model.Empleado;
import model.Producto;
import model.Proveedor;
import model.Vendedor;
import model.clienteDAO;
import model.Administrador;
import model.Bodeguero;
import model.Horarios;
import model.empleadoDAO;
import model.horariosDAO;
import model.productoDAO;
import model.proveedorDAO;

public class Administrar_info {

	protected static List <Empleado> empleados = new ArrayList <Empleado>();
	public static List <Cliente> clientes = new ArrayList <Cliente>();
	public static List <Producto> productos = new ArrayList <Producto>();
	public static List <Producto> productos_vendidos = new ArrayList <Producto>();
	public static List <Proveedor> proveedores = new ArrayList <Proveedor>();
	public static List <Horarios> horarios = new ArrayList <Horarios>();
	public static List <String> credenciales = new ArrayList <String>();
	public static int contador=1;
	public static String codigo = "ST0";
	public static empleadoDAO edao = new empleadoDAO();
	public static proveedorDAO pdao = new proveedorDAO();
	public static productoDAO prodao = new productoDAO();
	public static horariosDAO hdao = new horariosDAO();
	public static clienteDAO cdao = new clienteDAO();

	/**
	 * Este método se encarga de cargar la información de los 
	 * distintos archivos a los ArrayList, facilitando el manejo de información.
	 */

	public static void getInfo()
	{
		Administrar_info.empleados = Administrar_info.edao.listEmpleados();
		Administrar_info.productos = Administrar_info.prodao.listProductos();
		Administrar_info.proveedores = Administrar_info.pdao.listProveedores();
		Administrar_info.horarios = Administrar_info.hdao.listHorarios();
		Administrar_info.clientes = Administrar_info.cdao.listClientes();
		Administrar_info.credenciales = Administrar_info.edao.listCredenciales();
	}

	public static void resetArrayList()
	{
		empleados.clear();
		clientes.clear();
		productos.clear();
		proveedores.clear();
		clientes.clear();
		credenciales.clear();
	}
}
