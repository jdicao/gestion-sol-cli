package tec.msw.gestsol.gestionsolcli.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.msw.gestsol.gestionsolcli.entity.PlanCliente;
import tec.msw.gestsol.gestionsolcli.entity.ProyectoCliente;
import tec.msw.gestsol.gestionsolcli.repository.PlanClienteRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanClienteServiceImpl implements PlanClienteService{

    @Autowired
    private PlanClienteRepository planClienteRepository;

    @Override
    public List<PlanCliente> listAllPlanesClientes() {
        return planClienteRepository.findAll();
    }

    @Override
    public PlanCliente getPlaCliente(Long id) {
        return planClienteRepository.findById(id).orElse(null);
    }

    @Override
    public PlanCliente createPlanCliente(PlanCliente plan_cliente) {
        plan_cliente.setFecha_contratacion(new Date());
        return planClienteRepository.save(plan_cliente);
    }

    @Override
    public PlanCliente updatePlanCliente(PlanCliente plan_cliente) {
        PlanCliente plan_clienteDB = getPlaCliente(plan_cliente.getId_plan());
        if (plan_clienteDB == null){
            return null;
        }
        plan_clienteDB.setDescripcion(plan_cliente.getDescripcion());
        plan_clienteDB.setFecha_fin(plan_cliente.getFecha_fin());
        plan_clienteDB.setValor_hora(plan_cliente.getValor_hora());
        return planClienteRepository.save(plan_clienteDB);
    }

    @Override
    public String detelePlanCliente(Long id) {
        PlanCliente plan_clienteDB = getPlaCliente(id);
        if (plan_clienteDB == null){
            return "No existe el plan del ciente enviado.";
        }
        planClienteRepository.delete(plan_clienteDB);
        return "Plan de cliente eliinado correctamente.";
    }

   @Override
    public List<PlanCliente> findByProyectoCliente(ProyectoCliente proyecto_cliente) {
        return planClienteRepository.findByProyectoCliente(proyecto_cliente);
    }

    @Override
    public PlanCliente updateHorasConsumidas(Long id, Double horas) {
        PlanCliente plan_cliente = getPlaCliente(id);
        if (plan_cliente == null){
            return null;
        }
        plan_cliente.setHoras_consumidas(plan_cliente.getHoras_consumidas() + horas);
        plan_cliente.setUltimo_consumo(new Date());

        return planClienteRepository.save(plan_cliente);
    }
}
