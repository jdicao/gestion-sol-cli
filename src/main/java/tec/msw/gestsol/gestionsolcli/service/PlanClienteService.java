package tec.msw.gestsol.gestionsolcli.service;

import tec.msw.gestsol.gestionsolcli.entity.PlanCliente;
import tec.msw.gestsol.gestionsolcli.entity.ProyectoCliente;

import java.util.List;

public interface PlanClienteService {
    public List<PlanCliente> listAllPlanesClientes();
    public PlanCliente getPlaCliente(Long id);
    public PlanCliente createPlanCliente(PlanCliente plan_cliente);
    public PlanCliente updatePlanCliente(PlanCliente plan_cliente);
    public String detelePlanCliente(Long id);
    public List<PlanCliente> findByProyectoCliente(ProyectoCliente proyecto_cliente);

    public PlanCliente updateHorasConsumidas(Long id, Double horas);
}
