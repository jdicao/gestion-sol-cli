package tec.msw.gestsol.gestionsolcli.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.msw.gestsol.gestionsolcli.entity.ProductoCia;
import tec.msw.gestsol.gestionsolcli.repository.ProductoCiaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoCiaServiceImpl implements ProductoCiaService{

    @Autowired
    private ProductoCiaRepository productoCiaRepository;
    @Override
    public List<ProductoCia> listAllProductosCia() {
        return productoCiaRepository.findAll();
    }

    @Override
    public ProductoCia getProductoCia(Long id) {
        return productoCiaRepository.findById(id).orElse(null);
    }

    @Override
    public ProductoCia createProductoCia(ProductoCia producto_cia) {
        return productoCiaRepository.save(producto_cia);
    }

    @Override
    public ProductoCia updateProductoCia(ProductoCia producto_cia) {
        ProductoCia producto_ciaDB = getProductoCia(producto_cia.getId_producto());
        if (producto_ciaDB == null){
            return null;
        }
        producto_ciaDB.setDescripcion(producto_cia.getDescripcion());
        producto_ciaDB.setEstado(producto_cia.getEstado());
        producto_ciaDB.setLogo(producto_cia.getLogo());
        producto_ciaDB.setNombre(producto_cia.getNombre());
        return productoCiaRepository.save(producto_ciaDB);
    }

    @Override
    public String deleteProductoCia(Long id) {
        ProductoCia producto_ciaDB = getProductoCia(id);
        if (producto_ciaDB == null){
            return "No se encontró el producto a eliminar.";
        }
        productoCiaRepository.delete(producto_ciaDB);
        return "Producto eliminado correctamente";
    }
}
