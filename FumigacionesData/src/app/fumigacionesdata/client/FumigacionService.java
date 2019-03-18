package app.fumigacionesdata.client;

import java.util.ArrayList;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("fumigacion")
public interface FumigacionService extends RemoteService {
  
  public ArrayList<Fumigacion> buscarFumigacion();
  public ArrayList<Cliente> buscarClientes();
  public Integer buscarContador();
  public Map<Integer, Integer[]> buscarHtasStock();
  
  public void finHtasStock(Map<Integer, Integer[]> htas);
  public void finContador(Integer cont);
  public void finFumStock(ArrayList<Fumigacion> fum);
  public void finClienteStock(ArrayList<Cliente> clientes);
}