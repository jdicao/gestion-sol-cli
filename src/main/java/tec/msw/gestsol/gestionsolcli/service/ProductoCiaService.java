package tec.msw.gestsol.gestionsolcli.service;

import tec.msw.gestsol.gestionsolcli.entity.ProductoCia;

import java.util.List;

public interface ProductoCiaService {
    public List<ProductoCia> listAllProductosCia();
    public ProductoCia getProductoCia(Long id);
    public ProductoCia createProductoCia(ProductoCia producto_cia);
    public ProductoCia updateProductoCia(ProductoCia producto_cia);
    public String deleteProductoCia(Long id);

}
